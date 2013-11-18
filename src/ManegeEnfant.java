
public class ManegeEnfant extends AttractionEnfant {
	
	private static final int NB_PLACE = 10;
	private static final int TPS_EXEC = 5;
	private static final int TPS_ATT = 2;
	private static final String NOM = "[Manege Enfant] ";

	public ManegeEnfant(String nom) {
		super(nom, NB_PLACE, TPS_EXEC, TPS_ATT);
		this.setNom(NOM + this.getNom());
	}
}