/**
 * 采购管理性情列表
 */
var pageIndex;
$(function() {
	loadPurchaseList();
	$("#materialName").bsSuggest({
		url : "../material/getSelectData.do?name=",
		showBtn : false,
		idField:"id",
		keyField : "name",
		processData : processData,
		effectiveFields : [ "name" ]
	}).on("onSetSelectValue", function(e, keyword) {
	    console.log('onSetSelectValue: ', keyword);
		$("#materialId").val(keyword.id);
	}).on('onUnsetSelectValue', function(e) {
		$("#materialId").val('');
	});

	$("#addMaterialName").bsSuggest({
		url : "../material/getSelectData.do?name=",
		showBtn : false,
		idField:"id",
		keyField : "name",
		processData : processData,
		effectiveFields : [ "name","unitPrice" ],
		effectiveFieldsAlias:{name: "名称",unitPrice:"单价"}, 
		listAlign: "center" 
	}).on("onSetSelectValue", function(e, keyword,data) {
		 console.log('onSetSelectValue: ', keyword,data);
		$("input[name='materialId']").val(keyword.id);
		$("input[name='unitPrice']").val(data.unitPrice);
		$("select[name='unitId']").val(data.unitId);
		
	}).on('onUnsetSelectValue', function(e) {
		$("input[name='materialId']").val('');
	});

	$("input[name='unitPrice']").on("input", function() {
		var unitPrice = $("input[name='unitPrice']").val();
		var totalNum = $("input[name='totalNum']").val();
		$("input[name='totalMoney']").val(Number(unitPrice)*Number(totalNum).toFixed(3));
	});
	$("input[name='totalNum']").on("input", function() {
		var unitPrice = $("input[name='unitPrice']").val();
		var totalNum = $("input[name='totalNum']").val();
		$("input[name='totalMoney']").val(Number(unitPrice)*Number(totalNum).toFixed(3));
	});

	$("#addPurchaseInfoForm").validate({
		ignore : "", // 开启hidden验证,1.9版本后默认关闭
		rules : {
			'materialId' : {
				required : true
			},
			'unitPrice' : {
				required : true,
				number : true,
				max:10000
			},
			'totalNum' : {
				required : true,
				number : true,
				max:10000
			},
			'totalMoney' : {
				required : true,
				number : true
			},
			'mark' : {
				maxlength : 80
			}
		},
		submitHandler : function(form) {
			var options = {
				url : "savePurchaseInfo.do",
				type : "post",
				dataType : "json",
				success : function(data) {
					if (data.success) {
						$.success('操作成功', function() {
							layer.close(pageIndex);
							$('#purchaseListTable').bootstrapTable('refresh');
						});
					} else {
						$.error(data.msg);
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					$.warn('服务忙,请稍后再试.');
				}
			};
			$(form).ajaxSubmit(options);
		},
		invalidHandler : function(form, validator) {
			return false;
		}

	});
})
function processData(value) {
	return eval(value);
}
function loadPurchaseList() {
	$('#purchaseListTable')
			.bootstrapTable(
					{
						method : 'post',
						url : "getPurchaseListData.do?createTime=" + dateTime,
						height : $(window).height() - 100,
						striped : true,
						minimumCountColumns : 2,
						smartDisplay : true,
						toolbar : "#purchaseInfoTableToolbar",
						pagination : true,
						sidePagination : "server",
						pageNumber : 1,
						pageSize : 5,
						pageList : [ 5, 10, 20 ],
						queryParamsType : "limit",
						contentType : "application/x-www-form-urlencoded",
						columns : [
								{
									field : 'id',
									title : 'ID',
									visible : false
								},
								{
									title : '序号',
									align : 'center',
									width : '10',
									formatter : serilNumFormatter
								},
								{
									field : 'name',
									title : '名称',
									align : 'center',
									width : '100'
								},
								{
									field : 'typeName',
									title : '类别',
									align : 'center',
									width : '10'
								},
								{
									field : 'unitPrice',
									title : '单价(元)',
									align : 'center',
									width : '30',
									editable : {
										type : 'text',
										title : '修改单价',
										validate : function(value) {
											var data = $('#purchaseListTable')
													.bootstrapTable('getData'), index = $(
													this).parents('tr').data(
													'index');
											value = $.trim(value);
											if (!value) {
												return '该项必填';
											}
											if (!(/^[0-9]+(.[0-9]{1,3})?$/g
													.test(value))) {
												return '必须为数字且最多保留三位小数';
											}
											var info = '';

											$.post("updatePurchaseInfo.do", {
												id : data[index].id,
												unitPrice : value
											}, function(data) {
												if (!data.success) {
													info = data.msg;
												} else {
													$('#purchaseListTable')
															.bootstrapTable(
																	'refresh');
												}
											}, "json");
											return info;
										}
									}
								},
								{
									field : 'unitName',
									title : '单位',
									align : 'center',
									width : '30'
								},
								{
									field : 'totalNum',
									title : '数量',
									align : 'center',
									width : '10',
									editable : {
										type : 'text',
										title : '修改数量',
										validate : function(value) {
											var data = $('#purchaseListTable')
													.bootstrapTable('getData'), index = $(
													this).parents('tr').data(
													'index');
											value = $.trim(value);
											if (!value) {
												return '该项必填';
											}
											if (!(/^[0-9]+(.[0-9]{1,3})?$/g
													.test(value))) {
												return '必须为数字且最多保留三位小数';
											}
											var info = '';

											$.post("updatePurchaseInfo.do", {
												id : data[index].id,
												totalNum : value
											}, function(data) {
												if (!data.success) {
													info = data.msg;
												} else {
													$('#purchaseListTable')
															.bootstrapTable(
																	'refresh');
												}
											}, "json");
											return info;
										}
									}
								},
								{
									field : 'totalMoney',
									title : '金额',
									align : 'center',
									width : '10'
								},
								{
									field : 'mark',
									title : '备注',
									align : 'center',
									width : '100',
									editable : {
										type : 'text',
										title : '修改备注',
										validate : function(value) {
											var data = $('#purchaseListTable')
													.bootstrapTable('getData'), index = $(
													this).parents('tr').data(
													'index');
											value = $.trim(value);
											var info = '';
											$.post("updatePurchaseInfo.do", {
												id : data[index].id,
												mark : value
											}, function(data) {
												if (!data.success) {
													info = data.msg;
												} else {
													$('#purchaseListTable')
															.bootstrapTable(
																	'refresh');
												}
											}, "json");
											return info;
										}
									}
								},{
									title : '操作',
									field : 'shopId',
									align : 'center',
									width : '10',
									valign : 'middle',
									formatter : operateFormatter
								},{
									field : 'pageNum',
									visible : false
								}, {
									field : 'pageSize',
									visible : false
								}]
					});

}

function addPurchaseInfo() {
	$("#addPurchaseInfoForm").validate().resetForm();
	$("input[name='createTime']").val(dateTime);
	pageIndex = layer.open({
		type : 1,
		title : '新增采购',
		shadeClose : true,
		shade : 0.5,
		area : [ '500px', '450px' ],
		content : $('#addPurchaseInfo')
	});

}

function operateFormatter(value, row, index) {
	return [
			'<a class="remove" href="javascript:void(0)" onClick="delRow('
					+ row.id + ')" title="删除">',
			'<i class="glyphicon glyphicon-remove"></i>', '</a>' ].join('');
}
function search() {
	$('#purchaseListTable').bootstrapTable('refresh', {
		query : {
			materialId : $("#materialId").val(),
			materialTypeId : $("#materialTypeId").val()
		}
	});
}

function delRow(id) {

	layer.confirm('确定删除吗？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.getJSON("delPurchaseInfo.do", {
			id : id
		}, function(data) {
			if (data.success) {
				$.success("操作成功", function() {
					search();
				});
			} else {
				$.error(data.msg);
			}

		});
	}, function() {
		$.warn("您取消了删除操作");
	});

}