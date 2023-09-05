<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details de la vente</title>
</head>
<body>
<a href="ServletAccueil"><img src="images/encheres.png" alt="logo qui renvoie à l'accueil"/></a>

<h2>Détails vente</h2>
<form method="post" action="">
<table>
	<tr>
		<td><h3>Titre de l'annonce</h3></td>
	</tr>
	<tr>
		<td>Description</td>
		<td>LA DESCRIPTION</td>
	</tr>
	<tr>
		<td>Catégorie</td>
		<td> LA CATEGORIE</td>
	</tr>
	<tr>
		<td>Meilleure offre</td>
		<td>pts par NOM</td>
	</tr>
	<tr>
		<td>Fin de l'enchère</td>
		<td>DATE FIN ENCHERE </td>
	</tr>
	<tr>
		<td>Retrait</td>
		<td>ADRESSE </td>
	</tr>
	<tr>
		<td></td>
		<td>CODE POSTAL </td>
	</tr>
	<tr>
		<td>Vendeur</td>
		<td>NOM DU VENDEUR</td>
	</tr>
	
	<tr>
		<td><label for="proposition">Ma proposition </label></td>
		<td><input type="number" name="proposition" id="proposition" value="100" step="5" min="0"/>
		<td><input type="submit" value="Enchérir"/></td>

	</tr>
	
</table>
</form>
</body>
</html>