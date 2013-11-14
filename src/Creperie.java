
public class Creperie extends Boutique {

	private static final int PRIX = 3;
	private static final int TPS_EXEC = 6;
	
	private Creperie(String nom, int nbPlace, int tpsExec, int nbPlaceMax,
			int prix) {
		super(nom, nbPlace, tpsExec, nbPlaceMax, prix);
		// TODO Auto-generated constructor stub
	}

	public Creperie(String nom, int nbPlace, int nbPlaceMax) {
		super(nom, nbPlace, TPS_EXEC, nbPlaceMax, PRIX);
		// TODO Auto-generated constructor stub
	}
	
}
