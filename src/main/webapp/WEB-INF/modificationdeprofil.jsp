<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modification de profil</title>
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
    </style>
</head>
<body>

<div>
        <a href="ServletAccueil"><img src="images/encheres.png"
            alt="logo qui renvoie à l'accueil" /></a>

    </div>
    <br>
    
      <h3>Mon profil</h3>

<form method="POST" action=Servletinscription>
    <div>
        <div>
            <label for="pseudo">Pseudo :</label>
            <input type="text" name="pseudo" id="pseudo" >
        </div>
        <div>
            <label for="nom">Nom :</label>
            <input type="text" name="nom" id="nom" >
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
            <label for="codePostal">Code postale  :</label>
            <input type="text" name="codePostal" id="codePostal" >
        </div>
        <div>
            <label for="ville">Ville :</label>
            <input type="text" name="ville" id="ville" >
        </div>
    </div>
    <div>
        <div>
            <label for="motDePasse">Mot de passe actuel :</label>
            <input type="password" name="motDePasse" id="motDePasseActuel" >
        </div>
        
        <div>
            <label for="motDePasse">Nouveau Mot de passe :</label>
            <input type="password" name="motDePasse" id="nouveauMotDePasse" >
        </div>
        
        <div>
            <label for="confirmationMotDePasse">Confirmation :</label>
            <input type="password" name="confirmationMotDePasse" id="confirmationMotDePasse" >
        </div>
    </div>
    <div>
        
        <div>
            <a href="">Enregistrer</a>
        </div>
        <div>
            <a href="">Supprimer mon compte</a>
        </div>
    </div>
</form>
</body>
</html>