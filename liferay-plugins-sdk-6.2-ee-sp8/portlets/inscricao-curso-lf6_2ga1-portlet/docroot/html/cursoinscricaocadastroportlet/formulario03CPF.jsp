<%@ include file="/html/init.jsp"%>

<%
	CursoInscricao cursoInscricao = (CursoInscricao) request.getAttribute(Constantes.CURSO_INSCRICAO);
	CursoParticipante cursoParticipante = (CursoParticipante) request.getAttribute(Constantes.CURSO_PARTICIPANTE);
%>

<portlet:actionURL name="avancarEtapa03CPF" var="avancarURL" />

<liferay-ui:error key="mensagem.erro.nomeCompleto.obrigatorio" message="mensagem.erro.nomeCompleto.obrigatorio" />
<liferay-ui:error key="mensagem.erro.nomeCracha.obrigatorio" message="mensagem.erro.nomeCracha.obrigatorio" />
<liferay-ui:error key="mensagem.erro.cpf.obrigatorio" message="mensagem.erro.cpf.obrigatorio" />
<liferay-ui:error key="mensagem.erro.cpf.invalido" message="mensagem.erro.cpf.invalido" />
<liferay-ui:error key="mensagem.erro.formacaoAcademica.obrigatorio" message="mensagem.erro.formacaoAcademica.obrigatorio" />
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
<liferay-ui:error key="mensagem.erro.endereco.obrigatorio" message="mensagem.erro.endereco.obrigatorio" />
<liferay-ui:error key="mensagem.erro.bairro.obrigatorio" message="mensagem.erro.bairro.obrigatorio" />
<liferay-ui:error key="mensagem.erro.cidade.obrigatorio" message="mensagem.erro.cidade.obrigatorio" />
<liferay-ui:error key="mensagem.erro.estado.obrigatorio" message="mensagem.erro.estado.obrigatorio" />
<liferay-ui:error key="mensagem.erro.cep.obrigatorio" message="mensagem.erro.cep.obrigatorio" />
<liferay-ui:error key="mensagem.erro.perfilFacebook.obrigatorio" message="mensagem.erro.perfilFacebook.obrigatorio" />

<div class="curso_inscricao">
	<%@ include file="header.jspf"%>
	<form name="<portlet:namespace />fm" action="<%=avancarURL%>" method="POST">
		<div class="bloco-titulo">
			<h1 class="vinho">
				<liferay-ui:message key="label.terceiraEtapaCPF" />
			</h1>
			
			<p>
				<label for="inscricaoId">
					<liferay-ui:message key="label.numeroInscricao" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio">
					<liferay-ui:message key="label.obrigatorio" />
				</span>
				<input name="<portlet:namespace/>inscricaoId" id="inscricaoId" value="<%=cursoInscricao.getInscricaoId()%>" disabled />
			</p>
			
			<p>
				<label for="nomeCompleto">
					<liferay-ui:message key="label.nomeCompleto" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>nomeCompleto" id="nomeCompleto" value="<%=cursoParticipante.getNomeCompleto()%>" size="45">
			</p>
			<!-- 
			<p>
				<label for="nomeCracha">
					<liferay-ui:message key="label.nomeCracha" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<i
				nput type="text" name="<portlet:namespace/>nomeCracha" id="nomeCracha" value="" size="45">
			</p>
			 -->
			<p>
				<label for="cpf">
					<liferay-ui:message key="label.cpf" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>cpf" id="cpf" value="<%=cursoParticipante.getCpf()%>" size="45">
			</p>
			<!-- 
			<p>
				<label for="sexo">
					<liferay-ui:message key="label.sexo" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<select name="<portlet:namespace/>sexo">
					<%
						//if (Constantes.FEMININO.equals(cursoParticipante.getSexo())) {
					%>
					<option value="M">
						<liferay-ui:message key="label.masculino" />
					</option>
					<option value="F" selected="true">
						<liferay-ui:message key="label.feminino" />
					</option>
					<%
						//} else {
					%>
					<option value="M" selected="true">
						<liferay-ui:message key="label.masculino" />
					</option>
					<option value="F">
						<liferay-ui:message key="label.feminino" />
					</option>
					<%
						//}
					%>
				</select>
			</p>
			 -->
			<p>
				<label for="empresaOndeTrabalha">
					<liferay-ui:message key="label.empresa" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>empresaOndeTrabalha" id="empresaOndeTrabalha" value="<%=cursoParticipante.getEmpresaOndeTrabalha()%>" size="45">
			</p>
			<p>
				<label for="cargo">
					<liferay-ui:message key="label.cargo" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>cargo" id="cargo" value="<%=cursoParticipante.getCargo()%>" size="45">
			</p>
			<p>
				<label for="departamento">
					<liferay-ui:message key="label.departamento" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>departamento" id="departamento" value="<%=cursoParticipante.getDepartamento()%>" size="45">
			</p>
			<!-- 
			<p>
				<label for="formacaoAcademica">
					<liferay-ui:message key="label.formacaoAcademica" />
					<liferay-ui:message key="label.separador" />
				</label>
				&nbsp;
				<input type="text" name="<portlet:namespace/>formacaoAcademica" id="formacaoAcademica" value="" size="45">
			</p>
			 -->
			<p>
				<label for="emailPrincipal">
					<liferay-ui:message key="label.emailPrincipal" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>emailPrincipal" id="emailPrincipal" value="<%=cursoParticipante.getEmailPrincipal()%>" size="45">
			</p>
			<p>
				<label for="emailOpcional">
					<liferay-ui:message key="label.emailOpcional" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio">&nbsp;</span>
				<input type="text" name="<portlet:namespace/>emailOpcional" id="emailOpcional" value="<%=cursoParticipante.getEmailOpcional()%>" size="45">
			</p>
			<p>
				<label for="telefonePrincipal">
					<liferay-ui:message key="label.telefonePrincipal" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				(<input style="width:20px" type="text" name="<portlet:namespace/>dddTelefonePrincipal" id="dddTelefonePrincipal" value="<%=cursoParticipante.getDddTelefoneComercial()%>" size="1" maxlength="2" onkeyup="moverDeDDDParaTelefone('dddTelefonePrincipal', 'telefonePrincipal')">)
				<input type="text" name="<portlet:namespace/>telefonePrincipal" id="telefonePrincipal" value="<%=cursoParticipante.getTelefoneComercial()%>" maxlength="9" />
			</p>
			<!-- 
			<p>
				<label for="telefoneSecundario">
					<liferay-ui:message key="label.telefoneSecundario" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio">&nbsp;</span>
				(<input style="width: 20px" type="text" name="<portlet:namespace/>dddTelefoneSecundario" id="dddTelefoneSecundario" value="<%=cursoParticipante.getDddTelefonePessoal()%>" size="1" maxlength="2" onkeyup="moverDeDDDParaTelefone('dddTelefoneSecundario', 'telefoneSecundario')">)
				<input type="text" name="<portlet:namespace/>telefoneSecundario" id="telefoneSecundario" value="" maxlength="9" />
			</p>
			 -->
			<p>
				<label for="telefoneCelular">
					<liferay-ui:message key="label.telefoneCelular" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio">&nbsp;</span>
				(<input style="width: 20px" type="text" name="<portlet:namespace/>dddTelefoneCelular" id="dddTelefoneCelular" value="<%=cursoParticipante.getDddTelefoneCelular()%>" size="1" maxlength="2" onkeyup="moverDeDDDParaTelefone('dddTelefoneCelular', 'telefoneCelular')">)
				<input type="text" name="<portlet:namespace/>telefoneCelular" id="telefoneCelular" value="<%=cursoParticipante.getTelefonePessoal()%>" onfocus="ajustarTamanhoTelefone('dddTelefoneCelular', 'telefoneCelular')">
			</p>
			<p>
				<label for="endereco">
					<liferay-ui:message key="label.endereco" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>endereco" id="endereco" value="<%=cursoParticipante.getEndereco()%>" size="45">
			</p>
			<p>
				<label for="bairro">
					<liferay-ui:message key="label.bairro" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>bairro" id="bairro" value="<%=cursoParticipante.getBairro()%>" size="45">
			</p>
			<p>
				<label for="cidade">
					<liferay-ui:message key="label.cidade" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>cidade" id="cidade" value="<%=cursoParticipante.getCidade()%>" size="45">
			</p>
			<p>
				<label for="estado">
					<liferay-ui:message key="label.estado" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<select name="<portlet:namespace/>estado">
					<option value="">
						<liferay-ui:message key="label.selecione" />
					</option>
					<%
						List<String> listaEstados = (List) request
								.getAttribute("listaEstados");
						if (listaEstados == null) {
							listaEstados = new ArrayList<String>();
						}
						for (String uf : listaEstados) {
							if (uf.equalsIgnoreCase(cursoParticipante.getEstado())) {
					%>
					<option value="<%=uf%>" selected="selected"><%=uf%></option>
					<%
						} else {
					%>
					<option value="<%=uf%>"><%=uf%></option>
					<%
						}
						}
					%>
				</select>
			</p>
			<p>
				<label for="cep">
					<liferay-ui:message key="label.cep" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>cep" id="cep" value="<%=cursoParticipante.getCep()%>" size="8">
			</p>
			<p>
				<label for="expectativaCurso" class="texto-longo">
					<liferay-ui:message key="label.expectativaCurso" />
				</label>
				<span class="campo-obrigatorio">&nbsp;</span>
				<textarea rows="5" cols="80" name="<portlet:namespace/>expectativaCurso"><%=cursoParticipante.getExpectativaCurso()%></textarea>
			</p>
			<p>
				<label for="observacao" class="texto-longo">
					<liferay-ui:message key="label.observacoes" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio">&nbsp;</span>
				<textarea rows="5" cols="80" name="<portlet:namespace/>observacao"><%=cursoParticipante.getObservacao()%></textarea>
			</p>
			<p>
				<input type="button" value="<liferay-ui:message key="botao.avancar"/>" onclick="javascript:avancar(document.<portlet:namespace />fm)">
			</p>
		</div>

		<input type="hidden" name="<portlet:namespace/>etapa" id="etapa" value="${etapa }" />
		<input type="hidden" name="<portlet:namespace/>inscricaoId" id="inscricaoId" value="<%=cursoInscricao.getInscricaoId()%>" />
		<input type="hidden" name="<portlet:namespace/>cursoId" id="cursoId" value="<%=cursoInscricao.getCursoId()%>" />
		<input type="hidden" name="<portlet:namespace/>participanteId" id="participanteId" value="<%=cursoParticipante.getParticipanteId()%>" />
		<input type="hidden" name="<portlet:namespace/>modoAdm" id="modoAdm" value="${modoAdm }" />
	</form>
	<%@ include file="footer.jspf"%>
</div>