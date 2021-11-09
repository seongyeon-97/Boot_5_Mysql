<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/test.css">
</head>
<body>
	<h1>Index Page <spring:message code="hello.hi"></spring:message></h1>

	<c:choose>
		<c:when test="${sessionScope.member != null}">
		
			<h3>${member.name}님</h3>
			<h3><spring:message code="member.info" arguments="${member.id},${member.email}" argumentSeparator=","></spring:message></h3>
			<a href="./member/memberLogout">LOGOUT</a>
		</c:when>
		<c:otherwise>
		
			<a href="./member/memberLogin">LOGIN</a>
			<br>
			<a href="./member/memberJoin">JOIN</a>
			<br>
			
		</c:otherwise>
	</c:choose>
	<%-- <h1>${m}</h1> --%>
</body>
</html>