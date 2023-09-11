package fr.eni.javaee.enchere.dal;

import fr.eni.javaee.enchere.bo.Article;
import fr.eni.javaee.enchere.bo.Retrait;

public interface RetraitDAO {
	
	public Retrait selectById(int noArticle);
	
	public void insertRetrait(int noArticle, Retrait retrait);

}
