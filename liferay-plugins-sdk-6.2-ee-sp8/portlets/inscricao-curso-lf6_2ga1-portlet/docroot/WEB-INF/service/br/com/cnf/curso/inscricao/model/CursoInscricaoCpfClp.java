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
import br.com.cnf.curso.inscricao.service.CursoInscricaoCpfLocalServiceUtil;

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
public class CursoInscricaoCpfClp extends BaseModelImpl<CursoInscricaoCpf>
	implements CursoInscricaoCpf {
	public CursoInscricaoCpfClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CursoInscricaoCpf.class;
	}

	@Override
	public String getModelClassName() {
		return CursoInscricaoCpf.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _inscricaoCpfId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setInscricaoCpfId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _inscricaoCpfId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("inscricaoCpfId", getInscricaoCpfId());
		attributes.put("inscricaoId", getInscricaoId());
		attributes.put("nome", getNome());
		attributes.put("cpf", getCpf());
		attributes.put("endereco", getEndereco());
		attributes.put("bairro", getBairro());
		attributes.put("cidade", getCidade());
		attributes.put("estado", getEstado());
		attributes.put("cep", getCep());
		attributes.put("dddTelefone", getDddTelefone());
		attributes.put("telefone", getTelefone());
		attributes.put("email", getEmail());
		attributes.put("empresa", getEmpresa());
		attributes.put("cargo", getCargo());
		attributes.put("departamento", getDepartamento());
		attributes.put("observacao", getObservacao());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long inscricaoCpfId = (Long)attributes.get("inscricaoCpfId");

		if (inscricaoCpfId != null) {
			setInscricaoCpfId(inscricaoCpfId);
		}

		Long inscricaoId = (Long)attributes.get("inscricaoId");

		if (inscricaoId != null) {
			setInscricaoId(inscricaoId);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String cpf = (String)attributes.get("cpf");

		if (cpf != null) {
			setCpf(cpf);
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

		String dddTelefone = (String)attributes.get("dddTelefone");

		if (dddTelefone != null) {
			setDddTelefone(dddTelefone);
		}

		String telefone = (String)attributes.get("telefone");

		if (telefone != null) {
			setTelefone(telefone);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String empresa = (String)attributes.get("empresa");

		if (empresa != null) {
			setEmpresa(empresa);
		}

		String cargo = (String)attributes.get("cargo");

		if (cargo != null) {
			setCargo(cargo);
		}

		String departamento = (String)attributes.get("departamento");

		if (departamento != null) {
			setDepartamento(departamento);
		}

		String observacao = (String)attributes.get("observacao");

		if (observacao != null) {
			setObservacao(observacao);
		}
	}

	@Override
	public long getInscricaoCpfId() {
		return _inscricaoCpfId;
	}

	@Override
	public void setInscricaoCpfId(long inscricaoCpfId) {
		_inscricaoCpfId = inscricaoCpfId;

		if (_cursoInscricaoCpfRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCpfRemoteModel.getClass();

				Method method = clazz.getMethod("setInscricaoCpfId", long.class);

				method.invoke(_cursoInscricaoCpfRemoteModel, inscricaoCpfId);
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

		if (_cursoInscricaoCpfRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCpfRemoteModel.getClass();

				Method method = clazz.getMethod("setInscricaoId", long.class);

				method.invoke(_cursoInscricaoCpfRemoteModel, inscricaoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNome() {
		return _nome;
	}

	@Override
	public void setNome(String nome) {
		_nome = nome;

		if (_cursoInscricaoCpfRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCpfRemoteModel.getClass();

				Method method = clazz.getMethod("setNome", String.class);

				method.invoke(_cursoInscricaoCpfRemoteModel, nome);
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

		if (_cursoInscricaoCpfRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCpfRemoteModel.getClass();

				Method method = clazz.getMethod("setCpf", String.class);

				method.invoke(_cursoInscricaoCpfRemoteModel, cpf);
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

		if (_cursoInscricaoCpfRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCpfRemoteModel.getClass();

				Method method = clazz.getMethod("setEndereco", String.class);

				method.invoke(_cursoInscricaoCpfRemoteModel, endereco);
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

		if (_cursoInscricaoCpfRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCpfRemoteModel.getClass();

				Method method = clazz.getMethod("setBairro", String.class);

				method.invoke(_cursoInscricaoCpfRemoteModel, bairro);
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

		if (_cursoInscricaoCpfRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCpfRemoteModel.getClass();

				Method method = clazz.getMethod("setCidade", String.class);

				method.invoke(_cursoInscricaoCpfRemoteModel, cidade);
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

		if (_cursoInscricaoCpfRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCpfRemoteModel.getClass();

				Method method = clazz.getMethod("setEstado", String.class);

				method.invoke(_cursoInscricaoCpfRemoteModel, estado);
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

		if (_cursoInscricaoCpfRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCpfRemoteModel.getClass();

				Method method = clazz.getMethod("setCep", String.class);

				method.invoke(_cursoInscricaoCpfRemoteModel, cep);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDddTelefone() {
		return _dddTelefone;
	}

	@Override
	public void setDddTelefone(String dddTelefone) {
		_dddTelefone = dddTelefone;

		if (_cursoInscricaoCpfRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCpfRemoteModel.getClass();

				Method method = clazz.getMethod("setDddTelefone", String.class);

				method.invoke(_cursoInscricaoCpfRemoteModel, dddTelefone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTelefone() {
		return _telefone;
	}

	@Override
	public void setTelefone(String telefone) {
		_telefone = telefone;

		if (_cursoInscricaoCpfRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCpfRemoteModel.getClass();

				Method method = clazz.getMethod("setTelefone", String.class);

				method.invoke(_cursoInscricaoCpfRemoteModel, telefone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_cursoInscricaoCpfRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCpfRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_cursoInscricaoCpfRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmpresa() {
		return _empresa;
	}

	@Override
	public void setEmpresa(String empresa) {
		_empresa = empresa;

		if (_cursoInscricaoCpfRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCpfRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpresa", String.class);

				method.invoke(_cursoInscricaoCpfRemoteModel, empresa);
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

		if (_cursoInscricaoCpfRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCpfRemoteModel.getClass();

				Method method = clazz.getMethod("setCargo", String.class);

				method.invoke(_cursoInscricaoCpfRemoteModel, cargo);
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

		if (_cursoInscricaoCpfRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCpfRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartamento", String.class);

				method.invoke(_cursoInscricaoCpfRemoteModel, departamento);
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

		if (_cursoInscricaoCpfRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCpfRemoteModel.getClass();

				Method method = clazz.getMethod("setObservacao", String.class);

				method.invoke(_cursoInscricaoCpfRemoteModel, observacao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCursoInscricaoCpfRemoteModel() {
		return _cursoInscricaoCpfRemoteModel;
	}

	public void setCursoInscricaoCpfRemoteModel(
		BaseModel<?> cursoInscricaoCpfRemoteModel) {
		_cursoInscricaoCpfRemoteModel = cursoInscricaoCpfRemoteModel;
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

		Class<?> remoteModelClass = _cursoInscricaoCpfRemoteModel.getClass();

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

		Object returnValue = method.invoke(_cursoInscricaoCpfRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CursoInscricaoCpfLocalServiceUtil.addCursoInscricaoCpf(this);
		}
		else {
			CursoInscricaoCpfLocalServiceUtil.updateCursoInscricaoCpf(this);
		}
	}

	@Override
	public CursoInscricaoCpf toEscapedModel() {
		return (CursoInscricaoCpf)ProxyUtil.newProxyInstance(CursoInscricaoCpf.class.getClassLoader(),
			new Class[] { CursoInscricaoCpf.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CursoInscricaoCpfClp clone = new CursoInscricaoCpfClp();

		clone.setInscricaoCpfId(getInscricaoCpfId());
		clone.setInscricaoId(getInscricaoId());
		clone.setNome(getNome());
		clone.setCpf(getCpf());
		clone.setEndereco(getEndereco());
		clone.setBairro(getBairro());
		clone.setCidade(getCidade());
		clone.setEstado(getEstado());
		clone.setCep(getCep());
		clone.setDddTelefone(getDddTelefone());
		clone.setTelefone(getTelefone());
		clone.setEmail(getEmail());
		clone.setEmpresa(getEmpresa());
		clone.setCargo(getCargo());
		clone.setDepartamento(getDepartamento());
		clone.setObservacao(getObservacao());

		return clone;
	}

	@Override
	public int compareTo(CursoInscricaoCpf cursoInscricaoCpf) {
		int value = 0;

		value = getNome().compareTo(cursoInscricaoCpf.getNome());

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

		if (!(obj instanceof CursoInscricaoCpfClp)) {
			return false;
		}

		CursoInscricaoCpfClp cursoInscricaoCpf = (CursoInscricaoCpfClp)obj;

		long primaryKey = cursoInscricaoCpf.getPrimaryKey();

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
		StringBundler sb = new StringBundler(33);

		sb.append("{inscricaoCpfId=");
		sb.append(getInscricaoCpfId());
		sb.append(", inscricaoId=");
		sb.append(getInscricaoId());
		sb.append(", nome=");
		sb.append(getNome());
		sb.append(", cpf=");
		sb.append(getCpf());
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
		sb.append(", dddTelefone=");
		sb.append(getDddTelefone());
		sb.append(", telefone=");
		sb.append(getTelefone());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", empresa=");
		sb.append(getEmpresa());
		sb.append(", cargo=");
		sb.append(getCargo());
		sb.append(", departamento=");
		sb.append(getDepartamento());
		sb.append(", observacao=");
		sb.append(getObservacao());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("br.com.cnf.curso.inscricao.model.CursoInscricaoCpf");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>inscricaoCpfId</column-name><column-value><![CDATA[");
		sb.append(getInscricaoCpfId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inscricaoId</column-name><column-value><![CDATA[");
		sb.append(getInscricaoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nome</column-name><column-value><![CDATA[");
		sb.append(getNome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cpf</column-name><column-value><![CDATA[");
		sb.append(getCpf());
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
			"<column><column-name>dddTelefone</column-name><column-value><![CDATA[");
		sb.append(getDddTelefone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telefone</column-name><column-value><![CDATA[");
		sb.append(getTelefone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>empresa</column-name><column-value><![CDATA[");
		sb.append(getEmpresa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cargo</column-name><column-value><![CDATA[");
		sb.append(getCargo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departamento</column-name><column-value><![CDATA[");
		sb.append(getDepartamento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>observacao</column-name><column-value><![CDATA[");
		sb.append(getObservacao());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _inscricaoCpfId;
	private long _inscricaoId;
	private String _nome;
	private String _cpf;
	private String _endereco;
	private String _bairro;
	private String _cidade;
	private String _estado;
	private String _cep;
	private String _dddTelefone;
	private String _telefone;
	private String _email;
	private String _empresa;
	private String _cargo;
	private String _departamento;
	private String _observacao;
	private BaseModel<?> _cursoInscricaoCpfRemoteModel;
	private Class<?> _clpSerializerClass = br.com.cnf.curso.inscricao.service.ClpSerializer.class;
}