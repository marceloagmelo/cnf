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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the curso participante service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author SEA
 * @see CursoParticipantePersistenceImpl
 * @see CursoParticipanteUtil
 * @generated
 */
public interface CursoParticipantePersistence extends BasePersistence<CursoParticipante> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CursoParticipanteUtil} to access the curso participante persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the curso participante in the entity cache if it is enabled.
	*
	* @param cursoParticipante the curso participante
	*/
	public void cacheResult(
		br.com.cnf.curso.inscricao.model.CursoParticipante cursoParticipante);

	/**
	* Caches the curso participantes in the entity cache if it is enabled.
	*
	* @param cursoParticipantes the curso participantes
	*/
	public void cacheResult(
		java.util.List<br.com.cnf.curso.inscricao.model.CursoParticipante> cursoParticipantes);

	/**
	* Creates a new curso participante with the primary key. Does not add the curso participante to the database.
	*
	* @param participanteId the primary key for the new curso participante
	* @return the new curso participante
	*/
	public br.com.cnf.curso.inscricao.model.CursoParticipante create(
		long participanteId);

	/**
	* Removes the curso participante with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param participanteId the primary key of the curso participante
	* @return the curso participante that was removed
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoParticipanteException if a curso participante with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoParticipante remove(
		long participanteId)
		throws br.com.cnf.curso.inscricao.NoSuchCursoParticipanteException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.cnf.curso.inscricao.model.CursoParticipante updateImpl(
		br.com.cnf.curso.inscricao.model.CursoParticipante cursoParticipante)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the curso participante with the primary key or throws a {@link br.com.cnf.curso.inscricao.NoSuchCursoParticipanteException} if it could not be found.
	*
	* @param participanteId the primary key of the curso participante
	* @return the curso participante
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoParticipanteException if a curso participante with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoParticipante findByPrimaryKey(
		long participanteId)
		throws br.com.cnf.curso.inscricao.NoSuchCursoParticipanteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the curso participante with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param participanteId the primary key of the curso participante
	* @return the curso participante, or <code>null</code> if a curso participante with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoParticipante fetchByPrimaryKey(
		long participanteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the curso participantes.
	*
	* @return the curso participantes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoParticipante> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoParticipante> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoParticipante> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the curso participantes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of curso participantes.
	*
	* @return the number of curso participantes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}