<%@ include file="/html/init.jsp"%>
<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	CursoParticipante cursoParticipante = (CursoParticipante) row.getObject();
	String inscricaoId = String.valueOf(cursoParticipante.getInscricaoId());
	String primKey = String.valueOf(cursoParticipante.getPrimaryKey());

	boolean showViewIcon = PortletPermissionUtil.contains(permissionChecker, layout, portletDisplay.getId(), ActionKeys.VIEW);
%>

<liferay-ui:icon-menu>

	<c:if test="<%=showViewIcon%>">

		<portlet:actionURL name="prepararVisualizacaoInscricao"
			var="visualizarURL">
			<portlet:param name="participanteId" value="<%=primKey%>" />
			<portlet:param name="inscricaoId" value="<%=inscricaoId%>" />
			<portlet:param name="exibirDadosParticipante" value="<%=Constantes.S%>" />
		</portlet:actionURL>

		<liferay-ui:icon image="view" method="post" message="visualizar" url="<%=visualizarURL.toString()%>" />

	</c:if>

</liferay-ui:icon-menu>