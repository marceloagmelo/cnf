<div class="curso_inscricao">
	
	<div class="bloco-titulo">
			<h1><liferay-ui:message key="label.dadosMoedaDigital" /></h1>
			
		<p>
			<label for="status">
				<liferay-ui:message key="label.statusMoedaDigital" />
				<liferay-ui:message key="label.separador" />
			</label>
			<aui:input useNamespace="no" name="statusMoedaDigital" id="statusMoedaDigital" label="" value="<%=cursoInscricao.getStatusMoedaDigital()%>" disabled="true" />
		</p>
	
		<p>
			<label for="status">
				<liferay-ui:message key="label.formaPagamento" />
				<liferay-ui:message key="label.separador" />
			</label>
			<aui:input useNamespace="no" name="label.formaPagamento" id="label.formaPagamento" label="" value="<%=cursoInscricao.getFormaPagamento()%>" disabled="true" />
		</p>

		<%
		String moedaDigitalUrlBoleto = ParamUtil.getString(request, Constantes.PREF_MOEDA_DIGITAL_URL_BOLETO, InscricaoUtil.getMoedaDigitalUrlBoletoPreferencia(portletPreferences, company.getCompanyId()));
		
		moedaDigitalUrlBoleto = moedaDigitalUrlBoleto + cursoInscricao.getMoedaDigitalPedido();

		if (Constantes.ITAU_BOLETO.equals(cursoInscricao.getFormaPagamento())) {
		%>
		<p>
			<label for="boleto">
				<liferay-ui:message key="label.imprimir.boleto" />
				<liferay-ui:message key="label.separador" />
			</label>
			<a href="<%=moedaDigitalUrlBoleto %>" target="_blank">
				<img src="https://www.moedadigital.net/Imagens/Bandeiras/boleto.png"/> 
			</a>
		</p>
		
		<%
		}
		%>
	</div>
	
</div>
