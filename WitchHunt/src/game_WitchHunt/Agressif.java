package game_WitchHunt;

import java.util.Random;
import java.util.Scanner;

import game_WitchHunt.Bot;
import game_WitchHunt.Identite;
import game_WitchHunt.Partie;
import game_WitchHunt.Joueur;
import game_WitchHunt.EffetHunt;
import game_WitchHunt.EffetWitch;
import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;
import java.util.Scanner;

import game_WitchHunt.Bot;
import game_WitchHunt.Identite;
import game_WitchHunt.Partie;
import game_WitchHunt.Joueur;
import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

public class Agressif implements Strategie{
	int n;
	
	// trouver un moyen de faire passer l'attribut personnage de Identité ici
	//private String personnage;
	
	private Identite identite;
	
	//private game_WitchHunt.EffetWitch effetWitch;

	//private int compteur_cartes1;
	
	
	public String choisirNomAccuse() {
    	System.out.println("Donner le pseudo de la personne que vous voulez accuser!\n");
    	Scanner sc = new Scanner(System.in);
    	String nomAccuse = sc.next();
    	sc.close();
    	return nomAccuse;
    }
	
	public void jouer(Partie partie, Identite identite, List<Rumeur> rumeurs, EffetWitch effetwitch, EffetHunt effetHunt) {
		//savoir combien de cartes dispose le BOT
		int compteur_cartes=12;
		compteur_cartes = (int)12/partie.getNbJoueurs();
		
		//Si le BOT est sorcière, stratégie de jeu basée sur l'accusation à fond
		if (this.identite.getPersonnage() == "Witch") {
			//tant que le bot dispose de cartes, il peut accuser
			while (compteur_cartes != 1) {
				//définir le joueur à accuser (avec la méthode au dessus)
				int randomNumber2 = (int) Math.random();							//ERREUR
    	    	int j = randomNumber2 * partie.getNbJoueurs();
    	    	String accuse = this.choisirNomAccuse();
    	    	//2 types d'accusation
    			// générer un nombre aléatoire pour qu'il joue plusieurs types de jeu diff
    	    	int randomNumber3 = (int) Math.random();
    	    	int k = randomNumber3 * 2;
    	    	if (k == 0) {
    	    		//appliquer la méthode EffetHunt de la classe EffetHunt sur une carte que le joueur joue
    	    		
    	    		//prendre une carte au hasard dans la liste de cartes du joueur
        	    	//appliquer sur cette carte effetwitch ou effethunt avec la méthode équivalente
    	    		
    	    		
        	    	int nb_cartes = rumeurs.size();
        	    	Rumeur carte_choisie= rumeurs.get((int)(Math.random()*nb_cartes));
        	    	//carte_choisie;
    	    	}
    	    	if (k == 1) {
    	    		//appliquer la méthode EffetHunt de la classe EffetHunt sur une carte que le joueur joue
    	    		int nb_cartes = rumeurs.size();
        	    	Rumeur carte_choisie= rumeurs.get((int)(Math.random()*nb_cartes));
        	    	carte_choisie.effetHunt.effetHunt();
    	    	}
			}
		}
		if (this.identite.getPersonnage == "Villageois") {
			//appliquer la méthode révéler identité
			//this.identite.revelerIdentite;
		}
	}

	

}
