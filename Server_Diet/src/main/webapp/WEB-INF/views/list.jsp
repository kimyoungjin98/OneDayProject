<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<table>
	<tr>
        <th>��������</th>
        <th>��ǰ�ڵ�</th>
        <th>��ǰ��</th>
        <th>���뷮</th>
        <th>������</th>
        <th>���뷮</th>
        <th>ź��ȭ��</th>
        <th>����</th>
        <th>���</th>
        <th>�ܹ���</th>
        <th>Į�θ�</th>
    </tr>
    <c:forEach items="${MFOODS}" var="MF">
        <tr>
            <td>${MF.mf_date}</td>
            <td>${MF.mf_fcode}</td>
            <td>${MF.mf_name}</td>
            <td>${MF.mf_amt}</td>
            <td>${MF.mf_one}</td>
            <td>${MF.mf_capa}</td>
            <td>${MF.mf_carvo}</td>
            <td>${MF.mf_fat}</td>
            <td>${MF.mf_sugar}</td>
            <td>${MF.mf_protein}</td>
            <td>${MF.mf_cal}</td>
        </tr>
        </c:forEach>
</table>

