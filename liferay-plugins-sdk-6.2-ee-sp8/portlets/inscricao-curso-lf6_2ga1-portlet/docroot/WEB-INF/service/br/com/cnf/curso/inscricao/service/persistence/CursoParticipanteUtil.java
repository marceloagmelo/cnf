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

import br.com.cnf.curso.inscricao.model.CursoParticipante;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the curso participante service. This utility wraps {@link CursoParticipantePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author SEA
 * @see CursoParticipantePersistence
 * @see CursoParticipantePersistenceImpl
 * @generated
 */
public class CursoParticipanteUtil {
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
	public static void clearCache(CursoParticipante cursoParticipante) {
		getPersistence().clearCache(cursoParticipante);
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
	public static List<CursoParticipante> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CursoParticipante> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CursoParticipante> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CursoParticipante update(CursoParticipante cursoParticipante)
		throws SystemException {
		return getPersistence().update(cursoParticipante);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CursoParticipante update(
		CursoParticipante cursoParticipante, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(cursoParticipante, serviceContext);
	}

	/**
	* Caches the curso participante in the entity cache if it is enabled.
	*
	* @param cursoParticipante the curso participante
	*/
	public static void cacheResult(
		br.com.cnf.curso.inscricao.model.CursoParticipante cursoParticipante) {
		getPersistence().cacheResult(cursoParticipante);
	}

	/**
	* Caches the curso participantes in the entity cache if it is enabled.
	*
	* @param cursoParticipantes the curso participantes
	*/
	public static void cacheResult(
		java.util.List<br.com.cnf.curso.inscricao.model.CursoParticipante> cursoParticipantes) {
		getPersistence().cacheResult(cursoParticipantes);
	}

	/**
	* Creates a new curso participante with the primary key. Does not add the curso participante to the database.
	*
	* @param participanteId the primary key for the new curso participante
	* @return the new curso participante
	*/
	public static br.com.cnf.curso.inscricao.model.CursoParticipante create(
		long participanteId) {
		return getPersistence().create(participanteId);
	}

	/**
	* Removes the curso participante with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param participanteId the primary key of the curso participante
	* @return the curso participante that was removed
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoParticipanteException if a curso participante with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.cnf.curso.inscricao.model.CursoParticipante remove(
		long participanteId)
		throws br.com.cnf.curso.inscricao.NoSuchCursoParticipanteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(participanteId);
	}

	public static br.com.cnf.curso.inscricao.model.CursoParticipante updateImpl(
		br.com.cnf.curso.inscricao.model.CursoParticipante cursoParticipante)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(cursoParticipante);
	}

	/**
	* Returns the curso participante with the primary key or throws a {@link br.com.cnf.curso.inscricao.NoSuchCursoParticipanteException} if it could not be found.
	*
	* @param participanteId the primary key of the curso participante
	* @return the curso participante
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoParticipanteException if a curso participante with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.cnf.curso.inscricao.model.CursoParticipante findByPrimaryKey(
		long participanteId)
		throws br.com.cnf.curso.inscricao.NoSuchCursoParticipanteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(participanteId);
	}

	/**
	* Returns the curso participante with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param participanteId the primary key of the curso participante
	* @return the curso participante, or <code>null</code> if a curso participante with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.cnf.curso.inscricao.model.CursoParticipante fetchByPrimaryKey(
		long participanteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(participanteId);
	}

	/**
	* Returns all the curso participantes.
	*
	* @return the curso participantes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.cnf.curso.inscricao.model.CursoParticipante> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the curso participantes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoParticipanteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of curso participantes
	* @param end the upper bound of the range of curso participantes (not inclusive)
	* @return the range of curso participantes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.cnf.curso.inscricao.model.CursoParticipante> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the curso participantes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoParticipanteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of curso participantes
	* @param end the upper bound of the range of curso participantes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of curso participantes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.cnf.curso.inscricao.model.CursoParticipante> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the curso participantes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of curso participantes.
	*
	* @return the number of curso participantes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CursoParticipantePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CursoParticipantePersistence)PortletBeanLocatorUtil.locate(br.com.cnf.curso.inscricao.service.ClpSerializer.getServletContextName(),
					CursoParticipantePersistence.class.getName());

			ReferenceRegistry.registerReference(CursoParticipanteUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CursoParticipantePersistence persistence) {
	}

	private static CursoParticipantePersistence _persistence;
}