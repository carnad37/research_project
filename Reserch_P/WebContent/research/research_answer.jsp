<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
<title>설문지 답변 등록</title>
<style type="text/css">
  * {margin: 0; padding: 0; font-family: 'Noto Sans KR', sans-serif;}
  header, .wrapper {margin: 20px auto; }
  legend {text-align: center; font-size: 22px;}
  header {font-size: 32px; text-align: center;}
  ul {list-style-type: none;}
  li {margin-bottom: 20px; text-align: center;}
  label {font-weight: normal;}
  .wrapper {width: 430px; border: 2px dotted black; padding: 30px 20px 20px 20px; box-sizing: border-box;}
  .qus-input {width: 300px;}
  .ans-input {width: 50px; text-align: center;}
  .last_li {text-align: center; margin-top: 40px;}
  a, button {font-weight: bold; margin-top:10px; text-decoration: none; color:white;  display: inline-block; box-sizing: border-box; text-align: center; border-radius: 10px; padding: 1px 4px 4px 1px; font-size: 20px;}
  a {background-color: rgb(218, 68, 68);width: 170px;}
  button {background-color: rgb(60, 167, 219); border:0; outline: 0; width:100px; margin-right: 10px;}
  button:hover {background-color: rgb(186, 232, 255); color: rgb(27, 160, 217);}
  button:nth-child(3) {margin-right: 0; width:120px;}
  a:hover {background-color: rgba(218, 68, 68, 0.44); color: rgb(80, 12, 12);}
  .title {text-align: center;font-size: 18px; margin-bottom: 30px;}
</style>
</head>
	<!-- 서블릿에서 전달될수 있는 결과들 : 업로드 성공, 입력오류(공란), 업로드 실패 -->
	<!-- 업로드가 성공했을 경우 : 다음 질문 작성창을 띄우면서, result에 "sucess"반환. Q_COUNT에 1을 더한다.(서블릿에서 처리) -->
<body>
  <header>
    <h1>답변 등록</h1>
  </header>
    <form action="answer.do" method="post">
    <fieldset class="wrapper">
    <legend>${qCount}번째 질문</legend>
      <ul>
      	<li class="title"><strong>질문명</strong> : ${question}</li>
      	<c:forEach var="cnt" begin="1" end="${max_anum}">
      		<li><label><Strong>${cnt}번 답변</Strong> : <input class="qus-input" type="text" name="${cnt}_ans"></label></li>
      	</c:forEach>      
        <li class="last_li">
	        <button type="submit">답변등록</button>
	        <button type="reset">다시작성</button>
	        <button type="button" onclick="location.href='question_view.do'">질문 재작성</button>
        </li>
        <li><a href="research_main.jsp">메뉴로 돌아가기</a></li>
      </ul>
    </form>
    </fieldset>
</body>
</html>
