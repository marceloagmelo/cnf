<%@ include file="/html/init.jsp"%>

<liferay-ui:error key="mensagem.erro.dataInicioCurso.naoCadastrado" message="mensagem.erro.dataInicioCurso.naoCadastrado" />

<c:if test="<%= themeDisplay.isSignedIn() %>">

<%
	List<CursoInscricao> listaCursoInscricao = (List<CursoInscricao>) request.getAttribute(Constantes.LISTA_CURSO_INSCRICAO);
	if (listaCursoInscricao == null) {
		listaCursoInscricao = new ArrayList<CursoInscricao>();
	}
%>

<portlet:actionURL name="filtrar" var="filtrarURL" />

<div class="curso_inscricao">
	<form name="<portlet:namespace />fm" action="<%=filtrarURL%>" method="POST">
		<input type="hidden" name="<portlet:namespace/>filtro" id="filtro" value="" />
		<input type="hidden" name="<portlet:namespace/>tipoFiltro" id="tipoFiltro" value="" />
		
		<div class="bloco-titulo">
			<h1><liferay-ui:message key="label.opcoesBusca" /></h1>
			
			<h2><liferay-ui:message key="label.idCurso" /></h2>
			<p>
				<input type="text" name="<portlet:namespace/>filtroCurso" id="filtroCurso" value="${filtroCurso }">&nbsp;&nbsp; 
				<input type="button" value="<liferay-ui:message key="botao.buscar"/>" onclick="javascript:filtrar(document.<portlet:namespace />fm, 'C')">
			</p>
			
			<h2><liferay-ui:message key="label.cnpj" /></h2>
			<p>
				<input type="text" name="<portlet:namespace/>filtroCnpj" id="filtroCnpj" value="${filtroCnpj }">&nbsp;&nbsp;
				<input type="button" value="<liferay-ui:message key="botao.buscar"/>" onclick="javascript:filtrar(document.<portlet:namespace />fm, 'PJ')">
			</p>
			
			<h2><liferay-ui:message key="label.cpf" /></h2>
			<p>
				<input type="text" name="<portlet:namespace/>filtroCpf" id="filtroCpf" value="${filtroCpf }">&nbsp;&nbsp;
				<input type="button" value="<liferay-ui:message key="botao.buscar"/>" onclick="javascript:filtrar(document.<portlet:namespace />fm, 'PF')">
			</p>
			
			<h2><liferay-ui:message key="label.nomeResponsavelInscricao" /></h2>
			<p>
				<input type="text" name="<portlet:namespace/>filtroNomeResponsavel" id="filtroNomeResponsavel" value="${filtroNomeResponsavel }">&nbsp;&nbsp; 
				<input type="button" value="<liferay-ui:message key="botao.buscar"/>" onclick="javascript:filtrar(document.<portlet:namespace />fm, 'N')">
			</p>
			
			<input type="button" value="<liferay-ui:message key="botao.limpar"/>" onclick="javascript:avancar(document.<portlet:namespace />fm)">
			
			<p/>
			<hr/>
			
		</div>

		<h1><liferay-ui:message key="label.lista.inscricoes" /></h1>
		<c:if test="${filtroCurso ne ''}">
			<input type="button" id="botaoExportar" value="<liferay-ui:message key="botao.exportar"/>" onClick="location.href = '<portlet:resourceURL id="exportarListaParticipantes"><portlet:param name="cursoId" value="${filtroCurso}" /><portlet:param name="userAgent" value="" /></portlet:resourceURL>'" />
		</c:if>
		<liferay-ui:search-container emptyResultsMessage="mensagem.aviso.registrosNaoEncontrado" delta="50">
			<liferay-ui:search-container-results>
				<%
					total = listaCursoInscricao.size();
					results = ListUtil.subList(listaCursoInscricao, searchContainer.getStart(), searchContainer.getEnd());
					pageContext.setAttribute("results", results);
					pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="br.com.cnf.curso.inscricao.model.CursoInscricao" keyProperty="inscricaoId" modelVar="cursoInscricao">
				<%@ include file="colunasInscricao.jsp"%>
				<liferay-ui:search-container-column-jsp align="right" path="/html/cursoinscricaocadastroportlet/acoesInscricao.jsp" name="Visualizar" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</form>
</div>
</c:if>