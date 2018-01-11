package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.controller.Action;
import test.controller.ActionForward;
/*
 *  로그 아웃 처리를 하는 액션
 */
public class LogoutAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 세션 초기화
		HttpSession session=request.getSession();
		session.invalidate();
		//2. 응답
		return new ActionForward("/views/users/logout_result.jsp");
	}
	
}









