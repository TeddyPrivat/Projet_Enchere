package fr.eni.javaee.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import fr.eni.javaee.enchere.bo.Article;
import fr.eni.javaee.enchere.bo.Enchere;
import fr.eni.javaee.enchere.bo.Utilisateur;
import fr.eni.javaee.enchere.dal.ConnectionProvider;
import fr.eni.javaee.enchere.dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO{
	
	private final static String SELECT_ALL_ENCHERES_EN_COURS = "SELECT * FROM ENCHERES INNER JOIN ARTICLES ON no_article = no_article INNER JOIN UTILISATEURS ON no_utilisateur = no_utilisateur;";

	@Override
	public List<Enchere> selectAllEncheresEnCours() {
		List<Enchere> encheresEnCours = new ArrayList<>();
		Enchere enchere = null;
		LocalDate dateActuelle = LocalDate.now();
		
		try(Connection cnx = ConnectionProvider.getConnection()){
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_ENCHERES_EN_COURS);
			
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
				Article article = new Article(noArticle, nomArticle, description, debutEnchere, finEnchere, miseAPrix, prixVente);
				int noUtilisateur = rs.getInt("no_utilisateur");
				String pseudo = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				
				if(dateActuelle.isEqual(debutEnchere) || dateActuelle.isAfter(debutEnchere) && dateActuelle.isBefore(finEnchere)) {
					enchere = new Enchere();
					enchere.setArticle(article);
					encheresEnCours.add(enchere);
				}
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Enchere> selectById(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

}
