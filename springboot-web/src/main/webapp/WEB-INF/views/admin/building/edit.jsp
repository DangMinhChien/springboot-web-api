<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sửa tòa nhà</title>
</head>
<body>
<div class="main-content">
            <div class="main-content-inner">
                <div class="breadcrumbs" id="breadcrumbs">
                    <script type="text/javascript">
                        try {
                            ace.settings.check('breadcrumbs', 'fixed')
                        } catch (e) {}
                    </script>

                    <ul class="breadcrumb">
                        <li>
                            <i class="ace-icon fa fa-home home-icon"></i>
                            <a href="#">Home</a>
                        </li>
                        <li class="active">Dashboard</li>
                    </ul><!-- /.breadcrumb -->
                </div>

                <div class="page-content">

                    <div class="row">
                        <div class="col-sm-12">
                            <!-- PAGE CONTENT BEGINS -->

                            <form class="form-horizontal" role="form" id="formEdit">
                                <div class="form-group row">
                                    <label for="name" class="col-sm-2 col-form-label">Tên tòa nhà</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="name"  name="name" placeholder="Tên tòa nhà">
                                    </div>
                                  </div>
                                <div class="form-group row">
                                    <label for="managerName" class="col-sm-2 col-form-label">Người quản lý</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="managerName"   name="managerName" placeholder="Người quản lý">
                                    </div>
                                  </div>
                                <div class="form-group row">
                                    <label for="district" class="col-sm-2 col-form-label">Quận</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="district"  name="district" placeholder="Quận">
                                    </div>
                                  </div>
                                <div class="form-group row">
                                    <label for="ward" class="col-sm-2 col-form-label">Phường</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="ward" name="ward" placeholder="Phường">
                                    </div>
                                  </div>
                                <div class="form-group row">
                                    <label for="street" class="col-sm-2 col-form-label">Đường</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="street"  name="street"placeholder="Đường">
                                    </div>
                                  </div>
                                <div class="form-group row">
                                    <label for="structure" class="col-sm-2 col-form-label">Kết cấu</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="structure" name="structure" placeholder="Kết cấu">
                                    </div>
                                  </div>
                                <div class="form-group row">
                                    <label for="numberOfBasement" class="col-sm-2 col-form-label">Số tầng hầm</label>
                                    <div class="col-sm-10">
                                      <input type="number" class="form-control" id="numberOfBasement"  name="numberOfBasement" placeholder="Số tầng hầm">
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <label for="areaRent" class="col-sm-2 col-form-label">Diện tích sàn</label>
                                    <div class="col-sm-10">
                                      <input type="number" class="form-control" id="areaRent" name="areaRent" placeholder="Diện tích sàn">
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <label for="direction" class="col-sm-2 col-form-label">Hướng</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="direction" name="direction" placeholder="Hướng">
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <label for="rank" class="col-sm-2 col-form-label">Hạng</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="rank" name="rank" placeholder="Hạng">
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <label for="areaRentTo" class="col-sm-2 col-form-label">Diện tích thuê</label>
                                    <div class="col-sm-10">
                                      <input type="number" class="form-control" id="areaRentTo" name="areaRentTo" placeholder="Diện tích thuê">
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <label for="rentDescription" class="col-sm-2 col-form-label">Mô tả diện tích</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="rentDescription" name="rentDescription" placeholder="Mô tả diện tích">
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <label for="rentCost" class="col-sm-2 col-form-label">Giá thuê</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="rentCost" name="rentCost" placeholder="Giá thuê">
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <label for="costService" class="col-sm-2 col-form-label">Phí dịch vụ</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="costService" name="costService" placeholder="Phí dịch vụ">
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <label for="carCost" class="col-sm-2 col-form-label">Phí ô tô</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="carCost"  name="carCost" placeholder="Phí ô tô">
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <label for="motorbikeCost" class="col-sm-2 col-form-label">Phí mô tô</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="motorbikeCost"  name="motorbikeCost" placeholder="Mô tả diện tích">
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <label for="overtimeCost" class="col-sm-2 col-form-label">Phí ngoài giờ</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="overtimeCost" name="overtimeCost" placeholder="Phí ngoài giờ">
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <label for="electricCityCost" class="col-sm-2 col-form-label">Tiền điện</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="electricCityCost" name="electricCityCost" placeholder="Tiền điện">
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <label for="deposit" class="col-sm-2 col-form-label">Tiền đặt  cọc</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="deposit" name="deposit" placeholder="Tiền đặt cọc">
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <label for="payment" class="col-sm-2 col-form-label">Thanh toán</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="payment"  name="payment"placeholder="Thanh toán">
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <label for="timeRent" class="col-sm-2 col-form-label">Thời hạn thuê</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="timeRent"  name="timeRent" placeholder="Thời hạn thuê">
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <label for="timeDecorator" class="col-sm-2 col-form-label">Thời gian trang trí</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="timeDecorator"  name="timeDecorator"placeholder="Thời gian trang trí">
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <label for="costAgency" class="col-sm-2 col-form-label">Phí môi giới</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="costAgency"  name="costAgency"  placeholder="Phí môi giới">
                                    </div>
                                  </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Loại sản phẩm</label>
                                    <div class="col-sm-10">
                                        <div class="checkbox">
                                            <label><input type="checkbox" value="TANG_TRET" id="buildingTypes" name="buildingTypes">Tầng trệt</label>
                                          </div>
                                          <div class="checkbox">
                                            <label><input type="checkbox" value="NGUYEN_CAN" id="buildingTypes" name="buildingTypes">Nguyên căn</label>
                                          </div>
                                          <div class="checkbox ">
                                            <label><input type="checkbox" value="NOI_THAT" id="buildingTypes" name="buildingTypes">Nội thất</label>
                                          </div>
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <label for="note" class="col-sm-2 col-form-label">Ghi chú</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="note" placeholder="Ghi chú" name="note">
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <label for="link" class="col-sm-2 col-form-label">Link sản phẩm</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="link" name="link" placeholder="Link sản phẩm">
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <label for="map" class="col-sm-2 col-form-label">Bản đồ</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="map" name="map"  placeholder="Bản đồ">
                                    </div>
                                  </div>
                                  <div class="form-group row">
                                    <label for="avatar" class="col-sm-2 col-form-label">Hình đại diện</label>
                                    <div class="col-sm-10">
                                        <div class="">
                                            <input type="file" class="custom-file-input" id="avatar" name="avatar">
                                          </div>
                                    </div>
                                  </div>
                                  <div class="col-sm-12 ">
                                      <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/1024px-No_image_available.svg.png "  class=" img-fluid center-block img-responsive" width="200px" height="200px">
                                </div>
                                <div class="form-group row">
                                    <div class="pull-right">
                                        <button type="button" class="btn btn-warning" id="btnAddBuilding">Cập nhật người dùng</button>
                                  </div>
                                </div>
                            </form>

                            <!-- PAGE CONTENT ENDS -->
                        </div>
                    </div><!-- /.row -->
                </div><!-- /.page-content -->
            </div>
        </div><!-- /.main-content -->
          <script>
                
                $("#btnAddBuilding").click(function (e) { 
                    e.preventDefault();
                    var data ={};
                    var buildingTypes =[];
                    var formData= $("#formEdit").serializeArray();
                    $.each(formData,function (index,v) {
                        if (v.name== 'buildingTypes') {
                            buildingTypes.push(v.value);
                        } else {
                            data[""+v.name+""]=v.value;
                        }
                    })
                    data["buildingTypes"]=buildingTypes;
                    console.log(data);
                    $.ajax({
                        type: "POST",
                        url: "url",
                        data: JSON.stringify(data),
                        dataType: "json",
                        contentType:"application/json",
                        success: function (response) {
                            console.log("Thành công");
                            window.loading();
                        },
                        error: function (response) {
                            console.log("Failed");
                        }
                    });
                });
            </script>
</body>
</html>