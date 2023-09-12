package fr.eni.javaee.enchere.bll;

import fr.eni.javaee.enchere.bo.Article;
import fr.eni.javaee.enchere.bo.Retrait;
import fr.eni.javaee.enchere.bo.Utilisateur;

public class ArticleManager {
	
	private static ArticleManager instance;
	
	public static ArticleManager getInstance() {
		if(instance == null) {
			instance = new ArticleManager();
		}
		return instance;
	}
	
	private ArticleManager() {};
	
	public void insertArticle(Article article, Utilisateur vendeur, Retrait retrait) {
		int noVendeur = vendeur.getNoUtilisateur();
		DAOFactory.getArticleDAO().insertArticle(article, noVendeur, retrait);
	}
	
	public Article selectByIdArticle(int noArticle) {
		return DAOFactory.getArticleDAO().selectByIdArticle(noArticle);
	}
	
	public void faireEnchere(int noArticle) {
		DAOFactory.getArticleDAO().faireEnchere(noArticle);
	}

}
