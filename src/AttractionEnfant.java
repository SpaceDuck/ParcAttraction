
public abstract class AttractionEnfant extends Attraction{
	
	private static final boolean RESTRIC_AGE =  false;

	public AttractionEnfant(String nom, int tpsExec, int nbPlaceMax, int tpsAtt) {
		super(nom, tpsExec, nbPlaceMax, RESTRIC_AGE, tpsAtt);
	}
	
	public void ajoutVisiteur (Visiteur visiteur) {
		if (!(this.isEnInspection())) {
			if (visiteur.isAdulte()) {
				System.out.println("Seul un enfant peu aller dans cette structure !");
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
	

}
