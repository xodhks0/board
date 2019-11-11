<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jspf"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table style="margin:auto; text-align:center">
	<tr>
		<th>번호</th>
		<th width="500">제목</th>
		<th>작성자</th>
		<th>작성날짜</th>
		<th>작성시간</th>
		<th>수정날짜</th>
		<th>수정시간</th>
	</tr>
	<c:if test="${empty list}">
	<tr>
		<td colspan="7">게시물이 없습니다</td>
	</tr>
	</c:if>
	<c:forEach var="board" items="${list}">
	<tr>
		<td>${board.biNum}</td>
		<td><a href="/board/view?biNum=${board.biNum}">${board.biTitle}</a></td>
		<td>${board.uiNum}</td>
		<td>${board.credat}</td>
		<td>${board.cretim}</td>
		<td>${board.moddat}</td>
		<td>${board.modtim}</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="7" align="right"><a href="/views/board/insert"><button>글쓰기</button></td>    
	</tr>
</table>
</body>
</html>