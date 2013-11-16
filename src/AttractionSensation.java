
public abstract class AttractionSensation extends Attraction{
	
	private static final boolean RESTRIC_AGE =  true;

	public AttractionSensation(String nom, int tpsExec, int nbPlaceMax, int tpsAtt) {
		super(nom, tpsExec, nbPlaceMax, RESTRIC_AGE, tpsAtt);
	}	
	

}
