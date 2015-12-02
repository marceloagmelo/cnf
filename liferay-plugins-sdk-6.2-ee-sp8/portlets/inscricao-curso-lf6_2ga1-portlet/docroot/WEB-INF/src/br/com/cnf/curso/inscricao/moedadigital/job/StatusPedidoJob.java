package br.com.cnf.curso.inscricao.moedadigital.job;

import br.com.cnf.curso.inscricao.Constantes;
import br.com.cnf.curso.inscricao.model.CursoInscricao;
import br.com.cnf.curso.inscricao.service.CursoInscricaoLocalServiceUtil;
import br.com.cnf.curso.inscricao.util.MoedaDigitalUtil;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.portlet.PortletProps;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StatusPedidoJob implements MessageListener {

	private static final Log _log = LogFactory.getLog(StatusPedidoJob.class);

	public void receive(Message arg0) throws MessageListenerException {

		try {
			String moedaDigitalToken = PortletProps.get("moeda.digital.token");
			String moedaDigitalAplicacao = PortletProps.get("moeda.digital.aplicacao");
			String jobStatusPedido = PortletProps.get("job.statusPedido");
			
			if (Boolean.getBoolean(jobStatusPedido)) {
				_log.error("Executou a recuperacao de status do pedido");

				List<CursoInscricao> lista = CursoInscricaoLocalServiceUtil
						.search(Constantes.MOEDA_DIGITAL_PENDENTE);
				for (CursoInscricao cursoInscricao : lista) {
					// Recupera o status na base da moeda digital
					String statusMoedaDigital = MoedaDigitalUtil
							.consultarStatusPagamento(
									moedaDigitalToken,
									moedaDigitalAplicacao,
									String.valueOf(cursoInscricao.getInscricaoId()));
					
					if ( (Validator.isNotNull(statusMoedaDigital)) && (!Constantes.MOEDA_DIGITAL_PENDENTE.equals(statusMoedaDigital)) ){
						// Atualiza status na base
						cursoInscricao.setStatusMoedaDigital(statusMoedaDigital);
						cursoInscricao = CursoInscricaoLocalServiceUtil
								.updateCursoInscricao(cursoInscricao);
						_log.info("Pedido "+ cursoInscricao.getInscricaoId() + " atualizado.");
					}
				}
				lista = CursoInscricaoLocalServiceUtil
						.search(Constantes.MOEDA_DIGITAL_EM_ANALISE);
				for (CursoInscricao cursoInscricao : lista) {
					// Recupera o status na base da moeda digital
					String statusMoedaDigital = MoedaDigitalUtil
							.consultarStatusPagamento(
									moedaDigitalToken,
									moedaDigitalAplicacao,
									String.valueOf(cursoInscricao.getInscricaoId()));

					if ( (Validator.isNotNull(statusMoedaDigital)) && (!Constantes.MOEDA_DIGITAL_EM_ANALISE.equals(statusMoedaDigital)) ){
						// Atualiza status na base
						cursoInscricao.setStatusMoedaDigital(statusMoedaDigital);
						cursoInscricao = CursoInscricaoLocalServiceUtil
								.updateCursoInscricao(cursoInscricao);
						_log.info("Pedido "+ cursoInscricao.getInscricaoId() + " atualizado.");
					}
				}
			}

		} catch (Exception e) {
			_log.error("Recuperando lista de pedidos pendentes - " + e.getMessage());
		}
	}

}
