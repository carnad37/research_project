<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
<title>설문 답변</title>
<style type="text/css">
  * {margin: 0; padding: 0; font-family: 'Noto Sans KR', sans-serif;}
  header, .wrapper {margin: 20px auto; }
  header {font-size: 32px; text-align: center;}
  .wrapper {width:500px; border: 2px dotted black; padding: 20px 20px 20px 20px; box-sizing: border-box;}
  ul {list-style: none;}
  li {margin-left: 20px; margin-top:10px; font-size: 15px;}
  p {font-size: 18px; padding: 10px; background-color: rgba(172, 255, 203, 0.4); border-radius: 10px;}
  a, button {font-weight: bold; margin-top:10px; text-decoration: none; color:white;  display: inline-block; box-sizing: border-box; text-align: center; border-radius: 10px; padding: 1px 4px 4px 1px; font-size: 20px;}
  a {background-color: rgb(218, 68, 68);width: 100px;}
  button {background-color: rgb(60, 167, 219); border:0; outline: 0; width:100px;}
  button:hover {background-color: rgb(186, 232, 255); color: rgb(27, 160, 217);}
  a.pass:hover {background-color: rgba(218, 68, 68, 0.44); color: rgb(80, 12, 12);}
  div.select {margin: 0 auto; width: 210px;}
  a.stop {background-color: rgb(182, 182, 182);}  
</style>
</head>
<body>
  <header>
    <h1>설문 조사</h1>
  </header>
  <form action="next.do" method="post">
  <div class="wrapper">
  	<c:if test="${error eq 'NOT_SELECT'}">
  	  	<h4>답변을 선택하지 않으셨습니다.</h4>  	
  	</c:if>
	<p><strong>Q</strong> : ${research.listQA[qCount - 1].question}</p>
	<ul>
		<c:forEach var="unitAnswer" items="${research.listQA[qCount - 1].answer}" varStatus="status">
			<c:if test="${before == null}">
				<li><label><input type="radio" name="rAnswer" value="${status.count}">&nbsp&nbsp${unitAnswer}</label></li>
			</c:if>
			<c:if test="${before != null}">
				<c:choose>
					<c:when test="${before == status.count}">
						<li><label><input type="radio" name="rAnswer" checked="checked" value="${status.count}">&nbsp&nbsp${unitAnswer}</label></li>
					</c:when>
					<c:otherwise>
						<li><label><input type="radio" name="rAnswer" value="${status.count}">&nbsp&nbsp${unitAnswer}</label></li>
					</c:otherwise>
				</c:choose>
			</c:if>
		</c:forEach>
	</ul>
		<div class="select">
		<c:if test="${qCount == 1}">
			<a class="stop" href="#">이전</a>
		</c:if>
		<c:if test="${qCount != 1}">
			<a class="pass" href="before.do?qCount=${qCount - 1}">이전</a>
		</c:if>
		<input type="hidden" name = "qCount" value = "${qCount}">

		<button type="submit">
			<c:choose>
				<c:when test="${qCount == research.max_qnum}">
					완료
				</c:when>
				<c:otherwise>
					다음
				</c:otherwise>
			</c:choose>
		</button>
		</div>
  </div>
  </form>
</body>
</html>
