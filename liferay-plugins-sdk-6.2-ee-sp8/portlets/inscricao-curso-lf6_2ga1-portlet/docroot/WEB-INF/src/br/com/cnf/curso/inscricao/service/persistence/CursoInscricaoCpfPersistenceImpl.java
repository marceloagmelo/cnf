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

import br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCpfException;
import br.com.cnf.curso.inscricao.model.CursoInscricaoCpf;
import br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCpfImpl;
import br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCpfModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the curso inscricao cpf service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author SEA
 * @see CursoInscricaoCpfPersistence
 * @see CursoInscricaoCpfUtil
 * @generated
 */
public class CursoInscricaoCpfPersistenceImpl extends BasePersistenceImpl<CursoInscricaoCpf>
	implements CursoInscricaoCpfPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CursoInscricaoCpfUtil} to access the curso inscricao cpf persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CursoInscricaoCpfImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CursoInscricaoCpfModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoCpfModelImpl.FINDER_CACHE_ENABLED,
			CursoInscricaoCpfImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CursoInscricaoCpfModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoCpfModelImpl.FINDER_CACHE_ENABLED,
			CursoInscricaoCpfImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CursoInscricaoCpfModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoCpfModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CursoInscricaoCpfPersistenceImpl() {
		setModelClass(CursoInscricaoCpf.class);
	}

	/**
	 * Caches the curso inscricao cpf in the entity cache if it is enabled.
	 *
	 * @param cursoInscricaoCpf the curso inscricao cpf
	 */
	@Override
	public void cacheResult(CursoInscricaoCpf cursoInscricaoCpf) {
		EntityCacheUtil.putResult(CursoInscricaoCpfModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoCpfImpl.class, cursoInscricaoCpf.getPrimaryKey(),
			cursoInscricaoCpf);

		cursoInscricaoCpf.resetOriginalValues();
	}

	/**
	 * Caches the curso inscricao cpfs in the entity cache if it is enabled.
	 *
	 * @param cursoInscricaoCpfs the curso inscricao cpfs
	 */
	@Override
	public void cacheResult(List<CursoInscricaoCpf> cursoInscricaoCpfs) {
		for (CursoInscricaoCpf cursoInscricaoCpf : cursoInscricaoCpfs) {
			if (EntityCacheUtil.getResult(
						CursoInscricaoCpfModelImpl.ENTITY_CACHE_ENABLED,
						CursoInscricaoCpfImpl.class,
						cursoInscricaoCpf.getPrimaryKey()) == null) {
				cacheResult(cursoInscricaoCpf);
			}
			else {
				cursoInscricaoCpf.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all curso inscricao cpfs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CursoInscricaoCpfImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CursoInscricaoCpfImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the curso inscricao cpf.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CursoInscricaoCpf cursoInscricaoCpf) {
		EntityCacheUtil.removeResult(CursoInscricaoCpfModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoCpfImpl.class, cursoInscricaoCpf.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CursoInscricaoCpf> cursoInscricaoCpfs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CursoInscricaoCpf cursoInscricaoCpf : cursoInscricaoCpfs) {
			EntityCacheUtil.removeResult(CursoInscricaoCpfModelImpl.ENTITY_CACHE_ENABLED,
				CursoInscricaoCpfImpl.class, cursoInscricaoCpf.getPrimaryKey());
		}
	}

	/**
	 * Creates a new curso inscricao cpf with the primary key. Does not add the curso inscricao cpf to the database.
	 *
	 * @param inscricaoCpfId the primary key for the new curso inscricao cpf
	 * @return the new curso inscricao cpf
	 */
	@Override
	public CursoInscricaoCpf create(long inscricaoCpfId) {
		CursoInscricaoCpf cursoInscricaoCpf = new CursoInscricaoCpfImpl();

		cursoInscricaoCpf.setNew(true);
		cursoInscricaoCpf.setPrimaryKey(inscricaoCpfId);

		return cursoInscricaoCpf;
	}

	/**
	 * Removes the curso inscricao cpf with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param inscricaoCpfId the primary key of the curso inscricao cpf
	 * @return the curso inscricao cpf that was removed
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCpfException if a curso inscricao cpf with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricaoCpf remove(long inscricaoCpfId)
		throws NoSuchCursoInscricaoCpfException, SystemException {
		return remove((Serializable)inscricaoCpfId);
	}

	/**
	 * Removes the curso inscricao cpf with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the curso inscricao cpf
	 * @return the curso inscricao cpf that was removed
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCpfException if a curso inscricao cpf with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricaoCpf remove(Serializable primaryKey)
		throws NoSuchCursoInscricaoCpfException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CursoInscricaoCpf cursoInscricaoCpf = (CursoInscricaoCpf)session.get(CursoInscricaoCpfImpl.class,
					primaryKey);

			if (cursoInscricaoCpf == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCursoInscricaoCpfException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cursoInscricaoCpf);
		}
		catch (NoSuchCursoInscricaoCpfException nsee) {
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
	protected CursoInscricaoCpf removeImpl(CursoInscricaoCpf cursoInscricaoCpf)
		throws SystemException {
		cursoInscricaoCpf = toUnwrappedModel(cursoInscricaoCpf);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cursoInscricaoCpf)) {
				cursoInscricaoCpf = (CursoInscricaoCpf)session.get(CursoInscricaoCpfImpl.class,
						cursoInscricaoCpf.getPrimaryKeyObj());
			}

			if (cursoInscricaoCpf != null) {
				session.delete(cursoInscricaoCpf);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cursoInscricaoCpf != null) {
			clearCache(cursoInscricaoCpf);
		}

		return cursoInscricaoCpf;
	}

	@Override
	public CursoInscricaoCpf updateImpl(
		br.com.cnf.curso.inscricao.model.CursoInscricaoCpf cursoInscricaoCpf)
		throws SystemException {
		cursoInscricaoCpf = toUnwrappedModel(cursoInscricaoCpf);

		boolean isNew = cursoInscricaoCpf.isNew();

		Session session = null;

		try {
			session = openSession();

			if (cursoInscricaoCpf.isNew()) {
				session.save(cursoInscricaoCpf);

				cursoInscricaoCpf.setNew(false);
			}
			else {
				session.merge(cursoInscricaoCpf);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(CursoInscricaoCpfModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoCpfImpl.class, cursoInscricaoCpf.getPrimaryKey(),
			cursoInscricaoCpf);

		return cursoInscricaoCpf;
	}

	protected CursoInscricaoCpf toUnwrappedModel(
		CursoInscricaoCpf cursoInscricaoCpf) {
		if (cursoInscricaoCpf instanceof CursoInscricaoCpfImpl) {
			return cursoInscricaoCpf;
		}

		CursoInscricaoCpfImpl cursoInscricaoCpfImpl = new CursoInscricaoCpfImpl();

		cursoInscricaoCpfImpl.setNew(cursoInscricaoCpf.isNew());
		cursoInscricaoCpfImpl.setPrimaryKey(cursoInscricaoCpf.getPrimaryKey());

		cursoInscricaoCpfImpl.setInscricaoCpfId(cursoInscricaoCpf.getInscricaoCpfId());
		cursoInscricaoCpfImpl.setInscricaoId(cursoInscricaoCpf.getInscricaoId());
		cursoInscricaoCpfImpl.setNome(cursoInscricaoCpf.getNome());
		cursoInscricaoCpfImpl.setCpf(cursoInscricaoCpf.getCpf());
		cursoInscricaoCpfImpl.setEndereco(cursoInscricaoCpf.getEndereco());
		cursoInscricaoCpfImpl.setBairro(cursoInscricaoCpf.getBairro());
		cursoInscricaoCpfImpl.setCidade(cursoInscricaoCpf.getCidade());
		cursoInscricaoCpfImpl.setEstado(cursoInscricaoCpf.getEstado());
		cursoInscricaoCpfImpl.setCep(cursoInscricaoCpf.getCep());
		cursoInscricaoCpfImpl.setDddTelefone(cursoInscricaoCpf.getDddTelefone());
		cursoInscricaoCpfImpl.setTelefone(cursoInscricaoCpf.getTelefone());
		cursoInscricaoCpfImpl.setEmail(cursoInscricaoCpf.getEmail());
		cursoInscricaoCpfImpl.setEmpresa(cursoInscricaoCpf.getEmpresa());
		cursoInscricaoCpfImpl.setCargo(cursoInscricaoCpf.getCargo());
		cursoInscricaoCpfImpl.setDepartamento(cursoInscricaoCpf.getDepartamento());
		cursoInscricaoCpfImpl.setObservacao(cursoInscricaoCpf.getObservacao());

		return cursoInscricaoCpfImpl;
	}

	/**
	 * Returns the curso inscricao cpf with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the curso inscricao cpf
	 * @return the curso inscricao cpf
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCpfException if a curso inscricao cpf with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricaoCpf findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCursoInscricaoCpfException, SystemException {
		CursoInscricaoCpf cursoInscricaoCpf = fetchByPrimaryKey(primaryKey);

		if (cursoInscricaoCpf == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCursoInscricaoCpfException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cursoInscricaoCpf;
	}

	/**
	 * Returns the curso inscricao cpf with the primary key or throws a {@link br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCpfException} if it could not be found.
	 *
	 * @param inscricaoCpfId the primary key of the curso inscricao cpf
	 * @return the curso inscricao cpf
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCpfException if a curso inscricao cpf with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricaoCpf findByPrimaryKey(long inscricaoCpfId)
		throws NoSuchCursoInscricaoCpfException, SystemException {
		return findByPrimaryKey((Serializable)inscricaoCpfId);
	}

	/**
	 * Returns the curso inscricao cpf with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the curso inscricao cpf
	 * @return the curso inscricao cpf, or <code>null</code> if a curso inscricao cpf with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricaoCpf fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CursoInscricaoCpf cursoInscricaoCpf = (CursoInscricaoCpf)EntityCacheUtil.getResult(CursoInscricaoCpfModelImpl.ENTITY_CACHE_ENABLED,
				CursoInscricaoCpfImpl.class, primaryKey);

		if (cursoInscricaoCpf == _nullCursoInscricaoCpf) {
			return null;
		}

		if (cursoInscricaoCpf == null) {
			Session session = null;

			try {
				session = openSession();

				cursoInscricaoCpf = (CursoInscricaoCpf)session.get(CursoInscricaoCpfImpl.class,
						primaryKey);

				if (cursoInscricaoCpf != null) {
					cacheResult(cursoInscricaoCpf);
				}
				else {
					EntityCacheUtil.putResult(CursoInscricaoCpfModelImpl.ENTITY_CACHE_ENABLED,
						CursoInscricaoCpfImpl.class, primaryKey,
						_nullCursoInscricaoCpf);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CursoInscricaoCpfModelImpl.ENTITY_CACHE_ENABLED,
					CursoInscricaoCpfImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cursoInscricaoCpf;
	}

	/**
	 * Returns the curso inscricao cpf with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param inscricaoCpfId the primary key of the curso inscricao cpf
	 * @return the curso inscricao cpf, or <code>null</code> if a curso inscricao cpf with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricaoCpf fetchByPrimaryKey(long inscricaoCpfId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)inscricaoCpfId);
	}

	/**
	 * Returns all the curso inscricao cpfs.
	 *
	 * @return the curso inscricao cpfs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CursoInscricaoCpf> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CursoInscricaoCpf> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<CursoInscricaoCpf> findAll(int start, int end,
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

		List<CursoInscricaoCpf> list = (List<CursoInscricaoCpf>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CURSOINSCRICAOCPF);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CURSOINSCRICAOCPF;

				if (pagination) {
					sql = sql.concat(CursoInscricaoCpfModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CursoInscricaoCpf>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CursoInscricaoCpf>(list);
				}
				else {
					list = (List<CursoInscricaoCpf>)QueryUtil.list(q,
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
	 * Removes all the curso inscricao cpfs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CursoInscricaoCpf cursoInscricaoCpf : findAll()) {
			remove(cursoInscricaoCpf);
		}
	}

	/**
	 * Returns the number of curso inscricao cpfs.
	 *
	 * @return the number of curso inscricao cpfs
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

				Query q = session.createQuery(_SQL_COUNT_CURSOINSCRICAOCPF);

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
	 * Initializes the curso inscricao cpf persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.cnf.curso.inscricao.model.CursoInscricaoCpf")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CursoInscricaoCpf>> listenersList = new ArrayList<ModelListener<CursoInscricaoCpf>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CursoInscricaoCpf>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CursoInscricaoCpfImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CURSOINSCRICAOCPF = "SELECT cursoInscricaoCpf FROM CursoInscricaoCpf cursoInscricaoCpf";
	private static final String _SQL_COUNT_CURSOINSCRICAOCPF = "SELECT COUNT(cursoInscricaoCpf) FROM CursoInscricaoCpf cursoInscricaoCpf";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cursoInscricaoCpf.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CursoInscricaoCpf exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CursoInscricaoCpfPersistenceImpl.class);
	private static CursoInscricaoCpf _nullCursoInscricaoCpf = new CursoInscricaoCpfImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CursoInscricaoCpf> toCacheModel() {
				return _nullCursoInscricaoCpfCacheModel;
			}
		};

	private static CacheModel<CursoInscricaoCpf> _nullCursoInscricaoCpfCacheModel =
		new CacheModel<CursoInscricaoCpf>() {
			@Override
			public CursoInscricaoCpf toEntityModel() {
				return _nullCursoInscricaoCpf;
			}
		};
}