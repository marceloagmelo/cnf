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

import br.com.cnf.curso.inscricao.model.CursoInscricaoCpf;
import br.com.cnf.curso.inscricao.service.base.CursoInscricaoCpfLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the curso inscricao cpf local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.com.cnf.curso.inscricao.service.CursoInscricaoCpfLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author SEA
 * @see br.com.cnf.curso.inscricao.service.base.CursoInscricaoCpfLocalServiceBaseImpl
 * @see br.com.cnf.curso.inscricao.service.CursoInscricaoCpfLocalServiceUtil
 */
public class CursoInscricaoCpfLocalServiceImpl
	extends CursoInscricaoCpfLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link br.com.cnf.curso.inscricao.service.CursoInscricaoCpfLocalServiceUtil} to access the curso inscricao cpf local service.
	 */
	@Override
	public CursoInscricaoCpf addCursoInscricaoCpf(CursoInscricaoCpf cursoInscricaoCpf)
			throws SystemException {

		// Cria a classe implementando um novo ID no banco.
		CursoInscricaoCpf novoCursoInscricaoCpf = cursoInscricaoCpfPersistence
				.create(counterLocalService.increment(CursoInscricaoCpf.class
						.getName()));

		// Atribui novos valores
		novoCursoInscricaoCpf.setInscricaoId(cursoInscricaoCpf.getInscricaoId());
		novoCursoInscricaoCpf.setCpf(cursoInscricaoCpf.getCpf());
		novoCursoInscricaoCpf.setNome(cursoInscricaoCpf.getNome());
		novoCursoInscricaoCpf.setEndereco(cursoInscricaoCpf.getEndereco());
		novoCursoInscricaoCpf.setBairro(cursoInscricaoCpf.getBairro());
		novoCursoInscricaoCpf.setCidade(cursoInscricaoCpf.getCidade());
		novoCursoInscricaoCpf.setEstado(cursoInscricaoCpf.getEstado());
		novoCursoInscricaoCpf.setCep(cursoInscricaoCpf.getCep());
		novoCursoInscricaoCpf.setDddTelefone(cursoInscricaoCpf.getDddTelefone());
		novoCursoInscricaoCpf.setTelefone(cursoInscricaoCpf.getTelefone());
		novoCursoInscricaoCpf.setEmail(cursoInscricaoCpf.getEmail());

		return super.addCursoInscricaoCpf(novoCursoInscricaoCpf);
	}
}