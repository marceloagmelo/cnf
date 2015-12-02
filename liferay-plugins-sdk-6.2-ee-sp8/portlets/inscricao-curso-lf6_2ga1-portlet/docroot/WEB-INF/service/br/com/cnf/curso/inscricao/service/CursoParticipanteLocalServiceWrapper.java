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
 * Provides a wrapper for {@link CursoParticipanteLocalService}.
 *
 * @author SEA
 * @see CursoParticipanteLocalService
 * @generated
 */
public class CursoParticipanteLocalServiceWrapper
	implements CursoParticipanteLocalService,
		ServiceWrapper<CursoParticipanteLocalService> {
	public CursoParticipanteLocalServiceWrapper(
		CursoParticipanteLocalService cursoParticipanteLocalService) {
		_cursoParticipanteLocalService = cursoParticipanteLocalService;
	}

	/**
	* Adds the curso participante to the database. Also notifies the appropriate model listeners.
	*
	* @param cursoParticipante the curso participante
	* @return the curso participante that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.cnf.curso.inscricao.model.CursoParticipante addCursoParticipante(
		br.com.cnf.curso.inscricao.model.CursoParticipante cursoParticipante)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoParticipanteLocalService.addCursoParticipante(cursoParticipante);
	}

	/**
	* Creates a new curso participante with the primary key. Does not add the curso participante to the database.
	*
	* @param participanteId the primary key for the new curso participante
	* @return the new curso participante
	*/
	@Override
	public br.com.cnf.curso.inscricao.model.CursoParticipante createCursoParticipante(
		long participanteId) {
		return _cursoParticipanteLocalService.createCursoParticipante(participanteId);
	}

	/**
	* Deletes the curso participante with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param participanteId the primary key of the curso participante
	* @return the curso participante that was removed
	* @throws PortalException if a curso participante with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.cnf.curso.inscricao.model.CursoParticipante deleteCursoParticipante(
		long participanteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cursoParticipanteLocalService.deleteCursoParticipante(participanteId);
	}

	/**
	* Deletes the curso participante from the database. Also notifies the appropriate model listeners.
	*
	* @param cursoParticipante the curso participante
	* @return the curso participante that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.cnf.curso.inscricao.model.CursoParticipante deleteCursoParticipante(
		br.com.cnf.curso.inscricao.model.CursoParticipante cursoParticipante)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoParticipanteLocalService.deleteCursoParticipante(cursoParticipante);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cursoParticipanteLocalService.dynamicQuery();
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
		return _cursoParticipanteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoParticipanteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _cursoParticipanteLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoParticipanteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _cursoParticipanteLocalService.dynamicQuery(dynamicQuery, start,
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
		return _cursoParticipanteLocalService.dynamicQueryCount(dynamicQuery);
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
		return _cursoParticipanteLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public br.com.cnf.curso.inscricao.model.CursoParticipante fetchCursoParticipante(
		long participanteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoParticipanteLocalService.fetchCursoParticipante(participanteId);
	}

	/**
	* Returns the curso participante with the primary key.
	*
	* @param participanteId the primary key of the curso participante
	* @return the curso participante
	* @throws PortalException if a curso participante with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.cnf.curso.inscricao.model.CursoParticipante getCursoParticipante(
		long participanteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cursoParticipanteLocalService.getCursoParticipante(participanteId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cursoParticipanteLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoParticipante> getCursoParticipantes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoParticipanteLocalService.getCursoParticipantes(start, end);
	}

	/**
	* Returns the number of curso participantes.
	*
	* @return the number of curso participantes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCursoParticipantesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoParticipanteLocalService.getCursoParticipantesCount();
	}

	/**
	* Updates the curso participante in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cursoParticipante the curso participante
	* @return the curso participante that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public br.com.cnf.curso.inscricao.model.CursoParticipante updateCursoParticipante(
		br.com.cnf.curso.inscricao.model.CursoParticipante cursoParticipante)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cursoParticipanteLocalService.updateCursoParticipante(cursoParticipante);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _cursoParticipanteLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cursoParticipanteLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cursoParticipanteLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CursoParticipanteLocalService getWrappedCursoParticipanteLocalService() {
		return _cursoParticipanteLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCursoParticipanteLocalService(
		CursoParticipanteLocalService cursoParticipanteLocalService) {
		_cursoParticipanteLocalService = cursoParticipanteLocalService;
	}

	@Override
	public CursoParticipanteLocalService getWrappedService() {
		return _cursoParticipanteLocalService;
	}

	@Override
	public void setWrappedService(
		CursoParticipanteLocalService cursoParticipanteLocalService) {
		_cursoParticipanteLocalService = cursoParticipanteLocalService;
	}

	private CursoParticipanteLocalService _cursoParticipanteLocalService;
}