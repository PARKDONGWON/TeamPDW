package free.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.cafe.dao.FreeCafeDao;
import test.controller.Action;
import test.controller.ActionForward;

public class FreeCafeDeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 삭제할 글번호를 읽어와서
		int num=Integer.parseInt(request.getParameter("num"));
		//2. DB 에서 글정보 삭제
		FreeCafeDao.getInstance().delete(num);
		//3. 글목록 보기로 redirect 이동
		
		ActionForward af=new ActionForward("/freecafe/freelist.do");
		af.setRedirect(true);
		return af;
	}

}
