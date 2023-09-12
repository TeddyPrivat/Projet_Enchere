<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification de profil</title>
<style>
.incorrect{
	color:red;
	
}
form{
	display:table;
}
p     { display: table-row;  }
label { display: table-cell; }
input { display: table-cell; }
</style>
</head>
<body>

	<div>
		<a href="ServletAccueil"><img src="images/encheres.png"
			alt="logo qui renvoie à l'accueil" /></a>

	</div>
	<br>

<div align = "center"> 

	<h3>Mon profil</h3>
	<form method="POST" action="ModificationDeProfil">
	
	
	<c:if test="${emailIsInBDD }">
		<p class="incorrect">Cet email est déjà paris</p>
	</c:if>	
	
	<c:if test="${pseudoIsInBDD }">
		<p class="incorrect">Ce pseudo est déjà pris</p>
	</c:if>
		<table>
			<tr>
				<th align="left"><label for="pseudo">Pseudo :</label> <input type="text"
					name="pseudo" id="pseudo" value="${pseudo }" required></th>
				<th><label for="nom">Nom :</label> <input type="text"
					name="nom" id="nom" value="${nom }" required></th>

			</tr>
			<tr>
				<th align="left"><label for="prenom">Prénom :</label> <input type="text"
					name="prenom" id="prenom" value="${prenom }" required></th>
				<th><label for="email">Email :</label> <input type="email"
					name="email" id="email" value="${email }" required></th>
			</tr>
			<tr>
				<th align="left"><label for="telephone">Teléphone :</label> <input
					type="tel" name="telephone" id="telephone" value="${telephone }" required></th>
				<th><label for="rue">Rue :</label> <input type="text"
					name="rue" id="rue" value="${rue }" required></th>
			</tr>
			<tr>
				<th align="left" ><label for="codePostal">Code postale :</label> <input
					type="text" name="codePostal" id="codePostal" value="${codePostal }">
					
				</th>
				<th><label for="ville">Ville :</label> <input type="text"
					name="ville" id="ville" value="${ville }">
				</th>
			</tr>
			<tr>
				<th align="left"><label for="motDePasse">Mot de passe actuel :</label> <input
					type="password" name="motDePasse" id="motDePasseActuel" required></th>
				<td>
					<c:if test="${!isMdpCorrect && isMdpCorrect != null}">
						<p class="incorrect">Mot de passe incorrect</p>
					</c:if>
				</td>
				

			</tr>
			<tr>
				<th align="left"><label for="nouveauMotDePasse">Nouveau Mot de passe :</label> <input
					type="password" name="nouveauMotDePasse" id="nouveauMotDePasse" required/>
				</th>
				<th><label for="confirmationMotDePasse">Confirmation :</label>
					<input type="password" name="confirmationMotDePasse"
					id="confirmationMotDePasse" required/>
				</th>
			</tr>
			<tr>
				<th><label for="credit">Crédit ${credit }</label></th>
			</tr>

		</table>
		<c:if test="${!isNouveauMotDePasseCorrect && isNouveauMotDePasseCorrect != null}">
			<p class="incorrect">Nouveau mot de passe et sa confirmation : incorrects</p>
		</c:if>
		<div>
			<input type="submit" value="Enregistrer"/>
		</div>
		<div>
			<a href="ServletSuppressionCompte">Supprimer mon compte</a>
		</div>
	</form>
	</div>
</body>
</html>