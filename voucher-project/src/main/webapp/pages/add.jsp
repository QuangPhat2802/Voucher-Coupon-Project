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
	<form action="/customer/Add" method="post">
	<input type="text" id="phone" name="phone" value="${customerEntity.phone}" readonly />
	<h3>Nhap gia tri don hang</h3> 
		<input type="text"  id="minPrice"  name="minPrice" value="${minPrice}"/> <br><br>
		<select id="voucherCode" name="voucherCode" >
				<c:forEach var="list" items="${listVoucher}">
					<option value="${list.voucherCode}">${list.voucherCode}</option>
				</c:forEach> 
		</select>
		<br><br>
		<input type="submit" name="" value="add" />
	</form>
</body>
</html>