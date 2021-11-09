<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootStrapCDN.jsp"></c:import>
</head>
<body>
	<div class="container mt-3">
		<h1>${board}InsertPage</h1>
		<form:form modelAttribute="boardVO" enctype="multipart/form-data">
			<div class="mb-3 mt-3 input-group-sm">
				<label for="title" class="form-label">Title:</label>
				<form:input path="title" id="title" cssClass="form-control" />
				<form:errors path="title" cssStyle="color:red;"></form:errors>
			</div>
			<div class="mb-3 mt-3 input-group-sm">
				<label for="title" class="form-label">Writer:</label>
				<form:input path="writer" id="writer" cssClass="form-control"/>
				<form:errors path="writer" cssStyle="color:red;"></form:errors>

			</div>
			<div class="mb-3 mt-3">
				<label for="Contents">Contents:</label>				
				<form:textarea path="contents" cssClass="form-control" rows="5" id="comment" name="text"/>
				<form:errors path="contents" cssStyle="color:red;"></form:errors>
			</div>
			
			<div class="mb-3 mt-3 input-group-sm">
				<input type="file" name="files">
			</div>
			<div class="mb-3 mt-3 input-group-sm">
				<input type="file" name="files">
			</div>


			<div>
				<button type="submit" class="btn btn-primary">Write</button>
			</div>
		</form:form>
	</div>

	<!-- ---------------------------------------------------------------------- -->

	<%-- <form action="./insert" method="post" enctype="multipart/form-data">
	
		title : <input type="text" name="title"><br>
		writer : <input type="text" name="writer"><br>
		contents : <textarea rows="" cols="" name="contents"></textarea><br>
		
		<input type="file" name="files">
		<input type="file" name="files">
		<button type="submit">INSERT</button>
		
	</form> --%>
</body>
</html>