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
	<h1>��ǰ ���� ����Ʈ</h1>
	
	<form action="foodList/select">
	<h3>��ǰ �̸����� ��ȸ</h3>
		<input name="fd_name"/><button>����</button>
	</form>
	
	<form action="foodList/code">
	<h3>��ǰ �ڵ�� ��ȸ</h3>
		<input name="fd_code"/><button>����</button>
	</form>
	<p>
	
	<a href = "/food/">���ư���</a>
	
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