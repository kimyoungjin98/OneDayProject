<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	h1{
		background-color: rgba(255,0,0,0.7);
		color:white;
		padding:1.2rem;
		text-align: center;
	}
	
	a{
		text-decoration:none;
	}

	/* 
	CSS 3�� ����� interactive ��Ÿ�� ����
	����(Dynamic) ��Ÿ�� ���� 
	*/
	/* a tag�� ���콺�� �� ������ */
	a:hover{
		text-decoration: underline;
		background-color:rgba(0,0,255,0.3);	
	}
</style>
</head>
<body>
	<h1>���̾�Ʈ�� ������!!</h1>
	<%-- /diet/food/search --%>
	<a href="${pageContext.request.contextPath}/food/search">�������� ���</a>
</body>
</html>