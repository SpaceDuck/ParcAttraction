import java.util.ArrayList;
import java.util.List;


public class Parc {
	private String nom;
	private int hDeb;
	private int hFin;
	private int nbStruct = 0;
	private final int NB_STRUCT_MAX;
	private List<Structure> listStruct = new ArrayList<Structure> ();
	private int nbVisiteur = 0;
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

	public Parc(String nom, int nB_STRUCT_MAX, int nB_VISITEUR_MAX) {
		super();
		this.nom = nom;
		NB_STRUCT_MAX = nB_STRUCT_MAX;
		NB_VISITEUR_MAX = nB_VISITEUR_MAX;
	}
	
	public void ajoutVisiteur (Visiteur visiteur) {
		if (this.nbVisiteur < this.NB_VISITEUR_MAX) {
			this.listVisiteur.add(visiteur);
			++ this.nbVisiteur;
			System.out.println("Ajout de visiteur dans le parc " + this.nom);
		}
		else {
			System.out.println("Impossible de rajouter un visiteur dans le parc " + this.nom + ". Parc plein.");
		}
	}
	
	public void ajoutStructure (Structure structure) {
		if (this.nbStruct < this.NB_STRUCT_MAX) {
			this.listStruct.add(structure);
			++ this.nbStruct;
			System.out.println("Ajout d'une structure dans le parc " + this.nom);
		}
		else {
			System.out.println("Impossible de rajouter une structure dans le parc " + this.nom + ". Parc plein.");
		}
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
	public void test1 () {
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
	
	public void test2 () {
		MontagneRusse mont1 = new MontagneRusse("Truc de la mort 1", 2, 10, 5);
		MontagneRusse mont2 = new MontagneRusse("Truc de la mort 2", 2, 10, 5);
		MontagneRusse mont3 = new MontagneRusse("Truc de la mort 3", 2, 10, 5);
		Visiteur v1 = new Visiteur(true, 10, 2);
		Visiteur v2 =  new Visiteur (true, 10, 2);
		Visiteur v3 = new Visiteur(true, 10, 2);
		
		this.ajoutStructure(mont1);
		this.ajoutStructure(mont2);
		this.ajoutStructure(mont3);
		this.ajoutVisiteur(v1);
		this.ajoutVisiteur(v2);
		this.ajoutVisiteur(v3);
		
		v1.searchStruct(this);
		v2.searchStruct(this);
		v3.searchStruct(this);
		
		mont1.setEnMarche(true);
		mont1.setEnMarche(false);
		mont1.supprAllVisiteur();
		
		mont2.setEnMarche(true);
		mont2.setEnMarche(false);
		mont2.supprAllVisiteur();
		
		mont3.setEnMarche(true);
		mont3.setEnMarche(false);
		mont3.supprAllVisiteur();
	}
	
	public static void main(String[] args) {
		Parc parc = new Parc("TEST", 5, 10);
		parc.test2();
	}

}
