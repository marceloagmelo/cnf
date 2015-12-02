<div class="curso_inscricao">
	<div class="bloco-titulo">
		
		<h1><liferay-ui:message key="label.dadosEmpresa" /></h1>
		
		<p>
			<label for="cnpj">
				<liferay-ui:message key="label.cnpj" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="cnpj" id="cnpj" value="<%=cursoInscricao.getCpfCnpj()%>" size="45" disabled="disabled">
			
		</p>
		<p>
			<label for="razaoSocial">
				<liferay-ui:message key="label.razaoSocial" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="razaoSocial" id="razaoSocial" value="<%=cursoInscricaoCnpj.getRazaoSocial()%>" class="largura-total" disabled="disabled">
		</p>
		<p>
			<label for="nomeFantasia">
				<liferay-ui:message key="label.nomeFantasia" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="nomeFantasia" id="nomeFantasia" value="<%=cursoInscricaoCnpj.getNomeFantasia()%>" class="largura-total" disabled="disabled">
		</p>
		<p>
			<label for="inscricaoEstadual">
				<liferay-ui:message key="label.inscricaoEstadual" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="inscricaoEstadual" id="inscricaoEstadual" value="<%=cursoInscricaoCnpj.getInscricaoEstadual()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="endereco">
				<liferay-ui:message key="label.endereco" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="endereco" id="endereco" value="<%=cursoInscricaoCnpj.getEndereco()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="bairro">
				<liferay-ui:message key="label.bairro" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="bairro" id="bairro" value="<%=cursoInscricaoCnpj.getBairro()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="cidade">
				<liferay-ui:message key="label.cidade" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="cidade" id="cidade" value="<%=cursoInscricaoCnpj.getCidade()%>" size="45" disabled="disabled">
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
						if (uf.equalsIgnoreCase(cursoInscricaoCnpj.getEstado())) {
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
			<input type="text" name="cep" id="cep" value="<%=cursoInscricaoCnpj.getCep()%>" size="8" disabled="disabled">
		</p>
		<p>
			<label for="telefone">
				<liferay-ui:message key="label.telefone" />
				<liferay-ui:message key="label.separador" />
			</label>
			(<input type="text" name="dddTelefone" id="dddTelefone" value="<%=cursoInscricaoCnpj.getDddTelefone()%>" size="1" maxlength="2" disabled="disabled">)
			<input type="text" name="telefone" id="telefone" value="<%=cursoInscricaoCnpj.getTelefone()%>" maxlength="10" disabled="disabled">
		</p>

		<h1><liferay-ui:message key="label.dadosRecebimentoNotaFiscal" /></h1>
		<p>
			<label for="nfNome">
				<liferay-ui:message key="label.nome" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="nfNome" id="nfNome"
				value="<%=cursoInscricaoCnpj.getNfNome()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="nfDepartamento">
				<liferay-ui:message key="label.departamento" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="nfDepartamento" id="nfDepartamento"
				value="<%=cursoInscricaoCnpj.getNfDepartamento()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="nfTelefone">
				<liferay-ui:message key="label.telefone" />
				<liferay-ui:message key="label.separador" />
			</label>
			(<input type="text" name="nfDddTelefone" id="nfDddTelefone" value="<%=cursoInscricaoCnpj.getNfDddTelefone()%>" size="1" maxlength="2" disabled="disabled">)
			<input type="text" name="nfTelefone" id="nfTelefone" value="<%=cursoInscricaoCnpj.getNfTelefone()%>" maxlength="9" disabled="disabled">
		</p>
		<p>
			<label for="nfEmail">
				<liferay-ui:message key="label.email" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="nfEmail" id="nfEmail" value="<%=cursoInscricaoCnpj.getNfEmail()%>" size="45" disabled="disabled">
		</p>
	</div>
</div>
