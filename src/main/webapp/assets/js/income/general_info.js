/**
 * 概况图表
 */

$(function() {
	// ---------------------------畅销产品TOP5-------------------------------
	var bestSellersChart = echarts.init(document.getElementById('bestSellers-chart'));
	$.getJSON('getBestSellersData.do').done(function(data) {
		bestSellersChart.setOption({
			title : {
				text : '当月畅销商品TOP5',
				x : 'center'
			},
			tooltip : {
				trigger : 'axis',
				axisPointer : { // 坐标轴指示器，坐标轴触发有效
					type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
				}
			},
			legend : {
				data : [ '销售金额' ],
				left : 'right'
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true
			},
			xAxis : [ {
				type : 'value'
			} ],
			yAxis : [ {
				type : 'category',
				data : data.category
			} ],
			series : [ {
				name : '销售金额',
				type : 'bar',
				stack : '总量',
				itemStyle : {
					normal : {
						label : {
							show : true,
							position : 'insideRight'
						}
					}
				},
				data : data.data
			} ]
		});
	});
	// ---------------------------消费方式-------------------------------
	var consumptionStyleChart = echarts.init(document.getElementById('consumptionStyle-chart'));
	$.getJSON('getConsumptionStyleData.do').done(function(data) {
		consumptionStyleChart.setOption({

			title : {
				text : '当月销售方式比例',
				x : 'center'
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				orient : 'vertical',
				left : 'right',
				data :data.vertical
			},
			series : [ {
				name : '访问来源',
				type : 'pie',
				radius : '55%',
				center : [ '50%', '60%' ],
				data :data.data ,
				itemStyle : {
					emphasis : {
						shadowBlur : 10,
						shadowOffsetX : 0,
						shadowColor : 'rgba(0, 0, 0, 0.5)'
					}
				}
			} ]
		});
	});
	
	// ---------------------------最近12个月销售情况概览-------------------------------
	var nearYearSaleDataChart = echarts.init(document.getElementById('nearYearSaleData-chart'));
	$.getJSON('getNearYearTotalData.do').done(function(data) {
		nearYearSaleDataChart.setOption({
			title : {
				text : '近12个月销售金额概览',
				x : 'center'
			},

		    tooltip : {
		        trigger: 'axis',
		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		        }
		    },
		    legend: {
		        data:['销售额','净利润'],
		        left : 'right'
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis : [
		        {
		            type : 'category',
		            data : data.category
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:'销售额',
		            type:'bar',
		            data:data.sales
		        },
		        {
		            name:'净利润',
		            type:'bar',
		            stack: '广告',
		            data:data.reals
		        }
		    ]
		});
	});

});