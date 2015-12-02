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

package br.com.cnf.curso.inscricao.service;

import br.com.cnf.curso.inscricao.model.CursoInscricaoClp;
import br.com.cnf.curso.inscricao.model.CursoInscricaoCnpjClp;
import br.com.cnf.curso.inscricao.model.CursoInscricaoCpfClp;
import br.com.cnf.curso.inscricao.model.CursoParticipanteClp;
import br.com.cnf.curso.inscricao.model.PedidoMoedaDigitalClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SEA
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"inscricao-curso-lf6_2ga1-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"inscricao-curso-lf6_2ga1-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "inscricao-curso-lf6_2ga1-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CursoInscricaoClp.class.getName())) {
			return translateInputCursoInscricao(oldModel);
		}

		if (oldModelClassName.equals(CursoInscricaoCnpjClp.class.getName())) {
			return translateInputCursoInscricaoCnpj(oldModel);
		}

		if (oldModelClassName.equals(CursoInscricaoCpfClp.class.getName())) {
			return translateInputCursoInscricaoCpf(oldModel);
		}

		if (oldModelClassName.equals(CursoParticipanteClp.class.getName())) {
			return translateInputCursoParticipante(oldModel);
		}

		if (oldModelClassName.equals(PedidoMoedaDigitalClp.class.getName())) {
			return translateInputPedidoMoedaDigital(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputCursoInscricao(BaseModel<?> oldModel) {
		CursoInscricaoClp oldClpModel = (CursoInscricaoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCursoInscricaoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCursoInscricaoCnpj(BaseModel<?> oldModel) {
		CursoInscricaoCnpjClp oldClpModel = (CursoInscricaoCnpjClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCursoInscricaoCnpjRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCursoInscricaoCpf(BaseModel<?> oldModel) {
		CursoInscricaoCpfClp oldClpModel = (CursoInscricaoCpfClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCursoInscricaoCpfRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCursoParticipante(BaseModel<?> oldModel) {
		CursoParticipanteClp oldClpModel = (CursoParticipanteClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCursoParticipanteRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPedidoMoedaDigital(BaseModel<?> oldModel) {
		PedidoMoedaDigitalClp oldClpModel = (PedidoMoedaDigitalClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPedidoMoedaDigitalRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"br.com.cnf.curso.inscricao.model.impl.CursoInscricaoImpl")) {
			return translateOutputCursoInscricao(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCnpjImpl")) {
			return translateOutputCursoInscricaoCnpj(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"br.com.cnf.curso.inscricao.model.impl.CursoInscricaoCpfImpl")) {
			return translateOutputCursoInscricaoCpf(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"br.com.cnf.curso.inscricao.model.impl.CursoParticipanteImpl")) {
			return translateOutputCursoParticipante(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"br.com.cnf.curso.inscricao.model.impl.PedidoMoedaDigitalImpl")) {
			return translateOutputPedidoMoedaDigital(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException")) {
			return new br.com.cnf.curso.inscricao.NoSuchCursoInscricaoException();
		}

		if (className.equals(
					"br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCnpjException")) {
			return new br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCnpjException();
		}

		if (className.equals(
					"br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCpfException")) {
			return new br.com.cnf.curso.inscricao.NoSuchCursoInscricaoCpfException();
		}

		if (className.equals(
					"br.com.cnf.curso.inscricao.NoSuchCursoParticipanteException")) {
			return new br.com.cnf.curso.inscricao.NoSuchCursoParticipanteException();
		}

		if (className.equals(
					"br.com.cnf.curso.inscricao.NoSuchPedidoMoedaDigitalException")) {
			return new br.com.cnf.curso.inscricao.NoSuchPedidoMoedaDigitalException();
		}

		return throwable;
	}

	public static Object translateOutputCursoInscricao(BaseModel<?> oldModel) {
		CursoInscricaoClp newModel = new CursoInscricaoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCursoInscricaoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCursoInscricaoCnpj(
		BaseModel<?> oldModel) {
		CursoInscricaoCnpjClp newModel = new CursoInscricaoCnpjClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCursoInscricaoCnpjRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCursoInscricaoCpf(BaseModel<?> oldModel) {
		CursoInscricaoCpfClp newModel = new CursoInscricaoCpfClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCursoInscricaoCpfRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCursoParticipante(BaseModel<?> oldModel) {
		CursoParticipanteClp newModel = new CursoParticipanteClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCursoParticipanteRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPedidoMoedaDigital(
		BaseModel<?> oldModel) {
		PedidoMoedaDigitalClp newModel = new PedidoMoedaDigitalClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPedidoMoedaDigitalRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}