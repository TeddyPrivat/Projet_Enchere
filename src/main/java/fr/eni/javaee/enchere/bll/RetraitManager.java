package fr.eni.javaee.enchere.bll;

import fr.eni.javaee.enchere.bo.Article;
import fr.eni.javaee.enchere.bo.Retrait;

public class RetraitManager {
	
	private static RetraitManager instance;
	
	public static RetraitManager getInstance() {
		if(instance == null) {
			instance = new RetraitManager();
		}
		return instance;
	}
	
	public RetraitManager() {};
	
	public Article selectById(int noArticle) {
		return DAOFactory.getRetraitDAO().selectById(noArticle);
	}
	
	public void insertRetrait(String rue, int codePostal, String ville, int noArticle) {
		Retrait retrait = new Retrait(rue, codePostal, ville);
		DAOFactory.getRetraitDAO().insertRetrait(retrait, noArticle);
	}

}
