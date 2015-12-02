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

import br.com.cnf.curso.inscricao.model.CursoParticipante;
import br.com.cnf.curso.inscricao.service.base.CursoParticipanteLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the curso participante local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.com.cnf.curso.inscricao.service.CursoParticipanteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author SEA
 * @see br.com.cnf.curso.inscricao.service.base.CursoParticipanteLocalServiceBaseImpl
 * @see br.com.cnf.curso.inscricao.service.CursoParticipanteLocalServiceUtil
 */
public class CursoParticipanteLocalServiceImpl
	extends CursoParticipanteLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link br.com.cnf.curso.inscricao.service.CursoParticipanteLocalServiceUtil} to access the curso participante local service.
	 */
	@Override
	public CursoParticipante addCursoParticipante(CursoParticipante cursoParticipante) throws SystemException {

		// Cria a classe implementando um novo ID no banco.
		CursoParticipante novoCursoParticipante = cursoParticipantePersistence.create(counterLocalService.increment(CursoParticipante.class.getName()));
		
		// Atribui novos valores
		novoCursoParticipante.setInscricaoId(cursoParticipante.getInscricaoId());
		novoCursoParticipante.setCpf(cursoParticipante.getCpf());
		novoCursoParticipante.setNomeCompleto(cursoParticipante.getNomeCompleto());
		novoCursoParticipante.setNomeCracha(cursoParticipante.getNomeCracha());
		novoCursoParticipante.setSexo(cursoParticipante.getSexo());
		novoCursoParticipante.setDddTelefoneComercial(cursoParticipante.getDddTelefoneComercial());
		novoCursoParticipante.setTelefoneComercial(cursoParticipante.getTelefoneComercial());
		novoCursoParticipante.setDddTelefonePessoal(cursoParticipante.getDddTelefonePessoal());
		novoCursoParticipante.setTelefonePessoal(cursoParticipante.getTelefonePessoal());
		novoCursoParticipante.setDddTelefoneCelular(cursoParticipante.getDddTelefoneCelular());
		novoCursoParticipante.setTelefoneCelular(cursoParticipante.getTelefoneCelular());
		novoCursoParticipante.setEmailPrincipal(cursoParticipante.getEmailPrincipal());
		novoCursoParticipante.setEmailOpcional(cursoParticipante.getEmailOpcional());
		novoCursoParticipante.setFormacaoAcademica(cursoParticipante.getFormacaoAcademica());
		novoCursoParticipante.setCargo(cursoParticipante.getCargo());
		novoCursoParticipante.setDepartamento(cursoParticipante.getDepartamento());
		novoCursoParticipante.setEndereco(cursoParticipante.getEndereco());
		novoCursoParticipante.setBairro(cursoParticipante.getBairro());
		novoCursoParticipante.setCidade(cursoParticipante.getCidade());
		novoCursoParticipante.setEstado(cursoParticipante.getEstado());
		novoCursoParticipante.setCep(cursoParticipante.getCep());
		novoCursoParticipante.setExpectativaCurso(cursoParticipante.getExpectativaCurso());
		novoCursoParticipante.setObservacao(cursoParticipante.getObservacao());
		novoCursoParticipante.setValorPago(cursoParticipante.getValorPago());

		return super.addCursoParticipante(novoCursoParticipante);
	}
}