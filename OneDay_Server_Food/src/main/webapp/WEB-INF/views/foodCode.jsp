<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html" ;charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>��ǰ ����</h1>
	
	<a href = "/food/diet/foodList">���ư���</a>
	
	<p>
	
	<table border="1">
	<tr bgcolor="violet">
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
	  <h2>���� ���� �Է�</h2>
	  

	  
	<form action="/food/insert" method="POST">
	��¥ : <input type="date" name="f_date" value="2021-01-01"/>
	���뷮 : <input name="f_size"/>
	��ǰ�ڵ� : <input name="f_fcode" value=${FOOD.fd_code}>
	<button>�Է�</button>
	
	
	</form>
	</tr>
</body>
</html>