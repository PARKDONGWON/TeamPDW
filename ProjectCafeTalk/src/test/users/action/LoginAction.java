package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;

/*
 *  로그인 처리를 하는 Action
 */
public class LoginAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) {
		//1. 파라미터로 전달되는 아이디, 비밀번호를 읽어온다.
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		UsersDto dto=new UsersDto();
		dto.setId(id);
		dto.setPwd(pwd);
		//2. Dao 를 이용해서 유효한 정보인지 확인한다.
		boolean isValid=UsersDao.getInstance().isValid(dto);
		if(isValid) {//유효한 정보인 경우 
			//세션에 아이디를 담는다.
			HttpSession session=request.getSession();
			session.setAttribute("id", id);
		}
		//로그인 성공후 이동할 url
		String url=request.getParameter("url");
		//view 페이지에서 필요한 정보를 request 영역에 담는다.
		request.setAttribute("url", url);
		request.setAttribute("isValid", isValid);
		
		//3. 응답한다.
		return new ActionForward("/views/users/login_result.jsp");
	}

}






















