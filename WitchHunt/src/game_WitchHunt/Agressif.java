package game_WitchHunt;

import Java.util.Random;

import game_WitchHunt.Bot;
import game_WitchHunt.Identite;
import game_WitchHunt.Partie;
import game_WitchHunt.Joueur;
import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

public class Agressif implements Strategie {

    public void jouer(Joueur c) {
    	int m;
    	
    	// trouver un moyen de faire passer l'attribut personnage de Identité ici
    	private String personnage;
    	
    	public Joueur accuserJoueur(Joueur c, Rumeur rumeur, Identite Identite, Partie Partie) {
    		System.out.println("Le BOT va accuser un joueur d'être une sorcière ! \n");
    		//Choisir un joueur au hasard parmi la liste de joueurs
    		int randomNumber = (int) Math.random();
        	int i = randomNumber * Partie.get_nbJoueurs();
    	    //System.out.println(Partie.joueur.get(i) + "vous êtes accusé par le BOT d'être une sorcière !\n");
    	    return Partie.joueur.get(i);
    	}
    	
    	
    	/*
    	public void jouer(Joueur c, Rumeur rumeur, Identite Identite, Partie Partie) {
       	 
        	//Adopter une stratégie de jeux au hasard
        	
        	int randNumber = (int) Math.random();
        	int d = randNumber * 2;

        	if (d == 0) {
        		System.out.println("Le Bot va accuser"+c.accuserJoueur()+"d'être une sorcière !");
        		this.Rumeur();
        		
        	}
        	else if( d == 1) {
        		System.out.println("Le BOT va jouer sa carte Identité ! \n");
        		if Bot.Identite == 
        	}
    	}*/
    	
    	//private game_WitchHunt.EffetWitch EffetWitch;
        public void jouer(Joueur b, int compteur_cartes,Identite identite, EffetHunt EffetHunt, EffetWitch EffetWitch, Partie Partie) {
       	
        //différente strategie selon l'identité du BOT
       	// si Sorcière = éviter à tout pris de révéler son identité
       	// si Vilageois c'est pas si grave
       	
       	String test="Villageois";
       	compteur_cartes1 = 12/Partie.get_nbJoueurs();
   		if (test == "Sorcière") {
       		while (compteur_cartes1 != 1) {
       			Joueur accuse = this.accuserJoueur(Joueur c, Rumeur rumeur, Partie Partie);
       			int randomNumber2 = (int) Math.random();
       	    	int j = randomNumber2 * 101;
       	    	if (j == 0) {
       	    		((game_WitchHunt.EffetHunt) this.EffetHunt).EffetHunt(accuse.getPseudo());
       	    		compteur_cartes1--;
       	    	}
       	    	if (j == 1) {
       	    		((game_WitchHunt.EffetWitch) this.EffetWitch).EffetWitch(accuse.getPseudo());
       	    		compteur_cartes1--;
       	    	}
       		}
       		if (compteur_cartes1 == 1) {
       			this.identite.revelerIdentite();
       		}
       	}
       	
       	else if(test == "Villageois") {
       		int randomNumber3 = (int) Math.random();
   	    	int k = randomNumber3 * 11;
   	    	if (k > 0 && k<8) {
   	    		int randomNumber4 = (int) Math.random();
   		    	int l = randomNumber4 * 2;
   		    	if (l == 0) {
   		    		((game_WitchHunt.EffetHunt) this.EffetHunt).EffetHunt(accuse.getPseudo());
       	    		compteur_cartes1--;
   		    	}
   		    	else if (l == 1) {
   		    		((game_WitchHunt.EffetWitch) this.EffetWitch).EffetWitch(accuse.getPseudo());
       	    		compteur_cartes1--;
   		    	}
   	    	}
   	    	
   	    	else if ( k >= 8) {
   	    		this.identite.revelerIdentite();
   	    	}
       	}
        	
        	
        	
        	 //sélection du joueur à accuser
        	 //Joueur joueur = new Joueur(personnage);
        	 //List<Joueur> joueur1 = Partie.getList();
     		
        	
        	
        }

    	
    }

	

}
