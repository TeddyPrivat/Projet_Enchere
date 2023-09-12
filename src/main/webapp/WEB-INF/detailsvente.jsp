<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details de la vente</title>
</head>
<body>
	<a href="ServletAccueil"><img src="images/encheres.png" alt="logo qui renvoie à l'accueil"/></a>
	<h2>Détails vente</h2>
	<table>
		<tr>
			<td><h3>${articleEnVente.nomArticle }</h3></td>
		</tr>
		<tr>
			<td>Description</td>
			<td>${articleEnVente.description }</td>
		</tr>
		<tr>
			<td>Catégorie</td>
			<td>${articleEnVente.categorie.libelle }</td>
		</tr>
		<tr>
			<td>Meilleure offre</td>
			<td>${articleEnVente.enchere.montantEnchere }</td>
		</tr>
		<tr>
			<td>Fin de l'enchère</td>
			<td>${articleEnVente.finEnchere }</td>
		</tr>
		<tr>
			<td>Retrait</td>
			<td>${articleEnVente.retrait.rue }
				<br>
				${articleEnVente.retrait.codePostal }
			</td>
		</tr>
		<tr>
			<td></td>
			<td>CODE POSTAL </td>
		</tr>
		<tr>
			<td>Vendeur</td>
			<td>NOM DU VENDEUR</td>
		</tr>
		<c:if test="${boutonEncherir">
			<form method="post" action="ServletDetailsVente">
				<tr>
					<td><label for="proposition">Ma proposition </label></td>
					<td><input type="number" name="proposition" id="proposition" value="100" step="5" min="0"/>
					<td><input type="submit" value="Enchérir"/></td>
				</tr>
			</form>
		</c:if>
	</table>
</body>
</html>