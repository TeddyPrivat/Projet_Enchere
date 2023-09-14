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
    
    <title>Inscription</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
       		<a href="ServletAccueil"><img src="images/encheres.png" alt="logo qui renvoie à l'accueil" /></a>
    		 <h1 class="navbar-brand">Créer mon compte</h1>
    		 <p></p>
    	</div>
    </nav>
    <br>
	<form method="POST" action=ServletInscription>
		<c:if test="${isPseudoUsed }">
			<p class="incorrect">Pseudo déjà utilisé</p>
		</c:if>
		<c:if test="${isEmailUsed}">
			<p class="incorrect">Email déjà utilisé</p>
	    </c:if>
		<div class="row">
			  <div class="col-sm-3"></div>
			  <div class="col-sm-3">
			  	<table>
			  		<tr>
			  			<th><label for="pseudo">Pseudo :</label><th>
			  			<td><input type="text" name="pseudo" id="pseudo" ></td>
			  		<tr>
			  	</table>
			  </div>
			  <div class="col-sm-3">
			  	<table>
			  		<tr>
			  			<th><label for="name">Nom :</label></th>
			  			<td><input type="text" name="nom" id="name" ></td>
			  		</tr>
			  	</table>
			  </div>
			  <div class="col-sm-3"></div>
		</div>
		<br>
		<div class="row">
			  <div class="col-sm-3"></div>
			  <div class="col-sm-3">
			  	<table>
			  		<tr>
			  			<th><label for="prenom">Prénom :</label></th>
			  			<th><input type="text" name="prenom" id="prenom" ></th>
			  		</tr>
			  	</table>
			  </div>
			  <div class="col-sm-3">
			  	<table>
			  		<tr>
			  			<th><label for="email">Email :</label></th>
			  			<th><input type="email" name="email" id="email" ></th>
			  		</tr>
			  	</table>
			  </div>
			  <div class="col-sm-3"></div>
		</div>
		<br>
		<div class="row">
			  <div class="col-sm-3"></div>
			  <div class="col-sm-3">
			  	<table>
			  		<tr>
			 			<th><label for="telephone">Teléphone :</label></th>
			 			<th><input type="tel" name="telephone" id="telephone" ></th>
			  		</tr>
			  	</table>
			  </div>
			  <div class="col-sm-3">
			  	<table>
			  		<tr>
			  			<th><label for="rue">Rue :</label></th>
			  			<th><input type="text" name="rue" id="rue" ></th>
			  		</tr>
			  	</table>
			  </div>
			  <div class="col-sm-3"></div>
		</div>
		<br>
		<div class="row">
			  <div class="col-sm-3"></div>
			  <div class="col-sm-3">
			  	<table>
			  		<tr>
			 			<th><label for="codePostal">Code postal  :</label></th>
			 			<th><input type="text" name="codePostal" id="codePostal" ></th>
			  		</tr>
			  	</table>
			  </div>
			  <div class="col-sm-3">
			  	<table>
			  		<tr>
			  			<th><label for="ville">Ville :</label></th>
			  			<th><input type="text" name="ville" id="ville" ></th>
			  		</tr>
			  	</table>
			  </div>
			  <div class="col-sm-3"></div>
		</div>
		<br>
		<div class="row">
			  <div class="col-sm-3"></div>
			  <div class="col-sm-3">
			  		<table>
			  			<tr>
			  				<th><label for="motDePasse">Mot de passe :</label></th>
			  				<th><input type="password" name="motDePasse" id="motDePasse" ></th>
			  			</tr>
			  		</table>
			  </div>
			  <div class="col-sm-3">
			  	<table>
			  		<tr>
			 			<th><label for="confirmationMotDePasse">Confirmation :</label></th>
			 			<th><input type="password" name="confirmationMotDePasse" id="confirmationMotDePasse" ></th>
			  		</tr>
			  	</table>
			  </div>
			  <div class="col-sm-3"></div>
		</div>
		<br>
		<div class="row">
			<div class="col-sm-5"></div>
	        <div class="col-sm-2">
		            <input type="submit" value="Créer" name="creerUnCompte" class="btn btn-success"/>
		            <a href="accueil" class="btn btn-success">Annuler</a>
	        </div>
	        <div class="col-sm-5"></div>
        </div>
	</form>
</body>
</html>