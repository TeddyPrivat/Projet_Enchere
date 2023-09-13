package fr.eni.javaee.enchere.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import fr.eni.javaee.enchere.bll.DAOFactory;
import fr.eni.javaee.enchere.bo.Enchere;


public class ServletEncheres extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Enchere> listeEncheres = new ArrayList<>();
    
	@Override
    public void init() throws ServletException {
    	listeEncheres = DAOFactory.getEnchereDAO().selectAllEncheres();
    	System.out.println(listeEncheres);
    	this.getServletContext().setAttribute("listeEncheres", listeEncheres);
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encheres.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
