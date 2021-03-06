$(function(){
	$("#shopInfoForm").validate({
		ignore : "", // 开启hidden验证,1.9版本后默认关闭
		rules : {
			'name' : {
				required : true,
				rangelength : [ 2, 10 ]
			},
			'contactInformation' : {
				required : true,
				maxlength : 20
			},
			'provinceId' : {
				required : true
			},
			'cityId' : {
				required : true
			},
			'districtId' : {
				required : true
			},
			'introduction':{
				required : true,
				maxlength : 2000
			},
			'legalPersonName':{
				required : true,
				rangelength : [ 2, 10 ]
			},
			'email':{
				required : true,
				email:true
			},
			'features':{
				required : true,
				maxlength :90
			}
		},
		submitHandler : function(form) {
			var options = {
				url : "saveShopInfo.do",
				type : "post",
				dataType : "json",
				success : function(data) {
					if (data.success) {
						$.success('操作成功', function() {
							window.location.href="index.htm";
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
	
	
	$("select[name='provinceId']").change(
			function() {
				if ($("select[name='provinceId']").val() != '') {
					$.getJSON("../region/getRegion.do?pid="
							+ $("select[name='provinceId']").val(), function(
							data) {
						var s = "<option value=''>选择市</option>";
						$.each(data, function(i, item) {
							s += "<option value='" + item.id + "'>" + item.name+ "</option>";
						});
						$("select[name='cityId']").html(s);
						$("input[name='provinceName']").val($("select[name='provinceId'] option:selected").text());
						$("input[name='cityName']").val('');

						$("select[name='districtId']").html("<option value=''>选择区</option>");
						$("input[name='districtName']").val('');
					});
				} else {
					$("input[name='provinceName']").val('');

					$("select[name='cityId']").html("<option value=''>选择市</option>");
					$("input[name='cityName']").val('');

					$("select[name='districtId']").html("<option value=''>选择区</option>");
					$("input[name='districtName']").val('');

				}

			});

	$("select[name='cityId']").change(
			function() {
				if ($("select[name='cityId']").val() != '') {
					$.getJSON("../region/getRegion.do?pid="
							+ $("select[name='cityId']").val(), function(data) {
						var s = "<option value=''>选择区</option>";
						$.each(data, function(i, item) {
							s += "<option value='" + item.id + "'>" + item.name + "</option>";
						});
						$("select[name='districtId']").html(s);
						$("input[name='cityName']").val($("select[name='cityId'] option:selected").text());
						$("input[name='districtName']").val('');
					});
				} else {
					$("input[name='cityName']").val('');
					$("select[name='districtId']").html("<option value=''>选择区</option>");
					$("input[name='districtName']").val('');

				}
			});

	$("select[name='districtId']").change(
			function() {
				if ($("select[name='districtId']").val() != '') {
					$("input[name='districtName']").val($("select[name='districtId'] option:selected").text());
				} else {
					$("input[name='districtName']").val('');
				}
	});
});