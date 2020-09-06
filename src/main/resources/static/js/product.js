/**
 * 
 */

$(document).ready(function() {
	findProduct(1);
	
	
	$('.pagination').on('click','.page-link', function(){
		var pageNumber = $(this).attr("data-index");
		var keyword = $('.search-brand').val();
		var startPrice = ($('#priceFrom').val());
		var endPrice = ($('#priceTo').val());
		if( keyword != ""){
			search(keyword ,pageNumber, startPrice,endPrice);
		}else{
		findProduct(pageNumber);
		}
	});
	
	
	var $infoProductModal = $('#infoProductModal');
	var $productInfoForm  = $('#productInfoForm');
	
	
	// show add modal
	$('#addProduct').on('click', function() {
		resetForm($productInfoForm);
		showModalWithCustomizedTitle($infoProductModal , "Add Product");
		$('#logoImg img').attr('src' , '/images/image-demo.png');
		$('#productId').closest(".form-group").addClass("d-none");
	});
	
	// show update modal
	$('#productInfoTable').on('click','.edit-btn',  function() {
		// get product info
		$.ajax({
			url : "/product/api/findAll?id=" + $(this).data("id"),
			type : 'GET',
			dataType : 'json',
			contentType : 'application/json',
			success : function(responseData) {
				if(responseData.responseCode == 100){
					var productInfo = responseData.data;
					resetForm($productInfoForm);
					showModalWithCustomizedTitle($infoProductModal, "Edit-Product");
					
					$('#productId').val(productInfo.productId);
					$('#productName').val(productInfo.productName);
					$('#quantity').val(productInfo.quantity);
					$('#price').val(productInfo.price);
					$('#saleDate').val(productInfo.saleDate);
					$('#brandId').val(productInfo.brandEntity.brandId);
					$('#description').val(productInfo.description);	
					if(productInfo.image == null || productInfo.image == ""){
						productInfo.image = '/images/image-demo.png';
					}
					$("#logoImg img").attr("src", productInfo.image);
					$("#image").val(productInfo.image);
					$('#productId').closest(".form-group").removeClass("d-none");
				}
			}
		});
	});
	
	// add product
	$('#saveProduct').on('click', function(event) {
		
		event.preventDefault();
		var formData = new FormData($productInfoForm[0]);
		var productId = formData.get("productId");
		var isAdd = productId == undefined || productId == "";
		
		($productInfoForm).validate({
			ignone: [],
			 rules: {
				 	productName: {
				 		required: true,
				 		maxlength : 50
				 	},
				 	quantity : {
				 		required: true,
				 		number : true,
				 	},
				 	price : {
				 		required: true,
				 		number : true,
				 	},
				 	saleDate : {
				 		required: true,
				 	},
				    imageFiles: {
						required: isAdd,
					},
			 	},
			 	messages: {
					productName: {
						required: "Please input produt Name",
						maxlength: "The product Name must be less than 50 characters",
					},
					quantity : {
				 		required: "please input quantity",
				 		number : "Please enter a valid number.",
				 	},
				 	price : {
				 		required: "please input price",
				 		number : "Please enter a valid number.",
				 	},
				 	saleDate : {
				 		required: "please input saleDate",
				 	},
					imageFiles: {
						required: "Please upload product image",
					}
				}, 
				errorElement: "div",
				errorClass: "error-message-invalid"
				  
		});
		if($productInfoForm.valid()){
			$.ajax({
				url : "/product/api/" +(isAdd ? "add" : "update"),
				type : "POST",
				ectype : "multipart/form-data",
				processData : false,
				contentType : false,
				cache: false,
				timeout : 1000,
				data : formData,
				success : function(responseData) {
					if(responseData.responseCode == 100){
						$infoProductModal.modal('hide');
						findProduct(1);
						showNotification(true,responseData.responseMsg);
					}else{
						showMsgOnField($productInfoForm.find("#productName"),responseData.responseMsg);
					}
				}
			});
		}
	});
	
	
	// show delete modal
	$('#productInfoTable').on('click' , '.delete-btn', function() {
		$("#product-name").text($(this).data("name"));
		$("#deleteBtn").attr("data-id", $(this).data("id"));
		$('#deleteModal').modal('show');
	});
	// submit delete
	$('#deleteBtn').on('click', function() {
		$.ajax({
			url : "/product/api/delete/" + $(this).attr("data-id"),
			type : 'DELETE',
			dataType : 'json',
			contentType : 'application/json',
			success : function(responseData) {
				$('#deleteModal').modal('hide');
				showNotification(responseData.responseCode == 100, responseData.responseMsg);
				findProduct(1);
				
			}
		});
	});
	
	
	
	$('#searchPrice').on('click', function() {
		var keyword = $('.search-brand').val();
		var startPrice = ($('#priceFrom').val());
		var endPrice = ($('#priceTo').val());
		search(keyword,1,startPrice,endPrice);
	});
	
	
	
});


function search(keyword,pageNumber, startPrice, endPrice) {
	$.ajax({
		url : "/product/api/search/" +keyword +"/"+pageNumber + "/"+startPrice+"/"+endPrice,
		type : 'GET',
		dataType : 'json',
		contentType : 'application/json',
		success : function(responseData) {
			if (responseData.responseCode == 100) {
				renderTable(responseData.data.productList);
				renderPage(responseData.data.paginationInfo);
				if(pageNumber==1){
					showNotification(true, responseData.responseMsg);
				}
				
			}
		}
	});
}

function findProduct(pageNumber) {
	$.ajax({
		url : "/product/api/findAll/" + pageNumber,
		type : 'GET',
		contentType : "application/json", 
		success : function(responseData) {
			if(responseData.responseCode == 100){
				renderTable(responseData.data.productList);
				renderPage(responseData.data.paginationInfo);
			}
		}
	});
}



function renderTable(productList) {
	var rowHTML= "";
	$("#productInfoTable tbody").empty();
	$.each(productList, function(key, value) {
		rowHTML = "<tr>"
					+	"<td>" + value.productId + "</td>"
					+	"<td>" + value.productName + "</td>"
					+	"<td>" + value.quantity  +  "</td>"
					+	"<td>" + value.price     +  "</td>"
					+	"<td>" + value.saleDate  +  "</td>"
					+	"<td>" + value.brandEntity.brandName + "</td>"
					+	"<td class='text-center'><a href='" + value.image + "' data-toggle='lightbox' data-max-width='1000'><img class='img-fluid' src='" + value.image + "'></td>"
					+	"<td>" + value.description + "</td>"
					+	"<td class = 'action-btns'>"
					+			"<a class='edit-btn' data-id='" + value.productId +"'><i class='fas fa-edit'></i></a> | <a class='delete-btn' data-name='" + value.productName + "' data-id='" + value.productId + "'><i class='fas fa-trash-alt'></i></a>"		
					+	"</td>"
					"</tr>";
		$("#productInfoTable tbody").append(rowHTML);
	});	
}	

function renderPage(pagination){
	var paginationInnerHtml = "";
	if(pagination.pageNumberList.length > 0){
		$("ul.pagination").empty();
		paginationInnerHtml += '<li class="page-item"><a class="page-link' + (pagination.firstPage == 0 ? 'disabled' : '') + '" href="javascript:void(0)" data-index="'+ pagination.firstPage + '">Trang Đầu</a></li>'
		paginationInnerHtml += '<li class="page-item"><a class="page-link' + (pagination.previousPage == 0 ? 'disabled' : '') + '" href="javascript:void(0)" data-index="'+ pagination.previousPage + '"> < </a></li>'
		$.each(pagination.pageNumberList, function(key, value) {
			paginationInnerHtml += '<li class="page-item"><a class="page-link '+ (value == pagination.currentPage ? 'active' : '') +'" href="javascript:void(0)" data-index="' + value +'">' + value + '</a></li>';
		});
		paginationInnerHtml += '<li class="page-item"><a class="page-link ' + (pagination.nextPage == 0 ? 'disabled' : '') + '" href="javascript:void(0)" data-index="'+ pagination.nextPage + '"> > </a></li>'
		paginationInnerHtml += '<li class="page-item"><a class="page-link ' + (pagination.lastPage == 0 ? 'disabled' : '') + '" href="javascript:void(0)" data-index="'+ pagination.lastPage + '">Trang Cuối</a></li>'
		$("ul.pagination").append(paginationInnerHtml);
	}
}



