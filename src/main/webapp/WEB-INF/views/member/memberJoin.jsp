<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootStrapCDN.jsp"></c:import>
</head>
<body>
	<div class="container mt-3">
		<h1>MemberJoin Page</h1>
		<form:form modelAttribute="memberVO" enctype="multipart/form-data">
			<div class="mb-3 mt-3 input-group-sm">
				<label for="id" class="form-label">ID:</label>
				<form:input path="id" id="id" cssClass="form-control" />
				<form:errors path="id" cssStyle="color:red;"></form:errors>
			</div>
			<div class="mb-3 mt-3 input-group-sm">
				<label for="pw" class="form-label">PW:</label>
				<form:input path="pw" id="pw" cssClass="form-control" />
				<form:errors path="pw" cssStyle="color:red;"></form:errors>
			</div>
			<div class="mb-3 mt-3 input-group-sm">
				<label for="pwCheck" class="form-label">PW CHECK:</label>
				<form:input path="pwCheck" id="pwCheck" cssClass="form-control" />
				<form:errors path="pwCheck" cssStyle="color:red;"></form:errors>
			</div>
			<div class="mb-3 mt-3 input-group-sm">
				<label for="name" class="form-label">NAME:</label>
				<form:input path="name" id="name" cssClass="form-control" />
				<form:errors path="name" cssStyle="color:red;"></form:errors>
			</div>
			<div class="mb-3 mt-3 input-group-sm">
				<label for="email" class="form-label">E-mail:</label>
				<form:input path="email" id="email" cssClass="form-control" />
				<form:errors path="email" cssStyle="color:red;"></form:errors>
			</div>
			<div class="mb-3 mt-3 input-group-sm">
				<label for="age" class="form-label">AGE:</label>
				<form:input path="age" id="age" cssClass="form-control" />
				<form:errors path="age" cssStyle="color:red;"></form:errors>
			</div>
			<div class="mb-3 mt-3 input-group-sm">
				<label for="birth" class="form-label">BIRTH:</label>
				<form:input path="birth" id="embirthail" cssClass="form-control" />
				<form:errors path="birth" cssStyle="color:red;"></form:errors>
			</div>
			<div>
				<button type="submit" class="btn btn-primary">Insert</button>
			</div>
		</form:form>
	</div>





	<%-- <form action="./memberJoin" method="post" enctype="multipart/form-data">
		id : <input type="text" name="id"><br> pw : <input
			type="text" name="pw"><br> pwcheck : <input type="text"
			name="pwCheck"><br> name : <input type="text"
			name="name"><br> email : <input type="text" name="email"><br>
		<!-- photo : <input type="file" name="files"><br> -->

		<input type="file" name="files"> <input type="file"
			name="files">
		<button type="submit">INSERT</button>

	</form> --%>
</body>
</html>