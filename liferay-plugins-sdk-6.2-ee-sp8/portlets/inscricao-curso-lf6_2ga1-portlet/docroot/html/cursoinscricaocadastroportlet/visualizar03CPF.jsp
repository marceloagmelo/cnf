<div class="curso_inscricao">
	<div class="bloco-titulo">
		<h1><liferay-ui:message key="label.dadosParticipante" /></h1>

		<p>
			<label for="valorPago">
				<liferay-ui:message key="label.valorPago" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="valorPago" id="valorPago" value="<%=cursoParticipante.getValorPago()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="nomeCompleto">
				<liferay-ui:message key="label.nomeCompleto" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="nomeCompleto" id="nomeCompleto" value="<%=cursoParticipante.getNomeCompleto()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="nomeCracha">
				<liferay-ui:message key="label.nomeCracha" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="nomeCracha" id="nomeCracha" value="<%=cursoParticipante.getNomeCracha()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="cpf">
				<liferay-ui:message key="label.cpf" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="cpf" id="cpf" value="<%=cursoParticipante.getCpf()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="sexo">
				<liferay-ui:message key="label.sexo" />
				<liferay-ui:message key="label.separador" />
			</label>
			<select name="sexo" disabled="disabled">
				<%
					if (Constantes.FEMININO.equals(cursoParticipante.getSexo())) {
				%>
				<option value="M">
					<liferay-ui:message key="label.masculino" />
				</option>
				<option value="F" selected="true">
					<liferay-ui:message key="label.feminino" />
				</option>
				<%
					} else {
				%>
				<option value="M" selected="true">
					<liferay-ui:message key="label.masculino" />
				</option>
				<option value="F">
					<liferay-ui:message key="label.feminino" />
				</option>
				<%
					}
				%>
			</select>
		</p>

		<p>
			<label for="empresaOndeTrabalha">
				<liferay-ui:message key="label.empresaOndeTrabalha" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="empresaOndeTrabalha" id="empresaOndeTrabalha" value="<%=cursoParticipante.getEmpresaOndeTrabalha()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="cargo">
				<liferay-ui:message key="label.cargo" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="cargo" id="cargo" value="<%=cursoParticipante.getCargo()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="departamento">
				<liferay-ui:message key="label.departamento" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="departamento" id="departamento" value="<%=cursoParticipante.getDepartamento()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="formacaoAcademica">
				<liferay-ui:message key="label.formacaoAcademica" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="formacaoAcademica" id="formacaoAcademica" value="<%=cursoParticipante.getFormacaoAcademica()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="emailPrincipal">
				<liferay-ui:message key="label.emailPrincipal" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="emailPrincipal" id="emailPrincipal" value="<%=cursoParticipante.getEmailPrincipal()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="emailOpcional">
				<liferay-ui:message key="label.emailOpcional" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="emailOpcional" id="emailOpcional" value="<%=cursoParticipante.getEmailOpcional()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="telefoneComercial">
				<liferay-ui:message key="label.telefonePrincipal" />
				<liferay-ui:message key="label.separador" />
			</label>
			(<input type="text" name="dddTelefoneComercial" id="dddTelefoneComercial" value="<%=cursoParticipante.getDddTelefoneComercial()%>" size="1" maxlength="2" disabled="disabled">)
			<input type="text" name="telefoneComercial" id="telefoneComercial" value="<%=cursoParticipante.getTelefoneComercial()%>" maxlength="9" disabled="disabled">
		</p>
		<p>
			<label for="telefonePessoal">
				<liferay-ui:message key="label.telefoneSecundario" />
				<liferay-ui:message key="label.separador" />
			</label>
			(<input type="text" name="dddTelefonePessoal" id="dddTelefonePessoal" value="<%=cursoParticipante.getDddTelefonePessoal()%>" size="1" maxlength="2" disabled="disabled">)
			<input type="text" name="telefonePessoal" id="telefonePessoal" value="<%=cursoParticipante.getTelefonePessoal()%>" maxlength="10" disabled="disabled">
		</p>
		<p>
			<label for="telefoneCelular">
				<liferay-ui:message key="label.telefoneCelular" />
				<liferay-ui:message key="label.separador" />
			</label>
			(<input type="text" name="dddTelefoneCelular" id="dddTelefoneCelular" value="<%=cursoParticipante.getDddTelefoneCelular()%>" size="1" maxlength="2" disabled="disabled">)
			<input type="text" name="telefoneCelular" id="telefoneCelular" value="<%=cursoParticipante.getTelefoneCelular()%>" maxlength="10" disabled="disabled">
		</p>
		<p>
			<label for="endereco">
				<liferay-ui:message key="label.endereco" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="endereco" id="endereco" value="<%=cursoParticipante.getEndereco()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="bairro">
				<liferay-ui:message key="label.bairro" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="bairro" id="bairro" value="<%=cursoParticipante.getBairro()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="cidade">
				<liferay-ui:message key="label.cidade" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="cidade" id="cidade" value="<%=cursoParticipante.getCidade()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="estado">
				<liferay-ui:message key="label.estado" />
				<liferay-ui:message key="label.separador" />
			</label>
			<select name="estado" disabled="disabled">
				<option value="">
					<liferay-ui:message key="label.selecione" />
				</option>
				<%
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
			<input type="text" name="cep" id="cep" value="<%=cursoParticipante.getCep()%>" size="8" disabled="disabled">
		</p>
		<p>
			<label for="expectativaCurso" class="texto-longo">
				<liferay-ui:message key="label.expectativaCurso" />
				<liferay-ui:message key="label.separador" />
			</label>
			<textarea rows="5" cols="80" name="expectativaCurso" disabled="disabled"><%=cursoParticipante.getExpectativaCurso()%></textarea>
		</p>
		<p>
			<label for="observacao" class="texto-longo">
				<liferay-ui:message key="label.observacoes" />
				<liferay-ui:message key="label.separador" />
			</label>
			<textarea rows="5" cols="80" name="observacao" disabled="disabled"><%=cursoParticipante.getObservacao()%></textarea>
		</p>
	</div>
</div>
