package fr.eni.javaee.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.enchere.bll.ArticleManager;
import fr.eni.javaee.enchere.bll.EnchereManager;
import fr.eni.javaee.enchere.bll.UtilisateurManager;
import fr.eni.javaee.enchere.bo.Article;
import fr.eni.javaee.enchere.bo.Categorie;
import fr.eni.javaee.enchere.bo.Enchere;
import fr.eni.javaee.enchere.bo.Retrait;
import fr.eni.javaee.enchere.bo.Utilisateur;
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
	
	private final static String SELECT_BY_ID_ARTICLE = "SELECT * FROM ARTICLES AS a INNER JOIN UTILISATEURS AS u ON u.no_utilisateur = a.no_utilisateur INNER JOIN CATEGORIES AS c ON c.no_categorie = a.no_categorie INNER JOIN RETRAITS AS r ON r.no_article = a.no_article INNER JOIN ENCHERES AS e ON e.no_article = a.no_article WHERE a.no_article = ?;";

	@Override
	public Article selectByIdArticle(int noArticle) {
		Article article = null;
		
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID_ARTICLE);
			pstmt.setInt(1, noArticle);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String nomArticle = rs.getString("nom_article");
				String description = rs.getString("description");
				LocalDate finEnchere = rs.getDate("date_fin_encheres").toLocalDate();
				int prixInitial = rs.getInt("prix_initial");
				article = new Article(nomArticle, description, finEnchere, prixInitial);
				
				int noCategorie = rs.getInt("no_categorie");
				String libelle = rs.getString("libelle");
				Categorie categorie = new Categorie(noCategorie, libelle);
				article.setCategorie(categorie);

				int noUtilisateur = rs.getInt("no_utilisateur");
				String pseudo = rs.getString("pseudo");
				int credit = rs.getInt("credit");
				Utilisateur vendeur = new Utilisateur(noUtilisateur, pseudo, credit);
				article.setUtilisateur(vendeur);
				
				int noEnchere = rs.getInt("no_enchere");
				int montantEnchere = rs.getInt("montant_enchere");
				int noAcheteur = rs.getInt("no_acheteur");
				Utilisateur acheteur = new Utilisateur(noAcheteur);
				acheteur = UtilisateurManager.getInstance().selectInfoUtilisateur(noAcheteur);
				Enchere enchere = new Enchere(noEnchere, montantEnchere, vendeur, acheteur);
				article.setEnchere(enchere);
				
				String rue = rs.getString("rue");
				String codePostal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				Retrait retrait = new Retrait(rue, codePostal, ville);
				article.setRetrait(retrait);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return article;
	}
	
	private final static String UPDATE_ARTICLES = "UPDATE ARTICLES SET prix_vente = ? WHERE no_article = ?;";
	private final static String UPDATE_ENCHERES = "UPDATE ENCHERES SET montant_enchere = ?, no_acheteur = ? WHERE no_enchere = ?;";

	@Override
	public void faireEnchere(int noArticle) {
		List<Enchere> encherisseurs = new ArrayList<>();

		try(Connection cnx = ConnectionProvider.getConnection()){
			Article article = ArticleManager.getInstance().selectByIdArticle(noArticle);
			int noEnchere = article.getEnchere().getNoEnchere();
			Enchere enchere = EnchereManager.getInstance().selectEncherebyId(noEnchere);
			
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_ARTICLES);
			pstmt.setInt(1, article.getPrixVente());
			pstmt.setInt(2, noArticle);
			pstmt.executeUpdate();
			
			pstmt = cnx.prepareStatement(UPDATE_ENCHERES);
			pstmt.setInt(1, enchere.getMontantEnchere());
			pstmt.setInt(2, enchere.getAcheteur().getNoUtilisateur());
			pstmt.setInt(3, noEnchere);
			pstmt.executeUpdate();
			
			enchere.setArticle(article);
			
			encherisseurs.add(enchere);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
