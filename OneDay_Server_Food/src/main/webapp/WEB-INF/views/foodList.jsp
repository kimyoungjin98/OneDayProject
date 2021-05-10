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
	<h1>식품 정보 리스트</h1>
	
	<form action="foodList/select">
	<h3>식품 이름으로 조회</h3>
		<input name="fd_name"/><button>전송</button>
	</form>
	
	<form action="foodList/code">
	<h3>식품 코드로 조회</h3>
		<input name="fd_code"/><button>전송</button>
	</form>
	<p>
	
	<a href = "/food/">돌아가기</a>
	
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
		
		<c:forEach items="${fLIST}" var="fFOOD">
	<tr>
	   <td>${fFOOD.fd_code}</td>
	   <td>${fFOOD.fd_name}</td>
	   <td>${fFOOD.fd_year}</td>
	   <td>${fFOOD.cp_code}</td>
	   <td>${fFOOD.cp_name}</td>
	   <td>${fFOOD.it_code}</td>
	   <td>${fFOOD.it_name}</td>

	   <td>${fFOOD.fd_serv}</td>
	   <td>${fFOOD.fd_total}</td>
	   <td>${fFOOD.fd_protein}</td>
	   <td>${fFOOD.fd_fat}</td>
	   <td>${fFOOD.fd_carbo}</td>
	   <td>${fFOOD.fd_sugar}</td>
	   <td>${fFOOD.fd_energy}</td>
	</tr>
	</c:forEach>
</body>
</html>