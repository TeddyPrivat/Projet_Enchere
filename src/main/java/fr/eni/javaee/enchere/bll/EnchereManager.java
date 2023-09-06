package fr.eni.javaee.enchere.bll;

import java.util.List;

import fr.eni.javaee.enchere.bo.Enchere;
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
	
	public List<Enchere> selectById(Utilisateur utilisateur){
		return DAOFactory.getEnchereDAO().selectById(utilisateur);
	}

}
