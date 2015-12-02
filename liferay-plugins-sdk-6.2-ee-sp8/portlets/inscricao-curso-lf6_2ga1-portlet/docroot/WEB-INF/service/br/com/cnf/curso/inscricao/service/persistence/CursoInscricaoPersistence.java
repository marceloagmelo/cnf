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

import br.com.cnf.curso.inscricao.model.CursoInscricao;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the curso inscricao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author SEA
 * @see CursoInscricaoPersistenceImpl
 * @see CursoInscricaoUtil
 * @generated
 */
public interface CursoInscricaoPersistence extends BasePersistence<CursoInscricao> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CursoInscricaoUtil} to access the curso inscricao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the curso inscricaos where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricao> findByCompanyGroup(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the curso inscricaos where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of curso inscricaos
	* @param end the upper bound of the range of curso inscricaos (not inclusive)
	* @return the range of matching curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricao> findByCompanyGroup(
		long companyId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the curso inscricaos where companyId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param start the lower bound of the range of curso inscricaos
	* @param end the upper bound of the range of curso inscricaos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricao> findByCompanyGroup(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first curso inscricao in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching curso inscricao
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a matching curso inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao findByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first curso inscricao in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching curso inscricao, or <code>null</code> if a matching curso inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao fetchByCompanyGroup_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last curso inscricao in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching curso inscricao
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a matching curso inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao findByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last curso inscricao in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching curso inscricao, or <code>null</code> if a matching curso inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao fetchByCompanyGroup_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the curso inscricaos before and after the current curso inscricao in the ordered set where companyId = &#63; and groupId = &#63;.
	*
	* @param inscricaoId the primary key of the current curso inscricao
	* @param companyId the company ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next curso inscricao
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a curso inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao[] findByCompanyGroup_PrevAndNext(
		long inscricaoId, long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the curso inscricaos where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of curso inscricaos where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyGroup(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the curso inscricaos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricao> findByGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the curso inscricaos where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of curso inscricaos
	* @param end the upper bound of the range of curso inscricaos (not inclusive)
	* @return the range of matching curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricao> findByGroup(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the curso inscricaos where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of curso inscricaos
	* @param end the upper bound of the range of curso inscricaos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricao> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first curso inscricao in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching curso inscricao
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a matching curso inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao findByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first curso inscricao in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching curso inscricao, or <code>null</code> if a matching curso inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last curso inscricao in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching curso inscricao
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a matching curso inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao findByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last curso inscricao in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching curso inscricao, or <code>null</code> if a matching curso inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the curso inscricaos before and after the current curso inscricao in the ordered set where groupId = &#63;.
	*
	* @param inscricaoId the primary key of the current curso inscricao
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next curso inscricao
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a curso inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao[] findByGroup_PrevAndNext(
		long inscricaoId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the curso inscricaos where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of curso inscricaos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the curso inscricaos where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricao> findByCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the curso inscricaos where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of curso inscricaos
	* @param end the upper bound of the range of curso inscricaos (not inclusive)
	* @return the range of matching curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricao> findByCompany(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the curso inscricaos where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of curso inscricaos
	* @param end the upper bound of the range of curso inscricaos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricao> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first curso inscricao in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching curso inscricao
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a matching curso inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao findByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first curso inscricao in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching curso inscricao, or <code>null</code> if a matching curso inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last curso inscricao in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching curso inscricao
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a matching curso inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao findByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last curso inscricao in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching curso inscricao, or <code>null</code> if a matching curso inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the curso inscricaos before and after the current curso inscricao in the ordered set where companyId = &#63;.
	*
	* @param inscricaoId the primary key of the current curso inscricao
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next curso inscricao
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a curso inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao[] findByCompany_PrevAndNext(
		long inscricaoId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the curso inscricaos where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of curso inscricaos where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompany(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the curso inscricao where cpfCnpj = &#63; or throws a {@link br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException} if it could not be found.
	*
	* @param cpfCnpj the cpf cnpj
	* @return the matching curso inscricao
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a matching curso inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao findByCpfCnpj(
		java.lang.String cpfCnpj)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the curso inscricao where cpfCnpj = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cpfCnpj the cpf cnpj
	* @return the matching curso inscricao, or <code>null</code> if a matching curso inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao fetchByCpfCnpj(
		java.lang.String cpfCnpj)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the curso inscricao where cpfCnpj = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cpfCnpj the cpf cnpj
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching curso inscricao, or <code>null</code> if a matching curso inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao fetchByCpfCnpj(
		java.lang.String cpfCnpj, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the curso inscricao where cpfCnpj = &#63; from the database.
	*
	* @param cpfCnpj the cpf cnpj
	* @return the curso inscricao that was removed
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao removeByCpfCnpj(
		java.lang.String cpfCnpj)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of curso inscricaos where cpfCnpj = &#63;.
	*
	* @param cpfCnpj the cpf cnpj
	* @return the number of matching curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCpfCnpj(java.lang.String cpfCnpj)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the curso inscricaos where statusMoedaDigital LIKE &#63;.
	*
	* @param statusMoedaDigital the status moeda digital
	* @return the matching curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricao> findByLikeStatusMoedaDigital(
		java.lang.String statusMoedaDigital)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the curso inscricaos where statusMoedaDigital LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param statusMoedaDigital the status moeda digital
	* @param start the lower bound of the range of curso inscricaos
	* @param end the upper bound of the range of curso inscricaos (not inclusive)
	* @return the range of matching curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricao> findByLikeStatusMoedaDigital(
		java.lang.String statusMoedaDigital, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the curso inscricaos where statusMoedaDigital LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param statusMoedaDigital the status moeda digital
	* @param start the lower bound of the range of curso inscricaos
	* @param end the upper bound of the range of curso inscricaos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricao> findByLikeStatusMoedaDigital(
		java.lang.String statusMoedaDigital, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first curso inscricao in the ordered set where statusMoedaDigital LIKE &#63;.
	*
	* @param statusMoedaDigital the status moeda digital
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching curso inscricao
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a matching curso inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao findByLikeStatusMoedaDigital_First(
		java.lang.String statusMoedaDigital,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first curso inscricao in the ordered set where statusMoedaDigital LIKE &#63;.
	*
	* @param statusMoedaDigital the status moeda digital
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching curso inscricao, or <code>null</code> if a matching curso inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao fetchByLikeStatusMoedaDigital_First(
		java.lang.String statusMoedaDigital,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last curso inscricao in the ordered set where statusMoedaDigital LIKE &#63;.
	*
	* @param statusMoedaDigital the status moeda digital
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching curso inscricao
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a matching curso inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao findByLikeStatusMoedaDigital_Last(
		java.lang.String statusMoedaDigital,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last curso inscricao in the ordered set where statusMoedaDigital LIKE &#63;.
	*
	* @param statusMoedaDigital the status moeda digital
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching curso inscricao, or <code>null</code> if a matching curso inscricao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao fetchByLikeStatusMoedaDigital_Last(
		java.lang.String statusMoedaDigital,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the curso inscricaos before and after the current curso inscricao in the ordered set where statusMoedaDigital LIKE &#63;.
	*
	* @param inscricaoId the primary key of the current curso inscricao
	* @param statusMoedaDigital the status moeda digital
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next curso inscricao
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a curso inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao[] findByLikeStatusMoedaDigital_PrevAndNext(
		long inscricaoId, java.lang.String statusMoedaDigital,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the curso inscricaos where statusMoedaDigital LIKE &#63; from the database.
	*
	* @param statusMoedaDigital the status moeda digital
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLikeStatusMoedaDigital(
		java.lang.String statusMoedaDigital)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of curso inscricaos where statusMoedaDigital LIKE &#63;.
	*
	* @param statusMoedaDigital the status moeda digital
	* @return the number of matching curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public int countByLikeStatusMoedaDigital(
		java.lang.String statusMoedaDigital)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the curso inscricao in the entity cache if it is enabled.
	*
	* @param cursoInscricao the curso inscricao
	*/
	public void cacheResult(
		br.com.cnf.curso.inscricao.model.CursoInscricao cursoInscricao);

	/**
	* Caches the curso inscricaos in the entity cache if it is enabled.
	*
	* @param cursoInscricaos the curso inscricaos
	*/
	public void cacheResult(
		java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricao> cursoInscricaos);

	/**
	* Creates a new curso inscricao with the primary key. Does not add the curso inscricao to the database.
	*
	* @param inscricaoId the primary key for the new curso inscricao
	* @return the new curso inscricao
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao create(
		long inscricaoId);

	/**
	* Removes the curso inscricao with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param inscricaoId the primary key of the curso inscricao
	* @return the curso inscricao that was removed
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a curso inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao remove(
		long inscricaoId)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.cnf.curso.inscricao.model.CursoInscricao updateImpl(
		br.com.cnf.curso.inscricao.model.CursoInscricao cursoInscricao)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the curso inscricao with the primary key or throws a {@link br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException} if it could not be found.
	*
	* @param inscricaoId the primary key of the curso inscricao
	* @return the curso inscricao
	* @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a curso inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao findByPrimaryKey(
		long inscricaoId)
		throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the curso inscricao with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param inscricaoId the primary key of the curso inscricao
	* @return the curso inscricao, or <code>null</code> if a curso inscricao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.cnf.curso.inscricao.model.CursoInscricao fetchByPrimaryKey(
		long inscricaoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the curso inscricaos.
	*
	* @return the curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricao> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricao> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the curso inscricaos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of curso inscricaos
	* @param end the upper bound of the range of curso inscricaos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.cnf.curso.inscricao.model.CursoInscricao> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the curso inscricaos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of curso inscricaos.
	*
	* @return the number of curso inscricaos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}