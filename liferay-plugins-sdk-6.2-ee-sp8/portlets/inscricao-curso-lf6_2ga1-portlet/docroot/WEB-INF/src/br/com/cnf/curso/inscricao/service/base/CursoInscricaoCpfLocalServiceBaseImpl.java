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

package br.com.cnf.curso.inscricao.service.base;

import br.com.cnf.curso.inscricao.model.CursoInscricaoCpf;
import br.com.cnf.curso.inscricao.service.CursoInscricaoCpfLocalService;
import br.com.cnf.curso.inscricao.service.persistence.CursoInscricaoCnpjPersistence;
import br.com.cnf.curso.inscricao.service.persistence.CursoInscricaoCpfPersistence;
import br.com.cnf.curso.inscricao.service.persistence.CursoInscricaoPersistence;
import br.com.cnf.curso.inscricao.service.persistence.CursoParticipantePersistence;
import br.com.cnf.curso.inscricao.service.persistence.PedidoMoedaDigitalPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the curso inscricao cpf local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link br.com.cnf.curso.inscricao.service.impl.CursoInscricaoCpfLocalServiceImpl}.
 * </p>
 *
 * @author SEA
 * @see br.com.cnf.curso.inscricao.service.impl.CursoInscricaoCpfLocalServiceImpl
 * @see br.com.cnf.curso.inscricao.service.CursoInscricaoCpfLocalServiceUtil
 * @generated
 */
public abstract class CursoInscricaoCpfLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements CursoInscricaoCpfLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link br.com.cnf.curso.inscricao.service.CursoInscricaoCpfLocalServiceUtil} to access the curso inscricao cpf local service.
	 */

	/**
	 * Adds the curso inscricao cpf to the database. Also notifies the appropriate model listeners.
	 *
	 * @param cursoInscricaoCpf the curso inscricao cpf
	 * @return the curso inscricao cpf that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CursoInscricaoCpf addCursoInscricaoCpf(
		CursoInscricaoCpf cursoInscricaoCpf) throws SystemException {
		cursoInscricaoCpf.setNew(true);

		return cursoInscricaoCpfPersistence.update(cursoInscricaoCpf);
	}

	/**
	 * Creates a new curso inscricao cpf with the primary key. Does not add the curso inscricao cpf to the database.
	 *
	 * @param inscricaoCpfId the primary key for the new curso inscricao cpf
	 * @return the new curso inscricao cpf
	 */
	@Override
	public CursoInscricaoCpf createCursoInscricaoCpf(long inscricaoCpfId) {
		return cursoInscricaoCpfPersistence.create(inscricaoCpfId);
	}

	/**
	 * Deletes the curso inscricao cpf with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param inscricaoCpfId the primary key of the curso inscricao cpf
	 * @return the curso inscricao cpf that was removed
	 * @throws PortalException if a curso inscricao cpf with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CursoInscricaoCpf deleteCursoInscricaoCpf(long inscricaoCpfId)
		throws PortalException, SystemException {
		return cursoInscricaoCpfPersistence.remove(inscricaoCpfId);
	}

	/**
	 * Deletes the curso inscricao cpf from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cursoInscricaoCpf the curso inscricao cpf
	 * @return the curso inscricao cpf that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CursoInscricaoCpf deleteCursoInscricaoCpf(
		CursoInscricaoCpf cursoInscricaoCpf) throws SystemException {
		return cursoInscricaoCpfPersistence.remove(cursoInscricaoCpf);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(CursoInscricaoCpf.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return cursoInscricaoCpfPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCpfModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return cursoInscricaoCpfPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCpfModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return cursoInscricaoCpfPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return cursoInscricaoCpfPersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return cursoInscricaoCpfPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public CursoInscricaoCpf fetchCursoInscricaoCpf(long inscricaoCpfId)
		throws SystemException {
		return cursoInscricaoCpfPersistence.fetchByPrimaryKey(inscricaoCpfId);
	}

	/**
	 * Returns the curso inscricao cpf with the primary key.
	 *
	 * @param inscricaoCpfId the primary key of the curso inscricao cpf
	 * @return the curso inscricao cpf
	 * @throws PortalException if a curso inscricao cpf with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CursoInscricaoCpf getCursoInscricaoCpf(long inscricaoCpfId)
		throws PortalException, SystemException {
		return cursoInscricaoCpfPersistence.findByPrimaryKey(inscricaoCpfId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return cursoInscricaoCpfPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<CursoInscricaoCpf> getCursoInscricaoCpfs(int start, int end)
		throws SystemException {
		return cursoInscricaoCpfPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of curso inscricao cpfs.
	 *
	 * @return the number of curso inscricao cpfs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getCursoInscricaoCpfsCount() throws SystemException {
		return cursoInscricaoCpfPersistence.countAll();
	}

	/**
	 * Updates the curso inscricao cpf in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param cursoInscricaoCpf the curso inscricao cpf
	 * @return the curso inscricao cpf that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CursoInscricaoCpf updateCursoInscricaoCpf(
		CursoInscricaoCpf cursoInscricaoCpf) throws SystemException {
		return cursoInscricaoCpfPersistence.update(cursoInscricaoCpf);
	}

	/**
	 * Returns the curso inscricao local service.
	 *
	 * @return the curso inscricao local service
	 */
	public br.com.cnf.curso.inscricao.service.CursoInscricaoLocalService getCursoInscricaoLocalService() {
		return cursoInscricaoLocalService;
	}

	/**
	 * Sets the curso inscricao local service.
	 *
	 * @param cursoInscricaoLocalService the curso inscricao local service
	 */
	public void setCursoInscricaoLocalService(
		br.com.cnf.curso.inscricao.service.CursoInscricaoLocalService cursoInscricaoLocalService) {
		this.cursoInscricaoLocalService = cursoInscricaoLocalService;
	}

	/**
	 * Returns the curso inscricao persistence.
	 *
	 * @return the curso inscricao persistence
	 */
	public CursoInscricaoPersistence getCursoInscricaoPersistence() {
		return cursoInscricaoPersistence;
	}

	/**
	 * Sets the curso inscricao persistence.
	 *
	 * @param cursoInscricaoPersistence the curso inscricao persistence
	 */
	public void setCursoInscricaoPersistence(
		CursoInscricaoPersistence cursoInscricaoPersistence) {
		this.cursoInscricaoPersistence = cursoInscricaoPersistence;
	}

	/**
	 * Returns the curso inscricao cnpj local service.
	 *
	 * @return the curso inscricao cnpj local service
	 */
	public br.com.cnf.curso.inscricao.service.CursoInscricaoCnpjLocalService getCursoInscricaoCnpjLocalService() {
		return cursoInscricaoCnpjLocalService;
	}

	/**
	 * Sets the curso inscricao cnpj local service.
	 *
	 * @param cursoInscricaoCnpjLocalService the curso inscricao cnpj local service
	 */
	public void setCursoInscricaoCnpjLocalService(
		br.com.cnf.curso.inscricao.service.CursoInscricaoCnpjLocalService cursoInscricaoCnpjLocalService) {
		this.cursoInscricaoCnpjLocalService = cursoInscricaoCnpjLocalService;
	}

	/**
	 * Returns the curso inscricao cnpj persistence.
	 *
	 * @return the curso inscricao cnpj persistence
	 */
	public CursoInscricaoCnpjPersistence getCursoInscricaoCnpjPersistence() {
		return cursoInscricaoCnpjPersistence;
	}

	/**
	 * Sets the curso inscricao cnpj persistence.
	 *
	 * @param cursoInscricaoCnpjPersistence the curso inscricao cnpj persistence
	 */
	public void setCursoInscricaoCnpjPersistence(
		CursoInscricaoCnpjPersistence cursoInscricaoCnpjPersistence) {
		this.cursoInscricaoCnpjPersistence = cursoInscricaoCnpjPersistence;
	}

	/**
	 * Returns the curso inscricao cpf local service.
	 *
	 * @return the curso inscricao cpf local service
	 */
	public br.com.cnf.curso.inscricao.service.CursoInscricaoCpfLocalService getCursoInscricaoCpfLocalService() {
		return cursoInscricaoCpfLocalService;
	}

	/**
	 * Sets the curso inscricao cpf local service.
	 *
	 * @param cursoInscricaoCpfLocalService the curso inscricao cpf local service
	 */
	public void setCursoInscricaoCpfLocalService(
		br.com.cnf.curso.inscricao.service.CursoInscricaoCpfLocalService cursoInscricaoCpfLocalService) {
		this.cursoInscricaoCpfLocalService = cursoInscricaoCpfLocalService;
	}

	/**
	 * Returns the curso inscricao cpf persistence.
	 *
	 * @return the curso inscricao cpf persistence
	 */
	public CursoInscricaoCpfPersistence getCursoInscricaoCpfPersistence() {
		return cursoInscricaoCpfPersistence;
	}

	/**
	 * Sets the curso inscricao cpf persistence.
	 *
	 * @param cursoInscricaoCpfPersistence the curso inscricao cpf persistence
	 */
	public void setCursoInscricaoCpfPersistence(
		CursoInscricaoCpfPersistence cursoInscricaoCpfPersistence) {
		this.cursoInscricaoCpfPersistence = cursoInscricaoCpfPersistence;
	}

	/**
	 * Returns the curso participante local service.
	 *
	 * @return the curso participante local service
	 */
	public br.com.cnf.curso.inscricao.service.CursoParticipanteLocalService getCursoParticipanteLocalService() {
		return cursoParticipanteLocalService;
	}

	/**
	 * Sets the curso participante local service.
	 *
	 * @param cursoParticipanteLocalService the curso participante local service
	 */
	public void setCursoParticipanteLocalService(
		br.com.cnf.curso.inscricao.service.CursoParticipanteLocalService cursoParticipanteLocalService) {
		this.cursoParticipanteLocalService = cursoParticipanteLocalService;
	}

	/**
	 * Returns the curso participante persistence.
	 *
	 * @return the curso participante persistence
	 */
	public CursoParticipantePersistence getCursoParticipantePersistence() {
		return cursoParticipantePersistence;
	}

	/**
	 * Sets the curso participante persistence.
	 *
	 * @param cursoParticipantePersistence the curso participante persistence
	 */
	public void setCursoParticipantePersistence(
		CursoParticipantePersistence cursoParticipantePersistence) {
		this.cursoParticipantePersistence = cursoParticipantePersistence;
	}

	/**
	 * Returns the pedido moeda digital local service.
	 *
	 * @return the pedido moeda digital local service
	 */
	public br.com.cnf.curso.inscricao.service.PedidoMoedaDigitalLocalService getPedidoMoedaDigitalLocalService() {
		return pedidoMoedaDigitalLocalService;
	}

	/**
	 * Sets the pedido moeda digital local service.
	 *
	 * @param pedidoMoedaDigitalLocalService the pedido moeda digital local service
	 */
	public void setPedidoMoedaDigitalLocalService(
		br.com.cnf.curso.inscricao.service.PedidoMoedaDigitalLocalService pedidoMoedaDigitalLocalService) {
		this.pedidoMoedaDigitalLocalService = pedidoMoedaDigitalLocalService;
	}

	/**
	 * Returns the pedido moeda digital persistence.
	 *
	 * @return the pedido moeda digital persistence
	 */
	public PedidoMoedaDigitalPersistence getPedidoMoedaDigitalPersistence() {
		return pedidoMoedaDigitalPersistence;
	}

	/**
	 * Sets the pedido moeda digital persistence.
	 *
	 * @param pedidoMoedaDigitalPersistence the pedido moeda digital persistence
	 */
	public void setPedidoMoedaDigitalPersistence(
		PedidoMoedaDigitalPersistence pedidoMoedaDigitalPersistence) {
		this.pedidoMoedaDigitalPersistence = pedidoMoedaDigitalPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("br.com.cnf.curso.inscricao.model.CursoInscricaoCpf",
			cursoInscricaoCpfLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"br.com.cnf.curso.inscricao.model.CursoInscricaoCpf");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return CursoInscricaoCpf.class;
	}

	protected String getModelClassName() {
		return CursoInscricaoCpf.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = cursoInscricaoCpfPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = br.com.cnf.curso.inscricao.service.CursoInscricaoLocalService.class)
	protected br.com.cnf.curso.inscricao.service.CursoInscricaoLocalService cursoInscricaoLocalService;
	@BeanReference(type = CursoInscricaoPersistence.class)
	protected CursoInscricaoPersistence cursoInscricaoPersistence;
	@BeanReference(type = br.com.cnf.curso.inscricao.service.CursoInscricaoCnpjLocalService.class)
	protected br.com.cnf.curso.inscricao.service.CursoInscricaoCnpjLocalService cursoInscricaoCnpjLocalService;
	@BeanReference(type = CursoInscricaoCnpjPersistence.class)
	protected CursoInscricaoCnpjPersistence cursoInscricaoCnpjPersistence;
	@BeanReference(type = br.com.cnf.curso.inscricao.service.CursoInscricaoCpfLocalService.class)
	protected br.com.cnf.curso.inscricao.service.CursoInscricaoCpfLocalService cursoInscricaoCpfLocalService;
	@BeanReference(type = CursoInscricaoCpfPersistence.class)
	protected CursoInscricaoCpfPersistence cursoInscricaoCpfPersistence;
	@BeanReference(type = br.com.cnf.curso.inscricao.service.CursoParticipanteLocalService.class)
	protected br.com.cnf.curso.inscricao.service.CursoParticipanteLocalService cursoParticipanteLocalService;
	@BeanReference(type = CursoParticipantePersistence.class)
	protected CursoParticipantePersistence cursoParticipantePersistence;
	@BeanReference(type = br.com.cnf.curso.inscricao.service.PedidoMoedaDigitalLocalService.class)
	protected br.com.cnf.curso.inscricao.service.PedidoMoedaDigitalLocalService pedidoMoedaDigitalLocalService;
	@BeanReference(type = PedidoMoedaDigitalPersistence.class)
	protected PedidoMoedaDigitalPersistence pedidoMoedaDigitalPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private CursoInscricaoCpfLocalServiceClpInvoker _clpInvoker = new CursoInscricaoCpfLocalServiceClpInvoker();
}