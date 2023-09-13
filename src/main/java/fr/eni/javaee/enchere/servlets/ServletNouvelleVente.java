package fr.eni.javaee.enchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import fr.eni.javaee.enchere.bll.ArticleManager;
import fr.eni.javaee.enchere.bll.CategorieManager;
import fr.eni.javaee.enchere.bll.UtilisateurManager;
import fr.eni.javaee.enchere.bo.Article;
import fr.eni.javaee.enchere.bo.Categorie;
import fr.eni.javaee.enchere.bo.Retrait;
import fr.eni.javaee.enchere.bo.Utilisateur;


public class ServletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<Categorie> categories;
	HttpSession session = null;
	
	public void init() throws ServletException{
		categories = CategorieManager.getInstance().selectAll();
		this.getServletContext().setAttribute("categories", categories);
	}

       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session = request.getSession();
		int noVendeur = (int)session.getAttribute("estConnecte");
		Utilisateur adresseVendeur = UtilisateurManager.getInstance().selectInfoUtilisateur(noVendeur);
		request.setAttribute("adresseVendeur", adresseVendeur);
		
		boolean boutonModifier = false;
		boolean boutonSupprimer = false;
		boutonModifier = true;
		boutonSupprimer = true;
		request.setAttribute("boutonModification", boutonModifier);
		request.setAttribute("boutonSupprimer", boutonSupprimer);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/nouvellevente.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session = request.getSession();
		int noVendeur = (int)session.getAttribute("estConnecte");
		
		String nomArticle = request.getParameter("article");
		String description = request.getParameter("description");
		int noCategorie = Integer.valueOf(request.getParameter("categorie-select"));
		int miseAPrix = Integer.valueOf(request.getParameter("prix"));
		int prixVente = Integer.valueOf(request.getParameter("prix"));
		LocalDate dateDebutEnchere = LocalDate.parse(request.getParameter("debutEnchere"));
		LocalDate dateFinEnchere = LocalDate.parse(request.getParameter("finEnchere"));
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		
		Categorie categorie = null;
		for(Categorie c : categories) {
			if(c.getNoCategorie() == noCategorie) {
				categorie = c;
			}
		}
		
		Utilisateur vendeur = UtilisateurManager.getInstance().selectInfoUtilisateur(noVendeur);
		Article nouveauArticle = new Article(nomArticle, description, dateDebutEnchere, dateFinEnchere, miseAPrix, prixVente, categorie, vendeur);
		Retrait retrait = new Retrait(rue, codePostal, ville);
		ArticleManager.getInstance().insertArticle(nouveauArticle, vendeur, retrait);
		
		request.setAttribute("nouveauArticle", nouveauArticle);
		
		doGet(request, response);
	}

}
