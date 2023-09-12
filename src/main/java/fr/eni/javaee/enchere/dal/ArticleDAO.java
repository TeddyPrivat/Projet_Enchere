package fr.eni.javaee.enchere.dal;

import fr.eni.javaee.enchere.bo.Article;
import fr.eni.javaee.enchere.bo.Retrait;

public interface ArticleDAO {
	
	public void insertArticle(Article article, int vendeur, Retrait retrait);

}
