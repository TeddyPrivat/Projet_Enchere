package fr.eni.javaee.enchere.bo;

public class Retrait {
	
	private Article noArticleRetrait;
	private String rue;
	private int codePostal;
	private String ville;
	
	public Retrait() {};
	
	public Retrait(String rue, int codePostal, String ville) {
		this();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	public void setNoArticleRetrait(Article noArticleRetrait) {
		this.noArticleRetrait = noArticleRetrait;
	}
	
	public Article getNoArticleRetrait() {
		return this.noArticleRetrait;
	}
	
	public void setRue(String rue) {
		this.rue = rue;
	}
	
	public String getRue() {
		return this.rue;
	}
	
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	
	public int getCodePostal() {
		return this.codePostal;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getVille() {
		return this.ville;
	}

	@Override
	public String toString() {
		return "Retrait [noArticleRetrait=" + noArticleRetrait + ", rue=" + rue + ", codePostal=" + codePostal
				+ ", ville=" + ville + "]";
	}

}
