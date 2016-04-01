/**
 * 供应商列表
 */
$(function() {
	loadSupplierList();
})
function loadSupplierList() {

	$('#supplierListTable').bootstrapTable({
		method : 'post',
		url : "getSupplierListData.do",
		height : $(window).height()-100,
		striped : true,
		minimumCountColumns : 2,
		smartDisplay : true,
		toolbar : "#supplierInfoTableToolbar",
		pagination : true,
		sidePagination : "server",
		pageNumber : 1,
		pageSize : 5,
		pageList : [ 5, 10, 20 ],
		queryParamsType : "limit",
		contentType : "application/x-www-form-urlencoded",
		columns : [ {
			field : 'id',
			title : 'ID',
			visible : false
		}, {
			title : '序号',
			align : 'center',
			width : '10',
			formatter : serilNumFormatter
		}, {
			field : 'name',
			title : '名称',
			align : 'center',
			width : '100'
		}, {
			field : 'supplierType',
			title : '类别',
			align : 'center',
			width : '50'
		}, {
			field : 'address',
			title : '地址',
			align : 'center',
			width : '100'
		}, {
			title : '操作',
			align : 'center',
			width : '10',
			valign : 'middle',
			formatter : operateFormatter
		}, {
			field : 'pageNum',
			visible : false
		}, {
			field : 'pageSize',
			visible : false
		} ]
	});

}

function search() {

	$('#supplierListTable').bootstrapTable('refresh', {
		query : {
			name : $("input[name='name']").val(),
			typeId : $("select[name='typeId']").val(),
			levelId : $("select[name='levelId']").val()
		}
	});

}

function operateFormatter(value, row, index) {
	return [
			'<a class="edit" href="toUpdateSupplierInfo.htm?id='+row.id+'" title="编辑">',
			'<i class="glyphicon glyphicon-pencil"></i>',
			'</a>    ',
			'<a class="remove" href="javascript:void(0)" onClick="delRow('
					+ row.id + ')" title="删除">',
			'<i class="glyphicon glyphicon-remove"></i>', '</a>' ].join('');
}

function delRow(id) {
	layer.confirm('确定删除吗？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.getJSON("delSupplierInfo.do", {
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
