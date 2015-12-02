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

import br.com.cnf.curso.inscricao.model.CursoInscricao;
import br.com.cnf.curso.inscricao.service.base.CursoInscricaoLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the curso inscricao local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.com.cnf.curso.inscricao.service.CursoInscricaoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author SEA
 * @see br.com.cnf.curso.inscricao.service.base.CursoInscricaoLocalServiceBaseImpl
 * @see br.com.cnf.curso.inscricao.service.CursoInscricaoLocalServiceUtil
 */
public class CursoInscricaoLocalServiceImpl
	extends CursoInscricaoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link br.com.cnf.curso.inscricao.service.CursoInscricaoLocalServiceUtil} to access the curso inscricao local service.
	 */
	@Override
	public CursoInscricao addCursoInscricao(CursoInscricao cursoInscricao) throws SystemException {
		long inscricaoId = cursoInscricao.getInscricaoId();
		
		// Cria a classe implementando um novo ID no banco.
		if(inscricaoId <= 0) {
			inscricaoId = counterLocalService.increment(CursoInscricao.class.getName());
		}
		
		CursoInscricao novoCursoInscricao = cursoInscricaoPersistence.create(inscricaoId);
		
		// Atribui novos valores
		novoCursoInscricao.setCreateDate(cursoInscricao.getCreateDate());
		novoCursoInscricao.setUserCreateId(cursoInscricao.getUserCreateId());
		novoCursoInscricao.setUserCreateName(cursoInscricao.getUserCreateName());
		novoCursoInscricao.setCompanyId(cursoInscricao.getCompanyId());
		novoCursoInscricao.setGroupId(cursoInscricao.getGroupId());
		novoCursoInscricao.setTipoFisicaJuridica(cursoInscricao.getTipoFisicaJuridica());
		novoCursoInscricao.setCpfCnpj(cursoInscricao.getCpfCnpj());
		novoCursoInscricao.setEmailPrincipal(cursoInscricao.getEmailPrincipal());
		novoCursoInscricao.setTelefoneComercial(cursoInscricao.getTelefoneComercial());
		novoCursoInscricao.setCursoNome(cursoInscricao.getCursoNome());
		novoCursoInscricao.setCursoData(cursoInscricao.getCursoData());
		novoCursoInscricao.setCursoLocal(cursoInscricao.getCursoLocal());
		novoCursoInscricao.setCursoHorario(cursoInscricao.getCursoHorario());
		novoCursoInscricao.setCursoId(cursoInscricao.getCursoId());
		novoCursoInscricao.setPreco(cursoInscricao.getPreco());
		novoCursoInscricao.setPrecoAssociado(cursoInscricao.getPrecoAssociado());
		novoCursoInscricao.setPrecoConvenio(cursoInscricao.getPrecoConvenio());
		novoCursoInscricao.setCadastroFinalizado(cursoInscricao.getCadastroFinalizado());
		novoCursoInscricao.setDataInicio(cursoInscricao.getDataInicio());

		return super.addCursoInscricao(novoCursoInscricao);
	}
	
	public List<CursoInscricao> search(String statusMoedaDigital) throws SystemException {
		return cursoInscricaoPersistence.findByLikeStatusMoedaDigital(statusMoedaDigital);
	}
	
}