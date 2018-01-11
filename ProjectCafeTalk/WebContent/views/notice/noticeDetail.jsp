<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/notice/noticeDetail.jsp</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
#container {
	width: 70%;
	margin: 0 auto; /* 가로로 중앙에 배치 */
	padding-top: 10%; /* 테두리와 내용 사이의 패딩 여백 */
}

#list {
	text-align: center;
}

#write {
	text-align: right;
}
/* Bootstrap 수정 */
.table>thead {
	background-color: #b3c6ff;
}

.table>thead>tr>th {
	text-align: center;
}

.table-hover>tbody>tr:hover {
	background-color: #e6ecff;
}

.table>tbody>tr>td {
	text-align: center;
}

.table>tbody>tr>#title {
	text-align: left;
}

div>#paging {
	text-align: center;
}

.hit {
	animation-name: blink;
	animation-duration: 1.5s;
	animation-timing-function: ease;
	animation-iteration-count: infinite;
	/* 위 속성들을 한 줄로 표기하기 */
	/* -webkit-animation: blink 1.5s ease infinite; */
}
/* 애니메이션 지점 설정하기 */
/* 익스플로러 10 이상, 최신 모던 브라우저에서 지원 */
@
keyframes blink {
	from {color: white;
}
30%
{
color: yellow;
}
to {
	color: red;
	font-weight: bold;
}
/* 0% {color:white;}
      30% {color: yellow;}
      100% {color:red; font-weight: bold;} */
}

/* Set height of the grid so .sidenav can be 100% (adjust if needed) */
.row.content {
	height: 1500px
}

/* Set gray background color and 100% height */
.sidenav {
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>
	<!--  사이드 -->
	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<h4>John's Blog</h4>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#section1">메인화면</a></li>
					<li><a href="#section2">게임소개</a></li>
					<li><a href="#section3">공지사항</a></li>
					<li><a href="#section3">FAQ</a></li>
				</ul>
				<br>
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search Blog..">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
			</div>
			<!-- 메인 영역------------------>
			<div class="col-sm-9">
				<h3>공지사항 디테일페이지</h3>
				<table>
					<tr>
						<th>글번호</th>
						<td>${dto.num }</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>${dto.writer }</td>
					</tr>
					<tr>
						<th>제목</th>
						<td>${dto.title }</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>${dto.content }</td>
					</tr>
				</table>
				<!-- 덧글 목록 출력하기 -->
<div class="comments">
	<c:forEach var="tmp" items="${commentList }">
		<div class="comment" <c:if test="${tmp.num ne tmp.comment_group }">style="margin-left:100px"</c:if> >
			<c:if test="${tmp.num ne tmp.comment_group }">
				<div class="reply_icon"></div>
			</c:if>
			<div>
				from <strong>${tmp.writer }</strong>${tmp.regdate }<br/>
				to <strong>${tmp.target_id }</strong>
				<a href="javascript:">답글</a>
			</div>
			<textarea rows="1" cols="100" disabled>${tmp.content }</textarea>
			<form action="comment_insert.do" method="post">
				<!-- 덧글 작성자 -->
				<input type="hidden" name="writer" value="${id }"/>
				<!-- 덧글 그룹 -->
				<input type="hidden" name="ref_group" value="${dto.num }" />
				<!-- 덧글 대상 -->
				<input type="hidden" name="target_id" value="${tmp.writer }" />
				<input type="hidden" name="comment_group" value="${tmp.comment_group }" />
				<textarea rows="1" cols="100" name="content"></textarea>
				<button type="submit">등록</button>
			</form>		
		</div>
	</c:forEach>
</div>

<!-- 원글에 대한 덧글 입력 폼 -->
<div class="comment_form">
	<form action="comment_insert.do" method="post">
		<!-- 덧글 작성자 -->
		<input type="hidden" name="writer" value="${id }"/>
		<!-- 덧글 그룹 -->
		<input type="hidden" name="ref_group" value="${dto.num }" />
		<!-- 덧글 대상 -->
		<input type="hidden" name="target_id" value="${dto.writer }" />
		<textarea rows="1" cols="100" name="content"></textarea>
		<button type="submit">등록</button>
	</form>
</div>
				<!-- 관리자가 로그인하였다면 수정과 삭제 버튼을 보이게 한다. -->
				<c:if test="${id eq 'admin' }">
					<div>
						<a href="private/adminNoticeUpdateForm.do?num=${dto.num}">수정</a>
					</div>
					<div>
						<a href="javascript:deleteCheck()">삭제</a>
					</div>
				</c:if>
					<div>
						<a href="noticelist.do">목록으로</a>
					</div>
			</div>
		</div>
	</div>
	<!-- footer 영역 -->
	<footer class="container-fluid">
		<p>Footer Text</p>
	</footer>
</body>
<script src="/resources/jquery-3.2.1.js"></script>
<script>
	function deleteCheck() {
		var isDelete = confirm("삭제 하시겠습니까?");
		if (isDelete) {
			location.href = "private/adminNoticeDelete.do?num=${dto.num}";
		}
	}
</script>
</html>