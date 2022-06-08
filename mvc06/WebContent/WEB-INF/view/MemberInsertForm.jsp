<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberInsertForm.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp%>/css/main.css">
</head>
<body>
<div>
	<form action="memberinsert.action" method="get">
		ID <input type="text" name="id">
		<br />
		pw <input type="text" name="pw">
		<br />
		이름 <input type="text" name="name">
		<br />
		전화번호 <input type="text" name="tel">
		<br />
		이메일 <input type="text" name="email">
		<br />
		<br />
		<button type="submit">완료</button>
	</form>
</div>
</body>
</html>