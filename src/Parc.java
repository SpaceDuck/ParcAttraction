import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parc {
	private String nom;
	private int hDeb;
	private int hFin;
	private int nbStruct = 0;
	private int nbStrucMax = 0;
	private List<Structure> listStruct = new ArrayList<Structure> ();
	private List<Attraction> listAttract = new ArrayList<Attraction> ();
	private List<Boutique> listBoutique = new ArrayList<Boutique> ();
	private List<AgentEntretien> listAgentEntretien = new ArrayList<AgentEntretien>();
	private List<Reparateur> listReparateur = new ArrayList<Reparateur>();
	private int nbVisiteur = 0;
	private int nbVisiteurMax = 0;
	private List<Visiteur> listVisiteur = new ArrayList<Visiteur> ();
	
	private static final int COEFF_VISTEUR = 4; //nombre de visiteurs par rapport au nombre de structures
	private static final int COEFF_ADULTE = 4; //nombre d'adultes par rapport au nombre de visiteurs
	private static final int COEFF_AGENT_ENTRETIEN = 2; //nombre d'agents d'entretien par rapport au structure
	private static final int COEFF_REPARATEUR = 3; //nombre de réparateur par rapport au nombre d'attraction
	
	/*
	 * exemple :
	 * Pour 5 structures dont 3 attractions avec 
	 * COEFF_VISTEUR = 4, COEFF_ADULTE = 4, COEFF_AGENT_ENTRETIEN = 2, COEFF_REPARATEUR = 3;
	 * On a :
	 * - 20 visiteurs,
	 * - dont 16 adultes (approximativement),
	 * - 2 agents d'entretien,
	 * - 1 réparateur.
	 */
	
	public Parc(String nom, int hDeb, int hFin, int nbStruct,
			int nbStrucMax, List<Attraction> listAttract, int nbVisiteur,
			int nbVisiteurMax, List<Visiteur> listVisiteur) {
		super();
		this.nom = nom;
		this.hDeb = hDeb;
		this.hFin = hFin;
		this.nbStruct = nbStruct;
		this.nbStrucMax = nbStrucMax;
		this.listAttract = listAttract;
		this.nbVisiteur = nbVisiteur;
		this.nbVisiteurMax = nbVisiteurMax;
		this.listVisiteur = listVisiteur;
	}

	public Parc(String nom, int nbStrucMax, int nbVisiteurMax) {
		super();
		this.nom = nom;
		this.nbStrucMax = nbStrucMax;
		this.nbVisiteurMax = nbVisiteurMax;
	}
	
	public Parc () {
		super ();
	}
	
	public void ajoutVisiteur (Visiteur visiteur) {
		if (this.nbVisiteur < this.nbVisiteurMax) {
			this.listVisiteur.add(visiteur);
			++ this.nbVisiteur;
			System.out.println("Ajout de visiteur dans le parc " + this.nom);
		}
		else {
			System.out.println("Impossible de rajouter un visiteur dans le parc " + this.nom + ". Parc plein.");
		}
	}
	
	public void ajoutStructure (Attraction attraction) {
		if (this.nbStruct < this.nbStrucMax) {
			this.listAttract.add(attraction);
			this.listStruct.add(attraction);
			++ this.nbStruct;
			System.out.println("Ajout d'une structure dans le parc " + this.nom);
		}
		else {
			System.out.println("Impossible de rajouter une structure dans le parc " + this.nom + ". Parc plein.");
		}
	}
	
	public void ajoutStructure (Boutique boutique) {
		if (this.nbStruct < this.nbStrucMax) {
			this.listBoutique.add(boutique);
			this.listStruct.add(boutique);
			++ this.nbStruct;
			System.out.println("Ajout d'une structure dans le parc " + this.nom);
		}
		else {
			System.out.println("Impossible de rajouter une structure dans le parc " + this.nom + ". Parc plein.");
		}
	}
	
	public void ajoutAgentEntretien(AgentEntretien agentEntretien){
		this.listAgentEntretien.add(agentEntretien);
	}
	
	public void ajoutReparateur(Reparateur reparateur){
		this.listReparateur.add(reparateur);
	}
	
	public List<AgentEntretien> getListAgentEntretien() {
		return listAgentEntretien;
	}

	public List<Reparateur> getListReparateur() {
		return listReparateur;
	}
	
	@Override
	public String toString() {
		return "Parc [nom=" + nom + ", hDeb=" + hDeb + ", hFin=" + hFin
				+ ", nbStruct=" + nbStruct + ", nbStrucMax=" + nbStrucMax
				+ ", listStruct=" + listStruct + ", listAttract=" + listAttract
				+ ", listBoutique=" + listBoutique + ", listAgentEntretien="
				+ listAgentEntretien + ", listReparateur=" + listReparateur
				+ ", nbVisiteur=" + nbVisiteur + ", nbVisiteurMax="
				+ nbVisiteurMax + ", listVisiteur=" + listVisiteur + "]";
	}

	public void allVisiteurSearch () {
		for (Visiteur v : listVisiteur) {
			if (!(v.isOccupe())) {
				v.searchStruct(this);
			}
		}
	}
	
	public void allAttractExec () {
		for (Attraction a : listAttract) {
			if (!(a.isEnMarche())) {
				try {
					a.exec(this);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void allAttractRepar () {
		for (Attraction a : listAttract) {
			if (!(a.isEnMarche())) {
				try {
					a.appelReparateur(this);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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

	public List<Attraction> getListAttract() {
		return listAttract;
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



	public int getNbStrucMax() {
		return nbStrucMax;
	}
	
	public void setNbStrucMax(int nbStrucMax) {
		this.nbStrucMax = nbStrucMax;
	}



	public int getNbVisiteurMax() {
		return nbVisiteurMax;
	}
	
	public void setNbVisiteurMax (int nbVisiteurMax) {
		this.nbVisiteurMax = nbVisiteurMax;
	}
	
	
	public int getCoeffVisiteur () {
		return COEFF_VISTEUR;
	}
	
	public int extractInt(String str) {
        Matcher matcher = Pattern.compile("\\d+").matcher(str);

        if (!matcher.find())
            return 0;
        
       	return Integer.parseInt(matcher.group());
	}
	
	public void creationVisiteur ()
	{
		boolean adulte;
		int porteMonnaie;
		final int HIGHER = 100;
		int random;
		
		for (int i = 0; i < this.nbVisiteurMax; ++i) {
			random = (int)(Math.random() * COEFF_ADULTE);
			if (random == 0) {
				adulte = false;
				porteMonnaie = 0;
			}
			else {
				adulte = true;
				porteMonnaie = (int)(Math.random() * (HIGHER));
			}
			this.ajoutVisiteur(new Visiteur(adulte, porteMonnaie, 1));
		}
	}
	
	//TEST
	public void test1 () {
		MontagneRusse mont = new MontagneRusse("Truc de la mort");
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
		MontagneRusse mont1 = new MontagneRusse("Truc de la mort 1");
		MontagneRusse mont2 = new MontagneRusse("Truc de la mort 2");
		MontagneRusse mont3 = new MontagneRusse("Truc de la mort 3");
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
	
	public void test3 () {
		MontagneRusse mont1 = new MontagneRusse("Truc de la mort 1");
		MontagneRusse mont2 = new MontagneRusse("Truc de la mort 2");
		MontagneRusse mont3 = new MontagneRusse("Truc de la mort 3");
		Bulle bulle1 = new Bulle("Mon jeu aquatique");
		
		Visiteur v1 = new Visiteur(true, 10, 2);
		Visiteur v2 =  new Visiteur (true, 10, 2);
		Visiteur v3 = new Visiteur(true, 10, 2);
		Visiteur v4 = new Visiteur(true, 10, 2);
		Visiteur v5 =  new Visiteur (true, 10, 2);
		Visiteur v6 = new Visiteur(true, 10, 2);
		
		this.ajoutStructure(mont1);
		this.ajoutStructure(mont2);
		this.ajoutStructure(mont3);
		this.ajoutStructure(bulle1);
		this.ajoutVisiteur(v1);
		this.ajoutVisiteur(v2);
		this.ajoutVisiteur(v3);
		this.ajoutVisiteur(v4);
		this.ajoutVisiteur(v5);
		this.ajoutVisiteur(v6);
		
		this.allVisiteurSearch();
		this.allAttractExec();
		
		this.allVisiteurSearch();
		this.allAttractExec();
	}
	
	public void test4 () {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bonjour et bienvenue sur la simulation de parc d'attraction.");
		
		//création du parc
		System.out.println("Pour commencer ... \nQuel est le nom de votre parc ?");
		this.setNom(sc.nextLine());
		
		while (this.getNbStrucMax() == 0) {			
			System.out.println("Ensuite, quel est la taille du parc ? -> nombre de structure (boutiques et attractions) maximal");
			this.setNbStrucMax(extractInt(sc.nextLine()));
			
			if (this.getNbStrucMax() == 0) {
				System.out.println("Le parc doit avoir au moins une structure !");
			}
		}
		
		//création des visiteurs
		this.setNbVisiteurMax(this.getNbStrucMax() * this.getCoeffVisiteur());
		System.out.println("Création des visteurs ...");
		this.creationVisiteur();
		System.out.println(this.listVisiteur);
		
		System.out.println("Le parc est créé ! \n\nMaintenant il faut creer les structures ...\nCombien y aura-t-il d'attractions ?");
		int nbAttract =  extractInt(sc.nextLine());
		
		while (nbAttract == 0) {
			System.out.println("Il ne peu y avoir aucune attraction ... Sinon ça ne serait pas un parc d'attraction ! \n\n");
			System.out.println("Combien y aura-t-il d'attractions ?");
			
			nbAttract =  extractInt(sc.nextLine());
		}
		
		if (nbAttract > this.getNbStrucMax()) {
			nbAttract = this.getNbStrucMax();
		}
		
		System.out.println("Nous allons donc maintenant creer les attractions !");
		String nom = new String ();
		for (int i = 0, choix = 0; i < nbAttract; ++i, choix = 0) {
			while (choix == 0) {
				System.out.println("Vous avez le choix entre : \n  Attraction à sensation \n    1 -> Montagne Russe \n  Attraction aquatique \n    2 -> Bulle");
				System.out.println("Faites votre choix ! (entrez un nombre)");
				choix = extractInt(sc.nextLine());
				
				switch (choix) {
				  case 1 :
					  System.out.println("Son nom ?");
					  nom = sc.nextLine();
					  this.ajoutStructure(new MontagneRusse(nom)); 
					  break;
				  case 2 :
					  System.out.println("Son nom ?");
					  this.ajoutStructure(new Bulle(sc.nextLine()));
					  break;
				  default :
					  System.out.println("Erreur, merci de rentrer un nombre dans les choix proposé.");
					  choix = 0;
				}
			}
		}
		
		//création des boutiques
		if (nbAttract == this.getNbStrucMax()) {
			System.out.println("Impossible de rajouter des boutiques dans le parc, le nombre de structure est déjà au maximum.");
		}
		else {
			System.out.println("Maintenant nous allons ajouter la (les) boutique(s)");
			int nbBoutique = this.getNbStrucMax() - nbAttract;
			
			for (int i = 0, choix = 0; i < nbBoutique; ++i, choix = 0) {
				while (choix == 0) {
					System.out.println("Vous avez le choix entre : \n  1 -> Creperie \n  2 -> Souvenir");
					System.out.println("Faites votre choix ! (entrez un nombre)");
					choix = extractInt(sc.nextLine());
					
					switch (choix) {
					  case 1 :
						  System.out.println("Son nom ?");
						  this.ajoutStructure(new Souvenirs(sc.nextLine())); 
						  break;
					  case 2 :
						  System.out.println("Son nom ?");
						  this.ajoutStructure(new Creperie(sc.nextLine())); 
						  break;
					  default :
						  System.out.println("Erreur, merci de rentrer un nombre dans les choix proposé.");
						  choix = 0;
					}
				}
			}
		}
		
		//création des agents d'entretien
		int nbEmploye = this.nbStruct / COEFF_AGENT_ENTRETIEN;
		System.out.println("Enfin, pour finir, il faut embaucher le personnel pour la maintenance du parc.\nPour commencer " + nbEmploye + " agents d'entretiens.\n");
		
		for (int i = 0; i < nbEmploye; ++i) {
			System.out.println("Nom de l'agent " + i + " : ");
			nom = sc.nextLine();
			this.ajoutAgentEntretien(new AgentEntretien(nom));	
		}
		
		//création des réparateurs
		nbEmploye = nbAttract / COEFF_REPARATEUR;
		
		System.out.println("Et enfin, le(s) réparateur(s) d'attraction(s).\n Il y en aura " + nbEmploye);
		for (int i = 0; i < nbEmploye; ++i) {
			System.out.println("Nom du répateur " + i + " : ");
			nom = sc.nextLine();
			this.ajoutReparateur(new Reparateur(nom));	
		}
		
		System.out.println("La création du parc est terminée.\nLa simulation commence dans 3sec...");
		try {
			Thread.sleep(1000);
			System.out.println("2sec...");
			Thread.sleep(1000);
			System.out.println("1sec...");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		while (sc.nextLine() != "exit") {
			this.allVisiteurSearch();
			this.allAttractExec();
		}
		
		sc.close();
	}
	
	public static void main(String[] args) {
		Parc parc = new Parc();
		parc.test4();
	}

}
