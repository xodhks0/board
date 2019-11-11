<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="users/list">
		번호 : <input type="text" name="ui_num"><br> ID : <input
			type="text" name="ui_id"><br> 이름 : <input type="text"
			name="ui_name"><br>
		<button>검색</button>
	</form>
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>아이디</th>
		</tr>
		<c:forEach var="user" items="${list}">
			<tr>
				<td>${user.ui_num}</td>
				<td>${user.ui_name}</td>
				<td>${user.ui_id}</td>
			</tr>
	</table>
	</c:forEach>
</body>
</html>