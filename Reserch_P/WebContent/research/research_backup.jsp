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
  header, .wrapper {margin: 20px auto; text-align: center;}
  header {font-size: 32px;}
  table {border-collapse: collapse;}
  tr, td {border-bottom: 1px solid black; border-top: 1px solid black; }
  td {padding: 2px 10px;}
  .title {font-size: 20px; font-weight: bold;}
</style>
</head>
<body>
  <header>
    <h1>DB 백업</h1>
  </header>
	<table class="wrapper">
    <tr class="title">
      <td></td>
      <td>설문명</td>
      <td>의뢰처</td>
      <td>분야</td>
      <td>질문수</td>
      <td>개시일</td>
      <td>종료일</td>
      <td></td>
    </tr>
    <form action="backup.do" method="post">
    <c:forEach var="research" items="${researchList}" varStatus="status">
		<tr>
	      <td><input type="checkbox" name="check_id" value="${research.research_id}"></td>
		  <td>${research.title}</td>
		  <td>${research.customer}</td>
		  <td>${research.subject}</td>
		  <td>${research.max_qnum}</td>
		  <td>${research.opendate}</td>
		  <td>${research.closedate}</td>
		</tr>
    </c:forEach>
	<p><button class="del_btn" type="submit">선택 항목 삭제하기</button><button class="main_btn" type="button" onclick="location.href='main.do'">메인으로</button></p>
	</form>
  </table>
</body>
</html>
