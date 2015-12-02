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

package br.com.cnf.curso.inscricao.service.impl;

import br.com.cnf.curso.inscricao.model.PedidoMoedaDigital;
import br.com.cnf.curso.inscricao.service.base.PedidoMoedaDigitalLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the pedido moeda digital local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.com.cnf.curso.inscricao.service.PedidoMoedaDigitalLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author SEA
 * @see br.com.cnf.curso.inscricao.service.base.PedidoMoedaDigitalLocalServiceBaseImpl
 * @see br.com.cnf.curso.inscricao.service.PedidoMoedaDigitalLocalServiceUtil
 */
public class PedidoMoedaDigitalLocalServiceImpl
	extends PedidoMoedaDigitalLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link br.com.cnf.curso.inscricao.service.PedidoMoedaDigitalLocalServiceUtil} to access the pedido moeda digital local service.
	 */
	@Override
	public PedidoMoedaDigital addPedidoMoedaDigital(PedidoMoedaDigital pedidoMoedaDigital) throws SystemException {
		long pedidoMoedaDigitalId = pedidoMoedaDigital.getPedidoMoedaDigitalId();
		
		// Cria a classe implementando um novo ID no banco.
		if(pedidoMoedaDigitalId <= 0) {
			pedidoMoedaDigitalId = counterLocalService.increment(PedidoMoedaDigital.class.getName());
		}
		
		PedidoMoedaDigital novoPedidoMoedaDigital = pedidoMoedaDigitalPersistence.create(pedidoMoedaDigitalId);
		
		// Atribui novos valores
		novoPedidoMoedaDigital.setDataPedido(pedidoMoedaDigital.getDataPedido());
		novoPedidoMoedaDigital.setXmlEnvio(pedidoMoedaDigital.getXmlEnvio());
		novoPedidoMoedaDigital.setXmlRetorno(pedidoMoedaDigital.getXmlRetorno());
		novoPedidoMoedaDigital.setInscricaoId(pedidoMoedaDigital.getInscricaoId());

		return super.addPedidoMoedaDigital(novoPedidoMoedaDigital);
	}
}