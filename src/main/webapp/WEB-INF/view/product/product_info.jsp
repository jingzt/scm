<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<%@ include file="../../include/taglib.jsp"%>
<script src="${ctx}/assets/js/plugins/artTemplate/template.js" type="text/javascript"></script>
<script src="${ctx}/assets/js/product/product_info.js"
	type="text/javascript"></script>
</head>
<body class="gray-bg">
	<%@ include file="/WEB-INF/view/product/template/product_material_realtion_template.jsp"%>
	<div class="wrapper wrapper-content animated fadeIn">
		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<ol class="breadcrumb">
					<li><a href="getProductList.htm">产品列表</a></li>
					<li class="active"><c:if test="${ empty productVO.product.id}">新增</c:if>
						<c:if test="${!empty productVO.product.id}">编辑</c:if></li>
				</ol>
			</div>
			<div class="ibox-content">
				<div class="row">
					<div class="alert alert-info">请仔细填写产品信息，这将对报表分析结果产生直接影响！点击保存后将会自动计算预算成本并将值赋予成本。如需修改成本请保存后到列表页修改！</div>
					<form class="form-horizontal m-t" id="productInfoForm">
						<input type="hidden" name="product.id" value="${productVO.product.id }" />
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label"><i class="red">*
								</i>产品名称：</label>
								<div class="col-sm-6">
									<input type="text" name="product.name"  class="form-control" value="${productVO.product.name}" placeholder="请输入产品名称">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="col-sm-3 control-label"><i class="red">*</i>售价：</label>
								<div class="col-sm-3">
									<input type="text" name="product.price" class="form-control" 
										value="<fmt:formatNumber value='${productVO.product.price}' type='currency' pattern='#.###' />" placeholder="请输入产品售价">
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<table class="table table-hover table-bordered">
								<thead>
									<tr>
										<th width="5%">序号</th>
										<th width="40%">材料名称</th>
										<th width="10%">材料单价(元)</th>
										<th width="10%">材料数量</th>
										<th width="10%">金额</th>
										<th width="5%"><a href="javascript:void(0)" onClick="addNewMaterial()" title="新增材料"><i class="glyphicon glyphicon-plus">新增</i></a></th>
									</tr>
								</thead>
								<tbody id="materialData">
									<c:forEach items="${productVO.realtionList}" var="realtion" varStatus="index">
										<tr>
											<td class="center">
												<input type="hidden" name="realtionList[${index.index}].id" value="${realtion.id}" /> 
												${index.count }
											</td>
											<td>
												<select name="realtionList[${index.index}].materialId" class="form-control" data-rule-required="true" onchange="selectMaterial(${index.index})">
													<c:forEach items="${materialList}" var="material">
														<option value="${material.id}" <c:if test="${material.id==realtion.materialId }">selected="selected"</c:if> >${material.name}</option>
													</c:forEach>
												</select>
											</td>
											<td>
												<input type="text" name="realtionList[${index.index}].materialUnitPrice" data-rule-required="true" data-rule-number="true" value="<fmt:formatNumber value='${realtion.materialUnitPrice}' type='currency' pattern='#.###' />" placeholder="单价" onfocus="makeTotalMoney(${index.index})" class="form-control"/>
											</td>
											<td>
												<input type="text" name="realtionList[${index.index}].materialTotalNum" data-rule-required="true" data-rule-number="true" value="<fmt:formatNumber value='${realtion.materialTotalNum}' type='currency' pattern='#.###' />" placeholder="数量" onfocus="makeTotalMoney(${index.index})" class="form-control"/>
											</td>
											<td>
												<input type="text" name="realtionList[${index.index}].materialTotalMoney" value="<fmt:formatNumber value='${realtion.materialTotalMoney}' type='currency' pattern='#.###' />" placeholder="金额自动计算" readonly="readonly" class="form-control"/>
											</td>
											<td class="center">
												<a class="remove" href="javascript:void(0)" onClick="delMaterial(this)" title="删除"><i class="glyphicon glyphicon-remove"></i></a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="col-md-12">
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<div class="col-sm-12 col-sm-offset-5">
									<button class="btn btn-primary" type="submit">保存</button>
									<a class="btn btn-white" href="getProductList.htm">返回</a>
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