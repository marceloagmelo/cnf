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
public class CursoParticipanteSoap implements Serializable {
	public static CursoParticipanteSoap toSoapModel(CursoParticipante model) {
		CursoParticipanteSoap soapModel = new CursoParticipanteSoap();

		soapModel.setParticipanteId(model.getParticipanteId());
		soapModel.setInscricaoId(model.getInscricaoId());
		soapModel.setNomeCompleto(model.getNomeCompleto());
		soapModel.setNomeCracha(model.getNomeCracha());
		soapModel.setCpf(model.getCpf());
		soapModel.setSexo(model.getSexo());
		soapModel.setCargo(model.getCargo());
		soapModel.setEmpresaOndeTrabalha(model.getEmpresaOndeTrabalha());
		soapModel.setDepartamento(model.getDepartamento());
		soapModel.setFormacaoAcademica(model.getFormacaoAcademica());
		soapModel.setEmailPrincipal(model.getEmailPrincipal());
		soapModel.setEmailOpcional(model.getEmailOpcional());
		soapModel.setDddTelefoneComercial(model.getDddTelefoneComercial());
		soapModel.setTelefoneComercial(model.getTelefoneComercial());
		soapModel.setDddTelefonePessoal(model.getDddTelefonePessoal());
		soapModel.setTelefonePessoal(model.getTelefonePessoal());
		soapModel.setDddTelefoneCelular(model.getDddTelefoneCelular());
		soapModel.setTelefoneCelular(model.getTelefoneCelular());
		soapModel.setEndereco(model.getEndereco());
		soapModel.setBairro(model.getBairro());
		soapModel.setCidade(model.getCidade());
		soapModel.setEstado(model.getEstado());
		soapModel.setCep(model.getCep());
		soapModel.setValorPago(model.getValorPago());
		soapModel.setExpectativaCurso(model.getExpectativaCurso());
		soapModel.setObservacao(model.getObservacao());

		return soapModel;
	}

	public static CursoParticipanteSoap[] toSoapModels(
		CursoParticipante[] models) {
		CursoParticipanteSoap[] soapModels = new CursoParticipanteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CursoParticipanteSoap[][] toSoapModels(
		CursoParticipante[][] models) {
		CursoParticipanteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CursoParticipanteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CursoParticipanteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CursoParticipanteSoap[] toSoapModels(
		List<CursoParticipante> models) {
		List<CursoParticipanteSoap> soapModels = new ArrayList<CursoParticipanteSoap>(models.size());

		for (CursoParticipante model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CursoParticipanteSoap[soapModels.size()]);
	}

	public CursoParticipanteSoap() {
	}

	public long getPrimaryKey() {
		return _participanteId;
	}

	public void setPrimaryKey(long pk) {
		setParticipanteId(pk);
	}

	public long getParticipanteId() {
		return _participanteId;
	}

	public void setParticipanteId(long participanteId) {
		_participanteId = participanteId;
	}

	public long getInscricaoId() {
		return _inscricaoId;
	}

	public void setInscricaoId(long inscricaoId) {
		_inscricaoId = inscricaoId;
	}

	public String getNomeCompleto() {
		return _nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		_nomeCompleto = nomeCompleto;
	}

	public String getNomeCracha() {
		return _nomeCracha;
	}

	public void setNomeCracha(String nomeCracha) {
		_nomeCracha = nomeCracha;
	}

	public String getCpf() {
		return _cpf;
	}

	public void setCpf(String cpf) {
		_cpf = cpf;
	}

	public String getSexo() {
		return _sexo;
	}

	public void setSexo(String sexo) {
		_sexo = sexo;
	}

	public String getCargo() {
		return _cargo;
	}

	public void setCargo(String cargo) {
		_cargo = cargo;
	}

	public String getEmpresaOndeTrabalha() {
		return _empresaOndeTrabalha;
	}

	public void setEmpresaOndeTrabalha(String empresaOndeTrabalha) {
		_empresaOndeTrabalha = empresaOndeTrabalha;
	}

	public String getDepartamento() {
		return _departamento;
	}

	public void setDepartamento(String departamento) {
		_departamento = departamento;
	}

	public String getFormacaoAcademica() {
		return _formacaoAcademica;
	}

	public void setFormacaoAcademica(String formacaoAcademica) {
		_formacaoAcademica = formacaoAcademica;
	}

	public String getEmailPrincipal() {
		return _emailPrincipal;
	}

	public void setEmailPrincipal(String emailPrincipal) {
		_emailPrincipal = emailPrincipal;
	}

	public String getEmailOpcional() {
		return _emailOpcional;
	}

	public void setEmailOpcional(String emailOpcional) {
		_emailOpcional = emailOpcional;
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

	public String getDddTelefonePessoal() {
		return _dddTelefonePessoal;
	}

	public void setDddTelefonePessoal(String dddTelefonePessoal) {
		_dddTelefonePessoal = dddTelefonePessoal;
	}

	public String getTelefonePessoal() {
		return _telefonePessoal;
	}

	public void setTelefonePessoal(String telefonePessoal) {
		_telefonePessoal = telefonePessoal;
	}

	public String getDddTelefoneCelular() {
		return _dddTelefoneCelular;
	}

	public void setDddTelefoneCelular(String dddTelefoneCelular) {
		_dddTelefoneCelular = dddTelefoneCelular;
	}

	public String getTelefoneCelular() {
		return _telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		_telefoneCelular = telefoneCelular;
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

	public String getValorPago() {
		return _valorPago;
	}

	public void setValorPago(String valorPago) {
		_valorPago = valorPago;
	}

	public String getExpectativaCurso() {
		return _expectativaCurso;
	}

	public void setExpectativaCurso(String expectativaCurso) {
		_expectativaCurso = expectativaCurso;
	}

	public String getObservacao() {
		return _observacao;
	}

	public void setObservacao(String observacao) {
		_observacao = observacao;
	}

	private long _participanteId;
	private long _inscricaoId;
	private String _nomeCompleto;
	private String _nomeCracha;
	private String _cpf;
	private String _sexo;
	private String _cargo;
	private String _empresaOndeTrabalha;
	private String _departamento;
	private String _formacaoAcademica;
	private String _emailPrincipal;
	private String _emailOpcional;
	private String _dddTelefoneComercial;
	private String _telefoneComercial;
	private String _dddTelefonePessoal;
	private String _telefonePessoal;
	private String _dddTelefoneCelular;
	private String _telefoneCelular;
	private String _endereco;
	private String _bairro;
	private String _cidade;
	private String _estado;
	private String _cep;
	private String _valorPago;
	private String _expectativaCurso;
	private String _observacao;
}