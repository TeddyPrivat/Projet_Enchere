package fr.eni.javaee.enchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.javaee.enchere.bll.UtilisateurManager;
import fr.eni.javaee.enchere.bo.Utilisateur;


public class ServletModificationDeProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Utilisateur utilisateur = null;
    @Override
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	int idUser = ((int)session.getAttribute("estConnecte")); // on récupère l'id de l'user par l'attribut de session
    	utilisateur = UtilisateurManager.getInstance().selectInfoUtilisateur(idUser); //on récupère les infos de l'user
    	System.out.println(utilisateur);
    	//on récupère les données que nous allons pré-remplir
    	String pseudo = utilisateur.getPseudo();
    	String nom = utilisateur.getNom();
    	String prenom = utilisateur.getPrenom();
    	String email = utilisateur.getEmail();
    	String telephone = utilisateur.getTelephone();
    	String rue = utilisateur.getRue();
    	String codePostal = utilisateur.getCodePostal();
    	String ville = utilisateur.getVille();
    	String motDePasse = utilisateur.getMotDePasse();
    	
    	request.setAttribute("pseudo", pseudo);
    	request.setAttribute("nom", nom);
    	request.setAttribute("prenom", prenom);
    	request.setAttribute("email", email);
    	request.setAttribute("telephone", telephone);
    	request.setAttribute("rue", rue);
    	request.setAttribute("codePostal", codePostal);
    	request.setAttribute("ville", ville);
    	request.setAttribute("motDePasse", motDePasse);
    	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modificationdeprofil.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getAttribute("motDePasse"); // récupération du mot de passe de la BDD
		System.out.println("mot de passe de la bdd " + request.getAttribute("motDePasse"));
		
		String motDePasseSaisi = request.getParameter("motDePasse"); //récupération du mot de passe saisi
		
		if(motDePasseSaisi.equals(request.getAttribute("motDePasse"))) {	//comparaison du mot de passe saisi et de celui en BDD
			System.out.println("Mot de passe correct, vous pouvez changer");
		}else {
			System.out.println("Mot de passe saisi incorrect");
		}
		
		doGet(request, response);
	}

}

