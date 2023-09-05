package fr.eni.javaee.enchere.servlets;

import java.io.IOException;
import java.util.List;

import fr.eni.javaee.enchere.bll.CategorieManager;
import fr.eni.javaee.enchere.bo.Categorie;
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

		doGet(request, response);
	}

}
