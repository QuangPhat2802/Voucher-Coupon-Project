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
<header>
	<a href="/admin" >Admin</a>
	<a href="/customer">Customer</a>
</header><br>
	<form action="/customer/phone" method="get">
	<p>Xác minh khách hàng bằng điện thoại</p>
		<input type="text" name="phone"/>
		<input type="submit" name="phone" value="Kiểm tra"/>
		<table>
		<c:forEach var="listCustomer" items="${listCustomer}">
			<tr>
				<td>${listCustomer.phone}</td>
				<td>${listCustomer.customerName}</td>
			</tr>
		</c:forEach>
	</table>
	</form><br>
	<form action="/customer/phone" method="post">
	<table>
		<tr>
			<th>voucherCode</th>
			<th>name</th>
			<th>des</th>
			<th>quantity</th>
			<th>discount</th>
			<th>max price discount</th>
			<th>minPrice</th>
			<th>start date</th>
			<th>end date</th>
			<th>status</th>
		</tr>
		<c:forEach var="listVoucher" items="${listVoucher}">
		<tr>
			<td>${listVoucher.voucherEntity.voucherCode}</td>
			<td>${listVoucher.voucherEntity.voucherName}</td>
			<td>${listVoucher.voucherEntity.description}</td>
			<td>${listVoucher.voucherEntity.quantity}</td>
			<td>${listVoucher.voucherEntity.discount}</td>
			<td>${listVoucher.voucherEntity.maxPriceDiscount}</td>
			<td>${listVoucher.voucherEntity.minPrice}</td>
			<td>${listVoucher.voucherEntity.startDate}</td>
			<td>${listVoucher.voucherEntity.endDate}</td>
			<td> <c:if test="${listVoucher.voucherEntity.status == 0}">
					<c:out value="Có thể sử dụng"></c:out>
				</c:if>
				<c:if test="${listVoucher.voucherEntity.status == 1}">
					<c:out value="Đã sử dụng"></c:out>
				</c:if> 
			</td>
		</tr>
		</c:forEach>
	</table><br>
	<input type="hidden" id="phone" name="phone" value="${customerEntity.phone}" readonly />
	<h3>Nhập giá trị đơn hàng </h3> 
		<input type="text"  id="price"  name="price" value="${totalprice}"/> 
		<input type="submit" name="check" value="Kiểm tra" /><br><br>
	</form>
	<form action="/customer/price" method="get">
		<div>
			<label for= "customerEntity.phone">Số điện thoại khách hàng</label>
		</div><br>
		<input type="text" id="customerEntity.phone" name="customerEntity.phone" value="${customerEntity.phone}"/><br>
		<input type="hidden"  id="price"  name="price" value="${price}"/><br>
		<div>
			<label for="voucherEntity.voucherCode">Chọn Voucher</label>
		</div><br>
		<select id="voucherEntity.voucherCode" name="voucherEntity.voucherCode" >
				<c:forEach var="listVoucherByPhoneAndPrice" items="${listVoucherByPhoneAndPrice}">
					<option value="${listVoucherByPhoneAndPrice.voucherEntity.voucherCode}">${listVoucherByPhoneAndPrice.voucherEntity.description}</option>
				</c:forEach> 
		</select>
		<input type="submit" name="select" value="Chọn" />
	</form>
	<form action="/customer/add" method="post">
		<input type="hidden" id="customerEntity.phone" name="customerEntity.phone" value="${customerEntity.phone}"/><br>
		<label for="voucherEntity.voucherCode">Mã voucher</label>
		<input type="text" id="check" name="voucherEntity.voucherCode" value="${getVoucher.voucherEntity.voucherCode}" readonly/><br><br>
		<label for="price">Tổng tiền</label>
		<input type="text" name="price" value="${price}" readonly/>
		<br><br>
		<input type="submit" name="Confirm" value="Xác nhận" />
	</form>
</body>
</html>