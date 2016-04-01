/**
 * 新增/编辑产品信息
 */
$(function() {
	$("#productInfoForm").validate({
		rules : {
			'product.name' : {
				required : true,
				maxlength : 80
			},
			'product.price' : {
				required : true,
				number : true,
				max : 10000
			}
		},
		submitHandler : function(form) {
			var options = {
				url : "saveOrUpdateProductInfo.do",
				type : "post",
				dataType : "json",
				success : function(data) {
					if (data.success) {
						$.success('操作成功', function() {
							window.location.href = "getProductList.htm";

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

function makeTotalMoney(index) {
	$("input[name='realtionList[" + index + "].materialUnitPrice']").on("input",
			function() {
				var unitPrice = $(
						"input[name='realtionList[" + index
								+ "].materialUnitPrice']").val();
				var totalNum = $(
						"input[name='realtionList[" + index
								+ "].materialTotalNum']").val();
				$(
						"input[name='realtionList[" + index
								+ "].materialTotalMoney']").val(
						Number(unitPrice) * Number(totalNum).toFixed(3));
			});
	$("input[name='realtionList[" + index + "].materialTotalNum']").on(
			"input",
			function() {
				var unitPrice = $(
						"input[name='realtionList[" + index
								+ "].materialUnitPrice']").val();
				var totalNum = $(
						"input[name='realtionList[" + index
								+ "].materialTotalNum']").val();
				$(
						"input[name='realtionList[" + index
								+ "].materialTotalMoney']").val(
						Number(unitPrice) * Number(totalNum).toFixed(3));
			});
}
/**
 * 产品-材料关系模版专用 开始
 */
function addNewMaterial() {
	var html = $("#p_m_realtion_template").html();
	var count = $("#materialData").children('tr').length;
	html = template('p_m_realtion_template', {
		index : count
	});
	$("#materialData").append(html);

}
function delMaterial(el) {
	var p = $(el).parent('td').parent('tr');
	var siblings = p.siblings();
	p.remove();
	siblings.each(function(index, element) {
		var founds = $(element).find("[name^='realtionList']");
		founds.each(function() {
			$(this).attr(
					'name',
					$(this).attr('name').replace(/realtionList\[\d+]/g,
							'realtionList[' + index + ']'));
		});
		var realtionNum = $(element).find("[onfocus^='makeTotalMoney']");
		realtionNum.each(function() {
			$(this.focus(makeTotalMoney(index)));
		});

	});
}
/**
 * 产品-材料关系模版专用 结束
 */
function selectMaterial(index){

	$.getJSON("../material/getSelectDataById.do", {
		id : $("select[name='realtionList["+index+"].materialId']").val()
	}, function(data) {
		if(data==null){
			$("input[name='realtionList["+index+"].materialUnitPrice']").val("");
		}else{
			$("input[name='realtionList["+index+"].materialUnitPrice']").val(data.unitPrice);
		}

	});

}