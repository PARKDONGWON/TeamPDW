package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
/*
 *  로그인 폼을 출력해주는 Action
 */
public class LoginFormAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//로그인 후 리다일렉트 이동할 url 이 넘어오는지 확인해서
		String url=request.getParameter("url");
		if(url==null) {//만일 넘어오지 않는다면
			//인덱스 페이지로 이동할수 있도록 
			url=request.getContextPath()+"/home.do";
		}
		// url 을 request 에 담는다.
		request.setAttribute("url", url);
		
		// view 페이지로 forward 이동 
		return new ActionForward("/views/users/login_form.jsp");
	}
	
}










