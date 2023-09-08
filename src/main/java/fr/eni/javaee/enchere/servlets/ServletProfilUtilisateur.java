package fr.eni.javaee.enchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.javaee.enchere.bll.UtilisateurManager;
import fr.eni.javaee.enchere.bo.Utilisateur;


public class ServletProfilUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("noUtilisateur"); //récupère l'ID du vendeur
		int noUtilisateur = Integer.valueOf(request.getParameter("noUtilisateur"));
		//System.out.println(noUtilisateur);
		
		Utilisateur utilisateur = UtilisateurManager.getInstance().selectInfoUtilisateur(noUtilisateur);
		/*
		Utilisateur utilisateur = UtilisateurManager.getInstance().selectInfoUtilisateur(2);
		int iduser1 = UtilisateurManager.getInstance().selectByIdentifiant(utilisateur.getPseudo(),utilisateur.getMotDePasse());
		utilisateur = UtilisateurManager.getInstance().selectInfoUtilisateur(iduser1);
		System.out.println(iduser1+"id");
		System.out.println("coucou"+utilisateur);
		request.setAttribute("utilisateur", utilisateur);*/
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/profilutilisateur.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
