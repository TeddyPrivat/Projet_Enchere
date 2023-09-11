package fr.eni.javaee.enchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.javaee.enchere.bll.DAOFactory;
import fr.eni.javaee.enchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletInscription
 */
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		//à faire ici : check si le pseudo ou mail déjà dans la BDD ou non 
		//on vérifie que le mot de passe est similaire dans les 2 inputs + on vérifie que le pseudo n'est pas déjà utilisé
		if(request.getParameter("confirmationMotDePasse").equals(request.getParameter("motDePasse"))) {
			Utilisateur utilisateur = new Utilisateur(pseudo,nom,prenom,email,telephone,rue,codePostal,ville,motDePasse);
			DAOFactory.getUtilisateurDAO().insertUtilisateur(utilisateur);
		}
		doGet(request, response);
	}

}
