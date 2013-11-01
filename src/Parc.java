import java.util.ArrayList;
import java.util.List;


public class Parc {
	private String nom;
	private int hDeb;
	private int hFin;
	private int nbStruct;
	private final int NB_STRUCT_MAX;
	private List<Structure> listStruct = new ArrayList<Structure> ();
	private int nbVisiteur;
	private final int NB_VISITEUR_MAX;
	private List<Visiteur> listVisiteur = new ArrayList<Visiteur> ();
	
	public Parc(String nom, int hDeb, int hFin, int nbStruct,
			int nB_STRUCT_MAX, List<Structure> listStruct, int nbVisiteur,
			int nB_VISITEUR_MAX, List<Visiteur> listVisiteur) {
		super();
		this.nom = nom;
		this.hDeb = hDeb;
		this.hFin = hFin;
		this.nbStruct = nbStruct;
		NB_STRUCT_MAX = nB_STRUCT_MAX;
		this.listStruct = listStruct;
		this.nbVisiteur = nbVisiteur;
		NB_VISITEUR_MAX = nB_VISITEUR_MAX;
		this.listVisiteur = listVisiteur;
	}

	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public int gethDeb() {
		return hDeb;
	}



	public void sethDeb(int hDeb) {
		this.hDeb = hDeb;
	}



	public int gethFin() {
		return hFin;
	}



	public void sethFin(int hFin) {
		this.hFin = hFin;
	}



	public int getNbStruct() {
		return nbStruct;
	}



	public void setNbStruct(int nbStruct) {
		this.nbStruct = nbStruct;
	}



	public List<Structure> getListStruct() {
		return listStruct;
	}



	public void setListStruct(List<Structure> listStruct) {
		this.listStruct = listStruct;
	}



	public int getNbVisiteur() {
		return nbVisiteur;
	}



	public void setNbVisiteur(int nbVisiteur) {
		this.nbVisiteur = nbVisiteur;
	}



	public List<Visiteur> getListVisiteur() {
		return listVisiteur;
	}



	public void setListVisiteur(List<Visiteur> listVisiteur) {
		this.listVisiteur = listVisiteur;
	}



	public int getNB_STRUCT_MAX() {
		return NB_STRUCT_MAX;
	}



	public int getNB_VISITEUR_MAX() {
		return NB_VISITEUR_MAX;
	}
	
	//TEST
	public static void main(String[] args) {
		MontagneRusse mont = new MontagneRusse("Truc de la mort", 2, 10, 5);
		Visiteur v1 = new Visiteur(true, 10, 2);
		Visiteur v2 =  new Visiteur (true, 10, 2);
		Visiteur v3 = new Visiteur(true, 10, 2);
		
		mont.ajoutVisiteur(v1);
		mont.ajoutVisiteur(v2);
		mont.ajoutVisiteur(v3);
		
		System.out.println(v1 + "\n" + v2 + "\n"+ v3 + "\n" + mont);
		
		mont.supprVisiteur(v2);
		
		System.out.println(v1 + "\n" + v2 + "\n"+ v3 + "\n" + mont);
		
		mont.setEnMarche(true);
		
		System.out.println(v1 + "\n" + v2 + "\n"+ v3 + "\n" + mont);
		
		mont.ajoutVisiteur(v2);
		mont.supprAllVisiteur();
		
		System.out.println(v1 + "\n" + v2 + "\n"+ v3 + "\n" + mont);
		
		mont.setEnMarche(false);
		
		System.out.println(v1 + "\n" + v2 + "\n"+ v3 + "\n" + mont);
		
		mont.ajoutVisiteur(v2);
		mont.supprAllVisiteur();
		
		System.out.println(v1 + "\n" + v2 + "\n"+ v3 + "\n" + mont);
	}

}
