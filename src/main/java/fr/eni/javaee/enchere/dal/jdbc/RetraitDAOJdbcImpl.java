package fr.eni.javaee.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.javaee.enchere.bo.Retrait;
import fr.eni.javaee.enchere.dal.ConnectionProvider;
import fr.eni.javaee.enchere.dal.RetraitDAO;

public class RetraitDAOJdbcImpl implements RetraitDAO{
	
	private final static String SELECT_BY_ID = "SELECT ARTICLES.no_article, rue, code_postal, ville FROM  ARTICLES + "
			+ " LEFT JOIN RETRAITS ON ARTICLES.no_article = RETRAITS.no_article WHERE ARTICLES.no_article = ?;";
	
	@Override
	public Retrait selectById(int noArticle) {
		Retrait retrait = null;
		
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, noArticle);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String rue = rs.getString("rue");
				String codePostal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				retrait = new Retrait(rue, codePostal, ville);	
			}
			
			pstmt.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return retrait;
	}

}
