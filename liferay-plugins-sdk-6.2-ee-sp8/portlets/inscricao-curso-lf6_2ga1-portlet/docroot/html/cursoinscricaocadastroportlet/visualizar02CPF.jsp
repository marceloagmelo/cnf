<div class="curso_inscricao">
	
	<div class="bloco-titulo">
			<h1><liferay-ui:message key="label.dadosInscricao" /></h1>
			
		<p>
			<label for="inscricaoId">
				<liferay-ui:message key="label.numeroInscricao" />
				<liferay-ui:message key="label.separador" />
			</label>
			<aui:input useNamespace="no" name="inscricaoId" id="inscricaoId" label="" value="<%=cursoInscricao.getInscricaoId()%>"  disabled="true" />
		</p>
		
		<p>
			<label for="cpfResponsavelInscricao">
				<liferay-ui:message key="label.cpfResponsavelInscricao" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="cpfResponsavelInscricao" id="cpfResponsavelInscricao" value="<%=cursoInscricao.getCpfCnpj()%>" size="45" disabled="disabled">
		</p>
		
		<p>
			<label for="nomeResponsavelInscricao">
				<liferay-ui:message key="label.nomeResponsavelInscricao" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="nomeResponsavelInscricao" id="nomeResponsavelInscricao" value="<%=cursoInscricao.getNomeResponsavel()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="emailPrincipal">
				<liferay-ui:message key="label.emailPrincipal" />
				<liferay-ui:message key="label.separador" />
			</label>
			<input type="text" name="emailPrincipal" id="emailPrincipal" value="<%=cursoInscricao.getEmailPrincipal()%>" size="45" disabled="disabled">
		</p>
		<p>
			<label for="telefonePrincipal">
				<liferay-ui:message key="label.telefonePrincipal" />
				<liferay-ui:message key="label.separador" />
			</label>
			(<input type="text" name="dddTelefonePrincipal" id="dddTelefonePrincipal" value="<%=cursoInscricao.getDddTelefoneComercial()%>" size="1" maxlength="2" disabled="disabled">)
			<input type="text" name="telefonePrincipal" id="telefonePrincipal" value="<%=cursoInscricao.getTelefoneComercial()%>" maxlength="10" disabled="disabled">
		</p>
		
		<p>
			<label for="sexo">
				<liferay-ui:message key="label.sexo" />
				<liferay-ui:message key="label.separador" />
			</label>
			<select name="sexo" disabled="disabled">
				<%
					if (Constantes.FEMININO.equals(cursoInscricao.getSexo())) {
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
	</div>
	
</div>
