package fr.eni.javaee.enchere.dal;

import fr.eni.javaee.enchere.bo.Utilisateur;

public interface UtilisateurDAO {

	public int selectByIdentifiant(String identifiant,String mdp);
	
	public void insertUtilisateur(Utilisateur utilisateur);
	
	public void deleteUtilisateur(int no_utilisateur );
	
	public Utilisateur selectInfoUtilisateur(int no_utilisateur);
	
	public void updateInfoUtilisateur(int no_utilisateur);
	
	public boolean checkIfPseudoIsUsed(String pseudo);
	
	public boolean checkIfEmailIsUsed(String email);
}
