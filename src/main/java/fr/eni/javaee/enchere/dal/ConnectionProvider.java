package fr.eni.javaee.enchere.dal;


import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {

private static DataSource dataSource;
	
	/*
	 * bloc static :
	 * bloc de code qui s'éxécute une fois et une seule fois,
	 * la 1ere fois que l'on appelle la classe (soit par instanciation (new()), 
	 * soit par appel de méthode static (public), 
	 * soit par appel d'attribut static (public)).
	 */
	static {
		
		try {
			//1. récupérer les infos du fichier context.xml
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
			Connection cnx = dataSource.getConnection();
			
			System.out.println("La connexion est : " + 
							(cnx.isClosed() ? " fermée" : "ouverte"));
			
			//3. libère la connexion
			cnx.close();
		} catch (NamingException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		//2. récupérer la connexion à la BDD
		return dataSource.getConnection();
	}
	
	
	
}