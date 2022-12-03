<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/css/Amain.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/boardDetail.css" rel="stylesheet" />
<title>Insert title here</title>
<script type="text/javascript"
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="https://kit.fontawesome.com/2c827c8cca.js"
   crossorigin="anonymous"></script>

  
  <script type="text/javascript">
   function but(currentPage, search ) {
         var keyword = $('#keyword').val();
         var sendData = 'currentPage=' + currentPage;
          sendData =  sendData + '&search=' + search;
          sendData =  sendData + '&keyword=' + keyword;
         /*  alert('sendData-->'+sendData) */
          location.href="A_Mkeyword?"+sendData; 
          };

</script>
</head>
<body>
 <br>
   <div class="container">
   <div class="ds">
   <h4>
   <i class="fa-solid fa-user-large"></i> &nbsp회원관리</h4>
   </div>
   <hr id="sh_hr">
   <P>사용자 수 : ${total}</P>
   
   <form action="A_Mkeyword">
   <div class="de">
      <input type="hidden" name="currentPage" value="${pg.currentPage}">
      <select name="search">
         <option value="s_all">전체조회</option>
         <option value="s_id">ID조회</option>
         <option value="s_nickname">닉네임조회</option>
         <option value="s_content">회원분류조회</option>
      </select>
      <%-- <input type="text" name="keyword" id="keyword" value="${keyword}"    placeholder="keyword를 입력하세요">
      <button type="submit">검색</button><p> --%>
         <div class="input-group">
      <input type="text"
       name="keyword" id="keyword" 
       value="${keyword}"
       class="head_input" 
       placeholder="keyword를 입력하세요"/>
      <button type="submit"  class="btn btn-outline-secondary" id="button-addon2"> <i class="fa-solid fa-magnifying-glass"></i> </button>
      </div>
      </div>   
   </form>
   <br>
   <c:set var="num" value="${pg.total-pg.start+1}"></c:set>
   
   <table class="table">
      <tr>
         <th>NO.</th>
         <th>아이디</th>
         <th>이름</th>
         <th>닉네임</th>
         <th>이메일</th>
         <th>전화번호</th>
         <th>가입일</th>
         <th>경고</th>
         <th>회원분류</th>
      </tr>
      <c:forEach var="member" items="${listMember}">
      <c:set var="seq" value="${seq + 1 }"></c:set>
         <tr>
            <td>${seq}</td>
            <td><a href="A_Mdetail?id=${member.id }">${member.id }</a></td>
            <td>${member.name}</td>
            <td>${member.nickname}</td>
            <td>${member.email}</td>
            <td>${member.phone }</td>
            <td>${member.joindate }</td>
            <td>${member.warningcnt }</td>
            <td>${member.content }</td>            
         </tr>
      </c:forEach>
   </table>
          <div id="reg_btn" class="d-flex justify-content-end">
              <button type="button" class="btn btn-warning mx-1" id="revise" onclick="location.href='A_Mlist'">
               목록</button> 
            </div>
         
   <!-- pagination -->
            <nav aria-label="Page navigation example">
               <ul class="pagination justify-content-center">
                  <c:if test="${pg.startPage > pg.pageBlock }">
                     <li class="page-item"><a class="page-link" href="A_Mkeyword?currentPage=${pg.startPage-pg.pageBlock}&search=s_all"
                        aria-label="Previous" id="page_btn"> <span
                           aria-hidden="true">&laquo;</span>
                     </a></li>
                  </c:if>
                  <c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
                  <%--    <li class="page-item"><a class="page-link" href="A_Mkeyword?currentPage=${i}&search=s_all"   id="page_btn">${i}</a></li> --%>
                     <li class="page-item"><input type="button" name="but${i}" value="${i}"  onclick="but(${i},'s_all' )" id="page_btn" class="page-link"></li>
                  </c:forEach>
                  <c:if test="${pg.endPage < pg.totalPage }">
                     <li class="page-item"><a class="page-link" href="A_Mkeyword?currentPage=${pg.startPage+pg.pageBlock}&search=s_all"
                        aria-label="Next" id="page_btn"> <span aria-hidden="true">&raquo;</span>
                     </a></li>
                  </c:if>
               </ul>
            </nav>
            
            <!-- pagination end-->
     </div>
      <div id="blank"></div>

<%@ include file="adminfooter.jsp" %>   
</body>
</html>