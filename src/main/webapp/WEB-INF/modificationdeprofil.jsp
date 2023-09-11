<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification de profil</title>
<style>
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

	<h3>Mon profil</h3>

	<form method="POST" action=Servletinscription>
		<table>
			<tr>
				<th align="left"><label for="pseudo">Pseudo :</label> <input type="text"
					name="pseudo" id="pseudo"></th>
				<th><label for="nom">Nom :</label> <input type="text"
					name="nom" id="nom"></th>

			</tr>
			<tr>
				<th align="left"><label for="prenom">Prénom :</label> <input type="text"
					name="prenom" id="prenom"></th>
				<th><label for="email">Email :</label> <input type="email"
					name="email" id="email"></th>
			</tr>
			<tr>
				<th align="left"><label for="telephone">Teléphone :</label> <input
					type="tel" name="telephone" id="telephone"></th>
				<th><label for="rue">Rue :</label> <input type="text"
					name="rue" id="rue"></th>
			</tr>
			<tr>
				<th align="left" ><label for="codePostal">Code postale :</label> <input
					type="text" name="codePostal" id="codePostal"></th>
				<th><label for="ville">Ville :</label> <input type="text"
					name="ville" id="ville"></th>
			</tr>
			<tr>
				<th align="left"><label for="motDePasse">Mot de passe actuel :</label> <input
					type="password" name="motDePasse" id="motDePasseActuel"></th>
				<th></th>

			</tr>
			<tr>
				<th align="left"><label for="motDePasse">Nouveau Mot de passe :</label> <input
					type="password" name="motDePasse" id="nouveauMotDePasse">
				</th>
				<th><label for="confirmationMotDePasse">Confirmation :</label>
					<input type="password" name="confirmationMotDePasse"
					id="confirmationMotDePasse">
				</th>
			</tr>

		</table>

		<div>
			<a href="">Enregistrer</a>
		</div>
		<div>
			<a href="">Supprimer mon compte</a>
		</div>
	</form>
</body>
</html>