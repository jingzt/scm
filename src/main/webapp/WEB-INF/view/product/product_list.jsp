<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<%@ include file="../../include/taglib.jsp"%>
<script src="${ctx}/assets/js/product/product_list.js" type="text/javascript"></script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeIn">
		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<ol class="breadcrumb">
					<li class="active">产品列表</li>
				</ol>
			</div>
			<div class="ibox-content">
				<div class="row">
					<div class="col-md-12">
						<div class="btn-group hidden-xs" id="productInfoTableToolbar"
							role="group">
							<div class="input-group">
								<div class="col-md-5">
									<div class="form-group">
										<label class="col-sm-5 control-label">名称：</label>
										<div class="col-sm-7">
											<input name="name" class="form-control" type="text" />
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label class="col-sm-5 control-label">状态：</label>
										<div class="col-sm-7">
											<select class="form-control" name="state">
													<option value="">全部</option>
													<option value="1">正常</option>
													<option value="2">停用</option>
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
										href="${ctx}/product/toAddProductInfo.htm">&nbsp;新增</a>
								</div>
							</div>
						</div>

						<table id="productListTable" data-mobile-responsive="true">
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

