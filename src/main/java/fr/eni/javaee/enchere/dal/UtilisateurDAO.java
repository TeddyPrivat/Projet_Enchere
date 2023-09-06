package fr.eni.javaee.enchere.dal;

public interface UtilisateurDAO {

	public boolean selectByIdentifiant(String identifiant,String mdp);
}
