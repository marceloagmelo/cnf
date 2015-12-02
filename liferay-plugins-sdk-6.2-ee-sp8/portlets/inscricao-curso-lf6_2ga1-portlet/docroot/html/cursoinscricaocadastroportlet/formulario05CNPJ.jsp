<%@ include file="/html/init.jsp"%>

<%
	CursoInscricao cursoInscricao = (CursoInscricao) request.getAttribute(Constantes.CURSO_INSCRICAO);

	List<CursoParticipante> listaCursoParticipante = (List<CursoParticipante>) request.getAttribute(Constantes.LISTA_CURSO_PARTICIPANTES);
	if (listaCursoParticipante == null) {
		listaCursoParticipante = new ArrayList<CursoParticipante>();
	}
	CursoInscricaoCnpj cursoInscricaoCnpj = (CursoInscricaoCnpj) request.getAttribute(Constantes.CURSO_INSCRICAO_CNPJ);

	String toolbarItem = ParamUtil.getString(request, "toolbarItem", "view-all");
%>
<portlet:actionURL name="avancarEtapa05CNPJ" var="avancarURL" />
	<portlet:actionURL name="prepararNovoParticipante" var="prepararNovoParticipanteURL">
	<portlet:param name="inscricaoId" value="<%=String.valueOf(cursoInscricao.getInscricaoId())%>" />
	<portlet:param name="cursoId" value="<%=String.valueOf(cursoInscricao.getCursoId())%>" />
</portlet:actionURL>

<div class="curso_inscricao">
	<%@ include file="header.jspf"%>

	<form name="<portlet:namespace />fm" action="<%=avancarURL%>" method="POST">
		<div class="bloco-titulo">
			<h1 class="verde-oliva"><liferay-ui:message key="label.quintaEtapaCNPJ" /></h1>
			
			<p>
				<strong><liferay-ui:message key="label.numeroInscricao" /><liferay-ui:message key="label.separador" /></strong> <%=cursoInscricao.getInscricaoId()%>
			<br/>
				<strong><liferay-ui:message key="label.cnpj" /><liferay-ui:message key="label.separador" /></strong> <%=cursoInscricao.getCpfCnpj()%>
			<br/>
				<strong><liferay-ui:message key="label.nomeEmpresa" /><liferay-ui:message key="label.separador" /></strong> <%=cursoInscricaoCnpj.getRazaoSocial()%>
			<br/>
				<strong><liferay-ui:message key="label.nomeResponsavelInscricao" /><liferay-ui:message key="label.separador" /></strong> <%=cursoInscricao.getNomeResponsavel()%>
			</p>
			
			<h2><liferay-ui:message key="label.listaParticipantes" /></h2>
			
				<div class="lfr-portlet-toolbar">
					<span class="lfr-toolbar-button add-button <%=toolbarItem.equals("add") ? "current" : StringPool.BLANK%>">
						<a href="<%=prepararNovoParticipanteURL%>"><liferay-ui:message key="botao.adicionarParticipante" /> </a>
					</span>
				</div>

				<liferay-ui:search-container emptyResultsMessage="mensagem.aviso.naoExistemParticipantes" delta="5">
					<liferay-ui:search-container-results>
						<%
							results = ListUtil.subList(listaCursoParticipante, searchContainer.getStart(), searchContainer.getEnd());
							total = listaCursoParticipante.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
						%>
					</liferay-ui:search-container-results>
					<liferay-ui:search-container-row className="br.com.cnf.curso.inscricao.model.CursoParticipante" keyProperty="participanteId" modelVar="participante">
						<liferay-ui:search-container-column-text name="label.nome" property="nomeCompleto" cssClass="largura-coluna-unica" />
						
						<% if(themeDisplay.isSignedIn()) { %>
							<liferay-ui:search-container-column-jsp align="right" path="/html/cursoinscricaocadastroportlet/acoesParticipante.jsp" cssClass="largura-coluna-acoes" />
						<% } %>
					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator />
				</liferay-ui:search-container>
	
				<p>
					<input type="button" value="<liferay-ui:message key="botao.avancar"/>" onclick="javascript:avancar(document.<portlet:namespace />fm)">
				</p>
				
		</div>
		
		<input type="hidden" name="<portlet:namespace />etapa" id="etapa" value="${etapa}" />
		<input type="hidden" name="<portlet:namespace />inscricaoId" id="inscricaoId" value="<%=cursoInscricao.getInscricaoId()%>" />
		<input type="hidden" name="<portlet:namespace />cursoId" id="cursoId" value="<%=cursoInscricao.getCursoId()%>" />
		<input type="hidden" name="<portlet:namespace />modoAdm" id="modoAdm" value="${modoAdm}" />
	</form>
		

		

	<%@ include file="footer.jspf"%>
</div>