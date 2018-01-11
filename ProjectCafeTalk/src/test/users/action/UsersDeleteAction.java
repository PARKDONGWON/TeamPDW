package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;

public class UsersDeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		//1. 삭제할 아이디를 읽어와서
		String id=(String)session.getAttribute("id");
		//2. DB 에서 삭제하고 
		UsersDao.getInstance().delete(id);
		session.invalidate();//세션 초기화
		
		request.setAttribute("id", id);
		
		//3. 응답한다.	
		return new ActionForward
				("/views/users/private/delete_result.jsp");
	}	
}
















