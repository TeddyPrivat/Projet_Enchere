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
			<td>${articleEnVente.enchere.montantEnchere } pts <c:if test="${articleEnVente.enchere.acheteur != null }">par ${articleEnVente.enchere.acheteur.pseudo }</c:if></td>
		</tr>
		<tr>
			<td>Mise à prix</td>
			<td>${articleEnVente.miseAPrix }</td>
		</tr>
		<tr>
			<td>Fin de l'enchère</td>
			<td>${articleEnVente.dateFinEncheres}</td>
		</tr>
		<tr>
			<td>Retrait</td>
			<td>${articleEnVente.retrait.rue }</td>
		</tr>
		<tr>
			<td></td>
			<td>${articleEnVente.retrait.codePostal } ${articleEnVente.retrait.ville }</td>
		</tr>
		<tr>
			<td>Vendeur</td>
			<td>${articleEnVente.utilisateur.pseudo }</td>
		</tr>
		<c:if test="${boutonEncherir}">
			<form method="post" action="ServletDetailsVente">
				<tr>
					<td><label for="proposition">Ma proposition </label></td>
					<td><input type="number" name="proposition" id="proposition" value="${articleEnVente.enchere.montantEnchere }" step="5" min="${articleEnVente.enchere.montantEnchere + 5}" max="${creditAcheteur}"/>
					<td><input type="submit" value="Enchérir"/></td>
				</tr>
			</form>
		</c:if>
	</table>
</body>
</html>