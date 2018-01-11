<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/users/login_result.jsp</title>
</head>
<body>
<%
	//로그인 성공 여부
	boolean isValid=(boolean)request.getAttribute("isValid");
	//로그인 성공후 이동할 url
	String url=(String)request.getAttribute("url");
%>
<%if(isValid){ 
	String id=(String)session.getAttribute("id");
	%>
	<p><strong><%=id %></strong> 회원님 로그인 되었습니다.</p>
	<a href="<%=url%>">확인</a>
<%}else{ %>
	<p>아이디 혹은 비밀 번호가 틀려요</p>
	<a href="login_form.do?url=<%=url%>">로그인 폼으로 돌아가기</a>
<%} %>
</body>
</html>












