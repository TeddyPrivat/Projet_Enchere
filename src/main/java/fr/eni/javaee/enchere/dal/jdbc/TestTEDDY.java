package fr.eni.javaee.enchere.dal.jdbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.eni.javaee.enchere.bo.Article;

public class TestTEDDY {

	public static void main(String[] args) {
		//motsDansLaRecherche("La bouteille vide");
		//System.out.println(contientMotDeLaRecherche(motsDansLaRecherche("La bouteille vide"), "bouteille"));
		Set<Article> listeArticle = new HashSet<>();
		Article a1 = new Article("Baleine à bosse");
		Article a2 = new Article("Voiture de course");
		Article a3 = new Article("Velo de course");
		Article a4 = new Article("Velo à bosse");
		
		listeArticle.add(a1);
		listeArticle.add(a2);
		listeArticle.add(a3);
		listeArticle.add(a4);
		
		listeArticle = contientMotDeLaRecherche(listeArticle, motsDansLaRecherche("velo à"));
		System.out.println(listeArticle);
	}
	
	public static List<String> motsDansLaRecherche(String recherche){
		List<String> motsRecherche = new ArrayList<String>();
		String[] tabString = recherche.toLowerCase().trim().split(" ");
		motsRecherche = Arrays.asList(tabString);
		return motsRecherche;
	}
	
	public static Set<Article> contientMotDeLaRecherche(Set<Article> articles, List<String> listeRecherche ) {
		Set<Article> listeArticle = new HashSet<Article>();
		
		for(Article article : articles) {
			for(String motRecherche : listeRecherche) {
				if(article.getNomArticle().toLowerCase().contains(motRecherche)) {
					listeArticle.add(article);
				}
			}
		}
		return listeArticle;
	}
}
