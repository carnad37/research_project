<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
<title>설문조사 실행</title>
<style type="text/css">
  * {margin: 0; padding: 0; font-family: 'Noto Sans KR', sans-serif;}
  header, .wrapper, table {margin: 20px auto; text-align: center;}
  .wrapper {}
  header {font-size: 32px;}
  table {border-collapse: collapse;}
  tr, td {border-bottom: 1px solid black; border-top: 1px solid black; }
  td {padding: 2px 10px;}
  .title {font-size: 20px; font-weight: bold;}
  button {cursor: pointer; font-weight: bold; background-color: red; outline: 0; border: 0;color:white; background-color: rgb(60, 167, 219); display: inline-block; width: 100%; height: 55px; box-sizing: border-box; text-align: center; border-radius: 10px; padding: 1px 4px 4px 1px; font-size: 20px;}
  button:hover {background-color: rgb(186, 232, 255); color: rgb(27, 160, 217);}
  .main_btn {width: 100px;}
  p {text-align: center;}
</style>
</head>
<body>
  <header>
    <h1>설문조사 실행</h1>
  </header>
  	<div class="wraaper">
	<table>
    <tr class="title">
    
      <td>설문명</td>
      <td>의뢰처</td>
      <td>분야</td>
      <td>질문수</td>
      <td>개시일</td>
      <td>종료일</td>
      <td></td>
    </tr>
    <c:forEach var="research" items="${researchList}" varStatus="status">
		<tr>
		  <td>${research.title}</td>
		  <td>${research.customer}</td>
		  <td>${research.subject}</td>
		  <td>${research.max_qnum}</td>
		  <td>${research.opendate}</td>
		  <td>${research.closedate}</td>
		  <td>
		  	<c:choose>
		  		<c:when test="${research.register == 1}">
		  			<form action="ready.do" method="post">
		  				<input type="hidden" value="${research.research_id}" name="RESEARCH_ID">
		  				<input type="hidden" value="${research.max_anum}" name="MAX_ANUM">
		  				<input type="hidden" value="${status.index}" name="INDEX">
		  				<input type="submit" value="등록">
		  			</form>
		  		</c:when>
		  		<c:when test="${research.register == 0}">
		  			<form action="ready.do" method="post">
		  				<input type="hidden" value="${research.research_id}" name="RESEARCH_ID">
		  				<input type="hidden" value="${research.max_anum}" name="MAX_ANUM">
		  				<input type="hidden" value="${status.index}" name="INDEX">
		  				<input type="submit" value="시작">
		  			</form>
		  		</c:when>
		  	</c:choose>
		  </td>
		</tr>
    </c:forEach>
  	</table>
  	<p><button class="main_btn" type="button" onclick="location.href='main.do'">메인으로</button></p>
  	</div>
</body>
</html>
