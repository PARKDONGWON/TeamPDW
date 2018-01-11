package free.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.cafe.dao.FreeCafeDao;
import free.cafe.dto.FreeCafeDto;
import test.controller.Action;
import test.controller.ActionForward;

public class FreeCafeUpdateAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num=Integer.parseInt(request.getParameter("num"));
		String title=request.getParameter("title");
		String content=request.getParameter("ir1");
		//2. DB 에 수정 반영
		FreeCafeDto dto=new FreeCafeDto();
		dto.setNum(num);
		dto.setTitle(title);
		dto.setContent(content);
		//수정 반영 
		FreeCafeDao.getInstance().update(dto);
		
		//3. 글목록 보기로 redirect 이동 
		ActionForward af=new ActionForward("/freecafe/freelist.do");
		af.setRedirect(true);
		return af;
	}

}
