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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CursoInscricaoCnpjLocalService}.
 *
 * @author SEA
 * @see CursoInscricaoCnpjLocalService
 * @generated
 */
public class CursoInscricaoCnpjLocalServiceWrapper
	implements CursoInscricaoCnpjLocalService,
		ServiceWrapper<CursoInscricaoCnpjLocalService> {
	public CursoInscricaoCnpjLocalServiceWrapper(
		CursoInscricaoCnpjLocalService cursoInscricaoCnpjLocalService) {
		_cursoInscricaoCnpjLocalService = cursoInscricaoCnpjLocalService;
	}

	/**
	* Adds the curso inscricao cnpj to the database. Also notifies the appropriate model listeners.
	*
	* @param cursoInscricaoCnpj the curso inscricao cnpj
	* @return the curso inscricao cnpj that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj addCursoInscricaoCnpj(
		br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj cursoInscricaoCnpj)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoCnpjLocalService.addCursoInscricaoCnpj(cursoInscricaoCnpj);
	}

	/**
	* Creates a new curso inscricao cnpj with the primary key. Does not add the curso inscricao cnpj to the database.
	*
	* @param inscricaoCnpjId the primary key for the new curso inscricao cnpj
	* @return the new curso inscricao cnpj
	*/
	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj createCursoInscricaoCnpj(
		long inscricaoCnpjId) {
		return _cursoInscricaoCnpjLocalService.createCursoInscricaoCnpj(inscricaoCnpjId);
	}

	/**
	* Deletes the curso inscricao cnpj with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param inscricaoCnpjId the primary key of the curso inscricao cnpj
	* @return the curso inscricao cnpj that was removed
	* @throws PortalException if a curso inscricao cnpj with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj deleteCursoInscricaoCnpj(
		long inscricaoCnpjId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoCnpjLocalService.deleteCursoInscricaoCnpj(inscricaoCnpjId);
	}

	/**
	* Deletes the curso inscricao cnpj from the database. Also notifies the appropriate model listeners.
	*
	* @param cursoInscricaoCnpj the curso inscricao cnpj
	* @return the curso inscricao cnpj that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj deleteCursoInscricaoCnpj(
		br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj cursoInscricaoCnpj)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoCnpjLocalService.deleteCursoInscricaoCnpj(cursoInscricaoCnpj);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cursoInscricaoCnpjLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoCnpjLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCnpjModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoCnpjLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCnpjModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoCnpjLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoCnpjLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoCnpjLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj fetchCursoInscricaoCnpj(
		long inscricaoCnpjId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoCnpjLocalService.fetchCursoInscricaoCnpj(inscricaoCnpjId);
	}

	/**
	* Returns the curso inscricao cnpj with the primary key.
	*
	* @param inscricaoCnpjId the primary key of the curso inscricao cnpj
	* @return the curso inscricao cnpj
	* @throws PortalException if a curso inscricao cnpj with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj getCursoInscricaoCnpj(
		long inscricaoCnpjId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoCnpjLocalService.getCursoInscricaoCnpj(inscricaoCnpjId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoCnpjLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj> getCursoInscricaoCnpjs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoCnpjLocalService.getCursoInscricaoCnpjs(start, end);
	}

	/**
	* Returns the number of curso inscricao cnpjs.
	*
	* @return the number of curso inscricao cnpjs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCursoInscricaoCnpjsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoCnpjLocalService.getCursoInscricaoCnpjsCount();
	}

	/**
	* Updates the curso inscricao cnpj in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cursoInscricaoCnpj the curso inscricao cnpj
	* @return the curso inscricao cnpj that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj updateCursoInscricaoCnpj(
		br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj cursoInscricaoCnpj)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoCnpjLocalService.updateCursoInscricaoCnpj(cursoInscricaoCnpj);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _cursoInscricaoCnpjLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cursoInscricaoCnpjLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cursoInscricaoCnpjLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CursoInscricaoCnpjLocalService getWrappedCursoInscricaoCnpjLocalService() {
		return _cursoInscricaoCnpjLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCursoInscricaoCnpjLocalService(
		CursoInscricaoCnpjLocalService cursoInscricaoCnpjLocalService) {
		_cursoInscricaoCnpjLocalService = cursoInscricaoCnpjLocalService;
	}

	@Override
	public CursoInscricaoCnpjLocalService getWrappedService() {
		return _cursoInscricaoCnpjLocalService;
	}

	@Override
	public void setWrappedService(
		CursoInscricaoCnpjLocalService cursoInscricaoCnpjLocalService) {
		_cursoInscricaoCnpjLocalService = cursoInscricaoCnpjLocalService;
	}

	private CursoInscricaoCnpjLocalService _cursoInscricaoCnpjLocalService;
}