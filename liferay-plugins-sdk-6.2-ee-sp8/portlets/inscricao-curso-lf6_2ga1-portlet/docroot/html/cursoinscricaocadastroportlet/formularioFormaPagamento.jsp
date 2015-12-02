<%@ include file="/html/init.jsp"%>

<%
	CursoInscricao cursoInscricao = (CursoInscricao) request.getAttribute(Constantes.CURSO_INSCRICAO);
%>

<portlet:actionURL name="finalizarEtapas" var="avancarURL" />

<liferay-ui:error key="mensagem.erro.formaPagamento.obrigatoria" message="mensagem.erro.formaPagamento.obrigatoria" />
<liferay-ui:error key="mensagem.erro.numeroCartao.obrigatorio" message="mensagem.erro.numeroCartao.obrigatorio" />
<liferay-ui:error key="mensagem.erro.numeroCartao.temQueSerNumerico" message="mensagem.erro.numeroCartao.temQueSerNumerico" />
<liferay-ui:error key="mensagem.erro.cartaoValidadeMes.obrigatorio" message="mensagem.erro.cartaoValidadeMes.obrigatorio" />
<liferay-ui:error key="mensagem.erro.cartaoValidadeMes.temQueSerNumerico" message="mensagem.erro.cartaoValidadeMes.temQueSerNumerico" />
<liferay-ui:error key="mensagem.erro.cartaoValidadeAno.obrigatorio" message="mensagem.erro.cartaoValidadeAno.obrigatorio" />
<liferay-ui:error key="mensagem.erro.cartaoValidadeAno.temQueSerNumerico" message="mensagem.erro.cartaoValidadeAno.temQueSerNumerico" />
<liferay-ui:error key="mensagem.erro.nomeTitularCartao.obrigatorio" message="mensagem.erro.nomeTitularCartao.obrigatorio" />
<liferay-ui:error key="mensagem.erro.cartaoCodigoSeguranca.obrigatorio" message="mensagem.erro.cartaoCodigoSeguranca.obrigatorio" />
<liferay-ui:error key="mensagem.erro.cartaoCodigoSeguranca.temQueSerNumerico" message="mensagem.erro.cartaoCodigoSeguranca.temQueSerNumerico" />
<liferay-ui:error key="mensagem.erro.envioEmail" message="mensagem.erro.envioEmail" />
<liferay-ui:error key="mensagem.erro.envioAprovacaoCartao" message="mensagem.erro.envioAprovacaoCartao" />
<liferay-ui:error key="mensagem.erro.pedidoNegado" message="mensagem.erro.pedidoNegado" />
<liferay-ui:error key="mensagem.erro.pedidoReprovado" message="mensagem.erro.pedidoReprovado" />
<liferay-ui:error key="mensagem.erro.pedidoCancelado" message="mensagem.erro.pedidoCancelado" />

<b>${conteudoRetornoMoedaDigital }</b>

<div class="curso_inscricao">
	<%@ include file="header.jspf"%>
	<form name="<portlet:namespace />fm" action="<%=avancarURL%>" method="POST">
<script type="text/javascript">
 function set_MD_MeioPagto(_MD_MeioPagto) {
     if ((_MD_MeioPagto.indexOf("CIELO") == -1) && (_MD_MeioPagto.indexOf("REDECARD") == -1)) {
         document.getElementById('div_MD_debitoboleto').style.display = 'block'; 
         document.getElementById('div_MD_cartao').style.display = 'none';
         document.getElementById('div_MD_parcelado').style.display = 'none';
         document.getElementById('dadosCartao').style.display = 'none';
         document.getElementById('MD_FormaPagto0').checked = true;
     } 
     else 
     { 
         document.getElementById('div_MD_cartao').style.display = 'block'; 
         document.getElementById('dadosCartao').style.display = 'block';
         document.getElementById('div_MD_debitoboleto').style.display = 'none'; 
         document.getElementById('MD_FormaPagto1').checked = true;  
         if (_MD_MeioPagto.indexOf("DISCOVER") != -1) {
             document.getElementById('div_MD_parcelado').style.display = 'none'; 
         } 
         else 
         { 
             document.getElementById('div_MD_parcelado').style.display = 'block'; 
         }
     }
 }
</script>
		<div class="bloco-titulo">
			<h1 class="vinho">
				<liferay-ui:message key="label.formaPagamentoTitulo" />
			</h1>
			
			<input type="hidden" id="MD_ValorBoleto" name="<portlet:namespace/>MD_ValorBoleto" value="${MD_ValorBoleto }" />
			<div id="MoedaDigital" style="float:left; width: 99%; margin: 10px auto;" >

			<c:if test="${encontrouMeiosPagamento eq '1'}">
				<c:if test="${encontrouMeiosPagamentoBoleto eq '1'}">
					<c:forEach items="${listaRetornoMeiosPagamento}" var="meioPagamento" varStatus="indice">
						<c:if test="${meioPagamento.nome == 'ITAU-BOLETO'}">
							<p>
								<label for="boletoBancario">
									<liferay-ui:message key="label.boletoBancario" />
									<liferay-ui:message key="label.separador" />
								</label>
								<input type="radio" name="<portlet:namespace/>MD_MeioPagto" value="${meioPagamento.nome }" 
									id="${meioPagamento.nome }" onclick="set_MD_MeioPagto('${meioPagamento.nome }')" />
								<img alt="${meioPagamento.descricao }" src="${meioPagamento.imagem }" width="47px" height="22px">
							</p>
						</c:if>
					</c:forEach>
				</c:if>
			</c:if>

			<c:if test="${exibirCreditoEmConta eq '1'}">
				<p>
					<label for="creditoConta">
						<liferay-ui:message key="label.creditoConta" />
						<liferay-ui:message key="label.separador" />
					</label>
					<input type="radio" name="<portlet:namespace/>MD_MeioPagto" value="CREDITO-CONTA"
						id="CREDITO-CONTA" onclick="set_MD_MeioPagto('CREDITO-CONTA')">
					<img alt="<liferay-ui:message key="label.creditoConta" />" src="<%=renderResponse.encodeURL(renderRequest.getContextPath() +"/images/depositIco.png")%>" width="47px" height="22px">
				</p>
			</c:if>
			
			<c:if test="${encontrouMeiosPagamento eq '1'}">
				<c:if test="${encontrouMeiosPagamentoCartao eq '1'}">
					<p>
						<label for="cartaoCredito">
							<liferay-ui:message key="label.cartaoCredito" />
							<liferay-ui:message key="label.separador" />
						</label>
						<c:forEach items="${listaRetornoMeiosPagamento}" var="meioPagamento" varStatus="indice">
							<c:if test="${meioPagamento.nome != 'ITAU-BOLETO'}">
								<input type="radio" name="<portlet:namespace/>MD_MeioPagto" value="${meioPagamento.nome }"
									id="${meioPagamento.nome }" onclick="set_MD_MeioPagto('${meioPagamento.nome }')" />
								<img alt="${meioPagamento.descricao }" src="${meioPagamento.imagem }" width="47px" height="22px">
								&nbsp;
							</c:if>
						</c:forEach>
					</p>
		
				</c:if>
	
				<div id="dadosCartao" style="display:none">
					<p>
						<label for="numeroCartao">
							<liferay-ui:message key="label.numeroCartao" />
							<liferay-ui:message key="label.separador" />
						</label>
						<span class="campo-obrigatorio">
							<liferay-ui:message key="label.obrigatorio" />
						</span>
						<input name="<portlet:namespace/>numeroCartao" id="numeroCartao" maxlength="16" value="<%=cursoInscricao.getNumeroCartao()%>"/>
					</p>
					
					<p>
						<label for="validadeCartao">
							<liferay-ui:message key="label.cartaoValidade" />
							<liferay-ui:message key="label.separador" />
						</label>
						<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
						<select name="<portlet:namespace/>validadeCartaoMes" style="width:25%">
							<option value="">
								<liferay-ui:message key="label.cartaoValidadeMes" />
							</option>
							<option value="01">
								<liferay-ui:message key="label.janeiro" />
							</option>
							<option value="02">
								<liferay-ui:message key="label.fevereiro" />
							</option>
							<option value="03">
								<liferay-ui:message key="label.marco" />
							</option>
							<option value="04">
								<liferay-ui:message key="label.abril" />
							</option>
							<option value="05">
								<liferay-ui:message key="label.maio" />
							</option>
							<option value="06">
								<liferay-ui:message key="label.junho" />
							</option>
							<option value="07">
								<liferay-ui:message key="label.julho" />
							</option>
							<option value="08">
								<liferay-ui:message key="label.agosto" />
							</option>
							<option value="09">
								<liferay-ui:message key="label.setembro" />
							</option>
							<option value="10">
								<liferay-ui:message key="label.outubro" />
							</option>
							<option value="11">
								<liferay-ui:message key="label.novembro" />
							</option>
							<option value="12">
								<liferay-ui:message key="label.dezembro" />
							</option>
							
							
						</select>
						/
						<select name="<portlet:namespace/>validadeCartaoAno" style="width:10%">
							<option value="">
								<liferay-ui:message key="label.cartaoValidadeAno" />
							</option>
							<c:forEach var="i" begin="15" end="99">
								<option value="${i}">
									${i}
								</option>
							</c:forEach>
						</select>
					</p>
		
					<p>
						<label for="nomeTitularCartao">
							<liferay-ui:message key="label.nomeTitularCartao" />
							<liferay-ui:message key="label.separador" />
						</label>
						<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
						<input type="text" name="<portlet:namespace/>nomeTitularCartao" id="nomeTitularCartao" size="45" maxlength="80" value="<%=cursoInscricao.getNomeTitularCartao()%>"/>
					</p>
		
					<p>
						<label for="cartaoCodigoSeguranca">
							<liferay-ui:message key="label.cartaoCodigoSeguranca" />
							<liferay-ui:message key="label.separador" />
						</label>
						<span class="campo-obrigatorio"><liferay-ui:message key="label.obrigatorio" /></span>
						<input type="text" name="<portlet:namespace/>codigoSegurancaCartao" id="codigoSegurancaCartao" size="10" maxlength="3" value="<%=cursoInscricao.getCodigoSegurancaCartao()%>"/>
					</p>
				</div>
			</c:if>
			
			<c:if test="${encontrouMeiosPagamento eq '1'}">
				<div style="display:block; width:530px; margin: 10px auto;">
					<br />
					<div id="MD_Header" style="float: left; width:530px; margin: 10px auto;">
						<br />
						<div style="float: left; width:180px; text-align:left;"><b>Quantidade de Parcelas</b></div> 
						<div style="float: left; width:110px; text-align:right;"><b>Valor da Parcela</b></div> 
						<div style="float: left; width:110px; text-align:right;"><b>Valor Total</b></div> 
						<div style="float: left; width:120px; text-align:center;"><b>Obs.</b></div> 
					</div>
					<c:forEach items="${listaRetornoParcelas}" var="parc" varStatus="indice">
						<c:if test="${indice.count == 1}">
							<div id="div_MD_debitoboleto" style="float:left;  width:530px;  margin: 0px auto;">
								<div style="float:left; width:180px; text-align:left;">
									<input type="radio" id="MD_FormaPagto${parc.parcela}" name="<portlet:namespace/>MD_FormaPagto" value="${indice.count }" checked="checked"/>&nbsp;1 parcela
								</div>
								<div style="float:left; width:110px; text-align:right;"> ${parc.valorParcela }&nbsp;</div>
								<div style="float:left; width:110px; text-align:right;"> ${parc.valorTotal }&nbsp;</div>
								<div style="float:left; width:120px; text-align:left;">&nbsp;${parc.obs }&nbsp;</div>
							</div>
						</c:if>
						<c:if test="${indice.count == 2}">
							<div id="div_MD_cartao" style="float:left;  width:530px;  margin: 0px auto; display: none;">
								<div style="float:left; width:180px; text-align:left;">
									<input type="radio" id="MD_FormaPagto${parc.parcela}" name="<portlet:namespace/>MD_FormaPagto" value="${parc.parcela}"/>&nbsp;${parc.parcela } parcela
								</div>
								<div style="float:left; width:110px; text-align:right;"> ${parc.valorParcela }&nbsp;</div>
								<div style="float:left; width:110px; text-align:right;"> ${parc.valorTotal }&nbsp;</div>
								<div style="float:left; width:120px; text-align:left;">&nbsp;${parc.obs }&nbsp;</div>
							</div>
							<div id="div_MD_parcelado" style="float:left; width:530px; display: none;">
						</c:if>
						<c:if test="${indice.count > 2}">
							<div style="float:left;">
								<div style="float:left; width:180px; text-align:left;  margin: 0px auto;">
									<input type="radio" id="MD_FormaPagto${parc.parcela}" name="<portlet:namespace/>MD_FormaPagto" value="${parc.parcela}" />&nbsp;${parc.parcela } parcela
								</div>
								<div style="float:left; width:110px; text-align:right;"> ${parc.valorParcela }&nbsp;</div>
								<div style="float:left; width:110px; text-align:right;"> ${parc.valorTotal }&nbsp;</div>
								<div style="float:left; width:120px; text-align:left;">&nbsp;${parc.obs }&nbsp;</div>
							</div>
						</c:if>
					</c:forEach>
						</div>
				</div>
			</c:if>
			</div>
			<p>
				<input type="button" value="<liferay-ui:message key="botao.concluir"/>" onclick="javascript:avancar(document.<portlet:namespace />fm)">
			</p>
		</div>

		<input type="hidden" name="<portlet:namespace/>etapa" id="etapa" value="${etapa }" />
		<input type="hidden" name="<portlet:namespace/>inscricaoId" id="inscricaoId" value="<%=cursoInscricao.getInscricaoId()%>" />
		<input type="hidden" name="<portlet:namespace/>cursoId" id="cursoId" value="<%=cursoInscricao.getCursoId()%>" />
		<input type="hidden" name="<portlet:namespace/>modoAdm" id="modoAdm" value="${modoAdm }" />
	</form>
	<%@ include file="footer.jspf"%>
</div>