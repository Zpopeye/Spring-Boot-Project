package sz.zxl.com.demo.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 登入检查;拦截器
 * @author carmelo
 * @version 创建时间：2018年11月8日下午11:42:35
 */
public class LoginHandlerInterceptor implements HandlerInterceptor{

	//目标方法执行之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Object user = request.getSession().getAttribute("user");
		if (user==null) {
			//没有登入需要拦截,返回登入页
			request.setAttribute("msg", "没有权限请先登入");
			//response.sendRedirect("/sbp/index.html");
			request.getRequestDispatcher("/index.html").forward(request, response);
			return false;
		} else {
			//已经登入/不拦截
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

	
}
