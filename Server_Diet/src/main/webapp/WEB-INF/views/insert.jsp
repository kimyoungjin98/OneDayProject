<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style>
		*{
			box-sizing: border-box;
		}
		
		h1, form{
			width:80%;
			margin:10px auto;
		}
		
		h1{
			background-color: rgba(0,255,0,0.6);
			color:white;
			padding:1.2rem;
			text-align: center;
		}
		
		form{
			border:1px solid green;
			border-radius:20px;
			padding:10px;
		}
		
		label{
			display : inline-block;
			width:20%;
			text-align: right;
		}
		input{
			width:60%;
			padding:8px;
			margin:5px;
		}
		
		button{
			background-color: blue;
			color:white;
			padding:8px;
			outline:0;
			border:0;
			border-radius: 10px;
			cursor:pointer;
		}
		
		button:hover{
			/* x-offset y-offset blue spread color */
			box-shadow: 3px 3px 3px rgba(0,0,0,0.3);
		}
	</style>
</head>
<body>
	<h1>��ǰ ���� ���� �Է�</h1>
	<form method="POST">
	<p><label>��ǰ�ڵ�</label>
		<input name="mf_code" value="${FOOD.fd_code}">
	<p><label>��ǰ�̸�</label>
		<input name="mf_name" value="${FOOD.fd_name}">
	<p><label>��������</label>
		<input type="date" name="mf_date" value="${TODAY}">
	<p><label>���뷮</label>
		<input type="number" name="mf_amt" value="1">
	<button>���</button>		
	</form>
</body>
</html>