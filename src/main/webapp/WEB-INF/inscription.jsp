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
    <style>
        form{
            display: flex;
            flex-wrap: wrap;
            flex-direction: column;
        }
        form div{
            display: flex;
            flex-wrap: nowrap;
            gap: 50px;
            margin: 0 0 10px 0;
            
        }
        form label{
            diplay:block;
            width:100px;
        }
        
        .incorrect {
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
    
    
    
    
    
     <h3>Mon profil</h3>

	


<form method="POST" action=ServletInscription>

<c:if test="${isPseudoUsed }">

         <p class="incorrect">Pseudo déjà utilisé</p>

    </c:if>


<c:if test="${isEmailUsed}">

<p class="incorrect">Email déjà utilisé</p>

    </c:if>

        <div>
            <label for="pseudo">Pseudo :</label>
            <input type="text" name="pseudo" id="pseudo" >
           
        </div>
        <div>
            <label for="name">Nom :</label>
            <input type="text" name="nom" id="name" >
        </div>
    </div>
    <div>
        <div>
            <label for="prenom">Prénom :</label>
            <input type="text" name="prenom" id="prenom" >
        </div>
        <div>
            <label for="email">Email :</label>
            <input type="email" name="email" id="email" >
        </div>
    </div>
    <div>
        <div>
            <label for="telephone">Teléphone :</label>
            <input type="tel" name="telephone" id="telephone" >
        </div>
        <div>
            <label for="rue">Rue :</label>
            <input type="text" name="rue" id="rue" >
        </div>
    </div>
    <div>
        <div>
            <label for="codePostal">Code postal  :</label>
            <input type="text" name="codePostal" id="codePostal" >
        </div>
        <div>
            <label for="ville">Ville :</label>
            <input type="text" name="ville" id="ville" >
        </div>
    </div>
    <div>
        <div>
            <label for="motDePasse">Mot de passe :</label>
            <input type="password" name="motDePasse" id="motDePasse" >
        </div>
        <div>
            <label for="confirmationMotDePasse">Confirmation :</label>
            <input type="password" name="confirmationMotDePasse" id="confirmationMotDePasse" >
        </div>
    </div>
    <div>
        <div>
            <input type="submit" value="Créer" name="creerUnCompte" class="btn btn-success"/>
        </div>
        <div>
            <a href="accueil" class="btn btn-success">Annuler</a>
        </div>
        </div>
        
    
</form>



</body>
</html>