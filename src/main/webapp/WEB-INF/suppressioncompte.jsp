<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.formulaire{
		text-align:center;
	}
</style>
<meta charset="UTF-8">
<title>Supprimer le compte</title>
</head>
<body>

	<div>
		<a href="ServletAccueil"><img src="images/encheres.png"
			alt="logo qui renvoie à l'accueil" /></a>
	</div>
	<div class="formulaire">
		<h1>Etes-vous sûr de vouloir supprimer votre compte ? </h1>
		<form action="ServletSuppressionCompte" method="POST">
			<input type="submit" value="OUI"/>
			<a href="ServletModificationDeProfil">ANNULER</a>
		</form>
	</div>
</body>
</html>