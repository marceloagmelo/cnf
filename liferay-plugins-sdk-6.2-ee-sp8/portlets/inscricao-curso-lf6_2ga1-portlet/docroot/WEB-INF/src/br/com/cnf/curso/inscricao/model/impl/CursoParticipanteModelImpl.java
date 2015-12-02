/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package br.com.cnf.curso.inscricao.model.impl;

import br.com.cnf.curso.inscricao.model.CursoParticipante;
import br.com.cnf.curso.inscricao.model.CursoParticipanteModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the CursoParticipante service. Represents a row in the &quot;cnf_CursoParticipante&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link br.com.cnf.curso.inscricao.model.CursoParticipanteModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CursoParticipanteImpl}.
 * </p>
 *
 * @author SEA
 * @see CursoParticipanteImpl
 * @see br.com.cnf.curso.inscricao.model.CursoParticipante
 * @see br.com.cnf.curso.inscricao.model.CursoParticipanteModel
 * @generated
 */
public class CursoParticipanteModelImpl extends BaseModelImpl<CursoParticipante>
	implements CursoParticipanteModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a curso participante model instance should use the {@link br.com.cnf.curso.inscricao.model.CursoParticipante} interface instead.
	 */
	public static final String TABLE_NAME = "cnf_CursoParticipante";
	public static final Object[][] TABLE_COLUMNS = {
			{ "participanteId", Types.BIGINT },
			{ "inscricaoId", Types.BIGINT },
			{ "nomeCompleto", Types.VARCHAR },
			{ "nomeCracha", Types.VARCHAR },
			{ "cpf", Types.VARCHAR },
			{ "sexo", Types.VARCHAR },
			{ "cargo", Types.VARCHAR },
			{ "empresaOndeTrabalha", Types.VARCHAR },
			{ "departamento", Types.VARCHAR },
			{ "formacaoAcademica", Types.VARCHAR },
			{ "emailPrincipal", Types.VARCHAR },
			{ "emailOpcional", Types.VARCHAR },
			{ "dddTelefoneComercial", Types.VARCHAR },
			{ "telefoneComercial", Types.VARCHAR },
			{ "dddTelefonePessoal", Types.VARCHAR },
			{ "telefonePessoal", Types.VARCHAR },
			{ "dddTelefoneCelular", Types.VARCHAR },
			{ "telefoneCelular", Types.VARCHAR },
			{ "endereco", Types.VARCHAR },
			{ "bairro", Types.VARCHAR },
			{ "cidade", Types.VARCHAR },
			{ "estado", Types.VARCHAR },
			{ "cep", Types.VARCHAR },
			{ "valorPago", Types.VARCHAR },
			{ "expectativaCurso", Types.VARCHAR },
			{ "observacao", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table cnf_CursoParticipante (participanteId LONG not null primary key,inscricaoId LONG,nomeCompleto VARCHAR(300) null,nomeCracha VARCHAR(100) null,cpf VARCHAR(75) null,sexo VARCHAR(75) null,cargo VARCHAR(75) null,empresaOndeTrabalha VARCHAR(100) null,departamento VARCHAR(75) null,formacaoAcademica VARCHAR(300) null,emailPrincipal VARCHAR(300) null,emailOpcional VARCHAR(300) null,dddTelefoneComercial VARCHAR(2) null,telefoneComercial VARCHAR(10) null,dddTelefonePessoal VARCHAR(2) null,telefonePessoal VARCHAR(10) null,dddTelefoneCelular VARCHAR(2) null,telefoneCelular VARCHAR(300) null,endereco VARCHAR(300) null,bairro VARCHAR(75) null,cidade VARCHAR(75) null,estado VARCHAR(75) null,cep VARCHAR(75) null,valorPago VARCHAR(75) null,expectativaCurso VARCHAR(300) null,observacao VARCHAR(300) null)";
	public static final String TABLE_SQL_DROP = "drop table cnf_CursoParticipante";
	public static final String ORDER_BY_JPQL = " ORDER BY cursoParticipante.nomeCompleto ASC";
	public static final String ORDER_BY_SQL = " ORDER BY cnf_CursoParticipante.nomeCompleto ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.br.com.cnf.curso.inscricao.model.CursoParticipante"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.br.com.cnf.curso.inscricao.model.CursoParticipante"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.br.com.cnf.curso.inscricao.model.CursoParticipante"));

	public CursoParticipanteModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _participanteId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setParticipanteId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _participanteId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CursoParticipante.class;
	}

	@Override
	public String getModelClassName() {
		return CursoParticipante.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("participanteId", getParticipanteId());
		attributes.put("inscricaoId", getInscricaoId());
		attributes.put("nomeCompleto", getNomeCompleto());
		attributes.put("nomeCracha", getNomeCracha());
		attributes.put("cpf", getCpf());
		attributes.put("sexo", getSexo());
		attributes.put("cargo", getCargo());
		attributes.put("empresaOndeTrabalha", getEmpresaOndeTrabalha());
		attributes.put("departamento", getDepartamento());
		attributes.put("formacaoAcademica", getFormacaoAcademica());
		attributes.put("emailPrincipal", getEmailPrincipal());
		attributes.put("emailOpcional", getEmailOpcional());
		attributes.put("dddTelefoneComercial", getDddTelefoneComercial());
		attributes.put("telefoneComercial", getTelefoneComercial());
		attributes.put("dddTelefonePessoal", getDddTelefonePessoal());
		attributes.put("telefonePessoal", getTelefonePessoal());
		attributes.put("dddTelefoneCelular", getDddTelefoneCelular());
		attributes.put("telefoneCelular", getTelefoneCelular());
		attributes.put("endereco", getEndereco());
		attributes.put("bairro", getBairro());
		attributes.put("cidade", getCidade());
		attributes.put("estado", getEstado());
		attributes.put("cep", getCep());
		attributes.put("valorPago", getValorPago());
		attributes.put("expectativaCurso", getExpectativaCurso());
		attributes.put("observacao", getObservacao());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long participanteId = (Long)attributes.get("participanteId");

		if (participanteId != null) {
			setParticipanteId(participanteId);
		}

		Long inscricaoId = (Long)attributes.get("inscricaoId");

		if (inscricaoId != null) {
			setInscricaoId(inscricaoId);
		}

		String nomeCompleto = (String)attributes.get("nomeCompleto");

		if (nomeCompleto != null) {
			setNomeCompleto(nomeCompleto);
		}

		String nomeCracha = (String)attributes.get("nomeCracha");

		if (nomeCracha != null) {
			setNomeCracha(nomeCracha);
		}

		String cpf = (String)attributes.get("cpf");

		if (cpf != null) {
			setCpf(cpf);
		}

		String sexo = (String)attributes.get("sexo");

		if (sexo != null) {
			setSexo(sexo);
		}

		String cargo = (String)attributes.get("cargo");

		if (cargo != null) {
			setCargo(cargo);
		}

		String empresaOndeTrabalha = (String)attributes.get(
				"empresaOndeTrabalha");

		if (empresaOndeTrabalha != null) {
			setEmpresaOndeTrabalha(empresaOndeTrabalha);
		}

		String departamento = (String)attributes.get("departamento");

		if (departamento != null) {
			setDepartamento(departamento);
		}

		String formacaoAcademica = (String)attributes.get("formacaoAcademica");

		if (formacaoAcademica != null) {
			setFormacaoAcademica(formacaoAcademica);
		}

		String emailPrincipal = (String)attributes.get("emailPrincipal");

		if (emailPrincipal != null) {
			setEmailPrincipal(emailPrincipal);
		}

		String emailOpcional = (String)attributes.get("emailOpcional");

		if (emailOpcional != null) {
			setEmailOpcional(emailOpcional);
		}

		String dddTelefoneComercial = (String)attributes.get(
				"dddTelefoneComercial");

		if (dddTelefoneComercial != null) {
			setDddTelefoneComercial(dddTelefoneComercial);
		}

		String telefoneComercial = (String)attributes.get("telefoneComercial");

		if (telefoneComercial != null) {
			setTelefoneComercial(telefoneComercial);
		}

		String dddTelefonePessoal = (String)attributes.get("dddTelefonePessoal");

		if (dddTelefonePessoal != null) {
			setDddTelefonePessoal(dddTelefonePessoal);
		}

		String telefonePessoal = (String)attributes.get("telefonePessoal");

		if (telefonePessoal != null) {
			setTelefonePessoal(telefonePessoal);
		}

		String dddTelefoneCelular = (String)attributes.get("dddTelefoneCelular");

		if (dddTelefoneCelular != null) {
			setDddTelefoneCelular(dddTelefoneCelular);
		}

		String telefoneCelular = (String)attributes.get("telefoneCelular");

		if (telefoneCelular != null) {
			setTelefoneCelular(telefoneCelular);
		}

		String endereco = (String)attributes.get("endereco");

		if (endereco != null) {
			setEndereco(endereco);
		}

		String bairro = (String)attributes.get("bairro");

		if (bairro != null) {
			setBairro(bairro);
		}

		String cidade = (String)attributes.get("cidade");

		if (cidade != null) {
			setCidade(cidade);
		}

		String estado = (String)attributes.get("estado");

		if (estado != null) {
			setEstado(estado);
		}

		String cep = (String)attributes.get("cep");

		if (cep != null) {
			setCep(cep);
		}

		String valorPago = (String)attributes.get("valorPago");

		if (valorPago != null) {
			setValorPago(valorPago);
		}

		String expectativaCurso = (String)attributes.get("expectativaCurso");

		if (expectativaCurso != null) {
			setExpectativaCurso(expectativaCurso);
		}

		String observacao = (String)attributes.get("observacao");

		if (observacao != null) {
			setObservacao(observacao);
		}
	}

	@Override
	public long getParticipanteId() {
		return _participanteId;
	}

	@Override
	public void setParticipanteId(long participanteId) {
		_participanteId = participanteId;
	}

	@Override
	public long getInscricaoId() {
		return _inscricaoId;
	}

	@Override
	public void setInscricaoId(long inscricaoId) {
		_inscricaoId = inscricaoId;
	}

	@Override
	public String getNomeCompleto() {
		if (_nomeCompleto == null) {
			return StringPool.BLANK;
		}
		else {
			return _nomeCompleto;
		}
	}

	@Override
	public void setNomeCompleto(String nomeCompleto) {
		_nomeCompleto = nomeCompleto;
	}

	@Override
	public String getNomeCracha() {
		if (_nomeCracha == null) {
			return StringPool.BLANK;
		}
		else {
			return _nomeCracha;
		}
	}

	@Override
	public void setNomeCracha(String nomeCracha) {
		_nomeCracha = nomeCracha;
	}

	@Override
	public String getCpf() {
		if (_cpf == null) {
			return StringPool.BLANK;
		}
		else {
			return _cpf;
		}
	}

	@Override
	public void setCpf(String cpf) {
		_cpf = cpf;
	}

	@Override
	public String getSexo() {
		if (_sexo == null) {
			return StringPool.BLANK;
		}
		else {
			return _sexo;
		}
	}

	@Override
	public void setSexo(String sexo) {
		_sexo = sexo;
	}

	@Override
	public String getCargo() {
		if (_cargo == null) {
			return StringPool.BLANK;
		}
		else {
			return _cargo;
		}
	}

	@Override
	public void setCargo(String cargo) {
		_cargo = cargo;
	}

	@Override
	public String getEmpresaOndeTrabalha() {
		if (_empresaOndeTrabalha == null) {
			return StringPool.BLANK;
		}
		else {
			return _empresaOndeTrabalha;
		}
	}

	@Override
	public void setEmpresaOndeTrabalha(String empresaOndeTrabalha) {
		_empresaOndeTrabalha = empresaOndeTrabalha;
	}

	@Override
	public String getDepartamento() {
		if (_departamento == null) {
			return StringPool.BLANK;
		}
		else {
			return _departamento;
		}
	}

	@Override
	public void setDepartamento(String departamento) {
		_departamento = departamento;
	}

	@Override
	public String getFormacaoAcademica() {
		if (_formacaoAcademica == null) {
			return StringPool.BLANK;
		}
		else {
			return _formacaoAcademica;
		}
	}

	@Override
	public void setFormacaoAcademica(String formacaoAcademica) {
		_formacaoAcademica = formacaoAcademica;
	}

	@Override
	public String getEmailPrincipal() {
		if (_emailPrincipal == null) {
			return StringPool.BLANK;
		}
		else {
			return _emailPrincipal;
		}
	}

	@Override
	public void setEmailPrincipal(String emailPrincipal) {
		_emailPrincipal = emailPrincipal;
	}

	@Override
	public String getEmailOpcional() {
		if (_emailOpcional == null) {
			return StringPool.BLANK;
		}
		else {
			return _emailOpcional;
		}
	}

	@Override
	public void setEmailOpcional(String emailOpcional) {
		_emailOpcional = emailOpcional;
	}

	@Override
	public String getDddTelefoneComercial() {
		if (_dddTelefoneComercial == null) {
			return StringPool.BLANK;
		}
		else {
			return _dddTelefoneComercial;
		}
	}

	@Override
	public void setDddTelefoneComercial(String dddTelefoneComercial) {
		_dddTelefoneComercial = dddTelefoneComercial;
	}

	@Override
	public String getTelefoneComercial() {
		if (_telefoneComercial == null) {
			return StringPool.BLANK;
		}
		else {
			return _telefoneComercial;
		}
	}

	@Override
	public void setTelefoneComercial(String telefoneComercial) {
		_telefoneComercial = telefoneComercial;
	}

	@Override
	public String getDddTelefonePessoal() {
		if (_dddTelefonePessoal == null) {
			return StringPool.BLANK;
		}
		else {
			return _dddTelefonePessoal;
		}
	}

	@Override
	public void setDddTelefonePessoal(String dddTelefonePessoal) {
		_dddTelefonePessoal = dddTelefonePessoal;
	}

	@Override
	public String getTelefonePessoal() {
		if (_telefonePessoal == null) {
			return StringPool.BLANK;
		}
		else {
			return _telefonePessoal;
		}
	}

	@Override
	public void setTelefonePessoal(String telefonePessoal) {
		_telefonePessoal = telefonePessoal;
	}

	@Override
	public String getDddTelefoneCelular() {
		if (_dddTelefoneCelular == null) {
			return StringPool.BLANK;
		}
		else {
			return _dddTelefoneCelular;
		}
	}

	@Override
	public void setDddTelefoneCelular(String dddTelefoneCelular) {
		_dddTelefoneCelular = dddTelefoneCelular;
	}

	@Override
	public String getTelefoneCelular() {
		if (_telefoneCelular == null) {
			return StringPool.BLANK;
		}
		else {
			return _telefoneCelular;
		}
	}

	@Override
	public void setTelefoneCelular(String telefoneCelular) {
		_telefoneCelular = telefoneCelular;
	}

	@Override
	public String getEndereco() {
		if (_endereco == null) {
			return StringPool.BLANK;
		}
		else {
			return _endereco;
		}
	}

	@Override
	public void setEndereco(String endereco) {
		_endereco = endereco;
	}

	@Override
	public String getBairro() {
		if (_bairro == null) {
			return StringPool.BLANK;
		}
		else {
			return _bairro;
		}
	}

	@Override
	public void setBairro(String bairro) {
		_bairro = bairro;
	}

	@Override
	public String getCidade() {
		if (_cidade == null) {
			return StringPool.BLANK;
		}
		else {
			return _cidade;
		}
	}

	@Override
	public void setCidade(String cidade) {
		_cidade = cidade;
	}

	@Override
	public String getEstado() {
		if (_estado == null) {
			return StringPool.BLANK;
		}
		else {
			return _estado;
		}
	}

	@Override
	public void setEstado(String estado) {
		_estado = estado;
	}

	@Override
	public String getCep() {
		if (_cep == null) {
			return StringPool.BLANK;
		}
		else {
			return _cep;
		}
	}

	@Override
	public void setCep(String cep) {
		_cep = cep;
	}

	@Override
	public String getValorPago() {
		if (_valorPago == null) {
			return StringPool.BLANK;
		}
		else {
			return _valorPago;
		}
	}

	@Override
	public void setValorPago(String valorPago) {
		_valorPago = valorPago;
	}

	@Override
	public String getExpectativaCurso() {
		if (_expectativaCurso == null) {
			return StringPool.BLANK;
		}
		else {
			return _expectativaCurso;
		}
	}

	@Override
	public void setExpectativaCurso(String expectativaCurso) {
		_expectativaCurso = expectativaCurso;
	}

	@Override
	public String getObservacao() {
		if (_observacao == null) {
			return StringPool.BLANK;
		}
		else {
			return _observacao;
		}
	}

	@Override
	public void setObservacao(String observacao) {
		_observacao = observacao;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			CursoParticipante.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CursoParticipante toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CursoParticipante)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CursoParticipanteImpl cursoParticipanteImpl = new CursoParticipanteImpl();

		cursoParticipanteImpl.setParticipanteId(getParticipanteId());
		cursoParticipanteImpl.setInscricaoId(getInscricaoId());
		cursoParticipanteImpl.setNomeCompleto(getNomeCompleto());
		cursoParticipanteImpl.setNomeCracha(getNomeCracha());
		cursoParticipanteImpl.setCpf(getCpf());
		cursoParticipanteImpl.setSexo(getSexo());
		cursoParticipanteImpl.setCargo(getCargo());
		cursoParticipanteImpl.setEmpresaOndeTrabalha(getEmpresaOndeTrabalha());
		cursoParticipanteImpl.setDepartamento(getDepartamento());
		cursoParticipanteImpl.setFormacaoAcademica(getFormacaoAcademica());
		cursoParticipanteImpl.setEmailPrincipal(getEmailPrincipal());
		cursoParticipanteImpl.setEmailOpcional(getEmailOpcional());
		cursoParticipanteImpl.setDddTelefoneComercial(getDddTelefoneComercial());
		cursoParticipanteImpl.setTelefoneComercial(getTelefoneComercial());
		cursoParticipanteImpl.setDddTelefonePessoal(getDddTelefonePessoal());
		cursoParticipanteImpl.setTelefonePessoal(getTelefonePessoal());
		cursoParticipanteImpl.setDddTelefoneCelular(getDddTelefoneCelular());
		cursoParticipanteImpl.setTelefoneCelular(getTelefoneCelular());
		cursoParticipanteImpl.setEndereco(getEndereco());
		cursoParticipanteImpl.setBairro(getBairro());
		cursoParticipanteImpl.setCidade(getCidade());
		cursoParticipanteImpl.setEstado(getEstado());
		cursoParticipanteImpl.setCep(getCep());
		cursoParticipanteImpl.setValorPago(getValorPago());
		cursoParticipanteImpl.setExpectativaCurso(getExpectativaCurso());
		cursoParticipanteImpl.setObservacao(getObservacao());

		cursoParticipanteImpl.resetOriginalValues();

		return cursoParticipanteImpl;
	}

	@Override
	public int compareTo(CursoParticipante cursoParticipante) {
		int value = 0;

		value = getNomeCompleto().compareTo(cursoParticipante.getNomeCompleto());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CursoParticipante)) {
			return false;
		}

		CursoParticipante cursoParticipante = (CursoParticipante)obj;

		long primaryKey = cursoParticipante.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<CursoParticipante> toCacheModel() {
		CursoParticipanteCacheModel cursoParticipanteCacheModel = new CursoParticipanteCacheModel();

		cursoParticipanteCacheModel.participanteId = getParticipanteId();

		cursoParticipanteCacheModel.inscricaoId = getInscricaoId();

		cursoParticipanteCacheModel.nomeCompleto = getNomeCompleto();

		String nomeCompleto = cursoParticipanteCacheModel.nomeCompleto;

		if ((nomeCompleto != null) && (nomeCompleto.length() == 0)) {
			cursoParticipanteCacheModel.nomeCompleto = null;
		}

		cursoParticipanteCacheModel.nomeCracha = getNomeCracha();

		String nomeCracha = cursoParticipanteCacheModel.nomeCracha;

		if ((nomeCracha != null) && (nomeCracha.length() == 0)) {
			cursoParticipanteCacheModel.nomeCracha = null;
		}

		cursoParticipanteCacheModel.cpf = getCpf();

		String cpf = cursoParticipanteCacheModel.cpf;

		if ((cpf != null) && (cpf.length() == 0)) {
			cursoParticipanteCacheModel.cpf = null;
		}

		cursoParticipanteCacheModel.sexo = getSexo();

		String sexo = cursoParticipanteCacheModel.sexo;

		if ((sexo != null) && (sexo.length() == 0)) {
			cursoParticipanteCacheModel.sexo = null;
		}

		cursoParticipanteCacheModel.cargo = getCargo();

		String cargo = cursoParticipanteCacheModel.cargo;

		if ((cargo != null) && (cargo.length() == 0)) {
			cursoParticipanteCacheModel.cargo = null;
		}

		cursoParticipanteCacheModel.empresaOndeTrabalha = getEmpresaOndeTrabalha();

		String empresaOndeTrabalha = cursoParticipanteCacheModel.empresaOndeTrabalha;

		if ((empresaOndeTrabalha != null) &&
				(empresaOndeTrabalha.length() == 0)) {
			cursoParticipanteCacheModel.empresaOndeTrabalha = null;
		}

		cursoParticipanteCacheModel.departamento = getDepartamento();

		String departamento = cursoParticipanteCacheModel.departamento;

		if ((departamento != null) && (departamento.length() == 0)) {
			cursoParticipanteCacheModel.departamento = null;
		}

		cursoParticipanteCacheModel.formacaoAcademica = getFormacaoAcademica();

		String formacaoAcademica = cursoParticipanteCacheModel.formacaoAcademica;

		if ((formacaoAcademica != null) && (formacaoAcademica.length() == 0)) {
			cursoParticipanteCacheModel.formacaoAcademica = null;
		}

		cursoParticipanteCacheModel.emailPrincipal = getEmailPrincipal();

		String emailPrincipal = cursoParticipanteCacheModel.emailPrincipal;

		if ((emailPrincipal != null) && (emailPrincipal.length() == 0)) {
			cursoParticipanteCacheModel.emailPrincipal = null;
		}

		cursoParticipanteCacheModel.emailOpcional = getEmailOpcional();

		String emailOpcional = cursoParticipanteCacheModel.emailOpcional;

		if ((emailOpcional != null) && (emailOpcional.length() == 0)) {
			cursoParticipanteCacheModel.emailOpcional = null;
		}

		cursoParticipanteCacheModel.dddTelefoneComercial = getDddTelefoneComercial();

		String dddTelefoneComercial = cursoParticipanteCacheModel.dddTelefoneComercial;

		if ((dddTelefoneComercial != null) &&
				(dddTelefoneComercial.length() == 0)) {
			cursoParticipanteCacheModel.dddTelefoneComercial = null;
		}

		cursoParticipanteCacheModel.telefoneComercial = getTelefoneComercial();

		String telefoneComercial = cursoParticipanteCacheModel.telefoneComercial;

		if ((telefoneComercial != null) && (telefoneComercial.length() == 0)) {
			cursoParticipanteCacheModel.telefoneComercial = null;
		}

		cursoParticipanteCacheModel.dddTelefonePessoal = getDddTelefonePessoal();

		String dddTelefonePessoal = cursoParticipanteCacheModel.dddTelefonePessoal;

		if ((dddTelefonePessoal != null) && (dddTelefonePessoal.length() == 0)) {
			cursoParticipanteCacheModel.dddTelefonePessoal = null;
		}

		cursoParticipanteCacheModel.telefonePessoal = getTelefonePessoal();

		String telefonePessoal = cursoParticipanteCacheModel.telefonePessoal;

		if ((telefonePessoal != null) && (telefonePessoal.length() == 0)) {
			cursoParticipanteCacheModel.telefonePessoal = null;
		}

		cursoParticipanteCacheModel.dddTelefoneCelular = getDddTelefoneCelular();

		String dddTelefoneCelular = cursoParticipanteCacheModel.dddTelefoneCelular;

		if ((dddTelefoneCelular != null) && (dddTelefoneCelular.length() == 0)) {
			cursoParticipanteCacheModel.dddTelefoneCelular = null;
		}

		cursoParticipanteCacheModel.telefoneCelular = getTelefoneCelular();

		String telefoneCelular = cursoParticipanteCacheModel.telefoneCelular;

		if ((telefoneCelular != null) && (telefoneCelular.length() == 0)) {
			cursoParticipanteCacheModel.telefoneCelular = null;
		}

		cursoParticipanteCacheModel.endereco = getEndereco();

		String endereco = cursoParticipanteCacheModel.endereco;

		if ((endereco != null) && (endereco.length() == 0)) {
			cursoParticipanteCacheModel.endereco = null;
		}

		cursoParticipanteCacheModel.bairro = getBairro();

		String bairro = cursoParticipanteCacheModel.bairro;

		if ((bairro != null) && (bairro.length() == 0)) {
			cursoParticipanteCacheModel.bairro = null;
		}

		cursoParticipanteCacheModel.cidade = getCidade();

		String cidade = cursoParticipanteCacheModel.cidade;

		if ((cidade != null) && (cidade.length() == 0)) {
			cursoParticipanteCacheModel.cidade = null;
		}

		cursoParticipanteCacheModel.estado = getEstado();

		String estado = cursoParticipanteCacheModel.estado;

		if ((estado != null) && (estado.length() == 0)) {
			cursoParticipanteCacheModel.estado = null;
		}

		cursoParticipanteCacheModel.cep = getCep();

		String cep = cursoParticipanteCacheModel.cep;

		if ((cep != null) && (cep.length() == 0)) {
			cursoParticipanteCacheModel.cep = null;
		}

		cursoParticipanteCacheModel.valorPago = getValorPago();

		String valorPago = cursoParticipanteCacheModel.valorPago;

		if ((valorPago != null) && (valorPago.length() == 0)) {
			cursoParticipanteCacheModel.valorPago = null;
		}

		cursoParticipanteCacheModel.expectativaCurso = getExpectativaCurso();

		String expectativaCurso = cursoParticipanteCacheModel.expectativaCurso;

		if ((expectativaCurso != null) && (expectativaCurso.length() == 0)) {
			cursoParticipanteCacheModel.expectativaCurso = null;
		}

		cursoParticipanteCacheModel.observacao = getObservacao();

		String observacao = cursoParticipanteCacheModel.observacao;

		if ((observacao != null) && (observacao.length() == 0)) {
			cursoParticipanteCacheModel.observacao = null;
		}

		return cursoParticipanteCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{participanteId=");
		sb.append(getParticipanteId());
		sb.append(", inscricaoId=");
		sb.append(getInscricaoId());
		sb.append(", nomeCompleto=");
		sb.append(getNomeCompleto());
		sb.append(", nomeCracha=");
		sb.append(getNomeCracha());
		sb.append(", cpf=");
		sb.append(getCpf());
		sb.append(", sexo=");
		sb.append(getSexo());
		sb.append(", cargo=");
		sb.append(getCargo());
		sb.append(", empresaOndeTrabalha=");
		sb.append(getEmpresaOndeTrabalha());
		sb.append(", departamento=");
		sb.append(getDepartamento());
		sb.append(", formacaoAcademica=");
		sb.append(getFormacaoAcademica());
		sb.append(", emailPrincipal=");
		sb.append(getEmailPrincipal());
		sb.append(", emailOpcional=");
		sb.append(getEmailOpcional());
		sb.append(", dddTelefoneComercial=");
		sb.append(getDddTelefoneComercial());
		sb.append(", telefoneComercial=");
		sb.append(getTelefoneComercial());
		sb.append(", dddTelefonePessoal=");
		sb.append(getDddTelefonePessoal());
		sb.append(", telefonePessoal=");
		sb.append(getTelefonePessoal());
		sb.append(", dddTelefoneCelular=");
		sb.append(getDddTelefoneCelular());
		sb.append(", telefoneCelular=");
		sb.append(getTelefoneCelular());
		sb.append(", endereco=");
		sb.append(getEndereco());
		sb.append(", bairro=");
		sb.append(getBairro());
		sb.append(", cidade=");
		sb.append(getCidade());
		sb.append(", estado=");
		sb.append(getEstado());
		sb.append(", cep=");
		sb.append(getCep());
		sb.append(", valorPago=");
		sb.append(getValorPago());
		sb.append(", expectativaCurso=");
		sb.append(getExpectativaCurso());
		sb.append(", observacao=");
		sb.append(getObservacao());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(82);

		sb.append("<model><model-name>");
		sb.append("br.com.cnf.curso.inscricao.model.CursoParticipante");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>participanteId</column-name><column-value><![CDATA[");
		sb.append(getParticipanteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inscricaoId</column-name><column-value><![CDATA[");
		sb.append(getInscricaoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nomeCompleto</column-name><column-value><![CDATA[");
		sb.append(getNomeCompleto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nomeCracha</column-name><column-value><![CDATA[");
		sb.append(getNomeCracha());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cpf</column-name><column-value><![CDATA[");
		sb.append(getCpf());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sexo</column-name><column-value><![CDATA[");
		sb.append(getSexo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cargo</column-name><column-value><![CDATA[");
		sb.append(getCargo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>empresaOndeTrabalha</column-name><column-value><![CDATA[");
		sb.append(getEmpresaOndeTrabalha());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departamento</column-name><column-value><![CDATA[");
		sb.append(getDepartamento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>formacaoAcademica</column-name><column-value><![CDATA[");
		sb.append(getFormacaoAcademica());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailPrincipal</column-name><column-value><![CDATA[");
		sb.append(getEmailPrincipal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailOpcional</column-name><column-value><![CDATA[");
		sb.append(getEmailOpcional());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dddTelefoneComercial</column-name><column-value><![CDATA[");
		sb.append(getDddTelefoneComercial());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telefoneComercial</column-name><column-value><![CDATA[");
		sb.append(getTelefoneComercial());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dddTelefonePessoal</column-name><column-value><![CDATA[");
		sb.append(getDddTelefonePessoal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telefonePessoal</column-name><column-value><![CDATA[");
		sb.append(getTelefonePessoal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dddTelefoneCelular</column-name><column-value><![CDATA[");
		sb.append(getDddTelefoneCelular());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telefoneCelular</column-name><column-value><![CDATA[");
		sb.append(getTelefoneCelular());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endereco</column-name><column-value><![CDATA[");
		sb.append(getEndereco());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bairro</column-name><column-value><![CDATA[");
		sb.append(getBairro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cidade</column-name><column-value><![CDATA[");
		sb.append(getCidade());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>estado</column-name><column-value><![CDATA[");
		sb.append(getEstado());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cep</column-name><column-value><![CDATA[");
		sb.append(getCep());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valorPago</column-name><column-value><![CDATA[");
		sb.append(getValorPago());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expectativaCurso</column-name><column-value><![CDATA[");
		sb.append(getExpectativaCurso());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>observacao</column-name><column-value><![CDATA[");
		sb.append(getObservacao());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CursoParticipante.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			CursoParticipante.class
		};
	private long _participanteId;
	private long _inscricaoId;
	private String _nomeCompleto;
	private String _nomeCracha;
	private String _cpf;
	private String _sexo;
	private String _cargo;
	private String _empresaOndeTrabalha;
	private String _departamento;
	private String _formacaoAcademica;
	private String _emailPrincipal;
	private String _emailOpcional;
	private String _dddTelefoneComercial;
	private String _telefoneComercial;
	private String _dddTelefonePessoal;
	private String _telefonePessoal;
	private String _dddTelefoneCelular;
	private String _telefoneCelular;
	private String _endereco;
	private String _bairro;
	private String _cidade;
	private String _estado;
	private String _cep;
	private String _valorPago;
	private String _expectativaCurso;
	private String _observacao;
	private CursoParticipante _escapedModel;
}