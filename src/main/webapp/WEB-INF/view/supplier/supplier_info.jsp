<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<%@ include file="../../include/taglib.jsp"%>
<script src="${ctx}/assets/js/supplier/supplier_info.js"
	type="text/javascript"></script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeIn">
		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<ol class="breadcrumb">
					<li><a href="getSupplierList.htm">供应商信息列表</a></li>
					<li class="active"><c:if test="${ empty shopSupplierInfo.id}">新增</c:if> <c:if
							test="${!empty shopSupplierInfo.id}">编辑</c:if></li>
				</ol>
			</div>
			<div class="ibox-content">
				<div class="row">
					<div class="alert alert-info">
						请仔细填写供应商信息，后续的供应商展销平台会择优进行展示！一次合作，一生朋友！</div>
					<form class="form-horizontal m-t" id="supplierInfoForm">
						<input type="hidden" name="id" value="${shopSupplierInfo.id }" />
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label"><i class="red">*
								</i>名称：</label>
								<div class="col-sm-9">
									<input name="name" class="form-control" placeholder="请输入名称"
										type="text" value="${shopSupplierInfo.name }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label"><i class="red">*
								</i>联系方式：</label>
								<div class="col-sm-9">
									<input name="contactInformation" class="form-control"
										placeholder="例:[张三-13800000001]" type="text"
										value="${shopSupplierInfo.contactInformation }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label"><i class="red">*
								</i>地址：</label>
								<div class="col-sm-3">
									<input type="hidden" name="provinceName"
										value="${shopSupplierInfo.provinceName }" /> <select
										class="form-control" name="provinceId">
										<option value="">选择省</option>
										<c:forEach items="${allProvince }" var="province">
											<option value="${province.id }"
												<c:if test="${province.id==shopSupplierInfo.provinceId }">selected="selected"</c:if>>${province.name }</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-sm-3">
									<input type="hidden" name="cityName"
										value="${shopSupplierInfo.cityName }" /> <select
										class="form-control" name="cityId" onchange="selectCity()">
										<option value=''>选择市</option>
										<c:forEach items="${allCity }" var="city">
											<option value="${city.id }"
												<c:if test="${city.id==shopSupplierInfo.cityId }">selected="selected"</c:if>>${city.name }</option>
										</c:forEach>
									</select>
								</div>

								<div class="col-sm-3">
									<input type="hidden" name="districtName"
										value="${shopSupplierInfo.districtName }" /> <select
										class="form-control" name="districtId"
										onchange="selectDistrict()">
										<option value=''>选择区</option>
										<c:forEach items="${allDistrict }" var="district">
											<option value="${district.id }"
												<c:if test="${district.id==shopSupplierInfo.districtId }">selected="selected"</c:if>>${district.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label"><i class="red">*
								</i>服务星级：</label>
								<div class="col-sm-9">
									<select class="form-control" name="levelId">
										<c:forEach items="${levelList }" var="level">
											<option value="${level.id }"
												<c:if test="${level.id==shopSupplierInfo.levelId }">selected="selected"</c:if>>${level.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="-NaN" class="col-sm-3 control-label"><i
									class="red">* </i>所属类别：</label>
								<div class="col-sm-9">
									<select class="form-control" name="typeId">
										<c:forEach items="${supplierTypeList }" var="supplierType">
											<option value="${supplierType.id }"
												<c:if test="${supplierType.id==shopSupplierInfo.typeId }">selected="selected"</c:if>>${supplierType.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">网址：</label>
								<div class="col-sm-9">
									<input name="addressNet" class="form-control"
										placeholder="例:[http://www.baidu.com]" type="text"
										value="${shopSupplierInfo.addressNet }">

								</div>
							</div>

							<div class="form-group ui-sortable-helper">
								<label class="col-sm-3 control-label">详细地址：</label>
								<div class="col-sm-9">
									<input name="address" class="form-control"
										placeholder="例:[青龙街道1003号信息大厦302室]" type="text"
										value="${shopSupplierInfo.address }">

								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<div class="col-sm-12 col-sm-offset-5">
									<button class="btn btn-primary" type="submit">保存</button>
									<button class="btn btn-white" type="button"
										onclick="history.back(-1);">返回</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>