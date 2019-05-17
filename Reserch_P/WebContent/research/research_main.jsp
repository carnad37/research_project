<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
<title>설문 조사</title>
<style type="text/css">
  * {margin: 0; padding: 0; font-family: 'Noto Sans KR', sans-serif;}
  header, .wrapper {margin: 20px auto; text-align: center;}
  header {font-size: 32px;}
  .wrapper {width: 400px; border: 2px dotted black; padding: 20px;}
  .wrapper::after {content: ""; display: block; clear: both;}
  li {font-size: 30px; margin: 10px 0;}
  .menu > ul > li {padding: 2.5px 0;}
  a {text-decoration: none; color:white; background-color: rgb(60, 167, 219); display: inline-block; box-sizing: border-box; width: 80px; text-align: center; border-radius: 10px; padding: 1px 4px 4px 1px;}
  a:hover {background-color: rgb(186, 232, 255); color: rgb(27, 160, 217);}
  ul {list-style-type: none;}
  .float {float: left;}
  .menu {width: 300px;}
  .start {width: 100px;}
</style>
</head>
<body>
  <header>
    <h1>설문조사</h1>
  </header>
  <div class="wrapper">
    <div class="menu float">
      <ul>
        <li>
          <span>설문조사 생성</span>
        </li>
        <li>
          <span>설문조사 실행</span>
        </li>
        <li>
          <span>DB삭제</span>
        </li>
        <li>
          <span>DB백업</span>
        </li>
        <li>
          <span>설문데이터 분석</span>
        </li>
      </ul>
    </div>
    <div class="start float">
      <ul>
        <li><a href="create_view.do">시작</a></li>
        <li><a href="open_table.do">시작</a></li>
        <li><a href="delete_view.do">시작</a></li>
        <li><a href="backup_view.do">시작</a></li>
        <li><a href="#">시작</a></li>
      </ul>
    </div>
  </div>
</body>
</html>