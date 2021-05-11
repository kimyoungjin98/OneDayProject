<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<tr bgcolor="violet">
	<h2>삭제할 데이터의 SEQ 입력</h2>
	<form action="/food/delete" method="POST">
	<input name="mf_seq">
	<button>전송</button>
	</form>
	<p>
	
	<a href = "/food">돌아가기</a>
	
	<p>
	
		<th>SEQ
		<th>날짜 
		<th>식품명
		<th>섭취량
		<th>에너지
		<th>총 내용량
		<th>단백질
		<th>지방
		<th>탄수화물
		<th>총 당류
		
		<tr>
		<c:forEach items="${FoodList}" var="List">
		<td>${List.mf_seq}</a></td>
		<td>${List.mf_date}</td>
		<td>${List.mf_name}</td>
		<td>${List.mf_size}</td>
		<td>${List.mf_energy}</td>
		<td>${List.mf_total}</td>
		<td>${List.mf_protein}</td>
		<td>${List.mf_fat}</td>
		<td>${List.mf_carbo}</td>
		<td>${List.mf_sugar}</td></tr>
			</c:forEach> 
			</table>
			
</body>
</html>