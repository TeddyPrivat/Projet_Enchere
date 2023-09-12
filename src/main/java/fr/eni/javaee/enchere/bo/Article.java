package fr.eni.javaee.enchere.bo;

import java.time.LocalDate;

public class Article {

	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	
	public enum Etat{
		A_VENDRE("A vendre"),
		EN_VENTE("En vente"),
		VENDU("Vendu");
		
		private String etat;
		private Etat(String etat) {
			this.etat = etat;
		}
		
		public String getEtat() {
			return this.etat;
		}
	}
	private Etat etatVente;
	
	private Categorie categorie;
	private Utilisateur utilisateur; 
	private Retrait retrait;
	private Enchere enchere;
	
	public Article() {};
	
	public Article(String nomArticle) {
		this();
		this.nomArticle = nomArticle;
	}
	
	public Article(String nomArticle, String description, LocalDate dateFinEncheres) {
		this(nomArticle);
		this.description = description;
		this.dateDebutEncheres = dateFinEncheres;
	}
	
	public Article(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente) {
		this(nomArticle, description, dateFinEncheres);
		this.noArticle = noArticle;
		this.dateDebutEncheres = dateDebutEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
	}
	
	public Article(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres, int miseAPrix, int prixVente, Categorie categorie, Utilisateur utilisateur) {
		this(nomArticle, description, dateFinEncheres);
		this.dateDebutEncheres = dateDebutEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.categorie = categorie;
		this.utilisateur = utilisateur;
	}
	
	public Article(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente, Etat etatVente) {
		this(noArticle, nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente);
		this.etatVente = etatVente;
	}
	
	public int getNoArticle() {
		return noArticle;
	}
	
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}
	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	public int getMiseAPrix() {
		return miseAPrix;
	}
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	public int getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	public String getEtatVente() {
		return etatVente.getEtat();
	}
	public void setEtatVente(Etat etatVente) {
		this.etatVente = etatVente;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Retrait getRetrait() {
		return retrait;
	}
	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Enchere getEnchere() {
		return enchere;
	}
	public void setEnchere(Enchere enchere) {
		this.enchere = enchere;
	}
	
	@Override
	public String toString() {
		return "Article [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente.getEtat() + "]";
	}

}
