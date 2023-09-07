package fr.eni.javaee.enchere.servlets;

import java.io.IOException;
import java.util.List;

import fr.eni.javaee.enchere.bll.CategorieManager;
import fr.eni.javaee.enchere.bll.EnchereManager;
import fr.eni.javaee.enchere.bo.Categorie;
import fr.eni.javaee.enchere.bo.Enchere;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<Categorie> categories;
	
	public void init() throws ServletException{
		categories = CategorieManager.getInstance().selectAll();
		this.getServletContext().setAttribute("categories", categories);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Enchere> encheres = EnchereManager.getInstance().selectAllEncheresEnCours();
		encheres.forEach(c -> System.out.println(c.toString()));
		int categorieSelectionne = Integer.valueOf(request.getParameter("categorie"));
		Categorie categorieAffichage = categories.stream().filter(c -> c.getNoCategorie() == categorieSelectionne).findFirst().get();
		System.out.println(categorieAffichage + "lolololloollollollollolo");
		request.setAttribute("categorieAffichage", categorieAffichage);

		
		request.setAttribute("encheres", encheres);

		doGet(request, response);
	}

}
