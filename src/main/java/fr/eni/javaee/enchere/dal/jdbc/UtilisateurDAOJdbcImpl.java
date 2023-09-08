package fr.eni.javaee.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.javaee.enchere.bo.Utilisateur;
import fr.eni.javaee.enchere.dal.ConnectionProvider;
import fr.eni.javaee.enchere.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO{


	private final static String DELETE = "DELETE FROM UTILISATEURS WHERE no_UTILISATEUR=?;";
	

	private final static String SELECT_USER_IF_EXIST = "SELECT no_utilisateur FROM UTILISATEURS WHERE ((pseudo=? OR email=?) AND mot_de_passe=?);";

	
	@Override
	public int selectByIdentifiant(String identifiant,String mdp) {
		int estConnecte = 0;
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_USER_IF_EXIST);
			pstmt.setString(1, identifiant);	//pseudo
			pstmt.setString(2, identifiant);	// ou email
			pstmt.setString(3, mdp);
			ResultSet rs = pstmt.executeQuery();
			
			if(!rs.next()) {	//si la requête ne renvoie aucune ligne 
				estConnecte = 0;
			}else {	//si elle en renvoie une -> cet utilisateur peut se connecter
				estConnecte = rs.getInt(1); //à récupérer si on veut savoir si nous sommes connectés
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
		try(Connection cnx = ConnectionProvider.getConnection()){
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
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void deleteUtilisateur(int no_UTILISATEUR) {
		
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pStmt = cnx.prepareStatement(DELETE);
			pStmt.setInt(1, no_UTILISATEUR);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}
