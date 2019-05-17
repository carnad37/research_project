<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
<title>설문지 질문 등록</title>
<style type="text/css">
  * {margin: 0; padding: 0; font-family: 'Noto Sans KR', sans-serif;}
  header, .wrapper {margin: 20px auto; }
  legend {text-align: center; font-size: 22px;}
  header {font-size: 32px; text-align: center;}
  ul {list-style-type: none;}
  li {margin-bottom: 20px; text-align: center;}
  label {font-weight: normal;}
  .wrapper {width: 430px; border: 2px dotted black; padding: 40px 20px 20px 20px; box-sizing: border-box;}
  .qus-input {width: 300px;}
  .ans-input {width: 50px; text-align: center;}
  .last_li {text-align: center; margin-top: 40px;}

  a, button {font-weight: bold; margin-top:10px; text-decoration: none; color:white;  display: inline-block; box-sizing: border-box; text-align: center; border-radius: 10px; padding: 1px 4px 4px 1px; font-size: 20px;}
  a {background-color: rgb(218, 68, 68);width: 170px;}
  button {background-color: rgb(60, 167, 219); border:0; outline: 0; width:100px;}
  button:hover {background-color: rgb(186, 232, 255); color: rgb(27, 160, 217);}
  button:nth-child(1) {margin-right: 30px;}
  a:hover {background-color: rgba(218, 68, 68, 0.44); color: rgb(80, 12, 12);}
  h3 {color: red;}
</style>
</head>
<body>
  <header>
    <h1>질문 등록</h1>
  </header>
    <form action="question.do" method="post">
    <fieldset class="wrapper">
    <legend>${qCount}번째 질문</legend>
      <ul>
      	<c:if test=" ${error eq 'NMExc'}" >
      		<li><h3>답변 수에 숫자를 입력해주세요.</h3></li>
      	</c:if>
        <li><label><Strong>질문명</Strong> : <input class="qus-input" type="text" name="QUESTION"></label></li>
        <li><label><Strong>답변 수</Strong> : <input class="ans-input" type="text" name="MAX_ANUM"></label></li>
        <li class="last_li">
			<button type="submit">답변등록</button>
			<button type="reset">다시작성</button>
        </li>
        <li><a href="main.do">메뉴로 돌아가기</a></li>
      </ul>
    </form>
    </fieldset>
</body>
</html>
