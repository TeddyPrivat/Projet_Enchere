<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
	<link rel="stylesheet" type="text/css" href="./CSS/apparence.css">
	<title>Supprimer le compte</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
		<a href="ServletAccueil"><img src="images/encheres.png" alt="logo qui renvoie à l'accueil" /></a>
		<h1 class="navbar-brand">Suppression mon compte</h1>
		<p></p>
		</div>
	</nav>
	<div class="formulaire">
		<h1>Etes-vous sûr de vouloir supprimer votre compte ? </h1>
		<br>
		<form action="ServletSuppressionCompte" method="POST">
				<input type="submit" value="OUI" class="btn btn-danger"/>
				<a href="ServletModificationDeProfil" class="btn btn-success">ANNULER</a>
		</form>
	</div>
</body>
</html>