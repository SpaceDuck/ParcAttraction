
public abstract class Employe {
	
	private String nom;
	private String metier ;
	private boolean travaille = false;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMetier() {
		return metier;
	}

	public void setMetier(String metier) {
		this.metier = metier;
	}

	public boolean isTravaille() {
		return travaille;
	}

	public void setTravaille(boolean travaille) {
		this.travaille = travaille;
	}

	public Employe(String nom, String metier) {
		super();
		this.nom = nom;
		this.metier = metier;
	}
		
}
