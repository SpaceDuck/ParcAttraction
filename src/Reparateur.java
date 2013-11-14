
public class Reparateur extends Employe{

	private static final String METIER = "Réparateur";
	
	private Reparateur(String nom, String metier) {
		super(nom, metier);
		// TODO Auto-generated constructor stub
	}
	
	public Reparateur(String nom) {
		super(nom, METIER);
		// TODO Auto-generated constructor stub
	}

	public void reparerAttraction(Attraction a){
		a.setProbaPanne(0);
	}
}
