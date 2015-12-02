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

package br.com.cnf.curso.inscricao.model.impl;

import br.com.cnf.curso.inscricao.model.CursoParticipante;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CursoParticipante in entity cache.
 *
 * @author SEA
 * @see CursoParticipante
 * @generated
 */
public class CursoParticipanteCacheModel implements CacheModel<CursoParticipante>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{participanteId=");
		sb.append(participanteId);
		sb.append(", inscricaoId=");
		sb.append(inscricaoId);
		sb.append(", nomeCompleto=");
		sb.append(nomeCompleto);
		sb.append(", nomeCracha=");
		sb.append(nomeCracha);
		sb.append(", cpf=");
		sb.append(cpf);
		sb.append(", sexo=");
		sb.append(sexo);
		sb.append(", cargo=");
		sb.append(cargo);
		sb.append(", empresaOndeTrabalha=");
		sb.append(empresaOndeTrabalha);
		sb.append(", departamento=");
		sb.append(departamento);
		sb.append(", formacaoAcademica=");
		sb.append(formacaoAcademica);
		sb.append(", emailPrincipal=");
		sb.append(emailPrincipal);
		sb.append(", emailOpcional=");
		sb.append(emailOpcional);
		sb.append(", dddTelefoneComercial=");
		sb.append(dddTelefoneComercial);
		sb.append(", telefoneComercial=");
		sb.append(telefoneComercial);
		sb.append(", dddTelefonePessoal=");
		sb.append(dddTelefonePessoal);
		sb.append(", telefonePessoal=");
		sb.append(telefonePessoal);
		sb.append(", dddTelefoneCelular=");
		sb.append(dddTelefoneCelular);
		sb.append(", telefoneCelular=");
		sb.append(telefoneCelular);
		sb.append(", endereco=");
		sb.append(endereco);
		sb.append(", bairro=");
		sb.append(bairro);
		sb.append(", cidade=");
		sb.append(cidade);
		sb.append(", estado=");
		sb.append(estado);
		sb.append(", cep=");
		sb.append(cep);
		sb.append(", valorPago=");
		sb.append(valorPago);
		sb.append(", expectativaCurso=");
		sb.append(expectativaCurso);
		sb.append(", observacao=");
		sb.append(observacao);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CursoParticipante toEntityModel() {
		CursoParticipanteImpl cursoParticipanteImpl = new CursoParticipanteImpl();

		cursoParticipanteImpl.setParticipanteId(participanteId);
		cursoParticipanteImpl.setInscricaoId(inscricaoId);

		if (nomeCompleto == null) {
			cursoParticipanteImpl.setNomeCompleto(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setNomeCompleto(nomeCompleto);
		}

		if (nomeCracha == null) {
			cursoParticipanteImpl.setNomeCracha(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setNomeCracha(nomeCracha);
		}

		if (cpf == null) {
			cursoParticipanteImpl.setCpf(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setCpf(cpf);
		}

		if (sexo == null) {
			cursoParticipanteImpl.setSexo(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setSexo(sexo);
		}

		if (cargo == null) {
			cursoParticipanteImpl.setCargo(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setCargo(cargo);
		}

		if (empresaOndeTrabalha == null) {
			cursoParticipanteImpl.setEmpresaOndeTrabalha(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setEmpresaOndeTrabalha(empresaOndeTrabalha);
		}

		if (departamento == null) {
			cursoParticipanteImpl.setDepartamento(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setDepartamento(departamento);
		}

		if (formacaoAcademica == null) {
			cursoParticipanteImpl.setFormacaoAcademica(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setFormacaoAcademica(formacaoAcademica);
		}

		if (emailPrincipal == null) {
			cursoParticipanteImpl.setEmailPrincipal(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setEmailPrincipal(emailPrincipal);
		}

		if (emailOpcional == null) {
			cursoParticipanteImpl.setEmailOpcional(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setEmailOpcional(emailOpcional);
		}

		if (dddTelefoneComercial == null) {
			cursoParticipanteImpl.setDddTelefoneComercial(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setDddTelefoneComercial(dddTelefoneComercial);
		}

		if (telefoneComercial == null) {
			cursoParticipanteImpl.setTelefoneComercial(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setTelefoneComercial(telefoneComercial);
		}

		if (dddTelefonePessoal == null) {
			cursoParticipanteImpl.setDddTelefonePessoal(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setDddTelefonePessoal(dddTelefonePessoal);
		}

		if (telefonePessoal == null) {
			cursoParticipanteImpl.setTelefonePessoal(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setTelefonePessoal(telefonePessoal);
		}

		if (dddTelefoneCelular == null) {
			cursoParticipanteImpl.setDddTelefoneCelular(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setDddTelefoneCelular(dddTelefoneCelular);
		}

		if (telefoneCelular == null) {
			cursoParticipanteImpl.setTelefoneCelular(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setTelefoneCelular(telefoneCelular);
		}

		if (endereco == null) {
			cursoParticipanteImpl.setEndereco(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setEndereco(endereco);
		}

		if (bairro == null) {
			cursoParticipanteImpl.setBairro(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setBairro(bairro);
		}

		if (cidade == null) {
			cursoParticipanteImpl.setCidade(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setCidade(cidade);
		}

		if (estado == null) {
			cursoParticipanteImpl.setEstado(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setEstado(estado);
		}

		if (cep == null) {
			cursoParticipanteImpl.setCep(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setCep(cep);
		}

		if (valorPago == null) {
			cursoParticipanteImpl.setValorPago(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setValorPago(valorPago);
		}

		if (expectativaCurso == null) {
			cursoParticipanteImpl.setExpectativaCurso(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setExpectativaCurso(expectativaCurso);
		}

		if (observacao == null) {
			cursoParticipanteImpl.setObservacao(StringPool.BLANK);
		}
		else {
			cursoParticipanteImpl.setObservacao(observacao);
		}

		cursoParticipanteImpl.resetOriginalValues();

		return cursoParticipanteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		participanteId = objectInput.readLong();
		inscricaoId = objectInput.readLong();
		nomeCompleto = objectInput.readUTF();
		nomeCracha = objectInput.readUTF();
		cpf = objectInput.readUTF();
		sexo = objectInput.readUTF();
		cargo = objectInput.readUTF();
		empresaOndeTrabalha = objectInput.readUTF();
		departamento = objectInput.readUTF();
		formacaoAcademica = objectInput.readUTF();
		emailPrincipal = objectInput.readUTF();
		emailOpcional = objectInput.readUTF();
		dddTelefoneComercial = objectInput.readUTF();
		telefoneComercial = objectInput.readUTF();
		dddTelefonePessoal = objectInput.readUTF();
		telefonePessoal = objectInput.readUTF();
		dddTelefoneCelular = objectInput.readUTF();
		telefoneCelular = objectInput.readUTF();
		endereco = objectInput.readUTF();
		bairro = objectInput.readUTF();
		cidade = objectInput.readUTF();
		estado = objectInput.readUTF();
		cep = objectInput.readUTF();
		valorPago = objectInput.readUTF();
		expectativaCurso = objectInput.readUTF();
		observacao = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(participanteId);
		objectOutput.writeLong(inscricaoId);

		if (nomeCompleto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nomeCompleto);
		}

		if (nomeCracha == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nomeCracha);
		}

		if (cpf == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cpf);
		}

		if (sexo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sexo);
		}

		if (cargo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cargo);
		}

		if (empresaOndeTrabalha == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(empresaOndeTrabalha);
		}

		if (departamento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(departamento);
		}

		if (formacaoAcademica == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(formacaoAcademica);
		}

		if (emailPrincipal == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailPrincipal);
		}

		if (emailOpcional == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailOpcional);
		}

		if (dddTelefoneComercial == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dddTelefoneComercial);
		}

		if (telefoneComercial == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telefoneComercial);
		}

		if (dddTelefonePessoal == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dddTelefonePessoal);
		}

		if (telefonePessoal == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telefonePessoal);
		}

		if (dddTelefoneCelular == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dddTelefoneCelular);
		}

		if (telefoneCelular == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telefoneCelular);
		}

		if (endereco == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endereco);
		}

		if (bairro == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bairro);
		}

		if (cidade == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cidade);
		}

		if (estado == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(estado);
		}

		if (cep == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cep);
		}

		if (valorPago == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(valorPago);
		}

		if (expectativaCurso == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(expectativaCurso);
		}

		if (observacao == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(observacao);
		}
	}

	public long participanteId;
	public long inscricaoId;
	public String nomeCompleto;
	public String nomeCracha;
	public String cpf;
	public String sexo;
	public String cargo;
	public String empresaOndeTrabalha;
	public String departamento;
	public String formacaoAcademica;
	public String emailPrincipal;
	public String emailOpcional;
	public String dddTelefoneComercial;
	public String telefoneComercial;
	public String dddTelefonePessoal;
	public String telefonePessoal;
	public String dddTelefoneCelular;
	public String telefoneCelular;
	public String endereco;
	public String bairro;
	public String cidade;
	public String estado;
	public String cep;
	public String valorPago;
	public String expectativaCurso;
	public String observacao;
}