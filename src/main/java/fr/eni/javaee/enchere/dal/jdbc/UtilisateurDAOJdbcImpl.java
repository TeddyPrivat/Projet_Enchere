package fr.eni.javaee.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.javaee.enchere.dal.ConnectionProvider;
import fr.eni.javaee.enchere.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO{

	private final static String SELECT_MDP = "SELECT mot_de_passe FROM UTILISATEURS WHERE ((pseudo=? OR email=?) AND mot_de_passe=?);";

	@Override
	public boolean selectByIdentifiant(String identifiant,String mdp) {
		boolean estConnecte = false;
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_MDP);
			pstmt.setString(1, identifiant);
			pstmt.setString(2, identifiant);
			pstmt.setString(3, mdp);
			ResultSet rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				estConnecte = false;
			}else {
				estConnecte = true; //à récupérer si on veut savoir si nous sommes connectés
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estConnecte;
	}

	
}
