<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
<title>Connexion</title>
<style>
.infoConnexion {
	color: red;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<a href="ServletAccueil"><img src="images/encheres.png" alt="logo qui renvoie à l'accueil" /></a>
		</div>
	</nav>
	<div align = "center"> 
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

 		<br>
 		<div>
			<input type="checkbox" id="souvenir" name="souvenir" />
			<label for="souvenir">Se souvenir de moi</label>
		</div>
		<br>
		<input type="submit" value="Connexion" class="btn btn-success"/>
	</form>
	<br>

	<br>
	<a href="#" class="btn btn-success">Mot de passe oublié</a> <a href="ServletInscription" class="btn btn-success">Créer un compte</a>
	<br>
</div>


</body>
</html>