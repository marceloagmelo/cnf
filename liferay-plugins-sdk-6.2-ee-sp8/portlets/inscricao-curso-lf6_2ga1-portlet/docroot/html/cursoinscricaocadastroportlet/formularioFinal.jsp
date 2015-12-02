<%@ include file="/html/init.jsp"%>

<%
	CursoInscricao cursoInscricao = (CursoInscricao) request.getAttribute(Constantes.CURSO_INSCRICAO);
	CursoInscricaoCnpj cursoInscricaoCnpj = (CursoInscricaoCnpj) request.getAttribute(Constantes.CURSO_INSCRICAO_CNPJ);
	
	String moedaDigitalUrlBoleto = ParamUtil.getString(request, Constantes.PREF_MOEDA_DIGITAL_URL_BOLETO, InscricaoUtil.getMoedaDigitalUrlBoletoPreferencia(portletPreferences, company.getCompanyId()));
	
	moedaDigitalUrlBoleto = moedaDigitalUrlBoleto + cursoInscricao.getMoedaDigitalPedido();
%>

<liferay-ui:success key="mensagem.aviso.sucesso" message="mensagem.aviso.sucesso" />

<div class="curso_inscricao">
	<%@ include file="header.jspf"%>

	<div class="bloco-titulo">
			<h1><liferay-ui:message key="label.dadosInscricao" /></h1>
			
			<p>
			<strong><liferay-ui:message key="label.numeroInscricao" /><liferay-ui:message key="label.separador" /></strong> <%=cursoInscricao.getInscricaoId()%>
		
			<br/>
			
			<%
				if (Constantes.PESSOA_FISICA.equals(cursoInscricao.getTipoFisicaJuridica())) {
			%>
				<strong><liferay-ui:message key="label.cpf" /><liferay-ui:message key="label.separador" /></strong> <%=cursoInscricao.getCpfCnpj()%>
			<%
				} else {
			%>
				<strong><liferay-ui:message key="label.cnpj" /><liferay-ui:message key="label.separador" /></strong> <%=cursoInscricao.getCpfCnpj()%>
				<br/>
				<strong><liferay-ui:message key="label.razaoSocial" /><liferay-ui:message key="label.separador" /></strong> <%= cursoInscricaoCnpj.getRazaoSocial() %>
			<%
				}
			%>
			
			<br/>
			
			<strong><liferay-ui:message key="label.nomeResponsavelInscricao" /><liferay-ui:message key="label.separador" /></strong> <%=cursoInscricao.getNomeResponsavel()%>
		</p>
		
		<%
		if (Constantes.ITAU_BOLETO.equals(cursoInscricao.getFormaPagamento())) {
		%>
		<h2><liferay-ui:message key="label.imprimir.boleto" /></h2>
		
		<p>
			<a href="<%=moedaDigitalUrlBoleto %>" target="_blank">
				<img src="https://www.moedadigital.net/Imagens/Bandeiras/boleto.png"/> 
			</a>
		</p>
		<h2><liferay-ui:message key="label.informacoesPagamento" /></h2>
		
		<p>
			<liferay-ui:message key="mensagem.aviso.boleto" />
		</p>

		<h2><liferay-ui:message key="label.importante" /></h2>
		
		<p>
			<liferay-ui:message key="mensagem.aviso.final.boleto" />
		</p>
		<%
		}
		if (Constantes.CREDITO_CONTA.equals(cursoInscricao.getFormaPagamento())) {
		%>
		<h2><liferay-ui:message key="label.informacoesPagamento" /></h2>
		
		<p>
			<liferay-ui:message key="mensagem.aviso.creditoConta" />
		</p>
		<h2><liferay-ui:message key="label.importante" /></h2>
		
		<p>
			<liferay-ui:message key="mensagem.aviso.final.creditoConta" />
		</p>
		<%
		}
		if ((cursoInscricao.getFormaPagamento().indexOf("CIELO") != -1) || (cursoInscricao.getFormaPagamento().indexOf("REDECARD") != -1)) {
		%>
		<h2><liferay-ui:message key="label.importante" /></h2>
		
		<p>
			<liferay-ui:message key="mensagem.aviso.final.cartao" />
		</p>
		<%
		}
		%>
	</div>

	<%@ include file="footer.jspf"%>
</div>

<!-- Google Code for Inscri&ccedil;&atilde;o Finalizada Conversion Page -->
<script type="text/javascript">
	/* <![CDATA[ */
	var google_conversion_id = 1009592884;
	var google_conversion_language = "en";
	var google_conversion_format = "3";
	var google_conversion_color = "ffffff";
	var google_conversion_label = "04XbCPSn3wQQtNS04QM";
	var google_conversion_value = 0;
	/* ]]> */
</script>
<script type="text/javascript" src="http://www.googleadservices.com/pagead/conversion.js">
</script>
<noscript>
	<div style="display:inline;">
		<img height="1" width="1" style="border-style:none;" alt="" src="http://www.googleadservices.com/pagead/conversion/1009592884/?value=0&amp;label=04XbCPSn3wQQtNS04QM&amp;guid=ON&amp;script=0"/>
	</div>
</noscript>