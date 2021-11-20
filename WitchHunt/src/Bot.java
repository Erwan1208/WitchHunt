

public class Bot extends Joueur {

    public Bot(String username) {
		super(username);
		// TODO Auto-generated constructor stub
	}
    
    public void jouer(Joueur c) {
    	super.jouer(c);
    }
	
	public String accuser() {
    	super.accuserJoueur(null);
    }
	
	/**
	 * 
	 * @param strategiemethode
	 * @param num
	 */
	public static void jouer(Strategie strategiemethode,int num){
		strategiemethode.jouer(num);
	}
	
	/**
	 * Methode pour jouer un BOT en Facile
	 * 
	 * @param i
	 */
	public static void JouerFacile(int i) {
		System.out.println("C'est le BOT qui joue facile");
		jouer(new FacileStrategie(), i);
	}

	/**
	 * Methode pour jouer un BOT en Moyen
	 * 
	 * @param i
	 */
	public static void JouerMoyen(int i) {
		
		System.out.println("C'est le BOT qui joue moyen");
		
		jouer(new MoyenStrategie(), i);
		
		
	}

	/**
	 * Methode pour jouer un BOT en Difficile
	 * 
	 * @param i
	 */
	public static void JouerDifficile(int i) {
		System.out.println("C'est le BOT qui joue difficile");
		
		jouer(new DifficileStrategie(), i);
	}

	

}
