<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouvelle vente</title>
</head>
<body>
	<h3>Nouvelle vente</h3>
	
	<label for="article">Article</label>
	<input type="text" name="article" id="article"/>
	<br>
	<br>
	<label for="description">Description</label>
	<input type="text" name="description" id="description"/>
	<br>
	<br>
	<label for="categorie-select">Catégorie</label>
	<select id="categorie-select" name="categorie-select">
		<option value=""></option>
		<option value="test">Option 1</option>
	</select>
	<br>
	<br>
	<label for="photo">Photo de l'article</label>
	<input type="file" id="photo" name="photo" accept="image/png, image/jpeg"/>
	<br>
	<br>
	<label for="prix">Mise à prix</label>
	<input type="number" name="prix" id="prix" min="0" step="5" value="0"/>
</body>
</html>