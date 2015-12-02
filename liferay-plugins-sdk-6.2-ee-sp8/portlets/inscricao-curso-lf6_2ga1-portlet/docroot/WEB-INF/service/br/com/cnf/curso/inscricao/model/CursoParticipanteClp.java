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

package br.com.cnf.curso.inscricao.model;

import br.com.cnf.curso.inscricao.service.ClpSerializer;
import br.com.cnf.curso.inscricao.service.CursoParticipanteLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SEA
 */
public class CursoParticipanteClp extends BaseModelImpl<CursoParticipante>
	implements CursoParticipante {
	public CursoParticipanteClp() {
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

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setParticipanteId", long.class);

				method.invoke(_cursoParticipanteRemoteModel, participanteId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getInscricaoId() {
		return _inscricaoId;
	}

	@Override
	public void setInscricaoId(long inscricaoId) {
		_inscricaoId = inscricaoId;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setInscricaoId", long.class);

				method.invoke(_cursoParticipanteRemoteModel, inscricaoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNomeCompleto() {
		return _nomeCompleto;
	}

	@Override
	public void setNomeCompleto(String nomeCompleto) {
		_nomeCompleto = nomeCompleto;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setNomeCompleto", String.class);

				method.invoke(_cursoParticipanteRemoteModel, nomeCompleto);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNomeCracha() {
		return _nomeCracha;
	}

	@Override
	public void setNomeCracha(String nomeCracha) {
		_nomeCracha = nomeCracha;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setNomeCracha", String.class);

				method.invoke(_cursoParticipanteRemoteModel, nomeCracha);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCpf() {
		return _cpf;
	}

	@Override
	public void setCpf(String cpf) {
		_cpf = cpf;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setCpf", String.class);

				method.invoke(_cursoParticipanteRemoteModel, cpf);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSexo() {
		return _sexo;
	}

	@Override
	public void setSexo(String sexo) {
		_sexo = sexo;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setSexo", String.class);

				method.invoke(_cursoParticipanteRemoteModel, sexo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCargo() {
		return _cargo;
	}

	@Override
	public void setCargo(String cargo) {
		_cargo = cargo;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setCargo", String.class);

				method.invoke(_cursoParticipanteRemoteModel, cargo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmpresaOndeTrabalha() {
		return _empresaOndeTrabalha;
	}

	@Override
	public void setEmpresaOndeTrabalha(String empresaOndeTrabalha) {
		_empresaOndeTrabalha = empresaOndeTrabalha;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpresaOndeTrabalha",
						String.class);

				method.invoke(_cursoParticipanteRemoteModel, empresaOndeTrabalha);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDepartamento() {
		return _departamento;
	}

	@Override
	public void setDepartamento(String departamento) {
		_departamento = departamento;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartamento", String.class);

				method.invoke(_cursoParticipanteRemoteModel, departamento);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFormacaoAcademica() {
		return _formacaoAcademica;
	}

	@Override
	public void setFormacaoAcademica(String formacaoAcademica) {
		_formacaoAcademica = formacaoAcademica;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setFormacaoAcademica",
						String.class);

				method.invoke(_cursoParticipanteRemoteModel, formacaoAcademica);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailPrincipal() {
		return _emailPrincipal;
	}

	@Override
	public void setEmailPrincipal(String emailPrincipal) {
		_emailPrincipal = emailPrincipal;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailPrincipal",
						String.class);

				method.invoke(_cursoParticipanteRemoteModel, emailPrincipal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailOpcional() {
		return _emailOpcional;
	}

	@Override
	public void setEmailOpcional(String emailOpcional) {
		_emailOpcional = emailOpcional;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailOpcional", String.class);

				method.invoke(_cursoParticipanteRemoteModel, emailOpcional);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDddTelefoneComercial() {
		return _dddTelefoneComercial;
	}

	@Override
	public void setDddTelefoneComercial(String dddTelefoneComercial) {
		_dddTelefoneComercial = dddTelefoneComercial;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setDddTelefoneComercial",
						String.class);

				method.invoke(_cursoParticipanteRemoteModel,
					dddTelefoneComercial);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTelefoneComercial() {
		return _telefoneComercial;
	}

	@Override
	public void setTelefoneComercial(String telefoneComercial) {
		_telefoneComercial = telefoneComercial;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setTelefoneComercial",
						String.class);

				method.invoke(_cursoParticipanteRemoteModel, telefoneComercial);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDddTelefonePessoal() {
		return _dddTelefonePessoal;
	}

	@Override
	public void setDddTelefonePessoal(String dddTelefonePessoal) {
		_dddTelefonePessoal = dddTelefonePessoal;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setDddTelefonePessoal",
						String.class);

				method.invoke(_cursoParticipanteRemoteModel, dddTelefonePessoal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTelefonePessoal() {
		return _telefonePessoal;
	}

	@Override
	public void setTelefonePessoal(String telefonePessoal) {
		_telefonePessoal = telefonePessoal;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setTelefonePessoal",
						String.class);

				method.invoke(_cursoParticipanteRemoteModel, telefonePessoal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDddTelefoneCelular() {
		return _dddTelefoneCelular;
	}

	@Override
	public void setDddTelefoneCelular(String dddTelefoneCelular) {
		_dddTelefoneCelular = dddTelefoneCelular;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setDddTelefoneCelular",
						String.class);

				method.invoke(_cursoParticipanteRemoteModel, dddTelefoneCelular);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTelefoneCelular() {
		return _telefoneCelular;
	}

	@Override
	public void setTelefoneCelular(String telefoneCelular) {
		_telefoneCelular = telefoneCelular;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setTelefoneCelular",
						String.class);

				method.invoke(_cursoParticipanteRemoteModel, telefoneCelular);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndereco() {
		return _endereco;
	}

	@Override
	public void setEndereco(String endereco) {
		_endereco = endereco;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setEndereco", String.class);

				method.invoke(_cursoParticipanteRemoteModel, endereco);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBairro() {
		return _bairro;
	}

	@Override
	public void setBairro(String bairro) {
		_bairro = bairro;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setBairro", String.class);

				method.invoke(_cursoParticipanteRemoteModel, bairro);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCidade() {
		return _cidade;
	}

	@Override
	public void setCidade(String cidade) {
		_cidade = cidade;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setCidade", String.class);

				method.invoke(_cursoParticipanteRemoteModel, cidade);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEstado() {
		return _estado;
	}

	@Override
	public void setEstado(String estado) {
		_estado = estado;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setEstado", String.class);

				method.invoke(_cursoParticipanteRemoteModel, estado);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCep() {
		return _cep;
	}

	@Override
	public void setCep(String cep) {
		_cep = cep;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setCep", String.class);

				method.invoke(_cursoParticipanteRemoteModel, cep);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getValorPago() {
		return _valorPago;
	}

	@Override
	public void setValorPago(String valorPago) {
		_valorPago = valorPago;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setValorPago", String.class);

				method.invoke(_cursoParticipanteRemoteModel, valorPago);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExpectativaCurso() {
		return _expectativaCurso;
	}

	@Override
	public void setExpectativaCurso(String expectativaCurso) {
		_expectativaCurso = expectativaCurso;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setExpectativaCurso",
						String.class);

				method.invoke(_cursoParticipanteRemoteModel, expectativaCurso);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getObservacao() {
		return _observacao;
	}

	@Override
	public void setObservacao(String observacao) {
		_observacao = observacao;

		if (_cursoParticipanteRemoteModel != null) {
			try {
				Class<?> clazz = _cursoParticipanteRemoteModel.getClass();

				Method method = clazz.getMethod("setObservacao", String.class);

				method.invoke(_cursoParticipanteRemoteModel, observacao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCursoParticipanteRemoteModel() {
		return _cursoParticipanteRemoteModel;
	}

	public void setCursoParticipanteRemoteModel(
		BaseModel<?> cursoParticipanteRemoteModel) {
		_cursoParticipanteRemoteModel = cursoParticipanteRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _cursoParticipanteRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_cursoParticipanteRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CursoParticipanteLocalServiceUtil.addCursoParticipante(this);
		}
		else {
			CursoParticipanteLocalServiceUtil.updateCursoParticipante(this);
		}
	}

	@Override
	public CursoParticipante toEscapedModel() {
		return (CursoParticipante)ProxyUtil.newProxyInstance(CursoParticipante.class.getClassLoader(),
			new Class[] { CursoParticipante.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CursoParticipanteClp clone = new CursoParticipanteClp();

		clone.setParticipanteId(getParticipanteId());
		clone.setInscricaoId(getInscricaoId());
		clone.setNomeCompleto(getNomeCompleto());
		clone.setNomeCracha(getNomeCracha());
		clone.setCpf(getCpf());
		clone.setSexo(getSexo());
		clone.setCargo(getCargo());
		clone.setEmpresaOndeTrabalha(getEmpresaOndeTrabalha());
		clone.setDepartamento(getDepartamento());
		clone.setFormacaoAcademica(getFormacaoAcademica());
		clone.setEmailPrincipal(getEmailPrincipal());
		clone.setEmailOpcional(getEmailOpcional());
		clone.setDddTelefoneComercial(getDddTelefoneComercial());
		clone.setTelefoneComercial(getTelefoneComercial());
		clone.setDddTelefonePessoal(getDddTelefonePessoal());
		clone.setTelefonePessoal(getTelefonePessoal());
		clone.setDddTelefoneCelular(getDddTelefoneCelular());
		clone.setTelefoneCelular(getTelefoneCelular());
		clone.setEndereco(getEndereco());
		clone.setBairro(getBairro());
		clone.setCidade(getCidade());
		clone.setEstado(getEstado());
		clone.setCep(getCep());
		clone.setValorPago(getValorPago());
		clone.setExpectativaCurso(getExpectativaCurso());
		clone.setObservacao(getObservacao());

		return clone;
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

		if (!(obj instanceof CursoParticipanteClp)) {
			return false;
		}

		CursoParticipanteClp cursoParticipante = (CursoParticipanteClp)obj;

		long primaryKey = cursoParticipante.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
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
	private BaseModel<?> _cursoParticipanteRemoteModel;
	private Class<?> _clpSerializerClass = br.com.cnf.curso.inscricao.service.ClpSerializer.class;
}