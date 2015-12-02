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
 * Provides the local service utility for CursoInscricaoCpf. This utility wraps
 * {@link br.com.cnf.curso.inscricao.service.impl.CursoInscricaoCpfLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author SEA
 * @see CursoInscricaoCpfLocalService
 * @see br.com.cnf.curso.inscricao.service.base.CursoInscricaoCpfLocalServiceBaseImpl
 * @see br.com.cnf.curso.inscricao.service.impl.CursoInscricaoCpfLocalServiceImpl
 * @generated
 */
public class CursoInscricaoCpfLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link br.com.cnf.curso.inscricao.service.impl.CursoInscricaoCpfLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the curso inscricao cpf to the database. Also notifies the appropriate model listeners.
	*
	* @param cursoInscricaoCpf the curso inscricao cpf
	* @return the curso inscricao cpf that was added
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.cnf.curso.inscricao.model.CursoInscricaoCpf addCursoInscricaoCpf(
		br.com.cnf.curso.inscricao.model.CursoInscricaoCpf cursoInscricaoCpf)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCursoInscricaoCpf(cursoInscricaoCpf);
	}

	/**
	* Creates a new curso inscricao cpf with the primary key. Does not add the curso inscricao cpf to the database.
	*
	* @param inscricaoCpfId the primary key for the new curso inscricao cpf
	* @return the new curso inscricao cpf
	*/
	public static br.com.cnf.curso.inscricao.model.CursoInscricaoCpf createCursoInscricaoCpf(
		long inscricaoCpfId) {
		return getService().createCursoInscricaoCpf(inscricaoCpfId);
	}

	/**
	* Deletes the curso inscricao cpf with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param inscricaoCpfId the primary key of the curso inscricao cpf
	* @return the curso inscricao cpf that was removed
	* @throws PortalException if a curso inscricao cpf with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.cnf.curso.inscricao.model.CursoInscricaoCpf deleteCursoInscricaoCpf(
		long inscricaoCpfId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCursoInscricaoCpf(inscricaoCpfId);
	}

	/**
	* Deletes the curso inscricao cpf from the database. Also notifies the appropriate model listeners.
	*
	* @param cursoInscricaoCpf the curso inscricao cpf
	* @return the curso inscricao cpf that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.cnf.curso.inscricao.model.CursoInscricaoCpf deleteCursoInscricaoCpf(
		br.com.cnf.curso.inscricao.model.CursoInscricaoCpf cursoInscricaoCpf)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCursoInscricaoCpf(cursoInscricaoCpf);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCpfModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCpfModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static br.com.cnf.curso.inscricao.model.CursoInscricaoCpf fetchCursoInscricaoCpf(
		long inscricaoCpfId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCursoInscricaoCpf(inscricaoCpfId);
	}

	/**
	* Returns the curso inscricao cpf with the primary key.
	*
	* @param inscricaoCpfId the primary key of the curso inscricao cpf
	* @return the curso inscricao cpf
	* @throws PortalException if a curso inscricao cpf with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.cnf.curso.inscricao.model.CursoInscricaoCpf getCursoInscricaoCpf(
		long inscricaoCpfId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCursoInscricaoCpf(inscricaoCpfId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricaoCpf> getCursoInscricaoCpfs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCursoInscricaoCpfs(start, end);
	}

	/**
	* Returns the number of curso inscricao cpfs.
	*
	* @return the number of curso inscricao cpfs
	* @throws SystemException if a system exception occurred
	*/
	public static int getCursoInscricaoCpfsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCursoInscricaoCpfsCount();
	}

	/**
	* Updates the curso inscricao cpf in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cursoInscricaoCpf the curso inscricao cpf
	* @return the curso inscricao cpf that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.cnf.curso.inscricao.model.CursoInscricaoCpf updateCursoInscricaoCpf(
		br.com.cnf.curso.inscricao.model.CursoInscricaoCpf cursoInscricaoCpf)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCursoInscricaoCpf(cursoInscricaoCpf);
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

	public static void clearService() {
		_service = null;
	}

	public static CursoInscricaoCpfLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CursoInscricaoCpfLocalService.class.getName());

			if (invokableLocalService instanceof CursoInscricaoCpfLocalService) {
				_service = (CursoInscricaoCpfLocalService)invokableLocalService;
			}
			else {
				_service = new CursoInscricaoCpfLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CursoInscricaoCpfLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CursoInscricaoCpfLocalService service) {
	}

	private static CursoInscricaoCpfLocalService _service;
}