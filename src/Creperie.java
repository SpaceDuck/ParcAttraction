
public class Creperie extends Boutique {

	private static final int PRIX = 3;
	private static final int TPS_EXEC = 6;
	private static final int NB_PLACE_MAX = 5;
	
	private Creperie(String nom, int tpsExec, int nbPlaceMax, int prix) {
		super(nom, tpsExec, nbPlaceMax, prix);
		// TODO Auto-generated constructor stub
	}

	public Creperie(String nom) {
		super(nom, TPS_EXEC, NB_PLACE_MAX, PRIX);
		// TODO Auto-generated constructor stub
	}
	
}
