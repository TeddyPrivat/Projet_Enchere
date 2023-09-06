package fr.eni.javaee.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.javaee.enchere.bo.Article;
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
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return retrait;
	}
	private final static String INSERT_RETRAIT = "INSERT INTO RETRAITS(no_article, rue, code_postal, ville) VALUES (?, ?, ?);";

	@Override
	public void insertRetrait(Retrait retrait, int noArticle) {
		
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_RETRAIT);
			pstmt.setInt(1, noArticle);
			pstmt.setString(2, retrait.getRue());
			pstmt.setString(3, retrait.getCodePostal());
			pstmt.setString(4, retrait.getVille());
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
