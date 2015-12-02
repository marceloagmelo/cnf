<%@ include file="/html/init.jsp"%>

<%
String moedaDigitalUrlBoleto = ParamUtil.getString(request, Constantes.PREF_MOEDA_DIGITAL_URL_BOLETO, InscricaoUtil.getMoedaDigitalUrlBoletoPreferencia(portletPreferences, company.getCompanyId()));
String paramDiasBoleto = ParamUtil.getString(request, Constantes.PREF_PARAM_DIAS_BOLETO, InscricaoUtil.getParamDiasBoletoPreferencia(portletPreferences, company.getCompanyId()));
String emailResponsavel = ParamUtil.getString(request, Constantes.PREF_EMAIL_RESPONSAVEL, InscricaoUtil.getEmailResponsavelPreferencia(portletPreferences, company.getCompanyId()));
%>

<liferay-ui:success key="mensagem.portlet.configurado.sucesso"
	message="mensagem.portlet.configurado.sucesso" />


<liferay-portlet:actionURL portletConfiguration="true"
	var="configuracaoURL" />

<aui:form method="post" action="${configuracaoURL}" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<liferay-ui:error key="moedaDigitalUrlBoletoObrigatorio" message="mensagem.erro.moedaDigitalUrlBoleto.obrigatorio" />
	<liferay-ui:error key="paramDiasBoletoObrigatorio" message="mensagem.erro.paramDiasBoleto.obrigatorio" />
	<liferay-ui:error key="paramDiasBoletoNaoNumerico" message="mensagem.erro.paramDiasBoleto.naoNumerico" />
	<liferay-ui:error key="emailResponsagelObrigatorio" message="mensagem.erro.emailResponsavel.obrigatorio" />
	<liferay-ui:error key="emailResponsagelInvalido" message="mensagem.erro.emailResponsavel.invalido" />
	
	<aui:fieldset>
		<aui:input cssClass="lfr-input-text-container" label="label.moedaDigital.urlBoleto" name="<%=Constantes.PREF_MOEDA_DIGITAL_URL_BOLETO %>" value="<%= moedaDigitalUrlBoleto %>" />
		<aui:input cssClass="lfr-input-text-container" label="label.parametro.diasBoleto" name="<%=Constantes.PREF_PARAM_DIAS_BOLETO %>" value="<%= paramDiasBoleto %>" />
		<aui:input cssClass="lfr-input-text-container" label="label.email.responsavel" name="<%=Constantes.PREF_EMAIL_RESPONSAVEL %>" value="<%= emailResponsavel %>" />
	</aui:fieldset>
	
	<aui:button type="submit" />
</aui:form>
