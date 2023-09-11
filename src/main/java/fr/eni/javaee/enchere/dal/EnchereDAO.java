package fr.eni.javaee.enchere.dal;

import java.util.List;

import fr.eni.javaee.enchere.bo.Article;
import fr.eni.javaee.enchere.bo.Enchere;

public interface EnchereDAO {
	
	public List<Enchere> selectAllEncheres();
	
	public Article selectNomArticleLike(String articleNom);

}
