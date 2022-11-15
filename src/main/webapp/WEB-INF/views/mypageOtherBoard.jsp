<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- header -->
<c:choose>
<c:when test="${id == null}">
	<%@ include file="header.jsp"%>
</c:when>
<c:otherwise>
	<%@ include file="header_mem.jsp"%>
</c:otherwise>
</c:choose>
<link href="css/mypageBoard.css" rel="stylesheet" />
<title>Cheese Market</title>
</head>
<body>

	<div class="col-lg-8 col-md-10 mx-auto"></div>
	<div id="blank"></div>
	<!-- ======= Frequenty Asked Questions Section ======= -->
	<div class="wrap">
		<div class="container">
			<section class="faq">
				<div class="container">
					<span class="mypageBoard_title"><i class="fa-solid fa-note-sticky icon_prf icon_myboard"></i><h4>작성한 글</h4></span>
					<hr /><br><br>
					<ul class="faq-list">
						<c:forEach var="bList" items="${mypageBoardList }">
							<li><a class="text-start" id="board_title" href="boardDetail?boardno=${bList.boardno }">${bList.boardtitle }</a>
							<p class="text-start" id="board_txt">${bList.boardcontent }</p>
							<div class="board_icon_view d-flex justify-content-start">
								<i class="fa-solid fa-heart"></i>&nbsp <span id="heart_cnt">${bList.boardlike } &nbsp&nbsp</span>
							</div></li>
						</c:forEach> 
					</ul>
					
				</div>
			</section>
		</div>
	</div>
	<!-- End Frequenty Asked Questions Section -->
<%@ include file="footer.jsp" %>
</body>
</html>