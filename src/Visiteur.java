import java.util.Random;


public class Visiteur {
	private boolean adulte;
	private int porteMonnaie;
	private int dureeVie;
	private boolean occup�;
	
	public Visiteur(boolean adulte, int porteMonnaie, int dureeVie) {
		super();
		this.adulte = adulte;
		
		if (adulte) {
			this.porteMonnaie = porteMonnaie;
		}
		else {
			this.porteMonnaie = 0;
		}
		
		this.dureeVie = dureeVie;
	}

	public boolean isAdulte() {
		return adulte;
	}

	public void setAdulte(boolean adulte) {
		this.adulte = adulte;
	}

	public int getPorteMonnaie() {
		return porteMonnaie;
	}

	public void setPorteMonnaie(int porteMonnaie) {
		this.porteMonnaie = porteMonnaie;
	}

	public int getDureeVie() {
		return dureeVie;
	}

	public void setDureeVie(int dureeVie) {
		this.dureeVie = dureeVie;
	}

	public boolean isOccup�() {
		return occup�;
	}

	public void setOccup�(boolean occup�) {
		this.occup� = occup�;
	}
	
	public void searchStruct (Parc parc) {
		Random rand = new Random ();
		int nbRand = rand.nextInt(parc.getNbStruct()) + 1;
		int i = 1;
		
		for (Structure s : parc.getListStruct()) {
			if (i == nbRand) {
				s.ajoutVisiteur(this);
				if (this.occup�) {
					break;
				}
				else {
					this.searchStruct(parc);
				}
			}
			++i;
		}
	}

	@Override
	public String toString() {
		return "Visiteur [adulte=" + adulte + ", porteMonnaie=" + porteMonnaie
				+ ", dureeVie=" + dureeVie + ", occup�=" + occup� + "]";
	}
	
}
