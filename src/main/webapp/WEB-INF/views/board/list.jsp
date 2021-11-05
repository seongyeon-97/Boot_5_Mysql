<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>${board} ListPage</h1>
	<!------------------- search form --------------------->
	<form action="./selectList" id="frm">
	<input type="hidden" name="pn" value="1" id="pn">
		<select name="kind" id="kind">
			<option class="s" value="title">Title</option>
			<option class="s" value="contents">Contents</option>
			<option class="s" value="writer">Writer</option>
		</select> <input type="text" name="search" id="search">

		<button type="submit" id="btn">SEARCH</button>

	</form>
	<!------------------- search form --------------------->

	<!------------------- perPage select form --------------------->
	<!-- <form action="./selectList">
		<select name="perPage">
			<option value="5">5개씩 보기</option>
			<option value="10">10개씩 보기</option>
			<option value="20">20개씩 보기</option>
		</select>

		<button type="submit">SEARCH</button>

	</form> -->
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

	<!-------------------------- pager ------------------------------>

	<%-- <a href="./selectList?pn=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">PRE</a> --%>
	<button class="p" data-list-pn="${pager.startNum-1}" type="button">PRE</button>

	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		<%-- <a href="./selectList?pn=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a> --%>
		<span class="p" data-list-pn="${i}">${i}</span>
	</c:forEach>


	<c:if test="${!pager.lastCheck}">
		<%-- <a href="./selectList?pn=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">NEXT</a> --%>
		<button class="p" data-list-pn="${pager.lastNum+1}" type="button">NEXT</button>
	</c:if>
	<br>
	<!-------------------------- pager ------------------------------>

	<a href="./insert">Write</a>
	<script type="text/javascript" src="../js/list.js"></script>
	<script type="text/javascript">
		let kind = '${pager.kind}';
		let search = '${pager.search}';
		let pn = ${pager.pn};
		
		$('.s').each(function () {
			if($(this).val() == kind){
				$(this).prop("selected", true);
			}
		});
		
		$('#search').val(search);
		
		$('.p').click(function () {
			const n = $(this).attr("data-list-pn")
			$('#pn').val(n);
			$('#search').val(search);
			$('#kind').val(kind);
			$('#frm').submit();
		});
		/* $('#kind').val(kind); */
		console.log(kind, search, pn);
	</script>
</body>
</html>