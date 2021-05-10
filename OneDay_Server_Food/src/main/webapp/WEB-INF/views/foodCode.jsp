<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>식품 정보</h1>
	
	<a href = "/food/diet/foodList">돌아가기</a>
	
	<p>
	
	<table border="1">
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
	
	<tr>
	   <td>${FOOD.fd_code}</td>
	   <td>${FOOD.fd_name}</td>
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
	   
	  <p>
	  <p>
	  <h2>섭취 정보 입력</h2>
	  
	
	  
	<form action="/food/diet/insert?">
	날짜 : <input name="f_date"/>
	섭취량 : <input name="f_size"/>
	식품코드 : <input name="f_fcode"/>
	<button>입력</button>
	
	
	</form>
	</tr>
</body>
</html>