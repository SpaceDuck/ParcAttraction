
public class Bulle extends AttractionEau {
	
	private static final int NB_PLACE = 4;
	private static final int TPS_EXEC = 4;
	private static final int TPS_ATT = 2;
	private static final String NOM = "[Bulle] ";

	public Bulle(String nom) {
		super(nom, NB_PLACE, TPS_EXEC, TPS_ATT);
		this.setNom(NOM + this.getNom());
	}
}