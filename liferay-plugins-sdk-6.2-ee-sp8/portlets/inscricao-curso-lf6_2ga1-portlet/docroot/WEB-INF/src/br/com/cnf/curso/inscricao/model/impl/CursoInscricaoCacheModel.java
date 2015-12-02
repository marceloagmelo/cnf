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

import br.com.cnf.curso.inscricao.model.CursoInscricao;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CursoInscricao in entity cache.
 *
 * @author SEA
 * @see CursoInscricao
 * @generated
 */
public class CursoInscricaoCacheModel implements CacheModel<CursoInscricao>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(73);

		sb.append("{inscricaoId=");
		sb.append(inscricaoId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userCreateId=");
		sb.append(userCreateId);
		sb.append(", userCreateName=");
		sb.append(userCreateName);
		sb.append(", userModifiedId=");
		sb.append(userModifiedId);
		sb.append(", userModifiedName=");
		sb.append(userModifiedName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", cursoId=");
		sb.append(cursoId);
		sb.append(", cursoNome=");
		sb.append(cursoNome);
		sb.append(", cursoData=");
		sb.append(cursoData);
		sb.append(", cursoHorario=");
		sb.append(cursoHorario);
		sb.append(", cursoLocal=");
		sb.append(cursoLocal);
		sb.append(", preco=");
		sb.append(preco);
		sb.append(", precoConvenio=");
		sb.append(precoConvenio);
		sb.append(", precoAssociado=");
		sb.append(precoAssociado);
		sb.append(", tipoFisicaJuridica=");
		sb.append(tipoFisicaJuridica);
		sb.append(", cpfCnpj=");
		sb.append(cpfCnpj);
		sb.append(", nomeResponsavel=");
		sb.append(nomeResponsavel);
		sb.append(", emailPrincipal=");
		sb.append(emailPrincipal);
		sb.append(", dddTelefoneComercial=");
		sb.append(dddTelefoneComercial);
		sb.append(", telefoneComercial=");
		sb.append(telefoneComercial);
		sb.append(", sexo=");
		sb.append(sexo);
		sb.append(", cadastroFinalizado=");
		sb.append(cadastroFinalizado);
		sb.append(", formaPagamento=");
		sb.append(formaPagamento);
		sb.append(", numeroCartao=");
		sb.append(numeroCartao);
		sb.append(", validadeCartaoMes=");
		sb.append(validadeCartaoMes);
		sb.append(", validadeCartaoAno=");
		sb.append(validadeCartaoAno);
		sb.append(", nomeTitularCartao=");
		sb.append(nomeTitularCartao);
		sb.append(", codigoSegurancaCartao=");
		sb.append(codigoSegurancaCartao);
		sb.append(", statusMoedaDigital=");
		sb.append(statusMoedaDigital);
		sb.append(", quantidadeParcelas=");
		sb.append(quantidadeParcelas);
		sb.append(", valorTotal=");
		sb.append(valorTotal);
		sb.append(", moedaDigitalPedido=");
		sb.append(moedaDigitalPedido);
		sb.append(", dataInicio=");
		sb.append(dataInicio);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CursoInscricao toEntityModel() {
		CursoInscricaoImpl cursoInscricaoImpl = new CursoInscricaoImpl();

		cursoInscricaoImpl.setInscricaoId(inscricaoId);
		cursoInscricaoImpl.setCompanyId(companyId);
		cursoInscricaoImpl.setGroupId(groupId);
		cursoInscricaoImpl.setUserCreateId(userCreateId);

		if (userCreateName == null) {
			cursoInscricaoImpl.setUserCreateName(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setUserCreateName(userCreateName);
		}

		cursoInscricaoImpl.setUserModifiedId(userModifiedId);

		if (userModifiedName == null) {
			cursoInscricaoImpl.setUserModifiedName(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setUserModifiedName(userModifiedName);
		}

		if (createDate == Long.MIN_VALUE) {
			cursoInscricaoImpl.setCreateDate(null);
		}
		else {
			cursoInscricaoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cursoInscricaoImpl.setModifiedDate(null);
		}
		else {
			cursoInscricaoImpl.setModifiedDate(new Date(modifiedDate));
		}

		cursoInscricaoImpl.setCursoId(cursoId);

		if (cursoNome == null) {
			cursoInscricaoImpl.setCursoNome(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setCursoNome(cursoNome);
		}

		if (cursoData == null) {
			cursoInscricaoImpl.setCursoData(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setCursoData(cursoData);
		}

		if (cursoHorario == null) {
			cursoInscricaoImpl.setCursoHorario(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setCursoHorario(cursoHorario);
		}

		if (cursoLocal == null) {
			cursoInscricaoImpl.setCursoLocal(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setCursoLocal(cursoLocal);
		}

		if (preco == null) {
			cursoInscricaoImpl.setPreco(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setPreco(preco);
		}

		if (precoConvenio == null) {
			cursoInscricaoImpl.setPrecoConvenio(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setPrecoConvenio(precoConvenio);
		}

		if (precoAssociado == null) {
			cursoInscricaoImpl.setPrecoAssociado(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setPrecoAssociado(precoAssociado);
		}

		if (tipoFisicaJuridica == null) {
			cursoInscricaoImpl.setTipoFisicaJuridica(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setTipoFisicaJuridica(tipoFisicaJuridica);
		}

		if (cpfCnpj == null) {
			cursoInscricaoImpl.setCpfCnpj(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setCpfCnpj(cpfCnpj);
		}

		if (nomeResponsavel == null) {
			cursoInscricaoImpl.setNomeResponsavel(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setNomeResponsavel(nomeResponsavel);
		}

		if (emailPrincipal == null) {
			cursoInscricaoImpl.setEmailPrincipal(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setEmailPrincipal(emailPrincipal);
		}

		if (dddTelefoneComercial == null) {
			cursoInscricaoImpl.setDddTelefoneComercial(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setDddTelefoneComercial(dddTelefoneComercial);
		}

		if (telefoneComercial == null) {
			cursoInscricaoImpl.setTelefoneComercial(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setTelefoneComercial(telefoneComercial);
		}

		if (sexo == null) {
			cursoInscricaoImpl.setSexo(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setSexo(sexo);
		}

		cursoInscricaoImpl.setCadastroFinalizado(cadastroFinalizado);

		if (formaPagamento == null) {
			cursoInscricaoImpl.setFormaPagamento(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setFormaPagamento(formaPagamento);
		}

		if (numeroCartao == null) {
			cursoInscricaoImpl.setNumeroCartao(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setNumeroCartao(numeroCartao);
		}

		cursoInscricaoImpl.setValidadeCartaoMes(validadeCartaoMes);
		cursoInscricaoImpl.setValidadeCartaoAno(validadeCartaoAno);

		if (nomeTitularCartao == null) {
			cursoInscricaoImpl.setNomeTitularCartao(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setNomeTitularCartao(nomeTitularCartao);
		}

		if (codigoSegurancaCartao == null) {
			cursoInscricaoImpl.setCodigoSegurancaCartao(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setCodigoSegurancaCartao(codigoSegurancaCartao);
		}

		if (statusMoedaDigital == null) {
			cursoInscricaoImpl.setStatusMoedaDigital(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setStatusMoedaDigital(statusMoedaDigital);
		}

		cursoInscricaoImpl.setQuantidadeParcelas(quantidadeParcelas);
		cursoInscricaoImpl.setValorTotal(valorTotal);

		if (moedaDigitalPedido == null) {
			cursoInscricaoImpl.setMoedaDigitalPedido(StringPool.BLANK);
		}
		else {
			cursoInscricaoImpl.setMoedaDigitalPedido(moedaDigitalPedido);
		}

		if (dataInicio == Long.MIN_VALUE) {
			cursoInscricaoImpl.setDataInicio(null);
		}
		else {
			cursoInscricaoImpl.setDataInicio(new Date(dataInicio));
		}

		cursoInscricaoImpl.resetOriginalValues();

		return cursoInscricaoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		inscricaoId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userCreateId = objectInput.readLong();
		userCreateName = objectInput.readUTF();
		userModifiedId = objectInput.readLong();
		userModifiedName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		cursoId = objectInput.readLong();
		cursoNome = objectInput.readUTF();
		cursoData = objectInput.readUTF();
		cursoHorario = objectInput.readUTF();
		cursoLocal = objectInput.readUTF();
		preco = objectInput.readUTF();
		precoConvenio = objectInput.readUTF();
		precoAssociado = objectInput.readUTF();
		tipoFisicaJuridica = objectInput.readUTF();
		cpfCnpj = objectInput.readUTF();
		nomeResponsavel = objectInput.readUTF();
		emailPrincipal = objectInput.readUTF();
		dddTelefoneComercial = objectInput.readUTF();
		telefoneComercial = objectInput.readUTF();
		sexo = objectInput.readUTF();
		cadastroFinalizado = objectInput.readBoolean();
		formaPagamento = objectInput.readUTF();
		numeroCartao = objectInput.readUTF();
		validadeCartaoMes = objectInput.readInt();
		validadeCartaoAno = objectInput.readInt();
		nomeTitularCartao = objectInput.readUTF();
		codigoSegurancaCartao = objectInput.readUTF();
		statusMoedaDigital = objectInput.readUTF();
		quantidadeParcelas = objectInput.readInt();
		valorTotal = objectInput.readDouble();
		moedaDigitalPedido = objectInput.readUTF();
		dataInicio = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(inscricaoId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userCreateId);

		if (userCreateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userCreateName);
		}

		objectOutput.writeLong(userModifiedId);

		if (userModifiedName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userModifiedName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(cursoId);

		if (cursoNome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cursoNome);
		}

		if (cursoData == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cursoData);
		}

		if (cursoHorario == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cursoHorario);
		}

		if (cursoLocal == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cursoLocal);
		}

		if (preco == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(preco);
		}

		if (precoConvenio == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(precoConvenio);
		}

		if (precoAssociado == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(precoAssociado);
		}

		if (tipoFisicaJuridica == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tipoFisicaJuridica);
		}

		if (cpfCnpj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cpfCnpj);
		}

		if (nomeResponsavel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nomeResponsavel);
		}

		if (emailPrincipal == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailPrincipal);
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

		if (sexo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sexo);
		}

		objectOutput.writeBoolean(cadastroFinalizado);

		if (formaPagamento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(formaPagamento);
		}

		if (numeroCartao == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(numeroCartao);
		}

		objectOutput.writeInt(validadeCartaoMes);
		objectOutput.writeInt(validadeCartaoAno);

		if (nomeTitularCartao == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nomeTitularCartao);
		}

		if (codigoSegurancaCartao == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codigoSegurancaCartao);
		}

		if (statusMoedaDigital == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusMoedaDigital);
		}

		objectOutput.writeInt(quantidadeParcelas);
		objectOutput.writeDouble(valorTotal);

		if (moedaDigitalPedido == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(moedaDigitalPedido);
		}

		objectOutput.writeLong(dataInicio);
	}

	public long inscricaoId;
	public long companyId;
	public long groupId;
	public long userCreateId;
	public String userCreateName;
	public long userModifiedId;
	public String userModifiedName;
	public long createDate;
	public long modifiedDate;
	public long cursoId;
	public String cursoNome;
	public String cursoData;
	public String cursoHorario;
	public String cursoLocal;
	public String preco;
	public String precoConvenio;
	public String precoAssociado;
	public String tipoFisicaJuridica;
	public String cpfCnpj;
	public String nomeResponsavel;
	public String emailPrincipal;
	public String dddTelefoneComercial;
	public String telefoneComercial;
	public String sexo;
	public boolean cadastroFinalizado;
	public String formaPagamento;
	public String numeroCartao;
	public int validadeCartaoMes;
	public int validadeCartaoAno;
	public String nomeTitularCartao;
	public String codigoSegurancaCartao;
	public String statusMoedaDigital;
	public int quantidadeParcelas;
	public double valorTotal;
	public String moedaDigitalPedido;
	public long dataInicio;
}