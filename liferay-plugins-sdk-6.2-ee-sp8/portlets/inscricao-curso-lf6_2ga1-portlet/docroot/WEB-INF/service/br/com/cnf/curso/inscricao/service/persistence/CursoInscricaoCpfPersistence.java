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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the curso inscricao cpf service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author SEA
 * @see CursoInscricaoCpfPersistenceImpl
 * @see CursoInscricaoCpfUtil
 * @generated
 */
public interface CursoInscricaoCpfPersistence extends BasePersistence<CursoInscricaoCpf> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CursoInscricaoCpfUtil} to access the curso inscricao cpf persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the curso inscricao cpf in the entity cache if it is enabled.
	*
	* @param cursoInscricaoCpf the curso inscricao cpf
	*/
	public void cacheResult(
		br.com.cnf.curso.inscricao.model.CursoInscricaoCpf cursoInscricaoCpf);

	/**
	* Caches the curso inscricao cpfs in the entity cache if it is enabled.
	*
	* @param cursoInscricaoCpfs the curso inscricao cpfs
	*/
	public void cacheResult(
		java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricaoCpf> cursoInscricaoCpfs);

	/**
	* Creates a new curso inscricao cpf with the primary key. Does not add the curso inscricao cpf to the database.
	*
	* @param inscricaoCpfId the primary key for the new curso inscricao cpf
	* @return the new curso inscricao cpf
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricaoCpf create(
		long inscricaoCpfId);

	/**
	* Removes the curso inscricao cpf with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param inscricaoCpfId the primary key of the curso inscricao cpf
	* @return the curso inscricao cpf that was removed
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCpfException if a curso inscricao cpf with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricaoCpf remove(
		long inscricaoCpfId)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCpfException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.cnf.curso.inscricao.model.CursoInscricaoCpf updateImpl(
		br.com.cnf.curso.inscricao.model.CursoInscricaoCpf cursoInscricaoCpf)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the curso inscricao cpf with the primary key or throws a {@link br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCpfException} if it could not be found.
	*
	* @param inscricaoCpfId the primary key of the curso inscricao cpf
	* @return the curso inscricao cpf
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCpfException if a curso inscricao cpf with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricaoCpf findByPrimaryKey(
		long inscricaoCpfId)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCpfException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the curso inscricao cpf with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param inscricaoCpfId the primary key of the curso inscricao cpf
	* @return the curso inscricao cpf, or <code>null</code> if a curso inscricao cpf with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricaoCpf fetchByPrimaryKey(
		long inscricaoCpfId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the curso inscricao cpfs.
	*
	* @return the curso inscricao cpfs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricaoCpf> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricaoCpf> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricaoCpf> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the curso inscricao cpfs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of curso inscricao cpfs.
	*
	* @return the number of curso inscricao cpfs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}