<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="/WEB-INF/apparence.css">
	<title>Enchères</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<img src="images/encheres.png" alt="logo du site d'enchères">
			<div class="navbar-header">
				<h1 class="navbar-brand">Bienvenue sur le site des enchères par troc</h1>
			</div>
			<c:choose>
				<c:when test="${estConnecte != null}">
				 	<div class="nav navbar-nav navbar-right" style="flex-direction: row;">
						<a href="ServletEncheres" class="btn btn-success navbar-btn">Enchères</a><a href="ServletNouvelleVente" class="btn btn-success navbar-btn">Vendre un article</a><a href="ServletProfilUtilisateur" class="btn btn-success navbar-btn">Mon profil</a><form method = "POST" action="ServletAccueil"><input type = "submit" class = "btn btn-success navbar-btn" name = "deconnexion" value = "Déconnexion"></form>
					</div>
				</c:when>
				<c:otherwise>
					<a href="ServletConnexion" class="btn btn-success">S'inscrire - Se connecter</a>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
	<form method="POST" action="ServletAccueil">
		<h2>Liste des enchères</h2>
		<br>
		Filtres :
		<br>
		<i class="glyphicon glyphicon-search"></i><input type="text" name="rechercheArticle" placeholder="Le nom de l'article contient" >
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
		<br>
		<input type="submit" value="Rechercher" class="btn btn-success">
	</form>
	<c:choose>
		<c:when test="${encheres.size() > 0}">
			<c:forEach items = "${encheres }" var = "enchere">
				<c:if test="${nomArticleSaisi.equalsIgnoreCase(enchere.article.nomArticle) && enchere.article.etatVente == 'En vente' }">
					<c:choose>
						<c:when test="${estConnecte != null}">
							<ul>
								<li>${enchere.article.noArticle }</li>
								<li><a href="ServletDetailsVente?noArticle=${enchere.article.noArticle }">${enchere.article.nomArticle }</a></li>
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
									<li><a href="ServletDetailsVente?noArticle=${enchere.article.noArticle }">${enchere.article.nomArticle }</a></li>
									<li>Prix: ${enchere.article.prixVente } points</li>
									<li>Fin de l'enchère: ${enchere.article.dateFinEncheres }</li>
									<li>Vendeur: <a href="ServletProfilUtilisateur?noUtilisateur=${enchere.utilisateur.noUtilisateur }">${enchere.utilisateur.pseudo }</a></li>
								</ul>
							</c:if>
						</c:when>
						<c:when test="${achat != null && achat == 2 }">
							<ul>
								<li><a href="ServletDetailsVente?noArticle=${enchere.article.noArticle }">${enchere.article.nomArticle }</a></li>
								<li>Prix: ${enchere.article.prixVente } points</li>
								<li>Fin de l'enchère: ${enchere.article.dateFinEncheres }</li>
								<li>Vendeur: <a href="ServletProfilUtilisateur?noUtilisateur=${enchere.utilisateur.noUtilisateur }">${enchere.utilisateur.pseudo }</a></li>
							</ul>
						</c:when>
						<c:when test="${achat != null && achat == 3 }">
							<ul>
								<li><a href="ServletDetailsVente?noArticle=${enchere.article.noArticle }">${enchere.article.nomArticle }</a></li>
								<li>Prix: ${enchere.article.prixVente } points</li>
								<li>Fin de l'enchère: ${enchere.article.dateFinEncheres }</li>
								<li>Vendeur: <a href="ServletProfilUtilisateur?noUtilisateur=${enchere.utilisateur.noUtilisateur }">${enchere.utilisateur.pseudo }</a></li>
							</ul>
						</c:when>
						<c:when test="${vente != null && vente == 1 }">
							<c:if test="${enchere.utilisateur.noUtilisateur == coAManipuler && enchere.article.etatVente == 'En vente' }">
								<ul>
									<li><a href="ServletDetailsVente?noArticle=${enchere.article.noArticle }">${enchere.article.nomArticle }</a></li>
									<li>Prix: ${enchere.article.prixVente } points</li>
									<li>Fin de l'enchère: ${enchere.article.dateFinEncheres }</li>
									<li>Vendeur: <a href="ServletProfilUtilisateur?noUtilisateur=${enchere.utilisateur.noUtilisateur }">${enchere.utilisateur.pseudo }</a></li>
								</ul>
							</c:if>
						</c:when>
						<c:when test="${vente != null && vente == 2 }">
							<c:if test="${enchere.utilisateur.noUtilisateur == coAManipuler && enchere.article.etatVente == 'A vendre' }">
								<ul>
									<li><a href="ServletDetailsVente?noArticle=${enchere.article.noArticle }">${enchere.article.nomArticle }</a></li>
									<li>Prix: ${enchere.article.prixVente } points</li>
									<li>Fin de l'enchère: ${enchere.article.dateFinEncheres }</li>
									<li>Vendeur: <a href="ServletProfilUtilisateur?noUtilisateur=${enchere.utilisateur.noUtilisateur }">${enchere.utilisateur.pseudo }</a></li>
								</ul>
							</c:if>
						</c:when>
						<c:when test="${vente != null && vente == 3 }">
							<c:if test="${enchere.utilisateur.noUtilisateur == coAManipuler && enchere.article.etatVente == 'Vendu' }">
								<ul>
									<li><a href="ServletDetailsVente?noArticle=${enchere.article.noArticle }">${enchere.article.nomArticle }</a></li>
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
									<li><a href="ServletDetailsVente?noArticle=${enchere.article.noArticle}">${enchere.article.nomArticle }</a></li>
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
									<li><a href="ServletDetailsVente?noArticle=${enchere.article.noArticle }">${enchere.article.nomArticle }</a></li>
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