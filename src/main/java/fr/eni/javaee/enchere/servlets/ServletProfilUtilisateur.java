package fr.eni.javaee.enchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

import java.io.IOException;

import fr.eni.javaee.enchere.bll.UtilisateurManager;
import fr.eni.javaee.enchere.bo.Utilisateur;


public class ServletProfilUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noUtilisateurVendeur = 0;
		
		boolean afficheBouton = false;
		Utilisateur utilisateur = null;

		HttpSession session = request.getSession();
		if(session != null) {
			int noUtilisateur = ((int) session.getAttribute("estConnecte"));
			
			if(request.getParameter("noUtilisateur") != null) {
				noUtilisateurVendeur = Integer.valueOf(request.getParameter("noUtilisateur")); //récupère l'ID du vendeur

				if (noUtilisateurVendeur != noUtilisateur) {
					utilisateur = UtilisateurManager.getInstance().selectInfoUtilisateur(noUtilisateurVendeur);

				}else {
					utilisateur = UtilisateurManager.getInstance().selectInfoUtilisateur(noUtilisateur);
					afficheBouton = true;

				}
			}
			else {
				utilisateur = UtilisateurManager.getInstance().selectInfoUtilisateur(noUtilisateur);
				afficheBouton = true;
			}
		}
		
		
		System.out.println("idSession " + session.getAttribute("estConnecte"));

		request.setAttribute("afficheBouton", afficheBouton);
		
		request.setAttribute("utilisateur", utilisateur);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/profilutilisateur.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
