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
	<form action="/KH/add" method="post">
	<input type="text" id="sdt" name="sdt" value="${khachHangEntity.sdt}" readonly />
	<h3>Nhap gia tri don hang</h3> 
		<input type="text"  id="minPrice"  name="minPrice" value="${minPrice}"/> <br><br>
		<select id="code" name="code" >
				<c:forEach var="list" items="${listVoucher}">
					<option value="${list.code}">${list.code}</option>
				</c:forEach> 
		</select>
		<br><br>
		<input type="submit" name="" value="add" />
	</form>
</body>
</html>