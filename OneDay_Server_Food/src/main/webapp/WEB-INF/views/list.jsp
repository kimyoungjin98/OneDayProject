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
	<h1>���̾�Ʈ�� ������</h1>
	<h3>������ ����Ʈ</h3>
		
		<c:forEach items="${FoodList}" var="List">
		<p>
		SEQ : ${List.mf_seq}
		��¥ : ${List.mf_date},
		��ǰ�� : ${List.mf_name}
		���뷮 : ${List.mf_size}
		������ : ${List.mf_energy}
		�� ���뷮 : ${List.mf_total}
		�ܹ��� : ${List.mf_protein} 
		���� : ${List.mf_fat}
		ź��ȭ�� : ${List.mf_carbo}
		�� ��� : ${List.mf_sugar}</p>
		</c:forEach>
		
		</form>
</body>
</html>