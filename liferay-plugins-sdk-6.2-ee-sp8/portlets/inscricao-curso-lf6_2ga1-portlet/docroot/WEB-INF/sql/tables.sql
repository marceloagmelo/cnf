create table cnf_CursoInscricao (
	inscricaoId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userCreateId LONG,
	userCreateName VARCHAR(75) null,
	userModifiedId LONG,
	userModifiedName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	cursoId LONG,
	cursoNome VARCHAR(300) null,
	cursoData VARCHAR(75) null,
	cursoHorario VARCHAR(300) null,
	cursoLocal VARCHAR(300) null,
	preco VARCHAR(75) null,
	precoConvenio VARCHAR(75) null,
	precoAssociado VARCHAR(75) null,
	tipoFisicaJuridica VARCHAR(75) null,
	cpfCnpj VARCHAR(75) null,
	nomeResponsavel VARCHAR(300) null,
	emailPrincipal VARCHAR(300) null,
	dddTelefoneComercial VARCHAR(2) null,
	telefoneComercial VARCHAR(10) null,
	sexo VARCHAR(75) null,
	cadastroFinalizado BOOLEAN,
	formaPagamento VARCHAR(75) null,
	numeroCartao VARCHAR(75) null,
	validadeCartaoMes INTEGER,
	validadeCartaoAno INTEGER,
	nomeTitularCartao VARCHAR(75) null,
	codigoSegurancaCartao VARCHAR(75) null,
	statusMoedaDigital VARCHAR(75) null,
	quantidadeParcelas INTEGER,
	valorTotal DOUBLE,
	moedaDigitalPedido VARCHAR(75) null,
	dataInicio DATE null
);

create table cnf_CursoInscricaoCnpj (
	inscricaoCnpjId LONG not null primary key,
	inscricaoId LONG,
	razaoSocial VARCHAR(300) null,
	nomeFantasia VARCHAR(300) null,
	inscricaoEstadual VARCHAR(75) null,
	endereco VARCHAR(300) null,
	bairro VARCHAR(75) null,
	cidade VARCHAR(75) null,
	estado VARCHAR(75) null,
	cep VARCHAR(75) null,
	dddTelefone VARCHAR(2) null,
	telefone VARCHAR(10) null,
	nfNome VARCHAR(300) null,
	nfDepartamento VARCHAR(75) null,
	nfEmail VARCHAR(300) null,
	nfDddTelefone VARCHAR(2) null,
	nfTelefone VARCHAR(10) null,
	observacao VARCHAR(1000) null
);

create table cnf_CursoInscricaoCpf (
	inscricaoCpfId LONG not null primary key,
	inscricaoId LONG,
	nome VARCHAR(300) null,
	cpf VARCHAR(75) null,
	endereco VARCHAR(300) null,
	bairro VARCHAR(75) null,
	cidade VARCHAR(75) null,
	estado VARCHAR(75) null,
	cep VARCHAR(75) null,
	dddTelefone VARCHAR(2) null,
	telefone VARCHAR(10) null,
	email VARCHAR(300) null,
	empresa VARCHAR(75) null,
	cargo VARCHAR(75) null,
	departamento VARCHAR(75) null,
	observacao VARCHAR(1000) null
);

create table cnf_CursoParticipante (
	participanteId LONG not null primary key,
	inscricaoId LONG,
	nomeCompleto VARCHAR(300) null,
	nomeCracha VARCHAR(100) null,
	cpf VARCHAR(75) null,
	sexo VARCHAR(75) null,
	cargo VARCHAR(75) null,
	empresaOndeTrabalha VARCHAR(100) null,
	departamento VARCHAR(75) null,
	formacaoAcademica VARCHAR(300) null,
	emailPrincipal VARCHAR(300) null,
	emailOpcional VARCHAR(300) null,
	dddTelefoneComercial VARCHAR(2) null,
	telefoneComercial VARCHAR(10) null,
	dddTelefonePessoal VARCHAR(2) null,
	telefonePessoal VARCHAR(10) null,
	dddTelefoneCelular VARCHAR(2) null,
	telefoneCelular VARCHAR(300) null,
	endereco VARCHAR(300) null,
	bairro VARCHAR(75) null,
	cidade VARCHAR(75) null,
	estado VARCHAR(75) null,
	cep VARCHAR(75) null,
	valorPago VARCHAR(75) null,
	expectativaCurso VARCHAR(300) null,
	observacao VARCHAR(300) null
);

create table cnf_PedidoMoedaDigital (
	pedidoMoedaDigitalId LONG not null primary key,
	inscricaoId LONG,
	dataPedido DATE null,
	xmlEnvio STRING null,
	xmlRetorno STRING null
);