<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} Update page</h1>
	
	<form action="./update" method="post">
		<input type="hidden" name="num" value="${boardVO.num}">
		title : <input type="text" name="title" value="${boardVO.title}"><br>	
		writer : <input type="text" name="writer" readonly="readonly" value="${boardVO.writer}"><br>	
		contents : <textarea rows="" cols="" name="contents">${boardVO.contents}</textarea><br>		
		
		<button type="submit">UPDATE</button>
		
	</form>
</body>
</html>