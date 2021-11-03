<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board}ListPage</h1>
	<!------------------- search form --------------------->
	<form action="./selectList">
		<select name="kind">
			<option value="title">Title</option>
			<option value="contents">Contents</option>
			<option value="writer">Writer</option>
		</select> <input type="text" name="search">			
		
		<button type="submit">SEARCH</button>

	</form>
	<!------------------- search form --------------------->
	
	<!------------------- perPage select form --------------------->
	<form action="./selectList">				
		<select name="perPage">
			<option value="5">5개씩 보기</option>
			<option value="10">10개씩 보기</option>
			<option value="20">20개씩 보기</option>
		</select>
		
		<button type="submit">SEARCH</button>

	</form>
	<!------------------- perPage select form --------------------->
		
	
	
	<table>
		<tr>
			<td>Num</td>
			<td>Title</td>
			<td>Writer</td>
			<td>regDate</td>
			<td>hit</td>
		</tr>

		<c:forEach items="${boardList}" var="boardVO">
			<tr>
				<td>${boardVO.num}</td>
				<td><a href="./selectOne?num=${boardVO.num}">${boardVO.title}</a></td>
				<td>${boardVO.writer}</td>
				<td>${boardVO.regDate}</td>
				<td>${boardVO.hit}</td>
			</tr>
		</c:forEach>
	</table>

	<a href="./insert">Write</a>

</body>
</html>