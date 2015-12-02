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

package br.com.cnf.curso.inscricao.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for CursoInscricao. This utility wraps
 * {@link br.com.cnf.curso.inscricao.service.impl.CursoInscricaoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author SEA
 * @see CursoInscricaoLocalService
 * @see br.com.cnf.curso.inscricao.service.base.CursoInscricaoLocalServiceBaseImpl
 * @see br.com.cnf.curso.inscricao.service.impl.CursoInscricaoLocalServiceImpl
 * @generated
 */
public class CursoInscricaoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link br.com.cnf.curso.inscricao.service.impl.CursoInscricaoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the curso inscricao to the database. Also notifies the appropriate model listeners.
	*
	* @param cursoInscricao the curso inscricao
	* @return the curso inscricao that was added
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.cnf.curso.inscricao.model.CursoInscricao addCursoInscricao(
		br.com.cnf.curso.inscricao.model.CursoInscricao cursoInscricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCursoInscricao(cursoInscricao);
	}

	/**
	* Creates a new curso inscricao with the primary key. Does not add the curso inscricao to the database.
	*
	* @param inscricaoId the primary key for the new curso inscricao
	* @return the new curso inscricao
	*/
	public static br.com.cnf.curso.inscricao.model.CursoInscricao createCursoInscricao(
		long inscricaoId) {
		return getService().createCursoInscricao(inscricaoId);
	}

	/**
	* Deletes the curso inscricao with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param inscricaoId the primary key of the curso inscricao
	* @return the curso inscricao that was removed
	* @throws PortalException if a curso inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.cnf.curso.inscricao.model.CursoInscricao deleteCursoInscricao(
		long inscricaoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCursoInscricao(inscricaoId);
	}

	/**
	* Deletes the curso inscricao from the database. Also notifies the appropriate model listeners.
	*
	* @param cursoInscricao the curso inscricao
	* @return the curso inscricao that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.cnf.curso.inscricao.model.CursoInscricao deleteCursoInscricao(
		br.com.cnf.curso.inscricao.model.CursoInscricao cursoInscricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCursoInscricao(cursoInscricao);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static br.com.cnf.curso.inscricao.model.CursoInscricao fetchCursoInscricao(
		long inscricaoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCursoInscricao(inscricaoId);
	}

	/**
	* Returns the curso inscricao with the primary key.
	*
	* @param inscricaoId the primary key of the curso inscricao
	* @return the curso inscricao
	* @throws PortalException if a curso inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.cnf.curso.inscricao.model.CursoInscricao getCursoInscricao(
		long inscricaoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCursoInscricao(inscricaoId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the curso inscricaos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of curso inscricaos
	* @param end the upper bound of the range of curso inscricaos (not inclusive)
	* @return the range of curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricao> getCursoInscricaos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCursoInscricaos(start, end);
	}

	/**
	* Returns the number of curso inscricaos.
	*
	* @return the number of curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public static int getCursoInscricaosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCursoInscricaosCount();
	}

	/**
	* Updates the curso inscricao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cursoInscricao the curso inscricao
	* @return the curso inscricao that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.cnf.curso.inscricao.model.CursoInscricao updateCursoInscricao(
		br.com.cnf.curso.inscricao.model.CursoInscricao cursoInscricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCursoInscricao(cursoInscricao);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricao> search(
		java.lang.String statusMoedaDigital)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().search(statusMoedaDigital);
	}

	public static void clearService() {
		_service = null;
	}

	public static CursoInscricaoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CursoInscricaoLocalService.class.getName());

			if (invokableLocalService instanceof CursoInscricaoLocalService) {
				_service = (CursoInscricaoLocalService)invokableLocalService;
			}
			else {
				_service = new CursoInscricaoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CursoInscricaoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CursoInscricaoLocalService service) {
	}

	private static CursoInscricaoLocalService _service;
}