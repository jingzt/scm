<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
{                                                      
	"total":${page.total},                                                   
	"rows":[  
	<c:forEach items="${page.list }" var="product" varStatus="index">
		{"id":"${product.id}","name":"${product.name }","cost":"<fmt:formatNumber value='${product.cost}' type='currency' pattern='#.###' />","budgetCost":"<fmt:formatNumber value='${product.budgetCost}' type='currency' pattern='#.###' />","price":"<fmt:formatNumber value='${product.price}' type='currency' pattern='#.###' />","state":"<c:if test="${product.state==1}">正常</c:if><c:if test="${product.state==2}">停用</c:if>","operState":"${product.state}","pageNum":"${page.pageNum}","pageSize":"${page.pageSize}"}
		<c:if test="${!index.last}">,</c:if>
	</c:forEach>
	]                                                          
}                                                           
