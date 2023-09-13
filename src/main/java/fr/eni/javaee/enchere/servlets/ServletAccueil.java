package fr.eni.javaee.enchere.servlets;

import java.io.IOException;
import java.util.List;

import fr.eni.javaee.enchere.bll.CategorieManager;
import fr.eni.javaee.enchere.bll.EnchereManager;
import fr.eni.javaee.enchere.bo.Categorie;
import fr.eni.javaee.enchere.bo.Enchere;
import fr.eni.javaee.enchere.bo.Article;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<Categorie> categories;
	List<Enchere> encheres;
	HttpSession session = null;
	
	public void init() throws ServletException{
		categories = CategorieManager.getInstance().selectAll();
		this.getServletContext().setAttribute("categories", categories);
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();
		if(session != null) {
			session.getAttribute("estConnecte");
		}
		encheres = EnchereManager.getInstance().selectAllEncheres();
		request.setAttribute("encheres", encheres);
		// if filtre 
		/*TODO recherche par nom similaire
		if(request.getParameter("rechercheArticle") != null){
			String rechercheArticle = (String) session.getAttribute("rechercheArticle");
			// rajoute tes filtre sur
			//encheres = contientMotDeLaRecherche(encheres, rechercheArticle);
			
		}
		*/
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();
		
		if(session.getAttribute("estConnecte") != null) {
			int coAManipuler = (int) session.getAttribute("estConnecte");
			request.setAttribute("coAManipuler", coAManipuler);
		}
		
		if(request.getParameter("deconnexion") != null){
			session.invalidate();
		}
		
		if(request.getParameter("rechercheArticle") != null) {
			String nomArticleSaisi = request.getParameter("rechercheArticle");
			//Article nomArticleSaisiLike = EnchereManager.getInstance().selectNomArticleLike(nomArticleSaisi);
			request.setAttribute("nomArticleSaisi", nomArticleSaisi);
		}
		
		if(request.getParameter("achats") != null) {
			int achat = Integer.valueOf(request.getParameter("achats"));
			request.setAttribute("achat", achat);
		}
		
		if(request.getParameter("vente") != null){
			int vente = Integer.valueOf(request.getParameter("ventes"));
			request.setAttribute("vente", vente);
		}
		
		if(request.getParameter("categorie") != null) {
			int categorieSelectionne = Integer.valueOf(request.getParameter("categorie"));
			Categorie categorieAffichage = categories.stream().filter(c -> c.getNoCategorie() == categorieSelectionne).findFirst().get();
			request.setAttribute("categorieAffichage", categorieAffichage);
		}

		doGet(request, response);
	}

}
