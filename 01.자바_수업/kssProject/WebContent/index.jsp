<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function search(){
		alert("�˻����ּ���.");
	}
</script>
</head>
<body>
Tomcat Server Start<br>
����� �̼��� <b>������</b> ������ �Դϴ�.<br>
WAS(Web Application Server)�� ��ġ �Ͽ����ϴ�.<br>
�湮���ּż� �����մϴ�.
<%
	String img = "http://192.168.0.17:8000/images/�����.png";
%>
<img src="<% out.print(img);%>" width="500px" height="400px"/>
<br>
<input type="text" size="20" value="���̸��� �Է��ϼ���." onClick="search()">
<input type="button" value="�˻�">
</body>
</html>
















