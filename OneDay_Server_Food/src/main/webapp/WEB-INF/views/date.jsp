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
	<h1>��¥������ ��ȸ�� ����Ʈ</h1>
	
	<a href="/food">���ư���</a>
	
	<p>
	
	<table border="1">
		<th>SEQ
		<th>��¥ 
		<th>��ǰ��
		<th>���뷮
		<th>������
		<th>�� ���뷮
		<th>�ܹ���
		<th>����
		<th>ź��ȭ��
		<th>�� ���
		
		<tr>
		<c:forEach items="${FoodList}" var="List">
		<td>${List.mf_seq}</td>
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