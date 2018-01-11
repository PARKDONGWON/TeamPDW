<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/users/signup_result.jsp</title>
</head>
<body>
<%
	String id=(String)request.getAttribute("id");
%>
<p> <strong><%=id %></strong> 회원님 가입 되었습니다.</p>
<a href="${pageContext.request.contextPath }/">인덱스로 가기</a>
</body>
</html>