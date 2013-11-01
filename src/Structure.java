import java.util.ArrayList;
import java.util.List;


public abstract class Structure {
	private String nom;
	private int nbPlace;
	private final int NB_PLACE_MAX;
	private int tpsExec;
	private List<Visiteur> listVisiteur = new ArrayList<Visiteur> ();
	
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
	
	public int getNbPlaceMax () {
		return this.NB_PLACE_MAX;
	}
	
	public List<Visiteur> getListVisiteur() {
		return this.listVisiteur;
	}

	public void ajoutVisiteur (Visiteur visiteur) {
		if (this.nbPlace < this.NB_PLACE_MAX) {
			this.listVisiteur.add(visiteur);
			++ this.nbPlace;
			visiteur.setOccupé(true);
			System.out.println("Ajout de visiteur dans la structure " + this.nom);
		}
		else {
			System.out.println("Impossible de rajouter un visiteur dans la structure " + this.nom + ". Structure pleine.");
		}
	}
	
	public void supprVisiteur (Visiteur visiteur) {
		if (this.nbPlace > 0)
		{
			this.listVisiteur.remove(visiteur);
			-- this.nbPlace;
			visiteur.setOccupé(false);
			System.out.println("Visiteur sortie de la structure " + this.nom);
		}
		else {
			System.out.println("Impossible d'enlever un visiteur, pas de visiteur dans structure " + this.nom);
		}
	}
	
	public void supprAllVisiteur () {
		for (Visiteur v : this.getListVisiteur()) {
			v.setOccupé(false);
		}
		this.listVisiteur.clear();
		System.out.println("Structure " + this.nom + " vide");
	}

	@Override
	public String toString() {
		return "Structure [nom=" + nom + ", nbPlace=" + nbPlace
				+ ", NB_PLACE_MAX=" + NB_PLACE_MAX + ", tpsExec=" + tpsExec
				+ ", listVisiteur=" + listVisiteur + "]";
	}
	
}
