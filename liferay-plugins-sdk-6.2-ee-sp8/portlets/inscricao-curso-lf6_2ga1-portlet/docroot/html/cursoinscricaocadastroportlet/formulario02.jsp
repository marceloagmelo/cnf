<%@ include file="/html/init.jsp"%>

<%
	CursoInscricao cursoInscricao = (CursoInscricao) request
			.getAttribute(Constantes.CURSO_INSCRICAO);
%>

<portlet:actionURL name="avancarEtapa02" var="avancarURL" />

<liferay-ui:error key="mensagem.erro.nomeResponsavelInscricao.obrigatorio" message="mensagem.erro.nomeResponsavelInscricao.obrigatorio" />
<liferay-ui:error key="mensagem.erro.nomeResponsavelInscricao.minimoDoisNomes" message="mensagem.erro.nomeResponsavelInscricao.minimoDoisNomes" />
<liferay-ui:error key="mensagem.erro.emailPrincipal.obrigatorio" message="mensagem.erro.emailPrincipal.obrigatorio" />
<liferay-ui:error key="mensagem.erro.emailPrincipal.invalido" message="mensagem.erro.emailPrincipal.invalido" />
<liferay-ui:error key="mensagem.erro.dddTelefoneComercial.obrigatorio" message="mensagem.erro.dddTelefoneComercial.obrigatorio" />
<liferay-ui:error key="mensagem.erro.dddTelefoneComercial.temQueSerNumerico" message="mensagem.erro.dddTelefoneComercial.temQueSerNumerico" />
<liferay-ui:error key="mensagem.erro.telefoneComercial.obrigatorio" message="mensagem.erro.telefoneComercial.obrigatorio" />
<liferay-ui:error key="mensagem.erro.telefoneComercial.temQueSerNumerico" message="mensagem.erro.telefoneComercial.temQueSerNumerico" />
<liferay-ui:error key="mensagem.erro.dddTelefonePessoal.obrigatorio" message="mensagem.erro.dddTelefonePessoal.obrigatorio" />
<liferay-ui:error key="mensagem.erro.telefonePessoal.obrigatorio" message="mensagem.erro.telefonePessoal.obrigatorio" />
<liferay-ui:error key="mensagem.erro.dddTelefonePessoal.temQueSerNumerico" message="mensagem.erro.dddTelefonePessoal.temQueSerNumerico" />
<liferay-ui:error key="mensagem.erro.telefonePessoal.temQueSerNumerico" message="mensagem.erro.telefonePessoal.temQueSerNumerico" />
<liferay-ui:error key="mensagem.erro.dddTelefoneCelular.obrigatorio" message="mensagem.erro.dddTelefoneCelular.obrigatorio" />
<liferay-ui:error key="mensagem.erro.telefoneCelular.obrigatorio" message="mensagem.erro.telefoneCelular.obrigatorio" />
<liferay-ui:error key="mensagem.erro.dddTelefoneCelular.temQueSerNumerico" message="mensagem.erro.dddTelefoneCelular.temQueSerNumerico" />
<liferay-ui:error key="mensagem.erro.telefoneCelular.temQueSerNumerico" message="mensagem.erro.telefoneCelular.temQueSerNumerico" />

<div class="curso_inscricao">
	<%@ include file="header.jspf"%>
	<form name="<portlet:namespace />fm" action="<%=avancarURL%>" method="POST">
		<div class="bloco-titulo">
			<h1 class="castanho">
				<c:choose>
					<c:when test="<%=Constantes.PESSOA_FISICA.equals(cursoInscricao.getTipoFisicaJuridica()) %>">
						<liferay-ui:message key="label.segundaEtapaCpf" />
					</c:when>
					<c:otherwise>
						<liferay-ui:message key="label.segundaEtapaCnpj" />
					</c:otherwise>
				</c:choose>
			</h1>
		
			<p>
				<label for="cursoInscricaoId">
					<liferay-ui:message key="label.numeroInscricao" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>cursoInscricaoId" id="cursoInscricaoId" value="<%=cursoInscricao.getInscricaoId()%>" size="15" disabled="disabled" />
			</p>
			<p>
				<label for="nomeResponsavelInscricao">
					<liferay-ui:message key="label.nomeResponsavelInscricao" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>nomeResponsavelInscricao" id="nomeResponsavelInscricao" value="<%=cursoInscricao.getNomeResponsavel()%>" size="45" />
			</p>
			<p>
				<label for="emailPrincipal">
					<liferay-ui:message key="label.emailPrincipal" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>emailPrincipal" id="emailPrincipal" value="<%=cursoInscricao.getEmailPrincipal()%>" size="45" />
			</p>
			<p>
				<label for="telefonePrincipal">
					<liferay-ui:message key="label.telefonePrincipal" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				(<input type="text" name="<portlet:namespace/>dddTelefonePrincipal" id="dddTelefonePrincipal" value="<%=cursoInscricao.getDddTelefoneComercial()%>" size="1" maxlength="2" style="width:20px" onkeyup="moverDeDDDParaTelefone('dddTelefonePrincipal', 'telefonePrincipal')">)
				<input type="text" name="<portlet:namespace/>telefonePrincipal" id="telefonePrincipal" value="<%=cursoInscricao.getTelefoneComercial()%>" maxlength="9" />

			<p>
				<input type="checkbox" name="<portlet:namespace/>responsavelParticipante" value="true"> <liferay-ui:message key="label.segundaEtapaResponsavelParticipante" />
			</p>
			
			<p>
				<input type="button" value="<liferay-ui:message key="botao.voltar"/>" onclick="window.history.go(-1)">
				<input type="button" value="<liferay-ui:message key="botao.avancar"/>" onclick="javascript:avancar(document.<portlet:namespace />fm)">
			</p>
		</div>

		<input type="hidden" name="<portlet:namespace/>etapa" id="etapa" value="${etapa}" />
		<input type="hidden" name="<portlet:namespace/>inscricaoId" id="inscricaoId" value="<%=cursoInscricao.getInscricaoId()%>" />
		<input type="hidden" name="<portlet:namespace/>cursoId" id="cursoId" value="<%=cursoInscricao.getCursoId()%>" />
		<input type="hidden" name="<portlet:namespace/>modoAdm" id="modoAdm" value="${modoAdm}" />
	</form>
	<%@ include file="footer.jspf"%>
</div>