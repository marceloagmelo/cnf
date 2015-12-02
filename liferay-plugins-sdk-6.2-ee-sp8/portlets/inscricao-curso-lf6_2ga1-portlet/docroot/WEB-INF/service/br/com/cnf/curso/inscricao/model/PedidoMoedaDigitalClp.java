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

package br.com.cnf.curso.inscricao.model;

import br.com.cnf.curso.inscricao.service.ClpSerializer;
import br.com.cnf.curso.inscricao.service.PedidoMoedaDigitalLocalServiceUtil;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author SEA
 */
public class PedidoMoedaDigitalClp extends BaseModelImpl<PedidoMoedaDigital>
	implements PedidoMoedaDigital {
	public PedidoMoedaDigitalClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PedidoMoedaDigital.class;
	}

	@Override
	public String getModelClassName() {
		return PedidoMoedaDigital.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _pedidoMoedaDigitalId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPedidoMoedaDigitalId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _pedidoMoedaDigitalId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("pedidoMoedaDigitalId", getPedidoMoedaDigitalId());
		attributes.put("inscricaoId", getInscricaoId());
		attributes.put("dataPedido", getDataPedido());
		attributes.put("xmlEnvio", getXmlEnvio());
		attributes.put("xmlRetorno", getXmlRetorno());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long pedidoMoedaDigitalId = (Long)attributes.get("pedidoMoedaDigitalId");

		if (pedidoMoedaDigitalId != null) {
			setPedidoMoedaDigitalId(pedidoMoedaDigitalId);
		}

		Long inscricaoId = (Long)attributes.get("inscricaoId");

		if (inscricaoId != null) {
			setInscricaoId(inscricaoId);
		}

		Date dataPedido = (Date)attributes.get("dataPedido");

		if (dataPedido != null) {
			setDataPedido(dataPedido);
		}

		String xmlEnvio = (String)attributes.get("xmlEnvio");

		if (xmlEnvio != null) {
			setXmlEnvio(xmlEnvio);
		}

		String xmlRetorno = (String)attributes.get("xmlRetorno");

		if (xmlRetorno != null) {
			setXmlRetorno(xmlRetorno);
		}
	}

	@Override
	public long getPedidoMoedaDigitalId() {
		return _pedidoMoedaDigitalId;
	}

	@Override
	public void setPedidoMoedaDigitalId(long pedidoMoedaDigitalId) {
		_pedidoMoedaDigitalId = pedidoMoedaDigitalId;

		if (_pedidoMoedaDigitalRemoteModel != null) {
			try {
				Class<?> clazz = _pedidoMoedaDigitalRemoteModel.getClass();

				Method method = clazz.getMethod("setPedidoMoedaDigitalId",
						long.class);

				method.invoke(_pedidoMoedaDigitalRemoteModel,
					pedidoMoedaDigitalId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getInscricaoId() {
		return _inscricaoId;
	}

	@Override
	public void setInscricaoId(long inscricaoId) {
		_inscricaoId = inscricaoId;

		if (_pedidoMoedaDigitalRemoteModel != null) {
			try {
				Class<?> clazz = _pedidoMoedaDigitalRemoteModel.getClass();

				Method method = clazz.getMethod("setInscricaoId", long.class);

				method.invoke(_pedidoMoedaDigitalRemoteModel, inscricaoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDataPedido() {
		return _dataPedido;
	}

	@Override
	public void setDataPedido(Date dataPedido) {
		_dataPedido = dataPedido;

		if (_pedidoMoedaDigitalRemoteModel != null) {
			try {
				Class<?> clazz = _pedidoMoedaDigitalRemoteModel.getClass();

				Method method = clazz.getMethod("setDataPedido", Date.class);

				method.invoke(_pedidoMoedaDigitalRemoteModel, dataPedido);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXmlEnvio() {
		return _xmlEnvio;
	}

	@Override
	public String getXmlEnvio(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getXmlEnvio(languageId);
	}

	@Override
	public String getXmlEnvio(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getXmlEnvio(languageId, useDefault);
	}

	@Override
	public String getXmlEnvio(String languageId) {
		return LocalizationUtil.getLocalization(getXmlEnvio(), languageId);
	}

	@Override
	public String getXmlEnvio(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getXmlEnvio(), languageId,
			useDefault);
	}

	@Override
	public String getXmlEnvioCurrentLanguageId() {
		return _xmlEnvioCurrentLanguageId;
	}

	@Override
	public String getXmlEnvioCurrentValue() {
		Locale locale = getLocale(_xmlEnvioCurrentLanguageId);

		return getXmlEnvio(locale);
	}

	@Override
	public Map<Locale, String> getXmlEnvioMap() {
		return LocalizationUtil.getLocalizationMap(getXmlEnvio());
	}

	@Override
	public void setXmlEnvio(String xmlEnvio) {
		_xmlEnvio = xmlEnvio;

		if (_pedidoMoedaDigitalRemoteModel != null) {
			try {
				Class<?> clazz = _pedidoMoedaDigitalRemoteModel.getClass();

				Method method = clazz.getMethod("setXmlEnvio", String.class);

				method.invoke(_pedidoMoedaDigitalRemoteModel, xmlEnvio);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setXmlEnvio(String xmlEnvio, Locale locale) {
		setXmlEnvio(xmlEnvio, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setXmlEnvio(String xmlEnvio, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(xmlEnvio)) {
			setXmlEnvio(LocalizationUtil.updateLocalization(getXmlEnvio(),
					"XmlEnvio", xmlEnvio, languageId, defaultLanguageId));
		}
		else {
			setXmlEnvio(LocalizationUtil.removeLocalization(getXmlEnvio(),
					"XmlEnvio", languageId));
		}
	}

	@Override
	public void setXmlEnvioCurrentLanguageId(String languageId) {
		_xmlEnvioCurrentLanguageId = languageId;
	}

	@Override
	public void setXmlEnvioMap(Map<Locale, String> xmlEnvioMap) {
		setXmlEnvioMap(xmlEnvioMap, LocaleUtil.getDefault());
	}

	@Override
	public void setXmlEnvioMap(Map<Locale, String> xmlEnvioMap,
		Locale defaultLocale) {
		if (xmlEnvioMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setXmlEnvio(LocalizationUtil.updateLocalization(xmlEnvioMap,
					getXmlEnvio(), "XmlEnvio",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getXmlRetorno() {
		return _xmlRetorno;
	}

	@Override
	public String getXmlRetorno(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getXmlRetorno(languageId);
	}

	@Override
	public String getXmlRetorno(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getXmlRetorno(languageId, useDefault);
	}

	@Override
	public String getXmlRetorno(String languageId) {
		return LocalizationUtil.getLocalization(getXmlRetorno(), languageId);
	}

	@Override
	public String getXmlRetorno(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getXmlRetorno(), languageId,
			useDefault);
	}

	@Override
	public String getXmlRetornoCurrentLanguageId() {
		return _xmlRetornoCurrentLanguageId;
	}

	@Override
	public String getXmlRetornoCurrentValue() {
		Locale locale = getLocale(_xmlRetornoCurrentLanguageId);

		return getXmlRetorno(locale);
	}

	@Override
	public Map<Locale, String> getXmlRetornoMap() {
		return LocalizationUtil.getLocalizationMap(getXmlRetorno());
	}

	@Override
	public void setXmlRetorno(String xmlRetorno) {
		_xmlRetorno = xmlRetorno;

		if (_pedidoMoedaDigitalRemoteModel != null) {
			try {
				Class<?> clazz = _pedidoMoedaDigitalRemoteModel.getClass();

				Method method = clazz.getMethod("setXmlRetorno", String.class);

				method.invoke(_pedidoMoedaDigitalRemoteModel, xmlRetorno);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setXmlRetorno(String xmlRetorno, Locale locale) {
		setXmlRetorno(xmlRetorno, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setXmlRetorno(String xmlRetorno, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(xmlRetorno)) {
			setXmlRetorno(LocalizationUtil.updateLocalization(getXmlRetorno(),
					"XmlRetorno", xmlRetorno, languageId, defaultLanguageId));
		}
		else {
			setXmlRetorno(LocalizationUtil.removeLocalization(getXmlRetorno(),
					"XmlRetorno", languageId));
		}
	}

	@Override
	public void setXmlRetornoCurrentLanguageId(String languageId) {
		_xmlRetornoCurrentLanguageId = languageId;
	}

	@Override
	public void setXmlRetornoMap(Map<Locale, String> xmlRetornoMap) {
		setXmlRetornoMap(xmlRetornoMap, LocaleUtil.getDefault());
	}

	@Override
	public void setXmlRetornoMap(Map<Locale, String> xmlRetornoMap,
		Locale defaultLocale) {
		if (xmlRetornoMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setXmlRetorno(LocalizationUtil.updateLocalization(xmlRetornoMap,
					getXmlRetorno(), "XmlRetorno",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	public BaseModel<?> getPedidoMoedaDigitalRemoteModel() {
		return _pedidoMoedaDigitalRemoteModel;
	}

	public void setPedidoMoedaDigitalRemoteModel(
		BaseModel<?> pedidoMoedaDigitalRemoteModel) {
		_pedidoMoedaDigitalRemoteModel = pedidoMoedaDigitalRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _pedidoMoedaDigitalRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_pedidoMoedaDigitalRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PedidoMoedaDigitalLocalServiceUtil.addPedidoMoedaDigital(this);
		}
		else {
			PedidoMoedaDigitalLocalServiceUtil.updatePedidoMoedaDigital(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> xmlEnvioMap = getXmlEnvioMap();

		for (Map.Entry<Locale, String> entry : xmlEnvioMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> xmlRetornoMap = getXmlRetornoMap();

		for (Map.Entry<Locale, String> entry : xmlRetornoMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getXmlEnvio();

		if (xml == null) {
			return StringPool.BLANK;
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		prepareLocalizedFieldsForImport(null);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String xmlEnvio = getXmlEnvio(defaultLocale);

		if (Validator.isNull(xmlEnvio)) {
			setXmlEnvio(getXmlEnvio(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setXmlEnvio(getXmlEnvio(defaultLocale), defaultLocale, defaultLocale);
		}

		String xmlRetorno = getXmlRetorno(defaultLocale);

		if (Validator.isNull(xmlRetorno)) {
			setXmlRetorno(getXmlRetorno(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setXmlRetorno(getXmlRetorno(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public PedidoMoedaDigital toEscapedModel() {
		return (PedidoMoedaDigital)ProxyUtil.newProxyInstance(PedidoMoedaDigital.class.getClassLoader(),
			new Class[] { PedidoMoedaDigital.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PedidoMoedaDigitalClp clone = new PedidoMoedaDigitalClp();

		clone.setPedidoMoedaDigitalId(getPedidoMoedaDigitalId());
		clone.setInscricaoId(getInscricaoId());
		clone.setDataPedido(getDataPedido());
		clone.setXmlEnvio(getXmlEnvio());
		clone.setXmlRetorno(getXmlRetorno());

		return clone;
	}

	@Override
	public int compareTo(PedidoMoedaDigital pedidoMoedaDigital) {
		long primaryKey = pedidoMoedaDigital.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PedidoMoedaDigitalClp)) {
			return false;
		}

		PedidoMoedaDigitalClp pedidoMoedaDigital = (PedidoMoedaDigitalClp)obj;

		long primaryKey = pedidoMoedaDigital.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{pedidoMoedaDigitalId=");
		sb.append(getPedidoMoedaDigitalId());
		sb.append(", inscricaoId=");
		sb.append(getInscricaoId());
		sb.append(", dataPedido=");
		sb.append(getDataPedido());
		sb.append(", xmlEnvio=");
		sb.append(getXmlEnvio());
		sb.append(", xmlRetorno=");
		sb.append(getXmlRetorno());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("br.com.cnf.curso.inscricao.model.PedidoMoedaDigital");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>pedidoMoedaDigitalId</column-name><column-value><![CDATA[");
		sb.append(getPedidoMoedaDigitalId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inscricaoId</column-name><column-value><![CDATA[");
		sb.append(getInscricaoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataPedido</column-name><column-value><![CDATA[");
		sb.append(getDataPedido());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmlEnvio</column-name><column-value><![CDATA[");
		sb.append(getXmlEnvio());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmlRetorno</column-name><column-value><![CDATA[");
		sb.append(getXmlRetorno());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _pedidoMoedaDigitalId;
	private long _inscricaoId;
	private Date _dataPedido;
	private String _xmlEnvio;
	private String _xmlEnvioCurrentLanguageId;
	private String _xmlRetorno;
	private String _xmlRetornoCurrentLanguageId;
	private BaseModel<?> _pedidoMoedaDigitalRemoteModel;
	private Class<?> _clpSerializerClass = br.com.cnf.curso.inscricao.service.ClpSerializer.class;
}