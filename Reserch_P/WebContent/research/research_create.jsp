<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
<title>설문조사 생성</title>
<style>
  * {margin: 0; padding: 0; font-family: 'Noto Sans KR', sans-serif;}
  header, .wrapper {margin: 20px auto; }
  .wrapper {text-align: right;}
  header {font-size: 32px; text-align: center;}
  ul {list-style-type: none;}
  li {margin-bottom: 20px; font-weight: bold;}
  label {font-weight: normal;}
  .wrapper {width: 430px; border: 2px dotted black; padding: 40px 30px 20px 20px; box-sizing: border-box;}
  .text-input {margin-left: 30px;}
  li:nth-child(7) {margin-bottom: 50px;}
  .last_li {text-align: center;}
  button {font-weight: bold; margin-left:10px; background-color: red; outline: 0; border: 0;color:white; background-color: rgb(60, 167, 219); display: inline-block; width: 100px; box-sizing: border-box; text-align: center; border-radius: 10px; padding: 1px 4px 4px 1px; font-size: 20px;}
  button:nth-child(1) {margin-left:0px;}
  button:hover {background-color: rgb(186, 232, 255); color: rgb(27, 160, 217);}
  button.return {background-color: rgb(218, 68, 68); color: white;}
  button.return:hover {background-color: rgba(218, 68, 68, 0.44); color: rgb(80, 12, 12);}

</style>
</head>
<body>
  <header>
    <h1>설문조사 생성</h1>
  </header>
  <div class="wrapper">
    <form action="create.do" method="post">
      <ul>
        <li>의뢰처 : <input class="text-input" type="text" name="CUSTOMER"></li>
        <li>설문조사이름 : <input class="text-input" type="text" name="TITLE"></li>
        <li>설문분야 :&nbsp
          <label><input type="radio" name="SUBJECT" value="인문">인문</label>&nbsp
          <label><input type="radio" name="SUBJECT" value="사회">사회</label>&nbsp
          <label><input type="radio" name="SUBJECT" value="과학">과학</label>&nbsp
          <label><input type="radio" name="SUBJECT" value="공학">공학</label>&nbsp
          <label><input type="radio" name="SUBJECT" value="농업">농업</label>&nbsp
          <label><input type="radio" name="SUBJECT" value="경제">경제</label>
        </li>
        <li>질문 갯수 : <input class="text-input" type="text" name="MAX_QNUM"></li>
        <li>시작일 : <input class="text-input" type="date" name="OPEN"></li>
        <li>종료일 : <input class="text-input" type="date" name="CLOSE"></li>
        <li class="last_li">
       		<button type="submit">등록하기</button>
        	<button type="reset">다시작성</button>
        </li>
        <li class="last_li">
        	<button class="return" type="button" onclick="location.href='main.do'">뒤로가기</button>
        </li>
        <!--<input type="submit" value="등록하기">&nbsp<input type="reset" value="다시작성">&nbsp<button type="button" onclick="location.href='research_main.html'">뒤로가기</button>-->
      </ul>
    </form>
  </div>
</body>
</html>
