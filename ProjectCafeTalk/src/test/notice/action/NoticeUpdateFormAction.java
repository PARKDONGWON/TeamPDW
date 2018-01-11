package test.notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.notice.dao.NoticeDao;
import test.notice.dto.NoticeDto;

public class NoticeUpdateFormAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num=Integer.parseInt(request.getParameter("num"));
		NoticeDto dto = new NoticeDto();
		dto.setNum(num);
		NoticeDto resultDto = NoticeDao.getInstance().getData(dto);
		request.setAttribute("dto", resultDto);
		return new ActionForward("/views/notice/private/adminNoticeUpdateForm.jsp");
	}

}
