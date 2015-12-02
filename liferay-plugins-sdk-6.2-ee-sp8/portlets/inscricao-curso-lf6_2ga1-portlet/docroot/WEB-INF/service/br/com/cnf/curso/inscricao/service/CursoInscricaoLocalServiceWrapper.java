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
 * Provides a wrapper for {@link CursoInscricaoLocalService}.
 *
 * @author SEA
 * @see CursoInscricaoLocalService
 * @generated
 */
public class CursoInscricaoLocalServiceWrapper
	implements CursoInscricaoLocalService,
		ServiceWrapper<CursoInscricaoLocalService> {
	public CursoInscricaoLocalServiceWrapper(
		CursoInscricaoLocalService cursoInscricaoLocalService) {
		_cursoInscricaoLocalService = cursoInscricaoLocalService;
	}

	/**
	* Adds the curso inscricao to the database. Also notifies the appropriate model listeners.
	*
	* @param cursoInscricao the curso inscricao
	* @return the curso inscricao that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricao addCursoInscricao(
		br.com.cnf.curso.inscricao.model.CursoInscricao cursoInscricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoLocalService.addCursoInscricao(cursoInscricao);
	}

	/**
	* Creates a new curso inscricao with the primary key. Does not add the curso inscricao to the database.
	*
	* @param inscricaoId the primary key for the new curso inscricao
	* @return the new curso inscricao
	*/
	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricao createCursoInscricao(
		long inscricaoId) {
		return _cursoInscricaoLocalService.createCursoInscricao(inscricaoId);
	}

	/**
	* Deletes the curso inscricao with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param inscricaoId the primary key of the curso inscricao
	* @return the curso inscricao that was removed
	* @throws PortalException if a curso inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricao deleteCursoInscricao(
		long inscricaoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoLocalService.deleteCursoInscricao(inscricaoId);
	}

	/**
	* Deletes the curso inscricao from the database. Also notifies the appropriate model listeners.
	*
	* @param cursoInscricao the curso inscricao
	* @return the curso inscricao that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricao deleteCursoInscricao(
		br.com.cnf.curso.inscricao.model.CursoInscricao cursoInscricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoLocalService.deleteCursoInscricao(cursoInscricao);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cursoInscricaoLocalService.dynamicQuery();
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
		return _cursoInscricaoLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _cursoInscricaoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _cursoInscricaoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricao fetchCursoInscricao(
		long inscricaoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoLocalService.fetchCursoInscricao(inscricaoId);
	}

	/**
	* Returns the curso inscricao with the primary key.
	*
	* @param inscricaoId the primary key of the curso inscricao
	* @return the curso inscricao
	* @throws PortalException if a curso inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricao getCursoInscricao(
		long inscricaoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoLocalService.getCursoInscricao(inscricaoId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricao> getCursoInscricaos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoLocalService.getCursoInscricaos(start, end);
	}

	/**
	* Returns the number of curso inscricaos.
	*
	* @return the number of curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCursoInscricaosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoLocalService.getCursoInscricaosCount();
	}

	/**
	* Updates the curso inscricao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cursoInscricao the curso inscricao
	* @return the curso inscricao that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.cnf.curso.inscricao.model.CursoInscricao updateCursoInscricao(
		br.com.cnf.curso.inscricao.model.CursoInscricao cursoInscricao)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoLocalService.updateCursoInscricao(cursoInscricao);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _cursoInscricaoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cursoInscricaoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cursoInscricaoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricao> search(
		java.lang.String statusMoedaDigital)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoInscricaoLocalService.search(statusMoedaDigital);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CursoInscricaoLocalService getWrappedCursoInscricaoLocalService() {
		return _cursoInscricaoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCursoInscricaoLocalService(
		CursoInscricaoLocalService cursoInscricaoLocalService) {
		_cursoInscricaoLocalService = cursoInscricaoLocalService;
	}

	@Override
	public CursoInscricaoLocalService getWrappedService() {
		return _cursoInscricaoLocalService;
	}

	@Override
	public void setWrappedService(
		CursoInscricaoLocalService cursoInscricaoLocalService) {
		_cursoInscricaoLocalService = cursoInscricaoLocalService;
	}

	private CursoInscricaoLocalService _cursoInscricaoLocalService;
}