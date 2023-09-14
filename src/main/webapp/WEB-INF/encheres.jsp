<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
	<link rel="stylesheet" type="text/css" href="./CSS/apparence.css">
	<meta charset="UTF-8">
	<title>Encheres</title>
</head>
<body>	
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<a href="ServletAccueil"><img src="images/encheres.png" alt="logo qui renvoie à l'accueil" /></a>
			<h1 class="navbar-brand">Encheres</h1>
			<p></p>
		</div>
	</nav>
	<br>
	<h5>Voici ici vos enchères</h5>
	<br>
	<div class="ToutesLesEncheres">
	<c:forEach items="${listeEncheres }" var="encheres">
	<c:choose>
		<c:when test="${encheres.utilisateur.noUtilisateur == estConnecte }">
			<div class="uneEnchere">
				<p>Article : ${encheres.article.nomArticle }</p>
				<p>Mise à prix : ${encheres.article.prixVente } </p>
				<p>Prix de vente : ${encheres.article.prixVente }</p>
				<c:if test="${encheres.article.etatVente == 'En vente'}">
					<a href="NouvelleVente?noArticle=${encheres.article.noArticle }" class="btn btn-success">Détails</a>
				</c:if>
			</div>
		</c:when>
		<c:otherwise><p></p></c:otherwise>
	</c:choose>
	</c:forEach>
	</div>
</body>
</html>