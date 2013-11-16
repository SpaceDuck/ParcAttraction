
public abstract class AttractionEau extends Attraction {
	
	private static final boolean RESTRIC_AGE = false;

	private AttractionEau(String nom, int tpsExec, int nbPlaceMax, boolean restricAge, int tpsAtt) {
		super(nom, tpsExec, nbPlaceMax, restricAge, tpsAtt);
		// TODO Auto-generated constructor stub
	}

	public AttractionEau(String nom, int tpsExec, int nbPlaceMax, int tpsAtt) {
		super(nom, tpsExec, nbPlaceMax, RESTRIC_AGE, tpsAtt);
	}
}
