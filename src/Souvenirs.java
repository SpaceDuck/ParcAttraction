
public class Souvenirs extends Boutique {

	private static final int PRIX = 5;
	private static final int TPS_EXEC = 5;
	private static final int NB_PLACE_MAX = 6;
	
	private Souvenirs(String nom, int tpsExec, int nbPlaceMax, int prix) {
		super(nom, tpsExec, nbPlaceMax, prix);
		// TODO Auto-generated constructor stub
	}
	
	public Souvenirs(String nom) {
		super(nom, TPS_EXEC, NB_PLACE_MAX, PRIX);
		// TODO Auto-generated constructor stub
	}

}
