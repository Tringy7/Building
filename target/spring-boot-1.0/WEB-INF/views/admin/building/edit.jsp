<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@include file="/common/taglib.jsp" %>
        <html>

        <head>
            <title>Edit</title>
        </head>

        <body>
            <div class="main-content">
                <div class="main-content-inner">
                    <div class="breadcrumbs" id="breadcrumbs">
                        <script type="text/javascript">
                            try {
                                ace.settings.check('breadcrumbs', 'fixed')
                            } catch (e) {
                            }
                        </script>

                        <ul class="breadcrumb">
                            <li>
                                <i class="ace-icon fa fa-home home-icon"></i>
                                <a href="#">Home</a>
                            </li>
                            <li class="active">Dashboard</li>
                        </ul><!-- /.breadcrumb -->

                        <div class="nav-search" id="nav-search">
                            <form class="form-search">
                                <span class="input-icon">
                                    <input type="text" placeholder="Search ..." class="nav-search-input"
                                        id="nav-search-input" autocomplete="off" />
                                    <i class="ace-icon fa fa-search nav-search-icon"></i>
                                </span>
                            </form>
                        </div><!-- /.nav-search -->
                    </div>

                    <div class="page-content">
                        <div class="page-header">
                            <h1>
                                Edit building
                                <small>
                                    <i class="ace-icon fa fa-angle-double-right"></i>
                                    overview
                                </small>
                            </h1>
                        </div><!-- /.page-header -->

                        <div class="row" style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
                            <div class="col-xs-12">
                                <form class="form-horizontal" role="form" id="form-edit">
                                    <form:form id="buildingEdit" modelAttribute="buildingEdit" method="GET">
                                        <div class="form-group">
                                            <label class="col-xs-3">Tên tòa nhà</label>
                                            <div class="col-xs-9">
                                                <form:input path="name" class="form-control" type="text" id="name" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-3">Quận</label>
                                            <div class="col-xs-9">
                                                <form:select path="address" id="districtid" class="form-control">
                                                    <select:option value="">--Chọn quận--</select:option>
                                                    <select:option value="1">Quận 1</select:option>
                                                    <select:option value="2">Quận 2</select:option>
                                                    <select:option value="3">Quận 3</select:option>
                                                    <select:option value="4">Quận 4</select:option>
                                                </form:select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-3">Diện tích sàn</label>
                                            <div class="col-xs-9">
                                                <form:input path="floorArea" class="form-control" type="text"
                                                    id="floorarea" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-3">Phường</label>
                                            <div class="col-xs-9">
                                                <form:input path="ward" class="form-control" type="text" id="ward" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-3">Đường</label>
                                            <div class="col-xs-9">
                                                <form:input path="street" class="form-control" type="text"
                                                    id="street" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-3">Số tầng hầm</label>
                                            <div class="col-xs-9">
                                                <form:input path="numberOfBasement" class="form-control" type="text"
                                                    id="numberofbasement" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-3">Tên quản lí</label>
                                            <div class="col-xs-9">
                                                <form:input path="managerName" class="form-control" type="text"
                                                    id="managername" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-3">Số điện thoại</label>
                                            <div class="col-xs-9">
                                                <form:input path="managerPhone" class="form-control" type="text"
                                                    id="managerphone" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-3">Diện tích</label>
                                            <div class="col-xs-9">
                                                <form:input path="rentArea" class="form-control" type="text"
                                                    id="rentprice" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-3">Giá thuê</label>
                                            <div class="col-xs-9">
                                                <form:input path="rentPrice" class="form-control" type="text"
                                                    id="rentalarea" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-3">Loại tòa nhà</label>
                                            <div class="col-xs-9">
                                                <label class="checkbox-inline">
                                                    <form:checkbox path="typeCode" id="typecode" value="NOI_THAT" />Nội
                                                    thất
                                                </label>
                                                <label class="checkbox-inline">
                                                    <form:checkbox path="typeCode" id="typecode" value="NGUYEN_CAN" />
                                                    Nguyên căn
                                                </label>

                                                <label class="checkbox-inline">
                                                    <form:checkbox path="typeCode" id="typecode" value="TANG_TRET" />
                                                    Tầng
                                                    trệt
                                                </label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-3"></label>
                                            <div class="col-xs-9">
                                                <c:if test="${not empty buildingEdit.id}">
                                                    <button class="btn btn-info" id="btnassignmentBuilding">Thêm tòa
                                                        nhà</button>
                                                    <button class="btn btn-info">Hủy thao tác</button>
                                                </c:if>
                                                <c:if test="${empty buildingEdit.id}">
                                                    <button class="btn btn-info" id="btnassignmentBuilding">Sửa tòa
                                                        nhà</button>
                                                    <button class="btn btn-info">Hủy thao tác</button>
                                                </c:if>
                                            </div>
                                        </div>
                                    </form:form>
                                </form>
                            </div>
                        </div>
                    </div><!-- /.page-content -->
                </div>
            </div>
            <script>
                $('#btnassignmentBuilding').click(function () {
                    var data = {};
                    var typeCode = [];
                    var formData = $('#form-edit').serializeArray();
                    $.each(formData, function (i, v) {
                        if (v.name != 'typecode') {
                            data["" + v.name + ""] = v.value;
                        } else {
                            typeCode.push(v.value);
                        }
                    });
                    data['typecode'] = typeCode;
                    console.log("OK");
                    // call api
                    $.ajax({
                        type: "POST",
                        url: "http://localhost:8081/admin/building",
                        data: JSON.stringify(data),
                        contentType: "application/json",
                        dataType: "JSON",

                        success: function (respond) {
                            console.log("Success");
                        },
                        error: function (respond) {
                            console.log("Error");
                        },
                    })
                })
            </script>
        </body>

        </html>