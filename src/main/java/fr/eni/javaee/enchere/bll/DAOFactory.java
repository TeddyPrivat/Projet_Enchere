package fr.eni.javaee.enchere.bll;

import fr.eni.javaee.enchere.dal.CategorieDAO;
import fr.eni.javaee.enchere.dal.jdbc.CategorieDAOJdbcImpl;

public class DAOFactory {

	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOJdbcImpl();
	}
}
