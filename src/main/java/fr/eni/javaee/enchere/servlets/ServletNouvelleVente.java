package fr.eni.javaee.enchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import fr.eni.javaee.enchere.bll.ArticleManager;
import fr.eni.javaee.enchere.bll.CategorieManager;
import fr.eni.javaee.enchere.bll.EnchereManager;
import fr.eni.javaee.enchere.bll.RetraitManager;
import fr.eni.javaee.enchere.bll.UtilisateurManager;
import fr.eni.javaee.enchere.bo.Article;
import fr.eni.javaee.enchere.bo.Categorie;
import fr.eni.javaee.enchere.bo.Enchere;
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
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/nouvellevente.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session = request.getSession();
		int noVendeur = (int)session.getAttribute("estConnecte");
		
		String nomArticle = request.getParameter("article");
		System.out.println("Nom : " + nomArticle);
		String description = request.getParameter("description");
		System.out.println("Description : " + description);
		int noCategorie = Integer.valueOf(request.getParameter("categorie-select"));
		System.out.println("Numéro de la catégorie : " + noCategorie);
		int miseAPrix = Integer.valueOf(request.getParameter("prix"));
		System.out.println("Prix : " + miseAPrix);
		int prixVente = Integer.valueOf(request.getParameter("prix"));
		System.out.println("Prix de vente : " + prixVente);
		LocalDate dateDebutEnchere = LocalDate.parse(request.getParameter("debutEnchere"));
		System.out.println("Début des enchères : " + dateDebutEnchere);
		LocalDate dateFinEnchere = LocalDate.parse(request.getParameter("finEnchere"));
		System.out.println("Fin des enchères : " + dateFinEnchere);
		String rue = request.getParameter("rue");
		System.out.println("Rue : " + rue);
		String codePostal = request.getParameter("codePostal");
		System.out.println("Code postal : " + codePostal);
		String ville = request.getParameter("ville");
		System.out.println("Ville : " + ville);
		
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
