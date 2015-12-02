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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author SEA
 * @generated
 */
public class CursoInscricaoCnpjSoap implements Serializable {
	public static CursoInscricaoCnpjSoap toSoapModel(CursoInscricaoCnpj model) {
		CursoInscricaoCnpjSoap soapModel = new CursoInscricaoCnpjSoap();

		soapModel.setInscricaoCnpjId(model.getInscricaoCnpjId());
		soapModel.setInscricaoId(model.getInscricaoId());
		soapModel.setRazaoSocial(model.getRazaoSocial());
		soapModel.setNomeFantasia(model.getNomeFantasia());
		soapModel.setInscricaoEstadual(model.getInscricaoEstadual());
		soapModel.setEndereco(model.getEndereco());
		soapModel.setBairro(model.getBairro());
		soapModel.setCidade(model.getCidade());
		soapModel.setEstado(model.getEstado());
		soapModel.setCep(model.getCep());
		soapModel.setDddTelefone(model.getDddTelefone());
		soapModel.setTelefone(model.getTelefone());
		soapModel.setNfNome(model.getNfNome());
		soapModel.setNfDepartamento(model.getNfDepartamento());
		soapModel.setNfEmail(model.getNfEmail());
		soapModel.setNfDddTelefone(model.getNfDddTelefone());
		soapModel.setNfTelefone(model.getNfTelefone());
		soapModel.setObservacao(model.getObservacao());

		return soapModel;
	}

	public static CursoInscricaoCnpjSoap[] toSoapModels(
		CursoInscricaoCnpj[] models) {
		CursoInscricaoCnpjSoap[] soapModels = new CursoInscricaoCnpjSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CursoInscricaoCnpjSoap[][] toSoapModels(
		CursoInscricaoCnpj[][] models) {
		CursoInscricaoCnpjSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CursoInscricaoCnpjSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CursoInscricaoCnpjSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CursoInscricaoCnpjSoap[] toSoapModels(
		List<CursoInscricaoCnpj> models) {
		List<CursoInscricaoCnpjSoap> soapModels = new ArrayList<CursoInscricaoCnpjSoap>(models.size());

		for (CursoInscricaoCnpj model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CursoInscricaoCnpjSoap[soapModels.size()]);
	}

	public CursoInscricaoCnpjSoap() {
	}

	public long getPrimaryKey() {
		return _inscricaoCnpjId;
	}

	public void setPrimaryKey(long pk) {
		setInscricaoCnpjId(pk);
	}

	public long getInscricaoCnpjId() {
		return _inscricaoCnpjId;
	}

	public void setInscricaoCnpjId(long inscricaoCnpjId) {
		_inscricaoCnpjId = inscricaoCnpjId;
	}

	public long getInscricaoId() {
		return _inscricaoId;
	}

	public void setInscricaoId(long inscricaoId) {
		_inscricaoId = inscricaoId;
	}

	public String getRazaoSocial() {
		return _razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		_razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return _nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		_nomeFantasia = nomeFantasia;
	}

	public String getInscricaoEstadual() {
		return _inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		_inscricaoEstadual = inscricaoEstadual;
	}

	public String getEndereco() {
		return _endereco;
	}

	public void setEndereco(String endereco) {
		_endereco = endereco;
	}

	public String getBairro() {
		return _bairro;
	}

	public void setBairro(String bairro) {
		_bairro = bairro;
	}

	public String getCidade() {
		return _cidade;
	}

	public void setCidade(String cidade) {
		_cidade = cidade;
	}

	public String getEstado() {
		return _estado;
	}

	public void setEstado(String estado) {
		_estado = estado;
	}

	public String getCep() {
		return _cep;
	}

	public void setCep(String cep) {
		_cep = cep;
	}

	public String getDddTelefone() {
		return _dddTelefone;
	}

	public void setDddTelefone(String dddTelefone) {
		_dddTelefone = dddTelefone;
	}

	public String getTelefone() {
		return _telefone;
	}

	public void setTelefone(String telefone) {
		_telefone = telefone;
	}

	public String getNfNome() {
		return _nfNome;
	}

	public void setNfNome(String nfNome) {
		_nfNome = nfNome;
	}

	public String getNfDepartamento() {
		return _nfDepartamento;
	}

	public void setNfDepartamento(String nfDepartamento) {
		_nfDepartamento = nfDepartamento;
	}

	public String getNfEmail() {
		return _nfEmail;
	}

	public void setNfEmail(String nfEmail) {
		_nfEmail = nfEmail;
	}

	public String getNfDddTelefone() {
		return _nfDddTelefone;
	}

	public void setNfDddTelefone(String nfDddTelefone) {
		_nfDddTelefone = nfDddTelefone;
	}

	public String getNfTelefone() {
		return _nfTelefone;
	}

	public void setNfTelefone(String nfTelefone) {
		_nfTelefone = nfTelefone;
	}

	public String getObservacao() {
		return _observacao;
	}

	public void setObservacao(String observacao) {
		_observacao = observacao;
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
}