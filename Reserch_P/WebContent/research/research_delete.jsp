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
  .del_btn {background-color: rgb(218, 68, 68); width: 200px;}
  .del_btn:hover {background-color: rgba(218, 68, 68, 0.44); color: rgb(80, 12, 12);}
  .main_btn {margin-left: 20px; width: 100px;}
</style>
</head>
<body>
  <header>
    <h1>DB 삭제</h1>
  </header>
  <form action="delete.do" method="post">
  <div class="wrapper">
	<table>
    <tr class="title">
      <td></td>
      <td>설문명</td>
      <td>의뢰처</td>
      <td>분야</td>
      <td>질문수</td>
      <td>개시일</td>
      <td>종료일</td>
    </tr>
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
  </table>
  <p><button class="del_btn" type="submit">선택 항목 삭제하기</button><button class="main_btn" type="button" onclick="location.href='main.do'">메인으로</button></p>
  </div>
  </form>
</body>
</html>
