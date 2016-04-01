<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<%@ include file="../../include/taglib.jsp"%>
<script src="${ctx}/assets/js/plugins/suggest/bootstrap-suggest.min.js"
	type="text/javascript"></script>
<script src="${ctx}/assets/js/purchase/purchase_list.js"
	type="text/javascript"></script>
<script type="text/javascript">
	var dateTime = '${dateTime}';
</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeIn">
		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<ol class="breadcrumb">
					<li><a href="toPurchaseCalendar.htm">统计汇总</a></li>
					<li class="active">${dateTime }采购详情</li>
				</ol>
			</div>
			<div class="ibox-content">
				<div class="row">
					<div class="col-sm-12">
						<div class="btn-group hidden-xs" id="purchaseInfoTableToolbar" role="group">
							<div class="input-group">
								<div class="col-md-4">
									<div class="form-group">
										<label class="col-sm-5 control-label">名称：</label>
										<div class="col-sm-7">
											<div class="input-group">
												<input id="materialId" class="form-control" type="hidden" />
												<input class="form-control" type="text" id="materialName"
													placeholder="可选择材料" />
												<div class="input-group-btn">
													<button type="button"
														class="btn btn-default dropdown-toggle"
														data-toggle="dropdown">
														<span class="caret"></span>
													</button>
													<ul class="dropdown-menu dropdown-menu-right" role="menu">
													</ul>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label class="col-sm-5 control-label">类别：</label>
										<div class="col-sm-7">
											<select class="form-control" id="materialTypeId">
												<option value="">全部</option>
												<c:forEach items="${materialTypeList}" var="materialType">
													<option value="${materialType.id }">${materialType.name }</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>

								<div class="col-md-4">
									<button type="button" class="btn btn-success"
										onclick="search()">
										<i class="fa fa-road"></i>&nbsp;搜索
									</button>
									<a type="button" class="btn btn-primary"
										onclick="addPurchaseInfo()">&nbsp;新增</a>
									<a class="btn btn-white" href="toPurchaseCalendar.htm">返回</a>
								</div>
							</div>
						</div>
						<table id="purchaseListTable" data-mobile-responsive="true">
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="addPurchaseInfo" style="display: none;overflow: hidden">
		<div class="row">
			<div class="col-sm-11">
				<form class="form-horizontal m-t" id="addPurchaseInfoForm">
					<input name="createTime" type="hidden"/>
					<div class="form-group">
						<label class="col-sm-3 control-label"><i class="red">*
						</i>名称：</label>
						<div class="col-sm-8">
							<div class="input-group">
								<input name="materialId" class="form-control" type="hidden" />
								<input class="form-control" type="text" id="addMaterialName"
									placeholder="请选择材料" />
								<div class="input-group-btn">
									<button type="button" class="btn btn-default dropdown-toggle"
										data-toggle="dropdown">
										<span class="caret"></span>
									</button>
									<ul class="dropdown-menu dropdown-menu-right" role="menu">
									</ul>
								</div>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label"><i class="red">*
						</i>单价：</label>
						<div class="col-sm-4">
							<input type="text" name="unitPrice" class="form-control"
								placeholder="元" />
						</div>
						<label class="col-sm-1 control-label">/</label>
						<div class="col-sm-3">
							<select class="form-control" name="unitId">
								<c:forEach items="${unitList }" var="unit">
									<option value="${unit.id }">${unit.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label"><i class="red">*
						</i>数量：</label>
						<div class="col-sm-8">
							<input name="totalNum" class="form-control" placeholder="请输入数量"
								type="text">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">金额：</label>
						<div class="col-sm-8">
							<input name="totalMoney" class="form-control" placeholder="数量只读"
								type="text" readonly="readonly">

						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">备注：</label>
						<div class="col-sm-8">
							<input name="mark" class="form-control" placeholder="请输入备注"
								type="text">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12 col-sm-offset-3">
							<button class="btn btn-primary" type="submit">提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

