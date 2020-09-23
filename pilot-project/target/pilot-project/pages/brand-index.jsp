<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>Brand Management</title>
<jsp:include page="../common/head.jsp" />
<link rel="stylesheet" href="<c:url value='/css/brand.css'/>">
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div class="container">
		<div class="sub-header">
			<div class="float-left sub-title">Brand Management</div>
			<div class="float-right"><a class="btn btn-success add-btn" href="/brand/add"><i class="fas fa-plus-square"></i> Add Brand</a></div>
		</div>
		<table class="table table-bordered" id="brandInfoTable">
			<thead>
				<tr class="text-center">
					<th scope="col">#</th>
					<th scope="col">Name</th>
					<th scope="col">Logo</th>
					<th scope="col">Description</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="brand" items="${brandsList}">
					<tr>
						<td>${brand.brandId}</td>
						<td>${brand.brandName}</td>
						<td class="text-center"><img src="${brand.logo}"></td>
						<td>${brand.description}</td>
						<td class="action-btns" data-id="${brand.brandId}"><a class="edit-btn" href="/brand/update?id=${brand.brandId}"><i class="fas fa-edit"></i></a> | <a class="delete-btn" href="/brand/delete?id=${brand.brandId}"><i class="fas fa-trash-alt"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- Modal Confirm Deleting Brand -->
	<div class="modal fade" id="confirmDeleteModal" >
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Delete Brand</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>Do you want to delete <b class="brand-name"></b>?</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
					<button type="button" class="btn btn-primary" id="deleteSubmitBtn">Save</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>