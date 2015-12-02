<%@ include file="/html/init.jsp"%>
<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	CursoParticipante cursoParticipante = (CursoParticipante) row
			.getObject();
	String inscricaoId = String.valueOf(cursoParticipante.getInscricaoId());
	String primKey = String.valueOf(cursoParticipante.getPrimaryKey());
	
%>

<liferay-ui:icon-menu>

		<portlet:actionURL name="prepararAlteracaoParticipante" var="editURL">
			<portlet:param name="inscricaoId" value="<%=inscricaoId%>" />
			<portlet:param name="participanteId" value="<%=primKey%>" />
		</portlet:actionURL>

		<liferay-ui:icon image="edit" message="Editar" url="<%=editURL.toString()%>" />

		<portlet:actionURL name="excluirCursoParticipante" var="deleteURL">
			<portlet:param name="inscricaoId" value="<%=inscricaoId%>" />
			<portlet:param name="participanteId" value="<%=primKey%>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" label="Remover" />

</liferay-ui:icon-menu>