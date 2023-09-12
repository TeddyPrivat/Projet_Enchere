package fr.eni.javaee.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.javaee.enchere.bo.Article;
import fr.eni.javaee.enchere.bo.Enchere;
import fr.eni.javaee.enchere.bo.Retrait;
import fr.eni.javaee.enchere.dal.ArticleDAO;
import fr.eni.javaee.enchere.dal.ConnectionProvider;

public class ArticleDAOJdbcImpl implements ArticleDAO{
	
	private final static String INSERT_ARTICLE = "INSERT INTO ARTICLES (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	private final static String INSERT_RETRAIT = "INSERT INTO RETRAITS(no_article, rue, code_postal, ville) VALUES (?, ?, ?, ?);";
	private final static String INSERT_ENCHERE = "INSERT INTO ENCHERES (date_enchere, montant_enchere, no_article, no_vendeur) VALUES (?, ?, ?, ?);";
	
	@Override
	public void insertArticle(Article article, int vendeur, Retrait retrait) {
		
		try(Connection cnx = ConnectionProvider.getConnection()){
			try {
				cnx.setAutoCommit(false);
				
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, article.getNomArticle());
				pstmt.setString(2, article.getDescription());
				pstmt.setDate(3, Date.valueOf(article.getDateDebutEncheres()));
				pstmt.setDate(4, Date.valueOf(article.getDateFinEncheres()));
				pstmt.setInt(5, article.getMiseAPrix());
				pstmt.setInt(6, article.getPrixVente());
				pstmt.setInt(7, vendeur);
				pstmt.setInt(8, article.getCategorie().getNoCategorie());
				pstmt.executeUpdate();
			
				ResultSet rs = pstmt.getGeneratedKeys();
				
				if(rs.next()) {
					int noArticle = rs.getInt(1);
					article.setNoArticle(noArticle);
					
					pstmt = cnx.prepareStatement(INSERT_RETRAIT);
					pstmt.setInt(1, noArticle);
					pstmt.setString(2, retrait.getRue());
					pstmt.setString(3, retrait.getCodePostal());
					pstmt.setString(4, retrait.getVille());
					pstmt.executeUpdate();
					
					Enchere enchere = new Enchere();
					enchere.setArticle(article);
					pstmt = cnx.prepareStatement(INSERT_ENCHERE);
					pstmt.setDate(1, Date.valueOf(enchere.getArticle().getDateDebutEncheres()));
					pstmt.setInt(2, enchere.getArticle().getMiseAPrix());
					pstmt.setInt(3, noArticle);
					pstmt.setInt(4, vendeur);
					pstmt.executeUpdate();
					
				}
			
			cnx.commit();
			}catch(SQLException e) {
				e.printStackTrace();
				cnx.rollback();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
