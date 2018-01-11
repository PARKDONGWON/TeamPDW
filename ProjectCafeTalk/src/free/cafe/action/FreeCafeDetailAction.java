package free.cafe.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.cafe.dao.FreeCafeCommentDao;
import free.cafe.dao.FreeCafeDao;
import free.cafe.dto.FreeCafeCommentDto;
import free.cafe.dto.FreeCafeDto;
import test.controller.Action;
import test.controller.ActionForward;

public class FreeCafeDetailAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//검색과 관련된 파라미터를 읽어와 본다.
				String keyword=request.getParameter("keyword");
				String condition=request.getParameter("condition");
				//CafeDto 객체를 생성해서
				FreeCafeDto dto=new FreeCafeDto();
				if(keyword != null){ //검색어가 전달된 경우
					if(condition.equals("titlecontent")){ //제목+내용 검색
						dto.setTitle(keyword);
						dto.setContent(keyword);
					}else if(condition.equals("title")){//제목 검색
						dto.setTitle(keyword);
					}else if(condition.equals("writer")){//작성자 검색
						dto.setWriter(keyword);
					}
					// list.jsp 뷰페이지에서 필요한 내용을 request 에 담는다.
					request.setAttribute("condition", condition);
					request.setAttribute("keyword", keyword);
				}
				
				//1. 파라미터로 전달되는 글번호를 읽어온다.
				int num=Integer.parseInt(request.getParameter("num"));
				dto.setNum(num); //글번호도 dto 에 담는다.
				
				//2. 글의 조회수를 1 올린다.
				FreeCafeDao.getInstance().increaselikeCount(num);
				
				//3. 글번호에 해당되는 글정보를 얻어온다.
				FreeCafeDto resultDto=FreeCafeDao.getInstance().getData(dto);
				//4. 글정보를 request 에 담는다.
				request.setAttribute("dto", resultDto);
				//5. 글번호에 해당하는 덧글 목록을 얻어온다.
				List<FreeCafeCommentDto> commentList=
						FreeCafeCommentDao.getInstance().getList(num);
				//6. 덧글 목록을 request 에 담는다.
				request.setAttribute("commentList", commentList);
				
				String id = (String)request.getSession().getAttribute("id");
				boolean isLogin=false;
				if(id != null){
					isLogin=true;
				}
				//로그인 했는지 여부도 request 에 담는다.
				request.setAttribute("isLogin", isLogin);
				
				//5. view 페이지로 forward 이동해서 글 내용을 출력한다.  
				return new ActionForward("/views/freecafe/detail.jsp");
			}
}
