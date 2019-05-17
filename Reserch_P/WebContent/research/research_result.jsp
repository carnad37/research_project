<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
<title>결과창</title>
<style>
  * {margin: 0; padding: 0; font-family: 'Noto Sans KR', sans-serif;}
  p.title {text-align: center; margin-bottom: 20px; font-weight: bold; font-size: 20px;}
  header, .wrapper {margin: 20px auto; }
  .wrapper {text-align: center;}
  header {font-size: 32px; text-align: center;}
  ul {list-style-type: none;}
  li {margin-bottom: 20px;}
  label {font-weight: normal;}
  .wrapper {width: 430px; border: 2px dotted black; padding: 30px 30px 20px 20px; box-sizing: border-box;}
  a {margin-top:10px; text-decoration: none; color:white; background-color: rgb(60, 167, 219); display: inline-block; width: 170px; box-sizing: border-box; text-align: center; border-radius: 10px; padding: 1px 4px 4px 1px; font-size: 20px;}
  a:hover {background-color: rgb(186, 232, 255); color: rgb(27, 160, 217);}
</style>
</head>
<body>
  <header>
    <h1>결과</h1>
  </header>
	<!--결과 처리는 총 3개의 데이터. 1.기능(function) 2.오류여부(int?) 3.결과물(result등등)-->
	<div class="wrapper">
	<c:choose>
		<c:when test="${function eq 'CREATE_RESEARCH'}">
			<c:if test="${result != 1}">
				<p>설문생성에 실패하였습니다.</p>
				<p>자세한 사항은 관리자에게 문의해주십시오.</p>	
			</c:if>
			<c:if test="${result == 1}">
				<p class="title">등록된 설문 정보는 다음과 같습니다.</p>
				<ul>
					<li><Strong>설문조사명</Strong> : ${research.title}</li>
					<li><Strong>의뢰처</Strong> : ${research.customer}</li>
					<li><Strong>설문분야</Strong> : ${research.subject}</li>					
					<li><Strong>최대질문수</Strong> : ${research.max_qnum}</li>
					<li><Strong>설문시작일</Strong> : ${research.opendate}</li>
					<li><Strong>설문종료일</Strong> : ${research.closedate}</li>
				</ul>
				<a href="question_view.do">질문답변 등록하기</a><br>	
			</c:if>
		</c:when>
		<c:when test="${function eq 'INSERT_QA'}">
			<c:if test="${result != 1}">
				<p>질문 등록 과정에서 오류가 발생하였습니다</p>
				<p>자세한 사항은 관리자에게 문의해주십시오.</p>	
			</c:if>
			<c:if test="${result == 1}">
				<p class="title">질문과 답변의 등록이 완료되었습니다.</p>
			</c:if>
		</c:when>	
		<c:when test="${function eq 'JOIN_RESEARCH'}">
			<p class="title">참여해주셔서 감사합니다.</p>	
		</c:when>	
	</c:choose>
	<a href="main.do">메뉴로 돌아가기</a>
	</div>
</body>
</html>