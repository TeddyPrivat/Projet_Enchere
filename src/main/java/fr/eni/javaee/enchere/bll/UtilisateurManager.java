package fr.eni.javaee.enchere.bll;

public class UtilisateurManager {

private static UtilisateurManager instance;
	
	public static UtilisateurManager getInstance() {
		if(instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}
	
	public UtilisateurManager() {};
	
	public boolean selectByIdentifiant(String identifiant,String mdp) {
		return DAOFactory.getUtilisateurDAO().selectByIdentifiant(identifiant,mdp);
	}
}
