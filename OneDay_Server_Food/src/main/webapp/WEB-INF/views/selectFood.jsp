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
	<h1>식품 조회하기</h1>
	
	<a href = "/food/diet/foodList">돌아가기</a>
	
	<p>
	
	<table border="1">
	<tr bgcolor="violet">
	    <th>식품코드
		<th>식품명 
		<th>출시 연도
		<th>회사 코드
		<th>회사명
		<th>분류코드
		<th>분류명
		<th>1회 제공량
		<th>총 내용량
		<th>단백질
		<th>지방
		<th>탄수화물
		<th>총 당류
		<th>에너지
		
		<c:forEach items="${FOODLIST}" var="FOOD">
	<tr>
	   <td>${FOOD.fd_code}</td>
	   <td><a href = "/food/diet/foodList/code?fd_code=${FOOD.fd_code}">${FOOD.fd_name}</a></td>
	   <td>${FOOD.fd_year}</td>
	   <td>${FOOD.cp_code}</td>
	   <td>${FOOD.cp_name}</td>
	   <td>${FOOD.it_code}</td>
	   <td>${FOOD.it_name}</td>
	   
	   <td>${FOOD.fd_serv}</td>
	   <td>${FOOD.fd_total}</td>
	   <td>${FOOD.fd_protein}</td>
	   <td>${FOOD.fd_fat}</td>
	   <td>${FOOD.fd_carbo}</td>
	   <td>${FOOD.fd_sugar}</td>
	   <td>${FOOD.fd_energy}</td>
	</tr>
	</c:forEach>
	</table>
		<p>
	<c:if test ="${empty FOODLIST}">식품정보 없음</c:if>

</body>
</html>