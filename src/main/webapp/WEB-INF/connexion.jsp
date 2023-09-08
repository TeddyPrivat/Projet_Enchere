<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
<style>
.infoConnexion {
	color: red;
}
</style>
</head>
<body>

	<div>
		<a href="ServletAccueil"><img src="images/encheres.png"
			alt="logo qui renvoie à l'accueil" /></a>
	</div>

	<br>
	<form method="post" action="ServletConnexion">
		<div>
			<label for="username">Identifiant:</label> <input type="text"
				id="username" name="username" />
		</div>
		<br>
		<div>
			<label for="pass">Mot de passe :</label> <input type="password"
				id="pass" name="pass" />
		</div>
		<c:if test="${estConnecte == 0 }">
			<p class="infoConnexion">Mot de passe ou identifiant incorrect</p>
		</c:if>

		<input type="submit" value="Connexion" />
	</form>
	<br>

	<div>
		<input type="checkbox" id="souvenir" name="souvenir" /> <label
			for="souvenir">Se souvenir de moi</label>
	</div>

	<br>
	<a href="#">Mot de passe oublié</a>
	<br>
	<a href="ServletInscription">Créer un compte</a>
	<br>



</body>
</html>