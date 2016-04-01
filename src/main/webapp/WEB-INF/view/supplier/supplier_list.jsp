<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<%@ include file="../../include/taglib.jsp"%>
<script src="${ctx}/assets/js/supplier/supplier_list.js" type="text/javascript"></script>

</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeIn">
		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<ol class="breadcrumb">
					<li class="active">供应商信息列表</li>
				</ol>
			</div>
			<div class="ibox-content">
				<div class="row">
					<div class="col-sm-12">
						<div class="btn-group hidden-xs" id="supplierInfoTableToolbar" role="group">
							<div class="input-group">
								<div class="col-md-3">
									<div class="form-group">
										<label class="col-sm-5 control-label">名称：</label>
										<div class="col-sm-7">
											<input name="name" class="form-control" type="text" />
										</div>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label class="col-sm-5 control-label">类别：</label>
										<div class="col-sm-7">
											<select class="form-control" name="typeId">
												<option value="">全部</option>
												<c:forEach items="${supplierTypeList}" var="supplierType">
													<option value="${supplierType.id }">${supplierType.name }</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label class="col-sm-5 control-label">评级：</label>
										<div class="col-sm-7">
											<select class="form-control" name="levelId">
												<option value="">全部</option>
												<c:forEach items="${levelList}" var="level">
													<option value="${level.id }">${level.name }</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>

								<div class="col-md-3">
									<button type="button" class="btn btn-success"
										onclick="search()">
										<i class="fa fa-road"></i>&nbsp;搜索
									</button>
									<a type="button" class="btn btn-primary"
										href="${ctx}/supplier/toAddSupplierInfo.htm">&nbsp;新增</a>
								</div>
							</div>
						</div>

						<table id="supplierListTable" data-mobile-responsive="true">
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

