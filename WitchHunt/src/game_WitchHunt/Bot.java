package game_WitchHunt;

import game_WitchHunt.Doux;

import java.util.List;

import game_WitchHunt.Agressif;
import game_WitchHunt.Joueur;

public class Bot extends Joueur {

	private Strategie Strategy_jouee;
	
    public Bot(Partie p) {
		super(p);
		Strategy_jouee = new Doux();
		// TODO Auto-generated constructor stub
	}
    
    public String accuser() {
    	return super.choisirNomAccuse();
    }
	
    public static void JouerDoux(Joueur a) {
    	System.out.println("Le BOT joue facile.");
    	Partie partie;
    	Identite identite;
    	List<Rumeur> rumeurs;
    	EffetWitch effetwitch;
    	EffetHunt effetHunt;
    	//jouer(partie,identite,rumeurs,effetwitch,effetHunt);
    	//jouer(new Doux());
    }
    
    public static void JouerAgressif(Joueur a) {
    	System.out.println("Le BOT joue agressif.");
    	Partie partie;
    	Identite identite;
    	List<Rumeur> rumeurs;
    	EffetWitch effetwitch;
    	EffetHunt effetHunt;
    	//jouer(partie,identite,rumeurs,effetwitch,effetHunt);
    	//jouer(new Agressif());
    }
	
	


}
