<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- core 태그 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 연습..</title>
</head>
<body>
	<h3>안녕하세요.</h3>
	<c:set var="msg" value="Hello"></c:set>
	<p>msg의 값은 <c:out value="${msg }"></c:out></p>
	
	<c:set var="myAge" value="12" /> <!-- 선언.. -->
	<c:if test="${myAge >= 20 }"> <!-- if문.. -->
	<p>당신은 성인입니다.</p>
	</c:if>
	
	<c:choose>
	<c:when test="${myAge >= 20 }"> <!-- else if.. -->
	<p>당신은 성인입니다.</p>
	</c:when>
	<c:otherwise>
	<p>당신은 미성년자입니다</p>
	</c:otherwise>
	</c:choose>
	
	<c:forEach var="i" begin="1" end="10" step="2"> <!-- 반복문. step="1" 1씩 증가. step="2" => 2씩 증가. -->
	<p>i의 값은 ${i % 2 }</p>
	</c:forEach> 
</body>
</html>