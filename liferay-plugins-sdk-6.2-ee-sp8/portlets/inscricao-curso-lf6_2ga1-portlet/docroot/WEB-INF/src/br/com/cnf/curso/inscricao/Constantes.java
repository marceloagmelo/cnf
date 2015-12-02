package br.com.cnf.curso.inscricao;

public interface Constantes {

	public final String JSP_FORMULARIO_01 = "formulario-01";
	public final String JSP_FORMULARIO_02 = "formulario-02";
	public final String JSP_FORMULARIO_03_CNPJ = "formulario-03-CNPJ";
	public final String JSP_FORMULARIO_03_CPF = "formulario-03-CPF";
	public final String JSP_FORMULARIO_04_CNPJ = "formulario-04-CNPJ";
	public final String JSP_FORMULARIO_04_CPF = "formulario-04-CPF";
	public final String JSP_FORMULARIO_05_CNPJ = "formulario-05-CNPJ";
	public final String JSP_FORMULARIO_FINAL = "formulario-final";
	public final String JSP_VISUALIZAR = "visualizar-jsp";
	public final String JSP_FORMA_PAGAMENTO = "formaPagamento-jsp";
	
	public final String PARAM_CURSO_ID = "cursoId";
	public final String PARAM_INSCRICAO_ID = "inscricaoId";
	public final String PARAM_PARTICIPANTE_ID = "participanteId";
	public final String PARAM_INSCRICAO_CPF_ID = "inscricaoCpfId";
	public final String PARAM_INSCRICAO_CNPJ_ID = "inscricaoCnpjId";
	
	public final String MSG_ERRO_ID_CURSO_NAO_ENVIADO = "mensagem.erro.idCurso.naoEnviado";
	public final String MSG_ERRO_PORTLET = "mensagem.erro.portlet";
	public final String MSG_ERRO_CONTEUDO_NAO_ENCONTRADO = "mensagem.erro.conteudoNaoEncontrado";
	public final String MSG_ERRO_INSCRICAO_JA_REALIZADA_CPF = "mensagem.erro.inscricaoJaRealizadaCpf";
	public final String MSG_ERRO_INSCRICAO_JA_REALIZADA_CNPJ = "mensagem.erro.inscricaoJaRealizadaCnpj";
	public final String MSG_ERRO_CPF_JA_CADASTRADO_CURSO = "mensagem.erro.jaCadastroCurso";
	public final String MSG_ERRO_DATA_INICIO_CURSO_NAO_CADASTRADO = "mensagem.erro.dataInicioCurso.naoCadastrado";

	// estrutura
	public final String PREFIX = "web_content/";
	public final String NOME_CURSO = PREFIX + "nome-curso";
	public final String DATA_REALIZACAO = PREFIX + "data-realizacao";
	public final String HORARIO = PREFIX + "horario";
	public final String LOCAL = PREFIX + "local";
	public final String PRECO = PREFIX + "preco";
	public final String PRECO_CONVENIO = PREFIX + "preco-convenio";
	public final String PRECO_ASSOCIADO = PREFIX + "preco-associado";
	public final String DATA_INICIO = PREFIX + "data-inicio";
	
	public final String CURSO_INSCRICAO = "cursoInscricao";
	public final String CURSO_PARTICIPANTE = "cursoParticipante";
	public final String CURSO_INSCRICAO_CPF = "cursoInscricaoCpf";
	public final String CURSO_INSCRICAO_CNPJ = "cursoInscricaoCnpj";
		
	// fase 1
	public final String PROP_CPF_CNPJ = "cpfCnpj";
	public final String PROP_TIPO_FISICA_JURIDICA = "tipoFisicaJuridica";
	public final String PROP_ETAPA = "etapa";
	
	// fase 2
	public final String PROP_NOME_RESPONSAVEL_INSCRICAO = "nomeResponsavelInscricao";
	public final String PROP_EMAIL_PRINCIPAL = "emailPrincipal";
	public final String PROP_EMAIL_OPCIONAL = "emailOpcional";
	public final String PROP_DDD_TELEFONE_COMERCIAL = "dddTelefoneComercial";
	public final String PROP_TELEFONE_COMERCIAL = "telefoneComercial";
	public final String PROP_DDD_TELEFONE_PESSOAL = "dddTelefonePessoal";
	public final String PROP_TELEFONE_PESSOAL = "telefonePessoal";
	public final String PROP_DDD_TELEFONE_CELULAR = "dddTelefoneCelular";
	public final String PROP_TELEFONE_CELULAR = "telefoneCelular";
	public final String PROP_DDD_TELEFONE_PRINCIPAL = "dddTelefonePrincipal";
	public final String PROP_TELEFONE_PRINCIPAL = "telefonePrincipal";
	public final String PROP_DDD_TELEFONE_SECUNDARIO = "dddTelefoneSecundario";
	public final String PROP_TELEFONE_SECUNDARIO = "telefoneSecundario";
	
	public final String PROP_SEXO = "sexo";
	
	// fase 3 cpf
	public final String PROP_NOME_COMPLETO = "nomeCompleto";
	public final String PROP_NOME_CRACHA = "nomeCracha";
	public final String PROP_CPF = "cpf";
	public final String PROP_FORMACAO_ACADEMICA = "formacaoAcademica";
	public final String PROP_ENDERECO = "endereco";
	public final String PROP_BAIRRO = "bairro";
	public final String PROP_CIDADE = "cidade";
	public final String PROP_ESTADO = "estado";
	public final String PROP_CEP = "cep";
	public final String PROP_EMPRESA_ONDE_TRABALHA = "empresaOndeTrabalha";
	public final String PROP_POSSUI_PERFIL_FACEBOOK = "possuiPerfilFacebook";
	public final String PROP_PERFIL_FACEBOOK = "perfilFacebook";
	public final String PROP_EXPECTATIVA_CURSO = "expectativaCurso";
	public final String PROP_OBSERVACAO = "observacao";
	public final String EMPRESA = "empresa";
	public final String CARGO = "cargo";
	public final String DEPARTAMENTO = "departamento";
	
	// fase 3 cnpj
	public final String PROP_RAZAO_SOCIAL = "razaoSocial";
	public final String PROP_NOME_FANTASIA = "nomeFantasia";
	public final String PROP_INSCRICAO_ESTADUAL = "inscricaoEstadual";
	public final String PROP_NF_NOME = "nfNome";
	public final String PROP_NF_DEPARTAMENTO = "nfDepartamento";
	public final String PROP_NF_DDD_TELEFONE = "nfDddTelefone";
	public final String PROP_NF_TELEFONE = "nfTelefone";
	public final String PROP_NF_EMAIL = "nfEmail";
	
	// fase 4 cpf
	public final String PROP_NOME = "nome";
	public final String PROP_EMAIL = "email";
	public final String PROP_DDD_TELEFONE = "dddTelefone";
	public final String PROP_TELEFONE = "telefone";

	// fase 4 cnpj
	public final String PROP_CARGO = "cargo";
	public final String PROP_DEPARTAMENTO = "departamento";

	// fase forma de pagamento
	public final String PROP_QTDE_PARCELAS= "MD_FormaPagto";
	public final String PROP_FORMA_PAGAMENTO = "MD_MeioPagto";
	public final String PROP_NUMERO_CARTAO = "numeroCartao";
	public final String PROP_VALIDADE_CARTAO_MES = "validadeCartaoMes";
	public final String PROP_VALIDADE_CARTAO_ANO = "validadeCartaoAno";
	public final String PROP_NOME_TITULAR_CARTAO = "nomeTitularCartao";
	public final String PROP_CODIGO_SEGURANCA_CARTAO = "codigoSegurancaCartao";
	public final String PROP_VALOR_BOLETO = "MD_ValorBoleto";
	
	// preferências
	public final String PREF_MOEDA_DIGITAL_URL_BOLETO = "preferences--moedaDigitalUrlBoleto--";
	public final String PROP_MOEDA_DIGITAL_URL_BOLETO = "moedaDigitalUrlBoleto";
	public final String PREF_PARAM_DIAS_BOLETO = "preferences--paramDiasBoleto--";
	public final String PROP_PARAM_DIAS_BOLETO = "paramDiasBoleto";
	public final String PREF_EMAIL_RESPONSAVEL = "preferences--emailResponsavel--";
	public final String PROP_EMAIL_RESPONSAVEL = "emailResponsavel";

	public final String PESSOA_FISICA = "F";
	public final String PESSOA_JURIDICA = "J";

	public final String COMPANY_ID = "companyId";
	public final String GROUP_ID = "groupId";
	
	public final String MASCULINO = "M";
	public final String FEMININO = "F";
	
	public final String S = "S";
	public final String N = "N";
	
	public final String TODOS = "Todos";
	
	public final String HOUVE_ERRO = "houveErro";
	
	public final String LISTA_ESTADOS = "listaEstados";
	public final String LISTA_CURSO_PARTICIPANTES = "listaCursoParticipante";
	public final String LISTA_CURSO_INSCRICAO = "listaCursoInscricao";
	public final String LISTA_CURSO_INSCRICAO_CPF = "listaCursoInscricaoCpf";
	public final String LISTA_CURSO_INSCRICAO_CNPJ = "listaCursoInscricaoCnpj";
	
	public final String UM = "1";
	public final String TRES = "3";
	public final String QUATRO = "4";
	public final String NOVE = "9";
	
	public final String ALTERAR = "A";
	public final String INCLUIR = "I";
	
	public final String PERCENTE = "%";

	public final String TIPO_FILTRO = "tipoFiltro";
	public final String FILTRO = "filtro";
	public final String FILTRO_CPF = "filtroCpf";
	public final String FILTRO_CNPJ = "filtroCnpj";
	public final String FILTRO_CURSO = "filtroCurso";
	public final String FILTRO_NOME = "filtroNomeResponsavel";
	public final String TIPO_FILTRO_CPF = "PF";
	public final String TIPO_FILTRO_CNPJ = "PJ";
	public final String TIPO_FILTRO_CURSO = "C";
	public final String TIPO_FILTRO_NOME = "N";
	
	public final String MODO_ADM = "modoAdm";
	
	public final String URL_INSCRICAO = "/curso/inscricao";
	public final String URL_CURSO = "/curso";
	public final String URL = "url";
	
	public final String EXIBIR_DADOS_PARTICIPANTE = "exibirDadosParticipante";
	
	public final String CIELO_VISA = "CIELO-VISA";
	public final String CIELO_MASTERCARD = "CIELO-MASTERCARD";
	public final String CIELO_AMEX = "CIELO-AMEX";
	public final String CIELO_DINERS = "CIELO-DINERS";
	public final String CIELO_ELO = "CIELO-ELO";
	public final String CIELO_DISCOVER = "CIELO-DISCOVER";
	public final String ITAU_BOLETO = "ITAU-BOLETO";
	public final String CREDITO_CONTA = "CREDITO-CONTA";
		
	public final String MOEDA_DIGITA_URL_INICIAR_PAGAMENTO_DIGITAL_XML = "https://www.moedadigital.net/gateway.asmx/IniciarPagamentoXML";
	public final String MOEDA_DIGITAL_TOKEN = "55e2dba1-b253-493d-b73d-a6a194e808ad";
	public final String MOEDA_DIGITAL_APLICACAO = "CNF-APL-FICHA-INSC-TESTE";
	public final String MOEDA_DIGITAL_URL_BOLETO = "https://moeda.digital/Modulos/ItauBoleto/Boleto.aspx?Pedido=";
	public final String PARAM_DIAS_BOLETO = "7";
	public final String EMAIL_RESPONSAVEL = "lucio@cnf.org.br";
	
	public final String NODE_STRING = "string";
	public final String NODE_CONTEUDO = "Conteudo";
	public final String NODE_STATUS_PEDIDO = "PedidoStatus";
	public final String NODE_RETORNO = "Retorno";
	public final String NODE_MENSAGEM = "Mensagem";
	
	public final String MOEDA_DIGITAL_EM_ANALISE = "EM ANALISE";
	public final String MOEDA_DIGITAL_PENDENTE = "PENDENTE";
	public final String MOEDA_DIGITAL_APROVADO = "APROVADO";
	public final String MOEDA_DIGITAL_REPROVADO = "REPROVADO";
	public final String MOEDA_DIGITAL_NEGADO = "NEGADO";
	public final String MOEDA_DIGITAL_CANCELADO = "CANCELADO";
	
	public final String MOEDA_DIGITAL_MEIOS_PAGAMENTO_TODOS = "Todos";
	public final String MOEDA_DIGITAL_MEIOS_PAGAMENTO_HTML = "moedaDigitalMeiosPagamentoHtml";
	public final String MOEDA_DIGITAL_MENSAGEM_HTML = "moedaDigitalMensagemHtml";
	public final String MOEDA_DIGITAL_PEDIDO_ID = "moedaDigitalPedidoId";
	
	public final String MOEDA_DIGITAL_LISTA_RETORNO_MEIOS_PAGAMENTO = "listaRetornoMeiosPagamento";
	public final String MOEDA_DIGITAL_LISTA_RETORNO_PARCELAS = "listaRetornoParcelas";
	public final String MOEDA_DIGITAL_ENCONTROU_MEIOS_PAGAMENTO = "encontrouMeiosPagamento";
	public final String MOEDA_DIGITAL_ENCONTROU_MEIOS_PAGAMENTO_BOLETO = "encontrouMeiosPagamentoBoleto";
	public final String MOEDA_DIGITAL_ENCONTROU_MEIOS_PAGAMENTO_CARTAO = "encontrouMeiosPagamentoCartao";
	public final String EXIBIR_CREDITO_EM_CONTA = "exibirCreditoEmConta";
}

