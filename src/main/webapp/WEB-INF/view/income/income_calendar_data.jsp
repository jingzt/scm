<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
[  
	<c:forEach items="${incomeList}" var="income" varStatus="index">
		{"title":"销售金额：<fmt:formatNumber value='${income.totalPrice}' type='currency' pattern='#.###' />元","color":"red","start":"<fmt:formatDate value="${income.createTime}" pattern="yyyy-MM-dd"/>"}
		<c:if test="${!index.last}">,</c:if>
	</c:forEach>
]  