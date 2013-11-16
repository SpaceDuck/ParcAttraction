
public abstract class Boutique extends Structure {

	private int prix;
	private final static boolean RESTRIC_AGE = true;
	
	private Boutique(String nom, int tpsExec, int nbPlaceMax,
			boolean restricAge) {
		super(nom, tpsExec, nbPlaceMax, restricAge);
		// TODO Auto-generated constructor stub
	}
	public Boutique(String nom, int tpsExec, int nbPlaceMax, int prix) {
	
		super(nom, tpsExec, nbPlaceMax, RESTRIC_AGE);
		// TODO Auto-generated constructor stub
		this.prix = prix;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
}
