
public class Bulle extends AttractionEau {
	
	private static final boolean RESTRIC_AGE = false;
	
	private Bulle(String nom, int nbPlace, int tpsExec, boolean restricAge,
			int tpsAtt) {
		super(nom, nbPlace, tpsExec, restricAge, tpsAtt);
		// TODO Auto-generated constructor stub
	}

	public Bulle(String nom, int nbPlace, int tpsExec,
			int tpsAtt) {
		super(nom, nbPlace, tpsExec, RESTRIC_AGE, tpsAtt);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
