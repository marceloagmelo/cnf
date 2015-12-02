<%@ include file="/html/init.jsp"%>

<%
	CursoInscricao cursoInscricao = (CursoInscricao) request.getAttribute(Constantes.CURSO_INSCRICAO);
	CursoInscricaoCnpj cursoInscricaoCnpj = (CursoInscricaoCnpj) request.getAttribute(Constantes.CURSO_INSCRICAO_CNPJ);
%>

<portlet:actionURL name="avancarEtapa03CNPJ" var="avancarURL" />

<liferay-ui:error key="mensagem.erro.razaoSocial.obrigatorio" message="mensagem.erro.razaoSocial.obrigatorio" />
<liferay-ui:error key="mensagem.erro.nomeFantasia.obrigatorio" message="mensagem.erro.nomeFantasia.obrigatorio" />
<liferay-ui:error key="mensagem.erro.inscricaoEstadual.obrigatorio" message="mensagem.erro.inscricaoEstadual.obrigatorio" />
<liferay-ui:error key="mensagem.erro.endereco.obrigatorio" message="mensagem.erro.endereco.obrigatorio" />
<liferay-ui:error key="mensagem.erro.bairro.obrigatorio" message="mensagem.erro.bairro.obrigatorio" />
<liferay-ui:error key="mensagem.erro.cidade.obrigatorio" message="mensagem.erro.cidade.obrigatorio" />
<liferay-ui:error key="mensagem.erro.estado.obrigatorio" message="mensagem.erro.estado.obrigatorio" />
<liferay-ui:error key="mensagem.erro.cep.obrigatorio" message="mensagem.erro.cep.obrigatorio" />
<liferay-ui:error key="mensagem.erro.dddTelefone.obrigatorio" message="mensagem.erro.dddTelefone.obrigatorio" />
<liferay-ui:error key="mensagem.erro.dddTelefone.temQueSerNumerico" message="mensagem.erro.dddTelefone.temQueSerNumerico" />
<liferay-ui:error key="mensagem.erro.telefone.obrigatorio" message="mensagem.erro.telefone.obrigatorio" />
<liferay-ui:error key="mensagem.erro.telefone.temQueSerNumerico" message="mensagem.erro.telefone.temQueSerNumerico" />
<liferay-ui:error key="mensagem.erro.nomeNf.obrigatorio" message="mensagem.erro.nomeNf.obrigatorio" />
<liferay-ui:error key="mensagem.erro.departamentoNf.obrigatorio" message="mensagem.erro.departamentoNf.obrigatorio" />
<liferay-ui:error key="mensagem.erro.emailNf.obrigatorio" message="mensagem.erro.emailNf.obrigatorio" />
<liferay-ui:error key="mensagem.erro.emailNf.invalido" message="mensagem.erro.emailNf.invalido" />
<liferay-ui:error key="mensagem.erro.dddTelefoneNf.obrigatorio" message="mensagem.erro.dddTelefoneNf.obrigatorio" />
<liferay-ui:error key="mensagem.erro.dddTelefoneNf.temQueSerNumerico" message="mensagem.erro.dddTelefoneNf.temQueSerNumerico" />
<liferay-ui:error key="mensagem.erro.telefoneNf.obrigatorio" message="mensagem.erro.telefoneNf.obrigatorio" />
<liferay-ui:error key="mensagem.erro.telefoneNf.temQueSerNumerico" message="mensagem.erro.telefoneNf.temQueSerNumerico" />

<div class="curso_inscricao">
	<%@ include file="header.jspf"%>
	<form name="<portlet:namespace />fm" action="<%=avancarURL%>" method="POST">
	
		<div class="bloco-titulo">
			<h1 class="vinho">
				<liferay-ui:message key="label.terceiraEtapaCNPJ" />
			</h1>
			
			<p>
				<label for="inscricaoId">
					<liferay-ui:message key="label.numeroInscricao" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>inscricaoId" id="inscricaoId" value="<%=cursoInscricao.getInscricaoId()%>" disabled />
			</p>
			<p>
			 <b>Cabe ressaltar que os dados que irão constar na NF devem ser os mesmos da empresa que realizará o pagamento da inscrição.</b>
			</p>
			<p>
				<label for="numeroCnpj">
					<liferay-ui:message key="label.cnpj" />
					<liferay-ui:message key="label.separador" />
				</label>
				
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>numeroCnpj" id="numeroCnpj" value="<%=cursoInscricao.getCpfCnpj()%>" disabled />
			</p>
			
			<p>
				<label for="razaoSocial">
					<liferay-ui:message key="label.razaoSocial" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>razaoSocial" id="razaoSocial" class="largura-total" maxlength="300" value="<%=cursoInscricaoCnpj.getRazaoSocial()%>" />
			</p>
			<p>
				<label for="nomeFantasia">
					<liferay-ui:message key="label.nomeFantasia" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>nomeFantasia" id="nomeFantasia" class="largura-total" maxlength="300" value="<%=cursoInscricaoCnpj.getNomeFantasia()%>" />
			</p>
			<p>
				<label for="inscricaoEstadual">
					<liferay-ui:message key="label.inscricaoEstadual" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>inscricaoEstadual" id="inscricaoEstadual" value="<%=cursoInscricaoCnpj.getInscricaoEstadual()%>" size="45" maxlength="15">
			</p>
			<p>
				<label for="endereco">
					<liferay-ui:message key="label.endereco" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>endereco" id="endereco" value="<%=cursoInscricaoCnpj.getEndereco()%>" size="45" maxlength="300">
			</p>
			<p>
				<label for="bairro">
					<liferay-ui:message key="label.bairro" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>bairro" id="bairro" value="<%=cursoInscricaoCnpj.getBairro()%>" size="45" maxlength="75">
			</p>
			<p>
				<label for="cidade">
					<liferay-ui:message key="label.cidade" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>cidade" id="cidade" value="<%=cursoInscricaoCnpj.getCidade()%>" size="45" maxlength="75">
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
						List<String> listaEstados = (List) request.getAttribute("listaEstados");
						if (listaEstados == null) {
							listaEstados = new ArrayList<String>();
						}
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
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>cep" id="cep" value="<%=cursoInscricaoCnpj.getCep()%>" size="8" maxlength="9" >
			</p>
			
			<h2><liferay-ui:message key="label.dadosRecebimentoNotaFiscal" /></h2>
			
			<p>
				<label for="nfNome">
					<liferay-ui:message key="label.nome" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>nfNome" id="nfNome" value="<%=cursoInscricaoCnpj.getNfNome()%>" size="45" maxlength="300">
			</p>
			<p>
				<label for="nfDepartamento">
					<liferay-ui:message key="label.departamento" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>nfDepartamento" id="nfDepartamento" value="<%=cursoInscricaoCnpj.getNfDepartamento()%>" size="45" maxlength="75">
			</p>
			<p>
				<label for="nfTelefone">
					<liferay-ui:message key="label.telefone" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				(<input style="width:20px" type="text" name="<portlet:namespace/>nfDddTelefone" id="nfDddTelefone" value="<%=cursoInscricaoCnpj.getNfDddTelefone()%>" size="1" maxlength="2" onkeyup="moverDeDDDParaTelefone('nfDddTelefone', 'nfTelefone')">)
				<input type="text" name="<portlet:namespace/>nfTelefone" id="nfTelefone" value="<%=cursoInscricaoCnpj.getNfTelefone()%>" maxlength="9" />
			</p>
			<p>
				<label for="nfEmail">
					<liferay-ui:message key="label.email" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace/>nfEmail" id="nfEmail" value="<%=cursoInscricaoCnpj.getNfEmail()%>" size="45" maxlength="300">
			</p>
			<p>
				<label for="observacao" class="texto-longo">
					<liferay-ui:message key="label.observacoes" />
					<liferay-ui:message key="label.separador" />
				</label>
				<textarea rows="5" cols="80" name="<portlet:namespace/>observacao" maxlength="1000"><%=cursoInscricaoCnpj.getObservacao()%></textarea>
			</p>
			<p>
				<input type="button" value="<liferay-ui:message key="botao.avancar"/>" onclick="javascript:avancar(document.<portlet:namespace />fm)">
			</p>
			
		</div>
	
		<input type="hidden" name="<portlet:namespace/>etapa" id="etapa" value="${etapa}" />
		<input type="hidden" name="<portlet:namespace/>inscricaoId" id="inscricaoId" value="<%=cursoInscricao.getInscricaoId()%>" />
		<input type="hidden" name="<portlet:namespace/>cursoId" id="cursoId" value="<%=cursoInscricao.getCursoId()%>" />
		<input type="hidden" name="<portlet:namespace/>inscricaoCnpjId" id="inscricaoCnpjId" value="<%=cursoInscricaoCnpj.getInscricaoCnpjId()%>" />
		<input type="hidden" name="<portlet:namespace/>modoAdm" id="modoAdm" value="${modoAdm}" />
		<input type="hidden" name="<portlet:namespace/>responsavelParticipante" id="responsavelParticipante" value="${responsavelParticipante}" />
	</form>
	<%@ include file="footer.jspf"%>
</div>