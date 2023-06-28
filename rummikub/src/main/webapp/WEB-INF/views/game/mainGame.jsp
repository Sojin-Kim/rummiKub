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
<script type="text/javascript" src="../resources/js/common.js"></script>
<script type="text/javascript" src="../resources/js/game/mainGame.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/game/mainGame.css">
</head>
<!-- 
  메인 게임 화면
  2023/06/28 ksj 추가
-->
<body>
	<input type="button" value="시작하기" id="startBtn" onclick="start()">
	
	<main>
	  <table id="mainGrid">
	    
	  </table>
	</main>
	<div id="prifile">
	  
	</div>
	<div id="privateGrid">	<!-- 내꺼 빼고 히든 시킬 예정 :  -->
		player1
		<table id="privateTable1">
		
		</table>
		player2
		<table id="privateTable2">
		
		</table>
		player3
		<table id="privateTable3">
		
		</table>
		player4
		<table id="privateTable4">
		
		</table>
	</div>
	
	<div id="card">
	  <div id="jokercard">
	    <div class="blackcard card cardPack" id="card105">J</div>
	    <div class="redcard card cardPack" id="card106">J</div>
	  </div>
	</div>
	
</body>

</html>