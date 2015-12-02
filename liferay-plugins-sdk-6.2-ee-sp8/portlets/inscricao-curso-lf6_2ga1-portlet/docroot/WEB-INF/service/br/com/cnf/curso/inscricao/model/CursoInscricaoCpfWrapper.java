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
 * This class is a wrapper for {@link CursoInscricaoCpf}.
 * </p>
 *
 * @author SEA
 * @see CursoInscricaoCpf
 * @generated
 */
public class CursoInscricaoCpfWrapper implements CursoInscricaoCpf,
	ModelWrapper<CursoInscricaoCpf> {
	public CursoInscricaoCpfWrapper(CursoInscricaoCpf cursoInscricaoCpf) {
		_cursoInscricaoCpf = cursoInscricaoCpf;
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

	/**
	* Returns the primary key of this curso inscricao cpf.
	*
	* @return the primary key of this curso inscricao cpf
	*/
	@Override
	public long getPrimaryKey() {
		return _cursoInscricaoCpf.getPrimaryKey();
	}

	/**
	* Sets the primary key of this curso inscricao cpf.
	*
	* @param primaryKey the primary key of this curso inscricao cpf
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cursoInscricaoCpf.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the inscricao cpf ID of this curso inscricao cpf.
	*
	* @return the inscricao cpf ID of this curso inscricao cpf
	*/
	@Override
	public long getInscricaoCpfId() {
		return _cursoInscricaoCpf.getInscricaoCpfId();
	}

	/**
	* Sets the inscricao cpf ID of this curso inscricao cpf.
	*
	* @param inscricaoCpfId the inscricao cpf ID of this curso inscricao cpf
	*/
	@Override
	public void setInscricaoCpfId(long inscricaoCpfId) {
		_cursoInscricaoCpf.setInscricaoCpfId(inscricaoCpfId);
	}

	/**
	* Returns the inscricao ID of this curso inscricao cpf.
	*
	* @return the inscricao ID of this curso inscricao cpf
	*/
	@Override
	public long getInscricaoId() {
		return _cursoInscricaoCpf.getInscricaoId();
	}

	/**
	* Sets the inscricao ID of this curso inscricao cpf.
	*
	* @param inscricaoId the inscricao ID of this curso inscricao cpf
	*/
	@Override
	public void setInscricaoId(long inscricaoId) {
		_cursoInscricaoCpf.setInscricaoId(inscricaoId);
	}

	/**
	* Returns the nome of this curso inscricao cpf.
	*
	* @return the nome of this curso inscricao cpf
	*/
	@Override
	public java.lang.String getNome() {
		return _cursoInscricaoCpf.getNome();
	}

	/**
	* Sets the nome of this curso inscricao cpf.
	*
	* @param nome the nome of this curso inscricao cpf
	*/
	@Override
	public void setNome(java.lang.String nome) {
		_cursoInscricaoCpf.setNome(nome);
	}

	/**
	* Returns the cpf of this curso inscricao cpf.
	*
	* @return the cpf of this curso inscricao cpf
	*/
	@Override
	public java.lang.String getCpf() {
		return _cursoInscricaoCpf.getCpf();
	}

	/**
	* Sets the cpf of this curso inscricao cpf.
	*
	* @param cpf the cpf of this curso inscricao cpf
	*/
	@Override
	public void setCpf(java.lang.String cpf) {
		_cursoInscricaoCpf.setCpf(cpf);
	}

	/**
	* Returns the endereco of this curso inscricao cpf.
	*
	* @return the endereco of this curso inscricao cpf
	*/
	@Override
	public java.lang.String getEndereco() {
		return _cursoInscricaoCpf.getEndereco();
	}

	/**
	* Sets the endereco of this curso inscricao cpf.
	*
	* @param endereco the endereco of this curso inscricao cpf
	*/
	@Override
	public void setEndereco(java.lang.String endereco) {
		_cursoInscricaoCpf.setEndereco(endereco);
	}

	/**
	* Returns the bairro of this curso inscricao cpf.
	*
	* @return the bairro of this curso inscricao cpf
	*/
	@Override
	public java.lang.String getBairro() {
		return _cursoInscricaoCpf.getBairro();
	}

	/**
	* Sets the bairro of this curso inscricao cpf.
	*
	* @param bairro the bairro of this curso inscricao cpf
	*/
	@Override
	public void setBairro(java.lang.String bairro) {
		_cursoInscricaoCpf.setBairro(bairro);
	}

	/**
	* Returns the cidade of this curso inscricao cpf.
	*
	* @return the cidade of this curso inscricao cpf
	*/
	@Override
	public java.lang.String getCidade() {
		return _cursoInscricaoCpf.getCidade();
	}

	/**
	* Sets the cidade of this curso inscricao cpf.
	*
	* @param cidade the cidade of this curso inscricao cpf
	*/
	@Override
	public void setCidade(java.lang.String cidade) {
		_cursoInscricaoCpf.setCidade(cidade);
	}

	/**
	* Returns the estado of this curso inscricao cpf.
	*
	* @return the estado of this curso inscricao cpf
	*/
	@Override
	public java.lang.String getEstado() {
		return _cursoInscricaoCpf.getEstado();
	}

	/**
	* Sets the estado of this curso inscricao cpf.
	*
	* @param estado the estado of this curso inscricao cpf
	*/
	@Override
	public void setEstado(java.lang.String estado) {
		_cursoInscricaoCpf.setEstado(estado);
	}

	/**
	* Returns the cep of this curso inscricao cpf.
	*
	* @return the cep of this curso inscricao cpf
	*/
	@Override
	public java.lang.String getCep() {
		return _cursoInscricaoCpf.getCep();
	}

	/**
	* Sets the cep of this curso inscricao cpf.
	*
	* @param cep the cep of this curso inscricao cpf
	*/
	@Override
	public void setCep(java.lang.String cep) {
		_cursoInscricaoCpf.setCep(cep);
	}

	/**
	* Returns the ddd telefone of this curso inscricao cpf.
	*
	* @return the ddd telefone of this curso inscricao cpf
	*/
	@Override
	public java.lang.String getDddTelefone() {
		return _cursoInscricaoCpf.getDddTelefone();
	}

	/**
	* Sets the ddd telefone of this curso inscricao cpf.
	*
	* @param dddTelefone the ddd telefone of this curso inscricao cpf
	*/
	@Override
	public void setDddTelefone(java.lang.String dddTelefone) {
		_cursoInscricaoCpf.setDddTelefone(dddTelefone);
	}

	/**
	* Returns the telefone of this curso inscricao cpf.
	*
	* @return the telefone of this curso inscricao cpf
	*/
	@Override
	public java.lang.String getTelefone() {
		return _cursoInscricaoCpf.getTelefone();
	}

	/**
	* Sets the telefone of this curso inscricao cpf.
	*
	* @param telefone the telefone of this curso inscricao cpf
	*/
	@Override
	public void setTelefone(java.lang.String telefone) {
		_cursoInscricaoCpf.setTelefone(telefone);
	}

	/**
	* Returns the email of this curso inscricao cpf.
	*
	* @return the email of this curso inscricao cpf
	*/
	@Override
	public java.lang.String getEmail() {
		return _cursoInscricaoCpf.getEmail();
	}

	/**
	* Sets the email of this curso inscricao cpf.
	*
	* @param email the email of this curso inscricao cpf
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_cursoInscricaoCpf.setEmail(email);
	}

	/**
	* Returns the empresa of this curso inscricao cpf.
	*
	* @return the empresa of this curso inscricao cpf
	*/
	@Override
	public java.lang.String getEmpresa() {
		return _cursoInscricaoCpf.getEmpresa();
	}

	/**
	* Sets the empresa of this curso inscricao cpf.
	*
	* @param empresa the empresa of this curso inscricao cpf
	*/
	@Override
	public void setEmpresa(java.lang.String empresa) {
		_cursoInscricaoCpf.setEmpresa(empresa);
	}

	/**
	* Returns the cargo of this curso inscricao cpf.
	*
	* @return the cargo of this curso inscricao cpf
	*/
	@Override
	public java.lang.String getCargo() {
		return _cursoInscricaoCpf.getCargo();
	}

	/**
	* Sets the cargo of this curso inscricao cpf.
	*
	* @param cargo the cargo of this curso inscricao cpf
	*/
	@Override
	public void setCargo(java.lang.String cargo) {
		_cursoInscricaoCpf.setCargo(cargo);
	}

	/**
	* Returns the departamento of this curso inscricao cpf.
	*
	* @return the departamento of this curso inscricao cpf
	*/
	@Override
	public java.lang.String getDepartamento() {
		return _cursoInscricaoCpf.getDepartamento();
	}

	/**
	* Sets the departamento of this curso inscricao cpf.
	*
	* @param departamento the departamento of this curso inscricao cpf
	*/
	@Override
	public void setDepartamento(java.lang.String departamento) {
		_cursoInscricaoCpf.setDepartamento(departamento);
	}

	/**
	* Returns the observacao of this curso inscricao cpf.
	*
	* @return the observacao of this curso inscricao cpf
	*/
	@Override
	public java.lang.String getObservacao() {
		return _cursoInscricaoCpf.getObservacao();
	}

	/**
	* Sets the observacao of this curso inscricao cpf.
	*
	* @param observacao the observacao of this curso inscricao cpf
	*/
	@Override
	public void setObservacao(java.lang.String observacao) {
		_cursoInscricaoCpf.setObservacao(observacao);
	}

	@Override
	public boolean isNew() {
		return _cursoInscricaoCpf.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_cursoInscricaoCpf.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _cursoInscricaoCpf.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cursoInscricaoCpf.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _cursoInscricaoCpf.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _cursoInscricaoCpf.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cursoInscricaoCpf.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cursoInscricaoCpf.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_cursoInscricaoCpf.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_cursoInscricaoCpf.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cursoInscricaoCpf.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CursoInscricaoCpfWrapper((CursoInscricaoCpf)_cursoInscricaoCpf.clone());
	}

	@Override
	public int compareTo(
		br.com.cnf.curso.inscricao.model.CursoInscricaoCpf cursoInscricaoCpf) {
		return _cursoInscricaoCpf.compareTo(cursoInscricaoCpf);
	}

	@Override
	public int hashCode() {
		return _cursoInscricaoCpf.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.cnf.curso.inscricao.model.CursoInscricaoCpf> toCacheModel() {
		return _cursoInscricaoCpf.toCacheModel();
	}

	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricaoCpf toEscapedModel() {
		return new CursoInscricaoCpfWrapper(_cursoInscricaoCpf.toEscapedModel());
	}

	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricaoCpf toUnescapedModel() {
		return new CursoInscricaoCpfWrapper(_cursoInscricaoCpf.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cursoInscricaoCpf.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _cursoInscricaoCpf.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cursoInscricaoCpf.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CursoInscricaoCpfWrapper)) {
			return false;
		}

		CursoInscricaoCpfWrapper cursoInscricaoCpfWrapper = (CursoInscricaoCpfWrapper)obj;

		if (Validator.equals(_cursoInscricaoCpf,
					cursoInscricaoCpfWrapper._cursoInscricaoCpf)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CursoInscricaoCpf getWrappedCursoInscricaoCpf() {
		return _cursoInscricaoCpf;
	}

	@Override
	public CursoInscricaoCpf getWrappedModel() {
		return _cursoInscricaoCpf;
	}

	@Override
	public void resetOriginalValues() {
		_cursoInscricaoCpf.resetOriginalValues();
	}

	private CursoInscricaoCpf _cursoInscricaoCpf;
}