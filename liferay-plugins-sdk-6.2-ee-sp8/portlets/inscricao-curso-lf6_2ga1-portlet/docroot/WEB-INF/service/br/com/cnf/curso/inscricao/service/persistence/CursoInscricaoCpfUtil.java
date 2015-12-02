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

import br.com.cnf.curso.inscricao.model.CursoInscricaoCpf;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the curso inscricao cpf service. This utility wraps {@link CursoInscricaoCpfPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author SEA
 * @see CursoInscricaoCpfPersistence
 * @see CursoInscricaoCpfPersistenceImpl
 * @generated
 */
public class CursoInscricaoCpfUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(CursoInscricaoCpf cursoInscricaoCpf) {
		getPersistence().clearCache(cursoInscricaoCpf);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CursoInscricaoCpf> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CursoInscricaoCpf> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CursoInscricaoCpf> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CursoInscricaoCpf update(CursoInscricaoCpf cursoInscricaoCpf)
		throws SystemException {
		return getPersistence().update(cursoInscricaoCpf);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CursoInscricaoCpf update(
		CursoInscricaoCpf cursoInscricaoCpf, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(cursoInscricaoCpf, serviceContext);
	}

	/**
	* Caches the curso inscricao cpf in the entity cache if it is enabled.
	*
	* @param cursoInscricaoCpf the curso inscricao cpf
	*/
	public static void cacheResult(
		br.com.cnf.curso.inscricao.model.CursoInscricaoCpf cursoInscricaoCpf) {
		getPersistence().cacheResult(cursoInscricaoCpf);
	}

	/**
	* Caches the curso inscricao cpfs in the entity cache if it is enabled.
	*
	* @param cursoInscricaoCpfs the curso inscricao cpfs
	*/
	public static void cacheResult(
		java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricaoCpf> cursoInscricaoCpfs) {
		getPersistence().cacheResult(cursoInscricaoCpfs);
	}

	/**
	* Creates a new curso inscricao cpf with the primary key. Does not add the curso inscricao cpf to the database.
	*
	* @param inscricaoCpfId the primary key for the new curso inscricao cpf
	* @return the new curso inscricao cpf
	*/
	public static br.com.cnf.curso.inscricao.model.CursoInscricaoCpf create(
		long inscricaoCpfId) {
		return getPersistence().create(inscricaoCpfId);
	}

	/**
	* Removes the curso inscricao cpf with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param inscricaoCpfId the primary key of the curso inscricao cpf
	* @return the curso inscricao cpf that was removed
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCpfException if a curso inscricao cpf with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.cnf.curso.inscricao.model.CursoInscricaoCpf remove(
		long inscricaoCpfId)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCpfException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(inscricaoCpfId);
	}

	public static br.com.cnf.curso.inscricao.model.CursoInscricaoCpf updateImpl(
		br.com.cnf.curso.inscricao.model.CursoInscricaoCpf cursoInscricaoCpf)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(cursoInscricaoCpf);
	}

	/**
	* Returns the curso inscricao cpf with the primary key or throws a {@link br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCpfException} if it could not be found.
	*
	* @param inscricaoCpfId the primary key of the curso inscricao cpf
	* @return the curso inscricao cpf
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCpfException if a curso inscricao cpf with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.cnf.curso.inscricao.model.CursoInscricaoCpf findByPrimaryKey(
		long inscricaoCpfId)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCpfException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(inscricaoCpfId);
	}

	/**
	* Returns the curso inscricao cpf with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param inscricaoCpfId the primary key of the curso inscricao cpf
	* @return the curso inscricao cpf, or <code>null</code> if a curso inscricao cpf with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.cnf.curso.inscricao.model.CursoInscricaoCpf fetchByPrimaryKey(
		long inscricaoCpfId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(inscricaoCpfId);
	}

	/**
	* Returns all the curso inscricao cpfs.
	*
	* @return the curso inscricao cpfs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricaoCpf> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the curso inscricao cpfs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCpfModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of curso inscricao cpfs
	* @param end the upper bound of the range of curso inscricao cpfs (not inclusive)
	* @return the range of curso inscricao cpfs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricaoCpf> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the curso inscricao cpfs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCpfModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of curso inscricao cpfs
	* @param end the upper bound of the range of curso inscricao cpfs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of curso inscricao cpfs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricaoCpf> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the curso inscricao cpfs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of curso inscricao cpfs.
	*
	* @return the number of curso inscricao cpfs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CursoInscricaoCpfPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CursoInscricaoCpfPersistence)PortletBeanLocatorUtil.locate(br.com.cnf.curso.inscricao.service.ClpSerializer.getServletContextName(),
					CursoInscricaoCpfPersistence.class.getName());

			ReferenceRegistry.registerReference(CursoInscricaoCpfUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CursoInscricaoCpfPersistence persistence) {
	}

	private static CursoInscricaoCpfPersistence _persistence;
}