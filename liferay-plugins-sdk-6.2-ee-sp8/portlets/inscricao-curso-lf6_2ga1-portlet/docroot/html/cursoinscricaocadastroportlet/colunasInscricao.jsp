<%@page import="java.io.PrintWriter"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="br.com.cnf.curso.inscricao.util.InscricaoUtil"%>
<%@page import="br.com.cnf.curso.inscricao.model.CursoParticipante"%>
<%@page pageEncoding="UTF-8"%>

<liferay-ui:search-container-column-text name="label.id" property="cursoId" />
<liferay-ui:search-container-column-text name="label.curso" property="cursoNome" />


<% if(cursoInscricao.isCadastroFinalizado()) { %>
	<liferay-ui:search-container-column-text name="label.statusCadastro">
		<liferay-ui:message key="label.cadastroFinalizado"/>
	</liferay-ui:search-container-column-text>
<% } else { %>
	<liferay-ui:search-container-column-text name="label.statusCadastro">
		<liferay-ui:message key="label.cadastroNaoFinalizado"/>
	</liferay-ui:search-container-column-text>
<% } %>

<liferay-ui:search-container-column-text name="label.nome" buffer="bufferNome" >

<%
List<CursoParticipante> cursoParticipantes = InscricaoUtil.recuperarListaParticipantesPorInscricao(cursoInscricao.getInscricaoId());
bufferNome.append("<ul>");
for(CursoParticipante participante : cursoParticipantes){
	bufferNome.append("<li>");
	bufferNome.append(participante.getNomeCompleto());
	bufferNome.append("</li>");
}
bufferNome.append("</ul>");
%>
</liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="label.dadosEmpresaTelefoneEmail" buffer="buffer">

<%
	
	CursoInscricaoCnpj cursoInscricaoCnpj = InscricaoUtil.recuperarInscricaoCnpjPorInscricao(String.valueOf(cursoInscricao.getInscricaoId()));
	if(cursoInscricaoCnpj != null) {
		if(cursoInscricaoCnpj.getNomeFantasia() == null || !"".equals(cursoInscricaoCnpj.getNomeFantasia())) {
			buffer.append("Nome da empresa: ");
			buffer.append(cursoInscricaoCnpj.getNomeFantasia());
		} else {
			buffer.append("Nome da empresa não informado.");
		}
		buffer.append("<br/>");
	}
	
	if(cursoInscricao.getTelefoneComercial() == null || !"".equals(cursoInscricao.getTelefoneComercial())) {
		buffer.append("Telefone: ");
		buffer.append("(");
		buffer.append(cursoInscricao.getDddTelefoneComercial());
		buffer.append(") ");
		buffer.append(cursoInscricao.getTelefoneComercial());
		
	} else {
		buffer.append("Telefone principal não informado.");
	}
	buffer.append("<br/>");
	
	if(cursoInscricao.getEmailPrincipal() == null || !"".equals(cursoInscricao.getEmailPrincipal())) {
		buffer.append("Email: ");
		buffer.append(cursoInscricao.getEmailPrincipal());
	} else {
		buffer.append("Email não informado.");
	}
%>
</liferay-ui:search-container-column-text>