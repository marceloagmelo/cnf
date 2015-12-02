<div class="bloco-titulo">
	
	<h1><liferay-ui:message key="label.listaParticipantes" /></h1>

	<liferay-ui:search-container emptyResultsMessage="mensagem.aviso.naoExistemParticipantes" delta="100">
		<liferay-ui:search-container-results>
			<%
				results = ListUtil.subList(listaCursoParticipante, searchContainer.getStart(), searchContainer.getEnd());
				total = listaCursoParticipante.size();
				pageContext.setAttribute("results", results);
				pageContext.setAttribute("total", total);
			%>
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row className="br.com.cnf.curso.inscricao.model.CursoParticipante" keyProperty="participanteId" modelVar="participante">
			<%@ include file="colunasParticipante.jsp"%>
			<liferay-ui:search-container-column-jsp align="right" path="/html/cursoinscricaocadastroportlet/acoesParticipanteVisualizar.jsp" />
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>
