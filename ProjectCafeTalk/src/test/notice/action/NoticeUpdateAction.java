package test.notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.notice.dao.NoticeDao;
import test.notice.dto.NoticeDto;

public class NoticeUpdateAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("들어왔따 업데이트로직수행하러");
		int num=Integer.parseInt(request.getParameter("num"));
		String title = request.getParameter("title");
		String content = request.getParameter("ir1");
		
		NoticeDto dto = new NoticeDto();
		dto.setNum(num);
		dto.setTitle(title);
		dto.setContent(content);
		NoticeDao.getInstance().update(dto);
		
		ActionForward af=new ActionForward("/notice/noticeDetail.do?num="+num);
		af.setRedirect(true);
		return af;
	}

}
