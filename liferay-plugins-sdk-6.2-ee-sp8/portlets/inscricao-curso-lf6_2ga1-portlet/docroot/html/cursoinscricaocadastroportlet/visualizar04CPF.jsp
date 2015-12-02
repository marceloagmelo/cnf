<div class="curso_inscricao">
	<div class="bloco-titulo">
		<h1><liferay-ui:message key="label.dadosEmissaoNF" /></h1>

		<p>
			<label for="nome">
				<liferay-ui:message key="label.nome" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="nome" id="nome" value="<%=cursoInscricaoCpf.getNome()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="cpf">
				<liferay-ui:message key="label.cpf" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="cpf" id="cpf" value="<%=cursoInscricaoCpf.getCpf()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="endereco">
				<liferay-ui:message key="label.endereco" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="endereco" id="endereco" value="<%=cursoInscricaoCpf.getEndereco()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="bairro">
				<liferay-ui:message key="label.bairro" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="bairro" id="bairro" value="<%=cursoInscricaoCpf.getBairro()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="cidade">
				<liferay-ui:message key="label.cidade" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="cidade" id="cidade" value="<%=cursoInscricaoCpf.getCidade()%>" size="45" disabled="disabled">
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
						if (uf.equalsIgnoreCase(cursoInscricaoCpf.getEstado())) {
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
			<input type="text" name="cep" id="cep" value="<%=cursoInscricaoCpf.getCep()%>" size="8" disabled="disabled">
		</p>
		<p>
			<label for="telefone">
				<liferay-ui:message key="label.telefone" />
				<liferay-ui:message key="label.separador" />
			</label>
			(<input type="text" name="dddTelefone" id="dddTelefone" value="<%=cursoInscricaoCpf.getDddTelefone()%>" size="1" maxlength="2" disabled="disabled">)
			<input type="text" name="telefone" id="telefone" value="<%=cursoInscricaoCpf.getTelefone()%>" maxlength="10" disabled="disabled">
		</p>
		<p>
			<label for="email">
				<liferay-ui:message key="label.email" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="email" id="email" value="<%=cursoInscricaoCpf.getEmail()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="observacao" class="texto-longo">
				<liferay-ui:message key="label.observacoes" />
				<liferay-ui:message key="label.separador" />
			</label>
			<textarea rows="5" cols="80" name="observacao" disabled="disabled"><%=cursoInscricaoCpf.getObservacao()%></textarea>
		</p>
	</div>
</div>