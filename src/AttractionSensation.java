
public abstract class AttractionSensation extends Attraction{
	
	private static final int PROBA_PANNE = 60;

	private AttractionSensation(String nom, int nbPlace, int tpsExec,
			int probaPanne, boolean restricAge, int tpsAtt) {
		super(nom, nbPlace, tpsExec, probaPanne, restricAge, tpsAtt);
	}
	
	public AttractionSensation(String nom, int nbPlace, int tpsExec, boolean restricAge, int tpsAtt) {
		super(nom, nbPlace, tpsExec, PROBA_PANNE, restricAge, tpsAtt);
	}

}
