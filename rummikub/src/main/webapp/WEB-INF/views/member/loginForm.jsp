<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<style>
#logo{
	display:flex;
	justify-content: center;
	height:50px;
	width:100%;
	margin-top:40px;
	border-bottom: 1px solid black;
}
#logo>img{
	height:30px;
}
</style>
<body>
<div id="logo">
	<!-- 로고 클릭 시 홈페이지 이동 -->
	<img src="${pageContext.request.contextPath}/resources/images/common/hyundai_logo_white.png">
</div>
	<div class="box">
		<div class="inner-box">
			<form name="login" action="/workout/member/loginAction.do" method="post" autocomplete="on">
				<div class="loginForm">	<!-- <-form으로 수정 -->
					<h3 type="subtitle1">
						<strong>이메일 로그인</strong>
					</h3>
					<div class="spacingInput">
						<input type="text" name="userId" id="userId" aria-invalid="false" placeholder="아이디" value="" title="아이디">
					</div>
					<div class="spacingInput">
						<input type="password" name="password" id="password" aria-invalid="false"  placeholder="비밀번호" value="" title="비밀번호">
					</div>
				</div>
				<div style="padding-top: 10px;">
					<button tabindex="0" type="submit">
						<span>로그인</span>
					</button>
				</div>
			</form>
			<div>
				<a href="">아이디 찾기</a>   |  
				<a href="">비밀번호 초기화</a>
				<span><a href="">회원가입</a>▶</span>
			</div>
		</div>
	</div>
</body>
</html>