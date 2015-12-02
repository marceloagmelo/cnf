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

import br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException;
import br.com.cnf.curso.inscricao.model.CursoInscricao;
import br.com.cnf.curso.inscricao.model.impl.CursoInscricaoImpl;
import br.com.cnf.curso.inscricao.model.impl.CursoInscricaoModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the curso inscricao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author SEA
 * @see CursoInscricaoPersistence
 * @see CursoInscricaoUtil
 * @generated
 */
public class CursoInscricaoPersistenceImpl extends BasePersistenceImpl<CursoInscricao>
	implements CursoInscricaoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CursoInscricaoUtil} to access the curso inscricao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CursoInscricaoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			CursoInscricaoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			CursoInscricaoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			CursoInscricaoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP =
		new FinderPath(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			CursoInscricaoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			CursoInscricaoModelImpl.COMPANYID_COLUMN_BITMASK |
			CursoInscricaoModelImpl.GROUPID_COLUMN_BITMASK |
			CursoInscricaoModelImpl.CURSONOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYGROUP = new FinderPath(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the curso inscricaos where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching curso inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CursoInscricao> findByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		return findByCompanyGroup(companyId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CursoInscricao> findByCompanyGroup(long companyId,
		long groupId, int start, int end) throws SystemException {
		return findByCompanyGroup(companyId, groupId, start, end, null);
	}

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
	@Override
	public List<CursoInscricao> findByCompanyGroup(long companyId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP;
			finderArgs = new Object[] { companyId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYGROUP;
			finderArgs = new Object[] {
					companyId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<CursoInscricao> list = (List<CursoInscricao>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CursoInscricao cursoInscricao : list) {
				if ((companyId != cursoInscricao.getCompanyId()) ||
						(groupId != cursoInscricao.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CURSOINSCRICAO_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CursoInscricaoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<CursoInscricao>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CursoInscricao>(list);
				}
				else {
					list = (List<CursoInscricao>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

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
	@Override
	public CursoInscricao findByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCursoInscricaoException, SystemException {
		CursoInscricao cursoInscricao = fetchByCompanyGroup_First(companyId,
				groupId, orderByComparator);

		if (cursoInscricao != null) {
			return cursoInscricao;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCursoInscricaoException(msg.toString());
	}

	/**
	 * Returns the first curso inscricao in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching curso inscricao, or <code>null</code> if a matching curso inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao fetchByCompanyGroup_First(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CursoInscricao> list = findByCompanyGroup(companyId, groupId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public CursoInscricao findByCompanyGroup_Last(long companyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCursoInscricaoException, SystemException {
		CursoInscricao cursoInscricao = fetchByCompanyGroup_Last(companyId,
				groupId, orderByComparator);

		if (cursoInscricao != null) {
			return cursoInscricao;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCursoInscricaoException(msg.toString());
	}

	/**
	 * Returns the last curso inscricao in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching curso inscricao, or <code>null</code> if a matching curso inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao fetchByCompanyGroup_Last(long companyId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCompanyGroup(companyId, groupId);

		if (count == 0) {
			return null;
		}

		List<CursoInscricao> list = findByCompanyGroup(companyId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public CursoInscricao[] findByCompanyGroup_PrevAndNext(long inscricaoId,
		long companyId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchCursoInscricaoException, SystemException {
		CursoInscricao cursoInscricao = findByPrimaryKey(inscricaoId);

		Session session = null;

		try {
			session = openSession();

			CursoInscricao[] array = new CursoInscricaoImpl[3];

			array[0] = getByCompanyGroup_PrevAndNext(session, cursoInscricao,
					companyId, groupId, orderByComparator, true);

			array[1] = cursoInscricao;

			array[2] = getByCompanyGroup_PrevAndNext(session, cursoInscricao,
					companyId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CursoInscricao getByCompanyGroup_PrevAndNext(Session session,
		CursoInscricao cursoInscricao, long companyId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CURSOINSCRICAO_WHERE);

		query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CursoInscricaoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cursoInscricao);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CursoInscricao> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the curso inscricaos where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		for (CursoInscricao cursoInscricao : findByCompanyGroup(companyId,
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(cursoInscricao);
		}
	}

	/**
	 * Returns the number of curso inscricaos where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching curso inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyGroup(long companyId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYGROUP;

		Object[] finderArgs = new Object[] { companyId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CURSOINSCRICAO_WHERE);

			query.append(_FINDER_COLUMN_COMPANYGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYGROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYGROUP_COMPANYID_2 = "cursoInscricao.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYGROUP_GROUPID_2 = "cursoInscricao.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP = new FinderPath(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			CursoInscricaoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP = new FinderPath(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			CursoInscricaoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] { Long.class.getName() },
			CursoInscricaoModelImpl.GROUPID_COLUMN_BITMASK |
			CursoInscricaoModelImpl.CURSONOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP = new FinderPath(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the curso inscricaos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching curso inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CursoInscricao> findByGroup(long groupId)
		throws SystemException {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CursoInscricao> findByGroup(long groupId, int start, int end)
		throws SystemException {
		return findByGroup(groupId, start, end, null);
	}

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
	@Override
	public List<CursoInscricao> findByGroup(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<CursoInscricao> list = (List<CursoInscricao>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CursoInscricao cursoInscricao : list) {
				if ((groupId != cursoInscricao.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CURSOINSCRICAO_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CursoInscricaoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<CursoInscricao>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CursoInscricao>(list);
				}
				else {
					list = (List<CursoInscricao>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first curso inscricao in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching curso inscricao
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a matching curso inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao findByGroup_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCursoInscricaoException, SystemException {
		CursoInscricao cursoInscricao = fetchByGroup_First(groupId,
				orderByComparator);

		if (cursoInscricao != null) {
			return cursoInscricao;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCursoInscricaoException(msg.toString());
	}

	/**
	 * Returns the first curso inscricao in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching curso inscricao, or <code>null</code> if a matching curso inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao fetchByGroup_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CursoInscricao> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last curso inscricao in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching curso inscricao
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a matching curso inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao findByGroup_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCursoInscricaoException, SystemException {
		CursoInscricao cursoInscricao = fetchByGroup_Last(groupId,
				orderByComparator);

		if (cursoInscricao != null) {
			return cursoInscricao;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCursoInscricaoException(msg.toString());
	}

	/**
	 * Returns the last curso inscricao in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching curso inscricao, or <code>null</code> if a matching curso inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao fetchByGroup_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<CursoInscricao> list = findByGroup(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public CursoInscricao[] findByGroup_PrevAndNext(long inscricaoId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCursoInscricaoException, SystemException {
		CursoInscricao cursoInscricao = findByPrimaryKey(inscricaoId);

		Session session = null;

		try {
			session = openSession();

			CursoInscricao[] array = new CursoInscricaoImpl[3];

			array[0] = getByGroup_PrevAndNext(session, cursoInscricao, groupId,
					orderByComparator, true);

			array[1] = cursoInscricao;

			array[2] = getByGroup_PrevAndNext(session, cursoInscricao, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CursoInscricao getByGroup_PrevAndNext(Session session,
		CursoInscricao cursoInscricao, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CURSOINSCRICAO_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CursoInscricaoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cursoInscricao);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CursoInscricao> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the curso inscricaos where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroup(long groupId) throws SystemException {
		for (CursoInscricao cursoInscricao : findByGroup(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(cursoInscricao);
		}
	}

	/**
	 * Returns the number of curso inscricaos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching curso inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroup(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUP;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CURSOINSCRICAO_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 = "cursoInscricao.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY = new FinderPath(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			CursoInscricaoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompany",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY =
		new FinderPath(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			CursoInscricaoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] { Long.class.getName() },
			CursoInscricaoModelImpl.COMPANYID_COLUMN_BITMASK |
			CursoInscricaoModelImpl.CURSONOME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANY = new FinderPath(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the curso inscricaos where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching curso inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CursoInscricao> findByCompany(long companyId)
		throws SystemException {
		return findByCompany(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<CursoInscricao> findByCompany(long companyId, int start, int end)
		throws SystemException {
		return findByCompany(companyId, start, end, null);
	}

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
	@Override
	public List<CursoInscricao> findByCompany(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANY;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<CursoInscricao> list = (List<CursoInscricao>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CursoInscricao cursoInscricao : list) {
				if ((companyId != cursoInscricao.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CURSOINSCRICAO_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CursoInscricaoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<CursoInscricao>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CursoInscricao>(list);
				}
				else {
					list = (List<CursoInscricao>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first curso inscricao in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching curso inscricao
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a matching curso inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao findByCompany_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCursoInscricaoException, SystemException {
		CursoInscricao cursoInscricao = fetchByCompany_First(companyId,
				orderByComparator);

		if (cursoInscricao != null) {
			return cursoInscricao;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCursoInscricaoException(msg.toString());
	}

	/**
	 * Returns the first curso inscricao in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching curso inscricao, or <code>null</code> if a matching curso inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao fetchByCompany_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CursoInscricao> list = findByCompany(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last curso inscricao in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching curso inscricao
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a matching curso inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao findByCompany_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCursoInscricaoException, SystemException {
		CursoInscricao cursoInscricao = fetchByCompany_Last(companyId,
				orderByComparator);

		if (cursoInscricao != null) {
			return cursoInscricao;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCursoInscricaoException(msg.toString());
	}

	/**
	 * Returns the last curso inscricao in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching curso inscricao, or <code>null</code> if a matching curso inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao fetchByCompany_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<CursoInscricao> list = findByCompany(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public CursoInscricao[] findByCompany_PrevAndNext(long inscricaoId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchCursoInscricaoException, SystemException {
		CursoInscricao cursoInscricao = findByPrimaryKey(inscricaoId);

		Session session = null;

		try {
			session = openSession();

			CursoInscricao[] array = new CursoInscricaoImpl[3];

			array[0] = getByCompany_PrevAndNext(session, cursoInscricao,
					companyId, orderByComparator, true);

			array[1] = cursoInscricao;

			array[2] = getByCompany_PrevAndNext(session, cursoInscricao,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CursoInscricao getByCompany_PrevAndNext(Session session,
		CursoInscricao cursoInscricao, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CURSOINSCRICAO_WHERE);

		query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CursoInscricaoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cursoInscricao);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CursoInscricao> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the curso inscricaos where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompany(long companyId) throws SystemException {
		for (CursoInscricao cursoInscricao : findByCompany(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(cursoInscricao);
		}
	}

	/**
	 * Returns the number of curso inscricaos where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching curso inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompany(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANY;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CURSOINSCRICAO_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 = "cursoInscricao.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CPFCNPJ = new FinderPath(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			CursoInscricaoImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCpfCnpj", new String[] { String.class.getName() },
			CursoInscricaoModelImpl.CPFCNPJ_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CPFCNPJ = new FinderPath(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCpfCnpj",
			new String[] { String.class.getName() });

	/**
	 * Returns the curso inscricao where cpfCnpj = &#63; or throws a {@link br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException} if it could not be found.
	 *
	 * @param cpfCnpj the cpf cnpj
	 * @return the matching curso inscricao
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a matching curso inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao findByCpfCnpj(String cpfCnpj)
		throws NoSuchCursoInscricaoException, SystemException {
		CursoInscricao cursoInscricao = fetchByCpfCnpj(cpfCnpj);

		if (cursoInscricao == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cpfCnpj=");
			msg.append(cpfCnpj);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCursoInscricaoException(msg.toString());
		}

		return cursoInscricao;
	}

	/**
	 * Returns the curso inscricao where cpfCnpj = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cpfCnpj the cpf cnpj
	 * @return the matching curso inscricao, or <code>null</code> if a matching curso inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao fetchByCpfCnpj(String cpfCnpj)
		throws SystemException {
		return fetchByCpfCnpj(cpfCnpj, true);
	}

	/**
	 * Returns the curso inscricao where cpfCnpj = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cpfCnpj the cpf cnpj
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching curso inscricao, or <code>null</code> if a matching curso inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao fetchByCpfCnpj(String cpfCnpj,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { cpfCnpj };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CPFCNPJ,
					finderArgs, this);
		}

		if (result instanceof CursoInscricao) {
			CursoInscricao cursoInscricao = (CursoInscricao)result;

			if (!Validator.equals(cpfCnpj, cursoInscricao.getCpfCnpj())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CURSOINSCRICAO_WHERE);

			boolean bindCpfCnpj = false;

			if (cpfCnpj == null) {
				query.append(_FINDER_COLUMN_CPFCNPJ_CPFCNPJ_1);
			}
			else if (cpfCnpj.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CPFCNPJ_CPFCNPJ_3);
			}
			else {
				bindCpfCnpj = true;

				query.append(_FINDER_COLUMN_CPFCNPJ_CPFCNPJ_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCpfCnpj) {
					qPos.add(cpfCnpj);
				}

				List<CursoInscricao> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CPFCNPJ,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CursoInscricaoPersistenceImpl.fetchByCpfCnpj(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CursoInscricao cursoInscricao = list.get(0);

					result = cursoInscricao;

					cacheResult(cursoInscricao);

					if ((cursoInscricao.getCpfCnpj() == null) ||
							!cursoInscricao.getCpfCnpj().equals(cpfCnpj)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CPFCNPJ,
							finderArgs, cursoInscricao);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CPFCNPJ,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CursoInscricao)result;
		}
	}

	/**
	 * Removes the curso inscricao where cpfCnpj = &#63; from the database.
	 *
	 * @param cpfCnpj the cpf cnpj
	 * @return the curso inscricao that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao removeByCpfCnpj(String cpfCnpj)
		throws NoSuchCursoInscricaoException, SystemException {
		CursoInscricao cursoInscricao = findByCpfCnpj(cpfCnpj);

		return remove(cursoInscricao);
	}

	/**
	 * Returns the number of curso inscricaos where cpfCnpj = &#63;.
	 *
	 * @param cpfCnpj the cpf cnpj
	 * @return the number of matching curso inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCpfCnpj(String cpfCnpj) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CPFCNPJ;

		Object[] finderArgs = new Object[] { cpfCnpj };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CURSOINSCRICAO_WHERE);

			boolean bindCpfCnpj = false;

			if (cpfCnpj == null) {
				query.append(_FINDER_COLUMN_CPFCNPJ_CPFCNPJ_1);
			}
			else if (cpfCnpj.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CPFCNPJ_CPFCNPJ_3);
			}
			else {
				bindCpfCnpj = true;

				query.append(_FINDER_COLUMN_CPFCNPJ_CPFCNPJ_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCpfCnpj) {
					qPos.add(cpfCnpj);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CPFCNPJ_CPFCNPJ_1 = "cursoInscricao.cpfCnpj IS NULL";
	private static final String _FINDER_COLUMN_CPFCNPJ_CPFCNPJ_2 = "cursoInscricao.cpfCnpj = ?";
	private static final String _FINDER_COLUMN_CPFCNPJ_CPFCNPJ_3 = "(cursoInscricao.cpfCnpj IS NULL OR cursoInscricao.cpfCnpj = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIKESTATUSMOEDADIGITAL =
		new FinderPath(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoModelImpl.FINDER_CACHE_ENABLED,
			CursoInscricaoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLikeStatusMoedaDigital",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_LIKESTATUSMOEDADIGITAL =
		new FinderPath(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByLikeStatusMoedaDigital",
			new String[] { String.class.getName() });

	/**
	 * Returns all the curso inscricaos where statusMoedaDigital LIKE &#63;.
	 *
	 * @param statusMoedaDigital the status moeda digital
	 * @return the matching curso inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CursoInscricao> findByLikeStatusMoedaDigital(
		String statusMoedaDigital) throws SystemException {
		return findByLikeStatusMoedaDigital(statusMoedaDigital,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CursoInscricao> findByLikeStatusMoedaDigital(
		String statusMoedaDigital, int start, int end)
		throws SystemException {
		return findByLikeStatusMoedaDigital(statusMoedaDigital, start, end, null);
	}

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
	@Override
	public List<CursoInscricao> findByLikeStatusMoedaDigital(
		String statusMoedaDigital, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LIKESTATUSMOEDADIGITAL;
		finderArgs = new Object[] {
				statusMoedaDigital,
				
				start, end, orderByComparator
			};

		List<CursoInscricao> list = (List<CursoInscricao>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CursoInscricao cursoInscricao : list) {
				if (!StringUtil.wildcardMatches(
							cursoInscricao.getStatusMoedaDigital(),
							statusMoedaDigital, CharPool.UNDERLINE,
							CharPool.PERCENT, CharPool.BACK_SLASH, true)) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CURSOINSCRICAO_WHERE);

			boolean bindStatusMoedaDigital = false;

			if (statusMoedaDigital == null) {
				query.append(_FINDER_COLUMN_LIKESTATUSMOEDADIGITAL_STATUSMOEDADIGITAL_1);
			}
			else if (statusMoedaDigital.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LIKESTATUSMOEDADIGITAL_STATUSMOEDADIGITAL_3);
			}
			else {
				bindStatusMoedaDigital = true;

				query.append(_FINDER_COLUMN_LIKESTATUSMOEDADIGITAL_STATUSMOEDADIGITAL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CursoInscricaoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatusMoedaDigital) {
					qPos.add(statusMoedaDigital);
				}

				if (!pagination) {
					list = (List<CursoInscricao>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CursoInscricao>(list);
				}
				else {
					list = (List<CursoInscricao>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first curso inscricao in the ordered set where statusMoedaDigital LIKE &#63;.
	 *
	 * @param statusMoedaDigital the status moeda digital
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching curso inscricao
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a matching curso inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao findByLikeStatusMoedaDigital_First(
		String statusMoedaDigital, OrderByComparator orderByComparator)
		throws NoSuchCursoInscricaoException, SystemException {
		CursoInscricao cursoInscricao = fetchByLikeStatusMoedaDigital_First(statusMoedaDigital,
				orderByComparator);

		if (cursoInscricao != null) {
			return cursoInscricao;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusMoedaDigital=");
		msg.append(statusMoedaDigital);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCursoInscricaoException(msg.toString());
	}

	/**
	 * Returns the first curso inscricao in the ordered set where statusMoedaDigital LIKE &#63;.
	 *
	 * @param statusMoedaDigital the status moeda digital
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching curso inscricao, or <code>null</code> if a matching curso inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao fetchByLikeStatusMoedaDigital_First(
		String statusMoedaDigital, OrderByComparator orderByComparator)
		throws SystemException {
		List<CursoInscricao> list = findByLikeStatusMoedaDigital(statusMoedaDigital,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last curso inscricao in the ordered set where statusMoedaDigital LIKE &#63;.
	 *
	 * @param statusMoedaDigital the status moeda digital
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching curso inscricao
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a matching curso inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao findByLikeStatusMoedaDigital_Last(
		String statusMoedaDigital, OrderByComparator orderByComparator)
		throws NoSuchCursoInscricaoException, SystemException {
		CursoInscricao cursoInscricao = fetchByLikeStatusMoedaDigital_Last(statusMoedaDigital,
				orderByComparator);

		if (cursoInscricao != null) {
			return cursoInscricao;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusMoedaDigital=");
		msg.append(statusMoedaDigital);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCursoInscricaoException(msg.toString());
	}

	/**
	 * Returns the last curso inscricao in the ordered set where statusMoedaDigital LIKE &#63;.
	 *
	 * @param statusMoedaDigital the status moeda digital
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching curso inscricao, or <code>null</code> if a matching curso inscricao could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao fetchByLikeStatusMoedaDigital_Last(
		String statusMoedaDigital, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByLikeStatusMoedaDigital(statusMoedaDigital);

		if (count == 0) {
			return null;
		}

		List<CursoInscricao> list = findByLikeStatusMoedaDigital(statusMoedaDigital,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public CursoInscricao[] findByLikeStatusMoedaDigital_PrevAndNext(
		long inscricaoId, String statusMoedaDigital,
		OrderByComparator orderByComparator)
		throws NoSuchCursoInscricaoException, SystemException {
		CursoInscricao cursoInscricao = findByPrimaryKey(inscricaoId);

		Session session = null;

		try {
			session = openSession();

			CursoInscricao[] array = new CursoInscricaoImpl[3];

			array[0] = getByLikeStatusMoedaDigital_PrevAndNext(session,
					cursoInscricao, statusMoedaDigital, orderByComparator, true);

			array[1] = cursoInscricao;

			array[2] = getByLikeStatusMoedaDigital_PrevAndNext(session,
					cursoInscricao, statusMoedaDigital, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CursoInscricao getByLikeStatusMoedaDigital_PrevAndNext(
		Session session, CursoInscricao cursoInscricao,
		String statusMoedaDigital, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CURSOINSCRICAO_WHERE);

		boolean bindStatusMoedaDigital = false;

		if (statusMoedaDigital == null) {
			query.append(_FINDER_COLUMN_LIKESTATUSMOEDADIGITAL_STATUSMOEDADIGITAL_1);
		}
		else if (statusMoedaDigital.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LIKESTATUSMOEDADIGITAL_STATUSMOEDADIGITAL_3);
		}
		else {
			bindStatusMoedaDigital = true;

			query.append(_FINDER_COLUMN_LIKESTATUSMOEDADIGITAL_STATUSMOEDADIGITAL_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CursoInscricaoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStatusMoedaDigital) {
			qPos.add(statusMoedaDigital);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cursoInscricao);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CursoInscricao> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the curso inscricaos where statusMoedaDigital LIKE &#63; from the database.
	 *
	 * @param statusMoedaDigital the status moeda digital
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLikeStatusMoedaDigital(String statusMoedaDigital)
		throws SystemException {
		for (CursoInscricao cursoInscricao : findByLikeStatusMoedaDigital(
				statusMoedaDigital, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(cursoInscricao);
		}
	}

	/**
	 * Returns the number of curso inscricaos where statusMoedaDigital LIKE &#63;.
	 *
	 * @param statusMoedaDigital the status moeda digital
	 * @return the number of matching curso inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLikeStatusMoedaDigital(String statusMoedaDigital)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_LIKESTATUSMOEDADIGITAL;

		Object[] finderArgs = new Object[] { statusMoedaDigital };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CURSOINSCRICAO_WHERE);

			boolean bindStatusMoedaDigital = false;

			if (statusMoedaDigital == null) {
				query.append(_FINDER_COLUMN_LIKESTATUSMOEDADIGITAL_STATUSMOEDADIGITAL_1);
			}
			else if (statusMoedaDigital.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LIKESTATUSMOEDADIGITAL_STATUSMOEDADIGITAL_3);
			}
			else {
				bindStatusMoedaDigital = true;

				query.append(_FINDER_COLUMN_LIKESTATUSMOEDADIGITAL_STATUSMOEDADIGITAL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatusMoedaDigital) {
					qPos.add(statusMoedaDigital);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LIKESTATUSMOEDADIGITAL_STATUSMOEDADIGITAL_1 =
		"cursoInscricao.statusMoedaDigital LIKE NULL";
	private static final String _FINDER_COLUMN_LIKESTATUSMOEDADIGITAL_STATUSMOEDADIGITAL_2 =
		"cursoInscricao.statusMoedaDigital LIKE ?";
	private static final String _FINDER_COLUMN_LIKESTATUSMOEDADIGITAL_STATUSMOEDADIGITAL_3 =
		"(cursoInscricao.statusMoedaDigital IS NULL OR cursoInscricao.statusMoedaDigital LIKE '')";

	public CursoInscricaoPersistenceImpl() {
		setModelClass(CursoInscricao.class);
	}

	/**
	 * Caches the curso inscricao in the entity cache if it is enabled.
	 *
	 * @param cursoInscricao the curso inscricao
	 */
	@Override
	public void cacheResult(CursoInscricao cursoInscricao) {
		EntityCacheUtil.putResult(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoImpl.class, cursoInscricao.getPrimaryKey(),
			cursoInscricao);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CPFCNPJ,
			new Object[] { cursoInscricao.getCpfCnpj() }, cursoInscricao);

		cursoInscricao.resetOriginalValues();
	}

	/**
	 * Caches the curso inscricaos in the entity cache if it is enabled.
	 *
	 * @param cursoInscricaos the curso inscricaos
	 */
	@Override
	public void cacheResult(List<CursoInscricao> cursoInscricaos) {
		for (CursoInscricao cursoInscricao : cursoInscricaos) {
			if (EntityCacheUtil.getResult(
						CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
						CursoInscricaoImpl.class, cursoInscricao.getPrimaryKey()) == null) {
				cacheResult(cursoInscricao);
			}
			else {
				cursoInscricao.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all curso inscricaos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CursoInscricaoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CursoInscricaoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the curso inscricao.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CursoInscricao cursoInscricao) {
		EntityCacheUtil.removeResult(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoImpl.class, cursoInscricao.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(cursoInscricao);
	}

	@Override
	public void clearCache(List<CursoInscricao> cursoInscricaos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CursoInscricao cursoInscricao : cursoInscricaos) {
			EntityCacheUtil.removeResult(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
				CursoInscricaoImpl.class, cursoInscricao.getPrimaryKey());

			clearUniqueFindersCache(cursoInscricao);
		}
	}

	protected void cacheUniqueFindersCache(CursoInscricao cursoInscricao) {
		if (cursoInscricao.isNew()) {
			Object[] args = new Object[] { cursoInscricao.getCpfCnpj() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CPFCNPJ, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CPFCNPJ, args,
				cursoInscricao);
		}
		else {
			CursoInscricaoModelImpl cursoInscricaoModelImpl = (CursoInscricaoModelImpl)cursoInscricao;

			if ((cursoInscricaoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CPFCNPJ.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { cursoInscricao.getCpfCnpj() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CPFCNPJ, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CPFCNPJ, args,
					cursoInscricao);
			}
		}
	}

	protected void clearUniqueFindersCache(CursoInscricao cursoInscricao) {
		CursoInscricaoModelImpl cursoInscricaoModelImpl = (CursoInscricaoModelImpl)cursoInscricao;

		Object[] args = new Object[] { cursoInscricao.getCpfCnpj() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CPFCNPJ, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CPFCNPJ, args);

		if ((cursoInscricaoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CPFCNPJ.getColumnBitmask()) != 0) {
			args = new Object[] { cursoInscricaoModelImpl.getOriginalCpfCnpj() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CPFCNPJ, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CPFCNPJ, args);
		}
	}

	/**
	 * Creates a new curso inscricao with the primary key. Does not add the curso inscricao to the database.
	 *
	 * @param inscricaoId the primary key for the new curso inscricao
	 * @return the new curso inscricao
	 */
	@Override
	public CursoInscricao create(long inscricaoId) {
		CursoInscricao cursoInscricao = new CursoInscricaoImpl();

		cursoInscricao.setNew(true);
		cursoInscricao.setPrimaryKey(inscricaoId);

		return cursoInscricao;
	}

	/**
	 * Removes the curso inscricao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param inscricaoId the primary key of the curso inscricao
	 * @return the curso inscricao that was removed
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a curso inscricao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao remove(long inscricaoId)
		throws NoSuchCursoInscricaoException, SystemException {
		return remove((Serializable)inscricaoId);
	}

	/**
	 * Removes the curso inscricao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the curso inscricao
	 * @return the curso inscricao that was removed
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a curso inscricao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao remove(Serializable primaryKey)
		throws NoSuchCursoInscricaoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CursoInscricao cursoInscricao = (CursoInscricao)session.get(CursoInscricaoImpl.class,
					primaryKey);

			if (cursoInscricao == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCursoInscricaoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cursoInscricao);
		}
		catch (NoSuchCursoInscricaoException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CursoInscricao removeImpl(CursoInscricao cursoInscricao)
		throws SystemException {
		cursoInscricao = toUnwrappedModel(cursoInscricao);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cursoInscricao)) {
				cursoInscricao = (CursoInscricao)session.get(CursoInscricaoImpl.class,
						cursoInscricao.getPrimaryKeyObj());
			}

			if (cursoInscricao != null) {
				session.delete(cursoInscricao);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cursoInscricao != null) {
			clearCache(cursoInscricao);
		}

		return cursoInscricao;
	}

	@Override
	public CursoInscricao updateImpl(
		br.com.cnf.curso.inscricao.model.CursoInscricao cursoInscricao)
		throws SystemException {
		cursoInscricao = toUnwrappedModel(cursoInscricao);

		boolean isNew = cursoInscricao.isNew();

		CursoInscricaoModelImpl cursoInscricaoModelImpl = (CursoInscricaoModelImpl)cursoInscricao;

		Session session = null;

		try {
			session = openSession();

			if (cursoInscricao.isNew()) {
				session.save(cursoInscricao);

				cursoInscricao.setNew(false);
			}
			else {
				session.merge(cursoInscricao);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CursoInscricaoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((cursoInscricaoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cursoInscricaoModelImpl.getOriginalCompanyId(),
						cursoInscricaoModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);

				args = new Object[] {
						cursoInscricaoModelImpl.getCompanyId(),
						cursoInscricaoModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYGROUP,
					args);
			}

			if ((cursoInscricaoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cursoInscricaoModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);

				args = new Object[] { cursoInscricaoModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP,
					args);
			}

			if ((cursoInscricaoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cursoInscricaoModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);

				args = new Object[] { cursoInscricaoModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANY,
					args);
			}
		}

		EntityCacheUtil.putResult(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoImpl.class, cursoInscricao.getPrimaryKey(),
			cursoInscricao);

		clearUniqueFindersCache(cursoInscricao);
		cacheUniqueFindersCache(cursoInscricao);

		return cursoInscricao;
	}

	protected CursoInscricao toUnwrappedModel(CursoInscricao cursoInscricao) {
		if (cursoInscricao instanceof CursoInscricaoImpl) {
			return cursoInscricao;
		}

		CursoInscricaoImpl cursoInscricaoImpl = new CursoInscricaoImpl();

		cursoInscricaoImpl.setNew(cursoInscricao.isNew());
		cursoInscricaoImpl.setPrimaryKey(cursoInscricao.getPrimaryKey());

		cursoInscricaoImpl.setInscricaoId(cursoInscricao.getInscricaoId());
		cursoInscricaoImpl.setCompanyId(cursoInscricao.getCompanyId());
		cursoInscricaoImpl.setGroupId(cursoInscricao.getGroupId());
		cursoInscricaoImpl.setUserCreateId(cursoInscricao.getUserCreateId());
		cursoInscricaoImpl.setUserCreateName(cursoInscricao.getUserCreateName());
		cursoInscricaoImpl.setUserModifiedId(cursoInscricao.getUserModifiedId());
		cursoInscricaoImpl.setUserModifiedName(cursoInscricao.getUserModifiedName());
		cursoInscricaoImpl.setCreateDate(cursoInscricao.getCreateDate());
		cursoInscricaoImpl.setModifiedDate(cursoInscricao.getModifiedDate());
		cursoInscricaoImpl.setCursoId(cursoInscricao.getCursoId());
		cursoInscricaoImpl.setCursoNome(cursoInscricao.getCursoNome());
		cursoInscricaoImpl.setCursoData(cursoInscricao.getCursoData());
		cursoInscricaoImpl.setCursoHorario(cursoInscricao.getCursoHorario());
		cursoInscricaoImpl.setCursoLocal(cursoInscricao.getCursoLocal());
		cursoInscricaoImpl.setPreco(cursoInscricao.getPreco());
		cursoInscricaoImpl.setPrecoConvenio(cursoInscricao.getPrecoConvenio());
		cursoInscricaoImpl.setPrecoAssociado(cursoInscricao.getPrecoAssociado());
		cursoInscricaoImpl.setTipoFisicaJuridica(cursoInscricao.getTipoFisicaJuridica());
		cursoInscricaoImpl.setCpfCnpj(cursoInscricao.getCpfCnpj());
		cursoInscricaoImpl.setNomeResponsavel(cursoInscricao.getNomeResponsavel());
		cursoInscricaoImpl.setEmailPrincipal(cursoInscricao.getEmailPrincipal());
		cursoInscricaoImpl.setDddTelefoneComercial(cursoInscricao.getDddTelefoneComercial());
		cursoInscricaoImpl.setTelefoneComercial(cursoInscricao.getTelefoneComercial());
		cursoInscricaoImpl.setSexo(cursoInscricao.getSexo());
		cursoInscricaoImpl.setCadastroFinalizado(cursoInscricao.isCadastroFinalizado());
		cursoInscricaoImpl.setFormaPagamento(cursoInscricao.getFormaPagamento());
		cursoInscricaoImpl.setNumeroCartao(cursoInscricao.getNumeroCartao());
		cursoInscricaoImpl.setValidadeCartaoMes(cursoInscricao.getValidadeCartaoMes());
		cursoInscricaoImpl.setValidadeCartaoAno(cursoInscricao.getValidadeCartaoAno());
		cursoInscricaoImpl.setNomeTitularCartao(cursoInscricao.getNomeTitularCartao());
		cursoInscricaoImpl.setCodigoSegurancaCartao(cursoInscricao.getCodigoSegurancaCartao());
		cursoInscricaoImpl.setStatusMoedaDigital(cursoInscricao.getStatusMoedaDigital());
		cursoInscricaoImpl.setQuantidadeParcelas(cursoInscricao.getQuantidadeParcelas());
		cursoInscricaoImpl.setValorTotal(cursoInscricao.getValorTotal());
		cursoInscricaoImpl.setMoedaDigitalPedido(cursoInscricao.getMoedaDigitalPedido());
		cursoInscricaoImpl.setDataInicio(cursoInscricao.getDataInicio());

		return cursoInscricaoImpl;
	}

	/**
	 * Returns the curso inscricao with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the curso inscricao
	 * @return the curso inscricao
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a curso inscricao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCursoInscricaoException, SystemException {
		CursoInscricao cursoInscricao = fetchByPrimaryKey(primaryKey);

		if (cursoInscricao == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCursoInscricaoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cursoInscricao;
	}

	/**
	 * Returns the curso inscricao with the primary key or throws a {@link br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException} if it could not be found.
	 *
	 * @param inscricaoId the primary key of the curso inscricao
	 * @return the curso inscricao
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException if a curso inscricao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao findByPrimaryKey(long inscricaoId)
		throws NoSuchCursoInscricaoException, SystemException {
		return findByPrimaryKey((Serializable)inscricaoId);
	}

	/**
	 * Returns the curso inscricao with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the curso inscricao
	 * @return the curso inscricao, or <code>null</code> if a curso inscricao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CursoInscricao cursoInscricao = (CursoInscricao)EntityCacheUtil.getResult(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
				CursoInscricaoImpl.class, primaryKey);

		if (cursoInscricao == _nullCursoInscricao) {
			return null;
		}

		if (cursoInscricao == null) {
			Session session = null;

			try {
				session = openSession();

				cursoInscricao = (CursoInscricao)session.get(CursoInscricaoImpl.class,
						primaryKey);

				if (cursoInscricao != null) {
					cacheResult(cursoInscricao);
				}
				else {
					EntityCacheUtil.putResult(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
						CursoInscricaoImpl.class, primaryKey,
						_nullCursoInscricao);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CursoInscricaoModelImpl.ENTITY_CACHE_ENABLED,
					CursoInscricaoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cursoInscricao;
	}

	/**
	 * Returns the curso inscricao with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param inscricaoId the primary key of the curso inscricao
	 * @return the curso inscricao, or <code>null</code> if a curso inscricao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricao fetchByPrimaryKey(long inscricaoId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)inscricaoId);
	}

	/**
	 * Returns all the curso inscricaos.
	 *
	 * @return the curso inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CursoInscricao> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<CursoInscricao> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<CursoInscricao> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<CursoInscricao> list = (List<CursoInscricao>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CURSOINSCRICAO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CURSOINSCRICAO;

				if (pagination) {
					sql = sql.concat(CursoInscricaoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CursoInscricao>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CursoInscricao>(list);
				}
				else {
					list = (List<CursoInscricao>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the curso inscricaos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CursoInscricao cursoInscricao : findAll()) {
			remove(cursoInscricao);
		}
	}

	/**
	 * Returns the number of curso inscricaos.
	 *
	 * @return the number of curso inscricaos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CURSOINSCRICAO);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the curso inscricao persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.cnf.curso.inscricao.model.CursoInscricao")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CursoInscricao>> listenersList = new ArrayList<ModelListener<CursoInscricao>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CursoInscricao>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(CursoInscricaoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CURSOINSCRICAO = "SELECT cursoInscricao FROM CursoInscricao cursoInscricao";
	private static final String _SQL_SELECT_CURSOINSCRICAO_WHERE = "SELECT cursoInscricao FROM CursoInscricao cursoInscricao WHERE ";
	private static final String _SQL_COUNT_CURSOINSCRICAO = "SELECT COUNT(cursoInscricao) FROM CursoInscricao cursoInscricao";
	private static final String _SQL_COUNT_CURSOINSCRICAO_WHERE = "SELECT COUNT(cursoInscricao) FROM CursoInscricao cursoInscricao WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cursoInscricao.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CursoInscricao exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CursoInscricao exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CursoInscricaoPersistenceImpl.class);
	private static CursoInscricao _nullCursoInscricao = new CursoInscricaoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CursoInscricao> toCacheModel() {
				return _nullCursoInscricaoCacheModel;
			}
		};

	private static CacheModel<CursoInscricao> _nullCursoInscricaoCacheModel = new CacheModel<CursoInscricao>() {
			@Override
			public CursoInscricao toEntityModel() {
				return _nullCursoInscricao;
			}
		};
}