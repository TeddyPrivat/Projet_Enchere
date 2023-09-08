package fr.eni.javaee.enchere.dal;

import java.util.List;

import fr.eni.javaee.enchere.bo.Enchere;
import fr.eni.javaee.enchere.bo.Utilisateur;

public interface EnchereDAO {
	
	public List<Enchere> selectAllEncheres();

}
