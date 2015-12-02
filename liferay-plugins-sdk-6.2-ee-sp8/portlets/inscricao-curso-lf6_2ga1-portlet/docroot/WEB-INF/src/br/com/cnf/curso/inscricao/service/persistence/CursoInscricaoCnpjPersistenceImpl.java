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

import br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCnpjException;
import br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj;
import br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCnpjImpl;
import br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCnpjModelImpl;

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
 * The persistence implementation for the curso inscricao cnpj service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author SEA
 * @see CursoInscricaoCnpjPersistence
 * @see CursoInscricaoCnpjUtil
 * @generated
 */
public class CursoInscricaoCnpjPersistenceImpl extends BasePersistenceImpl<CursoInscricaoCnpj>
	implements CursoInscricaoCnpjPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CursoInscricaoCnpjUtil} to access the curso inscricao cnpj persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CursoInscricaoCnpjImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CursoInscricaoCnpjModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoCnpjModelImpl.FINDER_CACHE_ENABLED,
			CursoInscricaoCnpjImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CursoInscricaoCnpjModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoCnpjModelImpl.FINDER_CACHE_ENABLED,
			CursoInscricaoCnpjImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CursoInscricaoCnpjModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoCnpjModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CursoInscricaoCnpjPersistenceImpl() {
		setModelClass(CursoInscricaoCnpj.class);
	}

	/**
	 * Caches the curso inscricao cnpj in the entity cache if it is enabled.
	 *
	 * @param cursoInscricaoCnpj the curso inscricao cnpj
	 */
	@Override
	public void cacheResult(CursoInscricaoCnpj cursoInscricaoCnpj) {
		EntityCacheUtil.putResult(CursoInscricaoCnpjModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoCnpjImpl.class, cursoInscricaoCnpj.getPrimaryKey(),
			cursoInscricaoCnpj);

		cursoInscricaoCnpj.resetOriginalValues();
	}

	/**
	 * Caches the curso inscricao cnpjs in the entity cache if it is enabled.
	 *
	 * @param cursoInscricaoCnpjs the curso inscricao cnpjs
	 */
	@Override
	public void cacheResult(List<CursoInscricaoCnpj> cursoInscricaoCnpjs) {
		for (CursoInscricaoCnpj cursoInscricaoCnpj : cursoInscricaoCnpjs) {
			if (EntityCacheUtil.getResult(
						CursoInscricaoCnpjModelImpl.ENTITY_CACHE_ENABLED,
						CursoInscricaoCnpjImpl.class,
						cursoInscricaoCnpj.getPrimaryKey()) == null) {
				cacheResult(cursoInscricaoCnpj);
			}
			else {
				cursoInscricaoCnpj.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all curso inscricao cnpjs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CursoInscricaoCnpjImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CursoInscricaoCnpjImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the curso inscricao cnpj.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CursoInscricaoCnpj cursoInscricaoCnpj) {
		EntityCacheUtil.removeResult(CursoInscricaoCnpjModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoCnpjImpl.class, cursoInscricaoCnpj.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CursoInscricaoCnpj> cursoInscricaoCnpjs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CursoInscricaoCnpj cursoInscricaoCnpj : cursoInscricaoCnpjs) {
			EntityCacheUtil.removeResult(CursoInscricaoCnpjModelImpl.ENTITY_CACHE_ENABLED,
				CursoInscricaoCnpjImpl.class, cursoInscricaoCnpj.getPrimaryKey());
		}
	}

	/**
	 * Creates a new curso inscricao cnpj with the primary key. Does not add the curso inscricao cnpj to the database.
	 *
	 * @param inscricaoCnpjId the primary key for the new curso inscricao cnpj
	 * @return the new curso inscricao cnpj
	 */
	@Override
	public CursoInscricaoCnpj create(long inscricaoCnpjId) {
		CursoInscricaoCnpj cursoInscricaoCnpj = new CursoInscricaoCnpjImpl();

		cursoInscricaoCnpj.setNew(true);
		cursoInscricaoCnpj.setPrimaryKey(inscricaoCnpjId);

		return cursoInscricaoCnpj;
	}

	/**
	 * Removes the curso inscricao cnpj with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param inscricaoCnpjId the primary key of the curso inscricao cnpj
	 * @return the curso inscricao cnpj that was removed
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCnpjException if a curso inscricao cnpj with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricaoCnpj remove(long inscricaoCnpjId)
		throws NoSuchCursoInscricaoCnpjException, SystemException {
		return remove((Serializable)inscricaoCnpjId);
	}

	/**
	 * Removes the curso inscricao cnpj with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the curso inscricao cnpj
	 * @return the curso inscricao cnpj that was removed
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCnpjException if a curso inscricao cnpj with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricaoCnpj remove(Serializable primaryKey)
		throws NoSuchCursoInscricaoCnpjException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CursoInscricaoCnpj cursoInscricaoCnpj = (CursoInscricaoCnpj)session.get(CursoInscricaoCnpjImpl.class,
					primaryKey);

			if (cursoInscricaoCnpj == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCursoInscricaoCnpjException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cursoInscricaoCnpj);
		}
		catch (NoSuchCursoInscricaoCnpjException nsee) {
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
	protected CursoInscricaoCnpj removeImpl(
		CursoInscricaoCnpj cursoInscricaoCnpj) throws SystemException {
		cursoInscricaoCnpj = toUnwrappedModel(cursoInscricaoCnpj);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cursoInscricaoCnpj)) {
				cursoInscricaoCnpj = (CursoInscricaoCnpj)session.get(CursoInscricaoCnpjImpl.class,
						cursoInscricaoCnpj.getPrimaryKeyObj());
			}

			if (cursoInscricaoCnpj != null) {
				session.delete(cursoInscricaoCnpj);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cursoInscricaoCnpj != null) {
			clearCache(cursoInscricaoCnpj);
		}

		return cursoInscricaoCnpj;
	}

	@Override
	public CursoInscricaoCnpj updateImpl(
		br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj cursoInscricaoCnpj)
		throws SystemException {
		cursoInscricaoCnpj = toUnwrappedModel(cursoInscricaoCnpj);

		boolean isNew = cursoInscricaoCnpj.isNew();

		Session session = null;

		try {
			session = openSession();

			if (cursoInscricaoCnpj.isNew()) {
				session.save(cursoInscricaoCnpj);

				cursoInscricaoCnpj.setNew(false);
			}
			else {
				session.merge(cursoInscricaoCnpj);
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

		EntityCacheUtil.putResult(CursoInscricaoCnpjModelImpl.ENTITY_CACHE_ENABLED,
			CursoInscricaoCnpjImpl.class, cursoInscricaoCnpj.getPrimaryKey(),
			cursoInscricaoCnpj);

		return cursoInscricaoCnpj;
	}

	protected CursoInscricaoCnpj toUnwrappedModel(
		CursoInscricaoCnpj cursoInscricaoCnpj) {
		if (cursoInscricaoCnpj instanceof CursoInscricaoCnpjImpl) {
			return cursoInscricaoCnpj;
		}

		CursoInscricaoCnpjImpl cursoInscricaoCnpjImpl = new CursoInscricaoCnpjImpl();

		cursoInscricaoCnpjImpl.setNew(cursoInscricaoCnpj.isNew());
		cursoInscricaoCnpjImpl.setPrimaryKey(cursoInscricaoCnpj.getPrimaryKey());

		cursoInscricaoCnpjImpl.setInscricaoCnpjId(cursoInscricaoCnpj.getInscricaoCnpjId());
		cursoInscricaoCnpjImpl.setInscricaoId(cursoInscricaoCnpj.getInscricaoId());
		cursoInscricaoCnpjImpl.setRazaoSocial(cursoInscricaoCnpj.getRazaoSocial());
		cursoInscricaoCnpjImpl.setNomeFantasia(cursoInscricaoCnpj.getNomeFantasia());
		cursoInscricaoCnpjImpl.setInscricaoEstadual(cursoInscricaoCnpj.getInscricaoEstadual());
		cursoInscricaoCnpjImpl.setEndereco(cursoInscricaoCnpj.getEndereco());
		cursoInscricaoCnpjImpl.setBairro(cursoInscricaoCnpj.getBairro());
		cursoInscricaoCnpjImpl.setCidade(cursoInscricaoCnpj.getCidade());
		cursoInscricaoCnpjImpl.setEstado(cursoInscricaoCnpj.getEstado());
		cursoInscricaoCnpjImpl.setCep(cursoInscricaoCnpj.getCep());
		cursoInscricaoCnpjImpl.setDddTelefone(cursoInscricaoCnpj.getDddTelefone());
		cursoInscricaoCnpjImpl.setTelefone(cursoInscricaoCnpj.getTelefone());
		cursoInscricaoCnpjImpl.setNfNome(cursoInscricaoCnpj.getNfNome());
		cursoInscricaoCnpjImpl.setNfDepartamento(cursoInscricaoCnpj.getNfDepartamento());
		cursoInscricaoCnpjImpl.setNfEmail(cursoInscricaoCnpj.getNfEmail());
		cursoInscricaoCnpjImpl.setNfDddTelefone(cursoInscricaoCnpj.getNfDddTelefone());
		cursoInscricaoCnpjImpl.setNfTelefone(cursoInscricaoCnpj.getNfTelefone());
		cursoInscricaoCnpjImpl.setObservacao(cursoInscricaoCnpj.getObservacao());

		return cursoInscricaoCnpjImpl;
	}

	/**
	 * Returns the curso inscricao cnpj with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the curso inscricao cnpj
	 * @return the curso inscricao cnpj
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCnpjException if a curso inscricao cnpj with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricaoCnpj findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCursoInscricaoCnpjException, SystemException {
		CursoInscricaoCnpj cursoInscricaoCnpj = fetchByPrimaryKey(primaryKey);

		if (cursoInscricaoCnpj == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCursoInscricaoCnpjException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cursoInscricaoCnpj;
	}

	/**
	 * Returns the curso inscricao cnpj with the primary key or throws a {@link br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCnpjException} if it could not be found.
	 *
	 * @param inscricaoCnpjId the primary key of the curso inscricao cnpj
	 * @return the curso inscricao cnpj
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCnpjException if a curso inscricao cnpj with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricaoCnpj findByPrimaryKey(long inscricaoCnpjId)
		throws NoSuchCursoInscricaoCnpjException, SystemException {
		return findByPrimaryKey((Serializable)inscricaoCnpjId);
	}

	/**
	 * Returns the curso inscricao cnpj with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the curso inscricao cnpj
	 * @return the curso inscricao cnpj, or <code>null</code> if a curso inscricao cnpj with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricaoCnpj fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CursoInscricaoCnpj cursoInscricaoCnpj = (CursoInscricaoCnpj)EntityCacheUtil.getResult(CursoInscricaoCnpjModelImpl.ENTITY_CACHE_ENABLED,
				CursoInscricaoCnpjImpl.class, primaryKey);

		if (cursoInscricaoCnpj == _nullCursoInscricaoCnpj) {
			return null;
		}

		if (cursoInscricaoCnpj == null) {
			Session session = null;

			try {
				session = openSession();

				cursoInscricaoCnpj = (CursoInscricaoCnpj)session.get(CursoInscricaoCnpjImpl.class,
						primaryKey);

				if (cursoInscricaoCnpj != null) {
					cacheResult(cursoInscricaoCnpj);
				}
				else {
					EntityCacheUtil.putResult(CursoInscricaoCnpjModelImpl.ENTITY_CACHE_ENABLED,
						CursoInscricaoCnpjImpl.class, primaryKey,
						_nullCursoInscricaoCnpj);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CursoInscricaoCnpjModelImpl.ENTITY_CACHE_ENABLED,
					CursoInscricaoCnpjImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cursoInscricaoCnpj;
	}

	/**
	 * Returns the curso inscricao cnpj with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param inscricaoCnpjId the primary key of the curso inscricao cnpj
	 * @return the curso inscricao cnpj, or <code>null</code> if a curso inscricao cnpj with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricaoCnpj fetchByPrimaryKey(long inscricaoCnpjId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)inscricaoCnpjId);
	}

	/**
	 * Returns all the curso inscricao cnpjs.
	 *
	 * @return the curso inscricao cnpjs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CursoInscricaoCnpj> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<CursoInscricaoCnpj> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<CursoInscricaoCnpj> findAll(int start, int end,
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

		List<CursoInscricaoCnpj> list = (List<CursoInscricaoCnpj>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CURSOINSCRICAOCNPJ);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CURSOINSCRICAOCNPJ;

				if (pagination) {
					sql = sql.concat(CursoInscricaoCnpjModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CursoInscricaoCnpj>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CursoInscricaoCnpj>(list);
				}
				else {
					list = (List<CursoInscricaoCnpj>)QueryUtil.list(q,
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
	 * Removes all the curso inscricao cnpjs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CursoInscricaoCnpj cursoInscricaoCnpj : findAll()) {
			remove(cursoInscricaoCnpj);
		}
	}

	/**
	 * Returns the number of curso inscricao cnpjs.
	 *
	 * @return the number of curso inscricao cnpjs
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

				Query q = session.createQuery(_SQL_COUNT_CURSOINSCRICAOCNPJ);

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
	 * Initializes the curso inscricao cnpj persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CursoInscricaoCnpj>> listenersList = new ArrayList<ModelListener<CursoInscricaoCnpj>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CursoInscricaoCnpj>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CursoInscricaoCnpjImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CURSOINSCRICAOCNPJ = "SELECT cursoInscricaoCnpj FROM CursoInscricaoCnpj cursoInscricaoCnpj";
	private static final String _SQL_COUNT_CURSOINSCRICAOCNPJ = "SELECT COUNT(cursoInscricaoCnpj) FROM CursoInscricaoCnpj cursoInscricaoCnpj";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cursoInscricaoCnpj.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CursoInscricaoCnpj exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CursoInscricaoCnpjPersistenceImpl.class);
	private static CursoInscricaoCnpj _nullCursoInscricaoCnpj = new CursoInscricaoCnpjImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CursoInscricaoCnpj> toCacheModel() {
				return _nullCursoInscricaoCnpjCacheModel;
			}
		};

	private static CacheModel<CursoInscricaoCnpj> _nullCursoInscricaoCnpjCacheModel =
		new CacheModel<CursoInscricaoCnpj>() {
			@Override
			public CursoInscricaoCnpj toEntityModel() {
				return _nullCursoInscricaoCnpj;
			}
		};
}