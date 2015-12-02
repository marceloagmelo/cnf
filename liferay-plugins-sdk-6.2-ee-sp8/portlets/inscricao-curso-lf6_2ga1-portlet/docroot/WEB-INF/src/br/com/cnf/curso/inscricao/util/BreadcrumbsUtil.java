package br.com.cnf.curso.inscricao.util;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

public class BreadcrumbsUtil {
	public static String removeLastClass(String breadcrumbs) {
		return StringUtil.replace(breadcrumbs, new String[] { "class=\"last\"",
				"class=\"first last\"" }, new String[] { StringPool.BLANK,
				"class=\"first\"" });
	}
}
