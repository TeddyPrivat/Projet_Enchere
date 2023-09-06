package fr.eni.javaee.enchere.bo;

public class Retrait {
	
	private Article noArticleRetrait;
	private String rue;
	private String codePostal;
	private String ville;
	
	public Retrait() {};
	
	public Retrait(String rue, String codePostal, String ville) {
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
	
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	public String getCodePostal() {
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
