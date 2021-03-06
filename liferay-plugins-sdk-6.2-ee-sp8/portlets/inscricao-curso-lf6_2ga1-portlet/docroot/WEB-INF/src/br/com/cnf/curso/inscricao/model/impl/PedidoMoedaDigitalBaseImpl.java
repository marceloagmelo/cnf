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
import br.com.cnf.curso.inscricao.service.PedidoMoedaDigitalLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the PedidoMoedaDigital service. Represents a row in the &quot;cnf_PedidoMoedaDigital&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PedidoMoedaDigitalImpl}.
 * </p>
 *
 * @author SEA
 * @see PedidoMoedaDigitalImpl
 * @see br.com.cnf.curso.inscricao.model.PedidoMoedaDigital
 * @generated
 */
public abstract class PedidoMoedaDigitalBaseImpl
	extends PedidoMoedaDigitalModelImpl implements PedidoMoedaDigital {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a pedido moeda digital model instance should use the {@link PedidoMoedaDigital} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PedidoMoedaDigitalLocalServiceUtil.addPedidoMoedaDigital(this);
		}
		else {
			PedidoMoedaDigitalLocalServiceUtil.updatePedidoMoedaDigital(this);
		}
	}
}