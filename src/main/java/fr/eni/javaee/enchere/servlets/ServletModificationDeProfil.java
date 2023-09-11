package fr.eni.javaee.enchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
    	int idUser = ((int)session.getAttribute("estConnecte"));
    	System.out.println(("idUser : " + idUser));
    	
    	
    	utilisateur = UtilisateurManager.getInstance().selectInfoUtilisateur(idUser);
    	System.out.println(utilisateur);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modificationdeprofil.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

