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

import br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the curso inscricao cnpj service. This utility wraps {@link CursoInscricaoCnpjPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author SEA
 * @see CursoInscricaoCnpjPersistence
 * @see CursoInscricaoCnpjPersistenceImpl
 * @generated
 */
public class CursoInscricaoCnpjUtil {
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
	public static void clearCache(CursoInscricaoCnpj cursoInscricaoCnpj) {
		getPersistence().clearCache(cursoInscricaoCnpj);
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
	public static List<CursoInscricaoCnpj> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CursoInscricaoCnpj> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CursoInscricaoCnpj> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CursoInscricaoCnpj update(
		CursoInscricaoCnpj cursoInscricaoCnpj) throws SystemException {
		return getPersistence().update(cursoInscricaoCnpj);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CursoInscricaoCnpj update(
		CursoInscricaoCnpj cursoInscricaoCnpj, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(cursoInscricaoCnpj, serviceContext);
	}

	/**
	* Caches the curso inscricao cnpj in the entity cache if it is enabled.
	*
	* @param cursoInscricaoCnpj the curso inscricao cnpj
	*/
	public static void cacheResult(
		br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj cursoInscricaoCnpj) {
		getPersistence().cacheResult(cursoInscricaoCnpj);
	}

	/**
	* Caches the curso inscricao cnpjs in the entity cache if it is enabled.
	*
	* @param cursoInscricaoCnpjs the curso inscricao cnpjs
	*/
	public static void cacheResult(
		java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj> cursoInscricaoCnpjs) {
		getPersistence().cacheResult(cursoInscricaoCnpjs);
	}

	/**
	* Creates a new curso inscricao cnpj with the primary key. Does not add the curso inscricao cnpj to the database.
	*
	* @param inscricaoCnpjId the primary key for the new curso inscricao cnpj
	* @return the new curso inscricao cnpj
	*/
	public static br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj create(
		long inscricaoCnpjId) {
		return getPersistence().create(inscricaoCnpjId);
	}

	/**
	* Removes the curso inscricao cnpj with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param inscricaoCnpjId the primary key of the curso inscricao cnpj
	* @return the curso inscricao cnpj that was removed
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCnpjException if a curso inscricao cnpj with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj remove(
		long inscricaoCnpjId)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCnpjException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(inscricaoCnpjId);
	}

	public static br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj updateImpl(
		br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj cursoInscricaoCnpj)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(cursoInscricaoCnpj);
	}

	/**
	* Returns the curso inscricao cnpj with the primary key or throws a {@link br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCnpjException} if it could not be found.
	*
	* @param inscricaoCnpjId the primary key of the curso inscricao cnpj
	* @return the curso inscricao cnpj
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCnpjException if a curso inscricao cnpj with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj findByPrimaryKey(
		long inscricaoCnpjId)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCnpjException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(inscricaoCnpjId);
	}

	/**
	* Returns the curso inscricao cnpj with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param inscricaoCnpjId the primary key of the curso inscricao cnpj
	* @return the curso inscricao cnpj, or <code>null</code> if a curso inscricao cnpj with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj fetchByPrimaryKey(
		long inscricaoCnpjId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(inscricaoCnpjId);
	}

	/**
	* Returns all the curso inscricao cnpjs.
	*
	* @return the curso inscricao cnpjs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the curso inscricao cnpjs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCnpjModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of curso inscricao cnpjs
	* @param end the upper bound of the range of curso inscricao cnpjs (not inclusive)
	* @return the range of curso inscricao cnpjs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the curso inscricao cnpjs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCnpjModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of curso inscricao cnpjs
	* @param end the upper bound of the range of curso inscricao cnpjs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of curso inscricao cnpjs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the curso inscricao cnpjs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of curso inscricao cnpjs.
	*
	* @return the number of curso inscricao cnpjs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CursoInscricaoCnpjPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CursoInscricaoCnpjPersistence)PortletBeanLocatorUtil.locate(br.com.cnf.curso.inscricao.service.ClpSerializer.getServletContextName(),
					CursoInscricaoCnpjPersistence.class.getName());

			ReferenceRegistry.registerReference(CursoInscricaoCnpjUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CursoInscricaoCnpjPersistence persistence) {
	}

	private static CursoInscricaoCnpjPersistence _persistence;
}