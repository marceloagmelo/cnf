package br.com.cnf.curso.inscricao.util;

import br.com.cnf.curso.inscricao.Constantes;
import br.com.cnf.curso.inscricao.model.CursoInscricao;
import br.com.cnf.curso.inscricao.model.CursoInscricaoCnpj;
import br.com.cnf.curso.inscricao.model.CursoInscricaoCpf;
import br.com.cnf.curso.inscricao.model.CursoParticipante;
import br.com.cnf.curso.inscricao.service.CursoInscricaoCnpjLocalServiceUtil;
import br.com.cnf.curso.inscricao.service.CursoInscricaoCpfLocalServiceUtil;
import br.com.cnf.curso.inscricao.service.CursoInscricaoLocalServiceUtil;
import br.com.cnf.curso.inscricao.service.CursoParticipanteLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.theme.ThemeDisplay;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletPreferences;

public class InscricaoUtil {

	public static CursoInscricao recuperarInscricaoPorCpfCnpj(
			ThemeDisplay themeDisplay, String cursoId, String cpfCnpj)
			throws Exception {
		CursoInscricao cursoInscricao = null;
		try {
			long idGroup = themeDisplay.getScopeGroupId();
			long idCompany = themeDisplay.getCompanyId();

			DynamicQuery cursoInscricaoQuery = DynamicQueryFactoryUtil
					.forClass(CursoInscricao.class);
			Criterion criteriaCompany = RestrictionsFactoryUtil.eq(
					Constantes.COMPANY_ID, idCompany);
			cursoInscricaoQuery.add(criteriaCompany);
			Criterion criteriaGroup = RestrictionsFactoryUtil.eq(
					Constantes.GROUP_ID, idGroup);
			cursoInscricaoQuery.add(criteriaGroup);
			Criterion criteriaCurso = RestrictionsFactoryUtil.eq(
					Constantes.PARAM_CURSO_ID, GetterUtil.getLong(cursoId));
			cursoInscricaoQuery.add(criteriaCurso);
			Criterion criteriaCpfCnpj = RestrictionsFactoryUtil.eq(
					Constantes.PROP_CPF_CNPJ, cpfCnpj);
			cursoInscricaoQuery.add(criteriaCpfCnpj);

			List<CursoInscricao> listaCursoInscricao = (List<CursoInscricao>) CursoInscricaoLocalServiceUtil
					.dynamicQuery(cursoInscricaoQuery);

			for (CursoInscricao ci : listaCursoInscricao) {
				cursoInscricao = ci;
				break;
			}

		} catch (Exception e) {
		}
		return cursoInscricao;
	}

	public static List<CursoInscricao> recuperarListaInscricaoPorCpfCnpj(
			ThemeDisplay themeDisplay, String cpfCnpj)
			throws Exception {
		List<CursoInscricao> listaCursoInscricao = null;
		try {
			long idGroup = themeDisplay.getScopeGroupId();
			long idCompany = themeDisplay.getCompanyId();

			DynamicQuery cursoInscricaoQuery = DynamicQueryFactoryUtil
					.forClass(CursoInscricao.class);
			Criterion criteriaCompany = RestrictionsFactoryUtil.eq(
					Constantes.COMPANY_ID, idCompany);
			cursoInscricaoQuery.add(criteriaCompany);
			Criterion criteriaGroup = RestrictionsFactoryUtil.eq(
					Constantes.GROUP_ID, idGroup);
			cursoInscricaoQuery.add(criteriaGroup);
			Criterion criteriaCpfCnpj = RestrictionsFactoryUtil.eq(
					Constantes.PROP_CPF_CNPJ, cpfCnpj);
			cursoInscricaoQuery.add(criteriaCpfCnpj);

			listaCursoInscricao = (List<CursoInscricao>) CursoInscricaoLocalServiceUtil
					.dynamicQuery(cursoInscricaoQuery);

		} catch (Exception e) {
		}
		return listaCursoInscricao;
	}
	
	public static List<CursoInscricao> recuperarListaInscricaoPorCursoId(
			ThemeDisplay themeDisplay, String cursoId)
			throws Exception {
		List<CursoInscricao> listaCursoInscricao = null;
		try {
			long idGroup = themeDisplay.getScopeGroupId();
			long idCompany = themeDisplay.getCompanyId();

			DynamicQuery cursoInscricaoQuery = DynamicQueryFactoryUtil
					.forClass(CursoInscricao.class);
			Criterion criteriaCompany = RestrictionsFactoryUtil.eq(
					Constantes.COMPANY_ID, idCompany);
			cursoInscricaoQuery.add(criteriaCompany);
			Criterion criteriaGroup = RestrictionsFactoryUtil.eq(
					Constantes.GROUP_ID, idGroup);
			cursoInscricaoQuery.add(criteriaGroup);
			Criterion criteriaCursoId = RestrictionsFactoryUtil.eq(
					Constantes.PARAM_CURSO_ID, Long.valueOf(cursoId));
			cursoInscricaoQuery.add(criteriaCursoId);

			listaCursoInscricao = (List<CursoInscricao>) CursoInscricaoLocalServiceUtil
					.dynamicQuery(cursoInscricaoQuery);

		} catch (Exception e) {
		}
		return listaCursoInscricao;
	}

	public static List<CursoInscricao> recuperarListaInscricaoPorNomeCurso(
			ThemeDisplay themeDisplay, String cursoNome)
			throws Exception {
		List<CursoInscricao> listaCursoInscricao = null;
		try {
			long idGroup = themeDisplay.getScopeGroupId();
			long idCompany = themeDisplay.getCompanyId();

			DynamicQuery cursoInscricaoQuery = DynamicQueryFactoryUtil
					.forClass(CursoInscricao.class);
			Criterion criteriaCompany = RestrictionsFactoryUtil.eq(
					Constantes.COMPANY_ID, idCompany);
			cursoInscricaoQuery.add(criteriaCompany);
			Criterion criteriaGroup = RestrictionsFactoryUtil.eq(
					Constantes.GROUP_ID, idGroup);
			cursoInscricaoQuery.add(criteriaGroup);
			Criterion criteriaNomeCurso = RestrictionsFactoryUtil.like(
					"cursoNome", Constantes.PERCENTE + cursoNome
							+ Constantes.PERCENTE);
			cursoInscricaoQuery.add(criteriaNomeCurso);

			listaCursoInscricao = (List<CursoInscricao>) CursoInscricaoLocalServiceUtil
					.dynamicQuery(cursoInscricaoQuery);
		} catch (Exception e) {
		}
		return listaCursoInscricao;
	}

	public static List<CursoInscricao> recuperarListaInscricaoPorNomeResponsavel(
			ThemeDisplay themeDisplay, String nomeResponsavel)
			throws Exception {
		List<CursoInscricao> listaCursoInscricao = null;
		try {
			long idGroup = themeDisplay.getScopeGroupId();
			long idCompany = themeDisplay.getCompanyId();

			DynamicQuery cursoInscricaoQuery = DynamicQueryFactoryUtil
					.forClass(CursoInscricao.class);
			Criterion criteriaCompany = RestrictionsFactoryUtil.eq(
					Constantes.COMPANY_ID, idCompany);
			cursoInscricaoQuery.add(criteriaCompany);
			Criterion criteriaGroup = RestrictionsFactoryUtil.eq(
					Constantes.GROUP_ID, idGroup);
			cursoInscricaoQuery.add(criteriaGroup);
			Criterion criteriaNomeCurso = RestrictionsFactoryUtil.like(
					"nomeResponsavel", Constantes.PERCENTE + nomeResponsavel
							+ Constantes.PERCENTE);
			cursoInscricaoQuery.add(criteriaNomeCurso);

			listaCursoInscricao = (List<CursoInscricao>) CursoInscricaoLocalServiceUtil
					.dynamicQuery(cursoInscricaoQuery);
		} catch (Exception e) {
		}
		return listaCursoInscricao;
	}

	public static List<String> montarListaEstados() {
		List<String> lista = new ArrayList<String>();

		// Adicionar na lista
		lista.add("AC");
		lista.add("AL");
		lista.add("AM");
		lista.add("AP");
		lista.add("BA");
		lista.add("CE");
		lista.add("DF");
		lista.add("ES");
		lista.add("GO");
		lista.add("MA");
		lista.add("MG");
		lista.add("MS");
		lista.add("MT");
		lista.add("PA");
		lista.add("PB");
		lista.add("PE");
		lista.add("PI");
		lista.add("PR");
		lista.add("RJ");
		lista.add("RN");
		lista.add("RO");
		lista.add("RR");
		lista.add("RS");
		lista.add("SC");
		lista.add("SE");
		lista.add("SP");
		lista.add("TO");

		return lista;
	}

	public static CursoParticipante recuperarParticipantePorInscricao(
			String inscricaoId) throws Exception {
		CursoParticipante cursoParticipante = null;
		try {
			DynamicQuery cursoInscricaoQuery = DynamicQueryFactoryUtil
					.forClass(CursoParticipante.class);
			Criterion criteriaInscricao = RestrictionsFactoryUtil.eq(
					Constantes.PARAM_INSCRICAO_ID,
					GetterUtil.getLong(inscricaoId));
			cursoInscricaoQuery.add(criteriaInscricao);

			List<CursoParticipante> listaCursoParticipante = (List<CursoParticipante>) CursoParticipanteLocalServiceUtil
					.dynamicQuery(cursoInscricaoQuery);

			for (CursoParticipante cp : listaCursoParticipante) {
				cursoParticipante = cp;
				break;
			}

		} catch (Exception e) {
		}
		return cursoParticipante;
	}

	public static CursoParticipante recuperarParticipantePorInscricaoCpf(
			long inscricaoId, String cpf) throws Exception {
		CursoParticipante cursoParticipante = null;
		try {
			DynamicQuery cursoInscricaoQuery = DynamicQueryFactoryUtil
					.forClass(CursoParticipante.class);
			Criterion criteriaInscricao = RestrictionsFactoryUtil.eq(
					Constantes.PARAM_INSCRICAO_ID, inscricaoId);
			cursoInscricaoQuery.add(criteriaInscricao);
			Criterion criteriaCpf = RestrictionsFactoryUtil.eq(
					Constantes.PROP_CPF, cpf);
			cursoInscricaoQuery.add(criteriaCpf);

			List<CursoParticipante> listaCursoParticipante = (List<CursoParticipante>) CursoParticipanteLocalServiceUtil
					.dynamicQuery(cursoInscricaoQuery);

			for (CursoParticipante cp : listaCursoParticipante) {
				cursoParticipante = cp;
				break;
			}

		} catch (Exception e) {
		}
		return cursoParticipante;
	}

	public static CursoInscricaoCpf recuperarInscricaoCpfPorInscricao(
			String inscricaoId) throws Exception {
		CursoInscricaoCpf cursoInscricaoCpf = null;
		try {
			DynamicQuery cursoInscricaoQuery = DynamicQueryFactoryUtil
					.forClass(CursoInscricaoCpf.class);
			Criterion criteriaInscricao = RestrictionsFactoryUtil.eq(
					Constantes.PARAM_INSCRICAO_ID,
					GetterUtil.getLong(inscricaoId));
			cursoInscricaoQuery.add(criteriaInscricao);

			List<CursoInscricaoCpf> listaCursoInscricaoCpf = (List<CursoInscricaoCpf>) CursoInscricaoCpfLocalServiceUtil
					.dynamicQuery(cursoInscricaoQuery);

			for (CursoInscricaoCpf cif : listaCursoInscricaoCpf) {
				cursoInscricaoCpf = cif;
				break;
			}

		} catch (Exception e) {
		}
		return cursoInscricaoCpf;
	}

	public static CursoInscricaoCnpj recuperarInscricaoCnpjPorInscricao(
			String inscricaoId) throws Exception {
		CursoInscricaoCnpj cursoInscricaoCnpj = null;
		try {
			DynamicQuery cursoInscricaoQuery = DynamicQueryFactoryUtil
					.forClass(CursoInscricaoCnpj.class);
			Criterion criteriaInscricao = RestrictionsFactoryUtil.eq(
					Constantes.PARAM_INSCRICAO_ID,
					GetterUtil.getLong(inscricaoId));
			cursoInscricaoQuery.add(criteriaInscricao);

			List<CursoInscricaoCnpj> listaCursoInscricaoCnpj = (List<CursoInscricaoCnpj>) CursoInscricaoCnpjLocalServiceUtil
					.dynamicQuery(cursoInscricaoQuery);

			for (CursoInscricaoCnpj cij : listaCursoInscricaoCnpj) {
				cursoInscricaoCnpj = cij;
				break;
			}

		} catch (Exception e) {
		}
		return cursoInscricaoCnpj;
	}

	public static List<CursoParticipante> recuperarListaParticipantesPorInscricao(long inscricaoId) throws Exception {
		List<CursoParticipante> listaCursoParticipante = null;
		try {
			DynamicQuery cursoInscricaoQuery = DynamicQueryFactoryUtil.forClass(CursoParticipante.class);
			Criterion criteriaInscricao = RestrictionsFactoryUtil.eq(Constantes.PARAM_INSCRICAO_ID, inscricaoId);
			cursoInscricaoQuery.add(criteriaInscricao);
			
			listaCursoParticipante = (List<CursoParticipante>) CursoParticipanteLocalServiceUtil.dynamicQuery(cursoInscricaoQuery);
		} catch (Exception e) {
		}
		return listaCursoParticipante;
	}

	public static List<CursoInscricaoCpf> recuperarListaCursoInscricaoCpfPorInscricao(
			long inscricaoId) throws Exception {
		List<CursoInscricaoCpf> listaCursoInscricaoCpf = null;
		try {
			DynamicQuery cursoInscricaoQuery = DynamicQueryFactoryUtil
					.forClass(CursoInscricaoCpf.class);
			Criterion criteriaInscricao = RestrictionsFactoryUtil.eq(
					Constantes.PARAM_INSCRICAO_ID, inscricaoId);
			cursoInscricaoQuery.add(criteriaInscricao);

			listaCursoInscricaoCpf = (List<CursoInscricaoCpf>) CursoInscricaoCpfLocalServiceUtil
					.dynamicQuery(cursoInscricaoQuery);
		} catch (Exception e) {
		}
		return listaCursoInscricaoCpf;
	}

	public static List<CursoInscricaoCnpj> recuperarListaCursoInscricaoCnpjPorInscricao(
			long inscricaoId) throws Exception {
		List<CursoInscricaoCnpj> listaCursoInscricaoCnpj = null;
		try {
			DynamicQuery cursoInscricaoQuery = DynamicQueryFactoryUtil
					.forClass(CursoInscricaoCnpj.class);
			Criterion criteriaInscricao = RestrictionsFactoryUtil.eq(
					Constantes.PARAM_INSCRICAO_ID, inscricaoId);
			cursoInscricaoQuery.add(criteriaInscricao);

			listaCursoInscricaoCnpj = (List<CursoInscricaoCnpj>) CursoInscricaoCnpjLocalServiceUtil
					.dynamicQuery(cursoInscricaoQuery);
		} catch (Exception e) {
		}
		return listaCursoInscricaoCnpj;
	}


	public static String getMoedaDigitalUrlBoletoPreferencia(
			PortletPreferences preferences, long companyId)
		throws SystemException {

		return preferences.getValue(Constantes.PROP_MOEDA_DIGITAL_URL_BOLETO, Constantes.MOEDA_DIGITAL_URL_BOLETO);
	}

	public static String getParamDiasBoletoPreferencia(
			PortletPreferences preferences, long companyId)
		throws SystemException {

		return preferences.getValue(Constantes.PROP_PARAM_DIAS_BOLETO, Constantes.PARAM_DIAS_BOLETO);
	}

	public static String getEmailResponsavelPreferencia(
			PortletPreferences preferences, long companyId)
		throws SystemException {

		return preferences.getValue(Constantes.PROP_EMAIL_RESPONSAVEL, Constantes.EMAIL_RESPONSAVEL);
	}
}
