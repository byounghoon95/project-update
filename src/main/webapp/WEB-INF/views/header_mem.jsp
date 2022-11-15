<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Font Awesome icons (free version)-->
    <script
      src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
      crossorigin="anonymous"
    ></script>
    <!-- Google fonts-->
    <link
      href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900"
      rel="stylesheet"
    />
    <link
      href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i"
      rel="stylesheet"
    />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/hfmem_before.css" rel="stylesheet" />
    <link href="css/hfmem_after.css" rel="stylesheet" />

	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
	$(function() {
		$('#button-addon2').click(function() {
			var keyword =  $('#keyword').val();
			if (!keyword) {
				alert("검색어를 입력하세요")
				return false;
			}
			var sendData = 'keyword='+keyword + '&Gubun=1';
			/* alert('sendData-->'+sendData) */
			location.href="searchList?"+sendData;
		});
	});
	</script>

    <title>Cheese Market</title>
  </head>
  <body id="page-top">
    <!-- Navigation-->
    <div class="fixed-top1">
    <div class="container d-flex flex-row justify-content-end welcome">
      <i class="fa-regular fa-bell"></i
      ><span id="welcome">${nickname }님 환영합니다!</span
      ><a id="logout" href="/logout">Logout</a>
    </div>
    </div>
    <nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
      <div class="container px-5">
        <a href="/main"><img src="images/logo.png" id="logo" /></a>
        <div class="input-group">
          <input
            type="text" id="keyword" 
            class="head_input" value="${keyword }" 
            placeholder="동네 이름, 물품명 등을 검색해보세요 !"
          />
          <button
            class="btn btn-outline-secondary"
            type="button"  value="확인1" 
            id="button-addon2"
          >
            <i class="fa-solid fa-magnifying-glass"></i>
          </button>
        </div>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarResponsive"
          aria-controls="navbarResponsive"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ms-auto">
            <li class="nav-item">
              <a class="nav-link" href="/market" id="new">치즈마켓</a>
            </li>
            <li class="nav-item nav-link">|</li>
            <li class="nav-item">
              <a class="nav-link" href="/board">치즈일상</a>
            </li>
          </ul>
        </div>
        <button type="button" class="btn btn-warning" id="start" onclick="location.href='/mypage'">
          My 치즈
        </button>
      </div>
    </nav>
    <div id="blank"></div>
    
  </body>
</html>
