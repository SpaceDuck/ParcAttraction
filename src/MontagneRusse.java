
public class MontagneRusse extends AttractionSensation{
	
	private static final int NB_PLACE = 4;
	private static final int TPS_EXEC = 5;
	private static final int TPS_ATT = 3;
	private static final String NOM = "[Montagne Russe] ";
	
	public MontagneRusse(String nom) {
		super(nom, NB_PLACE, TPS_EXEC, TPS_ATT);
		this.setNom(NOM + this.getNom());
	}
}
