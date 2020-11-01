<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:url var="buildingListURL" value="/admin/building-list"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Danh sách bài viết</title>
</head>
<body>
<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>
							<li class="active">Danh sách tòa nhà</li>
						</ul><!-- /.breadcrumb -->
					</div>

					<div class="page-content">

						<div class="row">
						<div class="col-sm-12">	
								<!-- PAGE CONTENT BEGINS -->
								
							<div class="widget-box">	
								<div class="widget-header">	
								<h4 class="widget-title">Tìm kiếm</h4>

									<div class="widget-toolbar">
										<a href="#" data-action="collapse">
											<i class="ace-icon fa fa-chevron-up"></i>
										</a>
									</div>
								</div>	
								
								<div class="widget-body">
								<div class="widget-main">
								<form:form commandName="modelSearch" action="buildingListURL" id="listForm" method="GET" class="form-horizontal">
								<div class="form-group mb">
								<div class="col-sm-6">
										<div>
											<label for="name" class="bold">Tên tòa nhà</label>
											<form:input path="name" cssClass="form-control" />
										</div>
									</div>
									<div class=" col-sm-6">
										<div>
											<label for="floorArea" class="bold">Diện tích sàn</label>
											<form:input type="number" path="floorArea" cssClass="form-control" />
										</div>
									
									</div>
								</div>
								<div class="form-group mb">
								<div class="col-sm-2">
										<div>
											<label for="district" class="bold">Quận hiện có</label>
											<form:select path="district" id="district">
												<form:option value="" label="-- Chọn quận--"/>
												<form:options items="${districts}"/>
										  </form:select>
										</div>
									</div>
									<div class=" col-sm-2">
									</div>
									<div class=" col-sm-4">
										<div>
											<label for="ward" class="bold">Phường</label>
											<form:input path="ward" cssClass="form-control" />
										</div>
									
									</div>
									<div class=" col-sm-4">
										<div>
											<label for="street" class="bold">Đường</label>
											<form:input path="street" cssClass="form-control" />
										</div>
									
									</div>
								</div>
								<div class="form-group mb">
								<div class="col-sm-4">
										<div>
											<label for="numberOfBasement" class="bold">Số tầng hầm</label>
											<form:input path="numberOfBasement" cssClass="form-control" />
										</div>
									</div>
									<div class=" col-sm-4">
										<div>
											<label for="direction" class="bold">Hướng</label>
											<form:input path="direction" cssClass="form-control" />
										</div>
									
									</div>
									<div class="col-sm-4">
										<div>
											<label for="level" class="bold">Hạng</label>
											<form:input path="level" cssClass="form-control" />
										</div>
									</div>
								</div>
								<div class="form-group mb">
								<div class="col-sm-3">
										<div>
											<label for="rentAreaFrom" class="bold">Diện tích từ</label>
											<form:input type="number" path="rentAreaFrom" cssClass="form-control" />
										</div>
									</div>
									<div class=" col-sm-3">
										<div>
											<label for="rentAreaTo" class="bold">Diện tích đến</label>
											<form:input type="number" path="rentAreaTo" cssClass="form-control" />
										</div>
									
									</div>
									<div class="col-sm-3">
										<div>
											<label for="rentPriceFrom" class="bold">Giá thuê từ</label>
											<form:input type="number" path="rentPriceFrom" cssClass="form-control" />
										</div>
									</div>
									<div class="col-sm-3">
										<div>
											<label for="rentPriceTo" class="bold">Giá thuê đến</label>
											<form:input type="number" path="rentPriceTo" cssClass="form-control" />
										</div>
									</div>
								</div>
								<div class="form-group mb">
								<div class="col-sm-4">
										<div>
											<label for="manager" class="bold">Tên quản lý</label>
											<form:input path="manager" cssClass="form-control" />
										</div>
									</div>
									<div class=" col-sm-4">
										<div>
											<label for="managerMobile" class="bold">Điện thoại quản lý</label>
											<form:input path="managerMobile" cssClass="form-control" />
										</div>
									
									</div>
									<div class="col-sm-3">
										<div>
											<label for="staffId" class="bold">Chọn nhân viên phụ trách</label>
										  <form:select path="staffId" >
												<form:option value="-1" label="-- Chọn nhân viên phụ trách--"/>
												<form:options items="${staff}"/>
										  </form:select>
										</div>
									</div>
								</div>
								<div class="form-group mb">
								<div class="col-sm-12">
									<form:checkboxes path="types" items=${buildingTypes}/>
									</div>
								</div>
								<div class="form-group mb">
								<div class="col-sm-12">
									<button type="button" class="btn btn-success">Tìm kiếm</button>
									</div>
								</div>
								</form:form>
								</div>
								</div>
							</div>	
							
							
								<!-- PAGE CONTENT ENDS -->
								</div>
						</div><!-- /.row -->
						<div class="row">
						<div class="col-xs-12">
						<div class="pull-right">
							<a href="building-edit.html" class="btn btn-white btn-info btn-bold" data-toggle="tooltip" title="Thêm tòa nhà">
							<i class="fa fa-plus-circle"></i>
							</a>
							<button class="btn btn-white btn-warning btn-bold" data-toggle="tooltip" title="Xóa tòa nhà">
							<i class="fa fa-trash" data-toggle="tooltip" title="Xóa tòa nhà" id="btnDeleteBuilding"></i>
							</button>
							</div>
						</div>
						</div>
						<br>
						<div class="row">
						<div class="col-xs-12">
							<table  class="table table-striped table-bordered table-hover" id="buildingList">
							<thead>
								<tr>
									<th  class="center"></th>
									<th  class="center">Ngày</th>
									<th  class="center">Tên sản phẩm</th>
									<th  class="center">Địa chỉ</th>
									<th  class="center">Tên quản lý</th>
									<th  class="center">Số điện thoại</th>
									<th  class="center">Diện tích sàn</th>
									<th  class="center">Giá thuê</th>
									<th  class="center">Phí dịch vụ</th>
									<th  class="center">Thao tác</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="item" items="${buildings}">
								<tr>
									<td class="center">                                 
										<label><input type="checkbox" value="${item.id}" id="checkbox_${item.id}"></label>
									</td>
									<td>${item.name}</td>
									<td>${item.street}</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td><a class="btn btn-xs btn-info" >
											<i class="fa fa-eye" data-toggle="tooltip" title="Xem chi tiết tòa nhà" ></i>
										</a>
										<a class="btn btn-xs btn-info" >
											<i class="fa fa-pencil-square-o" data-toggle="tooltip" title="Sửa chi tiết tòa nhà" ></i>
										</a>
									<button class="btn btn-xs btn-info" onclick="assignmentBuilding(1)">
											<i class="fa fa-bars" data-toggle="tooltip" title="Giao tòa nhà" ></i>
										</button>
									<button class="btn btn-xs btn-info">
											<i class="fa fa-plus" data-toggle="tooltip" title="Giao tòa nhà" ></i>
										</button></td>
								</tr>
							</c:forEach>	
							</tbody>
							</table>
							</div>	
						</div>
						
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->
					<div class="modal fade" id="assignmentBuildingModal" role="dialog">
			<div class="modal-dialog">
			<!-- Modal content-->
			  <div class="modal-content">
				<div class="modal-header">
				  <button type="button" class="close" data-dismiss="modal">&times;</button>
				  <h4 class="modal-title">Danh sách nhân viên</h4>
				</div>
				<div class="modal-body">
					<table id="staffList" class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th class="center">Chọn nhân viên</th>
								<th class="center">Tên nhân viên</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="center">                                 
									<label><input type="checkbox" value="2"></label>
								</td>
								<td class="center">Đặng Minh Chiến</td>							
							</tr>
							<tr>
								<td class="center">                                 
									<label><input type="checkbox" value="1"></label>
								</td>
								<td class="center">Người vô hình</td>							
							</tr>	
						</tbody>
						</table>
						<input type="hidden" id="buildingId" value="">
				</div>
				<div class="modal-footer">
				  <button type="button" class="btn btn-success"  id="btnAssignBuilding">Giao tòa nhà</button>
				  <button type="button" class="btn btn-default" data-dismiss="modal">Đóng lại</button>
				</div>
			  </div>
			  </div>
			  </div>
			  <script>
			assignmentBuilding=(buildingId)=>{
			  openModalAssignmentBuilding();
			  $('#buildingId').val(buildingId);
			}
			openModalAssignmentBuilding=()=>{
				$('#assignmentBuildingModal').modal();
			}
			$("#btnAssignBuilding").click(function (e) { 
				e.preventDefault();
				var data= {};
				data["buildingId"]=$('#buildingId').val();
				var staffs=$('#staffList').find('tbody input[type=checkbox]:checked').map(function(){
					return $(this).val();
				}).get();
				data['staff']=staffs;
				assignStaff(data);
			});
			function assignStaff(data){
				$.ajax({
					type: "POST",
					url: "url",
					data: JSON.stringify(data),
					dataType: "json",
					contentType:"application/json",
					success: function (response) {
						console.log("Hoàn thành")
					},
					error: function (response) {
						console.log("Lỗi")
					}
				});
			}
			$("#btnDeleteBuilding").click(function (e) { 
				e.preventDefault();
				var data={};
				var buildingIds=$('#buildingList').find('tbody input[type=checkbox]:checked').map(function(){
					return $(this).val();
				}).get();
				data['buildingIds']=buildingIds;
				deleteBuilding(data);
			});
			function deleteBuilding(data){
				$.ajax({
					type: "DELETE",
					url: "url",
					data: JSON.stringify(data),
					dataType: "json",
					contentType:"application/json",
					success: function (response) {
						console.log("Hoàn thành")
					},
					error: function (response) {
						console.log("Lỗi")
					}
				});
			}
		</script>
</body>
</html>