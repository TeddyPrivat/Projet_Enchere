package fr.eni.javaee.enchere.dal;

import java.util.List;

import fr.eni.javaee.enchere.bo.Article;
import fr.eni.javaee.enchere.bo.Enchere;
import fr.eni.javaee.enchere.bo.Retrait;

public interface EnchereDAO {
	
	public List<Enchere> selectAllEncheres();
	
	public Article selectNomArticleLike(String articleNom);
	
	public void insertNouvelleVente(Enchere nouvelleVente);
	
	public void insertArticle(Article article, int vendeur, Retrait retrait);

}
