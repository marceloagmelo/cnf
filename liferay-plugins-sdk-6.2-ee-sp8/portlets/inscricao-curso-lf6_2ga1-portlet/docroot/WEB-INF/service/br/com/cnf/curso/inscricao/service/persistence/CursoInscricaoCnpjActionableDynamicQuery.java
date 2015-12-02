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

import br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj;
import br.com.cnf.curso.inscricao.service.CursoInscricaoCnpjLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author SEA
 * @generated
 */
public abstract class CursoInscricaoCnpjActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public CursoInscricaoCnpjActionableDynamicQuery() throws SystemException {
		setBaseLocalService(CursoInscricaoCnpjLocalServiceUtil.getService());
		setClass(CursoInscricaoCnpj.class);

		setClassLoader(br.com.cnf.curso.inscricao.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("inscricaoCnpjId");
	}
}