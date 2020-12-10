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
	
	<form action="/admin/sdt" method="post">

		<input type="text" id="code" name="code" value="${code.code}"  disable/><br><br>
		<input type="text" id="name" name="name" value="${code.name}" readonly/><br><br>
		<input type="text" id="description" name="description" value="${code.description}" readonly/><br><br>
		<input type="text" id="quantity" name="quantity" value="${code.quantity}" readonly/><br><br>
		<input type="text" id="discount" name="discount" value="${code.discount}" readonly/><br><br>
		<input type="text" id="minPrice" name="minPrice" value="${code.minPrice}" readonly/><br><br>
		<input type="text" id="startDate" name="startDate" value="${code.startDate}" readonly/><br><br>
		<input type="text" id="endDate" name="endDate" value="${code.endDate}" readonly/><br><br>
		<input type="text" id="status" name="status" value="${code.status}" readonly/><br><br>
		<input type="text" id="khachHangEntity.sdt" name="khachHangEntity.sdt" />
		<input type="submit" value="add"/>
	</form>
</body>
</html>