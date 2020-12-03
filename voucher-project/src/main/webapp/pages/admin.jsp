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
<header>
	<a href="/admin" >Admin</a>
	<a href="/customer">Customer</a>
</header><br>	
	<table>
		<tr>
			<th>voucherCode</th>
			<th>Voucher-Name</th>
			<th>des</th>
			<th>quantity</th>
			<th>discount</th>
			<th>minPrice</th>
			<th>start date</th>
			<th>end date</th>
			<th>status</th>
			<th>phone</th>
		</tr>
		<c:forEach var="list" items="${listVoucher}">
		<tr>
			<td> <a href="/admin/phone?voucherCode=${list.voucherCode}">${list.voucherCode}</a></td>
			<td>${list.voucherName}</td>
			<td>${list.description}</td>
			<td>${list.quantity}</td>
			<td>${list.discount}</td>
			<td>${list.minPrice}</td>
			<td>${list.startDate}</td>
			<td>${list.endDate}</td>
			<td> <c:if test="${list.status == 0}">
					<c:out value="Chưa sử dụng"></c:out>
				</c:if>
				<c:if test="${list.status == 1}">
					<c:out value="Đã sử dụng"></c:out>
				</c:if> 
			</td>
			<td>${list.customerEntity.phone}</td>
		</tr>
		</c:forEach>
	</table>
	<form action="/admin/code" method="get">
	<br/>
	<div><label for="phone">Nhập phone</label></div>
	<input type="text" name="phone" id="phone" value="${customerEntity.phone}"/><br><br>
	<div><label for="minPrice">Nhập giá đơn hàng</label></div>
	<input type="text" name="minPrice" id="minPrice" value="${minPrice}"/>
	<input type="submit" name="check" value="check"/>
	<br><br>
	<select id="voucherCode" name="voucherCode">
		<c:forEach items="${list}" var="list">
			<option value="${list.voucherCode}">${list.voucherCode}</option>
		</c:forEach>
	</select>
	<h1>${error}</h1>
	 <c:forEach var="list" items="${list}">
			<div>
			<c:if test="${list.status == 0}">
					<c:out value="Có thể sử dụng voucher"></c:out>
				</c:if>
				<c:if test="${list.status == 1}">
					<c:out value="Voucher đã sử dụng"></c:out>
				</c:if>
			</div><p>${list.voucherCode}</p>
		</c:forEach>	
	
	<br>
	<!-- ======================================================== -->
	<p>Danh sách voucher đã sử dụng</p>
	<table>
		<tr>
			<th>ordersID</th>
			<th>Gia</th>
			<th>phone</th>
			<th>voucherCode</th>	
		</tr>
		<c:forEach var="list" items="${listDonHang}">
		<tr>	
	 		<td>${list.ordersID}</td>
			<td>${list.minPrice}</td>
			<td>${list.customerEntity.phone}</td>
			<td>${list.voucherEntity.voucherCode}</td>
		</tr>
		</c:forEach>
	</table>
	</form>
</body>
</html>