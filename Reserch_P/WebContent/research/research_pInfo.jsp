<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
<title>설문 대상자 정보입력</title>
<style type="text/css">
  * {margin: 0; padding: 0; font-family: 'Noto Sans KR', sans-serif;}
  header, .wrapper {margin: 20px auto; }
  .wrapper {text-align: right;}
  header {font-size: 32px; text-align: center;}
  label {font-weight: normal;}
  .wrapper {width: 430px; border: 2px dotted black; padding: 20px 20px 20px 20px; box-sizing: border-box;}
  .text-input {margin-left: 30px;}
  tr td:nth-of-type(1) {width: 20%; text-align: right;}
  tr td:nth-of-type(2) {text-align: left;}
  tr td:nth-of-type(3) {text-align: center; width:	 25%;}
  td {height: 30px;}
  button {cursor: pointer; font-weight: bold; background-color: red; outline: 0; border: 0;color:white; background-color: rgb(60, 167, 219); display: inline-block; width: 100%; height: 55px; box-sizing: border-box; text-align: center; border-radius: 10px; padding: 1px 4px 4px 1px; font-size: 20px;}
  button:hover {background-color: rgb(186, 232, 255); color: rgb(27, 160, 217);}
  table {border-collapse: collapse; width: 300px; margin: 20px auto;}
  a {background-color: rgb(218, 68, 68);width: 100%; font-weight: bold; margin-top:5px; height:28px; text-decoration: none; color:white;  display: block; box-sizing: border-box; text-align: center; border-radius: 10px; padding: 1px 4px 4px 1px; font-size: 16px;}
  a:hover {background-color: rgba(218, 68, 68, 0.44); color: rgb(80, 12, 12);}  
</style>
</head>
<body>
  <header>
    <h1>설문 대상자 정보입력</h1>
  </header>
  <div class="wrapper">
    <form action="pInfo.do" method="post">
    	<table>
    		<tr>
    			<td>성별&nbsp&nbsp&nbsp</td>
    			<td>:&nbsp&nbsp&nbsp 
    				<label><input type="radio" name="sex" value="male">남자</label>&nbsp
    				<label><input type="radio" name="sex" value="female">여자</label>
    			</td>
    			<td rowspan="3">
    				<button type="submit">입력</button>
    				<a href="open_table.do">리스트로</a>
    			</td>
    		</tr>
    		<tr>
    			<td>나이&nbsp&nbsp&nbsp</td>
    			<td>:&nbsp&nbsp&nbsp 
    				<select name="age">
						<c:forEach var="cnt" begin="12" end="80">
							<option value="${cnt}">${cnt}</option>
						</c:forEach>
	    			</select>
    			</td>
    		</tr>
    		<tr>
    			<td>직업&nbsp&nbsp&nbsp</td>
    			<td>:&nbsp&nbsp&nbsp 
	    			<select name="job">
	    				<option value="have_job">직장인</option>
	    				<option value="student">학생</option>
	    				<option value="jubu">주부</option>
	    				<option value="soldier">군인</option>
	    				<option value="no_job">무직</option>
	    			</select>
	    		</td>
    		</tr>
    	</table>
    </form>
  </div>
</body>
</html>