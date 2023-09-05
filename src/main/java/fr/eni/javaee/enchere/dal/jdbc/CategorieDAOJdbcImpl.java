package fr.eni.javaee.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.enchere.bo.Categorie;
import fr.eni.javaee.enchere.dal.CategorieDAO;
import fr.eni.javaee.enchere.dal.ConnectionProvider;

public class CategorieDAOJdbcImpl implements CategorieDAO{
	
	private final static String SELECT_ALL = "SELECT * FROM CATEGORIES";

	@Override
	public List<Categorie> selectAll() {
		List<Categorie> categories = new ArrayList<>();
		
		try(Connection cnx = ConnectionProvider.getConnection()){
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			
			while(rs.next()) {
				int noCategorie = rs.getInt("no_categorie");
				String libelle = rs.getString("libelle");
				
				Categorie cat = new Categorie(noCategorie, libelle);
				categories.add(cat);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

}
