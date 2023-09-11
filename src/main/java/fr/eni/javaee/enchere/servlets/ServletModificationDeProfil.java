package fr.eni.javaee.enchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.javaee.enchere.bll.DAOFactory;
import fr.eni.javaee.enchere.bll.UtilisateurManager;
import fr.eni.javaee.enchere.bo.Utilisateur;
import fr.eni.javaee.enchere.dal.ConnectionProvider;


public class ServletModificationDeProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Utilisateur utilisateur = null;
    @Override
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	int idUser = ((int)session.getAttribute("estConnecte")); // on récupère l'id de l'user par l'attribut de session
    	utilisateur = UtilisateurManager.getInstance().selectInfoUtilisateur(idUser); //on récupère les infos de l'user
    	System.out.println(utilisateur);
    	//on récupère les données que nous allons pré-remplir
    	String pseudo = utilisateur.getPseudo();
    	String nom = utilisateur.getNom();
    	String prenom = utilisateur.getPrenom();
    	String email = utilisateur.getEmail();
    	String telephone = utilisateur.getTelephone();
    	String rue = utilisateur.getRue();
    	String codePostal = utilisateur.getCodePostal();
    	String ville = utilisateur.getVille();
    	String motDePasse = utilisateur.getMotDePasse();
    	System.out.println(rue);
    	System.out.println(telephone);
    	
    	session.setAttribute("pseudo", pseudo);
    	request.setAttribute("nom", nom);
    	request.setAttribute("prenom", prenom);
    	request.setAttribute("email", email);
    	request.setAttribute("telephone", telephone);
    	request.setAttribute("rue", rue);
    	request.setAttribute("codePostal", codePostal);
    	request.setAttribute("ville", ville);
    	request.setAttribute("motDePasse", motDePasse);
    	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modificationdeprofil.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//autre possibilité : refaire un appel à la bdd 
		HttpSession session = request.getSession();	//récupère ID de l'user par le paramètre de session
    	int idUser = ((int)session.getAttribute("estConnecte"));
    	utilisateur = UtilisateurManager.getInstance().selectInfoUtilisateur(idUser); //on récupère les infos de l'user
    	
    	String motDePasseBDD = utilisateur.getMotDePasse();	//on stocke dans une variable le mot de passe de la BDD de l'user
		boolean isNouveauMotDePasseCorrect = true;
		boolean isMdpCorrect = true;	//booléen utilisé dans la jsp pour écrire le message d'erreur
		String motDePasseSaisi = request.getParameter("motDePasse"); //récupération du mot de passe saisi
		String nouveauMotDePasse = request.getParameter("nouveauMotDePasse");	//on récupère le potentiel nouveau mot de passe
		String motDePasseConfirmation = request.getParameter("confirmationMotDePasse");	//on récupère le mdp de confirmation
		
		if(!motDePasseSaisi.equals(motDePasseBDD)) {	//comparaison du mot de passe saisi et de celui en BDD
			isMdpCorrect = false;
		}else if(!nouveauMotDePasse.equals(motDePasseConfirmation)) {	//comparaison du nouveau mdp et de sa confirmation  
			isNouveauMotDePasseCorrect = false;
		}
		//DAOFactory.getUtilisateurDAO().updateInfoUtilisateur(idUser);
		//tentative sale de mettre en place l'update direct dans la servlet
		 String UPDATE_UTILISATEUR = """ 
				UPDATE UTILISATEURS 
				SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?,
				rue = ?, code_postal = ?, ville = ?
				WHERE no_utilisateur = ?
				""";
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_UTILISATEUR);
			//il nous faut récupérer les infos du formulaire 
			String pseudoSaisi = request.getParameter("pseudo");
			String nomSaisi = request.getParameter("nom");
			String prenomSaisi = request.getParameter("prenom");
			String emailSaisi = request.getParameter("email");
			String telephoneSaisi = request.getParameter("telephone");
			String rueSaisi = request.getParameter("rue");
			String codePostalSaisi = request.getParameter("codePostal");
			String villeSaisi = request.getParameter("ville");
			
			pstmt.setString(1, pseudoSaisi);
			pstmt.setString(2, nomSaisi);
			pstmt.setString(3, prenomSaisi);
			pstmt.setString(4, emailSaisi);
			pstmt.setString(5, telephoneSaisi);
			pstmt.setString(6, rueSaisi);
			pstmt.setString(7, codePostalSaisi);
			pstmt.setString(8, villeSaisi);
			pstmt.setInt(9, utilisateur.getNoUtilisateur());
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("isNouveauMotDePasseCorrect", isNouveauMotDePasseCorrect);	//on envoie les booléens pour qu'ils soient traités
		request.setAttribute("isMdpCorrect", isMdpCorrect);								//dans la JSP
		
		doGet(request, response);	
	}

}

