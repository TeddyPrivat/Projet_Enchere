<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	<label for="debutenchere">Début de l'enchère</label>
	<input type="date" name="debutenchere" id="debutenchere"/>
	<br>
	<br>
	<label for="finenchere">Fin de l'enchère</label>
	<input type="date" name="finenchere" id="finenchere"/>
	
	<h3>Retrait</h3>
	<div class="retrait">
		<table>
			<tr>
				<th align="left"><label for="rue">Rue</label></th>
				<th><input type="text" name="rue" id="rue"/></th>
			</tr>
			<tr>
				<th><label for="codePostal">Code postal</label></th>
				<th><input type="text" name="codePostal" id="codePostal"/></th>
			</tr>
			<tr>
				<th align="left"><label for="ville">Ville</label></th>
				<th><input type="text" name="ville" id="ville"/></th>
			</tr>
		</table>
	</div>
	<br>
	<br>
	<input type="submit" value="Enregistrer"/>
	<input type="reset" value="Annuler"/>
	<a href="">Annuler la vente</a>
	
	</form>
</body>
</html>