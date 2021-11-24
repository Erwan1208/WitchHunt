package game_WitchHunt;

import Java.util.Random;

import game_WitchHunt.Bot;
import game_WitchHunt.Identite;
import game_WitchHunt.Partie;
import game_WitchHunt.Joueur;
import game_WitchHunt.EffetHunt;
import game_WitchHunt.EffetWitch;
import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;



/**
 * Interface de la classe Strat�gie pour d�finir un comportement de jeux "Doux" pour le BOT
 * Mod�lisation d'un cycle de jeu
 * @author aurel
 *
 */
public class Doux implements Strategie {
	int n;
	
	// trouver un moyen de faire passer l'attribut personnage de Identit� ici
	private String personnage;
	
	private String identite;

	//private int compteur_cartes1;
	
	
	public Joueur accuserJoueur(Joueur c, Rumeur rumeur, Partie Partie) {
		System.out.println("Le BOT va accuser un joueur d'�tre une sorci�re ! \n");
		//Choisir un joueur au hasard parmi la liste de joueurs
		int randomNumber = (int) Math.random();
    	int i = randomNumber * Partie.get_nbJoueurs();
	    //System.out.println(Partie.joueur.get(i) + "vous �tes accus� par le BOT d'�tre une sorci�re !\n");
	    return Partie.joueur.get(i);
	}
	
	 
	private game_WitchHunt.EffetWitch EffetWitch;
    public void jouer(Partie Partie, Rumeur rumeur, Identite identite, EffetHunt EffetHunt,EffetWitch EffetWitch) {
    	 //diff�rente strategie selon l'identit� du BOT
    	// si Sorci�re = �viter � tout pris de r�v�ler son identit�
    	// si Vilageois c'est pas si grave
    	int compteur_cartes1;
    	String test=this.identite;
    	compteur_cartes1 = 12/Partie.get_nbJoueurs();
		if (test == "Sorci�re") {
    		while (compteur_cartes1 != 1) {
    			Joueur accuse = this.accuserJoueur(c, rumeur, Partie);
    			int randomNumber2 = (int) Math.random();
    	    	int j = randomNumber2 * 2;
    	    	if (j == 0) {
    	    		//appliquer la m�thode EffetHunt de la classe EffetHunt sur une carte que le joueur joue
    	    		
    	    		compteur_cartes1--;
    	    	}
    	    	if (j == 1) {
    	    		//appliquer la m�thode EffetHunt de la classe EffetHunt sur une carte que le joueur joue
    	    		
    	    		compteur_cartes1--;
    	    	}
    		}
    		if (compteur_cartes1 == 1) {
    			this.identite.revelerIdentite();
    		}
    	}
    	
    	else if(test == "Villageois") {
    		int randomNumber3 = (int) Math.random();
	    	int k = randomNumber3 * 2;
	    	if (k == 0) {
	    		int randomNumber4 = (int) Math.random();
		    	int l = randomNumber4 * 2;
		    	if (l == 0) {
		    		//appliquer la method� EffetHunt de la classe EffetHunt sur le joueur accus�
		    		((game_WitchHunt.EffetHunt) this.EffetHunt).EffetHunt(accuse.getPseudo());
    	    		compteur_cartes1--;
		    	}     
		    	else if (l == 1) {
		    		//appliquer la m�thode EffetWith de la classe EffetWitch sur le joueur accus�
		    		((game_WitchHunt.EffetWitch) this.EffetWitch).EffetWitch(accuse.getPseudo());
    	    		compteur_cartes1--;
		    	}
	    	}
	    	
	    	else if ( k == 1) {
	    		this.identite.revelerIdentite();
	    	}
    	}
    	
	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	//Adopter une strat�gie de jeux au hasard qui suit une loi uniforme
    	int randNumber = (int) Math.random();
    	int d = randNumber * 2;
    	
    	//Adopter une strat�gie de jeux au hasard qui ne suit pas une loi uniforme
    	
    	

    	if (d == 0) {
    		System.out.println("Le Bot va accuser"+c.accuserJoueur()+"d'�tre une sorci�re !");
    		this.Rumeur();
    		
    	}
    	else if( d == 1) {
    		System.out.println("Le BOT va jouer sa carte Identit� ! \n");
    		if Bot.identite == 
    	}
    	
    	
    	 //s�lection du joueur � accuser
    	 //Joueur joueur = new Joueur(personnage);
    	 //List<Joueur> joueur1 = Partie.getList();
 		
    	
    	
    }




	private void EffetWitch(String pseudo) {
		// TODO Auto-generated method stub
		
	}






	private void EffetHunt(String pseudo) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void jouer(Joueur c) {
		// TODO Auto-generated method stub
		
	}

}
