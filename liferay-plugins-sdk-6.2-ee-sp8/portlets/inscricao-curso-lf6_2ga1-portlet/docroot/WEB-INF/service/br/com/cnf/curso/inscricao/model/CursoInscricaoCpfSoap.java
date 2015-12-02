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
public class CursoInscricaoCpfSoap implements Serializable {
	public static CursoInscricaoCpfSoap toSoapModel(CursoInscricaoCpf model) {
		CursoInscricaoCpfSoap soapModel = new CursoInscricaoCpfSoap();

		soapModel.setInscricaoCpfId(model.getInscricaoCpfId());
		soapModel.setInscricaoId(model.getInscricaoId());
		soapModel.setNome(model.getNome());
		soapModel.setCpf(model.getCpf());
		soapModel.setEndereco(model.getEndereco());
		soapModel.setBairro(model.getBairro());
		soapModel.setCidade(model.getCidade());
		soapModel.setEstado(model.getEstado());
		soapModel.setCep(model.getCep());
		soapModel.setDddTelefone(model.getDddTelefone());
		soapModel.setTelefone(model.getTelefone());
		soapModel.setEmail(model.getEmail());
		soapModel.setEmpresa(model.getEmpresa());
		soapModel.setCargo(model.getCargo());
		soapModel.setDepartamento(model.getDepartamento());
		soapModel.setObservacao(model.getObservacao());

		return soapModel;
	}

	public static CursoInscricaoCpfSoap[] toSoapModels(
		CursoInscricaoCpf[] models) {
		CursoInscricaoCpfSoap[] soapModels = new CursoInscricaoCpfSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CursoInscricaoCpfSoap[][] toSoapModels(
		CursoInscricaoCpf[][] models) {
		CursoInscricaoCpfSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CursoInscricaoCpfSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CursoInscricaoCpfSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CursoInscricaoCpfSoap[] toSoapModels(
		List<CursoInscricaoCpf> models) {
		List<CursoInscricaoCpfSoap> soapModels = new ArrayList<CursoInscricaoCpfSoap>(models.size());

		for (CursoInscricaoCpf model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CursoInscricaoCpfSoap[soapModels.size()]);
	}

	public CursoInscricaoCpfSoap() {
	}

	public long getPrimaryKey() {
		return _inscricaoCpfId;
	}

	public void setPrimaryKey(long pk) {
		setInscricaoCpfId(pk);
	}

	public long getInscricaoCpfId() {
		return _inscricaoCpfId;
	}

	public void setInscricaoCpfId(long inscricaoCpfId) {
		_inscricaoCpfId = inscricaoCpfId;
	}

	public long getInscricaoId() {
		return _inscricaoId;
	}

	public void setInscricaoId(long inscricaoId) {
		_inscricaoId = inscricaoId;
	}

	public String getNome() {
		return _nome;
	}

	public void setNome(String nome) {
		_nome = nome;
	}

	public String getCpf() {
		return _cpf;
	}

	public void setCpf(String cpf) {
		_cpf = cpf;
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

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getEmpresa() {
		return _empresa;
	}

	public void setEmpresa(String empresa) {
		_empresa = empresa;
	}

	public String getCargo() {
		return _cargo;
	}

	public void setCargo(String cargo) {
		_cargo = cargo;
	}

	public String getDepartamento() {
		return _departamento;
	}

	public void setDepartamento(String departamento) {
		_departamento = departamento;
	}

	public String getObservacao() {
		return _observacao;
	}

	public void setObservacao(String observacao) {
		_observacao = observacao;
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
}