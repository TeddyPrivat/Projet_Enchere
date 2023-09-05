package fr.eni.javaee.enchere.bll;

import java.util.List;

import fr.eni.javaee.enchere.bo.Categorie;

public class CategorieManager {
	
	private static CategorieManager instance;
	
	public static CategorieManager getInstance() {
		if(instance == null) {
			instance = new CategorieManager(); 
		}
		return instance;
	}
	
	private CategorieManager() {};
	
	public List<Categorie> selectAll(){
		return DAOFactory.getCategorieDAO().selectAll();
	}

}
