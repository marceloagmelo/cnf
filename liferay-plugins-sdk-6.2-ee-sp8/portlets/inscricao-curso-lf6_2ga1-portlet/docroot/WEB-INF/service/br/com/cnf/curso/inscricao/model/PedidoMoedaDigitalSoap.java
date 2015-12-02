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
public class PedidoMoedaDigitalSoap implements Serializable {
	public static PedidoMoedaDigitalSoap toSoapModel(PedidoMoedaDigital model) {
		PedidoMoedaDigitalSoap soapModel = new PedidoMoedaDigitalSoap();

		soapModel.setPedidoMoedaDigitalId(model.getPedidoMoedaDigitalId());
		soapModel.setInscricaoId(model.getInscricaoId());
		soapModel.setDataPedido(model.getDataPedido());
		soapModel.setXmlEnvio(model.getXmlEnvio());
		soapModel.setXmlRetorno(model.getXmlRetorno());

		return soapModel;
	}

	public static PedidoMoedaDigitalSoap[] toSoapModels(
		PedidoMoedaDigital[] models) {
		PedidoMoedaDigitalSoap[] soapModels = new PedidoMoedaDigitalSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PedidoMoedaDigitalSoap[][] toSoapModels(
		PedidoMoedaDigital[][] models) {
		PedidoMoedaDigitalSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PedidoMoedaDigitalSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PedidoMoedaDigitalSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PedidoMoedaDigitalSoap[] toSoapModels(
		List<PedidoMoedaDigital> models) {
		List<PedidoMoedaDigitalSoap> soapModels = new ArrayList<PedidoMoedaDigitalSoap>(models.size());

		for (PedidoMoedaDigital model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PedidoMoedaDigitalSoap[soapModels.size()]);
	}

	public PedidoMoedaDigitalSoap() {
	}

	public long getPrimaryKey() {
		return _pedidoMoedaDigitalId;
	}

	public void setPrimaryKey(long pk) {
		setPedidoMoedaDigitalId(pk);
	}

	public long getPedidoMoedaDigitalId() {
		return _pedidoMoedaDigitalId;
	}

	public void setPedidoMoedaDigitalId(long pedidoMoedaDigitalId) {
		_pedidoMoedaDigitalId = pedidoMoedaDigitalId;
	}

	public long getInscricaoId() {
		return _inscricaoId;
	}

	public void setInscricaoId(long inscricaoId) {
		_inscricaoId = inscricaoId;
	}

	public Date getDataPedido() {
		return _dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		_dataPedido = dataPedido;
	}

	public String getXmlEnvio() {
		return _xmlEnvio;
	}

	public void setXmlEnvio(String xmlEnvio) {
		_xmlEnvio = xmlEnvio;
	}

	public String getXmlRetorno() {
		return _xmlRetorno;
	}

	public void setXmlRetorno(String xmlRetorno) {
		_xmlRetorno = xmlRetorno;
	}

	private long _pedidoMoedaDigitalId;
	private long _inscricaoId;
	private Date _dataPedido;
	private String _xmlEnvio;
	private String _xmlRetorno;
}