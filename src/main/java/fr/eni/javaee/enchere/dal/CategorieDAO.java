package fr.eni.javaee.enchere.dal;

import java.util.List;

import fr.eni.javaee.enchere.bo.Categorie;

public interface CategorieDAO {
	
	List<Categorie> selectAll();

}
