<%@ page pageEncoding="UTF-8"%>
<script type="text/html" id="income_product_template">
	<tr>
		<td class="center">
			<input type="hidden" name="incomeList[{{index}}].id"/> 
			<input type="hidden" name="incomeList[{{index}}].createTime" value="${dateTime}" /> 
		</td>
		<td>
			<select name="incomeList[{{index}}].productId" class="form-control"  data-rule-required="true" onchange="selectProductId({{index}})">
						<option value="">请选择商品</option>
				<c:forEach items="${productList}" var="product">
						<option value="${product.id}">${product.name}</option>
				</c:forEach>
			</select>
		</td>
		<td>
			<select name="incomeList[{{index}}].consumptionStyleId" class="form-control">
				<c:forEach items="${consumptionStyleList}" var="consumptionStyle">
					<option value="${consumptionStyle.id}" <c:if test="${consumptionStyle.id==income.consumptionStyleId}">selected="selected"</c:if> >${consumptionStyle.name}</option>
				</c:forEach>
			</select>
		</td>
		<td>
			<input type="text" name="incomeList[{{index}}].unitPrice" data-rule-required="true" data-rule-number="true" placeholder="单价" onfocus="makeTotalMoney({{index}})" class="form-control"/>
		</td>
		<td>
			<input type="text" name="incomeList[{{index}}].totalNum" data-rule-required="true" data-rule-number="true"  placeholder="数量" onfocus="makeTotalMoney({{index}})" class="form-control"/>
		</td>
		<td>
			<input type="text" name="incomeList[{{index}}].totalPrice" value="0" placeholder="金额自动计算" readonly="readonly" class="form-control"/>
		</td>
		<td>
			<input type="text" name="incomeList[{{index}}].mark" placeholder="备注" data-rule-maxlength="80" class="form-control"/>
		</td>
		<td class="center">
			<a class="remove" href="javascript:void(0)" onClick="delIncome(this)" title="删除"><i class="glyphicon glyphicon-remove"></i></a>
		</td>
	</tr>
</script>