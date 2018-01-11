package test.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

public class HomeAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//DB 에서 공지사항을 읽어온다.
		List<String> news=new ArrayList<>();
		news.add("오늘 날씨가 춥네요!");
		news.add("감기 조심 하세요");
		news.add("MVC pattern 공부중");
		news.add("어쩌구.. 저쩌구....");
		//request 에 담는다.
		request.setAttribute("news", news);
		// home.jsp 페이지로 forward 이동해서 응답할수 있도록
		ActionForward af=new ActionForward("/views/home.jsp");
		
		return af;
	}

}











