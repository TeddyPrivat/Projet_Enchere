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
	<img src="images/encheres.png" alt="logo du site d'enchères">
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
		<table>
			<thead>
				<td>
					<label for="achats">Achats</label>
					<input type="radio" id="achats">
				</td>
				<td>
					<label for="ventes">Mes ventes</label>
					<input type="radio" id="ventes">
				</td>
			</thead>
			<tbody>
				<td>
					<label for="enchereEnCours">enchères ouvertes</label>
					<input type="checkbox" id="enchereEnCours">
					<br>
					<label for="encheresPerso">mes enchères</label>
					<input type="checkbox" id="encheresPerso">
					<br>
					<label for="encheresGagnees">mes enchères remportées</label>
					<input type="checkbox" id="encheresGagnees">
				</td>
				<td>
					<label for="ventesEnCours">mes ventes en cours</label>
					<input type="checkbox" id="ventesEnCours">
					<br>
					<label for="ventesAttente">mes ventes non débutées</label>
					<input type="checkbox" id="ventesAttente">
					<br>
					<label for="ventesTerminees">mes ventes terminées</label>
					<input type="checkbox" id="ventesTerminees">
				</td>
			</tbody>
		</table>
		<input type="submit" value="Rechercher">
	</form>
	<c:choose>
		<c:when test="${encheres.size() > 0}">
			<c:forEach items = "${encheres }" var = "enchere">
				<c:choose>
					<c:when test="${categorieAffichage.noCategorie == enchere.article.categorie.noCategorie }">
						<ul>
							<li><a href="ServletDetailsVente">${enchere.article.nomArticle }</a></li>
							<li>Prix: ${enchere.article.prixVente } points</li>
							<li>Fin de l'enchère: ${enchere.article.dateFinEncheres }</li>
							<li>Vendeur: <a href="ServletProfilUtilisateur">${enchere.utilisateur.pseudo }</a></li>
						</ul>
					</c:when>
					<c:when test="${categorieAffichage.noCategorie == 5 }">
						<ul>
							<li><a href="ServletDetailsVente">${enchere.article.nomArticle }</a></li>
							<li>Prix: ${enchere.article.prixVente } points</li>
							<li>Fin de l'enchère: ${enchere.article.dateFinEncheres }</li>
							<li>Vendeur: <a href="ServletProfilUtilisateur">${enchere.utilisateur.pseudo }</a></li>
						</ul>
					</c:when>
					<c:otherwise>
						Aucune enchère pour la catégorie demandée
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<p>Aucune enchère</p>
		</c:otherwise>
	</c:choose>
</body>
</html>