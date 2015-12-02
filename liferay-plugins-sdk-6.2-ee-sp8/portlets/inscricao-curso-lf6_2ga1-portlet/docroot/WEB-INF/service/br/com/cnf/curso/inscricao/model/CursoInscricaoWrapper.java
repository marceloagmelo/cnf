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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CursoInscricao}.
 * </p>
 *
 * @author SEA
 * @see CursoInscricao
 * @generated
 */
public class CursoInscricaoWrapper implements CursoInscricao,
	ModelWrapper<CursoInscricao> {
	public CursoInscricaoWrapper(CursoInscricao cursoInscricao) {
		_cursoInscricao = cursoInscricao;
	}

	@Override
	public Class<?> getModelClass() {
		return CursoInscricao.class;
	}

	@Override
	public String getModelClassName() {
		return CursoInscricao.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("inscricaoId", getInscricaoId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userCreateId", getUserCreateId());
		attributes.put("userCreateName", getUserCreateName());
		attributes.put("userModifiedId", getUserModifiedId());
		attributes.put("userModifiedName", getUserModifiedName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("cursoId", getCursoId());
		attributes.put("cursoNome", getCursoNome());
		attributes.put("cursoData", getCursoData());
		attributes.put("cursoHorario", getCursoHorario());
		attributes.put("cursoLocal", getCursoLocal());
		attributes.put("preco", getPreco());
		attributes.put("precoConvenio", getPrecoConvenio());
		attributes.put("precoAssociado", getPrecoAssociado());
		attributes.put("tipoFisicaJuridica", getTipoFisicaJuridica());
		attributes.put("cpfCnpj", getCpfCnpj());
		attributes.put("nomeResponsavel", getNomeResponsavel());
		attributes.put("emailPrincipal", getEmailPrincipal());
		attributes.put("dddTelefoneComercial", getDddTelefoneComercial());
		attributes.put("telefoneComercial", getTelefoneComercial());
		attributes.put("sexo", getSexo());
		attributes.put("cadastroFinalizado", getCadastroFinalizado());
		attributes.put("formaPagamento", getFormaPagamento());
		attributes.put("numeroCartao", getNumeroCartao());
		attributes.put("validadeCartaoMes", getValidadeCartaoMes());
		attributes.put("validadeCartaoAno", getValidadeCartaoAno());
		attributes.put("nomeTitularCartao", getNomeTitularCartao());
		attributes.put("codigoSegurancaCartao", getCodigoSegurancaCartao());
		attributes.put("statusMoedaDigital", getStatusMoedaDigital());
		attributes.put("quantidadeParcelas", getQuantidadeParcelas());
		attributes.put("valorTotal", getValorTotal());
		attributes.put("moedaDigitalPedido", getMoedaDigitalPedido());
		attributes.put("dataInicio", getDataInicio());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long inscricaoId = (Long)attributes.get("inscricaoId");

		if (inscricaoId != null) {
			setInscricaoId(inscricaoId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userCreateId = (Long)attributes.get("userCreateId");

		if (userCreateId != null) {
			setUserCreateId(userCreateId);
		}

		String userCreateName = (String)attributes.get("userCreateName");

		if (userCreateName != null) {
			setUserCreateName(userCreateName);
		}

		Long userModifiedId = (Long)attributes.get("userModifiedId");

		if (userModifiedId != null) {
			setUserModifiedId(userModifiedId);
		}

		String userModifiedName = (String)attributes.get("userModifiedName");

		if (userModifiedName != null) {
			setUserModifiedName(userModifiedName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long cursoId = (Long)attributes.get("cursoId");

		if (cursoId != null) {
			setCursoId(cursoId);
		}

		String cursoNome = (String)attributes.get("cursoNome");

		if (cursoNome != null) {
			setCursoNome(cursoNome);
		}

		String cursoData = (String)attributes.get("cursoData");

		if (cursoData != null) {
			setCursoData(cursoData);
		}

		String cursoHorario = (String)attributes.get("cursoHorario");

		if (cursoHorario != null) {
			setCursoHorario(cursoHorario);
		}

		String cursoLocal = (String)attributes.get("cursoLocal");

		if (cursoLocal != null) {
			setCursoLocal(cursoLocal);
		}

		String preco = (String)attributes.get("preco");

		if (preco != null) {
			setPreco(preco);
		}

		String precoConvenio = (String)attributes.get("precoConvenio");

		if (precoConvenio != null) {
			setPrecoConvenio(precoConvenio);
		}

		String precoAssociado = (String)attributes.get("precoAssociado");

		if (precoAssociado != null) {
			setPrecoAssociado(precoAssociado);
		}

		String tipoFisicaJuridica = (String)attributes.get("tipoFisicaJuridica");

		if (tipoFisicaJuridica != null) {
			setTipoFisicaJuridica(tipoFisicaJuridica);
		}

		String cpfCnpj = (String)attributes.get("cpfCnpj");

		if (cpfCnpj != null) {
			setCpfCnpj(cpfCnpj);
		}

		String nomeResponsavel = (String)attributes.get("nomeResponsavel");

		if (nomeResponsavel != null) {
			setNomeResponsavel(nomeResponsavel);
		}

		String emailPrincipal = (String)attributes.get("emailPrincipal");

		if (emailPrincipal != null) {
			setEmailPrincipal(emailPrincipal);
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

		String sexo = (String)attributes.get("sexo");

		if (sexo != null) {
			setSexo(sexo);
		}

		Boolean cadastroFinalizado = (Boolean)attributes.get(
				"cadastroFinalizado");

		if (cadastroFinalizado != null) {
			setCadastroFinalizado(cadastroFinalizado);
		}

		String formaPagamento = (String)attributes.get("formaPagamento");

		if (formaPagamento != null) {
			setFormaPagamento(formaPagamento);
		}

		String numeroCartao = (String)attributes.get("numeroCartao");

		if (numeroCartao != null) {
			setNumeroCartao(numeroCartao);
		}

		Integer validadeCartaoMes = (Integer)attributes.get("validadeCartaoMes");

		if (validadeCartaoMes != null) {
			setValidadeCartaoMes(validadeCartaoMes);
		}

		Integer validadeCartaoAno = (Integer)attributes.get("validadeCartaoAno");

		if (validadeCartaoAno != null) {
			setValidadeCartaoAno(validadeCartaoAno);
		}

		String nomeTitularCartao = (String)attributes.get("nomeTitularCartao");

		if (nomeTitularCartao != null) {
			setNomeTitularCartao(nomeTitularCartao);
		}

		String codigoSegurancaCartao = (String)attributes.get(
				"codigoSegurancaCartao");

		if (codigoSegurancaCartao != null) {
			setCodigoSegurancaCartao(codigoSegurancaCartao);
		}

		String statusMoedaDigital = (String)attributes.get("statusMoedaDigital");

		if (statusMoedaDigital != null) {
			setStatusMoedaDigital(statusMoedaDigital);
		}

		Integer quantidadeParcelas = (Integer)attributes.get(
				"quantidadeParcelas");

		if (quantidadeParcelas != null) {
			setQuantidadeParcelas(quantidadeParcelas);
		}

		Double valorTotal = (Double)attributes.get("valorTotal");

		if (valorTotal != null) {
			setValorTotal(valorTotal);
		}

		String moedaDigitalPedido = (String)attributes.get("moedaDigitalPedido");

		if (moedaDigitalPedido != null) {
			setMoedaDigitalPedido(moedaDigitalPedido);
		}

		Date dataInicio = (Date)attributes.get("dataInicio");

		if (dataInicio != null) {
			setDataInicio(dataInicio);
		}
	}

	/**
	* Returns the primary key of this curso inscricao.
	*
	* @return the primary key of this curso inscricao
	*/
	@Override
	public long getPrimaryKey() {
		return _cursoInscricao.getPrimaryKey();
	}

	/**
	* Sets the primary key of this curso inscricao.
	*
	* @param primaryKey the primary key of this curso inscricao
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cursoInscricao.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the inscricao ID of this curso inscricao.
	*
	* @return the inscricao ID of this curso inscricao
	*/
	@Override
	public long getInscricaoId() {
		return _cursoInscricao.getInscricaoId();
	}

	/**
	* Sets the inscricao ID of this curso inscricao.
	*
	* @param inscricaoId the inscricao ID of this curso inscricao
	*/
	@Override
	public void setInscricaoId(long inscricaoId) {
		_cursoInscricao.setInscricaoId(inscricaoId);
	}

	/**
	* Returns the company ID of this curso inscricao.
	*
	* @return the company ID of this curso inscricao
	*/
	@Override
	public long getCompanyId() {
		return _cursoInscricao.getCompanyId();
	}

	/**
	* Sets the company ID of this curso inscricao.
	*
	* @param companyId the company ID of this curso inscricao
	*/
	@Override
	public void setCompanyId(long companyId) {
		_cursoInscricao.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this curso inscricao.
	*
	* @return the group ID of this curso inscricao
	*/
	@Override
	public long getGroupId() {
		return _cursoInscricao.getGroupId();
	}

	/**
	* Sets the group ID of this curso inscricao.
	*
	* @param groupId the group ID of this curso inscricao
	*/
	@Override
	public void setGroupId(long groupId) {
		_cursoInscricao.setGroupId(groupId);
	}

	/**
	* Returns the user create ID of this curso inscricao.
	*
	* @return the user create ID of this curso inscricao
	*/
	@Override
	public long getUserCreateId() {
		return _cursoInscricao.getUserCreateId();
	}

	/**
	* Sets the user create ID of this curso inscricao.
	*
	* @param userCreateId the user create ID of this curso inscricao
	*/
	@Override
	public void setUserCreateId(long userCreateId) {
		_cursoInscricao.setUserCreateId(userCreateId);
	}

	/**
	* Returns the user create name of this curso inscricao.
	*
	* @return the user create name of this curso inscricao
	*/
	@Override
	public java.lang.String getUserCreateName() {
		return _cursoInscricao.getUserCreateName();
	}

	/**
	* Sets the user create name of this curso inscricao.
	*
	* @param userCreateName the user create name of this curso inscricao
	*/
	@Override
	public void setUserCreateName(java.lang.String userCreateName) {
		_cursoInscricao.setUserCreateName(userCreateName);
	}

	/**
	* Returns the user modified ID of this curso inscricao.
	*
	* @return the user modified ID of this curso inscricao
	*/
	@Override
	public long getUserModifiedId() {
		return _cursoInscricao.getUserModifiedId();
	}

	/**
	* Sets the user modified ID of this curso inscricao.
	*
	* @param userModifiedId the user modified ID of this curso inscricao
	*/
	@Override
	public void setUserModifiedId(long userModifiedId) {
		_cursoInscricao.setUserModifiedId(userModifiedId);
	}

	/**
	* Returns the user modified name of this curso inscricao.
	*
	* @return the user modified name of this curso inscricao
	*/
	@Override
	public java.lang.String getUserModifiedName() {
		return _cursoInscricao.getUserModifiedName();
	}

	/**
	* Sets the user modified name of this curso inscricao.
	*
	* @param userModifiedName the user modified name of this curso inscricao
	*/
	@Override
	public void setUserModifiedName(java.lang.String userModifiedName) {
		_cursoInscricao.setUserModifiedName(userModifiedName);
	}

	/**
	* Returns the create date of this curso inscricao.
	*
	* @return the create date of this curso inscricao
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _cursoInscricao.getCreateDate();
	}

	/**
	* Sets the create date of this curso inscricao.
	*
	* @param createDate the create date of this curso inscricao
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_cursoInscricao.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this curso inscricao.
	*
	* @return the modified date of this curso inscricao
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _cursoInscricao.getModifiedDate();
	}

	/**
	* Sets the modified date of this curso inscricao.
	*
	* @param modifiedDate the modified date of this curso inscricao
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_cursoInscricao.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the curso ID of this curso inscricao.
	*
	* @return the curso ID of this curso inscricao
	*/
	@Override
	public long getCursoId() {
		return _cursoInscricao.getCursoId();
	}

	/**
	* Sets the curso ID of this curso inscricao.
	*
	* @param cursoId the curso ID of this curso inscricao
	*/
	@Override
	public void setCursoId(long cursoId) {
		_cursoInscricao.setCursoId(cursoId);
	}

	/**
	* Returns the curso nome of this curso inscricao.
	*
	* @return the curso nome of this curso inscricao
	*/
	@Override
	public java.lang.String getCursoNome() {
		return _cursoInscricao.getCursoNome();
	}

	/**
	* Sets the curso nome of this curso inscricao.
	*
	* @param cursoNome the curso nome of this curso inscricao
	*/
	@Override
	public void setCursoNome(java.lang.String cursoNome) {
		_cursoInscricao.setCursoNome(cursoNome);
	}

	/**
	* Returns the curso data of this curso inscricao.
	*
	* @return the curso data of this curso inscricao
	*/
	@Override
	public java.lang.String getCursoData() {
		return _cursoInscricao.getCursoData();
	}

	/**
	* Sets the curso data of this curso inscricao.
	*
	* @param cursoData the curso data of this curso inscricao
	*/
	@Override
	public void setCursoData(java.lang.String cursoData) {
		_cursoInscricao.setCursoData(cursoData);
	}

	/**
	* Returns the curso horario of this curso inscricao.
	*
	* @return the curso horario of this curso inscricao
	*/
	@Override
	public java.lang.String getCursoHorario() {
		return _cursoInscricao.getCursoHorario();
	}

	/**
	* Sets the curso horario of this curso inscricao.
	*
	* @param cursoHorario the curso horario of this curso inscricao
	*/
	@Override
	public void setCursoHorario(java.lang.String cursoHorario) {
		_cursoInscricao.setCursoHorario(cursoHorario);
	}

	/**
	* Returns the curso local of this curso inscricao.
	*
	* @return the curso local of this curso inscricao
	*/
	@Override
	public java.lang.String getCursoLocal() {
		return _cursoInscricao.getCursoLocal();
	}

	/**
	* Sets the curso local of this curso inscricao.
	*
	* @param cursoLocal the curso local of this curso inscricao
	*/
	@Override
	public void setCursoLocal(java.lang.String cursoLocal) {
		_cursoInscricao.setCursoLocal(cursoLocal);
	}

	/**
	* Returns the preco of this curso inscricao.
	*
	* @return the preco of this curso inscricao
	*/
	@Override
	public java.lang.String getPreco() {
		return _cursoInscricao.getPreco();
	}

	/**
	* Sets the preco of this curso inscricao.
	*
	* @param preco the preco of this curso inscricao
	*/
	@Override
	public void setPreco(java.lang.String preco) {
		_cursoInscricao.setPreco(preco);
	}

	/**
	* Returns the preco convenio of this curso inscricao.
	*
	* @return the preco convenio of this curso inscricao
	*/
	@Override
	public java.lang.String getPrecoConvenio() {
		return _cursoInscricao.getPrecoConvenio();
	}

	/**
	* Sets the preco convenio of this curso inscricao.
	*
	* @param precoConvenio the preco convenio of this curso inscricao
	*/
	@Override
	public void setPrecoConvenio(java.lang.String precoConvenio) {
		_cursoInscricao.setPrecoConvenio(precoConvenio);
	}

	/**
	* Returns the preco associado of this curso inscricao.
	*
	* @return the preco associado of this curso inscricao
	*/
	@Override
	public java.lang.String getPrecoAssociado() {
		return _cursoInscricao.getPrecoAssociado();
	}

	/**
	* Sets the preco associado of this curso inscricao.
	*
	* @param precoAssociado the preco associado of this curso inscricao
	*/
	@Override
	public void setPrecoAssociado(java.lang.String precoAssociado) {
		_cursoInscricao.setPrecoAssociado(precoAssociado);
	}

	/**
	* Returns the tipo fisica juridica of this curso inscricao.
	*
	* @return the tipo fisica juridica of this curso inscricao
	*/
	@Override
	public java.lang.String getTipoFisicaJuridica() {
		return _cursoInscricao.getTipoFisicaJuridica();
	}

	/**
	* Sets the tipo fisica juridica of this curso inscricao.
	*
	* @param tipoFisicaJuridica the tipo fisica juridica of this curso inscricao
	*/
	@Override
	public void setTipoFisicaJuridica(java.lang.String tipoFisicaJuridica) {
		_cursoInscricao.setTipoFisicaJuridica(tipoFisicaJuridica);
	}

	/**
	* Returns the cpf cnpj of this curso inscricao.
	*
	* @return the cpf cnpj of this curso inscricao
	*/
	@Override
	public java.lang.String getCpfCnpj() {
		return _cursoInscricao.getCpfCnpj();
	}

	/**
	* Sets the cpf cnpj of this curso inscricao.
	*
	* @param cpfCnpj the cpf cnpj of this curso inscricao
	*/
	@Override
	public void setCpfCnpj(java.lang.String cpfCnpj) {
		_cursoInscricao.setCpfCnpj(cpfCnpj);
	}

	/**
	* Returns the nome responsavel of this curso inscricao.
	*
	* @return the nome responsavel of this curso inscricao
	*/
	@Override
	public java.lang.String getNomeResponsavel() {
		return _cursoInscricao.getNomeResponsavel();
	}

	/**
	* Sets the nome responsavel of this curso inscricao.
	*
	* @param nomeResponsavel the nome responsavel of this curso inscricao
	*/
	@Override
	public void setNomeResponsavel(java.lang.String nomeResponsavel) {
		_cursoInscricao.setNomeResponsavel(nomeResponsavel);
	}

	/**
	* Returns the email principal of this curso inscricao.
	*
	* @return the email principal of this curso inscricao
	*/
	@Override
	public java.lang.String getEmailPrincipal() {
		return _cursoInscricao.getEmailPrincipal();
	}

	/**
	* Sets the email principal of this curso inscricao.
	*
	* @param emailPrincipal the email principal of this curso inscricao
	*/
	@Override
	public void setEmailPrincipal(java.lang.String emailPrincipal) {
		_cursoInscricao.setEmailPrincipal(emailPrincipal);
	}

	/**
	* Returns the ddd telefone comercial of this curso inscricao.
	*
	* @return the ddd telefone comercial of this curso inscricao
	*/
	@Override
	public java.lang.String getDddTelefoneComercial() {
		return _cursoInscricao.getDddTelefoneComercial();
	}

	/**
	* Sets the ddd telefone comercial of this curso inscricao.
	*
	* @param dddTelefoneComercial the ddd telefone comercial of this curso inscricao
	*/
	@Override
	public void setDddTelefoneComercial(java.lang.String dddTelefoneComercial) {
		_cursoInscricao.setDddTelefoneComercial(dddTelefoneComercial);
	}

	/**
	* Returns the telefone comercial of this curso inscricao.
	*
	* @return the telefone comercial of this curso inscricao
	*/
	@Override
	public java.lang.String getTelefoneComercial() {
		return _cursoInscricao.getTelefoneComercial();
	}

	/**
	* Sets the telefone comercial of this curso inscricao.
	*
	* @param telefoneComercial the telefone comercial of this curso inscricao
	*/
	@Override
	public void setTelefoneComercial(java.lang.String telefoneComercial) {
		_cursoInscricao.setTelefoneComercial(telefoneComercial);
	}

	/**
	* Returns the sexo of this curso inscricao.
	*
	* @return the sexo of this curso inscricao
	*/
	@Override
	public java.lang.String getSexo() {
		return _cursoInscricao.getSexo();
	}

	/**
	* Sets the sexo of this curso inscricao.
	*
	* @param sexo the sexo of this curso inscricao
	*/
	@Override
	public void setSexo(java.lang.String sexo) {
		_cursoInscricao.setSexo(sexo);
	}

	/**
	* Returns the cadastro finalizado of this curso inscricao.
	*
	* @return the cadastro finalizado of this curso inscricao
	*/
	@Override
	public boolean getCadastroFinalizado() {
		return _cursoInscricao.getCadastroFinalizado();
	}

	/**
	* Returns <code>true</code> if this curso inscricao is cadastro finalizado.
	*
	* @return <code>true</code> if this curso inscricao is cadastro finalizado; <code>false</code> otherwise
	*/
	@Override
	public boolean isCadastroFinalizado() {
		return _cursoInscricao.isCadastroFinalizado();
	}

	/**
	* Sets whether this curso inscricao is cadastro finalizado.
	*
	* @param cadastroFinalizado the cadastro finalizado of this curso inscricao
	*/
	@Override
	public void setCadastroFinalizado(boolean cadastroFinalizado) {
		_cursoInscricao.setCadastroFinalizado(cadastroFinalizado);
	}

	/**
	* Returns the forma pagamento of this curso inscricao.
	*
	* @return the forma pagamento of this curso inscricao
	*/
	@Override
	public java.lang.String getFormaPagamento() {
		return _cursoInscricao.getFormaPagamento();
	}

	/**
	* Sets the forma pagamento of this curso inscricao.
	*
	* @param formaPagamento the forma pagamento of this curso inscricao
	*/
	@Override
	public void setFormaPagamento(java.lang.String formaPagamento) {
		_cursoInscricao.setFormaPagamento(formaPagamento);
	}

	/**
	* Returns the numero cartao of this curso inscricao.
	*
	* @return the numero cartao of this curso inscricao
	*/
	@Override
	public java.lang.String getNumeroCartao() {
		return _cursoInscricao.getNumeroCartao();
	}

	/**
	* Sets the numero cartao of this curso inscricao.
	*
	* @param numeroCartao the numero cartao of this curso inscricao
	*/
	@Override
	public void setNumeroCartao(java.lang.String numeroCartao) {
		_cursoInscricao.setNumeroCartao(numeroCartao);
	}

	/**
	* Returns the validade cartao mes of this curso inscricao.
	*
	* @return the validade cartao mes of this curso inscricao
	*/
	@Override
	public int getValidadeCartaoMes() {
		return _cursoInscricao.getValidadeCartaoMes();
	}

	/**
	* Sets the validade cartao mes of this curso inscricao.
	*
	* @param validadeCartaoMes the validade cartao mes of this curso inscricao
	*/
	@Override
	public void setValidadeCartaoMes(int validadeCartaoMes) {
		_cursoInscricao.setValidadeCartaoMes(validadeCartaoMes);
	}

	/**
	* Returns the validade cartao ano of this curso inscricao.
	*
	* @return the validade cartao ano of this curso inscricao
	*/
	@Override
	public int getValidadeCartaoAno() {
		return _cursoInscricao.getValidadeCartaoAno();
	}

	/**
	* Sets the validade cartao ano of this curso inscricao.
	*
	* @param validadeCartaoAno the validade cartao ano of this curso inscricao
	*/
	@Override
	public void setValidadeCartaoAno(int validadeCartaoAno) {
		_cursoInscricao.setValidadeCartaoAno(validadeCartaoAno);
	}

	/**
	* Returns the nome titular cartao of this curso inscricao.
	*
	* @return the nome titular cartao of this curso inscricao
	*/
	@Override
	public java.lang.String getNomeTitularCartao() {
		return _cursoInscricao.getNomeTitularCartao();
	}

	/**
	* Sets the nome titular cartao of this curso inscricao.
	*
	* @param nomeTitularCartao the nome titular cartao of this curso inscricao
	*/
	@Override
	public void setNomeTitularCartao(java.lang.String nomeTitularCartao) {
		_cursoInscricao.setNomeTitularCartao(nomeTitularCartao);
	}

	/**
	* Returns the codigo seguranca cartao of this curso inscricao.
	*
	* @return the codigo seguranca cartao of this curso inscricao
	*/
	@Override
	public java.lang.String getCodigoSegurancaCartao() {
		return _cursoInscricao.getCodigoSegurancaCartao();
	}

	/**
	* Sets the codigo seguranca cartao of this curso inscricao.
	*
	* @param codigoSegurancaCartao the codigo seguranca cartao of this curso inscricao
	*/
	@Override
	public void setCodigoSegurancaCartao(java.lang.String codigoSegurancaCartao) {
		_cursoInscricao.setCodigoSegurancaCartao(codigoSegurancaCartao);
	}

	/**
	* Returns the status moeda digital of this curso inscricao.
	*
	* @return the status moeda digital of this curso inscricao
	*/
	@Override
	public java.lang.String getStatusMoedaDigital() {
		return _cursoInscricao.getStatusMoedaDigital();
	}

	/**
	* Sets the status moeda digital of this curso inscricao.
	*
	* @param statusMoedaDigital the status moeda digital of this curso inscricao
	*/
	@Override
	public void setStatusMoedaDigital(java.lang.String statusMoedaDigital) {
		_cursoInscricao.setStatusMoedaDigital(statusMoedaDigital);
	}

	/**
	* Returns the quantidade parcelas of this curso inscricao.
	*
	* @return the quantidade parcelas of this curso inscricao
	*/
	@Override
	public int getQuantidadeParcelas() {
		return _cursoInscricao.getQuantidadeParcelas();
	}

	/**
	* Sets the quantidade parcelas of this curso inscricao.
	*
	* @param quantidadeParcelas the quantidade parcelas of this curso inscricao
	*/
	@Override
	public void setQuantidadeParcelas(int quantidadeParcelas) {
		_cursoInscricao.setQuantidadeParcelas(quantidadeParcelas);
	}

	/**
	* Returns the valor total of this curso inscricao.
	*
	* @return the valor total of this curso inscricao
	*/
	@Override
	public double getValorTotal() {
		return _cursoInscricao.getValorTotal();
	}

	/**
	* Sets the valor total of this curso inscricao.
	*
	* @param valorTotal the valor total of this curso inscricao
	*/
	@Override
	public void setValorTotal(double valorTotal) {
		_cursoInscricao.setValorTotal(valorTotal);
	}

	/**
	* Returns the moeda digital pedido of this curso inscricao.
	*
	* @return the moeda digital pedido of this curso inscricao
	*/
	@Override
	public java.lang.String getMoedaDigitalPedido() {
		return _cursoInscricao.getMoedaDigitalPedido();
	}

	/**
	* Sets the moeda digital pedido of this curso inscricao.
	*
	* @param moedaDigitalPedido the moeda digital pedido of this curso inscricao
	*/
	@Override
	public void setMoedaDigitalPedido(java.lang.String moedaDigitalPedido) {
		_cursoInscricao.setMoedaDigitalPedido(moedaDigitalPedido);
	}

	/**
	* Returns the data inicio of this curso inscricao.
	*
	* @return the data inicio of this curso inscricao
	*/
	@Override
	public java.util.Date getDataInicio() {
		return _cursoInscricao.getDataInicio();
	}

	/**
	* Sets the data inicio of this curso inscricao.
	*
	* @param dataInicio the data inicio of this curso inscricao
	*/
	@Override
	public void setDataInicio(java.util.Date dataInicio) {
		_cursoInscricao.setDataInicio(dataInicio);
	}

	@Override
	public boolean isNew() {
		return _cursoInscricao.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_cursoInscricao.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _cursoInscricao.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cursoInscricao.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _cursoInscricao.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _cursoInscricao.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cursoInscricao.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cursoInscricao.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_cursoInscricao.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_cursoInscricao.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cursoInscricao.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CursoInscricaoWrapper((CursoInscricao)_cursoInscricao.clone());
	}

	@Override
	public int compareTo(
		br.com.cnf.curso.inscricao.model.CursoInscricao cursoInscricao) {
		return _cursoInscricao.compareTo(cursoInscricao);
	}

	@Override
	public int hashCode() {
		return _cursoInscricao.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.cnf.curso.inscricao.model.CursoInscricao> toCacheModel() {
		return _cursoInscricao.toCacheModel();
	}

	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricao toEscapedModel() {
		return new CursoInscricaoWrapper(_cursoInscricao.toEscapedModel());
	}

	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricao toUnescapedModel() {
		return new CursoInscricaoWrapper(_cursoInscricao.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cursoInscricao.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _cursoInscricao.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cursoInscricao.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CursoInscricaoWrapper)) {
			return false;
		}

		CursoInscricaoWrapper cursoInscricaoWrapper = (CursoInscricaoWrapper)obj;

		if (Validator.equals(_cursoInscricao,
					cursoInscricaoWrapper._cursoInscricao)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CursoInscricao getWrappedCursoInscricao() {
		return _cursoInscricao;
	}

	@Override
	public CursoInscricao getWrappedModel() {
		return _cursoInscricao;
	}

	@Override
	public void resetOriginalValues() {
		_cursoInscricao.resetOriginalValues();
	}

	private CursoInscricao _cursoInscricao;
}