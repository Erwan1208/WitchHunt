

public class Gerant extends Joueur {

	public Gerant(String username) {
		super(username);
		// TODO Auto-generated constructor stub
	}
		public void jouer(Joueur c) {
	    	super.jouer(c);
	    }
		
		public String accuser() {
	    	super.accuserJoueur(null);
	    }
	
}
