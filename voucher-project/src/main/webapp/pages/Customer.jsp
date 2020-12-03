<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/css/index.css'/>">
<title>Insert title here</title>
</head>
<body>
	
	<br>
	<form action="/customer/phone" method="get">
	<p>xác minh số điện thoại</p>
		<input type="text" name="phone"/>
		<input type="submit" name="phone" value="check"/>
		<table>
		<c:forEach var="list" items="${listKH}">
			<tr>
				<td>${list.phone}</td>
				<td>${list.customerName}</td>
			</tr>
		</c:forEach>
	</table>
	</form>
</body>
</html>