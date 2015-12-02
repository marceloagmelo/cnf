<liferay-ui:search-container-column-text name="label.nome" property="nomeCompleto" />
<liferay-ui:search-container-column-text name="label.telefoneComercial" buffer="buffer">
<%
			buffer.append("(");
			buffer.append(participante.getDddTelefoneComercial());
			buffer.append(") (");
			buffer.append(participante.getTelefoneComercial());
			buffer.append(")");
%>	
</liferay-ui:search-container-column-text>
<liferay-ui:search-container-column-text name="label.email" property="emailPrincipal" />
