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

package br.com.cnf.curso.inscricao;

import com.liferay.portal.NoSuchModelException;

/**
 * @author SEA
 */
public class NoSuchCursoInscricaoException extends NoSuchModelException {

	public NoSuchCursoInscricaoException() {
		super();
	}

	public NoSuchCursoInscricaoException(String msg) {
		super(msg);
	}

	public NoSuchCursoInscricaoException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchCursoInscricaoException(Throwable cause) {
		super(cause);
	}

}