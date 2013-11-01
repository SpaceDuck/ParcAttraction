
public class MontagneRusse extends AttractionSensation{
	
	private static final boolean RESTRIC_AGE = true;

	private MontagneRusse(String nom, int nbPlace, int tpsExec,
			boolean restricAge, int tpsAtt) {
		super(nom, nbPlace, tpsExec, restricAge, tpsAtt);
		this.setNom("[Montagne Russe] " + this.getNom());
	}
	
	public MontagneRusse(String nom, int nbPlace, int tpsExec, int tpsAtt) {
		super(nom, nbPlace, tpsExec, RESTRIC_AGE, tpsAtt);
		this.setNom("[Montagne Russe] " + this.getNom());
	}
}
