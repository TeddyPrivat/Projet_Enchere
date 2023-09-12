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
	
	public Utilisateur selectInfoUtilisateur(int no_utilisateur) {
		return DAOFactory.getUtilisateurDAO().selectInfoUtilisateur(no_utilisateur);
		
	}
	
	public void updateInfoUtilisateur(int no_utilisateur, String pseudo, String nom, String prenom, String email,String telephone, 
			String rue,	String codePostal, String ville) {
		DAOFactory.getUtilisateurDAO().updateInfoUtilisateur(no_utilisateur,pseudo,nom,prenom,email,telephone,rue,codePostal,ville);
	}
	
	public boolean checkIfPseudoIsUsed(String pseudo) {
		return DAOFactory.getUtilisateurDAO().checkIfPseudoIsUsed(pseudo);
	}
	
	public boolean checkIfEmailIsUsed(String email) {
		return DAOFactory.getUtilisateurDAO().checkIfEmailIsUsed(email);
	}
}
