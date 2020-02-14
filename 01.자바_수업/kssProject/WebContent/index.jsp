<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function search(){
		alert("검색해주세요.");
	}
</script>
</head>
<body>
Tomcat Server Start<br>
여기는 이순신 <b>웹서버</b> 페이지 입니다.<br>
WAS(Web Application Server)를 설치 하였습니다.<br>
방문해주셔서 감사합니다.
<%
	String img = "http://192.168.0.17:8000/images/고양이.png";
%>
<img src="<% out.print(img);%>" width="500px" height="400px"/>
<br>
<input type="text" size="20" value="동이름을 입력하세요." onClick="search()">
<input type="button" value="검색">
</body>
</html>
















