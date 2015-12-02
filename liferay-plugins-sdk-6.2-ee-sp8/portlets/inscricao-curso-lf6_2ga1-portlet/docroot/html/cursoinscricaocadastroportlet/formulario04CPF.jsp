<%@ include file="/html/init.jsp"%>

<%
	CursoInscricao cursoInscricao = (CursoInscricao) request.getAttribute(Constantes.CURSO_INSCRICAO);
	CursoInscricaoCpf cursoInscricaoCpf = (CursoInscricaoCpf) request.getAttribute(Constantes.CURSO_INSCRICAO_CPF);
	CursoParticipante cursoParticipante = (CursoParticipante) request.getAttribute(Constantes.CURSO_PARTICIPANTE);
%>

<portlet:actionURL name="avancarEtapa04CPF" var="avancarURL" />

<liferay-ui:error key="mensagem.erro.nome.obrigatorio" message="mensagem.erro.nome.obrigatorio" />
<liferay-ui:error key="mensagem.erro.cpf.obrigatorio" message="mensagem.erro.cpf.obrigatorio" />
<liferay-ui:error key="mensagem.erro.cpf.invalido" message="mensagem.erro.cpf.invalido" />
<liferay-ui:error key="mensagem.erro.email.obrigatorio" message="mensagem.erro.email.obrigatorio" />
<liferay-ui:error key="mensagem.erro.email.invalido" message="mensagem.erro.email.invalido" />
<liferay-ui:error key="mensagem.erro.dddTelefone.obrigatorio" message="mensagem.erro.dddTelefone.obrigatorio" />
<liferay-ui:error key="mensagem.erro.dddTelefone.temQueSerNumerico" message="mensagem.erro.dddTelefone.temQueSerNumerico" />
<liferay-ui:error key="mensagem.erro.telefone.obrigatorio" message="mensagem.erro.telefone.obrigatorio" />
<liferay-ui:error key="mensagem.erro.telefone.temQueSerNumerico" message="mensagem.erro.telefone.temQueSerNumerico" />
<liferay-ui:error key="mensagem.erro.endereco.obrigatorio" message="mensagem.erro.endereco.obrigatorio" />
<liferay-ui:error key="mensagem.erro.bairro.obrigatorio" message="mensagem.erro.bairro.obrigatorio" />
<liferay-ui:error key="mensagem.erro.cidade.obrigatorio" message="mensagem.erro.cidade.obrigatorio" />
<liferay-ui:error key="mensagem.erro.estado.obrigatorio" message="mensagem.erro.estado.obrigatorio" />
<liferay-ui:error key="mensagem.erro.cep.obrigatorio" message="mensagem.erro.cep.obrigatorio" />

<div class="curso_inscricao">
	<%@ include file="header.jspf"%>
	<form name="<portlet:namespace />fm" action="<%=avancarURL%>" method="POST">
		<div class="bloco-titulo">
			<h1 class="verde-oliva"><liferay-ui:message key="label.quartaEtapaCPF" /></h1>
			
			<p>
				<label for="numeroInscricao">
					<liferay-ui:message key="label.numeroInscricao" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace />numeroInscricao" id="numeroInscricao" value="<%=cursoInscricao.getInscricaoId()%>" size="20" disabled="disabled">
			</p>
			
			<p>
				<label for="cpfParticipante">
					<liferay-ui:message key="label.cpfParticipante" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace />cpfParticipante" id="cpfParticipante" value="<%=cursoParticipante.getCpf()%>" size="15" disabled="disabled">
			</p>
			
			<p>
				<label for="nomeParticipante">
					<liferay-ui:message key="label.nomeParticipante" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace />nomeParticipante" id="nomeParticipante" value="<%=cursoParticipante.getNomeCompleto()%>" size="45" disabled="disabled">
			</p>
			
			
			<p>
				<label for="valorPago">
					<liferay-ui:message key="label.valorPago" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				
				<select name="<portlet:namespace />valorPago" id="valorPago">
					<option value="preco"><liferay-ui:message key="label.preco" />: <%= Search.recuperarAtributo(request, cursoInscricao.getCursoId(), Constantes.PRECO) %></option>
					<option value="precoConvenio"><liferay-ui:message key="label.precoPorConvenio" />: <%= Search.recuperarAtributo(request, cursoInscricao.getCursoId(), Constantes.PRECO_CONVENIO) %></option>
					<option value="precoAssociado"><liferay-ui:message key="label.precoPorAssociado" />: <%= Search.recuperarAtributo(request, cursoInscricao.getCursoId(), Constantes.PRECO_ASSOCIADO) %></option>
				</select>
			</p>
			<p>
			 <b>Cabe ressaltar que os dados que irão constar na NF devem ser os mesmos da pessoa que realizará o pagamento da inscrição.</b>
			</p>
			<p>
				<label for="nfNome">
					<liferay-ui:message key="label.nomeEmissaoNF" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace />nfNome" id="nfNome" value="<%=cursoInscricaoCpf.getNome()%>" size="45">
			</p>
			<p>
				<label for="cpf">
					<liferay-ui:message key="label.cpfEmissaoNF" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace />cpf" id="cpf" value="<%=cursoInscricaoCpf.getCpf()%>" size="45">
			</p>
			<p>
				<label for="endereco">
					<liferay-ui:message key="label.endereco" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace />endereco" id="endereco" value="<%=cursoInscricaoCpf.getEndereco()%>" size="45">
			</p>
			<p>
				<label for="bairro">
					<liferay-ui:message key="label.bairro" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace />bairro" id="bairro" value="<%=cursoInscricaoCpf.getBairro()%>" size="45">
			</p>
			<p>
				<label for="cidade">
					<liferay-ui:message key="label.cidade" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace />cidade" id="cidade" value="<%=cursoInscricaoCpf.getCidade()%>" size="45">
			</p>
			<p>
				<label for="estado">
					<liferay-ui:message key="label.estado" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<select name="<portlet:namespace />estado">
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
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace />cep" id="cep" value="<%=cursoInscricaoCpf.getCep()%>" size="8">
			</p>
			<p>
				<label for="telefone">
					<liferay-ui:message key="label.telefone" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				(<input style="width: 20px" type="text" name="<portlet:namespace />dddTelefone" id="dddTelefone" value="<%=cursoInscricaoCpf.getDddTelefone()%>" size="1" maxlength="2" onkeyup="moverDeDDDParaTelefone('dddTelefone', 'telefone')">)
				<input type="text" name="<portlet:namespace />telefone" id="telefone" value="<%=cursoInscricaoCpf.getTelefone()%>" maxlength="9" />
			</p>
			<p>
				<label for="email">
					<liferay-ui:message key="label.email" />
					<liferay-ui:message key="label.separador" />
				</label>
				<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
				<input type="text" name="<portlet:namespace />email" id="email" value="<%=cursoInscricaoCpf.getEmail()%>" size="45">
			</p>
			<p>
				<label for="observacao" class="texto-longo">
					<liferay-ui:message key="label.observacoes" />
					<liferay-ui:message key="label.separador" />
				</label>
				<textarea rows="5" cols="80" name="<portlet:namespace />observacao"><%=cursoInscricaoCpf.getObservacao()%></textarea>
			</p>
			<p>
				<input type="button" value="<liferay-ui:message key="botao.avancar"/>" onclick="javascript:avancar(document.<portlet:namespace />fm)">
			</p>	
		</div>
		
		<input type="hidden" name="<portlet:namespace />etapa" id="etapa" value="${etapa}" />
		<input type="hidden" name="<portlet:namespace />inscricaoId" id="inscricaoId" value="<%=cursoInscricao.getInscricaoId()%>" />
		<input type="hidden" name="<portlet:namespace />cursoId" id="cursoId" value="<%=cursoInscricao.getCursoId()%>" />
		<input type="hidden" name="<portlet:namespace />inscricaoCpfId" id="inscricaoCpfId" value="<%=cursoInscricaoCpf.getInscricaoCpfId()%>" />
		<input type="hidden" name="<portlet:namespace />participanteId" id="participanteId" value="<%=cursoParticipante.getParticipanteId()%>" />
		<input type="hidden" name="<portlet:namespace />modoAdm" id="modoAdm" value="${modoAdm}" />
	</form>
	<%@ include file="footer.jspf"%>
</div>