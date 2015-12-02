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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CursoInscricaoCnpj}.
 * </p>
 *
 * @author SEA
 * @see CursoInscricaoCnpj
 * @generated
 */
public class CursoInscricaoCnpjWrapper implements CursoInscricaoCnpj,
	ModelWrapper<CursoInscricaoCnpj> {
	public CursoInscricaoCnpjWrapper(CursoInscricaoCnpj cursoInscricaoCnpj) {
		_cursoInscricaoCnpj = cursoInscricaoCnpj;
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

	/**
	* Returns the primary key of this curso inscricao cnpj.
	*
	* @return the primary key of this curso inscricao cnpj
	*/
	@Override
	public long getPrimaryKey() {
		return _cursoInscricaoCnpj.getPrimaryKey();
	}

	/**
	* Sets the primary key of this curso inscricao cnpj.
	*
	* @param primaryKey the primary key of this curso inscricao cnpj
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cursoInscricaoCnpj.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the inscricao cnpj ID of this curso inscricao cnpj.
	*
	* @return the inscricao cnpj ID of this curso inscricao cnpj
	*/
	@Override
	public long getInscricaoCnpjId() {
		return _cursoInscricaoCnpj.getInscricaoCnpjId();
	}

	/**
	* Sets the inscricao cnpj ID of this curso inscricao cnpj.
	*
	* @param inscricaoCnpjId the inscricao cnpj ID of this curso inscricao cnpj
	*/
	@Override
	public void setInscricaoCnpjId(long inscricaoCnpjId) {
		_cursoInscricaoCnpj.setInscricaoCnpjId(inscricaoCnpjId);
	}

	/**
	* Returns the inscricao ID of this curso inscricao cnpj.
	*
	* @return the inscricao ID of this curso inscricao cnpj
	*/
	@Override
	public long getInscricaoId() {
		return _cursoInscricaoCnpj.getInscricaoId();
	}

	/**
	* Sets the inscricao ID of this curso inscricao cnpj.
	*
	* @param inscricaoId the inscricao ID of this curso inscricao cnpj
	*/
	@Override
	public void setInscricaoId(long inscricaoId) {
		_cursoInscricaoCnpj.setInscricaoId(inscricaoId);
	}

	/**
	* Returns the razao social of this curso inscricao cnpj.
	*
	* @return the razao social of this curso inscricao cnpj
	*/
	@Override
	public java.lang.String getRazaoSocial() {
		return _cursoInscricaoCnpj.getRazaoSocial();
	}

	/**
	* Sets the razao social of this curso inscricao cnpj.
	*
	* @param razaoSocial the razao social of this curso inscricao cnpj
	*/
	@Override
	public void setRazaoSocial(java.lang.String razaoSocial) {
		_cursoInscricaoCnpj.setRazaoSocial(razaoSocial);
	}

	/**
	* Returns the nome fantasia of this curso inscricao cnpj.
	*
	* @return the nome fantasia of this curso inscricao cnpj
	*/
	@Override
	public java.lang.String getNomeFantasia() {
		return _cursoInscricaoCnpj.getNomeFantasia();
	}

	/**
	* Sets the nome fantasia of this curso inscricao cnpj.
	*
	* @param nomeFantasia the nome fantasia of this curso inscricao cnpj
	*/
	@Override
	public void setNomeFantasia(java.lang.String nomeFantasia) {
		_cursoInscricaoCnpj.setNomeFantasia(nomeFantasia);
	}

	/**
	* Returns the inscricao estadual of this curso inscricao cnpj.
	*
	* @return the inscricao estadual of this curso inscricao cnpj
	*/
	@Override
	public java.lang.String getInscricaoEstadual() {
		return _cursoInscricaoCnpj.getInscricaoEstadual();
	}

	/**
	* Sets the inscricao estadual of this curso inscricao cnpj.
	*
	* @param inscricaoEstadual the inscricao estadual of this curso inscricao cnpj
	*/
	@Override
	public void setInscricaoEstadual(java.lang.String inscricaoEstadual) {
		_cursoInscricaoCnpj.setInscricaoEstadual(inscricaoEstadual);
	}

	/**
	* Returns the endereco of this curso inscricao cnpj.
	*
	* @return the endereco of this curso inscricao cnpj
	*/
	@Override
	public java.lang.String getEndereco() {
		return _cursoInscricaoCnpj.getEndereco();
	}

	/**
	* Sets the endereco of this curso inscricao cnpj.
	*
	* @param endereco the endereco of this curso inscricao cnpj
	*/
	@Override
	public void setEndereco(java.lang.String endereco) {
		_cursoInscricaoCnpj.setEndereco(endereco);
	}

	/**
	* Returns the bairro of this curso inscricao cnpj.
	*
	* @return the bairro of this curso inscricao cnpj
	*/
	@Override
	public java.lang.String getBairro() {
		return _cursoInscricaoCnpj.getBairro();
	}

	/**
	* Sets the bairro of this curso inscricao cnpj.
	*
	* @param bairro the bairro of this curso inscricao cnpj
	*/
	@Override
	public void setBairro(java.lang.String bairro) {
		_cursoInscricaoCnpj.setBairro(bairro);
	}

	/**
	* Returns the cidade of this curso inscricao cnpj.
	*
	* @return the cidade of this curso inscricao cnpj
	*/
	@Override
	public java.lang.String getCidade() {
		return _cursoInscricaoCnpj.getCidade();
	}

	/**
	* Sets the cidade of this curso inscricao cnpj.
	*
	* @param cidade the cidade of this curso inscricao cnpj
	*/
	@Override
	public void setCidade(java.lang.String cidade) {
		_cursoInscricaoCnpj.setCidade(cidade);
	}

	/**
	* Returns the estado of this curso inscricao cnpj.
	*
	* @return the estado of this curso inscricao cnpj
	*/
	@Override
	public java.lang.String getEstado() {
		return _cursoInscricaoCnpj.getEstado();
	}

	/**
	* Sets the estado of this curso inscricao cnpj.
	*
	* @param estado the estado of this curso inscricao cnpj
	*/
	@Override
	public void setEstado(java.lang.String estado) {
		_cursoInscricaoCnpj.setEstado(estado);
	}

	/**
	* Returns the cep of this curso inscricao cnpj.
	*
	* @return the cep of this curso inscricao cnpj
	*/
	@Override
	public java.lang.String getCep() {
		return _cursoInscricaoCnpj.getCep();
	}

	/**
	* Sets the cep of this curso inscricao cnpj.
	*
	* @param cep the cep of this curso inscricao cnpj
	*/
	@Override
	public void setCep(java.lang.String cep) {
		_cursoInscricaoCnpj.setCep(cep);
	}

	/**
	* Returns the ddd telefone of this curso inscricao cnpj.
	*
	* @return the ddd telefone of this curso inscricao cnpj
	*/
	@Override
	public java.lang.String getDddTelefone() {
		return _cursoInscricaoCnpj.getDddTelefone();
	}

	/**
	* Sets the ddd telefone of this curso inscricao cnpj.
	*
	* @param dddTelefone the ddd telefone of this curso inscricao cnpj
	*/
	@Override
	public void setDddTelefone(java.lang.String dddTelefone) {
		_cursoInscricaoCnpj.setDddTelefone(dddTelefone);
	}

	/**
	* Returns the telefone of this curso inscricao cnpj.
	*
	* @return the telefone of this curso inscricao cnpj
	*/
	@Override
	public java.lang.String getTelefone() {
		return _cursoInscricaoCnpj.getTelefone();
	}

	/**
	* Sets the telefone of this curso inscricao cnpj.
	*
	* @param telefone the telefone of this curso inscricao cnpj
	*/
	@Override
	public void setTelefone(java.lang.String telefone) {
		_cursoInscricaoCnpj.setTelefone(telefone);
	}

	/**
	* Returns the nf nome of this curso inscricao cnpj.
	*
	* @return the nf nome of this curso inscricao cnpj
	*/
	@Override
	public java.lang.String getNfNome() {
		return _cursoInscricaoCnpj.getNfNome();
	}

	/**
	* Sets the nf nome of this curso inscricao cnpj.
	*
	* @param nfNome the nf nome of this curso inscricao cnpj
	*/
	@Override
	public void setNfNome(java.lang.String nfNome) {
		_cursoInscricaoCnpj.setNfNome(nfNome);
	}

	/**
	* Returns the nf departamento of this curso inscricao cnpj.
	*
	* @return the nf departamento of this curso inscricao cnpj
	*/
	@Override
	public java.lang.String getNfDepartamento() {
		return _cursoInscricaoCnpj.getNfDepartamento();
	}

	/**
	* Sets the nf departamento of this curso inscricao cnpj.
	*
	* @param nfDepartamento the nf departamento of this curso inscricao cnpj
	*/
	@Override
	public void setNfDepartamento(java.lang.String nfDepartamento) {
		_cursoInscricaoCnpj.setNfDepartamento(nfDepartamento);
	}

	/**
	* Returns the nf email of this curso inscricao cnpj.
	*
	* @return the nf email of this curso inscricao cnpj
	*/
	@Override
	public java.lang.String getNfEmail() {
		return _cursoInscricaoCnpj.getNfEmail();
	}

	/**
	* Sets the nf email of this curso inscricao cnpj.
	*
	* @param nfEmail the nf email of this curso inscricao cnpj
	*/
	@Override
	public void setNfEmail(java.lang.String nfEmail) {
		_cursoInscricaoCnpj.setNfEmail(nfEmail);
	}

	/**
	* Returns the nf ddd telefone of this curso inscricao cnpj.
	*
	* @return the nf ddd telefone of this curso inscricao cnpj
	*/
	@Override
	public java.lang.String getNfDddTelefone() {
		return _cursoInscricaoCnpj.getNfDddTelefone();
	}

	/**
	* Sets the nf ddd telefone of this curso inscricao cnpj.
	*
	* @param nfDddTelefone the nf ddd telefone of this curso inscricao cnpj
	*/
	@Override
	public void setNfDddTelefone(java.lang.String nfDddTelefone) {
		_cursoInscricaoCnpj.setNfDddTelefone(nfDddTelefone);
	}

	/**
	* Returns the nf telefone of this curso inscricao cnpj.
	*
	* @return the nf telefone of this curso inscricao cnpj
	*/
	@Override
	public java.lang.String getNfTelefone() {
		return _cursoInscricaoCnpj.getNfTelefone();
	}

	/**
	* Sets the nf telefone of this curso inscricao cnpj.
	*
	* @param nfTelefone the nf telefone of this curso inscricao cnpj
	*/
	@Override
	public void setNfTelefone(java.lang.String nfTelefone) {
		_cursoInscricaoCnpj.setNfTelefone(nfTelefone);
	}

	/**
	* Returns the observacao of this curso inscricao cnpj.
	*
	* @return the observacao of this curso inscricao cnpj
	*/
	@Override
	public java.lang.String getObservacao() {
		return _cursoInscricaoCnpj.getObservacao();
	}

	/**
	* Sets the observacao of this curso inscricao cnpj.
	*
	* @param observacao the observacao of this curso inscricao cnpj
	*/
	@Override
	public void setObservacao(java.lang.String observacao) {
		_cursoInscricaoCnpj.setObservacao(observacao);
	}

	@Override
	public boolean isNew() {
		return _cursoInscricaoCnpj.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_cursoInscricaoCnpj.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _cursoInscricaoCnpj.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cursoInscricaoCnpj.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _cursoInscricaoCnpj.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _cursoInscricaoCnpj.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cursoInscricaoCnpj.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cursoInscricaoCnpj.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_cursoInscricaoCnpj.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_cursoInscricaoCnpj.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cursoInscricaoCnpj.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CursoInscricaoCnpjWrapper((CursoInscricaoCnpj)_cursoInscricaoCnpj.clone());
	}

	@Override
	public int compareTo(
		br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj cursoInscricaoCnpj) {
		return _cursoInscricaoCnpj.compareTo(cursoInscricaoCnpj);
	}

	@Override
	public int hashCode() {
		return _cursoInscricaoCnpj.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj> toCacheModel() {
		return _cursoInscricaoCnpj.toCacheModel();
	}

	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj toEscapedModel() {
		return new CursoInscricaoCnpjWrapper(_cursoInscricaoCnpj.toEscapedModel());
	}

	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj toUnescapedModel() {
		return new CursoInscricaoCnpjWrapper(_cursoInscricaoCnpj.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cursoInscricaoCnpj.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _cursoInscricaoCnpj.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cursoInscricaoCnpj.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CursoInscricaoCnpjWrapper)) {
			return false;
		}

		CursoInscricaoCnpjWrapper cursoInscricaoCnpjWrapper = (CursoInscricaoCnpjWrapper)obj;

		if (Validator.equals(_cursoInscricaoCnpj,
					cursoInscricaoCnpjWrapper._cursoInscricaoCnpj)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CursoInscricaoCnpj getWrappedCursoInscricaoCnpj() {
		return _cursoInscricaoCnpj;
	}

	@Override
	public CursoInscricaoCnpj getWrappedModel() {
		return _cursoInscricaoCnpj;
	}

	@Override
	public void resetOriginalValues() {
		_cursoInscricaoCnpj.resetOriginalValues();
	}

	private CursoInscricaoCnpj _cursoInscricaoCnpj;
}