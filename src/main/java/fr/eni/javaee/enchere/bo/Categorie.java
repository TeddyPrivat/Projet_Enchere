package fr.eni.javaee.enchere.bo;

public class Categorie {
	
	private int noCategorie;
	private String libelle;
	
	public Categorie(){};
	
	public Categorie(int noCategorie, String libelle) {
		this();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}
	
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	
	public int getNoCategorie() {
		return this.noCategorie;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public String getLibelle() {
		return this.libelle;
	}

	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + "]";
	}
}
