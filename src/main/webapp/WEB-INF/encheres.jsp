<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
.uneEnchere{
	border: 1px solid;
	height:150px;
	width:230px;
	display:block;
	padding-left : 20px;
	margin-left : 30px;
}
.ToutesLesEncheres{
	display:flex;
}
</style>
<meta charset="UTF-8">
<title>Encheres</title>
</head>
<body>	

	<div>
		<a href="ServletAccueil"><img src="images/encheres.png"
			alt="logo qui renvoie à l'accueil" /></a>
	</div>
	
	<h1>Encheres</h1>
	<h3>Voici ici vos enchères</h3>
	
	<div class="ToutesLesEncheres">
	<c:forEach items="${listeEncheres }" var="encheres">
	<c:choose>
	
		<c:when test="${encheres.utilisateur.noUtilisateur == estConnecte }">
		<div class="uneEnchere">
			<p>Article : ${encheres.article.nomArticle }</p>
			<p>Mise à prix : ${encheres.article.prixVente } </p>
			<p>Prix de vente : ${encheres.article.prixVente }</p>
			<c:if test="${encheres.article.etatVente == 'En vente'}">
				<a href="NouvelleVente?noArticle=${encheres.article.noArticle }">Coucou</a>
			</c:if>
			</div>
		</c:when>
		<c:otherwise><p></p></c:otherwise>
	</c:choose>
	</c:forEach>
	</div>

</body>
</html>