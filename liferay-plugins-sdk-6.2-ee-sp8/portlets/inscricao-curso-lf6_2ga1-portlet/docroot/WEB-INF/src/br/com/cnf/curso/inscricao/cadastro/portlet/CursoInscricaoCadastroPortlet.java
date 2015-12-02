package br.com.cnf.curso.inscricao.cadastro.portlet;

import br.com.cnf.curso.inscricao.Constantes;
import br.com.cnf.curso.inscricao.cadastro.validacao.Validacao;
import br.com.cnf.curso.inscricao.model.CursoInscricao;
import br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj;
import br.com.cnf.curso.inscricao.model.CursoInscricaoCpf;
import br.com.cnf.curso.inscricao.model.CursoParticipante;
import br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCnpjImpl;
import br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCpfImpl;
import br.com.cnf.curso.inscricao.model.impl.CursoParticipanteImpl;
import br.com.cnf.curso.inscricao.service.CursoInscricaoCnpjLocalServiceUtil;
import br.com.cnf.curso.inscricao.service.CursoInscricaoCpfLocalServiceUtil;
import br.com.cnf.curso.inscricao.service.CursoInscricaoLocalServiceUtil;
import br.com.cnf.curso.inscricao.service.CursoParticipanteLocalServiceUtil;
import br.com.cnf.curso.inscricao.util.DateUtil;
import br.com.cnf.curso.inscricao.util.Formatter;
import br.com.cnf.curso.inscricao.util.Helper;
import br.com.cnf.curso.inscricao.util.InscricaoUtil;
import br.com.cnf.curso.inscricao.util.MoedaDigitalUtil;
import br.com.cnf.curso.inscricao.util.Search;
import br.com.seatecnologia.utils.SEAUtils;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.NoSuchArticleException;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.tempuri.RetornoMeiosPagamento;
import org.tempuri.RetornoParcelas;
import org.tempuri.RetornoPedido;

/**
 * Portlet implementation class CursoInscricaoCadastroPortlet
 */
public class CursoInscricaoCadastroPortlet extends MVCPortlet {

	protected String formulario01;
	protected String formulario02;
	protected String formulario03CNPJ;
	protected String formulario03CPF;
	protected String formulario04CNPJ;
	protected String formulario04CPF;
	protected String formulario05CNPJ;
	protected String formularioFinal;
	protected String visualizarJSP;
	protected String formaPagamentoJSP;

	private static Log log = LogFactoryUtil
			.getLog(CursoInscricaoCadastroPortlet.class);

	@Override
	public void init() throws PortletException {
		formulario01 = getInitParameter(Constantes.JSP_FORMULARIO_01);
		formulario02 = getInitParameter(Constantes.JSP_FORMULARIO_02);
		formulario03CNPJ = getInitParameter(Constantes.JSP_FORMULARIO_03_CNPJ);
		formulario03CPF = getInitParameter(Constantes.JSP_FORMULARIO_03_CPF);
		formulario04CNPJ = getInitParameter(Constantes.JSP_FORMULARIO_04_CNPJ);
		formulario04CPF = getInitParameter(Constantes.JSP_FORMULARIO_04_CPF);
		formulario05CNPJ = getInitParameter(Constantes.JSP_FORMULARIO_05_CNPJ);
		formularioFinal = getInitParameter(Constantes.JSP_FORMULARIO_FINAL);
		visualizarJSP = getInitParameter(Constantes.JSP_VISUALIZAR);
		formaPagamentoJSP = getInitParameter(Constantes.JSP_FORMA_PAGAMENTO);
		super.init();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {
		if (PortletMode.VIEW.equals(renderRequest.getPortletMode())) {
			String cursoId = null;
			try {
				HttpServletRequest httpReq = PortalUtil
						.getOriginalServletRequest(PortalUtil
								.getHttpServletRequest(renderRequest));

				String moedaDigitalToken = PortletProps
						.get("moeda.digital.token");
				String moedaDigitalAplicacao = PortletProps
						.get("moeda.digital.aplicacao");

				// Recuperar lista inscrição do request
				List<CursoInscricao> listaCursoInscricao = (List<CursoInscricao>) renderRequest
						.getAttribute(Constantes.LISTA_CURSO_INSCRICAO);

				// Recuperar inscrição do request
				CursoInscricao cursoInscricao = (CursoInscricao) renderRequest
						.getAttribute(Constantes.CURSO_INSCRICAO);

				// Recuperar etapa do request
				String exibirDadosParticipante = ParamUtil.getString(
						renderRequest, Constantes.EXIBIR_DADOS_PARTICIPANTE);
				String modoAdm = ParamUtil.getString(renderRequest,
						Constantes.MODO_ADM);
				String houveErro = ParamUtil.getString(renderRequest,
						Constantes.HOUVE_ERRO);
				String etapa = ParamUtil.getString(renderRequest,
						Constantes.PROP_ETAPA);
				String responsavelParticipante = ParamUtil.getString(
						renderRequest, "responsavelParticipante");
				String moedaDigitalPedidoId = ParamUtil.getString(
						renderRequest, Constantes.MOEDA_DIGITAL_PEDIDO_ID);
				renderRequest.setAttribute(Constantes.MOEDA_DIGITAL_PEDIDO_ID,
						moedaDigitalPedidoId);

				int iEtapa = 0;
				if (Validator.isNull(etapa)) {
					iEtapa = 1;
				} else {
					if (Constantes.S.equals(houveErro)) {
						iEtapa = GetterUtil.getInteger(etapa);
					} else {
						iEtapa = GetterUtil.getInteger(etapa) + 1;
					}
				}

				// Recuperar o filtro do request
				String filtroCnpj = ParamUtil.getString(renderRequest,
						Constantes.FILTRO_CNPJ);
				String filtroCpf = ParamUtil.getString(renderRequest,
						Constantes.FILTRO_CPF);
				String filtroCurso = ParamUtil.getString(renderRequest,
						Constantes.FILTRO_CURSO);
				String filtroNomeResponsavel = ParamUtil.getString(
						renderRequest, Constantes.FILTRO_NOME);
				renderRequest.setAttribute(Constantes.FILTRO_CNPJ, filtroCnpj);
				renderRequest.setAttribute(Constantes.FILTRO_CPF, filtroCpf);
				renderRequest
						.setAttribute(Constantes.FILTRO_CURSO, filtroCurso);
				renderRequest.setAttribute(Constantes.FILTRO_NOME,
						filtroNomeResponsavel);

				// Recuperar id do curso do request
				cursoId = ParamUtil.getString(renderRequest,
						Constantes.PARAM_CURSO_ID);
				if (Validator.isNull(cursoId)) {
					cursoId = httpReq.getParameter(Constantes.PARAM_CURSO_ID);
				}

				renderRequest.setAttribute(
						Constantes.EXIBIR_DADOS_PARTICIPANTE,
						exibirDadosParticipante);
				if ((Validator.isNull(cursoId)) && (iEtapa == 1)) {
					if (Validator.isNull(listaCursoInscricao)) {
						listaCursoInscricao = CursoInscricaoLocalServiceUtil
								.getCursoInscricaos(QueryUtil.ALL_POS,
										QueryUtil.ALL_POS);
					}

					renderRequest.setAttribute(
							Constantes.LISTA_CURSO_INSCRICAO,
							listaCursoInscricao);
					renderRequest.setAttribute(Constantes.MODO_ADM,
							Constantes.S);
					include(viewTemplate, renderRequest, renderResponse);
				} else {
					if (Validator.isNull(cursoInscricao)) {
						cursoInscricao = Search.recuperarConteudo(httpReq,
								cursoId);

						if (Validator.isNull(cursoInscricao)) {

							SessionErrors
									.add(renderRequest,
											Constantes.MSG_ERRO_CONTEUDO_NAO_ENCONTRADO,
											cursoId);
							renderRequest.setAttribute("msgCursoNaoEncontrado",
									"Conte&uacute;do " + cursoId
											+ " n&atilde;o encontrado.");
							include(viewTemplate, renderRequest, renderResponse);
						} else {
							if (Validator.isNull(cursoInscricao.getDataInicio())) {
								SessionErrors
										.add(renderRequest,
												Constantes.MSG_ERRO_DATA_INICIO_CURSO_NAO_CADASTRADO,
												cursoInscricao.getCursoNome());
								enviarEmailParaResponsavel(renderRequest, cursoInscricao);
								cursoInscricao = null;
								include(viewTemplate, renderRequest, renderResponse);
								
							}
						}
					}
					if (Validator.isNotNull(cursoInscricao)) {

						// Atribuir objetos do request
						renderRequest.setAttribute(Constantes.CURSO_INSCRICAO,
								cursoInscricao);
						renderRequest.setAttribute(Constantes.PROP_ETAPA,
								iEtapa);
						renderRequest.setAttribute(Constantes.PARAM_CURSO_ID,
								cursoId);
						renderRequest
								.setAttribute(Constantes.MODO_ADM, modoAdm);
						renderRequest.setAttribute("responsavelParticipante",
								responsavelParticipante);

						// Recuperar estados
						List<String> listaEstados = InscricaoUtil
								.montarListaEstados();
						renderRequest.setAttribute(Constantes.LISTA_ESTADOS,
								listaEstados);

						if (iEtapa == 1) {
							include(formulario01, renderRequest, renderResponse);
						} else if (iEtapa == 2) {
							include(formulario02, renderRequest, renderResponse);
						} else if ((iEtapa == 3)
								&& (Constantes.PESSOA_FISICA
										.equals(cursoInscricao
												.getTipoFisicaJuridica()))) {
							include(formulario03CPF, renderRequest,
									renderResponse);
						} else if ((iEtapa == 3)
								&& (Constantes.PESSOA_JURIDICA
										.equals(cursoInscricao
												.getTipoFisicaJuridica()))) {
							include(formulario03CNPJ, renderRequest,
									renderResponse);
						} else if ((iEtapa == 4)
								&& (Constantes.PESSOA_FISICA
										.equals(cursoInscricao
												.getTipoFisicaJuridica()))) {
							include(formulario04CPF, renderRequest,
									renderResponse);
						} else if ((iEtapa == 4)
								&& (Constantes.PESSOA_JURIDICA
										.equals(cursoInscricao
												.getTipoFisicaJuridica()))) {
							include(formulario04CNPJ, renderRequest,
									renderResponse);
						} else if ((iEtapa == 5)
								&& (Constantes.PESSOA_FISICA
										.equals(cursoInscricao
												.getTipoFisicaJuridica()))) {
							// Recuperar formas de pagamento
							List<RetornoMeiosPagamento> listaRetornoMeiosPagamento = MoedaDigitalUtil
									.consultarMeiosPagamento(moedaDigitalToken,
											moedaDigitalAplicacao,
											Constantes.TODOS);
							
							String encontrouMeiosPagamento = "0";
							String encontrouMeiosPagamentoBoleto = "0";
							String encontrouMeiosPagamentoCartao = "0";
							
							Iterator<RetornoMeiosPagamento> itRetornoMeiosPagamento = listaRetornoMeiosPagamento.iterator();
							while(itRetornoMeiosPagamento.hasNext()) {
								RetornoMeiosPagamento retornoMeiosPagamento = itRetornoMeiosPagamento.next();
								if (Validator.isNotNull(retornoMeiosPagamento.getNome())) {
									encontrouMeiosPagamento = "1";
									if (Constantes.ITAU_BOLETO.equals(retornoMeiosPagamento.getNome())) {
										encontrouMeiosPagamentoBoleto = "1";
									}
									if ((retornoMeiosPagamento.getNome().indexOf("CIELO") != -1) || (retornoMeiosPagamento.getNome().indexOf("REDECARD") != -1)) {
										encontrouMeiosPagamentoCartao = "1";
									}
								}
							}
							
							PortletPreferences portletPreferences = renderRequest.getPreferences();
							ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
									.getAttribute(WebKeys.THEME_DISPLAY);
							String exibirCreditoEmConta = "1";
							String paramDiasBoleto = ParamUtil.getString(renderRequest, Constantes.PREF_PARAM_DIAS_BOLETO, InscricaoUtil.getParamDiasBoletoPreferencia(portletPreferences, themeDisplay.getCompanyId()));
							int diasBoleto = GetterUtil.getInteger(paramDiasBoleto);
							if (Validator.isNotNull(cursoInscricao.getDataInicio())) {
								int diferenca = DateUtil.dataDiff(new Date(), cursoInscricao.getDataInicio());
								if (diferenca <= diasBoleto) {
									encontrouMeiosPagamentoBoleto = "0";
									exibirCreditoEmConta = "0";
								}
							}
							
							renderRequest
							.setAttribute(
									Constantes.EXIBIR_CREDITO_EM_CONTA,
									exibirCreditoEmConta);
							renderRequest
							.setAttribute(
									Constantes.MOEDA_DIGITAL_ENCONTROU_MEIOS_PAGAMENTO,
									encontrouMeiosPagamento);
							renderRequest
							.setAttribute(
									Constantes.MOEDA_DIGITAL_ENCONTROU_MEIOS_PAGAMENTO_BOLETO,
									encontrouMeiosPagamentoBoleto);
							renderRequest
							.setAttribute(
									Constantes.MOEDA_DIGITAL_ENCONTROU_MEIOS_PAGAMENTO_CARTAO,
									encontrouMeiosPagamentoCartao);
							
							renderRequest
									.setAttribute(
											Constantes.MOEDA_DIGITAL_LISTA_RETORNO_MEIOS_PAGAMENTO,
											listaRetornoMeiosPagamento);

							List<CursoParticipante> listaParticipante = InscricaoUtil
									.recuperarListaParticipantesPorInscricao(cursoInscricao
											.getInscricaoId());
							double valorTotal = 0;
							for (CursoParticipante participante : listaParticipante) {
								valorTotal = valorTotal
										+ Helper.transformaValorPagoParaDouble(participante
												.getValorPago());
							}
							// Atualiza dados de inscrião
							cursoInscricao.setValorTotal(valorTotal);
							cursoInscricao = CursoInscricaoLocalServiceUtil
									.updateCursoInscricao(cursoInscricao);

							String strValor = Formatter.formatMoney(valorTotal);

							// Recuperar parcelas
							List<RetornoParcelas> listaRetornoParcelas = MoedaDigitalUtil
									.consultaParcelasArray(moedaDigitalToken,
											moedaDigitalAplicacao, strValor);

							renderRequest
									.setAttribute(
											Constantes.MOEDA_DIGITAL_LISTA_RETORNO_MEIOS_PAGAMENTO,
											listaRetornoMeiosPagamento);
							renderRequest
									.setAttribute(
											Constantes.MOEDA_DIGITAL_LISTA_RETORNO_PARCELAS,
											listaRetornoParcelas);
							renderRequest.setAttribute(
									Constantes.PROP_VALOR_BOLETO,
									cursoInscricao.getValorTotal());
							
							include(formaPagamentoJSP, renderRequest,
									renderResponse);
						} else if ((iEtapa == 5)
								&& (Constantes.PESSOA_JURIDICA
										.equals(cursoInscricao
												.getTipoFisicaJuridica()))) {
							List<CursoParticipante> listaCursoParticipante = InscricaoUtil
									.recuperarListaParticipantesPorInscricao(cursoInscricao
											.getInscricaoId());
							renderRequest.setAttribute(
									Constantes.LISTA_CURSO_PARTICIPANTES,
									listaCursoParticipante);
							include(formulario05CNPJ, renderRequest,
									renderResponse);
						} else if ((iEtapa == 6)
								&& (Constantes.PESSOA_FISICA
										.equals(cursoInscricao
												.getTipoFisicaJuridica()))) {
							if (Constantes.S.equals(modoAdm)) {
								renderRequest.setAttribute(Constantes.URL,
										Constantes.URL_INSCRICAO);
							} else {
								renderRequest.setAttribute(Constantes.URL,
										Constantes.URL_CURSO);
							}
							include(formularioFinal, renderRequest,
									renderResponse);
						} else if ((iEtapa == 6)
								&& (Constantes.PESSOA_JURIDICA
										.equals(cursoInscricao
												.getTipoFisicaJuridica()))) {
							// Recuperar formas de pagamento
							List<RetornoMeiosPagamento> listaRetornoMeiosPagamento = MoedaDigitalUtil
									.consultarMeiosPagamento(moedaDigitalToken,
											moedaDigitalAplicacao,
											Constantes.TODOS);

							String encontrouMeiosPagamento = "0";
							String encontrouMeiosPagamentoBoleto = "0";
							String encontrouMeiosPagamentoCartao = "0";
							
							Iterator<RetornoMeiosPagamento> itRetornoMeiosPagamento = listaRetornoMeiosPagamento.iterator();
							while(itRetornoMeiosPagamento.hasNext()) {
								RetornoMeiosPagamento retornoMeiosPagamento = itRetornoMeiosPagamento.next();
								if (Validator.isNotNull(retornoMeiosPagamento.getNome())) {
									encontrouMeiosPagamento = "1";
									if (Constantes.ITAU_BOLETO.equals(retornoMeiosPagamento.getNome())) {
										encontrouMeiosPagamentoBoleto = "1";
									}
									if ((retornoMeiosPagamento.getNome().indexOf("CIELO") != -1) || (retornoMeiosPagamento.getNome().indexOf("REDECARD") != -1)) {
										encontrouMeiosPagamentoCartao = "1";
									}
								}
							}
							
							PortletPreferences portletPreferences = renderRequest.getPreferences();
							ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
									.getAttribute(WebKeys.THEME_DISPLAY);
							String exibirCreditoEmConta = "1";
							String paramDiasBoleto = ParamUtil.getString(renderRequest, Constantes.PREF_PARAM_DIAS_BOLETO, InscricaoUtil.getParamDiasBoletoPreferencia(portletPreferences, themeDisplay.getCompanyId()));
							int diasBoleto = GetterUtil.getInteger(paramDiasBoleto);
							if (Validator.isNotNull(cursoInscricao.getDataInicio())) {
								int diferenca = DateUtil.dataDiff(new Date(), cursoInscricao.getDataInicio());
								if (diferenca <= diasBoleto) {
									encontrouMeiosPagamentoBoleto = "0";
									exibirCreditoEmConta = "0";
								}
							}
							
							renderRequest
							.setAttribute(
									Constantes.EXIBIR_CREDITO_EM_CONTA,
									exibirCreditoEmConta);
							renderRequest
							.setAttribute(
									Constantes.MOEDA_DIGITAL_ENCONTROU_MEIOS_PAGAMENTO,
									encontrouMeiosPagamento);
							renderRequest
							.setAttribute(
									Constantes.MOEDA_DIGITAL_ENCONTROU_MEIOS_PAGAMENTO_BOLETO,
									encontrouMeiosPagamentoBoleto);
							renderRequest
							.setAttribute(
									Constantes.MOEDA_DIGITAL_ENCONTROU_MEIOS_PAGAMENTO_CARTAO,
									encontrouMeiosPagamentoCartao);

							renderRequest
									.setAttribute(
											Constantes.MOEDA_DIGITAL_LISTA_RETORNO_MEIOS_PAGAMENTO,
											listaRetornoMeiosPagamento);

							List<CursoParticipante> listaParticipante = InscricaoUtil
									.recuperarListaParticipantesPorInscricao(cursoInscricao
											.getInscricaoId());
							double valorTotal = 0;
							for (CursoParticipante participante : listaParticipante) {
								valorTotal = valorTotal
										+ Helper.transformaValorPagoParaDouble(participante
												.getValorPago());
							}
							// Atualiza dados de inscrião
							cursoInscricao.setValorTotal(valorTotal);
							cursoInscricao = CursoInscricaoLocalServiceUtil
									.updateCursoInscricao(cursoInscricao);

							String strValor = Formatter.formatMoney(valorTotal);

							// Recuperar parcelas
							List<RetornoParcelas> listaRetornoParcelas = MoedaDigitalUtil
									.consultaParcelasArray(moedaDigitalToken,
											moedaDigitalAplicacao, strValor);

							renderRequest
									.setAttribute(
											Constantes.MOEDA_DIGITAL_LISTA_RETORNO_MEIOS_PAGAMENTO,
											listaRetornoMeiosPagamento);
							renderRequest
									.setAttribute(
											Constantes.MOEDA_DIGITAL_LISTA_RETORNO_PARCELAS,
											listaRetornoParcelas);
							renderRequest.setAttribute(
									Constantes.PROP_VALOR_BOLETO,
									cursoInscricao.getValorTotal());

							include(formaPagamentoJSP, renderRequest,
									renderResponse);
						} else if ((iEtapa == 7)
								&& (Constantes.PESSOA_JURIDICA
										.equals(cursoInscricao
												.getTipoFisicaJuridica()))) {
							if (Constantes.S.equals(modoAdm)) {
								renderRequest.setAttribute(Constantes.URL,
										Constantes.URL_INSCRICAO);
							} else {
								renderRequest.setAttribute(Constantes.URL,
										Constantes.URL_CURSO);
							}

							include(formularioFinal, renderRequest,
									renderResponse);
						} else if (iEtapa == 10) {
							include(visualizarJSP, renderRequest,
									renderResponse);
						}
					}
				}

			} catch (NoSuchArticleException e) {
				SessionErrors.add(renderRequest,
						Constantes.MSG_ERRO_CONTEUDO_NAO_ENCONTRADO, cursoId);
				renderRequest.setAttribute("msgCursoNaoEncontrado",
						"Conte&uacute;do " + cursoId
								+ " n&atilde;o encontrado.");
				log.info(e.getCause());

				include(viewTemplate, renderRequest, renderResponse);
			} catch (Exception e) {
				SessionErrors.add(renderRequest, Constantes.MSG_ERRO_PORTLET);
				log.info(e);
				include(viewTemplate, renderRequest, renderResponse);
			}
		} else if (PortletMode.EDIT.equals(renderRequest.getPortletMode())) {
			PortletPreferences prefs = renderRequest.getPreferences();

			String emailRemetenteNome = prefs.getValue("emailRemetenteNome",
					"Cursos CNF");
			String emailRemetenteEndereco = prefs.getValue(
					"emailRemetenteEndereco", "cursos.eventos@cnf.org.br");

			renderRequest
					.setAttribute("emailRemetenteNome", emailRemetenteNome);
			renderRequest.setAttribute("emailRemetenteEndereco",
					emailRemetenteEndereco);

			include(editTemplate, renderRequest, renderResponse);
		}
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		try {
			if (!isProcessActionRequest(actionRequest)) {
				return;
			}

			if (!callActionMethod(actionRequest, actionResponse)) {
				return;
			}

			if (!SessionErrors.isEmpty(actionRequest)) {
				return;
			}

			if (!SessionMessages.isEmpty(actionRequest)) {
				return;
			}

			sendRedirect(actionRequest, actionResponse);
		} catch (PortletException pe) {
			Throwable cause = pe.getCause();

			if (isSessionErrorException(cause)) {
				SessionErrors.add(actionRequest, cause.getClass().getName(),
						cause);
			} else {
				throw pe;
			}
		}
	}

	public void avancarEtapa01(ActionRequest request, ActionResponse response)
			throws Exception {
		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(request));

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		// Recuperar objetos do request
		String cursoId = ParamUtil
				.getString(request, Constantes.PARAM_CURSO_ID);
		String cpfCnpj = ParamUtil.getString(request, Constantes.PROP_CPF_CNPJ);
		String tipoFisicaJuridica = ParamUtil.getString(request,
				Constantes.PROP_TIPO_FISICA_JURIDICA);
		String etapa = ParamUtil.getString(request, Constantes.PROP_ETAPA);
		String modoAdm = ParamUtil.getString(request, Constantes.MODO_ADM);

		List<String> errors = new ArrayList<String>();
		CursoInscricao cursoInscricao = null;
		if (Validacao.validarEtapa01(cpfCnpj, tipoFisicaJuridica, errors)) {

			// Recuperar curso e inscrição por cpfCnpj
			cursoInscricao = InscricaoUtil.recuperarInscricaoPorCpfCnpj(
					themeDisplay, cursoId, cpfCnpj);

			if (Validator.isNull(cursoInscricao)) {

				// Recuperar dados do conteúdo
				cursoInscricao = Search.recuperarConteudo(httpReq, cursoId);

				// Atribuir dados do request no objeto Curso Inscrição
				cursoInscricao.setCpfCnpj(cpfCnpj);
				cursoInscricao.setTipoFisicaJuridica(tipoFisicaJuridica);
				cursoInscricao.setUserCreateId(themeDisplay.getUserId());
				cursoInscricao.setCreateDate(new Date());
				cursoInscricao.setCadastroFinalizado(false);

				// Recuperar dados do usuário
				User usuario = UserLocalServiceUtil.getUser(themeDisplay
						.getUserId());
				cursoInscricao.setUserCreateName(usuario.getFullName());

				// Atualizar no banco de dados
				cursoInscricao = CursoInscricaoLocalServiceUtil
						.addCursoInscricao(cursoInscricao);
			} else {

				try {
					String sDataInicio = Search.recuperarAtributo(httpReq,
							cursoInscricao.getCursoId(), Constantes.DATA_INICIO);
					if (Validator.isNotNull(sDataInicio)) {
						Date dtInicio = DateUtil.novaData(Long.valueOf(sDataInicio));
						cursoInscricao.setDataInicio(dtInicio);
						
						cursoInscricao = CursoInscricaoLocalServiceUtil.updateCursoInscricao(cursoInscricao);
					}
				} catch (Exception e) {
					e.getMessage();
				}
				
				if (cursoInscricao.getCadastroFinalizado()) {
					if (Constantes.PESSOA_FISICA.equals(cursoInscricao
							.getTipoFisicaJuridica())) {
						SessionErrors.add(request,
								Constantes.MSG_ERRO_INSCRICAO_JA_REALIZADA_CPF);
						response.setRenderParameter(Constantes.HOUVE_ERRO,
								Constantes.S);
					} else {
						CursoInscricaoCnpj cursoInscricaoCnpj = InscricaoUtil
								.recuperarInscricaoCnpjPorInscricao(String
										.valueOf(cursoInscricao
												.getInscricaoId()));
						request.setAttribute(Constantes.CURSO_INSCRICAO_CNPJ,
								cursoInscricaoCnpj);

						etapa = "4";
					}
				} else {
					if (Constantes.PESSOA_JURIDICA.equals(cursoInscricao
							.getTipoFisicaJuridica())) {
						long inscricaoId = cursoInscricao.getInscricaoId();

						CursoInscricaoLocalServiceUtil
								.deleteCursoInscricao(cursoInscricao
										.getInscricaoId());

						// Recuperar dados do conteúdo
						cursoInscricao = Search.recuperarConteudo(httpReq,
								cursoId);

						// Atribuir dados do request no objeto Curso Inscrição
						cursoInscricao.setInscricaoId(inscricaoId);
						cursoInscricao.setCpfCnpj(cpfCnpj);
						cursoInscricao
								.setTipoFisicaJuridica(tipoFisicaJuridica);
						cursoInscricao
								.setUserCreateId(themeDisplay.getUserId());
						cursoInscricao.setCreateDate(new Date());
						cursoInscricao.setCadastroFinalizado(false);

						// Recuperar dados do usuário
						User usuario = UserLocalServiceUtil
								.getUser(themeDisplay.getUserId());
						cursoInscricao.setUserCreateName(usuario.getFullName());

						// Atualizar no banco de dados
						cursoInscricao = CursoInscricaoLocalServiceUtil
								.addCursoInscricao(cursoInscricao);
					}
				}

			}
		} else {
			for (String error : errors) {
				SessionErrors.add(request, error);
				log.info(error);
			}
			response.setRenderParameter(Constantes.HOUVE_ERRO, Constantes.S);
		}

		// Atribui no request o objeto CursoInscricao
		request.setAttribute(Constantes.CURSO_INSCRICAO, cursoInscricao);

		// Atribuir no parameter os objetos
		response.setRenderParameter(Constantes.PARAM_CURSO_ID, cursoId);
		response.setRenderParameter(Constantes.PROP_ETAPA, etapa);
		if (Validator.isNotNull(cursoInscricao)) {
			response.setRenderParameter(Constantes.PARAM_INSCRICAO_ID,
					GetterUtil.getString(cursoInscricao.getInscricaoId()));
		}
		response.setRenderParameter(Constantes.MODO_ADM, modoAdm);
	}

	public void avancarEtapa02(ActionRequest request, ActionResponse response)
			throws Exception {
		// Recuperar objetos do request
		String inscricaoId = ParamUtil.getString(request,
				Constantes.PARAM_INSCRICAO_ID);
		String etapa = ParamUtil.getString(request, Constantes.PROP_ETAPA);
		String cursoId = ParamUtil
				.getString(request, Constantes.PARAM_CURSO_ID);
		String modoAdm = ParamUtil.getString(request, Constantes.MODO_ADM);
		String responsavelParticipante = ParamUtil.getString(request,
				"responsavelParticipante");

		// Recuperar a inscrição
		CursoInscricao cursoInscricao = CursoInscricaoLocalServiceUtil
				.fetchCursoInscricao(GetterUtil.getLong(inscricaoId));

		// Atribuir dados do request no objeto Curso Inscrição
		cursoInscricao.setNomeResponsavel(ParamUtil.getString(request,
				Constantes.PROP_NOME_RESPONSAVEL_INSCRICAO));
		cursoInscricao.setEmailPrincipal(ParamUtil.getString(request,
				Constantes.PROP_EMAIL_PRINCIPAL));
		cursoInscricao.setDddTelefoneComercial(ParamUtil.getString(request,
				Constantes.PROP_DDD_TELEFONE_PRINCIPAL));
		cursoInscricao.setTelefoneComercial(ParamUtil.getString(request,
				Constantes.PROP_TELEFONE_PRINCIPAL));
		cursoInscricao.setSexo(ParamUtil.getString(request,
				Constantes.PROP_SEXO));

		List<String> errors = new ArrayList<String>();
		if (Validacao.validarEtapa02(cursoInscricao, errors)) {
			// Atualizar no banco de dados
			cursoInscricao = CursoInscricaoLocalServiceUtil
					.updateCursoInscricao(cursoInscricao);

			// Se a inscrição for cpf
			if (Constantes.PESSOA_FISICA.equals(cursoInscricao
					.getTipoFisicaJuridica())) {
				// Recuperar os dados do participante pela inscrição
				CursoParticipante cursoParticipante = adicionarParticipante(
						cursoInscricao, inscricaoId,
						Boolean.valueOf(responsavelParticipante));

				// Atribui no request o objeto cursoParticipante
				request.setAttribute(Constantes.CURSO_PARTICIPANTE,
						cursoParticipante);
			}
			// Se a inscrição for cpf
			else if (Constantes.PESSOA_JURIDICA.equals(cursoInscricao
					.getTipoFisicaJuridica())) {
				// Recuperar os dados da inscrição cnpj pela inscrição
				CursoInscricaoCnpj cursoInscricaoCnpj = InscricaoUtil
						.recuperarInscricaoCnpjPorInscricao(inscricaoId);
				// Se não tiver cadastrado//incluir com os dados da pessoa que
				// iniciou a inscrição

				if (Validator.isNull(cursoInscricaoCnpj)) {
					cursoInscricaoCnpj = new CursoInscricaoCnpjImpl();
					cursoInscricaoCnpj.setInscricaoId(GetterUtil
							.getLong(inscricaoId));

					// Adicionar no banco de dados
					cursoInscricaoCnpj = CursoInscricaoCnpjLocalServiceUtil
							.addCursoInscricaoCnpj(cursoInscricaoCnpj);
				}

				// Atribui no request o objeto cursoInscricaoCnpj
				request.setAttribute(Constantes.CURSO_INSCRICAO_CNPJ,
						cursoInscricaoCnpj);
			}
		} else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			response.setRenderParameter(Constantes.HOUVE_ERRO, Constantes.S);
		}
		// Atribuir no parameter os objetos
		response.setRenderParameter(Constantes.PARAM_INSCRICAO_ID, inscricaoId);
		response.setRenderParameter(Constantes.PARAM_CURSO_ID, cursoId);
		response.setRenderParameter(Constantes.PROP_ETAPA, etapa);
		response.setRenderParameter(Constantes.MODO_ADM, modoAdm);
		response.setRenderParameter("responsavelParticipante",
				responsavelParticipante);

		// Atribui no request o objeto CursoInscricao
		request.setAttribute(Constantes.CURSO_INSCRICAO, cursoInscricao);
	}

	public void avancarEtapa03CPF(ActionRequest request, ActionResponse response)
			throws Exception {
		// Recuperar objetos do request
		String inscricaoId = ParamUtil.getString(request,
				Constantes.PARAM_INSCRICAO_ID);
		String etapa = ParamUtil.getString(request, Constantes.PROP_ETAPA);
		String cursoId = ParamUtil
				.getString(request, Constantes.PARAM_CURSO_ID);
		String participanteId = ParamUtil.getString(request,
				Constantes.PARAM_PARTICIPANTE_ID);
		String modoAdm = ParamUtil.getString(request, Constantes.MODO_ADM);

		String sexo = ParamUtil.getString(request, Constantes.PROP_SEXO);

		// Recuperar o participante
		CursoParticipante cursoParticipante = CursoParticipanteLocalServiceUtil
				.fetchCursoParticipante(GetterUtil.getLong(participanteId));

		// Atribuir dados do request no objeto Curso Participante
		cursoParticipante.setNomeCompleto(ParamUtil.getString(request,
				Constantes.PROP_NOME_COMPLETO));
		cursoParticipante.setNomeCracha(ParamUtil.getString(request,
				Constantes.PROP_NOME_CRACHA));
		cursoParticipante.setCpf(ParamUtil.getString(request,
				Constantes.PROP_CPF));
		cursoParticipante.setSexo(ParamUtil.getString(request,
				Constantes.PROP_SEXO));

		cursoParticipante.setEmpresaOndeTrabalha(ParamUtil.getString(request,
				Constantes.PROP_EMPRESA_ONDE_TRABALHA));
		cursoParticipante.setCargo(ParamUtil.getString(request,
				Constantes.PROP_CARGO));
		cursoParticipante.setDepartamento(ParamUtil.getString(request,
				Constantes.PROP_DEPARTAMENTO));
		cursoParticipante.setFormacaoAcademica(ParamUtil.getString(request,
				Constantes.PROP_FORMACAO_ACADEMICA));

		cursoParticipante.setEmailPrincipal(ParamUtil.getString(request,
				Constantes.PROP_EMAIL_PRINCIPAL));
		cursoParticipante.setEmailOpcional(ParamUtil.getString(request,
				Constantes.PROP_EMAIL_OPCIONAL));

		cursoParticipante.setDddTelefoneComercial(ParamUtil.getString(request,
				Constantes.PROP_DDD_TELEFONE_PRINCIPAL));
		cursoParticipante.setTelefoneComercial(ParamUtil.getString(request,
				Constantes.PROP_TELEFONE_PRINCIPAL));
		cursoParticipante.setDddTelefonePessoal(ParamUtil.getString(request,
				Constantes.PROP_DDD_TELEFONE_SECUNDARIO));
		cursoParticipante.setTelefonePessoal(ParamUtil.getString(request,
				Constantes.PROP_TELEFONE_SECUNDARIO));
		cursoParticipante.setDddTelefoneCelular(ParamUtil.getString(request,
				Constantes.PROP_DDD_TELEFONE_CELULAR));
		cursoParticipante.setTelefoneCelular(ParamUtil.getString(request,
				Constantes.PROP_TELEFONE_CELULAR));

		cursoParticipante.setEndereco(ParamUtil.getString(request,
				Constantes.PROP_ENDERECO));
		cursoParticipante.setBairro(ParamUtil.getString(request,
				Constantes.PROP_BAIRRO));
		cursoParticipante.setCidade(ParamUtil.getString(request,
				Constantes.PROP_CIDADE));
		cursoParticipante.setEstado(ParamUtil.getString(request,
				Constantes.PROP_ESTADO));
		cursoParticipante.setCep(ParamUtil.getString(request,
				Constantes.PROP_CEP));

		cursoParticipante.setExpectativaCurso(ParamUtil.getString(request,
				Constantes.PROP_EXPECTATIVA_CURSO));
		cursoParticipante.setObservacao(ParamUtil.getString(request,
				Constantes.PROP_OBSERVACAO));

		// Recuperar a inscrição
		CursoInscricao cursoInscricao = CursoInscricaoLocalServiceUtil
				.fetchCursoInscricao(GetterUtil.getLong(inscricaoId));
		cursoInscricao.setSexo(sexo);
		cursoInscricao = CursoInscricaoLocalServiceUtil
				.updateCursoInscricao(cursoInscricao);

		List<String> errors = new ArrayList<String>();
		if (Validacao.validarEtapa03CPF(cursoParticipante, errors)) {
			// Atualizar no banco de dados
			cursoParticipante = CursoParticipanteLocalServiceUtil
					.updateCursoParticipante(cursoParticipante);

			// Recuperar os dados da nota fiscal do participante pela
			// inscrição
			CursoInscricaoCpf cursoInscricaoCpf = InscricaoUtil
					.recuperarInscricaoCpfPorInscricao(inscricaoId);

			// Se não tiver cadastrado//incluir com os dados do participante
			if (Validator.isNull(cursoInscricaoCpf)) {
				cursoInscricaoCpf = new CursoInscricaoCpfImpl();
				cursoInscricaoCpf.setInscricaoId(GetterUtil
						.getLong(inscricaoId));
				cursoInscricaoCpf.setCpf(cursoParticipante.getCpf());
				cursoInscricaoCpf.setNome(cursoParticipante.getNomeCompleto());
				cursoInscricaoCpf.setEndereco(cursoParticipante.getEndereco());
				cursoInscricaoCpf.setBairro(cursoParticipante.getBairro());
				cursoInscricaoCpf.setCidade(cursoParticipante.getCidade());
				cursoInscricaoCpf.setEstado(cursoParticipante.getEstado());
				cursoInscricaoCpf.setCep(cursoParticipante.getCep());
				cursoInscricaoCpf.setDddTelefone(cursoParticipante
						.getDddTelefoneComercial());
				cursoInscricaoCpf.setTelefone(cursoParticipante
						.getTelefoneComercial());
				cursoInscricaoCpf.setEmail(cursoParticipante
						.getEmailPrincipal());
				cursoInscricaoCpf.setEmpresa(cursoParticipante
						.getEmpresaOndeTrabalha());
				cursoInscricaoCpf.setCargo(cursoParticipante.getCargo());
				cursoInscricaoCpf.setDepartamento(cursoParticipante
						.getDepartamento());

				// Adicionar no banco de dados
				cursoInscricaoCpf = CursoInscricaoCpfLocalServiceUtil
						.addCursoInscricaoCpf(cursoInscricaoCpf);
			}

			// Atribui no request o objeto cursoParticipante
			request.setAttribute(Constantes.CURSO_INSCRICAO_CPF,
					cursoInscricaoCpf);
		} else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			response.setRenderParameter(Constantes.HOUVE_ERRO, Constantes.S);
		}
		// Atribuir no parameter os objetos
		response.setRenderParameter(Constantes.PARAM_INSCRICAO_ID, inscricaoId);
		response.setRenderParameter(Constantes.PARAM_CURSO_ID, cursoId);
		response.setRenderParameter(Constantes.PROP_ETAPA, etapa);
		response.setRenderParameter(Constantes.MODO_ADM, modoAdm);

		// Atribui no request o objeto CursoInscricao
		request.setAttribute(Constantes.CURSO_INSCRICAO, cursoInscricao);

		// Atribui no request o objeto cursoParticipante
		request.setAttribute(Constantes.CURSO_PARTICIPANTE, cursoParticipante);
	}

	public void avancarEtapa04CPF(ActionRequest request, ActionResponse response)
			throws Exception {
		// Recuperar objetos do request
		String inscricaoId = ParamUtil.getString(request,
				Constantes.PARAM_INSCRICAO_ID);
		String etapa = ParamUtil.getString(request, Constantes.PROP_ETAPA);
		String cursoId = ParamUtil
				.getString(request, Constantes.PARAM_CURSO_ID);
		String inscricaoCpfId = ParamUtil.getString(request,
				Constantes.PARAM_INSCRICAO_CPF_ID);
		String participanteId = ParamUtil.getString(request,
				Constantes.PARAM_PARTICIPANTE_ID);
		String modoAdm = ParamUtil.getString(request, Constantes.MODO_ADM);

		// Recuperar a inscrição cpf
		CursoInscricaoCpf cursoInscricaoCpf = CursoInscricaoCpfLocalServiceUtil
				.fetchCursoInscricaoCpf(GetterUtil.getLong(inscricaoCpfId));

		// Recuperar o participante
		CursoParticipante cursoParticipante = CursoParticipanteLocalServiceUtil
				.fetchCursoParticipante(GetterUtil.getLong(participanteId));

		// Atribuir dados do request no objeto Inscrição CPF
		cursoInscricaoCpf.setNome(ParamUtil.getString(request,
				Constantes.PROP_NF_NOME));
		cursoInscricaoCpf.setCpf(ParamUtil.getString(request,
				Constantes.PROP_CPF));
		cursoInscricaoCpf.setEmail(ParamUtil.getString(request,
				Constantes.PROP_EMAIL));
		cursoInscricaoCpf.setDddTelefone(ParamUtil.getString(request,
				Constantes.PROP_DDD_TELEFONE));
		cursoInscricaoCpf.setTelefone(ParamUtil.getString(request,
				Constantes.PROP_TELEFONE));
		cursoInscricaoCpf.setEndereco(ParamUtil.getString(request,
				Constantes.PROP_ENDERECO));
		cursoInscricaoCpf.setBairro(ParamUtil.getString(request,
				Constantes.PROP_BAIRRO));
		cursoInscricaoCpf.setCidade(ParamUtil.getString(request,
				Constantes.PROP_CIDADE));
		cursoInscricaoCpf.setEstado(ParamUtil.getString(request,
				Constantes.PROP_ESTADO));
		cursoInscricaoCpf.setCep(ParamUtil.getString(request,
				Constantes.PROP_CEP));
		cursoInscricaoCpf.setObservacao(ParamUtil.getString(request,
				Constantes.PROP_OBSERVACAO));

		// Recuperar a inscrição
		CursoInscricao cursoInscricao = CursoInscricaoLocalServiceUtil
				.fetchCursoInscricao(GetterUtil.getLong(inscricaoId));

		List<String> errors = new ArrayList<String>();
		if (Validacao.validarEtapa04CPF(cursoInscricaoCpf, errors)) {
			// Atualizar no banco de dados
			cursoInscricaoCpf = CursoInscricaoCpfLocalServiceUtil
					.updateCursoInscricaoCpf(cursoInscricaoCpf);

			// Atualizar inscrição
			cursoInscricao = CursoInscricaoLocalServiceUtil
					.updateCursoInscricao(cursoInscricao);

			CursoParticipante participante = CursoParticipanteLocalServiceUtil
					.getCursoParticipante(Long.valueOf(participanteId));

			String paramValorPago = ParamUtil.getString(request, "valorPago");

			String valorPago = "";

			HttpServletRequest httpRequest = PortalUtil
					.getHttpServletRequest(request);

			if ("preco".equals(paramValorPago)) {
				valorPago = Search.recuperarAtributo(httpRequest,
						cursoInscricao.getCursoId(), Constantes.PRECO);
			} else if ("precoConvenio".equals(paramValorPago)) {
				valorPago = Search.recuperarAtributo(httpRequest,
						cursoInscricao.getCursoId(), Constantes.PRECO_CONVENIO);
			} else if ("precoAssociado".equals(paramValorPago)) {
				valorPago = Search
						.recuperarAtributo(httpRequest,
								cursoInscricao.getCursoId(),
								Constantes.PRECO_ASSOCIADO);
			}

			participante.setValorPago(valorPago);

			CursoParticipanteLocalServiceUtil
					.updateCursoParticipante(participante);

			// Atribui no request o objeto cursoInscricaoCpf
			request.setAttribute(Constantes.CURSO_INSCRICAO_CPF,
					cursoInscricaoCpf);
		} else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			response.setRenderParameter(Constantes.HOUVE_ERRO, Constantes.S);
		}

		// Atribuir no parameter os objetos
		response.setRenderParameter(Constantes.PARAM_INSCRICAO_ID, inscricaoId);
		response.setRenderParameter(Constantes.PARAM_CURSO_ID, cursoId);
		response.setRenderParameter(Constantes.PROP_ETAPA, etapa);
		response.setRenderParameter(Constantes.MODO_ADM, modoAdm);

		// Atribui no request o objeto CursoInscricao
		request.setAttribute(Constantes.CURSO_INSCRICAO, cursoInscricao);

		// Atribui no request o objeto cursoParticipante
		request.setAttribute(Constantes.CURSO_PARTICIPANTE, cursoParticipante);

		// Atribui no request o objeto cursoParticipante
		request.setAttribute(Constantes.CURSO_INSCRICAO_CPF, cursoInscricaoCpf);
	}

	public void avancarEtapa03CNPJ(ActionRequest request,
			ActionResponse response) throws Exception {
		// Recuperar objetos do request
		String inscricaoId = ParamUtil.getString(request,
				Constantes.PARAM_INSCRICAO_ID);
		String etapa = ParamUtil.getString(request, Constantes.PROP_ETAPA);
		String cursoId = ParamUtil
				.getString(request, Constantes.PARAM_CURSO_ID);
		String inscricaoCnpjId = ParamUtil.getString(request,
				Constantes.PARAM_INSCRICAO_CNPJ_ID);
		String modoAdm = ParamUtil.getString(request, Constantes.MODO_ADM);
		boolean responsavelParticipante = ParamUtil.getBoolean(request,
				"responsavelParticipante");

		// Recuperar a inscrição cnpj
		CursoInscricaoCnpj cursoInscricaoCnpj = CursoInscricaoCnpjLocalServiceUtil
				.fetchCursoInscricaoCnpj(GetterUtil.getLong(inscricaoCnpjId));

		// Atribuir dados do request no objeto Inscrição CNPJ
		cursoInscricaoCnpj.setRazaoSocial(ParamUtil.getString(request,
				Constantes.PROP_RAZAO_SOCIAL));
		cursoInscricaoCnpj.setNomeFantasia(ParamUtil.getString(request,
				Constantes.PROP_NOME_FANTASIA));
		cursoInscricaoCnpj.setInscricaoEstadual(ParamUtil.getString(request,
				Constantes.PROP_INSCRICAO_ESTADUAL));

		cursoInscricaoCnpj.setEndereco(ParamUtil.getString(request,
				Constantes.PROP_ENDERECO));
		cursoInscricaoCnpj.setBairro(ParamUtil.getString(request,
				Constantes.PROP_BAIRRO));
		cursoInscricaoCnpj.setCidade(ParamUtil.getString(request,
				Constantes.PROP_CIDADE));
		cursoInscricaoCnpj.setEstado(ParamUtil.getString(request,
				Constantes.PROP_ESTADO));
		cursoInscricaoCnpj.setCep(ParamUtil.getString(request,
				Constantes.PROP_CEP));

		cursoInscricaoCnpj.setNfNome(ParamUtil.getString(request,
				Constantes.PROP_NF_NOME));
		cursoInscricaoCnpj.setNfDepartamento(ParamUtil.getString(request,
				Constantes.PROP_NF_DEPARTAMENTO));
		cursoInscricaoCnpj.setNfDddTelefone(ParamUtil.getString(request,
				Constantes.PROP_NF_DDD_TELEFONE));
		cursoInscricaoCnpj.setNfTelefone(ParamUtil.getString(request,
				Constantes.PROP_NF_TELEFONE));
		cursoInscricaoCnpj.setNfEmail(ParamUtil.getString(request,
				Constantes.PROP_NF_EMAIL));
		cursoInscricaoCnpj.setObservacao(ParamUtil.getString(request,
				Constantes.PROP_OBSERVACAO));

		// Recuperar a inscrição
		CursoInscricao cursoInscricao = CursoInscricaoLocalServiceUtil
				.fetchCursoInscricao(GetterUtil.getLong(inscricaoId));

		List<String> errors = new ArrayList<String>();
		if (Validacao.validarEtapa03CNPJ(cursoInscricaoCnpj, errors)) {
			// Atualizar no banco de dados
			cursoInscricaoCnpj = CursoInscricaoCnpjLocalServiceUtil
					.updateCursoInscricaoCnpj(cursoInscricaoCnpj);

			// Recuperar lista de participantes, se existe vai pular a próxima
			// etapa
			List<CursoParticipante> listaCursoParticipante = InscricaoUtil
					.recuperarListaParticipantesPorInscricao(GetterUtil
							.getLong(inscricaoId));

			if (listaCursoParticipante.size() > 1) {
				int iEtapa = Integer.parseInt(etapa);
				iEtapa++;
				etapa = String.valueOf(iEtapa);
			} else {
				// Adicionar participante
				CursoParticipante cursoParticipante = adicionarParticipante(
						cursoInscricao, inscricaoId, responsavelParticipante);

				// Atribui no request o objeto cursoParticipante
				request.setAttribute(Constantes.CURSO_PARTICIPANTE,
						cursoParticipante);
			}
		} else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			response.setRenderParameter(Constantes.HOUVE_ERRO, Constantes.S);
		}
		// Atribuir no parameter os objetos
		response.setRenderParameter(Constantes.PARAM_INSCRICAO_ID, inscricaoId);
		response.setRenderParameter(Constantes.PARAM_CURSO_ID, cursoId);
		response.setRenderParameter(Constantes.PROP_ETAPA, etapa);
		response.setRenderParameter(Constantes.MODO_ADM, modoAdm);

		// Atribui no request o objeto CursoInscricao
		request.setAttribute(Constantes.CURSO_INSCRICAO, cursoInscricao);

		// Atribui no request o objeto cursoInscricaoCnpj
		request.setAttribute(Constantes.CURSO_INSCRICAO_CNPJ,
				cursoInscricaoCnpj);
	}

	public void avancarEtapa04CNPJ(ActionRequest request,
			ActionResponse response) throws Exception {
		// Recuperar objetos do request
		String inscricaoId = ParamUtil.getString(request,
				Constantes.PARAM_INSCRICAO_ID);
		String etapa = ParamUtil.getString(request, Constantes.PROP_ETAPA);
		String cursoId = ParamUtil
				.getString(request, Constantes.PARAM_CURSO_ID);
		String participanteId = ParamUtil.getString(request,
				Constantes.PARAM_PARTICIPANTE_ID);
		String acao = "A";
		String modoAdm = ParamUtil.getString(request, Constantes.MODO_ADM);

		CursoParticipante cursoParticipante = null;
		if (Validator.isNotNull(participanteId) && !"0".equals(participanteId)) {
			// Recuperar o participante
			cursoParticipante = CursoParticipanteLocalServiceUtil
					.fetchCursoParticipante(GetterUtil.getLong(participanteId));
		}
		if (Validator.isNull(cursoParticipante)) {
			cursoParticipante = new CursoParticipanteImpl();
			cursoParticipante.setInscricaoId(GetterUtil.getLong(inscricaoId));
			acao = "I";
		}

		// Atribuir dados do request no objeto Curso Participante
		cursoParticipante.setNomeCompleto(ParamUtil.getString(request,
				Constantes.PROP_NOME_COMPLETO));
		cursoParticipante.setNomeCracha(ParamUtil.getString(request,
				Constantes.PROP_NOME_CRACHA));
		cursoParticipante.setCpf(ParamUtil.getString(request,
				Constantes.PROP_CPF));
		cursoParticipante.setSexo(ParamUtil.getString(request,
				Constantes.PROP_SEXO));

		cursoParticipante.setFormacaoAcademica(ParamUtil.getString(request,
				Constantes.PROP_FORMACAO_ACADEMICA));
		cursoParticipante.setCargo(ParamUtil.getString(request,
				Constantes.PROP_CARGO));
		cursoParticipante.setDepartamento(ParamUtil.getString(request,
				Constantes.PROP_DEPARTAMENTO));

		cursoParticipante.setEmailPrincipal(ParamUtil.getString(request,
				Constantes.PROP_EMAIL_PRINCIPAL));
		cursoParticipante.setEmailOpcional(ParamUtil.getString(request,
				Constantes.PROP_EMAIL_OPCIONAL));
		cursoParticipante.setDddTelefoneComercial(ParamUtil.getString(request,
				Constantes.PROP_DDD_TELEFONE_PRINCIPAL));
		cursoParticipante.setTelefoneComercial(ParamUtil.getString(request,
				Constantes.PROP_TELEFONE_PRINCIPAL));
		cursoParticipante.setDddTelefonePessoal(ParamUtil.getString(request,
				Constantes.PROP_DDD_TELEFONE_SECUNDARIO));
		cursoParticipante.setTelefonePessoal(ParamUtil.getString(request,
				Constantes.PROP_TELEFONE_SECUNDARIO));
		cursoParticipante.setDddTelefoneCelular(ParamUtil.getString(request,
				Constantes.PROP_DDD_TELEFONE_CELULAR));
		cursoParticipante.setTelefoneCelular(ParamUtil.getString(request,
				Constantes.PROP_TELEFONE_CELULAR));

		cursoParticipante.setEndereco(ParamUtil.getString(request,
				Constantes.PROP_ENDERECO));
		cursoParticipante.setBairro(ParamUtil.getString(request,
				Constantes.PROP_BAIRRO));
		cursoParticipante.setCidade(ParamUtil.getString(request,
				Constantes.PROP_CIDADE));
		cursoParticipante.setEstado(ParamUtil.getString(request,
				Constantes.PROP_ESTADO));
		cursoParticipante.setCep(ParamUtil.getString(request,
				Constantes.PROP_CEP));

		cursoParticipante.setExpectativaCurso(ParamUtil.getString(request,
				Constantes.PROP_EXPECTATIVA_CURSO));
		cursoParticipante.setObservacao(ParamUtil.getString(request,
				Constantes.PROP_OBSERVACAO));

		// Recuperar a inscrição
		CursoInscricao cursoInscricao = CursoInscricaoLocalServiceUtil
				.fetchCursoInscricao(GetterUtil.getLong(inscricaoId));

		// Valor pago
		String paramValorPago = ParamUtil.getString(request, "valorPago");
		String valorPago = "";
		HttpServletRequest httpRequest = PortalUtil
				.getHttpServletRequest(request);

		if ("preco".equals(paramValorPago)) {
			valorPago = Search.recuperarAtributo(httpRequest,
					cursoInscricao.getCursoId(), Constantes.PRECO);
		} else if ("precoConvenio".equals(paramValorPago)) {
			valorPago = Search.recuperarAtributo(httpRequest,
					cursoInscricao.getCursoId(), Constantes.PRECO_CONVENIO);
		} else if ("precoAssociado".equals(paramValorPago)) {
			valorPago = Search.recuperarAtributo(httpRequest,
					cursoInscricao.getCursoId(), Constantes.PRECO_ASSOCIADO);
		}

		cursoParticipante.setValorPago(valorPago);

		// Recuperar inscrição cnpj
		CursoInscricaoCnpj cursoInscricaoCnpj = InscricaoUtil
				.recuperarInscricaoCnpjPorInscricao(inscricaoId);

		List<String> errors = new ArrayList<String>();
		if (Validacao.validarEtapa04CNPJ(cursoParticipante, errors)) {
			if (Constantes.INCLUIR.equals(acao)) {
				// Recuperar o participante com o cpf e inscrição
				CursoParticipante cursoParticipanteResultado = InscricaoUtil
						.recuperarParticipantePorInscricaoCpf(
								cursoParticipante.getInscricaoId(),
								cursoParticipante.getCpf());
				if (Validator.isNotNull(cursoParticipanteResultado)) {
					SessionErrors.add(request,
							Constantes.MSG_ERRO_CPF_JA_CADASTRADO_CURSO);
					response.setRenderParameter(Constantes.HOUVE_ERRO,
							Constantes.S);
				} else {
					// incluir participante
					cursoParticipante = CursoParticipanteLocalServiceUtil
							.addCursoParticipante(cursoParticipante);
				}
			} else {
				// Atualizar participante
				cursoParticipante = CursoParticipanteLocalServiceUtil
						.updateCursoParticipante(cursoParticipante);
			}
		} else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			response.setRenderParameter(Constantes.HOUVE_ERRO, Constantes.S);
		}
		// Atribuir no parameter os objetos
		response.setRenderParameter(Constantes.PARAM_INSCRICAO_ID, inscricaoId);
		response.setRenderParameter(Constantes.PARAM_CURSO_ID, cursoId);
		response.setRenderParameter(Constantes.PROP_ETAPA, etapa);
		response.setRenderParameter(Constantes.MODO_ADM, modoAdm);

		// Atribui no request o objeto CursoInscricao
		request.setAttribute(Constantes.CURSO_INSCRICAO, cursoInscricao);

		// Atribui no request o objeto cursoInscricaoCnpj
		request.setAttribute(Constantes.CURSO_INSCRICAO_CNPJ,
				cursoInscricaoCnpj);

		// Atribui no request o objeto cursoParticipante
		request.setAttribute(Constantes.CURSO_PARTICIPANTE, cursoParticipante);
	}

	public void finalizarEtapas(ActionRequest request, ActionResponse response)
			throws Exception {
		// Recuperar objetos do request
		String inscricaoId = ParamUtil.getString(request,
				Constantes.PARAM_INSCRICAO_ID);
		String etapa = ParamUtil.getString(request, Constantes.PROP_ETAPA);
		String cursoId = ParamUtil
				.getString(request, Constantes.PARAM_CURSO_ID);
		String modoAdm = ParamUtil.getString(request, Constantes.MODO_ADM);

		// Recuperar a inscrição
		CursoInscricao cursoInscricao = CursoInscricaoLocalServiceUtil
				.fetchCursoInscricao(GetterUtil.getLong(inscricaoId));

		// Recuperar os dados da nota fiscal do participante pela
		// inscrição
		CursoInscricaoCpf cursoInscricaoCpf = InscricaoUtil
				.recuperarInscricaoCpfPorInscricao(inscricaoId);

		CursoInscricaoCnpj cursoInscricaoCnpj = InscricaoUtil
				.recuperarInscricaoCnpjPorInscricao(inscricaoId);

		if (Validator.isNotNull(cursoInscricao)) {
			String formaPagamento = ParamUtil.getString(request,
					Constantes.PROP_FORMA_PAGAMENTO);
			String quantidadeParcelas = ParamUtil.getString(request,
					Constantes.PROP_QTDE_PARCELAS);
			String valorBoleto = ParamUtil.getString(request,
					Constantes.PROP_VALOR_BOLETO);
			String numeroCartao = ParamUtil.getString(request,
					Constantes.PROP_NUMERO_CARTAO);
			String validadeCartaoMes = ParamUtil.getString(request,
					Constantes.PROP_VALIDADE_CARTAO_MES);
			String validadeCartaoAno = ParamUtil.getString(request,
					Constantes.PROP_VALIDADE_CARTAO_ANO);
			String nomeTitularCartao = ParamUtil.getString(request,
					Constantes.PROP_NOME_TITULAR_CARTAO);
			String codigoSegurancaCartao = ParamUtil.getString(request,
					Constantes.PROP_CODIGO_SEGURANCA_CARTAO);

			cursoInscricao.setFormaPagamento(formaPagamento);
			cursoInscricao.setQuantidadeParcelas(GetterUtil
					.getInteger(quantidadeParcelas));
			cursoInscricao.setValorTotal(GetterUtil.getDouble(valorBoleto));
			if ((!Constantes.ITAU_BOLETO.equals(formaPagamento))
					&& (!Constantes.CREDITO_CONTA.equals(formaPagamento))) {
				cursoInscricao.setNumeroCartao(numeroCartao);
				cursoInscricao.setValidadeCartaoMes(GetterUtil
						.getInteger(validadeCartaoMes));
				cursoInscricao.setValidadeCartaoAno(GetterUtil
						.getInteger(validadeCartaoAno));
				cursoInscricao.setNomeTitularCartao(nomeTitularCartao);
				cursoInscricao.setCodigoSegurancaCartao(codigoSegurancaCartao);
			}

			List<String> errors = new ArrayList<String>();

			if (Validacao.validarEtapaFormaPagamento(cursoInscricao, errors)) {
				try {
					// Atualizar dados de inscriao
					cursoInscricao = CursoInscricaoLocalServiceUtil
							.updateCursoInscricao(cursoInscricao);

					if (!Constantes.CREDITO_CONTA.equals(formaPagamento)) {
						String statusMoedaDigital = enviarParaMoedaDigital(
								request, response, cursoInscricao, errors);
						// String statusMoedaDigital =
						// Constantes.MOEDA_DIGITAL_REPROVADO;Constantes.MOEDA_DIGITAL_APROVADO;
						cursoInscricao
								.setStatusMoedaDigital(statusMoedaDigital);
						if ((!Constantes.MOEDA_DIGITAL_REPROVADO
								.equals(statusMoedaDigital))
								&& (!Constantes.MOEDA_DIGITAL_CANCELADO
										.equals(statusMoedaDigital))
								&& (!Constantes.MOEDA_DIGITAL_NEGADO
										.equals(statusMoedaDigital))) {
							if (Constantes.ITAU_BOLETO.equals(formaPagamento)) {
								cursoInscricao
										.setNumeroCartao(StringPool.BLANK);
								cursoInscricao.setValidadeCartaoMes(GetterUtil
										.getInteger(0));
								cursoInscricao.setValidadeCartaoAno(GetterUtil
										.getInteger(0));
								cursoInscricao
										.setNomeTitularCartao(StringPool.BLANK);
								cursoInscricao
										.setCodigoSegurancaCartao(StringPool.BLANK);
							}

							finalizarEtapas(request, response, cursoInscricao);
						} else {
							errors.add("mensagem.erro.envioAprovacaoCartao");
							if (Constantes.MOEDA_DIGITAL_NEGADO
									.equals(statusMoedaDigital)) {
								errors.add("mensagem.erro.pedidoNegado");
							}
							if (Constantes.MOEDA_DIGITAL_REPROVADO
									.equals(statusMoedaDigital)) {
								errors.add("mensagem.erro.pedidoReprovado");
							}
							if (Constantes.MOEDA_DIGITAL_CANCELADO
									.equals(statusMoedaDigital)) {
								errors.add("mensagem.erro.pedidoCancelado");
							}
							for (String error : errors) {
								SessionErrors.add(request, error);
							}
							response.setRenderParameter(Constantes.HOUVE_ERRO,
									Constantes.S);
						}
					} else {
						cursoInscricao.setNumeroCartao(StringPool.BLANK);
						cursoInscricao.setValidadeCartaoMes(GetterUtil
								.getInteger(0));
						cursoInscricao.setValidadeCartaoAno(GetterUtil
								.getInteger(0));
						cursoInscricao.setNomeTitularCartao(StringPool.BLANK);
						cursoInscricao
								.setCodigoSegurancaCartao(StringPool.BLANK);
						cursoInscricao.setStatusMoedaDigital(StringPool.BLANK);

						finalizarEtapas(request, response, cursoInscricao);
					}
				} catch (Exception e) {
					errors.add("mensagem.erro.envioAprovacaoCartao");
					for (String error : errors) {
						SessionErrors.add(request, error);
					}
					response.setRenderParameter(Constantes.HOUVE_ERRO,
							Constantes.S);
				}
			} else {
				for (String error : errors) {
					SessionErrors.add(request, error);
				}
				response.setRenderParameter(Constantes.HOUVE_ERRO, Constantes.S);
			}
		}

		// Atribuir no parameter os objetos
		response.setRenderParameter(Constantes.PARAM_INSCRICAO_ID, inscricaoId);
		response.setRenderParameter(Constantes.PARAM_CURSO_ID, cursoId);
		response.setRenderParameter(Constantes.PROP_ETAPA, etapa);
		response.setRenderParameter(Constantes.MODO_ADM, modoAdm);

		// Atribui no request o objeto CursoInscricao
		request.setAttribute(Constantes.CURSO_INSCRICAO, cursoInscricao);

		// Atribui no request o objeto cursoParticipante
		request.setAttribute(Constantes.CURSO_INSCRICAO_CPF, cursoInscricaoCpf);

		request.setAttribute(Constantes.CURSO_INSCRICAO_CNPJ,
				cursoInscricaoCnpj);

	}

	private CursoParticipante adicionarParticipante(
			CursoInscricao cursoInscricao, String inscricaoId,
			boolean responsavelParticipante) throws Exception {
		// Recuperar os dados do participante pela inscrição
		CursoParticipante cursoParticipante = InscricaoUtil
				.recuperarParticipantePorInscricao(inscricaoId);
		// Se não tiver cadastrado//incluir com os dados da pessoa que iniciou
		// a
		// inscrição
		if (Validator.isNull(cursoParticipante)) {
			cursoParticipante = new CursoParticipanteImpl();
			cursoParticipante.setInscricaoId(GetterUtil.getLong(inscricaoId));

			if (responsavelParticipante) {
				if (Constantes.PESSOA_FISICA.equals(cursoInscricao
						.getTipoFisicaJuridica())) {
					cursoParticipante.setCpf(cursoInscricao.getCpfCnpj());
					cursoParticipante.setNomeCompleto(cursoInscricao
							.getNomeResponsavel());
					cursoParticipante.setSexo(cursoInscricao.getSexo());
					cursoParticipante.setDddTelefoneComercial(cursoInscricao
							.getDddTelefoneComercial());
					cursoParticipante.setTelefoneComercial(cursoInscricao
							.getTelefoneComercial());
					cursoParticipante.setEmailPrincipal(cursoInscricao
							.getEmailPrincipal());
				} else {
					cursoParticipante.setNomeCompleto(cursoInscricao
							.getNomeResponsavel());
					cursoParticipante.setSexo(cursoInscricao.getSexo());
					cursoParticipante.setDddTelefoneComercial(cursoInscricao
							.getDddTelefoneComercial());
					cursoParticipante.setTelefoneComercial(cursoInscricao
							.getTelefoneComercial());
					cursoParticipante.setEmailPrincipal(cursoInscricao
							.getEmailPrincipal());
				}
			}

			// Adicionar no banco de dados
			cursoParticipante = CursoParticipanteLocalServiceUtil
					.addCursoParticipante(cursoParticipante);
		}

		return cursoParticipante;
	}

	public void prepararNovoParticipante(ActionRequest request,
			ActionResponse response) throws Exception {
		// Recuperar objetos do request
		String inscricaoId = ParamUtil.getString(request,
				Constantes.PARAM_INSCRICAO_ID);
		String etapa = Constantes.TRES;
		String cursoId = ParamUtil
				.getString(request, Constantes.PARAM_CURSO_ID);
		String modoAdm = ParamUtil.getString(request, Constantes.MODO_ADM);

		// Recuperar a inscrição
		CursoInscricao cursoInscricao = CursoInscricaoLocalServiceUtil
				.fetchCursoInscricao(GetterUtil.getLong(inscricaoId));

		// Recuperar inscrição cnpj
		CursoInscricaoCnpj cursoInscricaoCnpj = InscricaoUtil
				.recuperarInscricaoCnpjPorInscricao(inscricaoId);

		CursoParticipante cursoParticipante = new CursoParticipanteImpl();

		// Atribuir no parameter os objetos
		response.setRenderParameter(Constantes.PARAM_INSCRICAO_ID, inscricaoId);
		response.setRenderParameter(Constantes.PARAM_CURSO_ID, cursoId);
		response.setRenderParameter(Constantes.PROP_ETAPA, etapa);
		response.setRenderParameter(Constantes.MODO_ADM, modoAdm);

		// Atribui no request o objeto CursoInscricao
		request.setAttribute(Constantes.CURSO_INSCRICAO, cursoInscricao);

		// Atribui no request o objeto cursoParticipante
		request.setAttribute(Constantes.CURSO_PARTICIPANTE, cursoParticipante);

		// Atribui no request o objeto cursoInscricaoCnpj
		request.setAttribute(Constantes.CURSO_INSCRICAO_CNPJ,
				cursoInscricaoCnpj);
	}

	public void prepararAlteracaoParticipante(ActionRequest request,
			ActionResponse response) throws Exception {
		// Recuperar objetos do request
		String inscricaoId = ParamUtil.getString(request,
				Constantes.PARAM_INSCRICAO_ID);
		String etapa = Constantes.TRES;
		String participanteId = ParamUtil.getString(request,
				Constantes.PARAM_PARTICIPANTE_ID);
		String modoAdm = ParamUtil.getString(request, Constantes.MODO_ADM);

		// Recuperar a inscrição
		CursoInscricao cursoInscricao = CursoInscricaoLocalServiceUtil
				.fetchCursoInscricao(GetterUtil.getLong(inscricaoId));

		// Recuperar o participante
		CursoParticipante cursoParticipante = CursoParticipanteLocalServiceUtil
				.fetchCursoParticipante(GetterUtil.getLong(participanteId));

		// Recuperar inscrição cnpj
		CursoInscricaoCnpj cursoInscricaoCnpj = InscricaoUtil
				.recuperarInscricaoCnpjPorInscricao(inscricaoId);

		// Atribuir no parameter os objetos
		response.setRenderParameter(Constantes.PARAM_INSCRICAO_ID, inscricaoId);
		response.setRenderParameter(Constantes.PARAM_CURSO_ID,
				String.valueOf(cursoInscricao.getCursoId()));
		response.setRenderParameter(Constantes.PROP_ETAPA, etapa);
		response.setRenderParameter(Constantes.MODO_ADM, modoAdm);

		// Atribui no request o objeto CursoInscricao
		request.setAttribute(Constantes.CURSO_INSCRICAO, cursoInscricao);

		// Atribui no request o objeto cursoParticipante
		request.setAttribute(Constantes.CURSO_PARTICIPANTE, cursoParticipante);

		// Atribui no request o objeto cursoInscricaoCnpj
		request.setAttribute(Constantes.CURSO_INSCRICAO_CNPJ,
				cursoInscricaoCnpj);

	}

	public void excluirCursoParticipante(ActionRequest request,
			ActionResponse response) throws Exception {
		// Recuperar objetos do request
		String inscricaoId = ParamUtil.getString(request,
				Constantes.PARAM_INSCRICAO_ID);
		String etapa = Constantes.QUATRO;
		String participanteId = ParamUtil.getString(request,
				Constantes.PARAM_PARTICIPANTE_ID);
		String modoAdm = ParamUtil.getString(request, Constantes.MODO_ADM);

		// Recuperar a inscrição
		CursoInscricao cursoInscricao = CursoInscricaoLocalServiceUtil
				.fetchCursoInscricao(GetterUtil.getLong(inscricaoId));

		// Excluir o participante
		CursoParticipanteLocalServiceUtil.deleteCursoParticipante(GetterUtil
				.getLong(participanteId));

		// Recuperar inscrição cnpj
		CursoInscricaoCnpj cursoInscricaoCnpj = InscricaoUtil
				.recuperarInscricaoCnpjPorInscricao(inscricaoId);

		// Atribuir no parameter os objetos
		response.setRenderParameter(Constantes.PARAM_INSCRICAO_ID, inscricaoId);
		response.setRenderParameter(Constantes.PARAM_CURSO_ID,
				String.valueOf(cursoInscricao.getCursoId()));
		response.setRenderParameter(Constantes.PROP_ETAPA, etapa);
		response.setRenderParameter(Constantes.MODO_ADM, modoAdm);

		// Atribui no request o objeto CursoInscricao
		request.setAttribute(Constantes.CURSO_INSCRICAO, cursoInscricao);

		// Atribui no request o objeto cursoInscricaoCnpj
		request.setAttribute(Constantes.CURSO_INSCRICAO_CNPJ,
				cursoInscricaoCnpj);
	}

	public void avancarEtapa05CNPJ(ActionRequest request,
			ActionResponse response) throws Exception {
		// Recuperar objetos do request
		String inscricaoId = ParamUtil.getString(request,
				Constantes.PARAM_INSCRICAO_ID);
		String etapa = ParamUtil.getString(request, Constantes.PROP_ETAPA);
		String cursoId = ParamUtil
				.getString(request, Constantes.PARAM_CURSO_ID);
		String modoAdm = ParamUtil.getString(request, Constantes.MODO_ADM);
		String participanteId = ParamUtil.getString(request,
				Constantes.PARAM_PARTICIPANTE_ID);

		// Recuperar a inscrição
		CursoInscricao cursoInscricao = CursoInscricaoLocalServiceUtil
				.fetchCursoInscricao(GetterUtil.getLong(inscricaoId));

		// Recuperar inscrição cnpj
		CursoInscricaoCnpj cursoInscricaoCnpj = InscricaoUtil
				.recuperarInscricaoCnpjPorInscricao(inscricaoId);

		// Recuperar o participante
		CursoParticipante cursoParticipante = CursoParticipanteLocalServiceUtil
				.fetchCursoParticipante(GetterUtil.getLong(participanteId));

		// Atribuir no parameter os objetos
		response.setRenderParameter(Constantes.PARAM_INSCRICAO_ID, inscricaoId);
		response.setRenderParameter(Constantes.PARAM_CURSO_ID, cursoId);
		response.setRenderParameter(Constantes.PROP_ETAPA, etapa);
		response.setRenderParameter(Constantes.MODO_ADM, modoAdm);

		// Atribui no request o objeto CursoInscricao
		request.setAttribute(Constantes.CURSO_INSCRICAO, cursoInscricao);
		request.setAttribute(Constantes.CURSO_INSCRICAO_CNPJ,
				cursoInscricaoCnpj);

		// Atribui no request o objeto cursoParticipante
		request.setAttribute(Constantes.CURSO_PARTICIPANTE, cursoParticipante);

	}

	public void filtrar(ActionRequest request, ActionResponse response)
			throws Exception {
		// Recuperar objetos do request
		String tipoFiltro = ParamUtil
				.getString(request, Constantes.TIPO_FILTRO);
		String filtro = ParamUtil.getString(request, Constantes.FILTRO);

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		List<CursoInscricao> listaCursoInscricao = null;
		if ((Constantes.TIPO_FILTRO_CPF.equals(tipoFiltro))
				|| (Constantes.TIPO_FILTRO_CNPJ.equals(tipoFiltro))) {
			listaCursoInscricao = InscricaoUtil
					.recuperarListaInscricaoPorCpfCnpj(themeDisplay, filtro);
		} else if (Constantes.TIPO_FILTRO_CURSO.equals(tipoFiltro)) {
			listaCursoInscricao = InscricaoUtil
					.recuperarListaInscricaoPorCursoId(themeDisplay, filtro);
		} else if (Constantes.TIPO_FILTRO_NOME.equals(tipoFiltro)) {
			listaCursoInscricao = InscricaoUtil
					.recuperarListaInscricaoPorNomeResponsavel(themeDisplay,
							filtro);
		}

		// Atribui no request o objeto lista
		request.setAttribute(Constantes.LISTA_CURSO_INSCRICAO,
				listaCursoInscricao);

		if ((Constantes.TIPO_FILTRO_CPF.equals(tipoFiltro))) {
			response.setRenderParameter(Constantes.FILTRO_CPF, filtro);
		} else if ((Constantes.TIPO_FILTRO_CNPJ.equals(tipoFiltro))) {
			response.setRenderParameter(Constantes.FILTRO_CNPJ, filtro);
		} else if ((Constantes.TIPO_FILTRO_CURSO.equals(tipoFiltro))) {
			response.setRenderParameter(Constantes.FILTRO_CURSO, filtro);
		} else if ((Constantes.TIPO_FILTRO_NOME.equals(tipoFiltro))) {
			response.setRenderParameter(Constantes.FILTRO_NOME, filtro);
		}
	}

	public void prepararVisualizacaoInscricao(ActionRequest request,
			ActionResponse response) throws Exception {
		// Recuperar objetos do request
		String inscricaoId = ParamUtil.getString(request,
				Constantes.PARAM_INSCRICAO_ID);
		String participanteId = ParamUtil.getString(request,
				Constantes.PARAM_PARTICIPANTE_ID);
		String exibirDadosParticipante = ParamUtil.getString(request,
				Constantes.EXIBIR_DADOS_PARTICIPANTE);
		String etapa = Constantes.NOVE;

		// Recuperar a inscrição
		CursoInscricao cursoInscricao = CursoInscricaoLocalServiceUtil
				.fetchCursoInscricao(GetterUtil.getLong(inscricaoId));

		// Recuperar tipo de pessoa
		CursoInscricaoCpf cursoInscricaoCpf = null;
		CursoInscricaoCnpj cursoInscricaoCnpj = null;
		if (Constantes.PESSOA_FISICA.equals(cursoInscricao
				.getTipoFisicaJuridica())) {
			// Recuperar inscrição cpf
			cursoInscricaoCpf = InscricaoUtil
					.recuperarInscricaoCpfPorInscricao(inscricaoId);
		} else if (Constantes.PESSOA_JURIDICA.equals(cursoInscricao
				.getTipoFisicaJuridica())) {
			// Recuperar inscrição cnpj
			cursoInscricaoCnpj = InscricaoUtil
					.recuperarInscricaoCnpjPorInscricao(inscricaoId);
		}
		// Recuperar participantes
		List<CursoParticipante> listaParticipantes = InscricaoUtil
				.recuperarListaParticipantesPorInscricao(cursoInscricao
						.getInscricaoId());
		// Recuperar participante
		CursoParticipante cursoParticipante = null;
		if (Constantes.PESSOA_JURIDICA.equals(cursoInscricao
				.getTipoFisicaJuridica())) {
			cursoParticipante = CursoParticipanteLocalServiceUtil
					.fetchCursoParticipante(GetterUtil.getLong(participanteId));
			if (Validator.isNull(cursoParticipante)) {
				cursoParticipante = new CursoParticipanteImpl();
			}
		} else if (Constantes.PESSOA_FISICA.equals(cursoInscricao
				.getTipoFisicaJuridica())) {
			for (CursoParticipante cp : listaParticipantes) {
				cursoParticipante = cp;
			}
		}

		// Se objetos forem nulos//instanciar para não dar erro de leitura nos
		// formulários
		if (Validator.isNull(cursoInscricaoCpf)) {
			cursoInscricaoCpf = new CursoInscricaoCpfImpl();
		}
		if (Validator.isNull(cursoInscricaoCnpj)) {
			cursoInscricaoCnpj = new CursoInscricaoCnpjImpl();
		}
		if (Validator.isNull(cursoParticipante)) {
			cursoParticipante = new CursoParticipanteImpl();
		}
		// Atribuir no parameter os objetos
		response.setRenderParameter(Constantes.PARAM_INSCRICAO_ID, inscricaoId);
		response.setRenderParameter(Constantes.PROP_ETAPA, etapa);
		response.setRenderParameter(Constantes.MODO_ADM, Constantes.S);
		response.setRenderParameter(Constantes.EXIBIR_DADOS_PARTICIPANTE,
				exibirDadosParticipante);

		// Atribui no request o objeto CursoInscricao
		request.setAttribute(Constantes.CURSO_INSCRICAO, cursoInscricao);
		request.setAttribute(Constantes.CURSO_INSCRICAO_CPF, cursoInscricaoCpf);
		request.setAttribute(Constantes.CURSO_INSCRICAO_CNPJ,
				cursoInscricaoCnpj);
		request.setAttribute(Constantes.LISTA_CURSO_PARTICIPANTES,
				listaParticipantes);
		request.setAttribute(Constantes.CURSO_PARTICIPANTE, cursoParticipante);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		if ("exportarListaParticipantes"
				.equals(resourceRequest.getResourceID())) {

			try {
				String cursoId = ParamUtil
						.getString(resourceRequest, "cursoId");

				ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
						.getAttribute(WebKeys.THEME_DISPLAY);

				List<CursoInscricao> listaCursoInscricao = InscricaoUtil
						.recuperarListaInscricaoPorCursoId(themeDisplay,
								cursoId);

				StringBuilder csv = new StringBuilder();

				// Dados do participante
				csv.append("Primeiro Contato,Segundo contato,Numero da inscrição,Nome completo,Telefone principal,Telefone secundário,Telefone celular,Email principal,Email opcional,Endereço,Bairro,Cidade,Estado,CEP,Cargo,Departamento,Nome para crachá,CPF,Formação Acadêmica,Sexo,Expectativa,Observações,");
				// Dados da inscrição
				csv.append("Nome do responsável pela inscrição,Email principal,Telefone principal,Valor unitário,Valor total,Situação financeira,Vencimento,Observações,CNPJ,CPF,");
				// Dados da empresa
				csv.append("Razão Social,Nome fantasia,Nome para emissão da NF,Inscrição Estadual ou CF/DF,Endereço,Bairro,Cidade,Estado,CEP,");
				// Dados da NF
				csv.append("Nome do responsável pelo recebimento da NF,Departamento do responsável pelo recebimento da NF,E-mail do responsável pelo recebimento da NF,Telefone do responsável pelo recebimento da NF\n");

				for (CursoInscricao ci : listaCursoInscricao) {

					List<CursoParticipante> listaCursoParticipante = InscricaoUtil
							.recuperarListaParticipantesPorInscricao(ci
									.getInscricaoId());

					for (CursoParticipante cp : listaCursoParticipante) {

						CursoInscricaoCnpj ciCnpj = null;
						CursoInscricaoCpf ciCpf = null;

						if (Constantes.PESSOA_FISICA.equals(ci
								.getTipoFisicaJuridica())) {
							ciCpf = InscricaoUtil
									.recuperarInscricaoCpfPorInscricao(String
											.valueOf(ci.getInscricaoId()));
						} else if (Constantes.PESSOA_JURIDICA.equals(ci
								.getTipoFisicaJuridica())) {
							ciCnpj = InscricaoUtil
									.recuperarInscricaoCnpjPorInscricao(String
											.valueOf(ci.getInscricaoId()));
						}

						// Dados do participante
						// Primeiro Contato
						csv.append("" + ",");

						// Segundo contato
						csv.append("" + ",");

						// Numero da inscrição
						csv.append(ci.getInscricaoId() + ",");

						// Nome completo
						csv.append("\"" + cp.getNomeCompleto() + "\"" + ",");

						// Telefone principal
						csv.append("\"" + "(" + cp.getDddTelefoneComercial()
								+ ") " + cp.getTelefoneComercial() + "\"" + ",");

						// Telefone secundário
						csv.append("\"" + "(" + cp.getDddTelefonePessoal()
								+ ") " + cp.getTelefonePessoal() + "\"" + ",");

						// Telefone celular
						csv.append("\"" + "(" + cp.getDddTelefoneCelular()
								+ ") " + cp.getTelefoneCelular() + "\"" + ",");

						// Email principal
						csv.append("\"" + cp.getEmailPrincipal() + "\"" + ",");

						// Email opcional
						csv.append("\"" + cp.getEmailOpcional() + "\"" + ",");

						// Endereço
						String endereco;
						endereco = cp.getEndereco().replace("\"", "");
						csv.append("\"" + endereco + "\"" + ",");

						// Bairro
						csv.append("\"" + cp.getBairro() + "\"" + ",");

						// Cidade
						csv.append("\"" + cp.getCidade() + "\"" + ",");

						// Estado
						csv.append("\"" + cp.getEstado() + "\"" + ",");

						// CEP
						csv.append("\"" + cp.getCep() + "\"" + ",");

						// Cargo
						csv.append("\"" + cp.getCargo() + "\"" + ",");

						// Departamento
						csv.append("\"" + cp.getDepartamento() + "\"" + ",");

						// Nome para cachá
						csv.append("\"" + cp.getNomeCracha() + "\"" + ",");

						// CPF
						csv.append("\"" + cp.getCpf() + "\"" + ",");

						// Formação Acadêmica
						csv.append("\"" + cp.getFormacaoAcademica() + "\""
								+ ",");

						// Sexo
						csv.append("\"" + cp.getSexo() + "\"" + ",");

						// Expectativa
						String expectativa = cp.getExpectativaCurso();
						expectativa = expectativa.replace("\r\n", " ").replace(
								"\n", " ");
						csv.append("\"" + expectativa + "\"" + ",");

						// Observações
						String observacao = cp.getObservacao();
						observacao = observacao.replace("\r\n", " ").replace(
								"\n", " ");
						csv.append("\"" + observacao + "\"" + ",");

						// Dados da inscrição
						// Nome do responsável pela inscrição
						csv.append("\"" + ci.getNomeResponsavel() + "\"" + ",");

						// Email principal
						csv.append("\"" + ci.getEmailPrincipal() + "\"" + ",");

						// Telefone principal
						csv.append("\"" + "(" + ci.getDddTelefoneComercial()
								+ ")" + ci.getTelefoneComercial() + "\"" + ",");

						// Valor unitario
						csv.append("\"" + cp.getValorPago() + "\"" + ",");

						// Valor total
						csv.append("" + ",");

						// Situação financeira
						csv.append("" + ",");

						// Vencimento
						csv.append("" + ",");

						// Observações
						if (ciCpf != null) {
							String observacaoCpf = ciCpf.getObservacao();
							observacaoCpf = observacaoCpf.replace("\r\n", " ")
									.replace("\n", " ");
							csv.append("\"" + observacaoCpf + "\"" + ",");
						} else if (ciCnpj != null) {
							String observacaoCnpj = ciCnpj.getObservacao();
							observacaoCnpj = observacaoCnpj
									.replace("\r\n", " ").replace("\n", " ");
							csv.append("\"" + observacaoCnpj + "\"" + ",");
						}

						// CNPJ
						if (ciCpf != null) {
							csv.append("" + ",");
						} else if (ciCnpj != null) {
							csv.append("\"" + ci.getCpfCnpj() + "\"" + ",");
						}

						// CPF
						if (ciCpf != null) {
							csv.append("\"" + ci.getCpfCnpj() + "\"" + ",");
						} else if (ciCnpj != null) {
							csv.append("" + ",");
						}

						// Dados da empresa
						// Razão Social
						if (ciCpf != null) {
							csv.append("" + ",");
						} else if (ciCnpj != null) {
							csv.append("\"" + ciCnpj.getRazaoSocial() + "\""
									+ ",");
						}

						// Nome fantasia
						if (ciCpf != null) {
							csv.append("\"" + cp.getEmpresaOndeTrabalha()
									+ "\"" + ",");
						} else if (ciCnpj != null) {
							csv.append("\"" + ciCnpj.getNomeFantasia() + "\""
									+ ",");
						}

						// Nome para emissão da NF
						if (ciCpf != null) {
							csv.append("\"" + ciCpf.getNome() + "\"" + ",");
						} else if (ciCnpj != null) {
							csv.append("\"" + ciCnpj.getNfNome() + "\"" + ",");
						}

						// Inscrição Estadual ou CF/DF
						if (ciCpf != null) {
							csv.append("" + ",");
						} else if (ciCnpj != null) {
							csv.append("\"" + ciCnpj.getInscricaoEstadual()
									+ "\"" + ",");
						}

						// Endereço
						String enderecoCpf, enderecoCnpj;
						if (ciCpf != null) {
							enderecoCpf = ciCpf.getEndereco().replace("\"", "");
							csv.append("\"" + enderecoCpf + "\"" + ",");
						} else if (ciCnpj != null) {
							enderecoCnpj = ciCnpj.getEndereco().replace("\"",
									"");
							csv.append("\"" + enderecoCnpj + "\"" + ",");
						}

						// Bairro
						if (ciCpf != null) {
							csv.append("\"" + ciCpf.getBairro() + "\"" + ",");
						} else if (ciCnpj != null) {
							csv.append("\"" + ciCnpj.getBairro() + "\"" + ",");
						}

						// Cidade
						if (ciCpf != null) {
							csv.append("\"" + ciCpf.getCidade() + "\"" + ",");
						} else if (ciCnpj != null) {
							csv.append("\"" + ciCnpj.getCidade() + "\"" + ",");
						}

						// Estado
						if (ciCpf != null) {
							csv.append("\"" + ciCpf.getEstado() + "\"" + ",");
						} else if (ciCnpj != null) {
							csv.append("\"" + ciCnpj.getEstado() + "\"" + ",");
						}

						// CEP
						if (ciCpf != null) {
							csv.append("\"" + ciCpf.getCep() + "\"" + ",");
						} else if (ciCnpj != null) {
							csv.append("\"" + ciCnpj.getCep() + "\"" + ",");
						}

						// Dados da NF

						// Nome do responsável pelo recebimento da NF
						if (ciCpf != null) {
							csv.append("\"" + ciCpf.getNome() + "\"" + ",");
						} else if (ciCnpj != null) {
							csv.append("\"" + ciCnpj.getNfNome() + "\"" + ",");
						}

						// Departamento do responsável pelo recebimento da NF
						if (ciCpf != null) {
							csv.append("\"" + ciCpf.getDepartamento() + "\""
									+ ",");
						} else if (ciCnpj != null) {
							csv.append("\"" + ciCnpj.getNfDepartamento() + "\""
									+ ",");
						}

						// E-mail do responsável pelo recebimento da NF
						if (ciCpf != null) {
							csv.append("\"" + ciCpf.getEmail() + "\"" + ",");
						} else if (ciCnpj != null) {
							csv.append("\"" + ciCnpj.getNfEmail() + "\"" + ",");
						}

						// Telefone do responsável pelo recebimento da NF
						if (ciCpf != null) {
							csv.append("\"" + "(" + ciCpf.getDddTelefone()
									+ ") " + ciCpf.getTelefone() + "\"" + ",");
						} else if (ciCnpj != null) {
							csv.append("\"" + "(" + ciCnpj.getNfDddTelefone()
									+ ") " + ciCnpj.getNfTelefone() + "\"");
						}

						csv.append("\n");
					}
				}

				if (!listaCursoInscricao.isEmpty()) {
					resourceResponse.setCharacterEncoding("UTF-16LE");

					resourceResponse.setContentType("text/csv");
					resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL,
							"max-age=3600, must-revalidate");
					resourceResponse.addProperty(
							HttpHeaders.CONTENT_DISPOSITION,
							"attachment; filename="
									+ cursoId
									+ "-"
									+ SEAUtils.slugify(listaCursoInscricao.get(
											0).getCursoNome()) + ".csv");
					resourceResponse
							.setContentLength(csv.toString().getBytes().length);

					OutputStream out = resourceResponse
							.getPortletOutputStream();

					out.write(csv.toString().getBytes(
							Charset.forName("UTF-16LE")));

					out.flush();
					out.close();
				}

			} catch (SystemException e) {
				SessionErrors.add(resourceRequest, "erro-exportacao-csv");
				e.printStackTrace();
			} catch (Exception e) {
				SessionErrors.add(resourceRequest, "erro-exportacao-csv");
				e.printStackTrace();
			}
		}

		super.serveResource(resourceRequest, resourceResponse);
	}

	private void enviarEmailParaParticipante(PortletRequest request,
			String nomeRemetente, String enderecoRemetente,
			CursoInscricao inscricao, CursoParticipante participante)
			throws Exception {
		StringBuilder corpoEmail = new StringBuilder();

		// Cabecalho
		// StringWriter writerCabecalho = new StringWriter();
		String velocityTemplateIdCabecalho = "/cabecalho_email_externo.vm";
		String cabecalhoEmailExterno = leituraArquivo(velocityTemplateIdCabecalho);

		String dataParcela = Search.recuperarAtributo(
				PortalUtil.getHttpServletRequest(request),
				inscricao.getCursoId(), Constantes.PREFIX + "data-parcela");
		String linkMapa = Search.recuperarAtributo(
				PortalUtil.getHttpServletRequest(request),
				inscricao.getCursoId(), Constantes.PREFIX + "link-mapa");

		cabecalhoEmailExterno = cabecalhoEmailExterno.replace(
				"$participante.getNomeCompleto()",
				participante.getNomeCompleto());
		cabecalhoEmailExterno = cabecalhoEmailExterno.replace(
				"$inscricao.getCursoNome()", inscricao.getCursoNome());
		cabecalhoEmailExterno = cabecalhoEmailExterno.replace(
				"$inscricao.getCursoData()", inscricao.getCursoData());
		cabecalhoEmailExterno = cabecalhoEmailExterno.replace(
				"$inscricao.getCursoHorario()", inscricao.getCursoHorario());
		cabecalhoEmailExterno = cabecalhoEmailExterno.replace(
				"$inscricao.getCursoLocal()", inscricao.getCursoLocal());
		cabecalhoEmailExterno = cabecalhoEmailExterno.replace(
				"$participante.getValorPago()", participante.getValorPago());
		cabecalhoEmailExterno = cabecalhoEmailExterno.replace("$dataParcela",
				HtmlUtil.stripHtml(dataParcela));
		cabecalhoEmailExterno = cabecalhoEmailExterno.replace("$linkMapa",
				linkMapa);

		// Dar uma olhada em
		// https://github.com/liferay/liferay-plugins/commit/37800e8e5ecdc81357890f2f5a4e93414b2c9e86#diff-2

		// VelocityContext velocityContextCabecalho =
		// VelocityEngineUtil.getRestrictedToolsContext();
		// String velocityTemplateContentCabecalho = StringUtil.read(getClass()
		// .getClassLoader(), velocityTemplateIdCabecalho);

		// velocityContextCabecalho.put("inscricao", inscricao);
		// velocityContextCabecalho.put("participante", participante);
		// velocityContextCabecalho.put("dataParcela",
		// HtmlUtil.stripHtml(dataParcela));
		// velocityContextCabecalho.put("linkMapa", linkMapa);
		//
		// VelocityEngineUtil.mergeTemplate(velocityTemplateIdCabecalho,
		// velocityTemplateContentCabecalho, velocityContextCabecalho,
		// writerCabecalho);

		corpoEmail.append(cabecalhoEmailExterno);

		// Corpo
		// StringWriter writer = new StringWriter();
		String velocityTemplateId = "";

		if (Constantes.PESSOA_FISICA.equals(inscricao.getTipoFisicaJuridica())) {
			velocityTemplateId = "/email_inscricao_cpf.vm";
		} else if (Constantes.PESSOA_JURIDICA.equals(inscricao
				.getTipoFisicaJuridica())) {
			velocityTemplateId = "/email_inscricao_cnpj.vm";
		}

		// String velocityTemplateContent = StringUtil.read(getClass()
		// .getClassLoader(), velocityTemplateId);
		// VelocityContext velocityContext = VelocityEngineUtil
		// .getRestrictedToolsContext();
		// TemplateResource corpoResource =
		// TemplateResourceLoaderUtil.getTemplateResource("vm",
		// velocityTemplateId);
		// Template corpoTemplate = TemplateManagerUtil.getTemplate("velocity",
		// corpoResource, true);

		// velocityContext.put("inscricao", inscricao);
		// velocityContext.put("participante", participante);

		String emailDetalheInscricao = leituraArquivo(velocityTemplateId);

		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$inscricao.getCursoId()", inscricao.getCursoId() + "");
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$inscricao.getCursoNome()", inscricao.getCursoNome());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$inscricao.getNomeResponsavel()",
				inscricao.getNomeResponsavel());
		emailDetalheInscricao = emailDetalheInscricao
				.replace("$inscricao.getEmailPrincipal()",
						inscricao.getEmailPrincipal());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$inscricao.getDddTelefoneComercial()",
				inscricao.getDddTelefoneComercial());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$inscricao.getTelefoneComercial()",
				inscricao.getTelefoneComercial());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$inscricao.getCpfCnpj()", inscricao.getCpfCnpj());

		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getParticipanteId()",
				participante.getParticipanteId() + "");
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getNomeCompleto()",
				participante.getNomeCompleto());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getSexo()", participante.getSexo());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getCpf()", participante.getCpf());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getEmailPrincipal()",
				participante.getEmailPrincipal());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getDddTelefoneComercial()",
				participante.getDddTelefoneComercial());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getTelefoneComercial()",
				participante.getTelefoneComercial());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getDddTelefoneCelular()",
				participante.getDddTelefoneCelular());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getTelefoneCelular()",
				participante.getTelefoneCelular());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getFormacaoAcademica()",
				participante.getFormacaoAcademica());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getEmpresaOndeTrabalha()",
				participante.getEmpresaOndeTrabalha());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getNomeCracha()", participante.getNomeCracha());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getCargo()", participante.getCargo());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getDepartamento()",
				participante.getDepartamento());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getEndereco()", participante.getEndereco());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getBairro()", participante.getBairro());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getCidade()", participante.getCidade());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getEstado()", participante.getEstado());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getCep()", participante.getCep());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getExpectativaCurso()",
				participante.getExpectativaCurso());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getObservacao()", participante.getObservacao());
		emailDetalheInscricao = emailDetalheInscricao.replace(
				"$participante.getValorPago()", participante.getValorPago());

		if (Constantes.PESSOA_FISICA.equals(inscricao.getTipoFisicaJuridica())) {
			List<CursoInscricaoCpf> listaCiCpf = InscricaoUtil
					.recuperarListaCursoInscricaoCpfPorInscricao(inscricao
							.getInscricaoId());
			// velocityContext.put("ciCpf", listaCiCpf.get(0));
			CursoInscricaoCpf ciCpf = listaCiCpf.get(0);
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCpf.getNome()", ciCpf.getNome());
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCpf.getCpf()", ciCpf.getCpf());
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCpf.getEndereco()", ciCpf.getEndereco());
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCpf.getBairro()", ciCpf.getBairro());
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCpf.getCidade()", ciCpf.getCidade());
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCpf.getEstado()", ciCpf.getEstado());
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCpf.getCep()", ciCpf.getCep());
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCpf.getEmail()", ciCpf.getEmail());
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCpf.getDddTelefone()", ciCpf.getDddTelefone());
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCpf.getTelefone()", ciCpf.getTelefone());
		} else if (Constantes.PESSOA_JURIDICA.equals(inscricao
				.getTipoFisicaJuridica())) {
			List<CursoInscricaoCnpj> listaCiCnpj = InscricaoUtil
					.recuperarListaCursoInscricaoCnpjPorInscricao(inscricao
							.getInscricaoId());
			// velocityContext.put("ciCnpj", listaCiCnpj.get(0));
			CursoInscricaoCnpj ciCnpj = listaCiCnpj.get(0);
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCnpj.getNomeFantasia()", ciCnpj.getNomeFantasia());
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCnpj.getRazaoSocial()", ciCnpj.getRazaoSocial());
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCnpj.getInscricaoEstadual()",
					ciCnpj.getInscricaoEstadual());
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCnpj.getEndereco()", ciCnpj.getEndereco());
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCnpj.getBairro()", ciCnpj.getBairro());
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCnpj.getCidade()", ciCnpj.getCidade());
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCnpj.getEstado()", ciCnpj.getEstado());
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCnpj.getCep()", ciCnpj.getCep());
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCnpj.getNfNome()", ciCnpj.getNfNome());
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCnpj.getNfDepartamento()", ciCnpj.getNfDepartamento());
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCnpj.getNfEmail()", ciCnpj.getNfEmail());
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCnpj.getNfDddTelefone()", ciCnpj.getNfDddTelefone());
			emailDetalheInscricao = emailDetalheInscricao.replace(
					"$ciCnpj.getNfTelefone()", ciCnpj.getNfTelefone());
		}

		// VelocityEngineUtil.mergeTemplate(velocityTemplateId,
		// velocityTemplateContent, velocityContext, writer);

		corpoEmail.append(System.getProperty("line.separator"));
		// corpoEmail.append(writer.toString());
		// String corpoEmailInterno = writer.toString();

		corpoEmail.append(emailDetalheInscricao);

		InternetAddress remetente = new InternetAddress(enderecoRemetente,
				nomeRemetente);

		List<MailMessage> mensagens = new ArrayList<MailMessage>();

		String enderecarPara = Search.recuperarAtributo(
				PortalUtil.getHttpServletRequest(request),
				inscricao.getCursoId(), Constantes.PREFIX + "enderecar-para");

		for (String endereco : enderecarPara.split(StringPool.COMMA)) {
			InternetAddress destinatarioInterno = new InternetAddress(
					endereco.trim(), "");
			MailMessage mensagem = new MailMessage(remetente,
					destinatarioInterno, "Inscrição no curso "
							+ inscricao.getCursoNome(), emailDetalheInscricao,
					true);
			mensagens.add(mensagem);
		}

		// Montagem do email interno
		InternetAddress destinatarioInterno = new InternetAddress(
				enderecoRemetente, nomeRemetente);
		MailMessage mensagemInterna = new MailMessage(remetente,
				destinatarioInterno, "Inscrição no curso "
						+ inscricao.getCursoNome(), emailDetalheInscricao, true);
		mensagens.add(mensagemInterna);

		// Montagem do email externo
		InternetAddress destinatario = new InternetAddress(
				participante.getEmailPrincipal(),
				participante.getNomeCompleto());
		MailMessage mensagem = new MailMessage(remetente, destinatario,
				"Inscrição no curso " + inscricao.getCursoNome(),
				corpoEmail.toString(), true);
		mensagens.add(mensagem);

		if (Constantes.PESSOA_JURIDICA
				.equals(inscricao.getTipoFisicaJuridica())) {
			InternetAddress destinatarioResponsavel = new InternetAddress(
					inscricao.getEmailPrincipal(),
					inscricao.getNomeResponsavel());
			MailMessage mensagemResponsavel = new MailMessage(remetente,
					destinatarioResponsavel, "Inscrição no curso "
							+ inscricao.getCursoNome(), corpoEmail.toString(),
					true);
			mensagens.add(mensagemResponsavel);
		}

		// Envio dos emails
		for (MailMessage mailMessage : mensagens) {
			MailServiceUtil.sendEmail(mailMessage);
		}
	}


	private void enviarEmailParaResponsavel(PortletRequest request, CursoInscricao cursoInscricao)
			throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		PortletPreferences portletPreferences = request.getPreferences();
		String emailResponsavel = ParamUtil.getString(request, Constantes.PREF_EMAIL_RESPONSAVEL, InscricaoUtil.getEmailResponsavelPreferencia(portletPreferences, themeDisplay.getCompanyId()));

		String nomeRemetente = portletPreferences.getValue("emailRemetenteNome", "Cursos CNF");
		String enderecoRemetente = portletPreferences.getValue("emailRemetenteEndereco", "cursos.eventos@cnf.org");

		String conteudoCurso = FriendlyURLNormalizerUtil.normalize(cursoInscricao.getCursoNome());
		String linkConteudo = themeDisplay.getURLHome()+"curso/-/asset_publisher/u40JOqzZws5j/content/"+conteudoCurso;
		// + themeDisplay.getURLCurrent();
		
		StringBuilder corpoEmail = new StringBuilder();

		// Cabecalho
		String velocityTemplateIdCabecalho = "/cabecalho_email_responsavel.vm";
		String cabecalhoEmailResponsavel = leituraArquivo(velocityTemplateIdCabecalho);

		cabecalhoEmailResponsavel = cabecalhoEmailResponsavel.replace(
				"$inscricao.getCursoNome()", cursoInscricao.getCursoNome());
		cabecalhoEmailResponsavel = cabecalhoEmailResponsavel.replace("$linkConteudo",
				linkConteudo);
		
		corpoEmail.append(cabecalhoEmailResponsavel);

		InternetAddress remetente = new InternetAddress(enderecoRemetente,
				nomeRemetente);

		List<MailMessage> mensagens = new ArrayList<MailMessage>();

		InternetAddress destinatario = new InternetAddress(
				emailResponsavel.trim(), "");
		MailMessage mensagem = new MailMessage(remetente,
				destinatario, "Curso "
						+ cursoInscricao.getCursoNome(), corpoEmail.toString(),
				true);
		mensagens.add(mensagem);


		// Envio dos emails
		for (MailMessage mailMessage : mensagens) {
			MailServiceUtil.sendEmail(mailMessage);
		}
	}

	
	private String leituraArquivo(String file) throws IOException {
		URL url = getClass().getClassLoader().getResource(file);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream()));

		StringBuffer buffer = new StringBuffer();

		String inputLine;
		while ((inputLine = in.readLine()) != null)
			buffer.append(inputLine + "\n");
		in.close();
		return buffer.toString();
	}

	public void salvarPreferencias(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		String emailRemetenteNome = ParamUtil.getString(actionRequest,
				"emailRemetenteNome");
		String emailRemetenteEndereco = ParamUtil.getString(actionRequest,
				"emailRemetenteEndereco");

		PortletPreferences prefs = actionRequest.getPreferences();

		prefs.setValue("emailRemetenteNome", emailRemetenteNome);
		prefs.setValue("emailRemetenteEndereco", emailRemetenteEndereco);
		prefs.store();
	}

	private String enviarParaMoedaDigital(ActionRequest actionRequest,
			ActionResponse actionResponse, CursoInscricao cursoInscricao,
			List<String> errors) throws Exception {
		
		String moedaDigitalToken = PortletProps.get("moeda.digital.token");
		String moedaDigitalAplicacao = PortletProps
				.get("moeda.digital.aplicacao");

		RetornoPedido retornoPedido = MoedaDigitalUtil.envioCartao(cursoInscricao,
				moedaDigitalToken, moedaDigitalAplicacao);
		String retorno = retornoPedido.getPedidoStatus();
		if (Constantes.ITAU_BOLETO.equals(cursoInscricao.getFormaPagamento())) {
			try {
				String moedaDigitalPedido = MoedaDigitalUtil
						.recuperarIdPedido(retornoPedido.getConteudo());
				// Atualiza dados de inscrião
				cursoInscricao.setMoedaDigitalPedido(moedaDigitalPedido);
				cursoInscricao = CursoInscricaoLocalServiceUtil
						.updateCursoInscricao(cursoInscricao);

				actionResponse.setRenderParameter(
						Constantes.MOEDA_DIGITAL_PEDIDO_ID, moedaDigitalPedido);
			} catch (Exception e) {
				errors.add("mensagem.erro.idBoleto");
				for (String error : errors) {
					SessionErrors.add(actionRequest, error);
				}
				actionResponse.setRenderParameter(Constantes.HOUVE_ERRO,
						Constantes.S);
				throw new Exception();
			}
		}
		
		//String retorno = Constantes.MOEDA_DIGITAL_APROVADO;
		return retorno;
	}

	private void finalizarEtapas(ActionRequest actionRequest,
			ActionResponse actionResponse, CursoInscricao cursoInscricao)
			throws Exception {

		// Atualiza dados de inscrião
		cursoInscricao.setCadastroFinalizado(true);
		cursoInscricao = CursoInscricaoLocalServiceUtil
				.updateCursoInscricao(cursoInscricao);

		try {
			PortletPreferences prefs = actionRequest.getPreferences();

			List<CursoParticipante> listaParticipante = InscricaoUtil
					.recuperarListaParticipantesPorInscricao(cursoInscricao
							.getInscricaoId());
			for (CursoParticipante cursoParticipante : listaParticipante) {
				// Envia email para o participante
				enviarEmailParaParticipante(actionRequest, prefs.getValue(
						"emailRemetenteNome", "Cursos CNF"), prefs.getValue(
						"emailRemetenteEndereco", "cursos.eventos@cnf.org"),
						cursoInscricao, cursoParticipante);
			}

		} catch (Exception e) {
			e.getMessage();
		}

		SessionMessages.add(actionRequest, "mensagem.aviso.sucesso");
	}
}
