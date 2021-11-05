<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MemberJoin Page</h1>
	
	<form action="./memberJoin" method="post" enctype="multipart/form-data">
		id : <input type="text" name="id"><br>
		pw : <input type="text" name="pw"><br>
		name : <input type="text" name="name"><br>
		email : <input type="text" name="email"><br>
		
		<input type="file" name="files">
		<input type="file" name="files">
		<button type="submit">INSERT</button>
		
	</form>
</body>
</html>