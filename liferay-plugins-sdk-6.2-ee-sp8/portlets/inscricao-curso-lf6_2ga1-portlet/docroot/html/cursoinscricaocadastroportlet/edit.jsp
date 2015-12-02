<%@ include file="/html/init.jsp"%>

<portlet:actionURL name="salvarPreferencias" var="salvarPreferenciasURL" />

<div>
	<aui:form action="<%= salvarPreferenciasURL %>" method="post">
		<div>
            <aui:input name="emailRemetenteNome" label="label.remetente.email.nome" value="${emailRemetenteNome}" />
            <aui:input name="emailRemetenteEndereco" label="label.remetente.email.endereco" value="${emailRemetenteEndereco}" />
        </div>
		
		<aui:button-row>
            <aui:button type="submit" value="botao.salvar"/>
        </aui:button-row>
	</aui:form>
</div>