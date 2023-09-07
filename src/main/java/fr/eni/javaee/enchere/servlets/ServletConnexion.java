package fr.eni.javaee.enchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.javaee.enchere.bll.DAOFactory;


public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = request.getParameter("username");	//recuperation des données entrées dans le formulaire
		String motDePasse = request.getParameter("pass");
		boolean estConnecte = DAOFactory.getUtilisateurDAO().selectByIdentifiant(identifiant,motDePasse);	//on récupère un boolean pour savoir s'il est connecté ou non
		
		request.setAttribute("estConnecte", estConnecte); //récupère le booléen pour afficher ou non le message en cas d'erreur dans la JSP
		if(estConnecte) {	//si on est connecté -> on se redirige vers la page d'accueil version connecté
			HttpSession session = request.getSession();
	        
	        //récupère l'id de la couleur choisie
	        session.setAttribute("estConnecte", estConnecte);//on l'enregistre en session
	        
	        
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
			rd.forward(request, response);
		}else {	//sinon on recharge la jsp de la connexion
			doGet(request, response);
		}
		
	}
	
	

}
