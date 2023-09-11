package fr.eni.javaee.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import fr.eni.javaee.enchere.bo.Article;
import fr.eni.javaee.enchere.bo.Article.Etat;
import fr.eni.javaee.enchere.bo.Categorie;
import fr.eni.javaee.enchere.bo.Enchere;
import fr.eni.javaee.enchere.bo.Retrait;
import fr.eni.javaee.enchere.bo.Utilisateur;
import fr.eni.javaee.enchere.dal.ConnectionProvider;
import fr.eni.javaee.enchere.dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO{
	
	private final static String SELECT_ALL_ENCHERES = "SELECT * FROM ENCHERES AS e INNER JOIN ARTICLES AS a ON a.no_article = e.no_article INNER JOIN UTILISATEURS AS u ON u.no_utilisateur = e.no_vendeur INNER JOIN CATEGORIES AS c ON c.no_categorie = a.no_categorie;";

	@Override
	public List<Enchere> selectAllEncheres() {
		List<Enchere> encheres = new ArrayList<>();
		Enchere enchere = null;
		LocalDate dateActuelle = LocalDate.now();
		
		try(Connection cnx = ConnectionProvider.getConnection()){
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_ENCHERES);
			
			while(rs.next()) {
				int noEnchere = rs.getInt("no_enchere");
				LocalDate dateEnchere = rs.getDate("date_enchere").toLocalDate();
				int montantEnchere = rs.getInt("montant_enchere");
				
				int noArticle = rs.getInt("no_article");
				String nomArticle = rs.getString("nom_article");
				String description = rs.getString("description");
				LocalDate debutEnchere = rs.getDate("date_debut_encheres").toLocalDate();
				LocalDate finEnchere = rs.getDate("date_fin_encheres").toLocalDate();
				int miseAPrix = rs.getInt("prix_initial");
				int prixVente = rs.getInt("prix_vente");
				
				int noCategorie = rs.getInt("no_categorie");
				String libelle = rs.getString("libelle");
				
				int noVendeur = rs.getInt("no_utilisateur");
				String pseudo = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String rue = rs.getString("rue");
				String codePostal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				String motDePasse = rs.getString("mot_de_passe");
				int credit = rs.getInt("credit");
				
				enchere = new Enchere(noEnchere, dateEnchere, montantEnchere);
				Article article = new Article(noArticle, nomArticle, description, debutEnchere, finEnchere, miseAPrix, prixVente);
				
				if(dateActuelle.isBefore(debutEnchere)) {
					article.setEtatVente(Etat.A_VENDRE);
				}
				
				if(dateActuelle.isEqual(debutEnchere) || dateActuelle.isAfter(debutEnchere) && dateActuelle.isBefore(finEnchere)) {
					article.setEtatVente(Etat.EN_VENTE);
				}
				
				if(dateActuelle.isEqual(finEnchere) || dateActuelle.isAfter(finEnchere)) {
					article.setEtatVente(Etat.VENDU);
				}
				
				Categorie categorie = new Categorie(noCategorie, libelle);
				article.setCategorie(categorie);
				enchere.setArticle(article);
				Utilisateur vendeur = new Utilisateur(noVendeur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit);
				enchere.setUtilisateur(vendeur);
				encheres.add(enchere);
			}
			
			stmt.close();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return encheres;
	}
	
	private final static String SELECT_NAME_LIKE = "SELECT a.nom_article FROM ENCHERES AS e INNER JOIN ARTICLES AS a ON a.no_article = e.no_article WHERE a.nom_article LIKE %(?)%;";

	@Override
	public Article selectNomArticleLike(String articleNom) {
		Article article = null;
		
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_NAME_LIKE);
			pstmt.setString(1, articleNom);
			ResultSet rs = pstmt.executeQuery();
			
			articleNom = rs.getString(1);
			
			article = new Article(articleNom);	
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return article;
	}
	
	private final static String INSERT_ENCHERE = "INSERT INTO ENCHERES (date_enchere, montant_enchere, no_article, no_vendeur) VALUES (?, ?, ?, ?);";

	@Override
	public void insertNouvelleVente(Enchere nouvelleVente) {
		
		try(Connection cnx = ConnectionProvider.getConnection()){

				PreparedStatement pstmt = cnx.prepareStatement(INSERT_ENCHERE);
				pstmt.setDate(1, Date.valueOf(nouvelleVente.getDateEnchere()));
				pstmt.setInt(2, nouvelleVente.getMontantEnchere());
				pstmt.setInt(3, nouvelleVente.getArticle().getNoArticle());
				pstmt.setInt(4, nouvelleVente.getUtilisateur().getNoUtilisateur());
				pstmt.executeUpdate();
				
				pstmt.close();
	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private final static String INSERT_ARTICLE = "INSERT INTO ARTICLES (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) VALUES (?, ?, ?, ?, ?, ?, ?);";
	private final static String INSERT_RETRAIT = "INSERT INTO RETRAITS(no_article, rue, code_postal, ville) VALUES (?, ?, ?, ?);";

	@Override
	public void insertArticle(Article article, int vendeur) {
		
		try(Connection cnx = ConnectionProvider.getConnection()){
			try {
				cnx.setAutoCommit(false);
				
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, article.getNomArticle());
				pstmt.setString(2, article.getDescription());
				pstmt.setDate(3, Date.valueOf(article.getDateDebutEncheres()));
				pstmt.setDate(4, Date.valueOf(article.getDateFinEncheres()));
				pstmt.setInt(5, article.getMiseAPrix());
				pstmt.setInt(6, vendeur);
				pstmt.setInt(7, article.getCategorie().getNoCategorie());
				pstmt.executeUpdate();
			
				ResultSet rs = pstmt.getGeneratedKeys();
				
				if(rs.next()) {
					int noArticle = rs.getInt(1);
					article.setNoArticle(noArticle);
					
					Enchere enchere = new Enchere();
					enchere.setArticle(article);
					pstmt = cnx.prepareStatement(INSERT_ENCHERE);
					pstmt.setDate(1, Date.valueOf(enchere.getArticle().getDateDebutEncheres()));
					pstmt.setInt(2, enchere.getArticle().getMiseAPrix());
					pstmt.setInt(3, noArticle);
					pstmt.setInt(4, vendeur);
					pstmt.executeUpdate();
					
					Retrait retrait = new Retrait();
					pstmt = cnx.prepareStatement(INSERT_RETRAIT);
					pstmt.setInt(1, noArticle);
					pstmt.setString(2, retrait.getRue());
					pstmt.setString(3, retrait.getCodePostal());
					pstmt.setString(4, retrait.getVille());
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
