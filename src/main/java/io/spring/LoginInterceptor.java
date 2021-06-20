package io.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import io.spring.entities.Account;
import io.spring.utils.Const;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(Const.USER_LOGGED);
		Account user = (Account) obj;
		if (user == null ) {
			response.sendRedirect("/login");
			return false;
		}
		else {
			return true;
		}
		
	}


}
