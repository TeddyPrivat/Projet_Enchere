package fr.eni.javaee.enchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.javaee.enchere.bll.DAOFactory;


public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get attribute " + request.getAttribute("estConnecte"));
		System.out.println("get " + request.getParameter("estConnecte"));
		System.out.println(request.getParameter("estConnecte"));
		
		
		//boolean estConnecte = Boolean.valueOf(request.getAttribute("estConnecte"));
		/*
		System.out.println("bool " + estConnecte);
		
		if(estConnecte == false) {
			
		}*/
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = request.getParameter("username");
		String motDePasse = request.getParameter("pass");
		
		boolean estConnecte = DAOFactory.getUtilisateurDAO().selectByIdentifiant(identifiant,motDePasse);
		request.setAttribute("estConnecte", estConnecte);
		doGet(request, response);
	}
	
	

}
