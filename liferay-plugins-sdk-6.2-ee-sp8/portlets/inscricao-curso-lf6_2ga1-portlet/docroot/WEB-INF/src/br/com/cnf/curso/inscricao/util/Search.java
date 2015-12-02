package br.com.cnf.curso.inscricao.util;

import br.com.cnf.curso.inscricao.model.CursoInscricao;
import br.com.cnf.curso.inscricao.model.impl.CursoInscricaoImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Search {

	private static final Log _log = LogFactory.getLog(Search.class);
	
	public static CursoInscricao recuperarConteudo(HttpServletRequest httpReq,
			String articleId) throws PortalException, SystemException {

		CursoInscricao cursoInscricao = null;

//		Indexer indexer = IndexerRegistryUtil
//				.getIndexer(com.liferay.portlet.journal.model.JournalArticle.class);
		
		
//		SearchContext searchContext = SearchContextFactory.getInstance(httpReq);
//		searchContext.setAttribute("articleId", articleId);
//		long[] lng = {PortalUtil.getScopeGroupId(httpReq)};
//		searchContext.setGroupIds(null);
		 
//		BooleanQuery query = BooleanQueryFactoryUtil.create(searchContext);
//		query.addRequiredTerm(Field., articleId);
//		SearchEngineUtil.search(searchContext, query);
//		Hits hits = indexer.search(searchContext);
		
//		Hits hits = SearchEngineUtil.search(searchContext.getSearchEngineId(),
//				PortalUtil.getCompanyId(httpReq), query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		JournalArticle article = JournalArticleLocalServiceUtil.getArticle(PortalUtil.getScopeGroupId(httpReq), articleId + "");
		com.liferay.portal.kernel.xml.Document xmlSax;
		try {
			xmlSax = SAXReaderUtil.read(article.getContent());
			Element root = xmlSax.getRootElement();
			
			cursoInscricao = new CursoInscricaoImpl();

			cursoInscricao.setCompanyId(CompanyThreadLocal.getCompanyId());
			cursoInscricao.setGroupId(article.getGroupId());
			cursoInscricao.setCursoId(GetterUtil.getLong(article.getArticleId()));
			cursoInscricao.setCursoNome(root.selectSingleNode("dynamic-element[@name='nome-curso']/dynamic-content").getText());
			cursoInscricao.setCursoData(root.selectSingleNode("dynamic-element[@name='data-realizacao']/dynamic-content").getText());
			cursoInscricao.setCursoHorario(root.selectSingleNode("dynamic-element[@name='horario']/dynamic-content").getText());
			cursoInscricao.setCursoLocal(root.selectSingleNode("dynamic-element[@name='local']/dynamic-content").getText());
			cursoInscricao.setPreco(root.selectSingleNode("dynamic-element[@name='preco']/dynamic-content").getText());
			cursoInscricao.setPrecoConvenio(root.selectSingleNode("dynamic-element[@name='preco-convenio']/dynamic-content").getText());
			cursoInscricao.setPrecoAssociado(root.selectSingleNode("dynamic-element[@name='preco-associado']/dynamic-content").getText());
			try {
				String sDataInicio = root.selectSingleNode("dynamic-element[@name='data-inicio']/dynamic-content").getText();
				if (Validator.isNotNull(sDataInicio)) {
					Date dtInicio = DateUtil.novaData(Long.valueOf(sDataInicio));
					cursoInscricao.setDataInicio(dtInicio);
				}
			} catch (Exception e) {
				_log.error("Curso "+ cursoInscricao.getCursoNome() + " data de inicio nao cadastrado.");
			}
			
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}

//		Document[] docs = hits.getDocs();
//
//		for (Document doc : docs) {
//			if(articleId.equals(doc.get("articleId"))) {
//				cursoInscricao = new CursoInscricaoImpl();
//				
//				cursoInscricao.setCursoId(GetterUtil.getLong(doc.get("articleId")));
//				cursoInscricao.setCompanyId(CompanyThreadLocal.getCompanyId());
//				cursoInscricao.setGroupId(GetterUtil.getLong(doc.get(Field.GROUP_ID)));
//				cursoInscricao.setCursoNome(doc.get(Constantes.NOME_CURSO).replace("[", "").replace("]", ""));
//				cursoInscricao.setCursoData(doc.get(Constantes.DATA_REALIZACAO).replace("[", "").replace("]", ""));
//				cursoInscricao.setCursoHorario(doc.get(Constantes.HORARIO).replace("[", "").replace("]", ""));
//				cursoInscricao.setCursoLocal(doc.get(Constantes.LOCAL).replace("[", "").replace("]", ""));
//				cursoInscricao.setPreco(doc.get(Constantes.PRECO).replace("[", "").replace("]", ""));
//				cursoInscricao.setPrecoConvenio(doc.get(Constantes.PRECO_CONVENIO).replace("[", "").replace("]", ""));
//				cursoInscricao.setPrecoAssociado(doc.get(Constantes.PRECO_ASSOCIADO).replace("[", "").replace("]", ""));
//				break;
//			}
//		}
		
		return cursoInscricao;
	}

	public static String recuperarAtributo(HttpServletRequest httpReq,
			long cursoId, String atributo) throws PortalException, SystemException {

//		Indexer indexer = IndexerRegistryUtil
//				.getIndexer(com.liferay.portlet.journal.model.JournalArticle.class);
		
		String valor = "";
		JournalArticle article = JournalArticleLocalServiceUtil.getArticle(PortalUtil.getScopeGroupId(httpReq), cursoId + "");
		com.liferay.portal.kernel.xml.Document xmlSax;
		try {
			xmlSax = SAXReaderUtil.read(article.getContent());
			Element root = xmlSax.getRootElement();
			atributo = atributo.replace("web_content/", "");
			Node node = root
					.selectSingleNode("dynamic-element[@name='"+atributo+"']/dynamic-content");
			
			if (node != null) {
				valor = node.getText();
			} else {
				valor = "Não informado";
			}
		} catch (DocumentException e) {
			e.printStackTrace();
			valor = "Não informado";
		}
		
//		SearchContext searchContext = SearchContextFactory.getInstance(httpReq);
//		searchContext.setAttribute("articleId", String.valueOf(cursoId));
//		searchContext.setGroupIds(null);
//		
//		Hits hits = indexer.search(searchContext);
//				
//		Document[] docs = hits.getDocs();
//
//		for (Document doc : docs) {
//			if(String.valueOf(cursoId).equals(doc.get("articleId"))) {
//				return doc.get("ddm/" + cursoId + "/" + atributo + "_pt_BR").replace("[", "").replace("]", "");
//			}
//		}
		
		return valor;
	}
}
