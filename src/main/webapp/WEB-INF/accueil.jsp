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
	<c:choose>
		<c:when test="${estConnecte != null}">
			<a href="ServletDetailsVente?myId=${estConnecte }">Enchères</a> <a href="ServletNouvelleVente?myId=${estConnecte }">Vendre un article</a> <a href="ServletProfilUtilisateur?myId=${estConnecte }">Mon profil</a> <form method = "POST" action="ServletAccueil"><input type = "submit" name = "deconnexion" value = "Déconnexion"></form>
		</c:when>
		<c:otherwise>
			<a href="ServletConnexion">S'inscrire - Se connecter</a>
		</c:otherwise>
	</c:choose>
	<br>
	<form method="POST" action="ServletAccueil">
		<h2>Liste des enchères</h2>
		Filtres :
		<input type="text" name="rechercheArticle" placeholder="Le nom de l'article contient">
		<br>
		<label for="categorie">Catégorie :</label>
		<select id="categorie" name="categorie">
			<option value = "" disabled selected>Choisissez une catégorie</option>
			<c:forEach items="${categories }" var="categorieArticle">
				<option value="${categorieArticle.noCategorie}">${categorieArticle.libelle}</option>
			</c:forEach>
		</select>
		<c:if test="${estConnecte != null }">
			<table>
				<thead>
					<td>
						<label for="achats">Achats</label>
						<input type="radio" id="achats" name="choixRadio">
					</td>
					<td>
						<label for="ventes">Mes ventes</label>
						<input type="radio" id="ventes" name="choixRadio">
					</td>
				</thead>
				<tbody>
					<td>
						<label for="autreEnchere">enchères ouvertes</label>
						<input type="checkbox" id="autreEnchere" name="achats" value=1>
						<br>
						<label for="enchereEncherie">mes enchères</label>
						<input type="checkbox" id="enchereEncherie" name="achats" value=2>
						<br>
						<label for="enchereGagnee">mes enchères remportées</label>
						<input type="checkbox" id="enchereGagnee" name="achats" value=3>
					</td>
					<td>
						<label for="ventesEnCours">mes ventes en cours</label>
						<input type="checkbox" id="ventesEnCours" name="ventes" value=1>
						<br>
						<label for="ventesAttente">mes ventes non débutées</label>
						<input type="checkbox" id="ventesAttente" name="ventes" value=2>
						<br>
						<label for="ventesTerminees">mes ventes terminées</label>
						<input type="checkbox" id="ventesTerminees" name="ventes" value=3>
					</td>
				</tbody>
			</table>
		</c:if>
		<br>
		<input type="submit" value="Rechercher">
	</form>
	<c:choose>
		<c:when test="${encheres.size() > 0}">
			<c:forEach items = "${encheres }" var = "enchere">
				<c:if test="${nomArticleSaisi.equalsIgnoreCase(enchere.article.nomArticle) && enchere.article.etatVente == 'En vente' }">
					<c:choose>
						<c:when test="${estConnecte != null}">
							<ul>
								<li><a href="ServletDetailsVente?noArticle="${enchere.article.noArticle }">${enchere.article.nomArticle }</a></li>
								<li>Prix: ${enchere.article.prixVente } points</li>
								<li>Fin de l'enchère: ${enchere.article.dateFinEncheres }</li>
								<li>Vendeur: <a href="ServletProfilUtilisateur?noUtilisateur=${enchere.utilisateur.noUtilisateur }">${enchere.utilisateur.pseudo }</a></li>
							</ul>
						</c:when>
						<c:otherwise>
							<ul>
								<li>${enchere.article.nomArticle }</li>
								<li>Prix: ${enchere.article.prixVente } points</li>
								<li>Fin de l'enchère: ${enchere.article.dateFinEncheres }</li>
								<li>Vendeur: ${enchere.utilisateur.pseudo }</li>
							</ul>
						</c:otherwise>
					</c:choose>
				</c:if>
				<c:if test="${estConnecte != null}">
					<c:choose>
						<c:when test="${achat != null && achat == 1 }">
							<c:if test ="${enchere.utilisateur.noUtilisateur != coAManipuler }">
								<ul>
									<li><a href="ServletDetailsVente?noArticle="${enchere.article.noArticle }">${enchere.article.nomArticle }</a></li>
									<li>Prix: ${enchere.article.prixVente } points</li>
									<li>Fin de l'enchère: ${enchere.article.dateFinEncheres }</li>
									<li>Vendeur: <a href="ServletProfilUtilisateur?noUtilisateur=${enchere.utilisateur.noUtilisateur }">${enchere.utilisateur.pseudo }</a></li>
								</ul>
							</c:if>
						</c:when>
						<c:when test="${achat != null && achat == 2 }">
							<ul>
								<li><a href="ServletDetailsVente?noArticle="${enchere.article.noArticle }">${enchere.article.nomArticle }</a></li>
								<li>Prix: ${enchere.article.prixVente } points</li>
								<li>Fin de l'enchère: ${enchere.article.dateFinEncheres }</li>
								<li>Vendeur: <a href="ServletProfilUtilisateur?noUtilisateur=${enchere.utilisateur.noUtilisateur }">${enchere.utilisateur.pseudo }</a></li>
							</ul>
						</c:when>
						<c:when test="${achat != null && achat == 3 }">
							<ul>
								<li><a href="ServletDetailsVente?noArticle="${enchere.article.noArticle }">${enchere.article.nomArticle }</a></li>
								<li>Prix: ${enchere.article.prixVente } points</li>
								<li>Fin de l'enchère: ${enchere.article.dateFinEncheres }</li>
								<li>Vendeur: <a href="ServletProfilUtilisateur?noUtilisateur=${enchere.utilisateur.noUtilisateur }">${enchere.utilisateur.pseudo }</a></li>
							</ul>
						</c:when>
						<c:when test="${vente != null && vente == 1 }">
							<c:if test="${enchere.utilisateur.noUtilisateur == coAManipuler && enchere.article.etatVente == 'En vente' }">
								<ul>
									<li><a href="ServletDetailsVente?noArticle="${enchere.article.noArticle }">${enchere.article.nomArticle }</a></li>
									<li>Prix: ${enchere.article.prixVente } points</li>
									<li>Fin de l'enchère: ${enchere.article.dateFinEncheres }</li>
									<li>Vendeur: <a href="ServletProfilUtilisateur?noUtilisateur=${enchere.utilisateur.noUtilisateur }">${enchere.utilisateur.pseudo }</a></li>
								</ul>
							</c:if>
						</c:when>
						<c:when test="${vente != null && vente == 2 }">
							<c:if test="${enchere.utilisateur.noUtilisateur == coAManipuler && enchere.article.etatVente == 'A vendre' }">
								<ul>
									<li><a href="ServletDetailsVente?noArticle="${enchere.article.noArticle }">${enchere.article.nomArticle }</a></li>
									<li>Prix: ${enchere.article.prixVente } points</li>
									<li>Fin de l'enchère: ${enchere.article.dateFinEncheres }</li>
									<li>Vendeur: <a href="ServletProfilUtilisateur?noUtilisateur=${enchere.utilisateur.noUtilisateur }">${enchere.utilisateur.pseudo }</a></li>
								</ul>
							</c:if>
						</c:when>
						<c:when test="${vente != null && vente == 3 }">
							<c:if test="${enchere.utilisateur.noUtilisateur == coAManipuler && enchere.article.etatVente == 'Vendu' }">
								<ul>
									<li><a href="ServletDetailsVente?noArticle="${enchere.article.noArticle }">${enchere.article.nomArticle }</a></li>
									<li>Prix: ${enchere.article.prixVente } points</li>
									<li>Fin de l'enchère: ${enchere.article.dateFinEncheres }</li>
									<li>Vendeur: <a href="ServletProfilUtilisateur?noUtilisateur=${enchere.utilisateur.noUtilisateur }">${enchere.utilisateur.pseudo }</a></li>
								</ul>
							</c:if>
						</c:when>
					</c:choose>
				</c:if>
				<c:choose>
					<c:when test="${categorieAffichage.noCategorie == enchere.article.categorie.noCategorie && enchere.article.etatVente == 'En vente' }">
						<c:choose>
							<c:when test="${estConnecte != null}">
								<ul>
									<li><a href="ServletDetailsVente?noArticle="${enchere.article.noArticle }">${enchere.article.nomArticle }</a></li>
									<li>Prix: ${enchere.article.prixVente } points</li>
									<li>Fin de l'enchère: ${enchere.article.dateFinEncheres }</li>
									<li>Vendeur: <a href="ServletProfilUtilisateur?noUtilisateur=${enchere.utilisateur.noUtilisateur }">${enchere.utilisateur.pseudo }</a></li>
								</ul>
							</c:when>
							<c:otherwise>
								<ul>
									<li>${enchere.article.nomArticle }</li>
									<li>Prix: ${enchere.article.prixVente } points</li>
									<li>Fin de l'enchère: ${enchere.article.dateFinEncheres }</li>
									<li>Vendeur: ${enchere.utilisateur.pseudo }</li>
								</ul>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:when test="${categorieAffichage.noCategorie == 5 && enchere.article.etatVente == 'En vente' }">
						<c:choose>
							<c:when test="${estConnecte != null}">
								<ul>
									<li><a href="ServletDetailsVente?noArticle="${enchere.article.noArticle }">${enchere.article.nomArticle }</a></li>
									<li>Prix: ${enchere.article.prixVente } points</li>
									<li>Fin de l'enchère: ${enchere.article.dateFinEncheres }</li>
									<li>Vendeur: <a href="ServletProfilUtilisateur?noUtilisateur=${enchere.utilisateur.noUtilisateur }">${enchere.utilisateur.pseudo }</a></li>
								</ul>
							</c:when>
							<c:otherwise>
								<ul>
									<li>${enchere.article.nomArticle }</li>
									<li>Prix: ${enchere.article.prixVente } points</li>
									<li>Fin de l'enchère: ${enchere.article.dateFinEncheres }</li>
									<li>Vendeur: ${enchere.utilisateur.pseudo }</li>
								</ul>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						Aucune enchère pour la catégorie demandée en ce moment
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<p>Aucune enchère en cours :(</p>
		</c:otherwise>
	</c:choose>
</body>
</html>