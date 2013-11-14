
public abstract class AttractionEau extends Attraction {

	private static final int PROBA_PANNE = 30;
	
	private AttractionEau(String nom, int nbPlace, int tpsExec, int probaPanne,
			boolean restricAge, int tpsAtt) {
		super(nom, nbPlace, tpsExec, probaPanne, restricAge, tpsAtt);
		// TODO Auto-generated constructor stub
	}

	public AttractionEau(String nom, int nbPlace, int tpsExec, boolean restricAge, int tpsAtt) {
		super(nom, nbPlace, tpsExec, PROBA_PANNE, restricAge, tpsAtt);
	}
}
