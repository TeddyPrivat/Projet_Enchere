package fr.eni.javaee.enchere.dal;

import fr.eni.javaee.enchere.bo.Article;
import fr.eni.javaee.enchere.bo.Retrait;

public interface RetraitDAO {
	
	public Article selectById(int noArticle);
	
	public void insertRetrait(Retrait retrait, int noArticle);

}
