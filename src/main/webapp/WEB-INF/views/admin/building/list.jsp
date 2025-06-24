<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="buildingListURL" value="/admin/building-list"/>
<html>
<head>
    <title>Search</title>
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
                                       id="nav-search-input" autocomplete="off"/>
								<i class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
                </form>
            </div><!-- /.nav-search -->
        </div>

        <div class="page-content">
            <div class="page-header">
                <h1>
                    Search building
                    <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                        overview
                    </small>
                </h1>
            </div><!-- /.page-header -->

            <div class="row">
                <div class="col-xs-12">
                    <div class="widget-box ui-sortable-handle">
                        <div class="widget-header">
                            <h4 class="widget-title">Building</h4>

                            <div class="widget-toolbar">
                                <a href="#" data-action="collapse">
                                    <i class="ace-icon fa fa-chevron-up"></i>
                                </a>

                                <a href="#" data-action="close">
                                    <i class="ace-icon fa fa-times"></i>
                                </a>
                            </div>
                        </div>

                        <div class="widget-body"
                             style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
                            <div class="widget-main">
                                <form:form id="listform" method="GET" action="${buildingListURL}"
                                           modelAttribute="modelSearch">
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <div class="form-group">
                                                <div class="col-xs-12">
                                                    <div class="col-xs-6">
                                                        <label>Tên tòa nhà</label>
                                                        <form:input type="text" class="form-control" id="name"
                                                                    path="name"/>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        <label>Diện tích sàn</label>
                                                        <form:input path="floorArea" type="number" class="form-control"
                                                                    id="floorArea"/>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12">
                                                    <div class="col-xs-2">
                                                        <label>Quận hiện có</label>
                                                        <form:select path="district" id="district" class="form-control">
                                                            <form:option value="">--Quận hiện có--</form:option>
                                                            <form:options items="${districtType}"/>
                                                        </form:select>
                                                    </div>
                                                    <div class="col-xs-5">
                                                        <label>Phường</label>
                                                        <form:input path="ward" type="text" class="form-control"
                                                                    id="ward"/>
                                                    </div>
                                                    <div class="col-xs-5">
                                                        <label>Đường</label>
                                                        <form:input path="street" type="text" class="form-control"
                                                                    id="street"/>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12">
                                                    <div class="col-xs-4">
                                                        <label>Số tầng hầm</label>
                                                        <form:input path="numberOfBasement" type="number"
                                                                    class="form-control" id="numberOfBasement"/>
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <label>Tên quản lí</label>
                                                        <form:input path="managerName" type="text" class="form-control"
                                                                    id="managerName"/>
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <label>Só điện thoại</label>
                                                        <form:input path="managerPhone" type="text" class="form-control"
                                                                    id="managerPhone"/>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12">
                                                    <div class="col-xs-4">
                                                        <label>Hướng</label>
                                                        <form:input path="direction" type="number" class="form-control"
                                                                    id="direction"/>
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <label>Hạng</label>
                                                        <form:input path="level" type="text" class="form-control"
                                                                    id="level"/>
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <label>Chọn nhân viên phụ trách</label>
                                                        <form:select path="staffId" name="staff" id="staff"
                                                                     class="form-control">
                                                            <form:option value="">--Nhân viên hiện có--</form:option>
                                                            <form:options items="${staffList}"/>
                                                        </form:select>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12">
                                                    <div class="col-xs-3">
                                                        <label>Diện tích từ</label>
                                                        <form:input path="areaFrom" type="number" class="form-control"
                                                                    id="areaFrom"/>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <label>Diện tích đến</label>
                                                        <form:input path="areaTo" type="number" class="form-control"
                                                                    id="areaTo"/>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <label>Giá thuê từ</label>
                                                        <form:input path="rentPriceFrom" type="number"
                                                                    class="form-control" id="rentPriceFrom"/>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <label>Giá thuê đến</label>
                                                        <form:input path="rentPriceTo" type="number"
                                                                    class="form-control" id="rentPriceTo"/>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12">
                                                    <div class="col-xs-6">
                                                        <label class="inline">
                                                            <form:checkboxes path="typeCode" items="${typeCode}"/>
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col-xs-12">
                                                    <div class="col-xs-6">
                                                        <button class="btn btn-success" id="searchBuildng">Search
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form:form>

                            </div>
                        </div>
                    </div>

                    <div class="pull-right">
                        <a href="/admin/building-edit">
                            <button class="btn btn-info" title="Thêm tòa nhà">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-building-add" viewBox="0 0 16 16">
                                    <path
                                            d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0"/>
                                    <path
                                            d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                    <path
                                            d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                </svg>
                            </button>
                        </a>

                        <button class="btn btn-danger" title="Xoá tòa nhà" id="btnEraseBuilings">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-building-dash" viewBox="0 0 16 16">
                                <path
                                        d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"/>
                                <path
                                        d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                <path
                                        d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                            </svg>
                        </button>
                    </div>
                </div>
            </div>

            <div class="row" style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
                <div class="col-xs-12">
                    <table id="buildingList" style="margin: 3em 0 1.5em;"
                           class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th class="center">
                                <label class="pos-rel">
                                    <input type="checkbox" class="ace" name="checkList" value="">
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th>Tên tòa nhà</th>
                            <th>Địa chỉ</th>
                            <th>Só lượng tầng hầm</th>
                            <th>Tên quản lí</th>
                            <th>Số điện thoại</th>
                            <th>Diện tích sàn</th>
                            <th>Giá thuê</th>
                            <th>Thao tác</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="item" items="${buildingList}">
                            <tr>
                                <td class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace" name="checkList" value="${item.id}">
                                        <span class="lbl"></span>
                                    </label>
                                </td>
                                <td>${item.name}</td>
                                <td>${item.address}</td>
                                <td>${item.numberOfBasement}</td>
                                <td>${item.managerName}</td>
                                <td>${item.managerPhone}</td>
                                <td>${item.floorArea}</td>
                                <td>${item.rentArea}</td>

                                <td>
                                    <div class="hidden-sm hidden-xs btn-group">
                                        <button class="btn btn-xs btn-success" title="Giao tòa nhà"
                                                onclick="assignmentBuilding(${item.id})">
                                            <i class="ace-icon fa fa-check bigger-120"></i>
                                        </button>

                                        <button class="btn btn-xs btn-info" title="Sửa tòa nhà"
                                                onclick="location.href='/admin/building-edit-${item.id}'">
                                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                                        </button>

                                        <button class="btn btn-xs btn-danger" title="Xóa tòa nhà"
                                                onclick="deleteBuilding(${item.id})">
                                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                        </button>
                                    </div>

                                    <div class="hidden-md hidden-lg">
                                        <div class="inline pos-rel">
                                            <button class="btn btn-minier btn-primary dropdown-toggle"
                                                    data-toggle="dropdown" data-position="auto">
                                                <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                                            </button>

                                            <ul
                                                    class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                <li>
                                                    <a href="#" class="tooltip-info" data-rel="tooltip"
                                                       title="Giao tòa nhà"
                                                       data-original-title="Giao tòa nhà">
																<span class="blue">
																	<i
                                                                            class="ace-icon fa fa-search-plus bigger-120"></i>
																</span>
                                                    </a>
                                                </li>

                                                <li>
                                                    <a href="#" class="tooltip-success" data-rel="tooltip"
                                                       title="" data-original-title="Sửa toà nhà">
																<span class="green">
																	<i
                                                                            class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																</span>
                                                    </a>
                                                </li>

                                                <li>
                                                    <a href="#" class="tooltip-error" data-rel="tooltip"
                                                       title="" data-original-title="Xóa tòa nhà">
																<span class="red">
																	<i class="ace-icon fa fa-trash-o bigger-120"></i>
																</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div><!-- /.span -->
            </div>
        </div><!-- /.page-content -->
    </div>


</div>
<div class="modal" id="assignmentBuildingModal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Danh sách nhân viên</h5>
            </div>
            <div class="modal-body">
                <div class="row" style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
                    <div class="col-xs-12">
                        <table id="stafflist" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="center">Chọn</th>
                                <th>Tên nhân viên</th>
                            </tr>
                            </thead>

                            <tbody>
                            </tbody>
                        </table>
                        <input type="hidden" id="buildingId" name="buildingId" value="3487">
                    </div><!-- /.span -->
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                <button type="button" class="btn btn-primary" id="btnassignmentBuilding">Giao tòa nhà</button>
            </div>
        </div>
    </div>
</div>
<div class="modal" id="assignmentBuildingModal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Danh sách nhân viên</h5>
            </div>
            <div class="modal-body">
                <div class="row" style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
                    <div class="col-xs-12">
                        <table id="stafflist" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="center">Chọn</th>
                                <th>Tên nhân viên</th>
                            </tr>
                            </thead>

                            <tbody>
                            <tr>
                                <td class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace" value="1">
                                        <span class="lbl"></span>
                                    </label>
                                </td>
                                <td>Nguyễn Văn A</td>
                            </tr>
                            <tr>
                                <td class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace" value="2">
                                        <span class="lbl"></span>
                                    </label>
                                </td>
                                <td>Nguyễn Văn B</td>
                            </tr>
                            </tbody>
                        </table>
                        <input type="hidden" id="buildingId" name="buildingId" value="3487">
                    </div><!-- /.span -->
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                <button type="button" class="btn btn-primary" id="btnassignmentBuilding">Giao tòa nhà</button>
            </div>
        </div>
    </div>
</div>

<!--[if !IE]> -->
<script src="assets/js/jquery.2.1.1.min.js"></script>

<script>
    function assignmentBuilding(buidlingId) {
        $('#assignmentBuildingModal').modal();
        sendBuilding(buidlingId);
    }

        function sendBuilding(buidlingId) {
            $.ajax({
                type: "GET",
                url: "/admin/building/" + buidlingId + "/staff",
                dataType: "JSON",

                success: function (response) {
                    var row = '';
                    $.each(response.data, function(index, value){
                        row += '<tr>';
                        row += '<td class="text-center"><input type="checkbox" value=' + value.staffid + 'id="checkbox_' + value.staffid + value.checked + '/></td>';
                        row += '<td>' + value.fullName + '</td>';
                        row += '/<tr>';
                    });
                    $("#stafflist tbody").html(row);
                    console.log("Success");
                },
                error: function (response) {
                    console.log("Failed");
                    window.location.href = "/admin/building-list?message=error";
                    console.log(response);
                },
            })
        }


    $('#searchBuildng').click(function (e) {
        e.preventDefault();
        $('#listform').submit();
    })

    $('#btnassignmentBuilding').click(function (e) {
        e.preventDefault();
        var data = {};
        data['buildingId'] = $('#buildingId').val();
        var staffid = $('#stafflist').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['staffid'] = staffid;
        console.log("OK");
    })

    function deleteBuilding(id) {
        var buildingId = id;
        deleteBuildingById(buildingId);
    }

    $('#btnEraseBuilings').click(function (e) {
        e.preventDefault();
        var buildingIds = $('#buildingList').find('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        deleteBuildingById(buildingIds);
    })

    function deleteBuildingById(ids) {
        $.ajax({
            type: "DELETE",
            url: "/admin/building/" + ids,
            data: JSON.stringify(ids),
            contentType: "application/json",
            dataType: "JSON",

            success: function (respond) {
                console.log("Success");
            },
            error: function (respond) {
                console.log("Error");
            },
        })
    }
</script>
</body>
</html>
