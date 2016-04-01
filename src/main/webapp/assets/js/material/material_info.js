/**
 * 新增/编辑材料信息
 */
$(function() {

	$("#supplierName").bsSuggest({
		url : "../supplier/getSelectData.do?name=",
		showBtn : false,
		keyField : "name",
		processData : processData,
		effectiveFields : [ "name" ],
	}).on("onSetSelectValue", function(e, keyword) {
		console.log("onSetSelectValue: ", keyword)
		$("input[name='supplierId']").val(keyword.id);
	}).on('onUnsetSelectValue', function(e) {
		$("input[name='supplierId']").val('');
	});

	$("#materialInfoForm").validate({
		ignore: "", // 开启hidden验证,1.9版本后默认关闭 
		rules : {
			'name' : {
				required : true,
				maxlength : 50
			},
			'unitPrice' : {
				required : true,
				number : true,
			 	max:1000000
			},
			'supplierId' : {
				required : true
			},
			'mark' : {
				maxlength : 80
			},
			'brand' : {
				maxlength : 100
			},
			'specifications' : {
				maxlength : 100
			}
			

		},
		submitHandler : function(form) {
			var options = {
				url : "saveOrUpdateMaterialInfo.do",
				type : "post",
				dataType : "json",
				success : function(data) {
					if (data.success) {
						$.success('操作成功', function() {
							window.location.href = "getMaterialList.htm";

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
function processData(value){
	return eval(value);
	
}
