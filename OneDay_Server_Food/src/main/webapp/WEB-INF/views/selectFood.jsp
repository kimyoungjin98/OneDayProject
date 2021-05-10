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
	<h1>��ǰ ��ȸ�ϱ�</h1>
	
	<a href = "/food/diet/foodList">���ư���</a>
	
	<p>
	
	<table border="1">
	    <th>��ǰ�ڵ�
		<th>��ǰ�� 
		<th>��� ����
		<th>ȸ�� �ڵ�
		<th>ȸ���
		<th>�з��ڵ�
		<th>�з���
		<th>1ȸ ������
		<th>�� ���뷮
		<th>�ܹ���
		<th>����
		<th>ź��ȭ��
		<th>�� ���
		<th>������
		
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
	<c:if test ="${empty FOODLIST}">��ǰ���� ����</c:if>

</body>
</html>