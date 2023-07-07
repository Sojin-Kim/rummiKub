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
	<div id="leftSide">
		<div id="prifile">	<!-- 왼쪽 사이드 -->
			<div id="player2">
			
			
			</div>
			<div id="player3">
			
			
			</div>
			<div id="player4">
			
			
			</div>
			<div id="player1">
			
			
			</div>
		</div>
	</div>
	<div id="middle">		<!-- 중앙 -->
		<main id="mainGrid">
		  <table id="mainTable">
		  </table>
		</main>
		
		<div id="privateGrid">	<!-- 내꺼 빼고 히든 시킬 예정 :  -->
			<table id="privateTable1" class="privateTable">
			
			</table>
			<table id="privateTable2" class="privateTable">
			
			</table>
			<table id="privateTable3" class="privateTable">
			
			</table>
			<table id="privateTable4" class="privateTable">
			
			</table>
		</div>
	</div>
	<div id="rightSide">	<!-- 오른쪽 사이드 -->
	
	
		<!-- 히든 처리 모아두기 -->
		<div id="hidden">
			<input type="button" value="시작하기" id="startBtn" onclick="start()">
			<div id="card">
			  <div id="jokercard">
			    <div class="blackcard card cardPack" id="card105">J</div>
			    <div class="redcard card cardPack" id="card106">J</div>
			  </div>
			</div>
		</div>
	</div>
</body>


</html>