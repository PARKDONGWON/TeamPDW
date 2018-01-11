package test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.controller.ActionForward;
/*
 *  중간에 클라이언트의 요청을 가로 채서 작업을 할 객체 설계
 *  
 *  - javax.servlet.Filter 인터페이스를 구현해서 만든다.
 */

@WebFilter({ "/users/private/*", "/cafe/private/*", "/file/private/*", "/notice/*" })
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	// 필터가 수행이 될때 호출되는 메소드
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// 원래 type 으로 casting
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		// HttpSession 객체의 참조값 얻어오기
		HttpSession session = request.getSession();
		// Context 경로 얻어오기
		String cPath = request.getContextPath();
		// 원래 요청 uri(url) 정보 얻어오기
		String url = request.getRequestURI();
		// session 에 로그인 정보가 있는지 여부를 확인해서
		if (session.getAttribute("id") == null) {
			// 로그인 페이지의 경로 구성
			String path = cPath + "/users/login_form.do?url=" + url;
			// 로그인 페이지로 이동 시킨다.
			response.sendRedirect(path);
		} else {
			// 원래 하려던 작업 진행 시키기
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
