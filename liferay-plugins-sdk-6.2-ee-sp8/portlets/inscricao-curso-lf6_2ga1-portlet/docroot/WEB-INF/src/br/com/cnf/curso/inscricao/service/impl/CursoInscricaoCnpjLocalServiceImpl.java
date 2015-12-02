/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package br.com.cnf.curso.inscricao.service.impl;

import br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj;
import br.com.cnf.curso.inscricao.service.base.CursoInscricaoCnpjLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the curso inscricao cnpj local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.com.cnf.curso.inscricao.service.CursoInscricaoCnpjLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author SEA
 * @see br.com.cnf.curso.inscricao.service.base.CursoInscricaoCnpjLocalServiceBaseImpl
 * @see br.com.cnf.curso.inscricao.service.CursoInscricaoCnpjLocalServiceUtil
 */
public class CursoInscricaoCnpjLocalServiceImpl
	extends CursoInscricaoCnpjLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link br.com.cnf.curso.inscricao.service.CursoInscricaoCnpjLocalServiceUtil} to access the curso inscricao cnpj local service.
	 */
	@Override
	public CursoInscricaoCnpj addCursoInscricaoCnpj(CursoInscricaoCnpj cursoInscricaoCnpj)
			throws SystemException {

		// Cria a classe implementando um novo ID no banco.
		CursoInscricaoCnpj novoCursoInscricaoCnpj = cursoInscricaoCnpjPersistence
				.create(counterLocalService.increment(CursoInscricaoCnpj.class
						.getName()));

		// Atribui novos valores
		novoCursoInscricaoCnpj.setInscricaoId(cursoInscricaoCnpj.getInscricaoId());
		novoCursoInscricaoCnpj.setRazaoSocial(cursoInscricaoCnpj.getRazaoSocial());
		novoCursoInscricaoCnpj.setNomeFantasia(cursoInscricaoCnpj.getNomeFantasia());
		novoCursoInscricaoCnpj.setInscricaoEstadual(cursoInscricaoCnpj.getInscricaoEstadual());
		novoCursoInscricaoCnpj.setEndereco(cursoInscricaoCnpj.getEndereco());
		novoCursoInscricaoCnpj.setBairro(cursoInscricaoCnpj.getBairro());
		novoCursoInscricaoCnpj.setCidade(cursoInscricaoCnpj.getCidade());
		novoCursoInscricaoCnpj.setEstado(cursoInscricaoCnpj.getEstado());
		novoCursoInscricaoCnpj.setCep(cursoInscricaoCnpj.getCep());
		novoCursoInscricaoCnpj.setDddTelefone(cursoInscricaoCnpj.getDddTelefone());
		novoCursoInscricaoCnpj.setTelefone(cursoInscricaoCnpj.getTelefone());
		novoCursoInscricaoCnpj.setNfNome(cursoInscricaoCnpj.getNfNome());
		novoCursoInscricaoCnpj.setNfDepartamento(cursoInscricaoCnpj.getNfDepartamento());
		novoCursoInscricaoCnpj.setNfEmail(cursoInscricaoCnpj.getNfEmail());
		novoCursoInscricaoCnpj.setNfDddTelefone(cursoInscricaoCnpj.getNfDddTelefone());
		novoCursoInscricaoCnpj.setNfTelefone(cursoInscricaoCnpj.getNfTelefone());

		return super.addCursoInscricaoCnpj(novoCursoInscricaoCnpj);
	}
}