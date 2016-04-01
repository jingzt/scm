<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
{                                                      
	"total":${page.total},                                                   
	"rows":[  
	<c:forEach items="${page.list }" var="supplier" varStatus="index">
		{"id":"${supplier.id}","name":"${supplier.name }","supplierType":"${supplier.supplierType.name }","address":"${supplier.provinceName}${supplier.cityName}${supplier.districtName}${supplier.address}","pageNum":"${page.pageNum}","pageSize":"${page.pageSize}"}
		<c:if test="${!index.last}">,</c:if>
	</c:forEach>
	]                                                          
}                                                           
