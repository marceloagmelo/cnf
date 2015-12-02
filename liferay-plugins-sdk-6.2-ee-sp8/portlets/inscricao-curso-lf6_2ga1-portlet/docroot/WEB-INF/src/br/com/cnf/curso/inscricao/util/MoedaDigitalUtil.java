package br.com.cnf.curso.inscricao.util;

import br.com.cnf.curso.inscricao.Constantes;
import br.com.cnf.curso.inscricao.model.CursoInscricao;
import br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj;
import br.com.cnf.curso.inscricao.model.CursoInscricaoCpf;
import br.com.cnf.curso.inscricao.model.PedidoMoedaDigital;
import br.com.cnf.curso.inscricao.model.impl.PedidoMoedaDigitalImpl;
import br.com.cnf.curso.inscricao.service.CursoInscricaoLocalServiceUtil;
import br.com.cnf.curso.inscricao.service.PedidoMoedaDigitalLocalServiceUtil;

import com.liferay.portal.kernel.util.Validator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.tempuri.GatewayLocator;
import org.tempuri.RetornoMeiosPagamento;
import org.tempuri.RetornoParcelas;
import org.tempuri.RetornoPedido;
import org.tempuri.RetornoStatusPagamento;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class MoedaDigitalUtil {

	private static final Log _log = LogFactory
			.getLog(MoedaDigitalUtil.class);
	
	public static RetornoPedido envioCartao(CursoInscricao cursoInscricao, String moedaDigitalToken, String moedaDigitalAplicacao) throws Exception {
		RetornoPedido retornoPedido = new RetornoPedido();
		try {
			String pedidoXML = montaXML(cursoInscricao, moedaDigitalToken, moedaDigitalAplicacao);

			//System.out.println(pedidoXML);
			
			String retornoXML = executar(
					Constantes.MOEDA_DIGITA_URL_INICIAR_PAGAMENTO_DIGITAL_XML,
					pedidoXML);

			//System.out.println(retornoXML);
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(retornoXML));

			Document doc = db.parse(is);
			NodeList nodes = doc.getElementsByTagName(Constantes.NODE_STRING);
			// iterate the employees
			for (int i = 0; i < nodes.getLength(); i++) {
				Element element = (Element) nodes.item(i);

				String retorno = "";
				String mensagem = "";
				NodeList nodeRetorno = element
						.getElementsByTagName(Constantes.NODE_RETORNO);
				if (Validator.isNotNull(nodeRetorno)) {
					Element line = (Element) nodeRetorno.item(0);
					if (Validator.isNotNull(line)) {
						retorno = getCharacterDataFromElement(line);
					}
				}

				NodeList nodeMensagem = element
						.getElementsByTagName(Constantes.NODE_MENSAGEM);
				if (Validator.isNotNull(nodeMensagem)) {
					Element line = (Element) nodeMensagem.item(0);
					if (Validator.isNotNull(line)) {
						mensagem = getCharacterDataFromElement(line);
					}
				}

				NodeList nodeConteudo = element
						.getElementsByTagName(Constantes.NODE_CONTEUDO);
				if (Validator.isNotNull(nodeConteudo)) {
					Element line = (Element) nodeConteudo.item(0);
					if (Validator.isNotNull(line)) {
						retornoPedido.setConteudo(getCharacterDataFromElement(line));
					}
				}

				NodeList nodeStatusPedido = element
						.getElementsByTagName(Constantes.NODE_STATUS_PEDIDO);
				if (Validator.isNotNull(nodeStatusPedido)) {
					Element line = (Element) nodeStatusPedido.item(0);

					if (Validator.isNotNull(line)) {
						// retorno = (
						// Constantes.CARTAO_APROVADO.equals(getCharacterDataFromElement(line))
						// ? Constantes.CARTAO_APROVADO : null);
						retornoPedido.setPedidoStatus(getCharacterDataFromElement(line));
						
						if (Constantes.MOEDA_DIGITAL_NEGADO.equals(retornoPedido.getPedidoStatus())) {
							_log.info("Pedido " + retornoPedido.getPedidoStatus());
							_log.info("Retorno " + retorno);
							_log.info("Mensagem " + mensagem);
						}
					}
				}
			}

			// Grava o pedido a moeda digital no banco
			PedidoMoedaDigital pedidoMoedaDigital = new PedidoMoedaDigitalImpl();
			pedidoMoedaDigital.setDataPedido(new Date());
			pedidoMoedaDigital.setXmlEnvio(pedidoXML);
			pedidoMoedaDigital.setXmlRetorno(retornoXML);
			pedidoMoedaDigital.setInscricaoId(cursoInscricao.getInscricaoId());

			pedidoMoedaDigital = PedidoMoedaDigitalLocalServiceUtil
					.addPedidoMoedaDigital(pedidoMoedaDigital);
			
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return retornoPedido;
	}

	private static String montaXML(CursoInscricao cursoInscricao, String moedaDigitalToken, String moedaDigitalAplicacao)
			throws Exception {

		// Pegar essa informações da tela de inscrição

		String numeroPedido = String.valueOf(cursoInscricao.getInscricaoId());

		String meioPagto = cursoInscricao.getFormaPagamento();

		String valorTotal = Formatter.formatMoney(cursoInscricao.getValorTotal());

		String valorSemJuros = valorTotal;
		
		double vlrParcela = (cursoInscricao.getValorTotal() / cursoInscricao.getQuantidadeParcelas());

		String valorParcela = Formatter.formatMoney(vlrParcela);

		String qtdParcelas = String.valueOf(cursoInscricao.getQuantidadeParcelas());

		String juros = "0";

		// Pegar as demais informações do seu banco de dados / cadastro cliente
		// e Pedido

		String CPF = cursoInscricao.getCpfCnpj();

		String genero = "M";
		if (Constantes.PESSOA_JURIDICA.equals(cursoInscricao
				.getTipoFisicaJuridica())) {
			genero = "J";
		} else {
			genero = "M";//cursoInscricao.getSexo();
		}

		String dataNasc = "";

		// Token de teste, será determinado um exclusivo do CNF.ORG.BR após o
		// cadastro

		String lojaChaveAcesso = moedaDigitalToken;

		// Nome da aplicação, vai aparecer na fatura do cliente.

		String lojaApp = moedaDigitalAplicacao;

		String cliente_IP = "127.0.0.1";

		Date dataAtual = DateUtil.getDataAtual();
		String dataCadastro = Formatter.format(dataAtual, "dd/MM/yyyy", "");
		
		// Recuperar os dados da nota fiscal do participante pela
		// inscrição
		CursoInscricaoCpf cursoInscricaoCpf = InscricaoUtil
				.recuperarInscricaoCpfPorInscricao(String
						.valueOf(cursoInscricao.getInscricaoId()));

		CursoInscricaoCnpj cursoInscricaoCnpj = InscricaoUtil
				.recuperarInscricaoCnpjPorInscricao(String
						.valueOf(cursoInscricao.getInscricaoId()));

		String pedidoXML = "<?xml version=\"1.0\" encoding=\"utf-16\"?>\r\n";

		pedidoXML += "<clsPedido xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\r\n";

		pedidoXML += "<Cliente>\r\n";

		pedidoXML += "<DataCadastro>" + dataCadastro + "</DataCadastro>\r\n";

		if (Constantes.PESSOA_FISICA.equals(cursoInscricao
				.getTipoFisicaJuridica())) {

			String nome = cursoInscricao.getNomeResponsavel();
			int pos = nome.indexOf(" ");
			String primeiroNome = nome.substring(0, pos);
			String restoNome = nome.substring(pos).trim();
			
			pedidoXML += "<Nome>" + primeiroNome
					+ "</Nome>\r\n";

			pedidoXML += "<Sobrenome>" + restoNome + "</Sobrenome>\r\n";

			pedidoXML += "<RazaoSocial></RazaoSocial>\r\n";
		} else {
			pedidoXML += "<Nome></Nome>\r\n";

			pedidoXML += "<Sobrenome></Sobrenome>\r\n";

			pedidoXML += "<RazaoSocial>" + cursoInscricaoCnpj.getRazaoSocial()
					+ "</RazaoSocial>\r\n";
		}

		pedidoXML += "<Genero>" + genero + "</Genero>\r\n";

		pedidoXML += "<CpfCnpj>" + CPF + "</CpfCnpj>\r\n";

		pedidoXML += "<NascAbertura>" + dataNasc + "</NascAbertura>\r\n";

		pedidoXML += "<Login></Login>\r\n";

		pedidoXML += "<Moeda>BRL</Moeda>\r\n";

		pedidoXML += "<Idioma>PT-BR</Idioma>\r\n";

		pedidoXML += "<IpCadastro>" + cliente_IP + "</IpCadastro>\r\n";

		pedidoXML += "<Score></Score>\r\n";

		pedidoXML += "<Notas></Notas>\r\n";

		pedidoXML += "</Cliente>\r\n";

		pedidoXML += "<Endereco1>\r\n";

		if (Constantes.PESSOA_FISICA.equals(cursoInscricao
				.getTipoFisicaJuridica())) {
			pedidoXML += "<Endereco>" + cursoInscricaoCpf.getEndereco()
					+ "</Endereco>\r\n";

			pedidoXML += "<Numero></Numero>\r\n";

			pedidoXML += "<Complemento></Complemento>\r\n";

			pedidoXML += "<Bairro>" + cursoInscricaoCpf.getBairro()
					+ "</Bairro>\r\n";

			pedidoXML += "<Cidade>" + cursoInscricaoCpf.getCidade()
					+ "</Cidade>\r\n";

			pedidoXML += "<UF>" + cursoInscricaoCpf.getEstado() + "</UF>\r\n";

			pedidoXML += "<CEP>" + cursoInscricaoCpf.getCep() + "</CEP> \r\n";

			pedidoXML += "<Pais>" + "BR" + "</Pais>\r\n";

			pedidoXML += "<DDD></DDD>\r\n";

			pedidoXML += "<Telefone>" + "Telefone" + "</Telefone>\r\n";

			pedidoXML += "<Tipo>Entrega</Tipo>\r\n";

			pedidoXML += "</Endereco1>\r\n";

			pedidoXML += "<Endereco2>\r\n";

			pedidoXML += "<Endereco>" + cursoInscricaoCpf.getEndereco()
					+ "</Endereco>\r\n";

			pedidoXML += "<Numero></Numero>\r\n";

			pedidoXML += "<Complemento></Complemento>\r\n";

			pedidoXML += "<Bairro>" + cursoInscricaoCpf.getBairro()
					+ "</Bairro>\r\n";

			pedidoXML += "<Cidade>" + cursoInscricaoCpf.getCidade()
					+ "</Cidade>\r\n";

			pedidoXML += "<UF>" + cursoInscricaoCpf.getEstado() + "</UF>\r\n";

			pedidoXML += "<CEP>" + cursoInscricaoCpf.getCep() + "</CEP>\r\n";

			pedidoXML += "<Pais>" + "BR" + "</Pais>\r\n";

			pedidoXML += "<DDD></DDD>\r\n";

			pedidoXML += "<Telefone>" + cursoInscricaoCpf.getTelefone()
					+ "</Telefone>\r\n";

			pedidoXML += "<Tipo>Cobranca</Tipo>\r\n";

			pedidoXML += "</Endereco2>\r\n";

			pedidoXML += "<Email1>\r\n";

			pedidoXML += "<Email>" + cursoInscricao.getEmailPrincipal()
					+ "</Email>\r\n";

			pedidoXML += "</Email1>\r\n";
		} else {
			pedidoXML += "<Endereco>" + cursoInscricaoCnpj.getEndereco()
					+ "</Endereco>\r\n";

			pedidoXML += "<Numero></Numero>\r\n";

			pedidoXML += "<Complemento></Complemento>\r\n";

			pedidoXML += "<Bairro>" + cursoInscricaoCnpj.getBairro()
					+ "</Bairro>\r\n";

			pedidoXML += "<Cidade>" + cursoInscricaoCnpj.getCidade()
					+ "</Cidade>\r\n";

			pedidoXML += "<UF>" + cursoInscricaoCnpj.getEstado() + "</UF>\r\n";

			pedidoXML += "<CEP>" + cursoInscricaoCnpj.getCep() + "</CEP> \r\n";

			pedidoXML += "<Pais>" + "BR" + "</Pais>\r\n";

			pedidoXML += "<DDD></DDD>\r\n";

			pedidoXML += "<Telefone>" + "Telefone" + "</Telefone>\r\n";

			pedidoXML += "<Tipo>Entrega</Tipo>\r\n";

			pedidoXML += "</Endereco1>\r\n";

			pedidoXML += "<Endereco2>\r\n";

			pedidoXML += "<Endereco>" + cursoInscricaoCnpj.getEndereco()
					+ "</Endereco>\r\n";

			pedidoXML += "<Numero></Numero>\r\n";

			pedidoXML += "<Complemento></Complemento>\r\n";

			pedidoXML += "<Bairro>" + cursoInscricaoCnpj.getBairro()
					+ "</Bairro>\r\n";

			pedidoXML += "<Cidade>" + cursoInscricaoCnpj.getCidade()
					+ "</Cidade>\r\n";

			pedidoXML += "<UF>" + cursoInscricaoCnpj.getEstado() + "</UF>\r\n";

			pedidoXML += "<CEP>" + cursoInscricaoCnpj.getCep() + "</CEP>\r\n";

			pedidoXML += "<Pais>" + "BR" + "</Pais>\r\n";

			pedidoXML += "<DDD></DDD>\r\n";

			pedidoXML += "<Telefone>" + cursoInscricaoCnpj.getTelefone()
					+ "</Telefone>\r\n";

			pedidoXML += "<Tipo>Cobranca</Tipo>\r\n";

			pedidoXML += "</Endereco2>\r\n";

			pedidoXML += "<Email1>\r\n";

			pedidoXML += "<Email>" + cursoInscricao.getEmailPrincipal()
					+ "</Email>\r\n";

			pedidoXML += "</Email1>\r\n";
		}

		pedidoXML += "<LojaChaveAcesso>" + lojaChaveAcesso
				+ "</LojaChaveAcesso>\r\n";

		pedidoXML += "<LojaApp>" + lojaApp + "</LojaApp>\r\n";

		pedidoXML += "<LojaCanal>WEB</LojaCanal>\r\n";

		pedidoXML += "<MeiosdePagamento>" + meioPagto
				+ "</MeiosdePagamento>\r\n";

		pedidoXML += "<PedidoCodigo>" + numeroPedido + "</PedidoCodigo>\r\n";

		pedidoXML += "<PedidoNumeroLoja>" + numeroPedido
				+ "</PedidoNumeroLoja>\r\n";

		pedidoXML += "<PedidoEmissao>" + dataCadastro + "</PedidoEmissao>\r\n";

		pedidoXML += "<PedidoVencimento></PedidoVencimento>\r\n";

		pedidoXML += "<PedidoExpiracao></PedidoExpiracao>\r\n";

		pedidoXML += "<PedidoRecorrente>N</PedidoRecorrente>\r\n";

		pedidoXML += "<PedidoValor>" + valorTotal + "</PedidoValor>\r\n";

		pedidoXML += "<PedidoValorSemJuros>" + valorSemJuros
				+ "</PedidoValorSemJuros>\r\n";

		pedidoXML += "<PedidoMulta>0</PedidoMulta>\r\n";

		pedidoXML += "<PedidoJuros>" + juros + "</PedidoJuros>\r\n";

		pedidoXML += "<PedidoItens>1</PedidoItens>\r\n";

		pedidoXML += "<PedidoParcelas>" + qtdParcelas + "</PedidoParcelas>\r\n";

		pedidoXML += "<PedidoValorParcelas>" + valorParcela
				+ "</PedidoValorParcelas>\r\n";

		pedidoXML += "<PedidoFinanciador>1</PedidoFinanciador>\r\n";

		pedidoXML += "<PedidoInstrucoes></PedidoInstrucoes>\r\n";

		pedidoXML += "<PedidoStatus></PedidoStatus>\r\n";

		pedidoXML += "<PedidoProduto>" + cursoInscricao.getCursoNome()
				+ "</PedidoProduto>\r\n";

		pedidoXML += "<PortadorCartao>" + cursoInscricao.getNumeroCartao()
				+ "</PortadorCartao>\r\n";

		pedidoXML += "<PortadorValidade>"
				+ Helper.zerosEsquerda(String.valueOf(cursoInscricao.getValidadeCartaoMes()), 2) + "/"
				+ Helper.zerosEsquerda(String.valueOf(cursoInscricao.getValidadeCartaoAno()), 2)
				+ "</PortadorValidade>\r\n";

		pedidoXML += "<PortadorCVV>"
				+ cursoInscricao.getCodigoSegurancaCartao()
				+ "</PortadorCVV>\r\n";

		pedidoXML += "<PortadorNome>" + cursoInscricao.getNomeTitularCartao()
				+ "</PortadorNome>\r\n";

		pedidoXML += "</clsPedido>\r\n";

		return pedidoXML;

	}

	private static String executar(String url, String query) throws Exception {

		String postData = "pedidoXML=" + query;

		// Connect

		URL httpURL = new URL(url);

		HttpURLConnection connection = (HttpURLConnection) httpURL
				.openConnection();

		connection.setDoOutput(true);

		connection.setRequestMethod("POST");

		connection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");

		connection.setRequestProperty("Content-Length",
				String.valueOf(postData.length()));

		// Write data

		OutputStream os = connection.getOutputStream();

		os.write(postData.getBytes());

		// Read response

		StringBuilder responseSB = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));

		String line;

		while ((line = br.readLine()) != null)

			responseSB.append(line);

		br.close();

		os.close();

		String result = responseSB.toString();

		result = URLDecoder.decode(result, "UTF-16");

		result = result.replace("&lt;", "<").replace("&gt;", ">");

		return result;

	}

	private static String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		}
		return "?";
	}

	public static List<CursoInscricao> recuperarStatusPedido(
			String statusMoedaDigital) throws Exception {
		List<CursoInscricao> retorno = null;
		try {
			return retorno = CursoInscricaoLocalServiceUtil
					.search(statusMoedaDigital);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return retorno;
	}

	public static List<CursoInscricao> listaPedidoMoedaDigitalPorStatus (String loja, String aplicacao,
			String statusMoedaDigital) throws Exception {
		List<CursoInscricao> retorno = null;
		try {
			retorno = CursoInscricaoLocalServiceUtil.search(statusMoedaDigital);

		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return retorno;
	}
	
	public static String consultarStatusPagamento(String loja, String aplicacao,
			String pedido) throws Exception {
		String retorno = null;
		try {
			GatewayLocator loc = new GatewayLocator();
			
			RetornoStatusPagamento retStatus = loc.getGatewaySoap().consultaStatusPagamento(loja, aplicacao, pedido);
			retorno = retStatus.getStatus();

		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return retorno;
	}

	public static List<RetornoMeiosPagamento> consultarMeiosPagamento(String loja, String aplicacao,
			String meios) throws Exception {
		List<RetornoMeiosPagamento> retorno = null;
		try {
			GatewayLocator loc = new GatewayLocator();
			
			RetornoMeiosPagamento[] aRetornoMeiosPagamento = loc.getGatewaySoap().consultaMeiosDePagamento(loja, aplicacao, meios);
			retorno = Arrays.asList(aRetornoMeiosPagamento);
			
			for (RetornoMeiosPagamento retornoMeiosPagamento : retorno) {
				if (Validator.isNull(retornoMeiosPagamento.getNome())) {
					_log.info(retornoMeiosPagamento.getMensagem());
				}
			}

		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return retorno;
	}
	
	public static String consultarMeiosPagamentoXML(String loja, String aplicacao,
			String meios) throws Exception {
		String retorno = null;
		try {
			GatewayLocator loc = new GatewayLocator();
			
			retorno = loc.getGatewaySoap().consultaMeiosDePagamentoXML(loja, aplicacao, meios);
		} catch (Exception e) {
			_log.error("MoedaDigital: " + e.getMessage());
		}
		return retorno;
	}

	public static String consultarMeiosPagamentoHtml(String loja, String aplicacao,
			String meios,  String valor) throws Exception {
		String retorno = null;
		try {
			GatewayLocator loc = new GatewayLocator();
			
			retorno = loc.getGatewaySoap().consultaMeiosDePagamentoHTML(loja, aplicacao, meios, valor);
			retorno = retorno.replace("name='MD_MeioPagto", "name='_cursoinscricaocadastroportlet_WAR_inscricaocursolf6_2ga1portlet_MD_MeioPagto");
			retorno = retorno.replace("name='MD_FormaPagto", "name='_cursoinscricaocadastroportlet_WAR_inscricaocursolf6_2ga1portlet_MD_FormaPagto");

		} catch (Exception e) {
			_log.error("MoedaDigital: " + e.getMessage());
		}
		return retorno;
	}

	public static String consultaParcelasXML(String loja, String aplicacao,
			String valor) throws Exception {
		String retorno = null;
		try {
			GatewayLocator loc = new GatewayLocator();
			
			retorno = loc.getGatewaySoap().consultaParcelasXML(loja, aplicacao, valor);

		} catch (Exception e) {
			_log.error("MoedaDigital: " + e.getMessage());
		}
		return retorno;
	}


	public static List<RetornoParcelas> consultaParcelasArray(String loja, String aplicacao,
			String valor) throws Exception {
		List<RetornoParcelas> retorno = null;
		try {
			GatewayLocator loc = new GatewayLocator();
			
			RetornoParcelas[] aRetornoParcelas = loc.getGatewaySoap().consultaParcelasArray(loja, aplicacao, valor);
			retorno = Arrays.asList(aRetornoParcelas);

			for (RetornoParcelas retornoParcelas : retorno) {
				if (Validator.isNull(retornoParcelas.getParcela())) {
					_log.info("MoedaDigital: " + retornoParcelas.getMensagem());
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return retorno;
	}

	public static String recuperarIdPedido(String conteudo) {
		String retorno = conteudo;
		
		int a = retorno.indexOf("'Pedido' value='"); 
		retorno = retorno.substring(a);
		retorno = retorno.replace("'Pedido' value='", "");
		a = retorno.indexOf("'");
		retorno = retorno.substring(0, a);
		
		return retorno;
	}
}
