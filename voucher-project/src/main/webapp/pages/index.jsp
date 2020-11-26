<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>voucher</title>
<link rel="stylesheet" href="<c:url value='/css/index.css'/>">
</head>
<body>

	
	<table>
		<tr>
			<th>code</th>
			<th>name</th>
			<th>des</th>
			<th>quantity</th>
			<th>discount</th>
			<th>start date</th>
			<th>end date</th>
			<th>status</th>
			<th>sdt</th>
		</tr>
		<c:forEach var="list" items="${listVoucher}">
		<tr>
			<td> <a href="/voucher/addSdt?code=${list.code}">${list.code}</a></td>
			<td>${list.name}</td>
			<td>${list.description}</td>
			<td>${list.quantity}</td>
			<td>${list.discount}</td>
			<td>${list.startDate}</td>
			<td>${list.endDate}</td>
			
			<td> <c:if test="${list.status == 0}">
					<c:out value="chua su dung"></c:out>
				</c:if>
				<c:if test="${list.status == 1}">
					<c:out value="da su dung"></c:out>
				</c:if> 
			</td>
		</tr>
		</c:forEach>
	</table>
	<form action="/voucher/code" method="get">
	<br/>
	<input type="text" name="code" value="${code}"/>
	<input type="submit" name="check" value="check"/>
	<br>
		<c:forEach var="list" items="${list}">
			<div>
			<p>${list.code}
			<c:if test="${list.status == 0}">
					<c:out value="chua su dung"></c:out>
				</c:if>
				<c:if test="${list.status == 1}">
					<c:out value="da su dung"></c:out>
				</c:if></p>
			</div>
		</c:forEach>
	</form>

</body>
</html>