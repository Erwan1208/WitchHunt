package game_WitchHunt;

public class Gerant extends Joueur {

	public Gerant(Partie p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
		public void jouer() {
	    	super.jouerTour();
	    }
		
		public String accuser() {
	    	return super.choisirNomAccuse();
	    }
	
}
