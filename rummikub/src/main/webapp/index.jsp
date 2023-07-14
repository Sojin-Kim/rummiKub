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
	width:100vw;
} /* 이미지 중앙 정렬 */

/* 로딩바 */
.loading-div{
position: relative;
    width: 0%;
	height:100vh;
    overflow: hidden;
	animation : load 5s 1s ease-in forwards;
}

/* 로딩바 애니메이션 */
@keyframes load{
	0%{    
		width:0%;
	}
	25%{
		width:25%;
	}
	50%{
		width:50%;
	}
	75%{
		width:75%;
	}
	100%{
		width:100%;
	}
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	// 임시 로그인 정보 담기 (삭제 예정)
	saveSession("local","login",'{"mid":1, "nickname":"sojin"}');	// 데이터 형식 맞추기
	
	// 서버 접속
	//tcpServerStart();
	
	//sessionSrch();	// 세션 정보 조회 후 페이지 이동
});

/**
 * 세션 정보 조회 후 페이지 이동
 */
function sessionSrch(){
	var login = getSession("local","login"); // 세션 정보 조회
	var url = ""; // 이동할 url
	if(isNull(login)){	// 세션에 로그인 정보가 없을 경우
		console.log("회원가입으로 이동");
		url = "member/login";
	}else{
		console.log("메인메뉴로 이동");
		url = "main/main";
	}
	// 애니메이션 끝나고 이동하기 위해 시간 지연시키기
	setTimeout(function() {
	    location.replace(url);	// replace 시 뒤로가기 안됨
	}, 6500);	// 6.5초 이후 replace 실행
}

function tcpServerStart() {
	$.ajax({
	    url: "load/tcpServerStart", //request 보낼 서버의 경로
	    type:'get', // 메소드(get, post)
	    data: null,
	    success: function(data) {
	        //서버로부터 정상적으로 응답이 왔을 때 실행
	    },
	    error: function(err) {
	        //서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
	    }
	});
}

</script>
<body>
	<div id="loadingDiv">
		<!-- <div id="loading-bar"></div> -->
		<img class="loadingImg" src="${pageContext.request.contextPath}/resources/images/loading/loading1.jpg">
		<div class="loading-div">
			<img class="loadingImg" src="${pageContext.request.contextPath}/resources/images/loading/loading2.png">
		</div>	
	</div>
</body>

<!-- 
<table>
    <tr>
        <td colspan="2">
            <input type="text" id="username" placeholder="Username"/>
            <button type="button" onclick="connect();" >Connect</button>
        </td>
    </tr>
    <tr>
        <td>
            <textarea readonly="true" rows="10" cols="80" id="log"></textarea>
        </td>
    </tr>
    <tr>
        <td>
            <input type="text" size="51" id="msg" placeholder="Message"/>
            <button type="button" onclick="send();" >Send</button>
        </td>
    </tr>
</table>
 -->
</html>