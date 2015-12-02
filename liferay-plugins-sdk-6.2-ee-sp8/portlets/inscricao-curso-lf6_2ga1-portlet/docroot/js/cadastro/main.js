function avancarEtapa01(form, tipo) {
	if (tipo == "J") {
		// document.forms[0].tipoFisicaJuridica.value = 'J';
		document.getElementById("tipoFisicaJuridica").value = "J";
		document.getElementById("cpfCnpj").value = document.getElementById("cnpj").value;
	} else {
		document.getElementById("tipoFisicaJuridica").value = "F";
		document.getElementById("cpfCnpj").value = document.getElementById("cpf").value;
	}
	form.submit();
}

function avancar(form) {
	form.submit();
}

function filtrar(form, tipoFiltro) {
	document.getElementById("tipoFiltro").value = tipoFiltro;
	if (tipoFiltro == "C") {
		document.getElementById("filtro").value = document.getElementById("filtroCurso").value;
	} else if (tipoFiltro == "PF") {
		document.getElementById("filtro").value = document.getElementById("filtroCpf").value;
	} else if (tipoFiltro == "PJ") {
		document.getElementById("filtro").value = document.getElementById("filtroCnpj").value;
	} else {
		document.getElementById("filtro").value = document.getElementById("filtroNomeResponsavel").value;
	}
	form.submit();
}

function ajustarTamanhoTelefone(ddd,telefone) {
	var campoDDD = jQuery("#"+ddd);
	var campoTelefone = jQuery("#"+telefone);
	
	if(campoDDD.val() == "11") {
		campoTelefone.mask("99999-9999");
		campoTelefone.prop('maxLength', 10);
	} else {
		campoTelefone.mask("9999-9999");
		campoTelefone.prop('maxLength', 9);
	}
}

function moverDeDDDParaTelefone(ddd, telefone) {
	var campoDDD = jQuery("#"+ddd);
	var campoTelefone = jQuery("#"+telefone);
	
	if(campoDDD.val().length == 2 && campoDDD.val().indexOf("_") < 0) {
		ajustarTamanhoTelefone(ddd,telefone);
		campoTelefone.focus();
	}
}

$(document).ready(function(){
   $("#cpf").mask("999.999.999-99");
   $("#filtroCpf").mask("999.999.999-99");
   $("#cnpj").mask("99.999.999/9999-99");
   $("#filtroCnpj").mask("99.999.999/9999-99");
   $("#cep").mask("99999-999");
   $("#dddTelefone").mask("99");
   $("#dddTelefonePrincipal").mask("99");
   $("#telefonePrincipal").mask("9999-9999");
   $("#dddTelefoneSecundario").mask("99");
   $("#telefoneSecundario").mask("9999-9999");
   $("#dddTelefoneCelular").mask("99");
   $("#nfDddTelefone").mask("99");
});

function exibeDadosCartao(dadosCartao){
	document.getElementById(dadosCartao).style.display = "block"
}

function escondeDadosCartao(dadosCartao){
	document.getElementById(dadosCartao).style.display = "none"
}