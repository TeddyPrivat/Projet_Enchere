package fr.eni.javaee.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.javaee.enchere.bo.Utilisateur;
import fr.eni.javaee.enchere.dal.ConnectionProvider;
import fr.eni.javaee.enchere.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO{

	private final static String SELECT_USER_IF_EXIST = "SELECT mot_de_passe FROM UTILISATEURS WHERE ((pseudo=? OR email=?) AND mot_de_passe=?);";
	private final static String INSERT_UTILISATEUR = "";
	@Override
	public boolean selectByIdentifiant(String identifiant,String mdp) {
		boolean estConnecte = false;
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_USER_IF_EXIST);
			pstmt.setString(1, identifiant);	//pseudo
			pstmt.setString(2, identifiant);	// ou email
			pstmt.setString(3, mdp);
			ResultSet rs = pstmt.executeQuery();
			
			if(!rs.next()) {	//si la requête ne renvoie aucune ligne 
				estConnecte = false;
			}else {	//si elle en renvoie une -> cet utilisateur peut se connecter
				estConnecte = true; //à récupérer si on veut savoir si nous sommes connectés
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estConnecte;
	}

	@Override
	public void insertUtilisateur(Utilisateur utilisateur) {
		
		
	}

	
}
