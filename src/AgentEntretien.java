
public class AgentEntretien extends Employe {

	private static final String METIER = "Agent d'entretient";
	
	private AgentEntretien(String nom, String metier) {
		super(nom, metier);
		// TODO Auto-generated constructor stub
	}
	
	public AgentEntretien(String nom) {
		super(nom, METIER);
		// TODO Auto-generated constructor stub
	}

	public void nettoyerStructure(Structure s){
		s.setNivPropre(100);
	}
	
}
