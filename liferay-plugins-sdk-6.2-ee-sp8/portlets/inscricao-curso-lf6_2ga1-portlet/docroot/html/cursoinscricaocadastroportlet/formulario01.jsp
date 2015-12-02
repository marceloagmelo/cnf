<%@ include file="/html/init.jsp"%>

<%
	CursoInscricao cursoInscricao = (CursoInscricao) request
			.getAttribute(Constantes.CURSO_INSCRICAO);
%>

<portlet:actionURL name="avancarEtapa01" var="avancarURL" />

<liferay-ui:error key="mensagem.erro.cpf.obrigatorio" message="mensagem.erro.cpf.obrigatorio" />
<liferay-ui:error key="mensagem.erro.cnpj.obrigatorio" message="mensagem.erro.cnpj.obrigatorio" />
<liferay-ui:error key="mensagem.erro.cpf.invalido" message="mensagem.erro.cpf.invalido" />
<liferay-ui:error key="mensagem.erro.cnpj.invalido" message="mensagem.erro.cnpj.invalido" />
<liferay-ui:error key="mensagem.erro.inscricaoJaRealizadaCpf" message="mensagem.erro.inscricaoJaRealizadaCpf" />
<liferay-ui:error key="mensagem.erro.inscricaoJaRealizadaCnpj" message="mensagem.erro.inscricaoJaRealizadaCnpj" />

<div class="curso_inscricao">
	<%@ include file="header.jspf"%>
	<form name="<portlet:namespace />fm" action="<%=avancarURL%>" method="POST">
		<div class="bloco-titulo">
			<h2><liferay-ui:message key="label.cnpj" /></h2>
			
			<p>
				<liferay-ui:message key="label.iniciar.cnpj"/>
			</p>
			<p>
				<input type="text" name="<portlet:namespace/>cnpj" id="cnpj" value="${cnpj}">&nbsp;&nbsp;
				<input type="button" value="<liferay-ui:message key="botao.avancar"/>" onclick="javascript:avancarEtapa01(document.<portlet:namespace />fm, 'J')">
			</p>
			
			<h2><liferay-ui:message key="label.cpf" /></h2>
			
			<p>
				<liferay-ui:message key="label.iniciar.cpf"/>
			</p>
			<p>
				<input type="text" name="<portlet:namespace/>cpf" id="cpf" value="${cpf}">&nbsp;&nbsp;
				<input type="button" value="<liferay-ui:message key="botao.avancar"/>" onclick="javascript:avancarEtapa01(document.<portlet:namespace />fm, 'F')">
			</p>
		</div>
		
		<input type="hidden" name="<portlet:namespace/>cpfCnpj" id="cpfCnpj" value="<%=cursoInscricao.getCpfCnpj()%>" />
		<input type="hidden" name="<portlet:namespace/>cursoId" id="cursoId" value="<%=cursoInscricao.getCursoId()%>" />
		<input type="hidden" name="<portlet:namespace/>tipoFisicaJuridica" id="tipoFisicaJuridica" value="<%=cursoInscricao.getTipoFisicaJuridica()%>" />
		<input type="hidden" name="<portlet:namespace/>etapa" id="etapa" value="${etapa}" />
		<input type="hidden" name="<portlet:namespace/>modoAdm" id="modoAdm" value="${modoAdm}" />
	</form>
	<%@ include file="footer.jspf"%>
</div>