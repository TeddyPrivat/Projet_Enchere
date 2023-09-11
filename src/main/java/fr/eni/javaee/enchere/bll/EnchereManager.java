package fr.eni.javaee.enchere.bll;

import java.time.LocalDate;
import java.util.List;

import fr.eni.javaee.enchere.bo.Article;
import fr.eni.javaee.enchere.bo.Categorie;
import fr.eni.javaee.enchere.bo.Enchere;
import fr.eni.javaee.enchere.bo.Retrait;
import fr.eni.javaee.enchere.bo.Utilisateur;

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
	
	public Enchere insertNouvelleVente(Enchere nouvelleVente) {
		DAOFactory.getEnchereDAO().insertNouvelleVente(nouvelleVente);
		return nouvelleVente;
	}
	
	public void insertArticle(Article article, Utilisateur vendeur, Retrait retrait) {
		int noVendeur = vendeur.getNoUtilisateur();
		DAOFactory.getRetraitDAO().insertRetrait(article.getNoArticle(), retrait);
		DAOFactory.getEnchereDAO().insertArticle(article, noVendeur, retrait);
	}
	
}
