<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<%@ include file="../../include/taglib.jsp"%>
<link href="${ctx}/assets/css/plugins/fullcalendar/fullcalendar.css" rel="stylesheet" />
<link href="${ctx}/assets/css/plugins/fullcalendar/fullcalendar.print.css" rel="stylesheet" />
<script src="${ctx}/assets/js/plugins/fullcalendar/fullcalendar.min.js"
	type="text/javascript"></script>
<script src="${ctx}/assets/js/purchase/purchase_calendar.js"
	type="text/javascript"></script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeIn">
		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<ol class="breadcrumb">
					<li class="active">采购汇总</li>
				</ol>
			</div>
			<div class="ibox-content">
				<div class="alert alert-info">说明：点击日期表格可以查看、编辑采购详情。</div>
				 <div id="purchaseCalendar"></div>
			</div>
		</div>
	</div>

</body>
</html>