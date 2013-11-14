
public class Souvenirs extends Boutique {

	private static final int PRIX = 5;
	private static final int TPS_EXEC = 5;
	
	private Souvenirs(String nom, int nbPlace, int tpsExec, int nbPlaceMax,
			int prix) {
		super(nom, nbPlace, tpsExec, nbPlaceMax, prix);
		// TODO Auto-generated constructor stub
	}
	
	public Souvenirs(String nom, int nbPlace, int nbPlaceMax) {
		super(nom, nbPlace, TPS_EXEC, nbPlaceMax, PRIX);
		// TODO Auto-generated constructor stub
	}

}
