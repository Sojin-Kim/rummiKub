<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>rummiKub</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="./resources/js/common.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<!-- 2023/06/23 ksj 수정
	index.jsp는 첫 화면 호출!!
	로딩하는 화면으로 사용할 예정입니다.
 -->
<style>
#loadingDiv{
	position: relative;
}

.loadingImg{
	position: absolute;
    transform: translate(28%, 6%);
} /* 이미지 중앙 정렬 */

/* 로딩바 */
#loading-bar{
	position: absolute;
	top:251px;
	left:298px;
	background-color:#f0c986;
	width:0px;
	height:25px;
	animation : load 5s 1s ease-in forwards;
}

/* 로딩바 애니메이션 */
@keyframes load{
	0%{    
		width:0px;
	}
	25%{
		width:100px;
	}
	50%{
		width:200px;
	}
	75%{
		width:300px;
	}
	100%{
		width:404px;
	}
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	//saveSession("local","login","{email:so97so@naver.com, nickname:sojin}");
	sessionSrch();	// 세션 정보 조회 후 페이지 이동
});

/**
 * 세션 정보 조회 후 페이지 이동
 */
function sessionSrch(){
	var login = getSession("local","login"); // 세션 정보 조회
	var url = ""; // 이동할 url
	if(isNull(login)){	// 세션에 로그인 정보가 없을 경우
		console.log("회원가입으로 이동");
		url = "/member/login";
	}else{
		console.log("메인메뉴로 이동");
		url = "/main/main";
	}
	// 애니메이션 끝나고 이동하기 위해 시간 지연시키기
	setTimeout(function() {
	    location.replace(url);	// replace 시 뒤로가기 안됨
	}, 6500);	// 6.5초 이후 replace 실행
}
</script>
<body>
	<div id="loadingDiv">
		<div id="loading-bar"></div>
		<img class="loadingImg" src="${pageContext.request.contextPath}/resources/images/loading/load2.png">
	</div>
</body>
</html>