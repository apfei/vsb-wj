/**
 * 
 */
package com.example.anpf.testserver.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.anpf.testserver.bean.User;

/**
 * @author anpf
 * @date: 2020/08/10
 */
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		HttpSession session = req.getSession();
		String contextPath = session.getServletContext().getContextPath();
		String[] requireAuthPages = new String[] {
				"index",
		};
		
		String uri = req.getRequestURI();
		uri = StringUtils.remove(uri, contextPath + "/");
		String page = uri;
		
		if(beginWith(page, requireAuthPages)) {
			User user = (User) session.getAttribute("user");
			if(null == user) {
				res.sendRedirect("login");
				return false;
			}
		}
		
		return true;
	}

	/**
	 * @param page
	 * @param requireAuthPage
	 * @return
	 */
	private boolean beginWith(String page, String[] requireAuthPages) {
		boolean result = false;
		for(String rpage : requireAuthPages) {
			if(StringUtils.startsWith(page, rpage)) {
				result = true;
				break;
			}
		}
		
		return result;
	}
	
}
