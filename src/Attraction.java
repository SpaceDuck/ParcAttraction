
public abstract class Attraction extends Structure {
	
	private int probaPanne;
	private boolean restricAge;
	private int tpsAtt;
	

	private Attraction(String nom, int nbPlace, int tpsExec) {
		super(nom, nbPlace, tpsExec, tpsExec);
	}


	public Attraction(String nom, int nbPlace, int tpsExec, int probaPanne,
			boolean restricAge, int tpsAtt) {
		super(nom, nbPlace, tpsExec, tpsAtt);
		this.probaPanne = probaPanne;
		this.restricAge = restricAge;
		this.tpsAtt = tpsAtt;
	}


	public int getProbaPanne() {
		return probaPanne;
	}


	public void setProbaPanne(int probaPanne) {
		this.probaPanne = probaPanne;
	}


	public boolean isRestricAge() {
		return restricAge;
	}


	public void setRestricAge(boolean restricAge) {
		this.restricAge = restricAge;
	}


	public int getTpsAtt() {
		return tpsAtt;
	}


	public void setTpsAtt(int tpsAtt) {
		this.tpsAtt = tpsAtt;
	}


	@Override
	public String toString() {
		return "Attraction [probaPanne=" + probaPanne + ", restricAge="
				+ restricAge + ", tpsAtt=" + tpsAtt + "]";
	}
}
