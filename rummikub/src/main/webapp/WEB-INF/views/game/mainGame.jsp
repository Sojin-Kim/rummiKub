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
<!-- 
  메인 게임 화면
  2023/06/23 ksj 추가
-->
<style>
#loadingDiv{
	position: relative;
}

#loadingImg{
	position: absolute;
    transform: translate(10%, 0%);
} /* 이미지 중앙 정렬 */

</style>
<body>
	<div id="loadingDiv">
	</div>
</body>
</html>