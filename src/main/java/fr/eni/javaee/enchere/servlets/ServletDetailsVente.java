package fr.eni.javaee.enchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.javaee.enchere.bll.ArticleManager;
import fr.eni.javaee.enchere.bo.Article;


public class ServletDetailsVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean boutonEncherir = false;
		Article articleEnVente = null;
		
		HttpSession session = request.getSession();
		int noVendeur = (int) session.getAttribute("estConnecte");

		if(request.getParameter("noArticle") != null) {
			int noArticleEnVente = Integer.valueOf(request.getParameter("noArticle"));
			articleEnVente =  ArticleManager.getInstance().selectByIdArticle(noArticleEnVente);
			
			if(articleEnVente.getUtilisateur().getNoUtilisateur() != noVendeur) {
				boutonEncherir = true;
			}
			
		}
		request.setAttribute("articleEnVente", articleEnVente);
		request.setAttribute("boutonEncherir", boutonEncherir);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/detailsvente.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
