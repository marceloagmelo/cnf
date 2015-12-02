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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PedidoMoedaDigital}.
 * </p>
 *
 * @author SEA
 * @see PedidoMoedaDigital
 * @generated
 */
public class PedidoMoedaDigitalWrapper implements PedidoMoedaDigital,
	ModelWrapper<PedidoMoedaDigital> {
	public PedidoMoedaDigitalWrapper(PedidoMoedaDigital pedidoMoedaDigital) {
		_pedidoMoedaDigital = pedidoMoedaDigital;
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

	/**
	* Returns the primary key of this pedido moeda digital.
	*
	* @return the primary key of this pedido moeda digital
	*/
	@Override
	public long getPrimaryKey() {
		return _pedidoMoedaDigital.getPrimaryKey();
	}

	/**
	* Sets the primary key of this pedido moeda digital.
	*
	* @param primaryKey the primary key of this pedido moeda digital
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_pedidoMoedaDigital.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the pedido moeda digital ID of this pedido moeda digital.
	*
	* @return the pedido moeda digital ID of this pedido moeda digital
	*/
	@Override
	public long getPedidoMoedaDigitalId() {
		return _pedidoMoedaDigital.getPedidoMoedaDigitalId();
	}

	/**
	* Sets the pedido moeda digital ID of this pedido moeda digital.
	*
	* @param pedidoMoedaDigitalId the pedido moeda digital ID of this pedido moeda digital
	*/
	@Override
	public void setPedidoMoedaDigitalId(long pedidoMoedaDigitalId) {
		_pedidoMoedaDigital.setPedidoMoedaDigitalId(pedidoMoedaDigitalId);
	}

	/**
	* Returns the inscricao ID of this pedido moeda digital.
	*
	* @return the inscricao ID of this pedido moeda digital
	*/
	@Override
	public long getInscricaoId() {
		return _pedidoMoedaDigital.getInscricaoId();
	}

	/**
	* Sets the inscricao ID of this pedido moeda digital.
	*
	* @param inscricaoId the inscricao ID of this pedido moeda digital
	*/
	@Override
	public void setInscricaoId(long inscricaoId) {
		_pedidoMoedaDigital.setInscricaoId(inscricaoId);
	}

	/**
	* Returns the data pedido of this pedido moeda digital.
	*
	* @return the data pedido of this pedido moeda digital
	*/
	@Override
	public java.util.Date getDataPedido() {
		return _pedidoMoedaDigital.getDataPedido();
	}

	/**
	* Sets the data pedido of this pedido moeda digital.
	*
	* @param dataPedido the data pedido of this pedido moeda digital
	*/
	@Override
	public void setDataPedido(java.util.Date dataPedido) {
		_pedidoMoedaDigital.setDataPedido(dataPedido);
	}

	/**
	* Returns the xml envio of this pedido moeda digital.
	*
	* @return the xml envio of this pedido moeda digital
	*/
	@Override
	public java.lang.String getXmlEnvio() {
		return _pedidoMoedaDigital.getXmlEnvio();
	}

	/**
	* Returns the localized xml envio of this pedido moeda digital in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized xml envio of this pedido moeda digital
	*/
	@Override
	public java.lang.String getXmlEnvio(java.util.Locale locale) {
		return _pedidoMoedaDigital.getXmlEnvio(locale);
	}

	/**
	* Returns the localized xml envio of this pedido moeda digital in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized xml envio of this pedido moeda digital. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getXmlEnvio(java.util.Locale locale,
		boolean useDefault) {
		return _pedidoMoedaDigital.getXmlEnvio(locale, useDefault);
	}

	/**
	* Returns the localized xml envio of this pedido moeda digital in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized xml envio of this pedido moeda digital
	*/
	@Override
	public java.lang.String getXmlEnvio(java.lang.String languageId) {
		return _pedidoMoedaDigital.getXmlEnvio(languageId);
	}

	/**
	* Returns the localized xml envio of this pedido moeda digital in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized xml envio of this pedido moeda digital
	*/
	@Override
	public java.lang.String getXmlEnvio(java.lang.String languageId,
		boolean useDefault) {
		return _pedidoMoedaDigital.getXmlEnvio(languageId, useDefault);
	}

	@Override
	public java.lang.String getXmlEnvioCurrentLanguageId() {
		return _pedidoMoedaDigital.getXmlEnvioCurrentLanguageId();
	}

	@Override
	public java.lang.String getXmlEnvioCurrentValue() {
		return _pedidoMoedaDigital.getXmlEnvioCurrentValue();
	}

	/**
	* Returns a map of the locales and localized xml envios of this pedido moeda digital.
	*
	* @return the locales and localized xml envios of this pedido moeda digital
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getXmlEnvioMap() {
		return _pedidoMoedaDigital.getXmlEnvioMap();
	}

	/**
	* Sets the xml envio of this pedido moeda digital.
	*
	* @param xmlEnvio the xml envio of this pedido moeda digital
	*/
	@Override
	public void setXmlEnvio(java.lang.String xmlEnvio) {
		_pedidoMoedaDigital.setXmlEnvio(xmlEnvio);
	}

	/**
	* Sets the localized xml envio of this pedido moeda digital in the language.
	*
	* @param xmlEnvio the localized xml envio of this pedido moeda digital
	* @param locale the locale of the language
	*/
	@Override
	public void setXmlEnvio(java.lang.String xmlEnvio, java.util.Locale locale) {
		_pedidoMoedaDigital.setXmlEnvio(xmlEnvio, locale);
	}

	/**
	* Sets the localized xml envio of this pedido moeda digital in the language, and sets the default locale.
	*
	* @param xmlEnvio the localized xml envio of this pedido moeda digital
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setXmlEnvio(java.lang.String xmlEnvio, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_pedidoMoedaDigital.setXmlEnvio(xmlEnvio, locale, defaultLocale);
	}

	@Override
	public void setXmlEnvioCurrentLanguageId(java.lang.String languageId) {
		_pedidoMoedaDigital.setXmlEnvioCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized xml envios of this pedido moeda digital from the map of locales and localized xml envios.
	*
	* @param xmlEnvioMap the locales and localized xml envios of this pedido moeda digital
	*/
	@Override
	public void setXmlEnvioMap(
		java.util.Map<java.util.Locale, java.lang.String> xmlEnvioMap) {
		_pedidoMoedaDigital.setXmlEnvioMap(xmlEnvioMap);
	}

	/**
	* Sets the localized xml envios of this pedido moeda digital from the map of locales and localized xml envios, and sets the default locale.
	*
	* @param xmlEnvioMap the locales and localized xml envios of this pedido moeda digital
	* @param defaultLocale the default locale
	*/
	@Override
	public void setXmlEnvioMap(
		java.util.Map<java.util.Locale, java.lang.String> xmlEnvioMap,
		java.util.Locale defaultLocale) {
		_pedidoMoedaDigital.setXmlEnvioMap(xmlEnvioMap, defaultLocale);
	}

	/**
	* Returns the xml retorno of this pedido moeda digital.
	*
	* @return the xml retorno of this pedido moeda digital
	*/
	@Override
	public java.lang.String getXmlRetorno() {
		return _pedidoMoedaDigital.getXmlRetorno();
	}

	/**
	* Returns the localized xml retorno of this pedido moeda digital in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized xml retorno of this pedido moeda digital
	*/
	@Override
	public java.lang.String getXmlRetorno(java.util.Locale locale) {
		return _pedidoMoedaDigital.getXmlRetorno(locale);
	}

	/**
	* Returns the localized xml retorno of this pedido moeda digital in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized xml retorno of this pedido moeda digital. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getXmlRetorno(java.util.Locale locale,
		boolean useDefault) {
		return _pedidoMoedaDigital.getXmlRetorno(locale, useDefault);
	}

	/**
	* Returns the localized xml retorno of this pedido moeda digital in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized xml retorno of this pedido moeda digital
	*/
	@Override
	public java.lang.String getXmlRetorno(java.lang.String languageId) {
		return _pedidoMoedaDigital.getXmlRetorno(languageId);
	}

	/**
	* Returns the localized xml retorno of this pedido moeda digital in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized xml retorno of this pedido moeda digital
	*/
	@Override
	public java.lang.String getXmlRetorno(java.lang.String languageId,
		boolean useDefault) {
		return _pedidoMoedaDigital.getXmlRetorno(languageId, useDefault);
	}

	@Override
	public java.lang.String getXmlRetornoCurrentLanguageId() {
		return _pedidoMoedaDigital.getXmlRetornoCurrentLanguageId();
	}

	@Override
	public java.lang.String getXmlRetornoCurrentValue() {
		return _pedidoMoedaDigital.getXmlRetornoCurrentValue();
	}

	/**
	* Returns a map of the locales and localized xml retornos of this pedido moeda digital.
	*
	* @return the locales and localized xml retornos of this pedido moeda digital
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getXmlRetornoMap() {
		return _pedidoMoedaDigital.getXmlRetornoMap();
	}

	/**
	* Sets the xml retorno of this pedido moeda digital.
	*
	* @param xmlRetorno the xml retorno of this pedido moeda digital
	*/
	@Override
	public void setXmlRetorno(java.lang.String xmlRetorno) {
		_pedidoMoedaDigital.setXmlRetorno(xmlRetorno);
	}

	/**
	* Sets the localized xml retorno of this pedido moeda digital in the language.
	*
	* @param xmlRetorno the localized xml retorno of this pedido moeda digital
	* @param locale the locale of the language
	*/
	@Override
	public void setXmlRetorno(java.lang.String xmlRetorno,
		java.util.Locale locale) {
		_pedidoMoedaDigital.setXmlRetorno(xmlRetorno, locale);
	}

	/**
	* Sets the localized xml retorno of this pedido moeda digital in the language, and sets the default locale.
	*
	* @param xmlRetorno the localized xml retorno of this pedido moeda digital
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setXmlRetorno(java.lang.String xmlRetorno,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_pedidoMoedaDigital.setXmlRetorno(xmlRetorno, locale, defaultLocale);
	}

	@Override
	public void setXmlRetornoCurrentLanguageId(java.lang.String languageId) {
		_pedidoMoedaDigital.setXmlRetornoCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized xml retornos of this pedido moeda digital from the map of locales and localized xml retornos.
	*
	* @param xmlRetornoMap the locales and localized xml retornos of this pedido moeda digital
	*/
	@Override
	public void setXmlRetornoMap(
		java.util.Map<java.util.Locale, java.lang.String> xmlRetornoMap) {
		_pedidoMoedaDigital.setXmlRetornoMap(xmlRetornoMap);
	}

	/**
	* Sets the localized xml retornos of this pedido moeda digital from the map of locales and localized xml retornos, and sets the default locale.
	*
	* @param xmlRetornoMap the locales and localized xml retornos of this pedido moeda digital
	* @param defaultLocale the default locale
	*/
	@Override
	public void setXmlRetornoMap(
		java.util.Map<java.util.Locale, java.lang.String> xmlRetornoMap,
		java.util.Locale defaultLocale) {
		_pedidoMoedaDigital.setXmlRetornoMap(xmlRetornoMap, defaultLocale);
	}

	@Override
	public boolean isNew() {
		return _pedidoMoedaDigital.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_pedidoMoedaDigital.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _pedidoMoedaDigital.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_pedidoMoedaDigital.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _pedidoMoedaDigital.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _pedidoMoedaDigital.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_pedidoMoedaDigital.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _pedidoMoedaDigital.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_pedidoMoedaDigital.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_pedidoMoedaDigital.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_pedidoMoedaDigital.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _pedidoMoedaDigital.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _pedidoMoedaDigital.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_pedidoMoedaDigital.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_pedidoMoedaDigital.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new PedidoMoedaDigitalWrapper((PedidoMoedaDigital)_pedidoMoedaDigital.clone());
	}

	@Override
	public int compareTo(
		br.com.cnf.curso.inscricao.model.PedidoMoedaDigital pedidoMoedaDigital) {
		return _pedidoMoedaDigital.compareTo(pedidoMoedaDigital);
	}

	@Override
	public int hashCode() {
		return _pedidoMoedaDigital.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<br.com.cnf.curso.inscricao.model.PedidoMoedaDigital> toCacheModel() {
		return _pedidoMoedaDigital.toCacheModel();
	}

	@Override
	public br.com.cnf.curso.inscricao.model.PedidoMoedaDigital toEscapedModel() {
		return new PedidoMoedaDigitalWrapper(_pedidoMoedaDigital.toEscapedModel());
	}

	@Override
	public br.com.cnf.curso.inscricao.model.PedidoMoedaDigital toUnescapedModel() {
		return new PedidoMoedaDigitalWrapper(_pedidoMoedaDigital.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _pedidoMoedaDigital.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _pedidoMoedaDigital.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_pedidoMoedaDigital.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PedidoMoedaDigitalWrapper)) {
			return false;
		}

		PedidoMoedaDigitalWrapper pedidoMoedaDigitalWrapper = (PedidoMoedaDigitalWrapper)obj;

		if (Validator.equals(_pedidoMoedaDigital,
					pedidoMoedaDigitalWrapper._pedidoMoedaDigital)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PedidoMoedaDigital getWrappedPedidoMoedaDigital() {
		return _pedidoMoedaDigital;
	}

	@Override
	public PedidoMoedaDigital getWrappedModel() {
		return _pedidoMoedaDigital;
	}

	@Override
	public void resetOriginalValues() {
		_pedidoMoedaDigital.resetOriginalValues();
	}

	private PedidoMoedaDigital _pedidoMoedaDigital;
}