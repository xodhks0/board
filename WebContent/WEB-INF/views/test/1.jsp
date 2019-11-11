<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <c:set var="test" value="나나나"/>
 
 ${test} <br>
<%@ include file="/WEB-INF/views/common/header.jspf" %>
<!DOCTYPE html>
<%
pageContext.setAttribute("msg", "페이지");
request.setAttribute("msg", "리퀘스트"); /* 1.jsp에서만 값이 있고, 2.jsp로 넘어가면 null */
session.setAttribute("msg","세션"); /* 1.jsp를 실행하고 2를 실행하면 유지되나 브라우저를 종료하고 바로 들어가면 null */
application.setAttribute("msg", "어플리케이션");
//session.invalidate();
/* RequestDispatcher rd = request.getRequestDispatcher("/views/test/2");
rd.forward(request, response); */
%>
${msg}  <!--  작은것 부터 찾아냄 page - request - session - application 순 -->