package fr.eni.javaee.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.javaee.enchere.bo.Utilisateur;
import fr.eni.javaee.enchere.dal.ConnectionProvider;
import fr.eni.javaee.enchere.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private final static String DELETE = "DELETE FROM UTILISATEURS WHERE no_UTILISATEUR=?;";

	private final static String SELECT_USER_IF_EXIST = "SELECT no_utilisateur FROM UTILISATEURS WHERE ((pseudo=? OR email=?) AND mot_de_passe=?);";

	private final static String SELECT_USER_UTILISATEUR = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit, mot_de_passe  FROM UTILISATEURS WHERE no_utilisateur =?;";

		
	@Override
	public int selectByIdentifiant(String identifiant, String mdp) {
		int estConnecte = 0;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_USER_IF_EXIST);
			pstmt.setString(1, identifiant); // pseudo
			pstmt.setString(2, identifiant); // ou email
			pstmt.setString(3, mdp);
			ResultSet rs = pstmt.executeQuery();

			if (!rs.next()) { // si la requête ne renvoie aucune ligne
				estConnecte = 0;
			} else { // si elle en renvoie une -> cet utilisateur peut se connecter
				estConnecte = rs.getInt(1); // à récupérer si on veut savoir si nous sommes connectés
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estConnecte;
	}

	private final static String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur)"
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?);";

	@Override
	public void insertUtilisateur(Utilisateur utilisateur) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_UTILISATEUR);
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, utilisateur.getCredit());
			pstmt.setByte(11, utilisateur.getAdministrateur());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUtilisateur(int no_UTILISATEUR) {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(DELETE);
			pStmt.setInt(1, no_UTILISATEUR);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Utilisateur selectInfoUtilisateur(int no_utilisateur) {
		Utilisateur utilisateur = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = cnx.prepareStatement(SELECT_USER_UTILISATEUR);
			pstmt.setInt(1, no_utilisateur);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				int noUtilisateur = rs.getInt("no_utilisateur");
				String pseudo = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String rue = rs.getString("rue");
				String codePostal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				int credit = rs.getInt("credit");
				String motDePasse = rs.getString("mot_de_passe");

				utilisateur = new Utilisateur(noUtilisateur, pseudo,nom, prenom, email, telephone, rue, codePostal,ville, motDePasse, credit);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
	
	private static final String UPDATE_UTILISATEUR = """ 
			UPDATE UTILISATEURS 
			SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?,
			rue = ?, code_postal = ?, ville = ?
			WHERE no_utilisateur = ?
			""";
	
	public void updateInfoUtilisateur(int no_utilisateur, String pseudo, String nom, String prenom, String email,String telephone,
			String rue,	String codePostal, String ville) {
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_UTILISATEUR);
			//il nous faut récupérer les infos du formulaire 
			
			pstmt.setString(1, pseudo);
			pstmt.setString(2, nom);
			pstmt.setString(3, prenom);
			pstmt.setString(4, email);
			pstmt.setString(5, telephone);
			pstmt.setString(6, rue);
			pstmt.setString(7, codePostal);
			pstmt.setString(8, ville);
			pstmt.setInt(9, no_utilisateur);
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static final String SELECT_IF_PSEUDO_EXISTS =  "SELECT no_utilisateur FROM UTILISATEURS WHERE pseudo=?; ";
	
	public boolean checkIfPseudoIsUsed(String pseudo) {
		boolean isPseudoUsed = false;
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_IF_PSEUDO_EXISTS);
			pstmt.setString(1, pseudo);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				isPseudoUsed = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isPseudoUsed;
	}
	
private static final String SELECT_IF_EMAIL_EXISTS =  "SELECT no_utilisateur FROM UTILISATEURS WHERE email=?; ";
	
	public boolean checkIfEmailIsUsed(String email) {
		boolean isEmailUsed = false;
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_IF_EMAIL_EXISTS);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				isEmailUsed = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isEmailUsed;
	}
}
