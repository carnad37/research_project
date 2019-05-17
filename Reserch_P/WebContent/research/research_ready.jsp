<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
<title>설문 준비</title>
<style type="text/css">
  * {margin: 0; padding: 0; font-family: 'Noto Sans KR', sans-serif;}
  header, .wrapper {margin: 20px auto; }
  .wrapper {text-align: left; width:700px; padding: 30px 80px; border: 2px dotted black; box-sizing: border-box;}
  header {font-size: 32px; text-align: center;}
  .content {padding: 20px; background-color: rgba(150, 231, 244, 0.4); color:black; border-radius: 10px;}
  p { text-align: center;}
  a {margin-top:10px; text-decoration: none; color:white;  display: inline-block; width: 170px; box-sizing: border-box; text-align: center; border-radius: 10px; padding: 1px 4px 4px 1px; font-size: 20px; background-color: rgb(60, 167, 219);}
  a.start, a.stop {width: 230px; height: 80px; padding-top: 22px; font-size: 24px;}
  a.hover:hover {background-color: rgb(186, 232, 255); color: rgb(27, 160, 217);}
  a.stop {background-color: rgb(182, 182, 182);}
  p.select a:nth-of-type(1){margin-right: 10px;}
</style>
</head>
<body>
  <header>
    <h1>설문 시작</h1>
  </header>
  <div class="wrapper">
  	<div class="content">
  		&nbsp<strong>${research.customer}</strong>에서 <strong>${research.subject}</strong>분야로 진행되는 설문조사로,
  		총 <strong>${research.max_qnum}</strong>개의 항목이 <strong>${research.opendate}</strong>부터
  		<strong>${research.closedate}</strong>까지 진행됩니다.
  	</div>
  	  <c:choose>
  		<c:when test="${result eq 'IN'}">
  			<p><a class="start hover" href="pInfo_view.do">설문시작하기</a></p>
  		</c:when>
  		<c:when test="${result eq 'OUT'}">
  			<p><a class="stop" href="#">설문기간이 아닙니다</a></p>
  		</c:when>
  	</c:choose>
    <p class="select"><a class="hover" href="open_table.do">설문선택으로</a><a class="hover" href="main.do">메인메뉴로</a></p>
  </div>
</body>
</html>
