package test.notice.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.notice.dao.NoticeCommentDao;
import test.notice.dao.NoticeDao;
import test.notice.dto.NoticeCommentDto;
import test.notice.dto.NoticeDto;

public class NoticeDetailAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String keyword=request.getParameter("keyword");
		String condition=request.getParameter("condition");
		
		NoticeDto dto = new NoticeDto();
		if(keyword != null) {
			if(condition.equals("titlecontent")){ //제목+내용 검색
				dto.setTitle(keyword);
				dto.setContent(keyword);
			}else if(condition.equals("title")){//제목 검색
				dto.setTitle(keyword);
			}else if(condition.equals("writer")){//작성자 검색
				dto.setWriter(keyword);
			}
			request.setAttribute("condition", condition);
			request.setAttribute("keyword", keyword);
		}
		
		//1. 파라미터로 전달되는 글번호를 읽어온다.
		int num=Integer.parseInt(request.getParameter("num"));
		dto.setNum(num); //글번호도 dto 에 담는다.
		
		//2. 글의 조회수를 1 올린다.
		NoticeDao.getInstance().ViewCount(num);
		
		//3. 글번호에 해당되는 글정보를 얻어온다.
		NoticeDto resultDto=NoticeDao.getInstance().getData(dto);
		//4. 글정보를 request 에 담는다.
		request.setAttribute("dto", resultDto);
		//5. 글번호에 해당하는 덧글 목록을 얻어온다.
		List<NoticeCommentDto> commentList=
				NoticeCommentDao.getInstance().getList(num);
		//6. 덧글 목록을 request 에 담는다.
		request.setAttribute("commentList", commentList);
		
		String id = (String)request.getSession().getAttribute("id");
		boolean isLogin=false;
		if(id != null){
			isLogin=true;
		}
		//로그인 했는지 여부도 request 에 담는다.
		request.setAttribute("isLogin", isLogin);
		

		System.out.println("num : "+num);
	
		System.out.println("디테일페이지");
	
		return new ActionForward("/views/notice/noticeDetail.jsp");
	} 

}
