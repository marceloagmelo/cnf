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

import br.com.cnf.curso.inscricao.NoSuchCursoParticipanteException;
import br.com.cnf.curso.inscricao.model.CursoParticipante;
import br.com.cnf.curso.inscricao.model.impl.CursoParticipanteImpl;
import br.com.cnf.curso.inscricao.model.impl.CursoParticipanteModelImpl;

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
 * The persistence implementation for the curso participante service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author SEA
 * @see CursoParticipantePersistence
 * @see CursoParticipanteUtil
 * @generated
 */
public class CursoParticipantePersistenceImpl extends BasePersistenceImpl<CursoParticipante>
	implements CursoParticipantePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CursoParticipanteUtil} to access the curso participante persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CursoParticipanteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CursoParticipanteModelImpl.ENTITY_CACHE_ENABLED,
			CursoParticipanteModelImpl.FINDER_CACHE_ENABLED,
			CursoParticipanteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CursoParticipanteModelImpl.ENTITY_CACHE_ENABLED,
			CursoParticipanteModelImpl.FINDER_CACHE_ENABLED,
			CursoParticipanteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CursoParticipanteModelImpl.ENTITY_CACHE_ENABLED,
			CursoParticipanteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CursoParticipantePersistenceImpl() {
		setModelClass(CursoParticipante.class);
	}

	/**
	 * Caches the curso participante in the entity cache if it is enabled.
	 *
	 * @param cursoParticipante the curso participante
	 */
	@Override
	public void cacheResult(CursoParticipante cursoParticipante) {
		EntityCacheUtil.putResult(CursoParticipanteModelImpl.ENTITY_CACHE_ENABLED,
			CursoParticipanteImpl.class, cursoParticipante.getPrimaryKey(),
			cursoParticipante);

		cursoParticipante.resetOriginalValues();
	}

	/**
	 * Caches the curso participantes in the entity cache if it is enabled.
	 *
	 * @param cursoParticipantes the curso participantes
	 */
	@Override
	public void cacheResult(List<CursoParticipante> cursoParticipantes) {
		for (CursoParticipante cursoParticipante : cursoParticipantes) {
			if (EntityCacheUtil.getResult(
						CursoParticipanteModelImpl.ENTITY_CACHE_ENABLED,
						CursoParticipanteImpl.class,
						cursoParticipante.getPrimaryKey()) == null) {
				cacheResult(cursoParticipante);
			}
			else {
				cursoParticipante.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all curso participantes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CursoParticipanteImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CursoParticipanteImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the curso participante.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CursoParticipante cursoParticipante) {
		EntityCacheUtil.removeResult(CursoParticipanteModelImpl.ENTITY_CACHE_ENABLED,
			CursoParticipanteImpl.class, cursoParticipante.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CursoParticipante> cursoParticipantes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CursoParticipante cursoParticipante : cursoParticipantes) {
			EntityCacheUtil.removeResult(CursoParticipanteModelImpl.ENTITY_CACHE_ENABLED,
				CursoParticipanteImpl.class, cursoParticipante.getPrimaryKey());
		}
	}

	/**
	 * Creates a new curso participante with the primary key. Does not add the curso participante to the database.
	 *
	 * @param participanteId the primary key for the new curso participante
	 * @return the new curso participante
	 */
	@Override
	public CursoParticipante create(long participanteId) {
		CursoParticipante cursoParticipante = new CursoParticipanteImpl();

		cursoParticipante.setNew(true);
		cursoParticipante.setPrimaryKey(participanteId);

		return cursoParticipante;
	}

	/**
	 * Removes the curso participante with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param participanteId the primary key of the curso participante
	 * @return the curso participante that was removed
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoParticipanteException if a curso participante with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoParticipante remove(long participanteId)
		throws NoSuchCursoParticipanteException, SystemException {
		return remove((Serializable)participanteId);
	}

	/**
	 * Removes the curso participante with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the curso participante
	 * @return the curso participante that was removed
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoParticipanteException if a curso participante with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoParticipante remove(Serializable primaryKey)
		throws NoSuchCursoParticipanteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CursoParticipante cursoParticipante = (CursoParticipante)session.get(CursoParticipanteImpl.class,
					primaryKey);

			if (cursoParticipante == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCursoParticipanteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cursoParticipante);
		}
		catch (NoSuchCursoParticipanteException nsee) {
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
	protected CursoParticipante removeImpl(CursoParticipante cursoParticipante)
		throws SystemException {
		cursoParticipante = toUnwrappedModel(cursoParticipante);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cursoParticipante)) {
				cursoParticipante = (CursoParticipante)session.get(CursoParticipanteImpl.class,
						cursoParticipante.getPrimaryKeyObj());
			}

			if (cursoParticipante != null) {
				session.delete(cursoParticipante);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cursoParticipante != null) {
			clearCache(cursoParticipante);
		}

		return cursoParticipante;
	}

	@Override
	public CursoParticipante updateImpl(
		br.com.cnf.curso.inscricao.model.CursoParticipante cursoParticipante)
		throws SystemException {
		cursoParticipante = toUnwrappedModel(cursoParticipante);

		boolean isNew = cursoParticipante.isNew();

		Session session = null;

		try {
			session = openSession();

			if (cursoParticipante.isNew()) {
				session.save(cursoParticipante);

				cursoParticipante.setNew(false);
			}
			else {
				session.merge(cursoParticipante);
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

		EntityCacheUtil.putResult(CursoParticipanteModelImpl.ENTITY_CACHE_ENABLED,
			CursoParticipanteImpl.class, cursoParticipante.getPrimaryKey(),
			cursoParticipante);

		return cursoParticipante;
	}

	protected CursoParticipante toUnwrappedModel(
		CursoParticipante cursoParticipante) {
		if (cursoParticipante instanceof CursoParticipanteImpl) {
			return cursoParticipante;
		}

		CursoParticipanteImpl cursoParticipanteImpl = new CursoParticipanteImpl();

		cursoParticipanteImpl.setNew(cursoParticipante.isNew());
		cursoParticipanteImpl.setPrimaryKey(cursoParticipante.getPrimaryKey());

		cursoParticipanteImpl.setParticipanteId(cursoParticipante.getParticipanteId());
		cursoParticipanteImpl.setInscricaoId(cursoParticipante.getInscricaoId());
		cursoParticipanteImpl.setNomeCompleto(cursoParticipante.getNomeCompleto());
		cursoParticipanteImpl.setNomeCracha(cursoParticipante.getNomeCracha());
		cursoParticipanteImpl.setCpf(cursoParticipante.getCpf());
		cursoParticipanteImpl.setSexo(cursoParticipante.getSexo());
		cursoParticipanteImpl.setCargo(cursoParticipante.getCargo());
		cursoParticipanteImpl.setEmpresaOndeTrabalha(cursoParticipante.getEmpresaOndeTrabalha());
		cursoParticipanteImpl.setDepartamento(cursoParticipante.getDepartamento());
		cursoParticipanteImpl.setFormacaoAcademica(cursoParticipante.getFormacaoAcademica());
		cursoParticipanteImpl.setEmailPrincipal(cursoParticipante.getEmailPrincipal());
		cursoParticipanteImpl.setEmailOpcional(cursoParticipante.getEmailOpcional());
		cursoParticipanteImpl.setDddTelefoneComercial(cursoParticipante.getDddTelefoneComercial());
		cursoParticipanteImpl.setTelefoneComercial(cursoParticipante.getTelefoneComercial());
		cursoParticipanteImpl.setDddTelefonePessoal(cursoParticipante.getDddTelefonePessoal());
		cursoParticipanteImpl.setTelefonePessoal(cursoParticipante.getTelefonePessoal());
		cursoParticipanteImpl.setDddTelefoneCelular(cursoParticipante.getDddTelefoneCelular());
		cursoParticipanteImpl.setTelefoneCelular(cursoParticipante.getTelefoneCelular());
		cursoParticipanteImpl.setEndereco(cursoParticipante.getEndereco());
		cursoParticipanteImpl.setBairro(cursoParticipante.getBairro());
		cursoParticipanteImpl.setCidade(cursoParticipante.getCidade());
		cursoParticipanteImpl.setEstado(cursoParticipante.getEstado());
		cursoParticipanteImpl.setCep(cursoParticipante.getCep());
		cursoParticipanteImpl.setValorPago(cursoParticipante.getValorPago());
		cursoParticipanteImpl.setExpectativaCurso(cursoParticipante.getExpectativaCurso());
		cursoParticipanteImpl.setObservacao(cursoParticipante.getObservacao());

		return cursoParticipanteImpl;
	}

	/**
	 * Returns the curso participante with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the curso participante
	 * @return the curso participante
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoParticipanteException if a curso participante with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoParticipante findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCursoParticipanteException, SystemException {
		CursoParticipante cursoParticipante = fetchByPrimaryKey(primaryKey);

		if (cursoParticipante == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCursoParticipanteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cursoParticipante;
	}

	/**
	 * Returns the curso participante with the primary key or throws a {@link br.com.cnf.curso.inscricao.NoSuchCursoParticipanteException} if it could not be found.
	 *
	 * @param participanteId the primary key of the curso participante
	 * @return the curso participante
	 * @throws br.com.cnf.curso.inscricao.NoSuchCursoParticipanteException if a curso participante with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoParticipante findByPrimaryKey(long participanteId)
		throws NoSuchCursoParticipanteException, SystemException {
		return findByPrimaryKey((Serializable)participanteId);
	}

	/**
	 * Returns the curso participante with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the curso participante
	 * @return the curso participante, or <code>null</code> if a curso participante with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoParticipante fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CursoParticipante cursoParticipante = (CursoParticipante)EntityCacheUtil.getResult(CursoParticipanteModelImpl.ENTITY_CACHE_ENABLED,
				CursoParticipanteImpl.class, primaryKey);

		if (cursoParticipante == _nullCursoParticipante) {
			return null;
		}

		if (cursoParticipante == null) {
			Session session = null;

			try {
				session = openSession();

				cursoParticipante = (CursoParticipante)session.get(CursoParticipanteImpl.class,
						primaryKey);

				if (cursoParticipante != null) {
					cacheResult(cursoParticipante);
				}
				else {
					EntityCacheUtil.putResult(CursoParticipanteModelImpl.ENTITY_CACHE_ENABLED,
						CursoParticipanteImpl.class, primaryKey,
						_nullCursoParticipante);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CursoParticipanteModelImpl.ENTITY_CACHE_ENABLED,
					CursoParticipanteImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cursoParticipante;
	}

	/**
	 * Returns the curso participante with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param participanteId the primary key of the curso participante
	 * @return the curso participante, or <code>null</code> if a curso participante with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoParticipante fetchByPrimaryKey(long participanteId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)participanteId);
	}

	/**
	 * Returns all the curso participantes.
	 *
	 * @return the curso participantes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CursoParticipante> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<CursoParticipante> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<CursoParticipante> findAll(int start, int end,
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

		List<CursoParticipante> list = (List<CursoParticipante>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CURSOPARTICIPANTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CURSOPARTICIPANTE;

				if (pagination) {
					sql = sql.concat(CursoParticipanteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CursoParticipante>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CursoParticipante>(list);
				}
				else {
					list = (List<CursoParticipante>)QueryUtil.list(q,
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
	 * Removes all the curso participantes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CursoParticipante cursoParticipante : findAll()) {
			remove(cursoParticipante);
		}
	}

	/**
	 * Returns the number of curso participantes.
	 *
	 * @return the number of curso participantes
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

				Query q = session.createQuery(_SQL_COUNT_CURSOPARTICIPANTE);

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
	 * Initializes the curso participante persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.cnf.curso.inscricao.model.CursoParticipante")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CursoParticipante>> listenersList = new ArrayList<ModelListener<CursoParticipante>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CursoParticipante>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CursoParticipanteImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CURSOPARTICIPANTE = "SELECT cursoParticipante FROM CursoParticipante cursoParticipante";
	private static final String _SQL_COUNT_CURSOPARTICIPANTE = "SELECT COUNT(cursoParticipante) FROM CursoParticipante cursoParticipante";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cursoParticipante.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CursoParticipante exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CursoParticipantePersistenceImpl.class);
	private static CursoParticipante _nullCursoParticipante = new CursoParticipanteImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CursoParticipante> toCacheModel() {
				return _nullCursoParticipanteCacheModel;
			}
		};

	private static CacheModel<CursoParticipante> _nullCursoParticipanteCacheModel =
		new CacheModel<CursoParticipante>() {
			@Override
			public CursoParticipante toEntityModel() {
				return _nullCursoParticipante;
			}
		};
}