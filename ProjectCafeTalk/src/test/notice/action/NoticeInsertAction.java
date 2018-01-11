package test.notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.notice.dao.NoticeDao;
import test.notice.dto.NoticeDto;

public class NoticeInsertAction extends	Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String title=request.getParameter("title");
		String content = request.getParameter("ir1");
		String writer = (String)request.getSession().getAttribute("id");
		
		NoticeDto dto = new NoticeDto();
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setContent(content);
		
		NoticeDao.getInstance().insert(dto);
		System.out.println("서버전송완료");
		
		ActionForward af = new ActionForward("/notice/noticelist.do");
		af.setRedirect(true); 
		return af;
	}

}
