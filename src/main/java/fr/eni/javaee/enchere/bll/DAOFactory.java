package fr.eni.javaee.enchere.bll;

import fr.eni.javaee.enchere.dal.ArticleDAO;
import fr.eni.javaee.enchere.dal.CategorieDAO;
import fr.eni.javaee.enchere.dal.EnchereDAO;
import fr.eni.javaee.enchere.dal.RetraitDAO;
import fr.eni.javaee.enchere.dal.UtilisateurDAO;
import fr.eni.javaee.enchere.dal.jdbc.ArticleDAOJdbcImpl;
import fr.eni.javaee.enchere.dal.jdbc.CategorieDAOJdbcImpl;
import fr.eni.javaee.enchere.dal.jdbc.EnchereDAOJdbcImpl;
import fr.eni.javaee.enchere.dal.jdbc.RetraitDAOJdbcImpl;
import fr.eni.javaee.enchere.dal.jdbc.UtilisateurDAOJdbcImpl;

public class DAOFactory {

	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOJdbcImpl();
	}
	
	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOJdbcImpl();
	}
	
	public static RetraitDAO getRetraitDAO() {
		return new RetraitDAOJdbcImpl();
	}
	
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
	
	public static ArticleDAO getArticleDAO() {
		return new ArticleDAOJdbcImpl();
	}
}
