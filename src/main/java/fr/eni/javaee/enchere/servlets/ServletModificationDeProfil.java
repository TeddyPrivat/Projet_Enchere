package fr.eni.javaee.enchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.javaee.enchere.bll.DAOFactory;
import fr.eni.javaee.enchere.bll.UtilisateurManager;
import fr.eni.javaee.enchere.bo.Utilisateur;

public class ServletModificationDeProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Utilisateur utilisateur = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int idUser = ((int) session.getAttribute("estConnecte")); // on récupère l'id de l'user par l'attribut de
																	// session
		utilisateur = UtilisateurManager.getInstance().selectInfoUtilisateur(idUser); // on récupère les infos de l'user

		// on récupère les données que nous allons pré-remplir
		String pseudo = utilisateur.getPseudo();
		String nom = utilisateur.getNom();
		String prenom = utilisateur.getPrenom();
		String email = utilisateur.getEmail();
		String telephone = utilisateur.getTelephone();
		String rue = utilisateur.getRue();
		String codePostal = utilisateur.getCodePostal();
		String ville = utilisateur.getVille();
		String motDePasse = utilisateur.getMotDePasse();
		int credit = utilisateur.getCredit();

		request.setAttribute("pseudo", pseudo);
		request.setAttribute("nom", nom);
		request.setAttribute("prenom", prenom);
		request.setAttribute("email", email);
		request.setAttribute("telephone", telephone);
		request.setAttribute("rue", rue);
		request.setAttribute("codePostal", codePostal);
		request.setAttribute("ville", ville);
		request.setAttribute("motDePasse", motDePasse);
		request.setAttribute("credit", credit);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modificationdeprofil.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// autre possibilité : refaire un appel à la bdd
		HttpSession session = request.getSession(); // récupère ID de l'user par le paramètre de session
		int idUser = ((int) session.getAttribute("estConnecte"));
		utilisateur = UtilisateurManager.getInstance().selectInfoUtilisateur(idUser); // on récupère les infos de l'user

		String motDePasseBDD = utilisateur.getMotDePasse(); // on stocke dans une variable le mot de passe de la BDD de
															// l'user
		boolean isNouveauMotDePasseCorrect = true;
		boolean isMdpCorrect = true; // booléen utilisé dans la jsp pour écrire le message d'erreur
		String motDePasseSaisi = request.getParameter("motDePasse"); // récupération du mot de passe saisi
		String nouveauMotDePasse = request.getParameter("nouveauMotDePasse"); // on récupère le potentiel nouveau mot de
																				// passe
		String motDePasseConfirmation = request.getParameter("confirmationMotDePasse"); // on récupère le mdp de
																						// confirmation

		if (!motDePasseSaisi.equals(motDePasseBDD)) { // comparaison du mot de passe saisi et de celui en BDD
			isMdpCorrect = false;
		} else if (!nouveauMotDePasse.equals(motDePasseConfirmation)) { // comparaison du nouveau mdp et de sa
																		// confirmation
			isNouveauMotDePasseCorrect = false;
		}

		// VERSION BELLE
		String pseudoSaisi = request.getParameter("pseudo");
		String nomSaisi = request.getParameter("nom");
		String prenomSaisi = request.getParameter("prenom");
		String emailSaisi = request.getParameter("email");
		String telephoneSaisi = request.getParameter("telephone");
		String rueSaisi = request.getParameter("rue");
		String codePostalSaisi = request.getParameter("codePostal");
		String villeSaisi = request.getParameter("ville");

		// on va récupérer nos booléens pour savoir s'il est possible ou non de changer
		// pseudo/email en fonction de
		// s'il sont déjà présents ou non dans la BDD

		boolean pseudoIsInBDD = DAOFactory.getUtilisateurDAO().checkIfPseudoIsUsed(pseudoSaisi);
		boolean emailIsInBDD = DAOFactory.getUtilisateurDAO().checkIfEmailIsUsed(emailSaisi);

		// on récupère l'email et le pseudo de base
		Utilisateur utilisateur = DAOFactory.getUtilisateurDAO().selectInfoUtilisateur(idUser);

		String pseudoDansBDD = utilisateur.getPseudo();
		String emailDansBDD = utilisateur.getEmail();

		if (pseudoIsInBDD && !(pseudoSaisi.equals(pseudoDansBDD))) {
			request.setAttribute("pseudoIsInBDD", pseudoIsInBDD);
			doGet(request, response);
		} else if (emailIsInBDD && !(emailSaisi.equals(emailDansBDD))) {
			request.setAttribute("emailIsInBDD", emailIsInBDD);
			doGet(request, response);
		} else {

			DAOFactory.getUtilisateurDAO().updateInfoUtilisateur(idUser, pseudoSaisi, nomSaisi, prenomSaisi, emailSaisi,
					telephoneSaisi, rueSaisi, codePostalSaisi, villeSaisi);
			request.setAttribute("isNouveauMotDePasseCorrect", isNouveauMotDePasseCorrect); // on envoie les booléens
																							// pour qu'ils soient
																							// traités
			request.setAttribute("isMdpCorrect", isMdpCorrect); // dans la JSP

			RequestDispatcher rd = request.getRequestDispatcher("ServletProfilUtilisateur");
			rd.forward(request, response);
		}

	}
}
