package test.notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.notice.dao.NoticeDao;
import test.notice.dto.NoticeDto;

public class NoticeDeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("삭제페이지들어왔다~");
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("num : "+num);
		NoticeDao.getInstance().delete(num);
		
		ActionForward af=new ActionForward("/notice/private/adminNoticeList.do");
		af.setRedirect(true);
		return af;
	}

}
