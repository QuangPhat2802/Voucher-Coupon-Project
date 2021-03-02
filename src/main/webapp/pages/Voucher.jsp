<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/css/index.css'/>">
<title>Voucher</title>
</head>
<body>
	<header>
		<a href="/admin">Admin</a> <a href="/customer">Customer</a>
	</header>
	<br>
	<form action="/admin/code" method="get">
		<h4>Kiểm tra Voucher</h4>
		<label for="voucherCode">Nhập mã code</label> <input type="text"
			id="voucherCode" name="voucherCode"><br>
		<br> <label for="price">Nhập giá</label> <input type="text"
			id="price" name="price"> <input type="submit" value="check">
		<div>${mess}</div>
		<br>
		<br>
		<h3>Danh sách voucher đã được sử dụng</h3>
		<table>
			<tr>
				<th>Orders Id</th>
				<th>Price</th>
				<th>customer phone</th>
				<th>voucher code</th>
			</tr>
			<c:forEach var="listOrder" items="${listOrder}">
				<tr>
					<td>${listOrder.ordersID}</td>
					<td>${listOrder.price}</td>
					<td>${listOrder.customerEntity.phone}</td>
					<td>${listOrder.voucherEntity.voucherCode}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<br>
	<br>
	<form action="/admin/code" method="post">
		<h2>Gán coupon cho sdt</h2>
		<label for="customerEntity.phone">Nhập số điện thoại</label> <input
			type="text" id="customerEntity.phone" name="customerEntity.phone"><br>
		<p>${messerror}</p>
		<label for="voucherCode">Nhập mã code</label> <select
			id="voucherEntity.voucherCode" name="voucherEntity.voucherCode">
			<c:forEach var="listVoucher" items="${listVoucher}">
				<option value="${listVoucher.voucherCode}">${listVoucher.voucherCode}</option>
			</c:forEach>
		</select> <input type="submit" value="add">
	</form>
	<form action="/admin/phone" method="get">
		<h2>Kiểm tra</h2>
		<label for="customerEntity.phone">Nhập số điện thoại</label> <select
			id="phone" name="phone">
			<c:forEach var="listPhoneAndVoucher" items="${listPhoneAndVoucher}">
				<option value="${listPhoneAndVoucher.customerEntity.phone}">${listPhoneAndVoucher.customerEntity.phone}</option>
			</c:forEach>
		</select> <input type="submit" value="check">
	</form>
	<br>
	<form action="/admin/phone" method="post">
		<label for="voucherEntity.voucherCode">Nhập mã code</label> <select
			id="voucherCode" name="voucherCode">
			<c:forEach var="listVoucherCodeByPhone"
				items="${listVoucherCodeByPhone}">
				<option value="${listVoucherCodeByPhone.voucherEntity.voucherCode}">${listVoucherCodeByPhone.voucherEntity.voucherCode}</option>
			</c:forEach>
		</select> <br>
		<br> <label for="price">Nhập giá</label> <input type="text"
			id="price" name="price">
		<p>${listVoucherAndPrice}</p>
		<input type="submit" value="check">
	</form>
</body>
</html>