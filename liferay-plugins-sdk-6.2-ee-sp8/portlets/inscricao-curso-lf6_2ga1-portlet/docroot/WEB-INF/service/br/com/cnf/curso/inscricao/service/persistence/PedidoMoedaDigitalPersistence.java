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

package br.com.cnf.curso.inscricao.service.persistence;

import br.com.cnf.curso.inscricao.model.PedidoMoedaDigital;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the pedido moeda digital service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author SEA
 * @see PedidoMoedaDigitalPersistenceImpl
 * @see PedidoMoedaDigitalUtil
 * @generated
 */
public interface PedidoMoedaDigitalPersistence extends BasePersistence<PedidoMoedaDigital> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PedidoMoedaDigitalUtil} to access the pedido moeda digital persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the pedido moeda digital in the entity cache if it is enabled.
	*
	* @param pedidoMoedaDigital the pedido moeda digital
	*/
	public void cacheResult(
		br.com.cnf.curso.inscricao.model.PedidoMoedaDigital pedidoMoedaDigital);

	/**
	* Caches the pedido moeda digitals in the entity cache if it is enabled.
	*
	* @param pedidoMoedaDigitals the pedido moeda digitals
	*/
	public void cacheResult(
		java.util.List<br.com.cnf.curso.inscricao.model.PedidoMoedaDigital> pedidoMoedaDigitals);

	/**
	* Creates a new pedido moeda digital with the primary key. Does not add the pedido moeda digital to the database.
	*
	* @param pedidoMoedaDigitalId the primary key for the new pedido moeda digital
	* @return the new pedido moeda digital
	*/
	public br.com.cnf.curso.inscricao.model.PedidoMoedaDigital create(
		long pedidoMoedaDigitalId);

	/**
	* Removes the pedido moeda digital with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pedidoMoedaDigitalId the primary key of the pedido moeda digital
	* @return the pedido moeda digital that was removed
	* @throws br.com.cnf.curso.inscricao.NoSuchPedidoMoedaDigitalException if a pedido moeda digital with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.PedidoMoedaDigital remove(
		long pedidoMoedaDigitalId)
		throws br.com.cnf.curso.inscricao.NoSuchPedidoMoedaDigitalException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.cnf.curso.inscricao.model.PedidoMoedaDigital updateImpl(
		br.com.cnf.curso.inscricao.model.PedidoMoedaDigital pedidoMoedaDigital)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the pedido moeda digital with the primary key or throws a {@link br.com.cnf.curso.inscricao.NoSuchPedidoMoedaDigitalException} if it could not be found.
	*
	* @param pedidoMoedaDigitalId the primary key of the pedido moeda digital
	* @return the pedido moeda digital
	* @throws br.com.cnf.curso.inscricao.NoSuchPedidoMoedaDigitalException if a pedido moeda digital with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.PedidoMoedaDigital findByPrimaryKey(
		long pedidoMoedaDigitalId)
		throws br.com.cnf.curso.inscricao.NoSuchPedidoMoedaDigitalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the pedido moeda digital with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pedidoMoedaDigitalId the primary key of the pedido moeda digital
	* @return the pedido moeda digital, or <code>null</code> if a pedido moeda digital with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.PedidoMoedaDigital fetchByPrimaryKey(
		long pedidoMoedaDigitalId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the pedido moeda digitals.
	*
	* @return the pedido moeda digitals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.cnf.curso.inscricao.model.PedidoMoedaDigital> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the pedido moeda digitals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.PedidoMoedaDigitalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pedido moeda digitals
	* @param end the upper bound of the range of pedido moeda digitals (not inclusive)
	* @return the range of pedido moeda digitals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.cnf.curso.inscricao.model.PedidoMoedaDigital> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the pedido moeda digitals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.PedidoMoedaDigitalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pedido moeda digitals
	* @param end the upper bound of the range of pedido moeda digitals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of pedido moeda digitals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.cnf.curso.inscricao.model.PedidoMoedaDigital> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the pedido moeda digitals from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of pedido moeda digitals.
	*
	* @return the number of pedido moeda digitals
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}