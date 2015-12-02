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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the CursoInscricaoCpf service. Represents a row in the &quot;cnf_CursoInscricaoCpf&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCpfModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCpfImpl}.
 * </p>
 *
 * @author SEA
 * @see CursoInscricaoCpf
 * @see br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCpfImpl
 * @see br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCpfModelImpl
 * @generated
 */
public interface CursoInscricaoCpfModel extends BaseModel<CursoInscricaoCpf> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a curso inscricao cpf model instance should use the {@link CursoInscricaoCpf} interface instead.
	 */

	/**
	 * Returns the primary key of this curso inscricao cpf.
	 *
	 * @return the primary key of this curso inscricao cpf
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this curso inscricao cpf.
	 *
	 * @param primaryKey the primary key of this curso inscricao cpf
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the inscricao cpf ID of this curso inscricao cpf.
	 *
	 * @return the inscricao cpf ID of this curso inscricao cpf
	 */
	public long getInscricaoCpfId();

	/**
	 * Sets the inscricao cpf ID of this curso inscricao cpf.
	 *
	 * @param inscricaoCpfId the inscricao cpf ID of this curso inscricao cpf
	 */
	public void setInscricaoCpfId(long inscricaoCpfId);

	/**
	 * Returns the inscricao ID of this curso inscricao cpf.
	 *
	 * @return the inscricao ID of this curso inscricao cpf
	 */
	public long getInscricaoId();

	/**
	 * Sets the inscricao ID of this curso inscricao cpf.
	 *
	 * @param inscricaoId the inscricao ID of this curso inscricao cpf
	 */
	public void setInscricaoId(long inscricaoId);

	/**
	 * Returns the nome of this curso inscricao cpf.
	 *
	 * @return the nome of this curso inscricao cpf
	 */
	@AutoEscape
	public String getNome();

	/**
	 * Sets the nome of this curso inscricao cpf.
	 *
	 * @param nome the nome of this curso inscricao cpf
	 */
	public void setNome(String nome);

	/**
	 * Returns the cpf of this curso inscricao cpf.
	 *
	 * @return the cpf of this curso inscricao cpf
	 */
	@AutoEscape
	public String getCpf();

	/**
	 * Sets the cpf of this curso inscricao cpf.
	 *
	 * @param cpf the cpf of this curso inscricao cpf
	 */
	public void setCpf(String cpf);

	/**
	 * Returns the endereco of this curso inscricao cpf.
	 *
	 * @return the endereco of this curso inscricao cpf
	 */
	@AutoEscape
	public String getEndereco();

	/**
	 * Sets the endereco of this curso inscricao cpf.
	 *
	 * @param endereco the endereco of this curso inscricao cpf
	 */
	public void setEndereco(String endereco);

	/**
	 * Returns the bairro of this curso inscricao cpf.
	 *
	 * @return the bairro of this curso inscricao cpf
	 */
	@AutoEscape
	public String getBairro();

	/**
	 * Sets the bairro of this curso inscricao cpf.
	 *
	 * @param bairro the bairro of this curso inscricao cpf
	 */
	public void setBairro(String bairro);

	/**
	 * Returns the cidade of this curso inscricao cpf.
	 *
	 * @return the cidade of this curso inscricao cpf
	 */
	@AutoEscape
	public String getCidade();

	/**
	 * Sets the cidade of this curso inscricao cpf.
	 *
	 * @param cidade the cidade of this curso inscricao cpf
	 */
	public void setCidade(String cidade);

	/**
	 * Returns the estado of this curso inscricao cpf.
	 *
	 * @return the estado of this curso inscricao cpf
	 */
	@AutoEscape
	public String getEstado();

	/**
	 * Sets the estado of this curso inscricao cpf.
	 *
	 * @param estado the estado of this curso inscricao cpf
	 */
	public void setEstado(String estado);

	/**
	 * Returns the cep of this curso inscricao cpf.
	 *
	 * @return the cep of this curso inscricao cpf
	 */
	@AutoEscape
	public String getCep();

	/**
	 * Sets the cep of this curso inscricao cpf.
	 *
	 * @param cep the cep of this curso inscricao cpf
	 */
	public void setCep(String cep);

	/**
	 * Returns the ddd telefone of this curso inscricao cpf.
	 *
	 * @return the ddd telefone of this curso inscricao cpf
	 */
	@AutoEscape
	public String getDddTelefone();

	/**
	 * Sets the ddd telefone of this curso inscricao cpf.
	 *
	 * @param dddTelefone the ddd telefone of this curso inscricao cpf
	 */
	public void setDddTelefone(String dddTelefone);

	/**
	 * Returns the telefone of this curso inscricao cpf.
	 *
	 * @return the telefone of this curso inscricao cpf
	 */
	@AutoEscape
	public String getTelefone();

	/**
	 * Sets the telefone of this curso inscricao cpf.
	 *
	 * @param telefone the telefone of this curso inscricao cpf
	 */
	public void setTelefone(String telefone);

	/**
	 * Returns the email of this curso inscricao cpf.
	 *
	 * @return the email of this curso inscricao cpf
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this curso inscricao cpf.
	 *
	 * @param email the email of this curso inscricao cpf
	 */
	public void setEmail(String email);

	/**
	 * Returns the empresa of this curso inscricao cpf.
	 *
	 * @return the empresa of this curso inscricao cpf
	 */
	@AutoEscape
	public String getEmpresa();

	/**
	 * Sets the empresa of this curso inscricao cpf.
	 *
	 * @param empresa the empresa of this curso inscricao cpf
	 */
	public void setEmpresa(String empresa);

	/**
	 * Returns the cargo of this curso inscricao cpf.
	 *
	 * @return the cargo of this curso inscricao cpf
	 */
	@AutoEscape
	public String getCargo();

	/**
	 * Sets the cargo of this curso inscricao cpf.
	 *
	 * @param cargo the cargo of this curso inscricao cpf
	 */
	public void setCargo(String cargo);

	/**
	 * Returns the departamento of this curso inscricao cpf.
	 *
	 * @return the departamento of this curso inscricao cpf
	 */
	@AutoEscape
	public String getDepartamento();

	/**
	 * Sets the departamento of this curso inscricao cpf.
	 *
	 * @param departamento the departamento of this curso inscricao cpf
	 */
	public void setDepartamento(String departamento);

	/**
	 * Returns the observacao of this curso inscricao cpf.
	 *
	 * @return the observacao of this curso inscricao cpf
	 */
	@AutoEscape
	public String getObservacao();

	/**
	 * Sets the observacao of this curso inscricao cpf.
	 *
	 * @param observacao the observacao of this curso inscricao cpf
	 */
	public void setObservacao(String observacao);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		br.com.cnf.curso.inscricao.model.CursoInscricaoCpf cursoInscricaoCpf);

	@Override
	public int hashCode();

	@Override
	public CacheModel<br.com.cnf.curso.inscricao.model.CursoInscricaoCpf> toCacheModel();

	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricaoCpf toEscapedModel();

	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricaoCpf toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}