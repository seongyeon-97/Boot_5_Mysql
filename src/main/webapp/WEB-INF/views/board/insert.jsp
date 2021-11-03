<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} Insert Page</h1>
	<form action="./insert" method="post">
	
		title : <input type="text" name="title"><br>
		writer : <input type="text" name="writer"><br>
		contents : <textarea rows="" cols="" name="contents"></textarea><br>
		
		<button type="submit">INSERT</button>
		
	</form>
</body>
</html>