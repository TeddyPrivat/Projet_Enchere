package fr.eni.javaee.enchere.bll;

import fr.eni.javaee.enchere.bo.Utilisateur;

public class UtilisateurManager {

private static UtilisateurManager instance;
	
	public static UtilisateurManager getInstance() {
		if(instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}
	
	public UtilisateurManager() {};
	
	public int selectByIdentifiant(String identifiant,String mdp) {
		return DAOFactory.getUtilisateurDAO().selectByIdentifiant(identifiant,mdp);
	}
	
	public void insertUtilisateur(Utilisateur utilisateur) {
		 DAOFactory.getUtilisateurDAO().insertUtilisateur(utilisateur);
	}
	
	
	public void deleteUtilisateur(int no_utilisateur) {
		DAOFactory.getUtilisateurDAO().deleteUtilisateur(no_utilisateur);
	}
	
}
