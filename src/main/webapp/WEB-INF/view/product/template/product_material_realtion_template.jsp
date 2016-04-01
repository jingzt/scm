<%@ page pageEncoding="UTF-8"%>
<script type="text/html" id="p_m_realtion_template">
	<tr>
		<td>
			<input type="hidden" name="realtionList[{{index}}].id" /> 
		</td>
		<td>
			<select name="realtionList[{{index}}].materialId" class="form-control" data-rule-required="true" onchange="selectMaterial({{index}})">
				<option value="">请选择材料</option>
				<c:forEach items="${materialList}" var="material">
					<option value="${material.id}">${material.name}</option>
				</c:forEach>
			</select>
		</td>
		<td>
			<input type="text" name="realtionList[{{index}}].materialUnitPrice" data-rule-required="true" data-rule-number="true"  placeholder="单价(元)"   class="form-control materialUnitPrice" onfocus="makeTotalMoney({{index}})"/>
		</td>
		<td>
			<input type="text" name="realtionList[{{index}}].materialTotalNum" data-rule-required="true" data-rule-number="true" placeholder="数量" class="form-control" onfocus="makeTotalMoney({{index}})"/>
		</td>
		<td>
			<input type="text" name="realtionList[{{index}}].materialTotalMoney" placeholder="金额自动计算"  class="form-control" readonly="readonly"/>
		</td>
		<td class="center">
			<a class="remove" href="javascript:void(0)" onClick="delMaterial(this)" title="删除"><i class="glyphicon glyphicon-remove"></i></a>
		</td>
	</tr>
</script>