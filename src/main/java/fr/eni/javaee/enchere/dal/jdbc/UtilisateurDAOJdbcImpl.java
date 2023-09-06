package fr.eni.javaee.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.javaee.enchere.dal.ConnectionProvider;
import fr.eni.javaee.enchere.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO{

	private final static String SELECT_MDP = "SELECT mot_de_passe FROM UTILISATEURS WHERE pseudo=? OR email=? AND mot_de_passe=?;";

	@Override
	public String selectByIdentifiant(String identifiant,String mdp) {
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_MDP);
			pstmt.setString(1, identifiant);
			pstmt.setString(2, identifiant);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mdp = rs.getString("mot_de_passe");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mdp;
	}

	
}
