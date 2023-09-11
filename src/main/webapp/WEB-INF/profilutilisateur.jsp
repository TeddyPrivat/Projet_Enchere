<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
			<a href="ModificationDeProfil">Modifier</a>
		</c:if>

</body>
</html>