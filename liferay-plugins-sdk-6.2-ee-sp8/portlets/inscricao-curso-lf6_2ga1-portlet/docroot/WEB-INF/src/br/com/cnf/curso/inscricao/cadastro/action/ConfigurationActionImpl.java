package br.com.cnf.curso.inscricao.cadastro.action;

import br.com.cnf.curso.inscricao.util.Helper;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

public class ConfigurationActionImpl extends DefaultConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		validarCampos(actionRequest);

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	protected void validarCampos(ActionRequest actionRequest) throws Exception {

		String moedaDigitalUrlBoleto = getParameter(actionRequest,
				"moedaDigitalUrlBoleto");
		String paramDiasBoleto = getParameter(actionRequest,
				"paramDiasBoleto");
		String emailResponsavel = getParameter(actionRequest,
				"emailResponsavel");

		if (Validator.isNull(moedaDigitalUrlBoleto)) {
			SessionErrors.add(actionRequest, "moedaDigitalUrlBoletoObrigatorio");
		}
		if (Validator.isNull(paramDiasBoleto)) {
			SessionErrors.add(actionRequest, "paramDiasBoletoObrigatorio");
		} else {
			if (!Helper.isInteger(paramDiasBoleto)) {
				SessionErrors.add(actionRequest, "paramDiasBoletoNaoNumerico");
			}
		}
		if (Validator.isNull(emailResponsavel)) {
			SessionErrors.add(actionRequest, "emailResponsagelObrigatorio");
		} else {
			if (!Helper.isEmail(emailResponsavel)) {
				SessionErrors.add(actionRequest, "emailResponsagelInvalido");
			}
		}
	}
}
