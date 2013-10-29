
public abstract class Structure {
	private String nom;
	private int nbPlace;
	private final int NB_PLACE_MAX;
	private int tpsExec;
	
	public Structure(String nom, int nbPlace, int tpsExec, int nbPlaceMax) {
		super();
		this.nom = nom;
		this.nbPlace = nbPlace;
		this.tpsExec = tpsExec;
		this.NB_PLACE_MAX = nbPlaceMax;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public int getTpsExec() {
		return tpsExec;
	}

	public void setTpsExec(int tpsExec) {
		this.tpsExec = tpsExec;
	}
	
	public void ajoutClient () {
		if (this.nbPlace < this.NB_PLACE_MAX)
			++ this.nbPlace;
	}
	
	public void supprClient () {
		if (this.nbPlace > 0)
			-- this.nbPlace;
	}

	@Override
	public String toString() {
		return "Structure [nom=" + nom + ", nbPlace=" + nbPlace + ", tpsExec="
				+ tpsExec + "]";
	}
	
	
}
