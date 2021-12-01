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



/**
 * Interface de la classe Strat�gie pour d�finir un comportement de jeux "Doux" pour le BOT
 * Mod�lisation d'un cycle de jeu
 * @author aurel
 *
 */
public class Doux implements Strategie {
	
	// trouver un moyen de faire passer l'attribut personnage de Identit� ici
	private String personnage;
	
	private String identite;
	
	//private game_WitchHunt.EffetWitch effetWitch;	
	
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
		int randomNumber6 = (int) Math.random();
    	int m = randomNumber6 * 2;
		//Si le BOT est sorci�re, strat�gie de jeu bas�e sur l'accusation � fond
		if (m ==0) {
			//tant que le bot dispose de cartes, il peut accuser
			//while (compteur_cartes != 1) {
				//d�finir le joueur � accuser (avec la m�thode au dessus)
				int randomNumber2 = (int) Math.random();
    	    	int j = randomNumber2 * partie.getNbJoueurs();
    	    	String accuse = this.choisirNomAccuse();
    	    	//2 types d'accusation
    			// g�n�rer un nombre al�atoire pour qu'il joue plusieurs types de jeu diff
    	    	int randomNumber3 = (int) Math.random();
    	    	int k = randomNumber3 * 2;
    	    	if (k == 0) {
    	    		//appliquer la m�thode EffetHunt de la classe EffetHunt sur une carte que le joueur joue
    	    		
    	    		//prendre une carte au hasard dans la liste de cartes du joueur
        	    	//appliquer sur cette carte effetwitch ou effethunt avec la m�thode �quivalente
    	    		
        	    	int nb_cartes = rumeurs.size();
        	    	Rumeur carte_choisie= rumeurs.get((int)(Math.random()*nb_cartes));
        	    	//carte_choisie;
    	    	}
    	    	if (k == 1) {
    	    		//appliquer la m�thode EffetHunt de la classe EffetHunt sur une carte que le joueur joue
    	    		int nb_cartes = rumeurs.size();
        	    	Rumeur carte_choisie= rumeurs.get((int)(Math.random()*nb_cartes));
        	    	carte_choisie.effetHunt.effetHunt();
    	    	}
			}
		//}
		if (m == 1) {
			//appliquer la m�thode r�v�ler identit�
			//this.identite.revelerIdentite;
		}
	}
	
	
	




	private void EffetWitch(String pseudo, EffetWitch effetwitch) {
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
