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
<script src="${ctx}/assets/js/income/income_list.js" type="text/javascript"></script>
</head>
<body class="gray-bg">
	<%@ include file="/WEB-INF/view/income/template/income_product_template.jsp"%>
	<div class="wrapper wrapper-content animated fadeIn">
		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<ol class="breadcrumb">
					<li><a href="toIncomeCalendar.htm">销售汇总</a></li>
					<li class="active">销售详细列表</li>
				</ol>
			</div>
			<div class="ibox-content">
				<div class="row">
					<div class="alert alert-info">请仔细填写产品销售信息，这将对报表分析结果产生直接影响！</div>
					<form class="form-horizontal m-t" id="incomeInfoForm">
						<input type="hidden" name="date" value="${dateTime}" /> 
						<div class="col-md-12">
							<table class="table table-hover table-bordered">
								<thead>
									<tr>
										<th width="5%">序号</th>
										<th>产品名称</th>
										<th width="15%">消费方式</th>
										<th width="10%">销售单价(元)</th>
										<th width="10%">销售数量</th>
										<th width="10%">总金额</th>
										<th width="15%">备注</th>
										<th width="8%"><a href="javascript:void(0)" onClick="addNewIncome()" title="新增"><i class="glyphicon glyphicon-plus">新增</i></a></th>
									</tr>
								</thead>
								<tbody id="incomeData">
									<c:forEach items="${incomeInfoList}" var="income" varStatus="index">
										<tr>
											<td class="center">
												<input type="hidden" name="incomeList[${index.index}].id" value="${income.id}" /> 
												<input type="hidden" name="incomeList[${index.index}].createTime" value="${dateTime}" /> 
												${index.count }
											</td>
											<td>
												<select name="incomeList[${index.index}].productId" class="form-control" data-rule-required="true" onchange="selectProductId(${index.index})">
													<c:forEach items="${productList}" var="product">
														<option value="${product.id}" <c:if test="${product.id==income.productId}">selected="selected"</c:if> >${product.name}</option>
													</c:forEach>
												</select>
											</td>
											<td>
												<select name="incomeList[${index.index}].consumptionStyleId" class="form-control">
													<c:forEach items="${consumptionStyleList}" var="consumptionStyle">
														<option value="${consumptionStyle.id}" <c:if test="${consumptionStyle.id==income.consumptionStyleId}">selected="selected"</c:if> >${consumptionStyle.name}</option>
													</c:forEach>
												</select>
											</td>
											<td>
												<input type="text" name="incomeList[${index.index}].unitPrice" data-rule-required="true" data-rule-number="true" value="<fmt:formatNumber value='${income.unitPrice}' type='currency' pattern='#.###' />" placeholder="单价" onfocus="makeTotalMoney(${index.index})" class="form-control"/>
											</td>
											<td>
												<input type="text" name="incomeList[${index.index}].totalNum" data-rule-required="true" data-rule-number="true" value="<fmt:formatNumber value='${income.totalNum}' type='currency' pattern='#.###' />" placeholder="数量" onfocus="makeTotalMoney(${index.index})" class="form-control"/>
											</td>
											<td>
												<input type="text" name="incomeList[${index.index}].totalPrice" value="<fmt:formatNumber value='${income.totalPrice}' type='currency' pattern='#.###' />" placeholder="金额自动计算" readonly="readonly" class="form-control"/>
											</td>
											<td>
												<input type="text" name="incomeList[${index.index}].mark" value="${income.mark}" placeholder="备注" data-rule-maxlength="80" class="form-control"/>
											</td>
											<td class="center">
												<a class="remove" href="javascript:void(0)" onClick="delIncome(this)" title="删除"><i class="glyphicon glyphicon-remove"></i></a>
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
									<a class="btn btn-white" href="toIncomeCalendar.htm">返回</button>
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