<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/home.jsp</title>
</head>
<body>
<h3>인덱스 페이지 입니다.</h3>
<c:if test="${not empty id }">
	<p><a href="users/private/info.do">${id }</a>님 로그인중...</p>
	<a href="users/logout.do">로그아웃</a>
</c:if>
<ul>
	<li><a href="users/signup_form.do">회원가입</a></li>
	<li><a href="users/login_form.do?url=${pageContext.request.contextPath }/">로그인</a></li>
	<li><a href="notice/noticelist.do">공지사항게시판</a></li>
</ul>
<h3>공지사항</h3>
<ul>
	<c:forEach var="tmp" items="${news }">
		<li>${tmp }</li>
	</c:forEach>
</ul>
</body>
</html>














