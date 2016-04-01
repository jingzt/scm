/**
 * 材料列表
 */
$(function() {
	loadMaterialList();
	$("#supplierName").bsSuggest({
		url : "../supplier/getSelectData.do?name=",
		showBtn : false,
		keyField : "name",
		processData: processData,
		effectiveFields: ["name"],
	}).on("onSetSelectValue", function(e, keyword) {
		console.log("onSetSelectValue: ", keyword)
		$("input[name='supplierId']").val(keyword.id);
	}).on('onUnsetSelectValue', function (e) {
		$("input[name='supplierId']").val('');
    });
})

function processData(value){
	return eval(value);
}
function loadMaterialList() {

	$('#materialListTable').bootstrapTable({
		method : 'post',
		url : "getMaterialInfoListData.do",
		height : $(window).height() - 100,
		striped : true,
		minimumCountColumns : 2,
		smartDisplay : true,
		toolbar : "#materialInfoTableToolbar",
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
			width : '5%',
			formatter : serilNumFormatter
		},{
			field : 'typeName',
			title : '原料类别',
			align : 'center',
			width : '10%'
		}, {
			field : 'name',
			title : '原料名称',
			align : 'center',
			width : '15%'
		},  {
			field : 'unit',
			title : '单价',
			align : 'center',
			width : '10%'
		},  {
			field : 'brand',
			title : '品牌',
			align : 'center',
			width : '10%'
		},  {
			field : 'specifications',
			title : '规格',
			align : 'center',
			width : '20%'
		}, {
			field : 'supplierName',
			title : '原料供应商',
			align : 'center',
			width : '20%'
		}, {
			field : 'pageNum',
			visible : false
		}, {
			field : 'pageSize',
			visible : false
		}, {
			title : '操作',
			align : 'center',
			width : '5%',
			valign : 'middle',
			formatter : operateFormatter
		} ]
	});

}

function search() {

	$('#materialListTable').bootstrapTable('refresh', {
		query : {
			name : $("input[name='name']").val(),
			supplierId : $("input[name='supplierId']").val(),
			typeId : $("select[name='typeId']").val()
		}
	});

}

function operateFormatter(value, row, index) {
	return [
			'<a class="edit" href="toUpdateMaterialInfo.htm?id=' + row.id
					+ '" title="编辑">',
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
		$.getJSON("delMaterialInfo.do", {
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
