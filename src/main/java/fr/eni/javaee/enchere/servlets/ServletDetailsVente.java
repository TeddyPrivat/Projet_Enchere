package fr.eni.javaee.enchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.enchere.bll.ArticleManager;
import fr.eni.javaee.enchere.bll.DAOFactory;
import fr.eni.javaee.enchere.bll.EnchereManager;
import fr.eni.javaee.enchere.bll.UtilisateurManager;
import fr.eni.javaee.enchere.bo.Article;
import fr.eni.javaee.enchere.bo.Enchere;
import fr.eni.javaee.enchere.bo.Utilisateur;


public class ServletDetailsVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    Article articleEnVente = null;
    int noVendeur = 0;
    Enchere enchere = null;
    int creditPrec = 0;
    int creditAcheteur = 0;
    List<Enchere> encherisseurs = new ArrayList<>();
    
    public void init() throws ServletException{
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean boutonEncherir = false;
		
		HttpSession session = request.getSession();
		noVendeur = (int) session.getAttribute("estConnecte");

		if(request.getParameter("noArticle") != null) {
			int noArticleEnVente = Integer.valueOf(request.getParameter("noArticle"));
			articleEnVente =  ArticleManager.getInstance().selectByIdArticle(noArticleEnVente);
			
			if(articleEnVente.getUtilisateur().getNoUtilisateur() != noVendeur) {
				boutonEncherir = true;
				int noAcheteur = noVendeur;
				Utilisateur acheteur = UtilisateurManager.getInstance().selectInfoUtilisateur(noAcheteur);
				creditAcheteur = acheteur.getCredit();
				System.out.println("Crédit du Get: " + creditAcheteur);
				/*
				if(creditPrec == 0) {
					creditPrec = creditAcheteur;
					System.out.println("Initialisation crédit précédent : " + creditPrec);
				}else if(noAcheteur != articleEnVente.getEnchere().getAcheteur().getNoUtilisateur()){
					acheteur.setCredit(creditPrec);
					System.out.println("Crédit rendu en principe : " + acheteur.getCredit());
				}
				*/
			}

		}
		request.setAttribute("articleEnVente", articleEnVente);
		request.setAttribute("boutonEncherir", boutonEncherir);
		request.setAttribute("creditAcheteur", creditAcheteur);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/detailsvente.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noAcheteur = noVendeur;
		Utilisateur acheteur = UtilisateurManager.getInstance().selectInfoUtilisateur(noAcheteur);

		int proposition = Integer.valueOf(request.getParameter("proposition"));
		articleEnVente.setPrixVente(proposition);

		int noEnchere = articleEnVente.getEnchere().getNoEnchere();
		enchere = EnchereManager.getInstance().selectEncherebyId(noEnchere);
		enchere.setMontantEnchere(proposition);
		creditAcheteur = acheteur.getCredit() - proposition;
		acheteur.setCredit(creditAcheteur);
		enchere.setAcheteur(acheteur);
		
		encherisseurs.add(enchere);
		for(Enchere e : encherisseurs) {
			System.out.println(e.getAcheteur().getPseudo() + " " + e.getAcheteur().getCredit());
		}

		articleEnVente.setEnchere(enchere);
		DAOFactory.getArticleDAO().faireEnchere(articleEnVente);
		
		doGet(request, response);
	}

}
