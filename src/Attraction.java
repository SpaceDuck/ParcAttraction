public abstract class Attraction extends Structure {
	
	private int probaPanne;
	private boolean restricAge;
	private int tpsAtt;
	private boolean enMarche;
	

	private Attraction(String nom, int nbPlace, int tpsExec) {
		super(nom, nbPlace, tpsExec, tpsExec);
	}


	public Attraction(String nom, int nbPlace, int tpsExec, int probaPanne,
			boolean restricAge, int tpsAtt) {
		super(nom, nbPlace, tpsExec, tpsAtt);
		this.probaPanne = probaPanne;
		this.restricAge = restricAge;
		this.tpsAtt = tpsAtt;
	}

	public int getProbaPanne() {
		return probaPanne;
	}


	public void setProbaPanne(int probaPanne) {
		this.probaPanne = probaPanne;
	}


	public boolean isRestricAge() {
		return restricAge;
	}


	public void setRestricAge(boolean restricAge) {
		this.restricAge = restricAge;
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


	@Override
	public String toString() {
		return "Attraction [probaPanne=" + probaPanne + ", restricAge="
				+ restricAge + ", tpsAtt=" + tpsAtt + "]";
	}
	
	public void ajoutVisiteur (Visiteur visiteur) {
		if (this.isEnMarche()) {
			System.out.println("Impossible, l'attraction " + this.getNom() +  " est en fonctionnement.");
		}
		else {
			if (this.getNbPlace() < this.getNbPlaceMax()) {
				this.getListVisiteur().add(visiteur);
				this.setNbPlace(this.getNbPlace() + 1);
				visiteur.setOccupé(true);
				System.out.println("Ajout de visiteur dans la structure " + this.getNom());
			}
			else {
				System.out.println("Impossible de rajouter un visiteur dans la structure " + this.getNom() + ". Structure pleine.");
			}
		}
	}
	
	public void supprVisiteur (Visiteur visiteur) {
		if (this.isEnMarche()) {
			System.out.println("Impossible, l'attraction " + this.getNom() +  " est en fonctionnement.");
		}
		else {
			if (this.getNbPlace() > 0)
			{
				this.getListVisiteur().remove(visiteur);
				this.setNbPlace(this.getNbPlace () - 1);
				System.out.println("Visiteur sortie de la structure " + this.getNom());
			}
			else {
				System.out.println("Impossible d'enlever un visiteur, pas de visiteur dans structure " + this.getNom());
			}	
		}
	}
}
