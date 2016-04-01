<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
{                                                      
	"total":${page.total},                                                   
	"rows":[  
	<c:forEach items="${page.list }" var="purchase" varStatus="index">
		{"id":"${purchase.id}","name":"${purchase.material.name }","typeName":"${purchase.material.materialType.name }","unitPrice":"<fmt:formatNumber value='${purchase.unitPrice}' type='currency' pattern='#.###' />","unitName":"${purchase.unitType.name }","totalNum":"${purchase.totalNum}","totalMoney":"<fmt:formatNumber value='${purchase.totalMoney}' type='currency' pattern='#.###' />","mark":"${purchase.mark}","pageNum":"${page.pageNum}","pageSize":"${page.pageSize}"}
		<c:if test="${!index.last}">,</c:if>
	</c:forEach>
	]                                                          
}                                                           
