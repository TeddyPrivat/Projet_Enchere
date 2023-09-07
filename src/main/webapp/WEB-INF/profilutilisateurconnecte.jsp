<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST</title>
</head>
<body>
	<c:choose>
		<c:when test="${estConnecte == true }">
			<p>Je suis connecté</p>
			<p>${estConnecte }</p>
		</c:when>
		<c:otherwise>
			<p>Je ne suis pas connecté</p>
		</c:otherwise>
	</c:choose>
</body>
</html>