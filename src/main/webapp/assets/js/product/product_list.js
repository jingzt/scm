/**
 * 产品列表
 */
$(function() {
	loadProductList();
})

function loadProductList() {

	$('#productListTable').bootstrapTable({
		method : 'post',
		url : "getProductListData.do",
		height : $(window).height() - 100,
		striped : true,
		minimumCountColumns : 2,
		smartDisplay : true,
		toolbar : "#productInfoTableToolbar",
		pagination : true,
		sidePagination : "server",
		pageNumber : 1,
		pageSize : 2,
		pageList : [ 2, 4, 20 ],
		queryParamsType : "limit",
		contentType : "application/x-www-form-urlencoded",
		columns : [ {
			field : 'id',
			title : 'ID',
			visible : false
		}, {
			title : '序号',
			align : 'center',
			width : '5%',
			formatter : serilNumFormatter
		}, {
			field : 'name',
			title : '产品名称',
			align : 'center',
			width : '35%',
			editable : {
				type : 'text',
				title : '修改产品名称',
				validate : function(value) {
					var data = $('#productListTable')
							.bootstrapTable('getData'), index = $(
							this).parents('tr').data(
							'index');
					value = $.trim(value);
					if (!value) {
						return '该项必填';
					}
					var info = '';
					$.post("updateProductInfo.do", {
						id : data[index].id,
						name : value
					}, function(data) {
						if (!data.success) {
							info = data.msg;
						} else {
							$('#productListTable')
									.bootstrapTable(
											'refresh');
						}
					}, "json");
					return info;
				}
			}
		}, {
			field : 'price',
			title : '售价',
			align : 'center',
			width : '10%',
			editable : {
				type : 'text',
				title : '修改售价',
				validate : function(value) {
					var data = $('#productListTable')
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
					$.post("updateProductInfo.do", {
						id : data[index].id,
						price : value
					}, function(data) {
						if (!data.success) {
							info = data.msg;
						} else {
							$('#productListTable')
									.bootstrapTable(
											'refresh');
						}
					}, "json");
					return info;
				}
			}
		}, {
			field : 'cost',
			title : '成本',
			align : 'center',
			width : '10%',
			editable : {
				type : 'text',
				title : '修改成本',
				validate : function(value) {
					var data = $('#productListTable')
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
					$.post("updateProductInfo.do", {
						id : data[index].id,
						cost : value
					}, function(data) {
						if (!data.success) {
							info = data.msg;
						} else {
							$('#productListTable')
									.bootstrapTable(
											'refresh');
						}
					}, "json");
					return info;
				}
			}
		}, {
			field : 'budgetCost',
			title : '预算成本',
			align : 'center',
			width : '10%'
		}, {
			field : 'state',
			title : '状态',
			align : 'center',
			width : '10%',
			formatter : colorFormatter
		}, {
			field : 'operState',
			title : '操作状态',
			align : 'center',
			visible : false
		}, {
			field : 'pageNum',
			visible : false
		}, {
			field : 'pageSize',
			visible : false
		}, {
			title : '操作',
			align : 'center',
			width : '15%',
			valign : 'middle',
			formatter : operateFormatter
		} ]
	});

}

function search() {
	$('#productListTable').bootstrapTable('refresh', {
		query : {
			name : $("input[name='name']").val(),
			state : $("select[name='state']").val()
		}
	});
}
function colorFormatter(value, row, index) {
	if (row.operState == 1) {
		return '<span style="color:green">' + value + '</span>';
	} else {
		return '<span style="color:red">' + value + '</span>';
	}
}
function operateFormatter(value, row, index) {
	var changeState;
	if (row.operState == 1) {
		changeState = '<a class="edit" href="javascript:void(0)" onClick="changeState('+row.id+',2)" title="停用"><i class="glyphicon glyphicon-ban-circle"></i></a>';
	} else {
		changeState = '<a class="edit" href="javascript:void(0)" onClick="changeState('+row.id+',1)" title="启用"><i class="glyphicon glyphicon-ok"></i></a>';
	}

	return [

			'<a class="edit" href="toEditProductInfo.htm?id=' + row.id
					+ '" title="编辑">',
			'<i class="glyphicon glyphicon-pencil"></i>',
			'</a>',
			changeState,
			'<a class="remove" href="javascript:void(0)" onClick="delRow('
					+ row.id + ')" title="删除">',
			'<i class="glyphicon glyphicon-remove"></i>', '</a>' ].join(' ');
}
function changeState(id,state) {
	var tip;
	if(state==1){
		tip="确定启用该产品信息吗？";
	}else{
		tip="确定停用该产品信息吗？";
	}
	layer.confirm(tip, {
		btn : [ '确定', '取消' ]
	}, function() {
		$.getJSON("updateProductInfo.do", {
			id:id,
			state : state
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
function delRow(id) {
	layer.confirm('确定删除吗？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.getJSON("delProductInfo.do", {
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
