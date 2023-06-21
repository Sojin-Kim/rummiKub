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
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<style>
html,body{
	width:100%;
	height:100%;
}
#loadingDiv{
	display: flex;
    justify-content: center;
    align-items: center;
}

#loadingImg{
 	top:50%;
	width:50%;
} /* 이미지 중앙 정렬 */

</style>
<body>
	<div id="loadingDiv">
		<img id="loadingImg" src="${pageContext.request.contextPath}/resources/images/loading.jpg">
	</div>
</body>
</html>