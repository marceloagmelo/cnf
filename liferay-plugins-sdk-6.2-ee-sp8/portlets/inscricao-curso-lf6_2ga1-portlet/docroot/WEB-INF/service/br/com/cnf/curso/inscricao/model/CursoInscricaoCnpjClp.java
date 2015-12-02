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
import br.com.cnf.curso.inscricao.service.CursoInscricaoCnpjLocalServiceUtil;

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
public class CursoInscricaoCnpjClp extends BaseModelImpl<CursoInscricaoCnpj>
	implements CursoInscricaoCnpj {
	public CursoInscricaoCnpjClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CursoInscricaoCnpj.class;
	}

	@Override
	public String getModelClassName() {
		return CursoInscricaoCnpj.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _inscricaoCnpjId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setInscricaoCnpjId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _inscricaoCnpjId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("inscricaoCnpjId", getInscricaoCnpjId());
		attributes.put("inscricaoId", getInscricaoId());
		attributes.put("razaoSocial", getRazaoSocial());
		attributes.put("nomeFantasia", getNomeFantasia());
		attributes.put("inscricaoEstadual", getInscricaoEstadual());
		attributes.put("endereco", getEndereco());
		attributes.put("bairro", getBairro());
		attributes.put("cidade", getCidade());
		attributes.put("estado", getEstado());
		attributes.put("cep", getCep());
		attributes.put("dddTelefone", getDddTelefone());
		attributes.put("telefone", getTelefone());
		attributes.put("nfNome", getNfNome());
		attributes.put("nfDepartamento", getNfDepartamento());
		attributes.put("nfEmail", getNfEmail());
		attributes.put("nfDddTelefone", getNfDddTelefone());
		attributes.put("nfTelefone", getNfTelefone());
		attributes.put("observacao", getObservacao());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long inscricaoCnpjId = (Long)attributes.get("inscricaoCnpjId");

		if (inscricaoCnpjId != null) {
			setInscricaoCnpjId(inscricaoCnpjId);
		}

		Long inscricaoId = (Long)attributes.get("inscricaoId");

		if (inscricaoId != null) {
			setInscricaoId(inscricaoId);
		}

		String razaoSocial = (String)attributes.get("razaoSocial");

		if (razaoSocial != null) {
			setRazaoSocial(razaoSocial);
		}

		String nomeFantasia = (String)attributes.get("nomeFantasia");

		if (nomeFantasia != null) {
			setNomeFantasia(nomeFantasia);
		}

		String inscricaoEstadual = (String)attributes.get("inscricaoEstadual");

		if (inscricaoEstadual != null) {
			setInscricaoEstadual(inscricaoEstadual);
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

		String nfNome = (String)attributes.get("nfNome");

		if (nfNome != null) {
			setNfNome(nfNome);
		}

		String nfDepartamento = (String)attributes.get("nfDepartamento");

		if (nfDepartamento != null) {
			setNfDepartamento(nfDepartamento);
		}

		String nfEmail = (String)attributes.get("nfEmail");

		if (nfEmail != null) {
			setNfEmail(nfEmail);
		}

		String nfDddTelefone = (String)attributes.get("nfDddTelefone");

		if (nfDddTelefone != null) {
			setNfDddTelefone(nfDddTelefone);
		}

		String nfTelefone = (String)attributes.get("nfTelefone");

		if (nfTelefone != null) {
			setNfTelefone(nfTelefone);
		}

		String observacao = (String)attributes.get("observacao");

		if (observacao != null) {
			setObservacao(observacao);
		}
	}

	@Override
	public long getInscricaoCnpjId() {
		return _inscricaoCnpjId;
	}

	@Override
	public void setInscricaoCnpjId(long inscricaoCnpjId) {
		_inscricaoCnpjId = inscricaoCnpjId;

		if (_cursoInscricaoCnpjRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCnpjRemoteModel.getClass();

				Method method = clazz.getMethod("setInscricaoCnpjId", long.class);

				method.invoke(_cursoInscricaoCnpjRemoteModel, inscricaoCnpjId);
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

		if (_cursoInscricaoCnpjRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCnpjRemoteModel.getClass();

				Method method = clazz.getMethod("setInscricaoId", long.class);

				method.invoke(_cursoInscricaoCnpjRemoteModel, inscricaoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRazaoSocial() {
		return _razaoSocial;
	}

	@Override
	public void setRazaoSocial(String razaoSocial) {
		_razaoSocial = razaoSocial;

		if (_cursoInscricaoCnpjRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCnpjRemoteModel.getClass();

				Method method = clazz.getMethod("setRazaoSocial", String.class);

				method.invoke(_cursoInscricaoCnpjRemoteModel, razaoSocial);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNomeFantasia() {
		return _nomeFantasia;
	}

	@Override
	public void setNomeFantasia(String nomeFantasia) {
		_nomeFantasia = nomeFantasia;

		if (_cursoInscricaoCnpjRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCnpjRemoteModel.getClass();

				Method method = clazz.getMethod("setNomeFantasia", String.class);

				method.invoke(_cursoInscricaoCnpjRemoteModel, nomeFantasia);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInscricaoEstadual() {
		return _inscricaoEstadual;
	}

	@Override
	public void setInscricaoEstadual(String inscricaoEstadual) {
		_inscricaoEstadual = inscricaoEstadual;

		if (_cursoInscricaoCnpjRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCnpjRemoteModel.getClass();

				Method method = clazz.getMethod("setInscricaoEstadual",
						String.class);

				method.invoke(_cursoInscricaoCnpjRemoteModel, inscricaoEstadual);
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

		if (_cursoInscricaoCnpjRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCnpjRemoteModel.getClass();

				Method method = clazz.getMethod("setEndereco", String.class);

				method.invoke(_cursoInscricaoCnpjRemoteModel, endereco);
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

		if (_cursoInscricaoCnpjRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCnpjRemoteModel.getClass();

				Method method = clazz.getMethod("setBairro", String.class);

				method.invoke(_cursoInscricaoCnpjRemoteModel, bairro);
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

		if (_cursoInscricaoCnpjRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCnpjRemoteModel.getClass();

				Method method = clazz.getMethod("setCidade", String.class);

				method.invoke(_cursoInscricaoCnpjRemoteModel, cidade);
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

		if (_cursoInscricaoCnpjRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCnpjRemoteModel.getClass();

				Method method = clazz.getMethod("setEstado", String.class);

				method.invoke(_cursoInscricaoCnpjRemoteModel, estado);
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

		if (_cursoInscricaoCnpjRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCnpjRemoteModel.getClass();

				Method method = clazz.getMethod("setCep", String.class);

				method.invoke(_cursoInscricaoCnpjRemoteModel, cep);
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

		if (_cursoInscricaoCnpjRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCnpjRemoteModel.getClass();

				Method method = clazz.getMethod("setDddTelefone", String.class);

				method.invoke(_cursoInscricaoCnpjRemoteModel, dddTelefone);
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

		if (_cursoInscricaoCnpjRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCnpjRemoteModel.getClass();

				Method method = clazz.getMethod("setTelefone", String.class);

				method.invoke(_cursoInscricaoCnpjRemoteModel, telefone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNfNome() {
		return _nfNome;
	}

	@Override
	public void setNfNome(String nfNome) {
		_nfNome = nfNome;

		if (_cursoInscricaoCnpjRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCnpjRemoteModel.getClass();

				Method method = clazz.getMethod("setNfNome", String.class);

				method.invoke(_cursoInscricaoCnpjRemoteModel, nfNome);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNfDepartamento() {
		return _nfDepartamento;
	}

	@Override
	public void setNfDepartamento(String nfDepartamento) {
		_nfDepartamento = nfDepartamento;

		if (_cursoInscricaoCnpjRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCnpjRemoteModel.getClass();

				Method method = clazz.getMethod("setNfDepartamento",
						String.class);

				method.invoke(_cursoInscricaoCnpjRemoteModel, nfDepartamento);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNfEmail() {
		return _nfEmail;
	}

	@Override
	public void setNfEmail(String nfEmail) {
		_nfEmail = nfEmail;

		if (_cursoInscricaoCnpjRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCnpjRemoteModel.getClass();

				Method method = clazz.getMethod("setNfEmail", String.class);

				method.invoke(_cursoInscricaoCnpjRemoteModel, nfEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNfDddTelefone() {
		return _nfDddTelefone;
	}

	@Override
	public void setNfDddTelefone(String nfDddTelefone) {
		_nfDddTelefone = nfDddTelefone;

		if (_cursoInscricaoCnpjRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCnpjRemoteModel.getClass();

				Method method = clazz.getMethod("setNfDddTelefone", String.class);

				method.invoke(_cursoInscricaoCnpjRemoteModel, nfDddTelefone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNfTelefone() {
		return _nfTelefone;
	}

	@Override
	public void setNfTelefone(String nfTelefone) {
		_nfTelefone = nfTelefone;

		if (_cursoInscricaoCnpjRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCnpjRemoteModel.getClass();

				Method method = clazz.getMethod("setNfTelefone", String.class);

				method.invoke(_cursoInscricaoCnpjRemoteModel, nfTelefone);
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

		if (_cursoInscricaoCnpjRemoteModel != null) {
			try {
				Class<?> clazz = _cursoInscricaoCnpjRemoteModel.getClass();

				Method method = clazz.getMethod("setObservacao", String.class);

				method.invoke(_cursoInscricaoCnpjRemoteModel, observacao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCursoInscricaoCnpjRemoteModel() {
		return _cursoInscricaoCnpjRemoteModel;
	}

	public void setCursoInscricaoCnpjRemoteModel(
		BaseModel<?> cursoInscricaoCnpjRemoteModel) {
		_cursoInscricaoCnpjRemoteModel = cursoInscricaoCnpjRemoteModel;
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

		Class<?> remoteModelClass = _cursoInscricaoCnpjRemoteModel.getClass();

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

		Object returnValue = method.invoke(_cursoInscricaoCnpjRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CursoInscricaoCnpjLocalServiceUtil.addCursoInscricaoCnpj(this);
		}
		else {
			CursoInscricaoCnpjLocalServiceUtil.updateCursoInscricaoCnpj(this);
		}
	}

	@Override
	public CursoInscricaoCnpj toEscapedModel() {
		return (CursoInscricaoCnpj)ProxyUtil.newProxyInstance(CursoInscricaoCnpj.class.getClassLoader(),
			new Class[] { CursoInscricaoCnpj.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CursoInscricaoCnpjClp clone = new CursoInscricaoCnpjClp();

		clone.setInscricaoCnpjId(getInscricaoCnpjId());
		clone.setInscricaoId(getInscricaoId());
		clone.setRazaoSocial(getRazaoSocial());
		clone.setNomeFantasia(getNomeFantasia());
		clone.setInscricaoEstadual(getInscricaoEstadual());
		clone.setEndereco(getEndereco());
		clone.setBairro(getBairro());
		clone.setCidade(getCidade());
		clone.setEstado(getEstado());
		clone.setCep(getCep());
		clone.setDddTelefone(getDddTelefone());
		clone.setTelefone(getTelefone());
		clone.setNfNome(getNfNome());
		clone.setNfDepartamento(getNfDepartamento());
		clone.setNfEmail(getNfEmail());
		clone.setNfDddTelefone(getNfDddTelefone());
		clone.setNfTelefone(getNfTelefone());
		clone.setObservacao(getObservacao());

		return clone;
	}

	@Override
	public int compareTo(CursoInscricaoCnpj cursoInscricaoCnpj) {
		int value = 0;

		value = getRazaoSocial().compareTo(cursoInscricaoCnpj.getRazaoSocial());

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

		if (!(obj instanceof CursoInscricaoCnpjClp)) {
			return false;
		}

		CursoInscricaoCnpjClp cursoInscricaoCnpj = (CursoInscricaoCnpjClp)obj;

		long primaryKey = cursoInscricaoCnpj.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{inscricaoCnpjId=");
		sb.append(getInscricaoCnpjId());
		sb.append(", inscricaoId=");
		sb.append(getInscricaoId());
		sb.append(", razaoSocial=");
		sb.append(getRazaoSocial());
		sb.append(", nomeFantasia=");
		sb.append(getNomeFantasia());
		sb.append(", inscricaoEstadual=");
		sb.append(getInscricaoEstadual());
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
		sb.append(", nfNome=");
		sb.append(getNfNome());
		sb.append(", nfDepartamento=");
		sb.append(getNfDepartamento());
		sb.append(", nfEmail=");
		sb.append(getNfEmail());
		sb.append(", nfDddTelefone=");
		sb.append(getNfDddTelefone());
		sb.append(", nfTelefone=");
		sb.append(getNfTelefone());
		sb.append(", observacao=");
		sb.append(getObservacao());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>inscricaoCnpjId</column-name><column-value><![CDATA[");
		sb.append(getInscricaoCnpjId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inscricaoId</column-name><column-value><![CDATA[");
		sb.append(getInscricaoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>razaoSocial</column-name><column-value><![CDATA[");
		sb.append(getRazaoSocial());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nomeFantasia</column-name><column-value><![CDATA[");
		sb.append(getNomeFantasia());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inscricaoEstadual</column-name><column-value><![CDATA[");
		sb.append(getInscricaoEstadual());
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
			"<column><column-name>nfNome</column-name><column-value><![CDATA[");
		sb.append(getNfNome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nfDepartamento</column-name><column-value><![CDATA[");
		sb.append(getNfDepartamento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nfEmail</column-name><column-value><![CDATA[");
		sb.append(getNfEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nfDddTelefone</column-name><column-value><![CDATA[");
		sb.append(getNfDddTelefone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nfTelefone</column-name><column-value><![CDATA[");
		sb.append(getNfTelefone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>observacao</column-name><column-value><![CDATA[");
		sb.append(getObservacao());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _inscricaoCnpjId;
	private long _inscricaoId;
	private String _razaoSocial;
	private String _nomeFantasia;
	private String _inscricaoEstadual;
	private String _endereco;
	private String _bairro;
	private String _cidade;
	private String _estado;
	private String _cep;
	private String _dddTelefone;
	private String _telefone;
	private String _nfNome;
	private String _nfDepartamento;
	private String _nfEmail;
	private String _nfDddTelefone;
	private String _nfTelefone;
	private String _observacao;
	private BaseModel<?> _cursoInscricaoCnpjRemoteModel;
	private Class<?> _clpSerializerClass = br.com.cnf.curso.inscricao.service.ClpSerializer.class;
}