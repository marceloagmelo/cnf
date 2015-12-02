<%@ include file="/html/init.jsp"%>
<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	CursoInscricao cursoInscricao = (CursoInscricao) row.getObject();
	String cursoId = String.valueOf(cursoInscricao.getCursoId());
	String primKey = String.valueOf(cursoInscricao.getPrimaryKey());

	boolean showViewIcon = PortletPermissionUtil.contains(
			permissionChecker, layout, portletDisplay.getId(),
			ActionKeys.VIEW);
%>

<liferay-ui:icon-menu>

	<c:if test="<%=showViewIcon%>">

		<portlet:actionURL name="prepararVisualizacaoInscricao" var="visualizarURL">
			<portlet:param name="inscricaoId" value="<%=primKey%>" />
			<portlet:param name="cursoId" value="<%=cursoId%>" />
		</portlet:actionURL>

		<liferay-ui:icon image="view" method="post" url="<%=visualizarURL.toString()%>" message="visualizar" />

	</c:if>

</liferay-ui:icon-menu>