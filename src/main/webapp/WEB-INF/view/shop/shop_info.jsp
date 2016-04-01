<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<%@ include file="../../include/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/assets/css/plugins/webuploader/webuploader.css">
<script src="${ctx}/assets/js/plugins/webuploader/webuploader.min.js" type="text/javascript"></script>
<script src="${ctx}/assets/js/shop/shop_upload.js" type="text/javascript"></script>
<script src="${ctx}/assets/js/shop/shop_info.js" type="text/javascript"></script>

</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeIn">
		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<!-- 2选1 开始 -->
					<!-- 多级开始  -->
					<ol class="breadcrumb">
						<li><a href="index.htm">基本信息</a></li>
						<li class="active">编辑店铺信息</li>
					</ol>
					<!-- 多级结束 -->
				<!-- 2选1 结束 -->
			</div>
			<div class="ibox-content">
				<div class="row">
					<!-- 下方的提示行酌情使用  开始 -->
					<div class="alert alert-info"> 请仔细填写店铺信息!后续业务逻辑将会紧紧围绕店铺信息展开,包含免费店铺信息推广、店铺奖励等等！填写越详细，被推广的几率越高哦~</div>
					<!-- 提示行结束 -->
					<form class="form-horizontal m-t" id="shopInfoForm">
						<input type="hidden" name="id" value="${shop.id}" />
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label"><i class="red">*
								</i>店铺名称：</label>
								<div class="col-sm-9">
									<input name="name" class="form-control" placeholder="请输入店铺名称" type="text" value="${shop.name}">
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label"><i class="red">*
								</i>经营类别：</label>
								<div class="col-sm-9">
									<select class="form-control" name="categoryId">
										<c:forEach items="${shopTypeList }" var="shopType">
											<option value="${shopType.id }"
												<c:if test="${shopType.id==shop.categoryId }">selected="selected"</c:if>>${shopType.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label"><i class="red">*
								</i>联系方式：</label>
								<div class="col-sm-9">
									<input name="contactInformation" class="form-control"
										placeholder="例:[张三-13800000001]" type="text" value="${shop.contactInformation }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label"><i class="red">*
								</i>地址：</label>
								<div class="col-sm-3">
									<input type="hidden" name="provinceName" value="${shop.provinceName }" />
									<select class="form-control" name="provinceId">
										<option value=''>选择省</option>
										<c:forEach items="${allProvince }" var="province">
										<option value="${province.id }" <c:if test="${province.id==shop.provinceId }">selected="selected"</c:if>>${province.name }</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-sm-3">
									<input type="hidden" name="cityName" value="${shop.cityName }" />
									<select class="form-control" name="cityId">
										<option value=''>选择市</option>
										<c:forEach items="${allCity }" var="city">
										<option value="${city.id }" <c:if test="${city.id==shop.cityId }">selected="selected"</c:if>>${city.name }</option>
										</c:forEach>
									</select>
								</div>

								<div class="col-sm-3">
									<input type="hidden" name="districtName" value="${shop.districtName }" />
									<select class="form-control" name="districtId">
										<option value=''>选择区</option>
										<c:forEach items="${allDistrict }" var="district">
											<option value="${district.id }" <c:if test="${district.id==shop.districtId }">selected="selected"</c:if>>${district.name }</option>
										</c:forEach>
									</select>
								</div>
							</div><div class="form-group">
								<label class="col-sm-3 control-label">店铺logo：</label>
								<div class="col-sm-6">
									<input name="logoPath" type="hidden" value="${shop.logoPath }" >
									<div id="uploader-demo">
										 <!--用来存放item-->
										 <div id="fileList" class="uploader-list">
										 	<div id="no_image" class="file-item thumbnail">
										 		 <img src="<c:if test="${empty shop.logoPath }">${ctx}/assets/img/profile_small.jpg</c:if><c:if test="${!empty shop.logoPath }">${ctx}/${shop.logoPath}</c:if>" style="width: 100px; height: 100px">
										 	</div>
										 </div>
										
										 
									</div>
								 </div>
								 <div class="col-sm-3">
									 <div id="filePicker">选择图片</div>
									 <div id="upInfo"></div>
								 </div>
							</div>
							
							
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label"><i class="red">*
								</i>法人：</label>
								<div class="col-sm-9">
									<input name="legalPersonName" class="form-control" placeholder="请输入法人"
										type="text" value="${shop.legalPersonName}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label"><i class="red">*
								</i>经营方式：</label>
								<div class="col-sm-9">
									<select class="form-control" name="typeId">
										<c:forEach items="${businessTypeList }" var="businessType">
											<option value="${businessType.id }"
												<c:if test="${businessType.id==shop.typeId }">selected="selected"</c:if>>${businessType.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label"><i class="red">*
								</i>邮箱：</label>
								<div class="col-sm-9">
									<input name="email" class="form-control" placeholder="请输入邮箱"
										type="text" value="${shop.email}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label"><i class="red">*
								</i>特色：</label>
								<div class="col-sm-9">
									<input name="features" class="form-control" placeholder="请输入特色描述" type="text" value="${shop.features}" onkeypress="toLength(this,90)"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label"><i class="red">*
								</i>简介：</label>
								<div class="col-sm-9">
									<textarea class="form-control" name="introduction" rows="" cols="" onkeypress="toLength(this,2000)" >${shop.introduction}</textarea>
								</div>
							</div>
							
						</div>
						<div class="col-md-12">
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<div class="col-sm-12 col-sm-offset-5">
									<button class="btn btn-primary" type="submit">保存</button>
									<a class="btn btn-white" href="index.htm">返回</a>
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