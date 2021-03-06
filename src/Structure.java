import java.util.ArrayList;
import java.util.List;


public abstract class Structure {
	private String nom;
	private int nbPlace = 0;
	private final int NB_PLACE_MAX;
	private int tpsExec;
	private boolean restricAge;
	private int nivPropre = 100;
	private List<Visiteur> listVisiteur = new ArrayList<Visiteur> ();
	private static final int TAUX_SALIR = 5;
	
	public Structure(String nom, int tpsExec, int nbPlaceMax, boolean restricAge) {
		super();
		this.nom = nom;
		this.tpsExec = tpsExec;
		this.NB_PLACE_MAX = nbPlaceMax;
		this.restricAge = restricAge;
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

	public int getNivPropre() {
		return nivPropre;
	}

	public void setNivPropre(int nivPropre) {
		this.nivPropre = nivPropre;
	}

	public boolean isRestricAge() {
		return restricAge;
	}

	public void setRestricAge(boolean restricAge) {
		this.restricAge = restricAge;
	}

	public int getNB_PLACE_MAX() {
		return NB_PLACE_MAX;
	}

	public void ajoutVisiteur (Visiteur visiteur) {
		if (this.restricAge && !(visiteur.isAdulte())) {
			System.out.println("Seul un adulte peu aller dans cette structure !");
		}
		else {
			if (this.nbPlace < this.NB_PLACE_MAX) {
				this.listVisiteur.add(visiteur);
				++ this.nbPlace;
				visiteur.setOccupe(true);
				System.out.println("Ajout de visiteur dans la structure " + this.nom);
			}
			else {
				System.out.println("Impossible de rajouter un visiteur dans la structure " + this.nom + ". Structure pleine.");
			}
		}
	}
	
	public void supprVisiteur (Visiteur visiteur) {
		if (this.nbPlace > 0)
		{
			this.listVisiteur.remove(visiteur);
			-- this.nbPlace;
			visiteur.setOccupe(false);
			System.out.println("Visiteur sortie de la structure " + this.nom);
		}
		else {
			System.out.println("Impossible d'enlever un visiteur, pas de visiteur dans structure " + this.nom);
		}
	}
	
	public void supprAllVisiteur () {
		for (Visiteur v : this.getListVisiteur()) {
			v.setOccupe(false);
		}
		this.listVisiteur.clear();
		System.out.println("Structure " + this.nom + " vide");
	}
	
	public void exec (Parc p) throws Exception {
		while (!(this.getListVisiteur().isEmpty())) {
			
			if (this.nivPropre < 50) {
				this.appelEntretien (p);
			}
			
			this.nivPropre = this.nivPropre + TAUX_SALIR;
			
			this.getListVisiteur().get(0).exec(this);
		}
	}
	
	public void appelEntretien (Parc p) throws InterruptedException {
		for (AgentEntretien a : p.getListAgentEntretien()){
			if (a.isTravaille() == false){
				a.setTravaille(true);
				Thread.sleep(3000);
				a.setTravaille(false);
				break;
			}
			if (this.nivPropre < 50){
				appelEntretien(p);
			}
		}
	}

	@Override
	public String toString() {
		return "Structure [nom=" + nom + ", nbPlace=" + nbPlace
				+ ", NB_PLACE_MAX=" + NB_PLACE_MAX + ", tpsExec=" + tpsExec
				+ ", restricAge=" + restricAge + ", listVisiteur="
				+ listVisiteur + "]";
	}
	
}
