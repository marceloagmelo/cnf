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

import br.com.cnf.curso.inscricao.model.CursoInscricaoCpf;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CursoInscricaoCpf in entity cache.
 *
 * @author SEA
 * @see CursoInscricaoCpf
 * @generated
 */
public class CursoInscricaoCpfCacheModel implements CacheModel<CursoInscricaoCpf>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{inscricaoCpfId=");
		sb.append(inscricaoCpfId);
		sb.append(", inscricaoId=");
		sb.append(inscricaoId);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", cpf=");
		sb.append(cpf);
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
		sb.append(", dddTelefone=");
		sb.append(dddTelefone);
		sb.append(", telefone=");
		sb.append(telefone);
		sb.append(", email=");
		sb.append(email);
		sb.append(", empresa=");
		sb.append(empresa);
		sb.append(", cargo=");
		sb.append(cargo);
		sb.append(", departamento=");
		sb.append(departamento);
		sb.append(", observacao=");
		sb.append(observacao);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CursoInscricaoCpf toEntityModel() {
		CursoInscricaoCpfImpl cursoInscricaoCpfImpl = new CursoInscricaoCpfImpl();

		cursoInscricaoCpfImpl.setInscricaoCpfId(inscricaoCpfId);
		cursoInscricaoCpfImpl.setInscricaoId(inscricaoId);

		if (nome == null) {
			cursoInscricaoCpfImpl.setNome(StringPool.BLANK);
		}
		else {
			cursoInscricaoCpfImpl.setNome(nome);
		}

		if (cpf == null) {
			cursoInscricaoCpfImpl.setCpf(StringPool.BLANK);
		}
		else {
			cursoInscricaoCpfImpl.setCpf(cpf);
		}

		if (endereco == null) {
			cursoInscricaoCpfImpl.setEndereco(StringPool.BLANK);
		}
		else {
			cursoInscricaoCpfImpl.setEndereco(endereco);
		}

		if (bairro == null) {
			cursoInscricaoCpfImpl.setBairro(StringPool.BLANK);
		}
		else {
			cursoInscricaoCpfImpl.setBairro(bairro);
		}

		if (cidade == null) {
			cursoInscricaoCpfImpl.setCidade(StringPool.BLANK);
		}
		else {
			cursoInscricaoCpfImpl.setCidade(cidade);
		}

		if (estado == null) {
			cursoInscricaoCpfImpl.setEstado(StringPool.BLANK);
		}
		else {
			cursoInscricaoCpfImpl.setEstado(estado);
		}

		if (cep == null) {
			cursoInscricaoCpfImpl.setCep(StringPool.BLANK);
		}
		else {
			cursoInscricaoCpfImpl.setCep(cep);
		}

		if (dddTelefone == null) {
			cursoInscricaoCpfImpl.setDddTelefone(StringPool.BLANK);
		}
		else {
			cursoInscricaoCpfImpl.setDddTelefone(dddTelefone);
		}

		if (telefone == null) {
			cursoInscricaoCpfImpl.setTelefone(StringPool.BLANK);
		}
		else {
			cursoInscricaoCpfImpl.setTelefone(telefone);
		}

		if (email == null) {
			cursoInscricaoCpfImpl.setEmail(StringPool.BLANK);
		}
		else {
			cursoInscricaoCpfImpl.setEmail(email);
		}

		if (empresa == null) {
			cursoInscricaoCpfImpl.setEmpresa(StringPool.BLANK);
		}
		else {
			cursoInscricaoCpfImpl.setEmpresa(empresa);
		}

		if (cargo == null) {
			cursoInscricaoCpfImpl.setCargo(StringPool.BLANK);
		}
		else {
			cursoInscricaoCpfImpl.setCargo(cargo);
		}

		if (departamento == null) {
			cursoInscricaoCpfImpl.setDepartamento(StringPool.BLANK);
		}
		else {
			cursoInscricaoCpfImpl.setDepartamento(departamento);
		}

		if (observacao == null) {
			cursoInscricaoCpfImpl.setObservacao(StringPool.BLANK);
		}
		else {
			cursoInscricaoCpfImpl.setObservacao(observacao);
		}

		cursoInscricaoCpfImpl.resetOriginalValues();

		return cursoInscricaoCpfImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		inscricaoCpfId = objectInput.readLong();
		inscricaoId = objectInput.readLong();
		nome = objectInput.readUTF();
		cpf = objectInput.readUTF();
		endereco = objectInput.readUTF();
		bairro = objectInput.readUTF();
		cidade = objectInput.readUTF();
		estado = objectInput.readUTF();
		cep = objectInput.readUTF();
		dddTelefone = objectInput.readUTF();
		telefone = objectInput.readUTF();
		email = objectInput.readUTF();
		empresa = objectInput.readUTF();
		cargo = objectInput.readUTF();
		departamento = objectInput.readUTF();
		observacao = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(inscricaoCpfId);
		objectOutput.writeLong(inscricaoId);

		if (nome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nome);
		}

		if (cpf == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cpf);
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

		if (dddTelefone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dddTelefone);
		}

		if (telefone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telefone);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (empresa == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(empresa);
		}

		if (cargo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cargo);
		}

		if (departamento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(departamento);
		}

		if (observacao == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(observacao);
		}
	}

	public long inscricaoCpfId;
	public long inscricaoId;
	public String nome;
	public String cpf;
	public String endereco;
	public String bairro;
	public String cidade;
	public String estado;
	public String cep;
	public String dddTelefone;
	public String telefone;
	public String email;
	public String empresa;
	public String cargo;
	public String departamento;
	public String observacao;
}