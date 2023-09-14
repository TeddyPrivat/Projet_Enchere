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
	<title>Profil utilisateur</title>
</head>
<body>

	<div>
		<a href="ServletAccueil"><img src="images/encheres.png"
			alt="logo qui renvoie à l'accueil" /></a>
	</div>

	<br>

	<table>
		<thead>
			<tr>
				<td>Pseudo : ${utilisateur.pseudo }</td>
			</tr>

			<tr>
				<td>Nom : ${utilisateur.nom }</td>
			</tr>

			<tr>
				<td>Prénom : ${utilisateur.prenom }</td>
			</tr>
			<tr>
				<td>Email : ${utilisateur.email }</td>
			</tr>
			<tr>
				<td>Teléphone : ${utilisateur.telephone }</td>
			</tr>
			<tr>
				<td>Rue : ${utilisateur.rue }</td>
			</tr>
			<tr>
				<td>Code Postal : ${utilisateur.codePostal }</td>
			</tr>
			<tr>
				<td>Ville : ${utilisateur.ville }</td>
			</tr>
		</thead>
	</table>
	
		<c:if test="${afficheBouton}"> 
			<a href="ModificationDeProfil" class="btn btn-success">Modifier</a>
		</c:if>

</body>
</html>