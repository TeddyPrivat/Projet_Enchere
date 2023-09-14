<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
	<title>Nouvelle vente</title>
	<style>
	.retrait{
		border:1px black solid;
		height :100px;
		width: 300px;
		padding-top: 20px;
		padding-left : 20px;
	}
	</style>
</head>
<body>
	<div>
	<a href="ServletAccueil"><img src="images/encheres.png" alt="logo qui renvoie à l'accueil"/></a>
	<h3>Nouvelle vente</h3>
	</div>
	
	<form method="post" action="ServletNouvelleVente">
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
		<c:forEach items="${categories }" var="categorieArticle">
			<option value="${categorieArticle.noCategorie}">${categorieArticle.libelle}</option>
		</c:forEach>
	</select>
	<br>
	<br>
	<label for="photo">Photo de l'article</label>
	<input type="file" id="photo" name="photo" accept="image/png, image/jpeg"/>
	<br>
	<br>
	<label for="prix">Mise à prix</label>
	<input type="number" name="prix" id="prix" min="0" step="5" value="0"/>
	<br>
	<br>
	<label for="debutEnchere">Début de l'enchère</label>
	<input type="date" name="debutEnchere" id="debutEnchere"/>
	<br>
	<br>
	<label for="finEnchere">Fin de l'enchère</label>
	<input type="date" name="finEnchere" id="finEnchere"/>
	
	<h3>Retrait</h3>
	<div class="retrait">
		<table>
			<tr>
				<th align="left"><label for="rue">Rue</label></th>
				<th><input type="text" name="rue" id="rue" value="${adresseVendeur.rue }"/></th>
			</tr>
			<tr>
				<th><label for="codePostal">Code postal</label></th>
				<th><input type="text" name="codePostal" id="codePostal" value="${adresseVendeur.codePostal }"/></th>
			</tr>
			<tr>
				<th align="left"><label for="ville">Ville</label></th>
				<th><input type="text" name="ville" id="ville" value="${adresseVendeur.ville }"/></th>
			</tr>
		</table>
	</div>
	<br>
	<br>
	<input type="submit" value="Enregistrer" class="btn btn-success"/>
	<input type="reset" value="Annuler" class="btn btn-success"/>
	<a href="" class="btn btn-success">Annuler la vente</a>
	
	</form>
</body>
</html>