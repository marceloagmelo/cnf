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

import br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CursoInscricaoCnpj in entity cache.
 *
 * @author SEA
 * @see CursoInscricaoCnpj
 * @generated
 */
public class CursoInscricaoCnpjCacheModel implements CacheModel<CursoInscricaoCnpj>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{inscricaoCnpjId=");
		sb.append(inscricaoCnpjId);
		sb.append(", inscricaoId=");
		sb.append(inscricaoId);
		sb.append(", razaoSocial=");
		sb.append(razaoSocial);
		sb.append(", nomeFantasia=");
		sb.append(nomeFantasia);
		sb.append(", inscricaoEstadual=");
		sb.append(inscricaoEstadual);
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
		sb.append(", nfNome=");
		sb.append(nfNome);
		sb.append(", nfDepartamento=");
		sb.append(nfDepartamento);
		sb.append(", nfEmail=");
		sb.append(nfEmail);
		sb.append(", nfDddTelefone=");
		sb.append(nfDddTelefone);
		sb.append(", nfTelefone=");
		sb.append(nfTelefone);
		sb.append(", observacao=");
		sb.append(observacao);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CursoInscricaoCnpj toEntityModel() {
		CursoInscricaoCnpjImpl cursoInscricaoCnpjImpl = new CursoInscricaoCnpjImpl();

		cursoInscricaoCnpjImpl.setInscricaoCnpjId(inscricaoCnpjId);
		cursoInscricaoCnpjImpl.setInscricaoId(inscricaoId);

		if (razaoSocial == null) {
			cursoInscricaoCnpjImpl.setRazaoSocial(StringPool.BLANK);
		}
		else {
			cursoInscricaoCnpjImpl.setRazaoSocial(razaoSocial);
		}

		if (nomeFantasia == null) {
			cursoInscricaoCnpjImpl.setNomeFantasia(StringPool.BLANK);
		}
		else {
			cursoInscricaoCnpjImpl.setNomeFantasia(nomeFantasia);
		}

		if (inscricaoEstadual == null) {
			cursoInscricaoCnpjImpl.setInscricaoEstadual(StringPool.BLANK);
		}
		else {
			cursoInscricaoCnpjImpl.setInscricaoEstadual(inscricaoEstadual);
		}

		if (endereco == null) {
			cursoInscricaoCnpjImpl.setEndereco(StringPool.BLANK);
		}
		else {
			cursoInscricaoCnpjImpl.setEndereco(endereco);
		}

		if (bairro == null) {
			cursoInscricaoCnpjImpl.setBairro(StringPool.BLANK);
		}
		else {
			cursoInscricaoCnpjImpl.setBairro(bairro);
		}

		if (cidade == null) {
			cursoInscricaoCnpjImpl.setCidade(StringPool.BLANK);
		}
		else {
			cursoInscricaoCnpjImpl.setCidade(cidade);
		}

		if (estado == null) {
			cursoInscricaoCnpjImpl.setEstado(StringPool.BLANK);
		}
		else {
			cursoInscricaoCnpjImpl.setEstado(estado);
		}

		if (cep == null) {
			cursoInscricaoCnpjImpl.setCep(StringPool.BLANK);
		}
		else {
			cursoInscricaoCnpjImpl.setCep(cep);
		}

		if (dddTelefone == null) {
			cursoInscricaoCnpjImpl.setDddTelefone(StringPool.BLANK);
		}
		else {
			cursoInscricaoCnpjImpl.setDddTelefone(dddTelefone);
		}

		if (telefone == null) {
			cursoInscricaoCnpjImpl.setTelefone(StringPool.BLANK);
		}
		else {
			cursoInscricaoCnpjImpl.setTelefone(telefone);
		}

		if (nfNome == null) {
			cursoInscricaoCnpjImpl.setNfNome(StringPool.BLANK);
		}
		else {
			cursoInscricaoCnpjImpl.setNfNome(nfNome);
		}

		if (nfDepartamento == null) {
			cursoInscricaoCnpjImpl.setNfDepartamento(StringPool.BLANK);
		}
		else {
			cursoInscricaoCnpjImpl.setNfDepartamento(nfDepartamento);
		}

		if (nfEmail == null) {
			cursoInscricaoCnpjImpl.setNfEmail(StringPool.BLANK);
		}
		else {
			cursoInscricaoCnpjImpl.setNfEmail(nfEmail);
		}

		if (nfDddTelefone == null) {
			cursoInscricaoCnpjImpl.setNfDddTelefone(StringPool.BLANK);
		}
		else {
			cursoInscricaoCnpjImpl.setNfDddTelefone(nfDddTelefone);
		}

		if (nfTelefone == null) {
			cursoInscricaoCnpjImpl.setNfTelefone(StringPool.BLANK);
		}
		else {
			cursoInscricaoCnpjImpl.setNfTelefone(nfTelefone);
		}

		if (observacao == null) {
			cursoInscricaoCnpjImpl.setObservacao(StringPool.BLANK);
		}
		else {
			cursoInscricaoCnpjImpl.setObservacao(observacao);
		}

		cursoInscricaoCnpjImpl.resetOriginalValues();

		return cursoInscricaoCnpjImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		inscricaoCnpjId = objectInput.readLong();
		inscricaoId = objectInput.readLong();
		razaoSocial = objectInput.readUTF();
		nomeFantasia = objectInput.readUTF();
		inscricaoEstadual = objectInput.readUTF();
		endereco = objectInput.readUTF();
		bairro = objectInput.readUTF();
		cidade = objectInput.readUTF();
		estado = objectInput.readUTF();
		cep = objectInput.readUTF();
		dddTelefone = objectInput.readUTF();
		telefone = objectInput.readUTF();
		nfNome = objectInput.readUTF();
		nfDepartamento = objectInput.readUTF();
		nfEmail = objectInput.readUTF();
		nfDddTelefone = objectInput.readUTF();
		nfTelefone = objectInput.readUTF();
		observacao = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(inscricaoCnpjId);
		objectOutput.writeLong(inscricaoId);

		if (razaoSocial == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(razaoSocial);
		}

		if (nomeFantasia == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nomeFantasia);
		}

		if (inscricaoEstadual == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(inscricaoEstadual);
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

		if (nfNome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nfNome);
		}

		if (nfDepartamento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nfDepartamento);
		}

		if (nfEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nfEmail);
		}

		if (nfDddTelefone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nfDddTelefone);
		}

		if (nfTelefone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nfTelefone);
		}

		if (observacao == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(observacao);
		}
	}

	public long inscricaoCnpjId;
	public long inscricaoId;
	public String razaoSocial;
	public String nomeFantasia;
	public String inscricaoEstadual;
	public String endereco;
	public String bairro;
	public String cidade;
	public String estado;
	public String cep;
	public String dddTelefone;
	public String telefone;
	public String nfNome;
	public String nfDepartamento;
	public String nfEmail;
	public String nfDddTelefone;
	public String nfTelefone;
	public String observacao;
}