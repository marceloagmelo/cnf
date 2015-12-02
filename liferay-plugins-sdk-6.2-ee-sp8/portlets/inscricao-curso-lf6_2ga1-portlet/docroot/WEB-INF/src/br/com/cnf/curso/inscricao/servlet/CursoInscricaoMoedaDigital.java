package br.com.cnf.curso.inscricao.servlet;

import br.com.cnf.curso.inscricao.model.CursoInscricao;
import br.com.cnf.curso.inscricao.service.CursoInscricaoLocalServiceUtil;
import br.com.cnf.curso.inscricao.util.MoedaDigitalUtil;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.portlet.PortletProps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CursoInscricaoMoedaDigital extends HttpServlet {

	private static final Log _log = LogFactory
			.getLog(CursoInscricaoMoedaDigital.class);

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			_log.info("Inicio da execucao da URL de status do pedido.");
			String pedido = (String) request.getParameter("Pedido");

			String moedaDigitalToken = PortletProps.get("moeda.digital.token");
			String moedaDigitalAplicacao = PortletProps
					.get("moeda.digital.aplicacao");
			String parametroInvalido = PortletProps.get("parametro.invalido");
			String pedidoNaoEncontrado = PortletProps
					.get("pedido.naoEncontrado");

			String statusMoedaDigital = "";

			// Set response content type
			response.setContentType("text/html");

			PrintWriter out = response.getWriter();
			String title = "Retorno do Pedido";
			String docType = "<!doctype html public \"-//w3c//dtd html 4.0 "
					+ "transitional//en\">\n";

			if (Validator.isNotNull(pedido)) {
				CursoInscricao cursoInscricao = CursoInscricaoLocalServiceUtil
						.fetchCursoInscricao(GetterUtil.getLong(pedido));
				if (Validator.isNotNull(cursoInscricao)) {
					// Recupera o status na base da moeda digital
					statusMoedaDigital = MoedaDigitalUtil.consultarStatusPagamento(
							moedaDigitalToken, moedaDigitalAplicacao, pedido);
					if (Validator.isNotNull(statusMoedaDigital)) {
						if ((!statusMoedaDigital.equals(cursoInscricao
								.getStatusMoedaDigital()))) {
							cursoInscricao
									.setStatusMoedaDigital(statusMoedaDigital);
							// Atualiza status na base
							cursoInscricao = CursoInscricaoLocalServiceUtil
									.updateCursoInscricao(cursoInscricao);
							_log.info("CursoInscricaoServlet: Pedido "
									+ cursoInscricao.getInscricaoId()
									+ " atualizado.");
						}
					} else {
						statusMoedaDigital = pedidoNaoEncontrado;
						_log.info("Pedido nao encontrado.");
					}
				} else {
					statusMoedaDigital = pedidoNaoEncontrado;

					_log.info("Pedido nao encontrado.");
				}

				out.println(docType + "<html>\n" + "<head><title>" + title
						+ "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
						+ "<h1 align=\"center\">" + title + "</h1>\n"
						+ "<ul>\n" + "  <li><b>Pedido</b>: " + pedido + "\n"
						+ "  <li><b>Status</b>: " + statusMoedaDigital + "\n"
						+ "</ul>\n" + "</body></html>");
			} else {
				out.println(docType + "<html>\n" + "<head><title>" + title
						+ "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
						+ "<h1 align=\"center\">" + title + "</h1>\n"
						+ "<ul>\n" + "  <li><b>" + parametroInvalido + "</b>"
						+ "</body></html>");

				_log.error("CursoInscricaoServlet: Parametro invalido.");
			}
			_log.info("Fim da execucao da URL de status do pedido.");
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}
}
