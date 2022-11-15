<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/adminNoticeWriteForm.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<div id="blank"></div>
	<div id="blank_5vh"></div>

	<form action="adminQListUpdate" method="post">
		<input type="hidden" name='boardno' value="${adminqlist.boardno }">
		<div class="wrap">
			<h4>
				<i class="fa-solid fa-clipboard"></i>&nbsp자주묻는질문수정
			</h4>
			<hr />
			<h6>제목</h6>
			<input type="text" id="title_input" name="boardtitle"
				value="${adminqlist.boardtitle }" />
			<hr />
			<h6>내용</h6>
			<textarea class="mb-4" rows="25" cols="100" id="content_input"
				name="boardcontent">${adminqlist.boardcontent }</textarea>
			<div id="reg_btn" class="d-flex justify-content-center">
				<button type="button" class="btn btn-gray mx-1"
					onclick="history.go(-1)">뒤로가기</button>
				<button type="submit" class="btn btn-blue mx-1">수정하기</button>
			</div>
		</div>
	</form>
	<div id="blank"></div>
	<%@ include file="adminfooter.jsp"%>
</body>
</html>