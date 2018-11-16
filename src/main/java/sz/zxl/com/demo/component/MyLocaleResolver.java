package sz.zxl.com.demo.component;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

/**
 * 可以在连接数携带区域信息 国际化
 * @author carmelo
 * @version 创建时间：2018年11月8日下午7:43:28
 */
public class MyLocaleResolver implements LocaleResolver {

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String l = request.getParameter("l");
		Locale locale = Locale.getDefault();	//系统默认的
		if(!StringUtils.isEmpty(l)) {
			String[] split = l.split("_");
			locale = new Locale(split[0], split[1]);
		}
		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse respons, Locale locale) {

	}

}
