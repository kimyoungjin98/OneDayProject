<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>
<%-- �ܺ��� css file ��������
webapp�� ������ ������Ʈ�� �ܺο��� �����Ҷ�
root Folder�� �νĵȴ�
������(/)�� ���۵Ǵ� ��δ� webapp ������ �νĵȴ�

�׷��� ���� ������Ʈ���� ������(/)�� �����ϴ� ��� ��û��
homeController�� catcher �ϵ��� ������� �ֱ⶧����
��� ���ϵ� ������ �Ҽ� ���� --%>
<%-- 
chrome browser�� ĳ�� ������
css, js �� �ܺ� ������ �����ص� ������ �ȵǴ� ��찡 �ִ�
?ver=���� ���� �����ϸ� chrome browser�� 
������ ����� ������ �ν��Ͽ� ���ΰ�ħ�� ���ش� 
--%>
<link href="${rootPath}/css/home.css?ver=1" rel="stylesheet">
</head>
<body>
	<h1>���̾�Ʈ�� ������!!</h1>
	<%-- /diet/food/search --%>
	<a href="${pageContext.request.contextPath}/food/search">�������� ���</a>
	
	<div>
        <form>
        <label>��¥</label>
        <input name="mf_date">
        </form>
    </div>
	
	<!-- JSP ���Ͽ��� �ٸ� JSP ���� �����ϱ�  -->
	<%@ include file="/WEB-INF/views/list.jsp" %>
</body>
</html>