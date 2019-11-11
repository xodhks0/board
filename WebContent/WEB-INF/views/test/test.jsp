<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border='1'>
		<tr>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<c:forEach var="tt" items="${list}">
			<tr>
				<th>${tt.name}</th>
				<th>${tt.age}</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>