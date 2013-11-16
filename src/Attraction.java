public abstract class Attraction extends Structure {
	
	private int probaPanne = 0;
	private int tpsAtt;
	private boolean enMarche;
	private boolean enInspection;
	

	private Attraction(String nom, int tpsExec, int nbPlaceMax, boolean restricAge) {
		super(nom, tpsExec, nbPlaceMax, restricAge);
	}


	public Attraction(String nom, int tpsExec, int nbPlaceMax, boolean restricAge, int tpsAtt) {
		super(nom, tpsExec, nbPlaceMax, restricAge);
		this.tpsAtt = tpsAtt;
	}

	public int getProbaPanne() {
		return probaPanne;
	}


	public void setProbaPanne(int probaPanne) {
		this.probaPanne = probaPanne;
	}


	public int getTpsAtt() {
		return tpsAtt;
	}


	public void setTpsAtt(int tpsAtt) {
		this.tpsAtt = tpsAtt;
	}
	
	public boolean isEnMarche() {
		return enMarche;
	}


	public void setEnMarche(boolean enMarche) {
		this.enMarche = enMarche;
	}


	public boolean isEnInspection() {
		return enInspection;
	}


	public void setEnInspection(boolean enInspection) {
		this.enInspection = enInspection;
	}


	@Override
	public String toString() {
		return "Attraction [probaPanne=" + probaPanne + ", tpsAtt=" + tpsAtt + ", enMarche=" + enMarche
				+ "]";
	}
	
	public void ajoutVisiteur (Visiteur visiteur) {
		if (!(this.enInspection)) {
			if (this.isRestricAge() && !(visiteur.isAdulte())) {
				System.out.println("Seul un adulte peu aller dans cette structure !");
			}
			else {
				if (this.isEnMarche()) {
					System.out.println("Impossible, l'attraction " + this.getNom() +  " est en fonctionnement.");
				}
				else {
					if (this.getNbPlace() < this.getNbPlaceMax()) {
						this.getListVisiteur().add(visiteur);
						this.setNbPlace(this.getNbPlace() + 1);
						visiteur.setOccupe(true);
						System.out.println("Ajout de visiteur dans la structure " + this.getNom());
					}
					else {
						System.out.println("Impossible de rajouter un visiteur dans la structure " + this.getNom() + ". Structure pleine.");
					}
				}
			}
		}
		else {
			System.out.println("Impossible, l'attraction " + this.getNom() +  " est en inspection.");
		}
	}
	
	public void supprVisiteur (Visiteur visiteur) {
		if (this.isEnMarche()) {
			System.out.println("Impossible, l'attraction " + this.getNom() +  " est en fonctionnement.");
		}
		else {
			if (this.getNbPlace() >= 0)
			{
				this.getListVisiteur().remove(visiteur);
				this.setNbPlace(this.getNbPlace () - 1);
				visiteur.setOccupe(false);
				System.out.println("Visiteur sortie de la structure " + this.getNom());
			}
			else {
				System.out.println("Impossible d'enlever un visiteur, pas de visiteur dans la structure " + this.getNom());
			}	
		}
	}
	
	public void supprAllVisiteur () {
		if (this.isEnMarche()) {
			System.out.println("Impossible, la structure " + this.getNom() +  " est en fonctionnement.");
		}
		else {
			for (Visiteur v : this.getListVisiteur()) {
				v.setOccupe(false);
			}
			this.getListVisiteur().clear();
			System.out.println("Structure " + this.getNom() + " vide");			
		}
	}
	
	public void appelReparateur(Parc p) throws InterruptedException{
		for (Reparateur r : p.getListReparateur()){
			if (r.isTravaille() == false){
				r.setTravaille(true);
				this.enInspection = true;
				Thread.sleep(3000);
				this.probaPanne = 0;
				r.setTravaille(false);
				this.enInspection = false;
				break;
			}
			if (this.probaPanne != 0){
				appelReparateur(p);
			}
		}
	}
	
	public void exec(Parc p) throws Exception {
		if (!(this.enInspection) && (this.probaPanne < 50 )) {
			this.enMarche = true;
			Thread.sleep(1000 * this.getTpsExec());
			this.enMarche = false;
			this.supprAllVisiteur();
		}
		else if (!(this.enInspection) && (this.probaPanne >= 50)){
			this.appelReparateur(p);
		}
		else {
			System.out.println("Impossible, l'attraction " + this.getNom() +  " est en inspection.");
		}
	}
}
