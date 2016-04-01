<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
[  
	<c:forEach items="${purchaseList}" var="purchase" varStatus="index">
		{"title":"采购金额：<fmt:formatNumber value='${purchase.totalMoney}' type='currency' pattern='#.###' />元","color":"red","start":"<fmt:formatDate value="${purchase.createTime}" pattern="yyyy-MM-dd"/>"}
		<c:if test="${!index.last}">,</c:if>
	</c:forEach>
]  