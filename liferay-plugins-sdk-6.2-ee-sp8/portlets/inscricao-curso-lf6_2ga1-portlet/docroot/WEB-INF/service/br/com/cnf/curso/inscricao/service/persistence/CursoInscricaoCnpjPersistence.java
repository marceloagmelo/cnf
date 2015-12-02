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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the curso inscricao cnpj service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author SEA
 * @see CursoInscricaoCnpjPersistenceImpl
 * @see CursoInscricaoCnpjUtil
 * @generated
 */
public interface CursoInscricaoCnpjPersistence extends BasePersistence<CursoInscricaoCnpj> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CursoInscricaoCnpjUtil} to access the curso inscricao cnpj persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the curso inscricao cnpj in the entity cache if it is enabled.
	*
	* @param cursoInscricaoCnpj the curso inscricao cnpj
	*/
	public void cacheResult(
		br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj cursoInscricaoCnpj);

	/**
	* Caches the curso inscricao cnpjs in the entity cache if it is enabled.
	*
	* @param cursoInscricaoCnpjs the curso inscricao cnpjs
	*/
	public void cacheResult(
		java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj> cursoInscricaoCnpjs);

	/**
	* Creates a new curso inscricao cnpj with the primary key. Does not add the curso inscricao cnpj to the database.
	*
	* @param inscricaoCnpjId the primary key for the new curso inscricao cnpj
	* @return the new curso inscricao cnpj
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj create(
		long inscricaoCnpjId);

	/**
	* Removes the curso inscricao cnpj with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param inscricaoCnpjId the primary key of the curso inscricao cnpj
	* @return the curso inscricao cnpj that was removed
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCnpjException if a curso inscricao cnpj with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj remove(
		long inscricaoCnpjId)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCnpjException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj updateImpl(
		br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj cursoInscricaoCnpj)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the curso inscricao cnpj with the primary key or throws a {@link br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCnpjException} if it could not be found.
	*
	* @param inscricaoCnpjId the primary key of the curso inscricao cnpj
	* @return the curso inscricao cnpj
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCnpjException if a curso inscricao cnpj with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj findByPrimaryKey(
		long inscricaoCnpjId)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCnpjException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the curso inscricao cnpj with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param inscricaoCnpjId the primary key of the curso inscricao cnpj
	* @return the curso inscricao cnpj, or <code>null</code> if a curso inscricao cnpj with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj fetchByPrimaryKey(
		long inscricaoCnpjId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the curso inscricao cnpjs.
	*
	* @return the curso inscricao cnpjs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the curso inscricao cnpjs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of curso inscricao cnpjs.
	*
	* @return the number of curso inscricao cnpjs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}