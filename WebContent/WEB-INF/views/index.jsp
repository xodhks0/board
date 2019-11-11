<%@page import="java.util.Enumeration"%>
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
안녕하세요~<br>
<%
if(user==null){
%>
<a href="/views/users/login">로그인</a>
<%
}else{
%>
<a href="/board/list">게시판 가기 </a>
<a href="/users/logout">로그아웃 </a>
<%
}
Enumeration <String> enums = session.getAttributeNames();
while(enums.hasMoreElements()) {
	String key = enums.nextElement();
	out.println(key + ":" + session.getAttribute(key)+"<br>");
}
%>
</body>
</html>