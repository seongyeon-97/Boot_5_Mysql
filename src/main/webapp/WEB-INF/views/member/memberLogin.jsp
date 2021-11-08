<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MemberLogin page</h1>
	
	<form action="./memberLogin" method="post" enctype="multipart/form-data">
		
		id : <input type="text" name="id"><br>
		pw : <input type="text" name="pw"><br>
					
		<button type="submit">INSERT</button>
		
	</form>
</body>
</html>