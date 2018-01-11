package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;

public class UsersUpdateFormAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//사용자의 아이디
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		//1. 사용자 정보를 DB 에서 얻어온다.
		UsersDto dto=UsersDao.getInstance().getData(id);
		//2. 사용자 정보를 응답
		request.setAttribute("dto", dto);
		
		return new ActionForward
				("/views/users/private/updateform.jsp");
	}
	
}

















