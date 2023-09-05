<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enchères</title>
</head>
<body>
	<img src="" alt="logo du site d'enchères">
	<h1>Bienvenue sur le site des enchères par troc</h1>
	<a href="">S'inscrire - Se connecter</a>
	<br>
	<form method="POST" action="ServletAccueil">
		<h2>Liste des enchères</h2>
		Filtres :
		<input type="text" name="nomArticle" placeholder="Le nom de l'article contient">
		<label for="categorie">Catégorie :</label>
		<select id="categorie" name="categorie">
			<c:forEach items="${categories }" var="categorieArticle">
				<option value="${categorieArticle.noCategorie}">${categorieArticle.libelle}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Rechercher">
	</form>
</body>
</html>