<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/voucher/addSdt" method="post">
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
		<c:forEach var="list" items="${list}">
		<tr>
			<td> ${list.code}</td>
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
			<td>
			<select id="sdt" name="voucherEntity.sdt">
			 	<c:forEach var="list" items="${listKH}">
					<option value="${list.id}">${list.sdt}</option>
				</c:forEach> 
			</select>
			</td>
			<input type="submit" name="sdt" value="add"/>
		</tr>
		</c:forEach>
	</table>
</form>
</body>
</html>