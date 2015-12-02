<%@ include file="/html/init.jsp"%>
<%
	CursoInscricao cursoInscricao = (CursoInscricao) request
			.getAttribute(Constantes.CURSO_INSCRICAO);
	CursoParticipante cursoParticipante = (CursoParticipante) request
			.getAttribute(Constantes.CURSO_PARTICIPANTE);
	CursoInscricaoCnpj cursoInscricaoCnpj = (CursoInscricaoCnpj) request
			.getAttribute(Constantes.CURSO_INSCRICAO_CNPJ);
	CursoInscricaoCpf cursoInscricaoCpf = (CursoInscricaoCpf) request
			.getAttribute(Constantes.CURSO_INSCRICAO_CPF);
	List<CursoParticipante> listaCursoParticipante = (List<CursoParticipante>) request
			.getAttribute(Constantes.LISTA_CURSO_PARTICIPANTES);
	if (listaCursoParticipante == null) {
		listaCursoParticipante = new ArrayList<CursoParticipante>();
	}
	List<String> listaEstados = (List) request
			.getAttribute(Constantes.LISTA_ESTADOS);
	if (listaEstados == null) {
		listaEstados = new ArrayList<String>();
	}
	String exibirDadosParticipante = (String) request.getAttribute(Constantes.EXIBIR_DADOS_PARTICIPANTE);
%>
<c:choose>
	<c:when
		test="<%=Constantes.PESSOA_FISICA.equals(cursoInscricao
							.getTipoFisicaJuridica())%>">
		<%@ include file="visualizar02CPF.jsp"%>
	</c:when>
	<c:otherwise>
		<%@ include file="visualizar02CNPJ.jsp"%>
	</c:otherwise>
</c:choose>
<c:if
	test="<%=Constantes.PESSOA_FISICA.equals(cursoInscricao
						.getTipoFisicaJuridica())%>">
	<%@ include file="visualizar03CPF.jsp"%>
	<%@ include file="visualizar04CPF.jsp"%>
</c:if>
<c:if
	test="<%=Constantes.PESSOA_JURIDICA.equals(cursoInscricao
						.getTipoFisicaJuridica())%>">
	<%@ include file="visualizar03CNPJ.jsp"%>
<c:if
	test="<%=Constantes.S.equals(exibirDadosParticipante)%>">
	<%@ include file="visualizar04CNPJ.jsp"%>
</c:if>
	<%@ include file="visualizar05CNPJ.jsp"%>
</c:if>
<c:if
	test="<%=Validator.isNotNull(cursoInscricao.getStatusMoedaDigital())%>">
	<%@ include file="visualizarDadosMoedaDigital.jsp"%>
</c:if>
