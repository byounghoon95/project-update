<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
	String context = request.getContextPath();
%>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<link href="${pageContext.request.contextPath}/css/background.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/register.css" rel="stylesheet" />
<title>Cheese Market</title>
<script type="text/javascript">
//아이디 중복확인
$(function () {
	$("#check_btn").on("click", function () {
		let id_input = $('#id_input').val();
		$.ajax(
				{
					url:'<%=context%>/user/idCheck',
					type:"get",
					data:{"id" : id_input},
					dataType:'text',
					success:function(data){
						if(data == "nonUsable"){
							$('.idchk').html("중복된 아이디입니다").css('color','rgb(253, 201, 0)');
							$('#id_input').val("");
						}else if(data =="usable"){
							$('.idchk').html("사용가능한 아이디입니다").css('color','green');;
						}else{
							$('.idchk').html("아이디를 입력해주세요").css('color','rgb(253, 201, 0)');
						}
					}
				}
		);
	});
	// 비밀번호 중복확인
	$('#pwcheck').blur(function() {
		if($('#pw').val() != $('#pwcheck').val()){
			$('.pwchk').html("비밀번호가 일치하지 않습니다").css('color','rgb(253, 201, 0)');
			$('#pwcheck').val("");
		}else{
			if ($('#pw').val() != "") {
				$('.pwchk').html("비밀번호가 일치합니다").css('color','green');
			}
		}
	});
});
</script>
</head>
<body>
	<div class="container py-5 h-100">
		<div
			class="row d-flex justify-content-center align-items-center h-100">
			<!-- xl-10 변경하면 가로폭 줄어듬 -->
			<div class="col col-xl-8">
				<img src="${pageContext.request.contextPath}/images/logo.png" id="logo" />
				<div class="card" style="border-radius: 1rem">
					<div class="g-0">
						<div class="col-md-6 col-lg-7 d-flex align-items-center">
							<div class="card-body p-4 p-lg-5 text-black">
								<form action="/user/register" method="post">
									<div class="input_all">
										<div class="form-outline mb-4">
											<label class="form-label">아이디</label>
											<div class="d-flex">
												<input type="text" class="input" name="id" id="id_input"
													placeholder="아이디를 입력해주세요" required />
												<button type="button" class="btn" id="check_btn">
													중복확인</button>
											</div>
										</div>
										<span class="idchk"></span>
										<div class="form-outline mb-4">
											<label class="form-label">이름</label>
											<input type="text" class="input" name="name"
												placeholder="이름을 입력해주세요" required />
										</div>

										<div class="form-outline mb-4">
											<label class="form-label">비밀번호</label>
											<input type="password" class="input" name="password" id="pw"
											placeholder="비밀번호를 입력해주세요" required />
										</div>
										<span class="pwchk1"></span>
										<div class="form-outline mb-4">
											<label class="form-label">비밀번호 확인</label>
											<input type="password" class="input" name="pwcheck" id="pwcheck" placeholder="비밀번호를 한 번 더 입력해주세요" required />
										</div>
										<span class="pwchk"></span>
										<div>
											<button class="btn btn-lg btn-block" type="submit"
												id="login_btn">회원가입</button>
										</div>
										<br /> <a href="/login" id="reg">이미
											계정이 있습니까?&nbsp <span id="reg_in">로그인</span>하세요
										</a><br />
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>