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
<form action=/food>
	<h1>다이어트를 도와줘</h1>
	<h3>섭취목록 리스트</h3>
		
		<c:forEach items="${FoodList}" var="List">
		<p>
		SEQ : ${List.mf_seq}
		날짜 : ${List.mf_date},
		식품명 : ${List.mf_name}
		섭취량 : ${List.mf_size}
		에너지 : ${List.mf_energy}
		총 내용량 : ${List.mf_total}
		단백질 : ${List.mf_protein} 
		지방 : ${List.mf_fat}
		탄수화물 : ${List.mf_carbo}
		총 당류 : ${List.mf_sugar}</p>
		</c:forEach>
		
		</form>
</body>
</html>