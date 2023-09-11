package fr.eni.javaee.enchere.bll;

import java.util.List;

import fr.eni.javaee.enchere.bo.Article;
import fr.eni.javaee.enchere.bo.Enchere;

public class EnchereManager {
	
	private static EnchereManager instance;
	
	public static EnchereManager getInstance() {
		if(instance == null) {
			instance = new EnchereManager();
		}
		return instance;
	}
	
	private EnchereManager() {};
	
	public List<Enchere> selectAllEncheres(){
		return DAOFactory.getEnchereDAO().selectAllEncheres();
	}
	
	public Article selectNomArticleLike(String articleNom) {
		return DAOFactory.getEnchereDAO().selectNomArticleLike(articleNom);
	}
	
}
