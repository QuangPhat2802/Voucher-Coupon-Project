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
	<form action="/KH/sdt" method="post">
	<table>
		<tr>
			<th>code</th>
			<th>name</th>
			<th>des</th>
			<th>quantity</th>
			<th>discount</th>
			<th>minPrice</th>
			<th>start date</th>
			<th>end date</th>
			<th>status</th>
		</tr>
		<c:forEach var="list" items="${listKH}">
		<tr>
			<td>${list.code}</td>
			<td>${list.name}</td>
			<td>${list.description}</td>
			<td>${list.quantity}</td>
			<td>${list.discount}</td>
			<td>${list.minPrice}</td>
			<td>${list.startDate}</td>
			<td>${list.endDate}</td>
			<td> <c:if test="${list.status == 0}">
					<c:out value="Có thể sử dụng"></c:out>
				</c:if>
				<c:if test="${list.status == 1}">
					<c:out value="Đã sử dụng"></c:out>
				</c:if> 
			</td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<input type="text" id="sdt" name="sdt" value="${khachHangEntity.sdt}" readonly />
	<h3>Nhap gia tri don hang</h3> 
		<input type="text"  id="minPrice"  name="minPrice" value="${minPrice}"/> <br><br>
		<input type="submit" name="check" value="check" /><br><br>
		<select id="code" name="code" >
				<c:forEach var="list" items="${listVoucher}">
					<option value="${list.code}">${list.description}</option>
				</c:forEach> 
		</select>
		<br>
		<br>
	
	</form>
</body>
</html>