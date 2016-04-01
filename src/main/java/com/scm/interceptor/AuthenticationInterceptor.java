package com.scm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.scm.constant.SecurityConstant;
import com.scm.po.ShopInfo;
import com.scm.po.UserInfo;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	private static final Logger log = Logger.getLogger(AuthenticationInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String contextPath = request.getContextPath();
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute(SecurityConstant.SCM_ERP_USER_COOKIE_KEY);
		ShopInfo shopInfo = (ShopInfo) request.getSession().getAttribute(SecurityConstant.SCM_ERP_SHOP_COOKIE_KEY);
		if (userInfo == null || shopInfo==null) {
			response.sendRedirect(contextPath + "/login.htm");
			return false;
		}
		return true;
	}

}
