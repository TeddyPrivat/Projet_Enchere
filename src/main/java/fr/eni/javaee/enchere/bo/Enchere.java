package fr.eni.javaee.enchere.bo;

import java.time.LocalDate;

public class Enchere {
	
	private int noEnchere;
	private LocalDate dateEnchere;
	private int montantEnchere;
	private Article article;
	private Utilisateur utilisateur;
	
	public Enchere() {};
	
	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}
	
	public int getNoEnchere() {
		return this.noEnchere;
	}
	
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	
	public LocalDate getDateEnchere() {
		return this.dateEnchere;
	}
	
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	
	public int getMontantEnchere() {
		return this.montantEnchere;
	}
	
	public void setArticle(Article article) {
		this.article = article;
	}
	
	public Article getArticle() {
		return this.article;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	@Override
	public String toString() {
		return "Enchere [noEnchere=" + noEnchere + ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere
				+ ", article=" + article + ", utilisateur=" + utilisateur + "]";
	}

}
