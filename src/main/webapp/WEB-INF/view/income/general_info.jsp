<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>运营概况</title>
<%@ include file="../../include/taglib.jsp"%>
<script src="${ctx}/assets/js/plugins/echarts/echarts.min.js"></script>
<script src="${ctx}/assets/js/income/general_info.js"></script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-3">
				<div class="widget style1 navy-bg">
					<div class="row">
						<div class="col-xs-4 text-center">
							<i class="fa fa-clock-o fa-5x"></i>
						</div>
						<div class="col-xs-8 text-right">
							<span> 当日收入 </span>
							<h2 class="font-bold">¥ <fmt:formatNumber value='${todayTotalInCome}' type='currency' pattern='#.###' /></h2>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="widget style1 lazur-bg">
					<div class="row">
						<div class="col-xs-4">
							<i class="fa fa-trophy fa-5x"></i>
						</div>
						<div class="col-xs-8 text-right">
							<span>当月收入</span>
							<h2 class="font-bold">¥ <fmt:formatNumber value='${monthTotalInCome}' type='currency' pattern='#.###' /></h2>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="widget style1 yellow-bg">
					<div class="row">
						<div class="col-xs-4">
							<i class="fa fa-cutlery fa-5x"></i>
						</div>
						<div class="col-xs-8 text-right">
							<span>当月支出</span>
							<h2 class="font-bold">¥ <fmt:formatNumber value='${monthTotalPurchase}' type='currency' pattern='#.###' /></h2>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="widget style1 lazur-bg">
					<div class="row">
						<div class="col-xs-4">
							<i class="fa fa-credit-card fa-5x"></i>
						</div>
						<div class="col-xs-8 text-right">
							<span>当月净利润 </span>
							<h2 class="font-bold">¥ <fmt:formatNumber value='${monthTotalInCome-monthTotalPurchase}' type='currency' pattern='#.###' /></h2>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
            <div class="col-sm-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-content">
                        <div id="bestSellers-chart" class="echarts"></div>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-content">
                    	 <div id="consumptionStyle-chart" class="echarts"></div>
                    </div>
                </div>
            </div>
        </div>
		<div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-content">
                    	<div id="nearYearSaleData-chart" class="echarts"></div>
                    </div>
                </div>
            </div>
         </div>
		
	</div>
</body>
</html>