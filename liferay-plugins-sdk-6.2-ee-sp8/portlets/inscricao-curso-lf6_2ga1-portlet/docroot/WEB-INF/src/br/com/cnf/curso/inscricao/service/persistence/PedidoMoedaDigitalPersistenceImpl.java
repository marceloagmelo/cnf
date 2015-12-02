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

import br.com.cnf.curso.inscricao.NoSuchPedidoMoedaDigitalException;
import br.com.cnf.curso.inscricao.model.PedidoMoedaDigital;
import br.com.cnf.curso.inscricao.model.impl.PedidoMoedaDigitalImpl;
import br.com.cnf.curso.inscricao.model.impl.PedidoMoedaDigitalModelImpl;

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
 * The persistence implementation for the pedido moeda digital service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author SEA
 * @see PedidoMoedaDigitalPersistence
 * @see PedidoMoedaDigitalUtil
 * @generated
 */
public class PedidoMoedaDigitalPersistenceImpl extends BasePersistenceImpl<PedidoMoedaDigital>
	implements PedidoMoedaDigitalPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PedidoMoedaDigitalUtil} to access the pedido moeda digital persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PedidoMoedaDigitalImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PedidoMoedaDigitalModelImpl.ENTITY_CACHE_ENABLED,
			PedidoMoedaDigitalModelImpl.FINDER_CACHE_ENABLED,
			PedidoMoedaDigitalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PedidoMoedaDigitalModelImpl.ENTITY_CACHE_ENABLED,
			PedidoMoedaDigitalModelImpl.FINDER_CACHE_ENABLED,
			PedidoMoedaDigitalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PedidoMoedaDigitalModelImpl.ENTITY_CACHE_ENABLED,
			PedidoMoedaDigitalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public PedidoMoedaDigitalPersistenceImpl() {
		setModelClass(PedidoMoedaDigital.class);
	}

	/**
	 * Caches the pedido moeda digital in the entity cache if it is enabled.
	 *
	 * @param pedidoMoedaDigital the pedido moeda digital
	 */
	@Override
	public void cacheResult(PedidoMoedaDigital pedidoMoedaDigital) {
		EntityCacheUtil.putResult(PedidoMoedaDigitalModelImpl.ENTITY_CACHE_ENABLED,
			PedidoMoedaDigitalImpl.class, pedidoMoedaDigital.getPrimaryKey(),
			pedidoMoedaDigital);

		pedidoMoedaDigital.resetOriginalValues();
	}

	/**
	 * Caches the pedido moeda digitals in the entity cache if it is enabled.
	 *
	 * @param pedidoMoedaDigitals the pedido moeda digitals
	 */
	@Override
	public void cacheResult(List<PedidoMoedaDigital> pedidoMoedaDigitals) {
		for (PedidoMoedaDigital pedidoMoedaDigital : pedidoMoedaDigitals) {
			if (EntityCacheUtil.getResult(
						PedidoMoedaDigitalModelImpl.ENTITY_CACHE_ENABLED,
						PedidoMoedaDigitalImpl.class,
						pedidoMoedaDigital.getPrimaryKey()) == null) {
				cacheResult(pedidoMoedaDigital);
			}
			else {
				pedidoMoedaDigital.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all pedido moeda digitals.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PedidoMoedaDigitalImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PedidoMoedaDigitalImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pedido moeda digital.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PedidoMoedaDigital pedidoMoedaDigital) {
		EntityCacheUtil.removeResult(PedidoMoedaDigitalModelImpl.ENTITY_CACHE_ENABLED,
			PedidoMoedaDigitalImpl.class, pedidoMoedaDigital.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PedidoMoedaDigital> pedidoMoedaDigitals) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PedidoMoedaDigital pedidoMoedaDigital : pedidoMoedaDigitals) {
			EntityCacheUtil.removeResult(PedidoMoedaDigitalModelImpl.ENTITY_CACHE_ENABLED,
				PedidoMoedaDigitalImpl.class, pedidoMoedaDigital.getPrimaryKey());
		}
	}

	/**
	 * Creates a new pedido moeda digital with the primary key. Does not add the pedido moeda digital to the database.
	 *
	 * @param pedidoMoedaDigitalId the primary key for the new pedido moeda digital
	 * @return the new pedido moeda digital
	 */
	@Override
	public PedidoMoedaDigital create(long pedidoMoedaDigitalId) {
		PedidoMoedaDigital pedidoMoedaDigital = new PedidoMoedaDigitalImpl();

		pedidoMoedaDigital.setNew(true);
		pedidoMoedaDigital.setPrimaryKey(pedidoMoedaDigitalId);

		return pedidoMoedaDigital;
	}

	/**
	 * Removes the pedido moeda digital with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pedidoMoedaDigitalId the primary key of the pedido moeda digital
	 * @return the pedido moeda digital that was removed
	 * @throws br.com.cnf.curso.inscricao.NoSuchPedidoMoedaDigitalException if a pedido moeda digital with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PedidoMoedaDigital remove(long pedidoMoedaDigitalId)
		throws NoSuchPedidoMoedaDigitalException, SystemException {
		return remove((Serializable)pedidoMoedaDigitalId);
	}

	/**
	 * Removes the pedido moeda digital with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pedido moeda digital
	 * @return the pedido moeda digital that was removed
	 * @throws br.com.cnf.curso.inscricao.NoSuchPedidoMoedaDigitalException if a pedido moeda digital with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PedidoMoedaDigital remove(Serializable primaryKey)
		throws NoSuchPedidoMoedaDigitalException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PedidoMoedaDigital pedidoMoedaDigital = (PedidoMoedaDigital)session.get(PedidoMoedaDigitalImpl.class,
					primaryKey);

			if (pedidoMoedaDigital == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPedidoMoedaDigitalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(pedidoMoedaDigital);
		}
		catch (NoSuchPedidoMoedaDigitalException nsee) {
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
	protected PedidoMoedaDigital removeImpl(
		PedidoMoedaDigital pedidoMoedaDigital) throws SystemException {
		pedidoMoedaDigital = toUnwrappedModel(pedidoMoedaDigital);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(pedidoMoedaDigital)) {
				pedidoMoedaDigital = (PedidoMoedaDigital)session.get(PedidoMoedaDigitalImpl.class,
						pedidoMoedaDigital.getPrimaryKeyObj());
			}

			if (pedidoMoedaDigital != null) {
				session.delete(pedidoMoedaDigital);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (pedidoMoedaDigital != null) {
			clearCache(pedidoMoedaDigital);
		}

		return pedidoMoedaDigital;
	}

	@Override
	public PedidoMoedaDigital updateImpl(
		br.com.cnf.curso.inscricao.model.PedidoMoedaDigital pedidoMoedaDigital)
		throws SystemException {
		pedidoMoedaDigital = toUnwrappedModel(pedidoMoedaDigital);

		boolean isNew = pedidoMoedaDigital.isNew();

		Session session = null;

		try {
			session = openSession();

			if (pedidoMoedaDigital.isNew()) {
				session.save(pedidoMoedaDigital);

				pedidoMoedaDigital.setNew(false);
			}
			else {
				session.merge(pedidoMoedaDigital);
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

		EntityCacheUtil.putResult(PedidoMoedaDigitalModelImpl.ENTITY_CACHE_ENABLED,
			PedidoMoedaDigitalImpl.class, pedidoMoedaDigital.getPrimaryKey(),
			pedidoMoedaDigital);

		return pedidoMoedaDigital;
	}

	protected PedidoMoedaDigital toUnwrappedModel(
		PedidoMoedaDigital pedidoMoedaDigital) {
		if (pedidoMoedaDigital instanceof PedidoMoedaDigitalImpl) {
			return pedidoMoedaDigital;
		}

		PedidoMoedaDigitalImpl pedidoMoedaDigitalImpl = new PedidoMoedaDigitalImpl();

		pedidoMoedaDigitalImpl.setNew(pedidoMoedaDigital.isNew());
		pedidoMoedaDigitalImpl.setPrimaryKey(pedidoMoedaDigital.getPrimaryKey());

		pedidoMoedaDigitalImpl.setPedidoMoedaDigitalId(pedidoMoedaDigital.getPedidoMoedaDigitalId());
		pedidoMoedaDigitalImpl.setInscricaoId(pedidoMoedaDigital.getInscricaoId());
		pedidoMoedaDigitalImpl.setDataPedido(pedidoMoedaDigital.getDataPedido());
		pedidoMoedaDigitalImpl.setXmlEnvio(pedidoMoedaDigital.getXmlEnvio());
		pedidoMoedaDigitalImpl.setXmlRetorno(pedidoMoedaDigital.getXmlRetorno());

		return pedidoMoedaDigitalImpl;
	}

	/**
	 * Returns the pedido moeda digital with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the pedido moeda digital
	 * @return the pedido moeda digital
	 * @throws br.com.cnf.curso.inscricao.NoSuchPedidoMoedaDigitalException if a pedido moeda digital with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PedidoMoedaDigital findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPedidoMoedaDigitalException, SystemException {
		PedidoMoedaDigital pedidoMoedaDigital = fetchByPrimaryKey(primaryKey);

		if (pedidoMoedaDigital == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPedidoMoedaDigitalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return pedidoMoedaDigital;
	}

	/**
	 * Returns the pedido moeda digital with the primary key or throws a {@link br.com.cnf.curso.inscricao.NoSuchPedidoMoedaDigitalException} if it could not be found.
	 *
	 * @param pedidoMoedaDigitalId the primary key of the pedido moeda digital
	 * @return the pedido moeda digital
	 * @throws br.com.cnf.curso.inscricao.NoSuchPedidoMoedaDigitalException if a pedido moeda digital with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PedidoMoedaDigital findByPrimaryKey(long pedidoMoedaDigitalId)
		throws NoSuchPedidoMoedaDigitalException, SystemException {
		return findByPrimaryKey((Serializable)pedidoMoedaDigitalId);
	}

	/**
	 * Returns the pedido moeda digital with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pedido moeda digital
	 * @return the pedido moeda digital, or <code>null</code> if a pedido moeda digital with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PedidoMoedaDigital fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PedidoMoedaDigital pedidoMoedaDigital = (PedidoMoedaDigital)EntityCacheUtil.getResult(PedidoMoedaDigitalModelImpl.ENTITY_CACHE_ENABLED,
				PedidoMoedaDigitalImpl.class, primaryKey);

		if (pedidoMoedaDigital == _nullPedidoMoedaDigital) {
			return null;
		}

		if (pedidoMoedaDigital == null) {
			Session session = null;

			try {
				session = openSession();

				pedidoMoedaDigital = (PedidoMoedaDigital)session.get(PedidoMoedaDigitalImpl.class,
						primaryKey);

				if (pedidoMoedaDigital != null) {
					cacheResult(pedidoMoedaDigital);
				}
				else {
					EntityCacheUtil.putResult(PedidoMoedaDigitalModelImpl.ENTITY_CACHE_ENABLED,
						PedidoMoedaDigitalImpl.class, primaryKey,
						_nullPedidoMoedaDigital);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PedidoMoedaDigitalModelImpl.ENTITY_CACHE_ENABLED,
					PedidoMoedaDigitalImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return pedidoMoedaDigital;
	}

	/**
	 * Returns the pedido moeda digital with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pedidoMoedaDigitalId the primary key of the pedido moeda digital
	 * @return the pedido moeda digital, or <code>null</code> if a pedido moeda digital with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PedidoMoedaDigital fetchByPrimaryKey(long pedidoMoedaDigitalId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)pedidoMoedaDigitalId);
	}

	/**
	 * Returns all the pedido moeda digitals.
	 *
	 * @return the pedido moeda digitals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PedidoMoedaDigital> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pedido moeda digitals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.PedidoMoedaDigitalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pedido moeda digitals
	 * @param end the upper bound of the range of pedido moeda digitals (not inclusive)
	 * @return the range of pedido moeda digitals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PedidoMoedaDigital> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pedido moeda digitals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.PedidoMoedaDigitalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pedido moeda digitals
	 * @param end the upper bound of the range of pedido moeda digitals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pedido moeda digitals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PedidoMoedaDigital> findAll(int start, int end,
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

		List<PedidoMoedaDigital> list = (List<PedidoMoedaDigital>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PEDIDOMOEDADIGITAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PEDIDOMOEDADIGITAL;

				if (pagination) {
					sql = sql.concat(PedidoMoedaDigitalModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PedidoMoedaDigital>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PedidoMoedaDigital>(list);
				}
				else {
					list = (List<PedidoMoedaDigital>)QueryUtil.list(q,
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
	 * Removes all the pedido moeda digitals from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PedidoMoedaDigital pedidoMoedaDigital : findAll()) {
			remove(pedidoMoedaDigital);
		}
	}

	/**
	 * Returns the number of pedido moeda digitals.
	 *
	 * @return the number of pedido moeda digitals
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

				Query q = session.createQuery(_SQL_COUNT_PEDIDOMOEDADIGITAL);

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
	 * Initializes the pedido moeda digital persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.cnf.curso.inscricao.model.PedidoMoedaDigital")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PedidoMoedaDigital>> listenersList = new ArrayList<ModelListener<PedidoMoedaDigital>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PedidoMoedaDigital>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PedidoMoedaDigitalImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PEDIDOMOEDADIGITAL = "SELECT pedidoMoedaDigital FROM PedidoMoedaDigital pedidoMoedaDigital";
	private static final String _SQL_COUNT_PEDIDOMOEDADIGITAL = "SELECT COUNT(pedidoMoedaDigital) FROM PedidoMoedaDigital pedidoMoedaDigital";
	private static final String _ORDER_BY_ENTITY_ALIAS = "pedidoMoedaDigital.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PedidoMoedaDigital exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PedidoMoedaDigitalPersistenceImpl.class);
	private static PedidoMoedaDigital _nullPedidoMoedaDigital = new PedidoMoedaDigitalImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PedidoMoedaDigital> toCacheModel() {
				return _nullPedidoMoedaDigitalCacheModel;
			}
		};

	private static CacheModel<PedidoMoedaDigital> _nullPedidoMoedaDigitalCacheModel =
		new CacheModel<PedidoMoedaDigital>() {
			@Override
			public PedidoMoedaDigital toEntityModel() {
				return _nullPedidoMoedaDigital;
			}
		};
}