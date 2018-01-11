package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;
/*
 *  회원가입 처리를 하는 액션 
 */
public class SignupAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 폼전송되는 내용을 읽어와서
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		//회원정보를 Dto 에 담고 
		UsersDto dto=new UsersDto(id, pwd, email, null);
		//2. DB 에 저장하고
		UsersDao.getInstance().insert(dto);
		//3. 응답하기 
		request.setAttribute("id", id);
		
		return new ActionForward("/views/users/signup_result.jsp");
	}

}

















