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
 * This class is a wrapper for {@link CursoParticipante}.
 * </p>
 *
 * @author SEA
 * @see CursoParticipante
 * @generated
 */
public class CursoParticipanteWrapper implements CursoParticipante,
	ModelWrapper<CursoParticipante> {
	public CursoParticipanteWrapper(CursoParticipante cursoParticipante) {
		_cursoParticipante = cursoParticipante;
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

	/**
	* Returns the primary key of this curso participante.
	*
	* @return the primary key of this curso participante
	*/
	@Override
	public long getPrimaryKey() {
		return _cursoParticipante.getPrimaryKey();
	}

	/**
	* Sets the primary key of this curso participante.
	*
	* @param primaryKey the primary key of this curso participante
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cursoParticipante.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the participante ID of this curso participante.
	*
	* @return the participante ID of this curso participante
	*/
	@Override
	public long getParticipanteId() {
		return _cursoParticipante.getParticipanteId();
	}

	/**
	* Sets the participante ID of this curso participante.
	*
	* @param participanteId the participante ID of this curso participante
	*/
	@Override
	public void setParticipanteId(long participanteId) {
		_cursoParticipante.setParticipanteId(participanteId);
	}

	/**
	* Returns the inscricao ID of this curso participante.
	*
	* @return the inscricao ID of this curso participante
	*/
	@Override
	public long getInscricaoId() {
		return _cursoParticipante.getInscricaoId();
	}

	/**
	* Sets the inscricao ID of this curso participante.
	*
	* @param inscricaoId the inscricao ID of this curso participante
	*/
	@Override
	public void setInscricaoId(long inscricaoId) {
		_cursoParticipante.setInscricaoId(inscricaoId);
	}

	/**
	* Returns the nome completo of this curso participante.
	*
	* @return the nome completo of this curso participante
	*/
	@Override
	public java.lang.String getNomeCompleto() {
		return _cursoParticipante.getNomeCompleto();
	}

	/**
	* Sets the nome completo of this curso participante.
	*
	* @param nomeCompleto the nome completo of this curso participante
	*/
	@Override
	public void setNomeCompleto(java.lang.String nomeCompleto) {
		_cursoParticipante.setNomeCompleto(nomeCompleto);
	}

	/**
	* Returns the nome cracha of this curso participante.
	*
	* @return the nome cracha of this curso participante
	*/
	@Override
	public java.lang.String getNomeCracha() {
		return _cursoParticipante.getNomeCracha();
	}

	/**
	* Sets the nome cracha of this curso participante.
	*
	* @param nomeCracha the nome cracha of this curso participante
	*/
	@Override
	public void setNomeCracha(java.lang.String nomeCracha) {
		_cursoParticipante.setNomeCracha(nomeCracha);
	}

	/**
	* Returns the cpf of this curso participante.
	*
	* @return the cpf of this curso participante
	*/
	@Override
	public java.lang.String getCpf() {
		return _cursoParticipante.getCpf();
	}

	/**
	* Sets the cpf of this curso participante.
	*
	* @param cpf the cpf of this curso participante
	*/
	@Override
	public void setCpf(java.lang.String cpf) {
		_cursoParticipante.setCpf(cpf);
	}

	/**
	* Returns the sexo of this curso participante.
	*
	* @return the sexo of this curso participante
	*/
	@Override
	public java.lang.String getSexo() {
		return _cursoParticipante.getSexo();
	}

	/**
	* Sets the sexo of this curso participante.
	*
	* @param sexo the sexo of this curso participante
	*/
	@Override
	public void setSexo(java.lang.String sexo) {
		_cursoParticipante.setSexo(sexo);
	}

	/**
	* Returns the cargo of this curso participante.
	*
	* @return the cargo of this curso participante
	*/
	@Override
	public java.lang.String getCargo() {
		return _cursoParticipante.getCargo();
	}

	/**
	* Sets the cargo of this curso participante.
	*
	* @param cargo the cargo of this curso participante
	*/
	@Override
	public void setCargo(java.lang.String cargo) {
		_cursoParticipante.setCargo(cargo);
	}

	/**
	* Returns the empresa onde trabalha of this curso participante.
	*
	* @return the empresa onde trabalha of this curso participante
	*/
	@Override
	public java.lang.String getEmpresaOndeTrabalha() {
		return _cursoParticipante.getEmpresaOndeTrabalha();
	}

	/**
	* Sets the empresa onde trabalha of this curso participante.
	*
	* @param empresaOndeTrabalha the empresa onde trabalha of this curso participante
	*/
	@Override
	public void setEmpresaOndeTrabalha(java.lang.String empresaOndeTrabalha) {
		_cursoParticipante.setEmpresaOndeTrabalha(empresaOndeTrabalha);
	}

	/**
	* Returns the departamento of this curso participante.
	*
	* @return the departamento of this curso participante
	*/
	@Override
	public java.lang.String getDepartamento() {
		return _cursoParticipante.getDepartamento();
	}

	/**
	* Sets the departamento of this curso participante.
	*
	* @param departamento the departamento of this curso participante
	*/
	@Override
	public void setDepartamento(java.lang.String departamento) {
		_cursoParticipante.setDepartamento(departamento);
	}

	/**
	* Returns the formacao academica of this curso participante.
	*
	* @return the formacao academica of this curso participante
	*/
	@Override
	public java.lang.String getFormacaoAcademica() {
		return _cursoParticipante.getFormacaoAcademica();
	}

	/**
	* Sets the formacao academica of this curso participante.
	*
	* @param formacaoAcademica the formacao academica of this curso participante
	*/
	@Override
	public void setFormacaoAcademica(java.lang.String formacaoAcademica) {
		_cursoParticipante.setFormacaoAcademica(formacaoAcademica);
	}

	/**
	* Returns the email principal of this curso participante.
	*
	* @return the email principal of this curso participante
	*/
	@Override
	public java.lang.String getEmailPrincipal() {
		return _cursoParticipante.getEmailPrincipal();
	}

	/**
	* Sets the email principal of this curso participante.
	*
	* @param emailPrincipal the email principal of this curso participante
	*/
	@Override
	public void setEmailPrincipal(java.lang.String emailPrincipal) {
		_cursoParticipante.setEmailPrincipal(emailPrincipal);
	}

	/**
	* Returns the email opcional of this curso participante.
	*
	* @return the email opcional of this curso participante
	*/
	@Override
	public java.lang.String getEmailOpcional() {
		return _cursoParticipante.getEmailOpcional();
	}

	/**
	* Sets the email opcional of this curso participante.
	*
	* @param emailOpcional the email opcional of this curso participante
	*/
	@Override
	public void setEmailOpcional(java.lang.String emailOpcional) {
		_cursoParticipante.setEmailOpcional(emailOpcional);
	}

	/**
	* Returns the ddd telefone comercial of this curso participante.
	*
	* @return the ddd telefone comercial of this curso participante
	*/
	@Override
	public java.lang.String getDddTelefoneComercial() {
		return _cursoParticipante.getDddTelefoneComercial();
	}

	/**
	* Sets the ddd telefone comercial of this curso participante.
	*
	* @param dddTelefoneComercial the ddd telefone comercial of this curso participante
	*/
	@Override
	public void setDddTelefoneComercial(java.lang.String dddTelefoneComercial) {
		_cursoParticipante.setDddTelefoneComercial(dddTelefoneComercial);
	}

	/**
	* Returns the telefone comercial of this curso participante.
	*
	* @return the telefone comercial of this curso participante
	*/
	@Override
	public java.lang.String getTelefoneComercial() {
		return _cursoParticipante.getTelefoneComercial();
	}

	/**
	* Sets the telefone comercial of this curso participante.
	*
	* @param telefoneComercial the telefone comercial of this curso participante
	*/
	@Override
	public void setTelefoneComercial(java.lang.String telefoneComercial) {
		_cursoParticipante.setTelefoneComercial(telefoneComercial);
	}

	/**
	* Returns the ddd telefone pessoal of this curso participante.
	*
	* @return the ddd telefone pessoal of this curso participante
	*/
	@Override
	public java.lang.String getDddTelefonePessoal() {
		return _cursoParticipante.getDddTelefonePessoal();
	}

	/**
	* Sets the ddd telefone pessoal of this curso participante.
	*
	* @param dddTelefonePessoal the ddd telefone pessoal of this curso participante
	*/
	@Override
	public void setDddTelefonePessoal(java.lang.String dddTelefonePessoal) {
		_cursoParticipante.setDddTelefonePessoal(dddTelefonePessoal);
	}

	/**
	* Returns the telefone pessoal of this curso participante.
	*
	* @return the telefone pessoal of this curso participante
	*/
	@Override
	public java.lang.String getTelefonePessoal() {
		return _cursoParticipante.getTelefonePessoal();
	}

	/**
	* Sets the telefone pessoal of this curso participante.
	*
	* @param telefonePessoal the telefone pessoal of this curso participante
	*/
	@Override
	public void setTelefonePessoal(java.lang.String telefonePessoal) {
		_cursoParticipante.setTelefonePessoal(telefonePessoal);
	}

	/**
	* Returns the ddd telefone celular of this curso participante.
	*
	* @return the ddd telefone celular of this curso participante
	*/
	@Override
	public java.lang.String getDddTelefoneCelular() {
		return _cursoParticipante.getDddTelefoneCelular();
	}

	/**
	* Sets the ddd telefone celular of this curso participante.
	*
	* @param dddTelefoneCelular the ddd telefone celular of this curso participante
	*/
	@Override
	public void setDddTelefoneCelular(java.lang.String dddTelefoneCelular) {
		_cursoParticipante.setDddTelefoneCelular(dddTelefoneCelular);
	}

	/**
	* Returns the telefone celular of this curso participante.
	*
	* @return the telefone celular of this curso participante
	*/
	@Override
	public java.lang.String getTelefoneCelular() {
		return _cursoParticipante.getTelefoneCelular();
	}

	/**
	* Sets the telefone celular of this curso participante.
	*
	* @param telefoneCelular the telefone celular of this curso participante
	*/
	@Override
	public void setTelefoneCelular(java.lang.String telefoneCelular) {
		_cursoParticipante.setTelefoneCelular(telefoneCelular);
	}

	/**
	* Returns the endereco of this curso participante.
	*
	* @return the endereco of this curso participante
	*/
	@Override
	public java.lang.String getEndereco() {
		return _cursoParticipante.getEndereco();
	}

	/**
	* Sets the endereco of this curso participante.
	*
	* @param endereco the endereco of this curso participante
	*/
	@Override
	public void setEndereco(java.lang.String endereco) {
		_cursoParticipante.setEndereco(endereco);
	}

	/**
	* Returns the bairro of this curso participante.
	*
	* @return the bairro of this curso participante
	*/
	@Override
	public java.lang.String getBairro() {
		return _cursoParticipante.getBairro();
	}

	/**
	* Sets the bairro of this curso participante.
	*
	* @param bairro the bairro of this curso participante
	*/
	@Override
	public void setBairro(java.lang.String bairro) {
		_cursoParticipante.setBairro(bairro);
	}

	/**
	* Returns the cidade of this curso participante.
	*
	* @return the cidade of this curso participante
	*/
	@Override
	public java.lang.String getCidade() {
		return _cursoParticipante.getCidade();
	}

	/**
	* Sets the cidade of this curso participante.
	*
	* @param cidade the cidade of this curso participante
	*/
	@Override
	public void setCidade(java.lang.String cidade) {
		_cursoParticipante.setCidade(cidade);
	}

	/**
	* Returns the estado of this curso participante.
	*
	* @return the estado of this curso participante
	*/
	@Override
	public java.lang.String getEstado() {
		return _cursoParticipante.getEstado();
	}

	/**
	* Sets the estado of this curso participante.
	*
	* @param estado the estado of this curso participante
	*/
	@Override
	public void setEstado(java.lang.String estado) {
		_cursoParticipante.setEstado(estado);
	}

	/**
	* Returns the cep of this curso participante.
	*
	* @return the cep of this curso participante
	*/
	@Override
	public java.lang.String getCep() {
		return _cursoParticipante.getCep();
	}

	/**
	* Sets the cep of this curso participante.
	*
	* @param cep the cep of this curso participante
	*/
	@Override
	public void setCep(java.lang.String cep) {
		_cursoParticipante.setCep(cep);
	}

	/**
	* Returns the valor pago of this curso participante.
	*
	* @return the valor pago of this curso participante
	*/
	@Override
	public java.lang.String getValorPago() {
		return _cursoParticipante.getValorPago();
	}

	/**
	* Sets the valor pago of this curso participante.
	*
	* @param valorPago the valor pago of this curso participante
	*/
	@Override
	public void setValorPago(java.lang.String valorPago) {
		_cursoParticipante.setValorPago(valorPago);
	}

	/**
	* Returns the expectativa curso of this curso participante.
	*
	* @return the expectativa curso of this curso participante
	*/
	@Override
	public java.lang.String getExpectativaCurso() {
		return _cursoParticipante.getExpectativaCurso();
	}

	/**
	* Sets the expectativa curso of this curso participante.
	*
	* @param expectativaCurso the expectativa curso of this curso participante
	*/
	@Override
	public void setExpectativaCurso(java.lang.String expectativaCurso) {
		_cursoParticipante.setExpectativaCurso(expectativaCurso);
	}

	/**
	* Returns the observacao of this curso participante.
	*
	* @return the observacao of this curso participante
	*/
	@Override
	public java.lang.String getObservacao() {
		return _cursoParticipante.getObservacao();
	}

	/**
	* Sets the observacao of this curso participante.
	*
	* @param observacao the observacao of this curso participante
	*/
	@Override
	public void setObservacao(java.lang.String observacao) {
		_cursoParticipante.setObservacao(observacao);
	}

	@Override
	public boolean isNew() {
		return _cursoParticipante.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_cursoParticipante.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _cursoParticipante.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cursoParticipante.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _cursoParticipante.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _cursoParticipante.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cursoParticipante.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cursoParticipante.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_cursoParticipante.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_cursoParticipante.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cursoParticipante.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CursoParticipanteWrapper((CursoParticipante)_cursoParticipante.clone());
	}

	@Override
	public int compareTo(
		br.com.cnf.curso.inscricao.model.CursoParticipante cursoParticipante) {
		return _cursoParticipante.compareTo(cursoParticipante);
	}

	@Override
	public int hashCode() {
		return _cursoParticipante.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.cnf.curso.inscricao.model.CursoParticipante> toCacheModel() {
		return _cursoParticipante.toCacheModel();
	}

	@Override
	public br.com.cnf.curso.inscricao.model.CursoParticipante toEscapedModel() {
		return new CursoParticipanteWrapper(_cursoParticipante.toEscapedModel());
	}

	@Override
	public br.com.cnf.curso.inscricao.model.CursoParticipante toUnescapedModel() {
		return new CursoParticipanteWrapper(_cursoParticipante.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cursoParticipante.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _cursoParticipante.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cursoParticipante.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CursoParticipanteWrapper)) {
			return false;
		}

		CursoParticipanteWrapper cursoParticipanteWrapper = (CursoParticipanteWrapper)obj;

		if (Validator.equals(_cursoParticipante,
					cursoParticipanteWrapper._cursoParticipante)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CursoParticipante getWrappedCursoParticipante() {
		return _cursoParticipante;
	}

	@Override
	public CursoParticipante getWrappedModel() {
		return _cursoParticipante;
	}

	@Override
	public void resetOriginalValues() {
		_cursoParticipante.resetOriginalValues();
	}

	private CursoParticipante _cursoParticipante;
}