/**
 * 新增/编辑产品信息
 */
$(function() {
	$("#incomeInfoForm").validate({
		submitHandler : function(form) {
			var options = {
				url : "saveOrUpdateIncomeList.do",
				type : "post",
				dataType : "json",
				success : function(data) {
					if (data.success) {
						$.success('操作成功', function() {
							window.location= window.location;
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
	$("input[name='incomeList[" + index + "].unitPrice']").on("input",
			function() {
				var unitPrice = $(
						"input[name='incomeList[" + index
								+ "].unitPrice']").val();
				var totalNum = $(
						"input[name='incomeList[" + index
								+ "].totalNum']").val();
				$(
						"input[name='incomeList[" + index
								+ "].totalPrice']").val(
						Number(unitPrice) * Number(totalNum).toFixed(3));
			});
	$("input[name='incomeList[" + index + "].totalNum']").on(
			"input",
			function() {
				var unitPrice = $(
						"input[name='incomeList[" + index
								+ "].unitPrice']").val();
				var totalNum = $(
						"input[name='incomeList[" + index
								+ "].totalNum']").val();
				$(
						"input[name='incomeList[" + index
								+ "].totalPrice']").val(
						Number(unitPrice) * Number(totalNum).toFixed(3));
			});
}
/**
 * 销售明细模版专用 开始
 */
function addNewIncome() {
	var html = $("#income_product_template").html();
	var count = $("#incomeData").children('tr').length;
	html = template('income_product_template', {
		index : count
	});
	$("#incomeData").append(html);

}
function delIncome(el) {
	var p = $(el).parent('td').parent('tr');
	var siblings = p.siblings();
	p.remove();
	siblings.each(function(index, element) {
		var founds = $(element).find("[name^='incomeList']");
		founds.each(function() {
			$(this).attr(
					'name',
					$(this).attr('name').replace(/incomeList\[\d+]/g,
							'incomeList[' + index + ']'));
		});
		var realtionNum = $(element).find("[onfocus^='makeTotalMoney']");
		realtionNum.each(function() {
			$(this.focus(makeTotalMoney(index)));
		});

	});
}
/**
 * 销售明细模版专用 结束
 */


function selectProductId(index){

	$.getJSON("../product/getProductDataById.do", {
		id : $("select[name='incomeList["+index+"].productId']").val()
	}, function(data) {
		if(data==null){
			$("input[name='incomeList["+index+"].unitPrice']").val("");
		}else{
			$("input[name='incomeList["+index+"].unitPrice']").val(data.price);
		}

	});

}
