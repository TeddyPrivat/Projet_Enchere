package fr.eni.javaee.enchere.servlets;

import java.io.IOException;
import java.util.List;

import fr.eni.javaee.enchere.bll.CategorieManager;
import fr.eni.javaee.enchere.bll.EnchereManager;
import fr.eni.javaee.enchere.bo.Categorie;
import fr.eni.javaee.enchere.bo.Enchere;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<Categorie> categories;
	HttpSession session = null;
	
	public void init() throws ServletException{
		categories = CategorieManager.getInstance().selectAll();
		this.getServletContext().setAttribute("categories", categories);
		
		List<Enchere> encheres = EnchereManager.getInstance().selectAllEncheresEnCours();
		this.getServletContext().setAttribute("encheres", encheres);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();

		//int estConnecte = (int) session.getAttribute("estConnecte");
		
		/*
		if(session.getAttribute("estConnecte") != null && deconnexion.equals("deconnexion")) {
			System.out.println("Je suis dans le if");
			session.invalidate();	
		}
		*/
		System.out.println("Je suis en dehors du if");
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();
		if(request.getParameter("deconnexion") != null){
			System.out.println("Je suis dans le if de la déco");
			session.invalidate();
		}
		
		if(request.getParameter("rechercheArticle") != null) {
			String nomArticleSaisi = request.getParameter("rechercheArticle");
			System.out.println(nomArticleSaisi);
			request.setAttribute("nomArticleSaisi", nomArticleSaisi);
		}
		
		if(request.getParameter("categorie") != null) {
			int categorieSelectionne = Integer.valueOf(request.getParameter("categorie"));
			Categorie categorieAffichage = categories.stream().filter(c -> c.getNoCategorie() == categorieSelectionne).findFirst().get();
			request.setAttribute("categorieAffichage", categorieAffichage);
		}

		doGet(request, response);
	}

}
