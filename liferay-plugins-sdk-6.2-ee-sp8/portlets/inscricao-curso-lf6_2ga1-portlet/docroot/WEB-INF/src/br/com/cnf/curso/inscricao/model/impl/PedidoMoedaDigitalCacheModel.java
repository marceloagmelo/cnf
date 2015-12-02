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

import br.com.cnf.curso.inscricao.model.PedidoMoedaDigital;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PedidoMoedaDigital in entity cache.
 *
 * @author SEA
 * @see PedidoMoedaDigital
 * @generated
 */
public class PedidoMoedaDigitalCacheModel implements CacheModel<PedidoMoedaDigital>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{pedidoMoedaDigitalId=");
		sb.append(pedidoMoedaDigitalId);
		sb.append(", inscricaoId=");
		sb.append(inscricaoId);
		sb.append(", dataPedido=");
		sb.append(dataPedido);
		sb.append(", xmlEnvio=");
		sb.append(xmlEnvio);
		sb.append(", xmlRetorno=");
		sb.append(xmlRetorno);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PedidoMoedaDigital toEntityModel() {
		PedidoMoedaDigitalImpl pedidoMoedaDigitalImpl = new PedidoMoedaDigitalImpl();

		pedidoMoedaDigitalImpl.setPedidoMoedaDigitalId(pedidoMoedaDigitalId);
		pedidoMoedaDigitalImpl.setInscricaoId(inscricaoId);

		if (dataPedido == Long.MIN_VALUE) {
			pedidoMoedaDigitalImpl.setDataPedido(null);
		}
		else {
			pedidoMoedaDigitalImpl.setDataPedido(new Date(dataPedido));
		}

		if (xmlEnvio == null) {
			pedidoMoedaDigitalImpl.setXmlEnvio(StringPool.BLANK);
		}
		else {
			pedidoMoedaDigitalImpl.setXmlEnvio(xmlEnvio);
		}

		if (xmlRetorno == null) {
			pedidoMoedaDigitalImpl.setXmlRetorno(StringPool.BLANK);
		}
		else {
			pedidoMoedaDigitalImpl.setXmlRetorno(xmlRetorno);
		}

		pedidoMoedaDigitalImpl.resetOriginalValues();

		return pedidoMoedaDigitalImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		pedidoMoedaDigitalId = objectInput.readLong();
		inscricaoId = objectInput.readLong();
		dataPedido = objectInput.readLong();
		xmlEnvio = objectInput.readUTF();
		xmlRetorno = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(pedidoMoedaDigitalId);
		objectOutput.writeLong(inscricaoId);
		objectOutput.writeLong(dataPedido);

		if (xmlEnvio == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xmlEnvio);
		}

		if (xmlRetorno == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xmlRetorno);
		}
	}

	public long pedidoMoedaDigitalId;
	public long inscricaoId;
	public long dataPedido;
	public String xmlEnvio;
	public String xmlRetorno;
}