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
	<link rel="stylesheet" type="text/css" href="./CSS/apparence.css">
	<title>Profil utilisateur</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<a href="ServletAccueil"><img src="images/encheres.png" alt="logo qui renvoie à l'accueil" /></a>
			<h1 class="navbar-brand">Mon profil</h1>
			<p></p>
		</div>
	</nav>
	<br>
	<div align="center"> 
		<table>
			<thead>
				<tr>
					<td><span class="labelProfil">Pseudo :</span> ${utilisateur.pseudo }</td>
				</tr>
	
				<tr>
					<td><span class="labelProfil">Nom :</span> ${utilisateur.nom }</td>
				</tr>
	
				<tr>
					<td><span class="labelProfil">Prénom :</span> ${utilisateur.prenom }</td>
				</tr>
				<tr>
					<td><span class="labelProfil">Email :</span> ${utilisateur.email }</td>
				</tr>
				<tr>
					<td><span class="labelProfil">Teléphone :</span> ${utilisateur.telephone }</td>
				</tr>
				<tr>
					<td><span class="labelProfil">Rue :</span> ${utilisateur.rue }</td>
				</tr>
				<tr>
					<td><span class="labelProfil">Code Postal :</span> ${utilisateur.codePostal }</td>
				</tr>
				<tr>
					<td><span class="labelProfil">Ville :</span> ${utilisateur.ville }</td>
				</tr>
			</thead>
		</table>
		<br>
		<div class="boutonModif">
			<c:if test="${afficheBouton}"> 
				<a href="ModificationDeProfil" class="btn btn-success">Modifier</a>
			</c:if>
		</div>
	</div>
</body>
</html>