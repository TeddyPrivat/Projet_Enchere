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
	<link rel="stylesheet" type="text/css" href="./CSS/apparence.css">
	<title>Nouvelle vente</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<a href="ServletAccueil"><img src="images/encheres.png" alt="logo qui renvoie à l'accueil"/></a>
			<h3 class="navbar-brand">Nouvelle vente</h3>
			<p></p>
		</div>
	</nav>
	<br>
	<form method="post" action="ServletNouvelleVente">
	<table>
		<tr>
			<th><label for="article">Article</label></th>
			<th><input type="text" name="article" id="article"/></th>
		</tr>
		<tr>
			<th><label for="description">Description</label></th>
			<th><input type="text" name="description" id="description"/></th>
		</tr>
		<tr>
			<th><label for="categorie-select">Catégorie</label></th>
			<th>
			<select id="categorie-select" name="categorie-select">
				<c:forEach items="${categories }" var="categorieArticle">
					<option value="${categorieArticle.noCategorie}">${categorieArticle.libelle}</option>
				</c:forEach>
			</select>
			</th>
		</tr>
		<tr>
			<th><label for="photo">Photo de l'article</label></th>
			<th><input type="file" id="photo" name="photo" accept="image/png, image/jpeg"/></th>
		</tr>
		<tr>
			<th><label for="prix">Mise à prix</label></th>
			<th><input type="number" name="prix" id="prix" min="0" step="5" value="0"/></th>
		</tr>
		<tr>
			<th><label for="debutEnchere">Début de l'enchère</label></th>
			<th><input type="date" name="debutEnchere" id="debutEnchere"/></th>
		</tr>
		<tr>
			<th><label for="finEnchere">Fin de l'enchère</label></th>
			<th><input type="date" name="finEnchere" id="finEnchere"/></th>
		</tr>
	</table>
	<br>
	<h5>Retrait</h5>
	<div class="retrait">
	<table>
		<tr>
			<th><label for="rue">Rue</label></th>
			<th><input type="text" name="rue" id="rue" value="${adresseVendeur.rue }"/></th>
		</tr>
		<tr>
			<th><label for="codePostal">Code postal</label></th>
			<th><input type="text" name="codePostal" id="codePostal" value="${adresseVendeur.codePostal }"/></th>
		</tr>
		<tr>
			<th><label for="ville">Ville</label></th>
			<th><input type="text" name="ville" id="ville" value="${adresseVendeur.ville }"/></th>
		</tr>
	</table>
	</div>
	<br>
	<div class="groupe-bouton">
		<input type="submit" value="Enregistrer" class="btn btn-success"/>
		<input type="reset" value="Annuler" class="btn btn-success"/>
		<a href="" class="btn btn-success">Annuler la vente</a>
	</div>
	</form>
</body>
</html>