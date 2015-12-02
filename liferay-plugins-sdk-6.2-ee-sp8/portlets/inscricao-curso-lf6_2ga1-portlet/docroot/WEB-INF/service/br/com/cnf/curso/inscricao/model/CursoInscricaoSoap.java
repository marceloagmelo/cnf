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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author SEA
 * @generated
 */
public class CursoInscricaoSoap implements Serializable {
	public static CursoInscricaoSoap toSoapModel(CursoInscricao model) {
		CursoInscricaoSoap soapModel = new CursoInscricaoSoap();

		soapModel.setInscricaoId(model.getInscricaoId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserCreateId(model.getUserCreateId());
		soapModel.setUserCreateName(model.getUserCreateName());
		soapModel.setUserModifiedId(model.getUserModifiedId());
		soapModel.setUserModifiedName(model.getUserModifiedName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCursoId(model.getCursoId());
		soapModel.setCursoNome(model.getCursoNome());
		soapModel.setCursoData(model.getCursoData());
		soapModel.setCursoHorario(model.getCursoHorario());
		soapModel.setCursoLocal(model.getCursoLocal());
		soapModel.setPreco(model.getPreco());
		soapModel.setPrecoConvenio(model.getPrecoConvenio());
		soapModel.setPrecoAssociado(model.getPrecoAssociado());
		soapModel.setTipoFisicaJuridica(model.getTipoFisicaJuridica());
		soapModel.setCpfCnpj(model.getCpfCnpj());
		soapModel.setNomeResponsavel(model.getNomeResponsavel());
		soapModel.setEmailPrincipal(model.getEmailPrincipal());
		soapModel.setDddTelefoneComercial(model.getDddTelefoneComercial());
		soapModel.setTelefoneComercial(model.getTelefoneComercial());
		soapModel.setSexo(model.getSexo());
		soapModel.setCadastroFinalizado(model.getCadastroFinalizado());
		soapModel.setFormaPagamento(model.getFormaPagamento());
		soapModel.setNumeroCartao(model.getNumeroCartao());
		soapModel.setValidadeCartaoMes(model.getValidadeCartaoMes());
		soapModel.setValidadeCartaoAno(model.getValidadeCartaoAno());
		soapModel.setNomeTitularCartao(model.getNomeTitularCartao());
		soapModel.setCodigoSegurancaCartao(model.getCodigoSegurancaCartao());
		soapModel.setStatusMoedaDigital(model.getStatusMoedaDigital());
		soapModel.setQuantidadeParcelas(model.getQuantidadeParcelas());
		soapModel.setValorTotal(model.getValorTotal());
		soapModel.setMoedaDigitalPedido(model.getMoedaDigitalPedido());
		soapModel.setDataInicio(model.getDataInicio());

		return soapModel;
	}

	public static CursoInscricaoSoap[] toSoapModels(CursoInscricao[] models) {
		CursoInscricaoSoap[] soapModels = new CursoInscricaoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CursoInscricaoSoap[][] toSoapModels(CursoInscricao[][] models) {
		CursoInscricaoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CursoInscricaoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CursoInscricaoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CursoInscricaoSoap[] toSoapModels(List<CursoInscricao> models) {
		List<CursoInscricaoSoap> soapModels = new ArrayList<CursoInscricaoSoap>(models.size());

		for (CursoInscricao model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CursoInscricaoSoap[soapModels.size()]);
	}

	public CursoInscricaoSoap() {
	}

	public long getPrimaryKey() {
		return _inscricaoId;
	}

	public void setPrimaryKey(long pk) {
		setInscricaoId(pk);
	}

	public long getInscricaoId() {
		return _inscricaoId;
	}

	public void setInscricaoId(long inscricaoId) {
		_inscricaoId = inscricaoId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserCreateId() {
		return _userCreateId;
	}

	public void setUserCreateId(long userCreateId) {
		_userCreateId = userCreateId;
	}

	public String getUserCreateName() {
		return _userCreateName;
	}

	public void setUserCreateName(String userCreateName) {
		_userCreateName = userCreateName;
	}

	public long getUserModifiedId() {
		return _userModifiedId;
	}

	public void setUserModifiedId(long userModifiedId) {
		_userModifiedId = userModifiedId;
	}

	public String getUserModifiedName() {
		return _userModifiedName;
	}

	public void setUserModifiedName(String userModifiedName) {
		_userModifiedName = userModifiedName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCursoId() {
		return _cursoId;
	}

	public void setCursoId(long cursoId) {
		_cursoId = cursoId;
	}

	public String getCursoNome() {
		return _cursoNome;
	}

	public void setCursoNome(String cursoNome) {
		_cursoNome = cursoNome;
	}

	public String getCursoData() {
		return _cursoData;
	}

	public void setCursoData(String cursoData) {
		_cursoData = cursoData;
	}

	public String getCursoHorario() {
		return _cursoHorario;
	}

	public void setCursoHorario(String cursoHorario) {
		_cursoHorario = cursoHorario;
	}

	public String getCursoLocal() {
		return _cursoLocal;
	}

	public void setCursoLocal(String cursoLocal) {
		_cursoLocal = cursoLocal;
	}

	public String getPreco() {
		return _preco;
	}

	public void setPreco(String preco) {
		_preco = preco;
	}

	public String getPrecoConvenio() {
		return _precoConvenio;
	}

	public void setPrecoConvenio(String precoConvenio) {
		_precoConvenio = precoConvenio;
	}

	public String getPrecoAssociado() {
		return _precoAssociado;
	}

	public void setPrecoAssociado(String precoAssociado) {
		_precoAssociado = precoAssociado;
	}

	public String getTipoFisicaJuridica() {
		return _tipoFisicaJuridica;
	}

	public void setTipoFisicaJuridica(String tipoFisicaJuridica) {
		_tipoFisicaJuridica = tipoFisicaJuridica;
	}

	public String getCpfCnpj() {
		return _cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		_cpfCnpj = cpfCnpj;
	}

	public String getNomeResponsavel() {
		return _nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		_nomeResponsavel = nomeResponsavel;
	}

	public String getEmailPrincipal() {
		return _emailPrincipal;
	}

	public void setEmailPrincipal(String emailPrincipal) {
		_emailPrincipal = emailPrincipal;
	}

	public String getDddTelefoneComercial() {
		return _dddTelefoneComercial;
	}

	public void setDddTelefoneComercial(String dddTelefoneComercial) {
		_dddTelefoneComercial = dddTelefoneComercial;
	}

	public String getTelefoneComercial() {
		return _telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		_telefoneComercial = telefoneComercial;
	}

	public String getSexo() {
		return _sexo;
	}

	public void setSexo(String sexo) {
		_sexo = sexo;
	}

	public boolean getCadastroFinalizado() {
		return _cadastroFinalizado;
	}

	public boolean isCadastroFinalizado() {
		return _cadastroFinalizado;
	}

	public void setCadastroFinalizado(boolean cadastroFinalizado) {
		_cadastroFinalizado = cadastroFinalizado;
	}

	public String getFormaPagamento() {
		return _formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		_formaPagamento = formaPagamento;
	}

	public String getNumeroCartao() {
		return _numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		_numeroCartao = numeroCartao;
	}

	public int getValidadeCartaoMes() {
		return _validadeCartaoMes;
	}

	public void setValidadeCartaoMes(int validadeCartaoMes) {
		_validadeCartaoMes = validadeCartaoMes;
	}

	public int getValidadeCartaoAno() {
		return _validadeCartaoAno;
	}

	public void setValidadeCartaoAno(int validadeCartaoAno) {
		_validadeCartaoAno = validadeCartaoAno;
	}

	public String getNomeTitularCartao() {
		return _nomeTitularCartao;
	}

	public void setNomeTitularCartao(String nomeTitularCartao) {
		_nomeTitularCartao = nomeTitularCartao;
	}

	public String getCodigoSegurancaCartao() {
		return _codigoSegurancaCartao;
	}

	public void setCodigoSegurancaCartao(String codigoSegurancaCartao) {
		_codigoSegurancaCartao = codigoSegurancaCartao;
	}

	public String getStatusMoedaDigital() {
		return _statusMoedaDigital;
	}

	public void setStatusMoedaDigital(String statusMoedaDigital) {
		_statusMoedaDigital = statusMoedaDigital;
	}

	public int getQuantidadeParcelas() {
		return _quantidadeParcelas;
	}

	public void setQuantidadeParcelas(int quantidadeParcelas) {
		_quantidadeParcelas = quantidadeParcelas;
	}

	public double getValorTotal() {
		return _valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		_valorTotal = valorTotal;
	}

	public String getMoedaDigitalPedido() {
		return _moedaDigitalPedido;
	}

	public void setMoedaDigitalPedido(String moedaDigitalPedido) {
		_moedaDigitalPedido = moedaDigitalPedido;
	}

	public Date getDataInicio() {
		return _dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		_dataInicio = dataInicio;
	}

	private long _inscricaoId;
	private long _companyId;
	private long _groupId;
	private long _userCreateId;
	private String _userCreateName;
	private long _userModifiedId;
	private String _userModifiedName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _cursoId;
	private String _cursoNome;
	private String _cursoData;
	private String _cursoHorario;
	private String _cursoLocal;
	private String _preco;
	private String _precoConvenio;
	private String _precoAssociado;
	private String _tipoFisicaJuridica;
	private String _cpfCnpj;
	private String _nomeResponsavel;
	private String _emailPrincipal;
	private String _dddTelefoneComercial;
	private String _telefoneComercial;
	private String _sexo;
	private boolean _cadastroFinalizado;
	private String _formaPagamento;
	private String _numeroCartao;
	private int _validadeCartaoMes;
	private int _validadeCartaoAno;
	private String _nomeTitularCartao;
	private String _codigoSegurancaCartao;
	private String _statusMoedaDigital;
	private int _quantidadeParcelas;
	private double _valorTotal;
	private String _moedaDigitalPedido;
	private Date _dataInicio;
}