package Vue;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import Modele.Rumeur;
import Modele.Joueur;
import Modele.Partie;

public class VueTexte implements Observer, Runnable {

  

    private Partie p;

    public VueTexte(Partie p) {
		this.p = p;
	
		List<Joueur> joueurs = p.joueurs;
		for (Joueur j : joueurs) {
		    j.addObserver(this);	
		    }
		p.addObserver(this);
		
		
		Thread t = new Thread(this);
		t.start();
    }

    public void run() {
    	while(p.terminee==false) {
    		
    		
    		
    		//Deroulement round
    		p.commencerRound();
    		
    		
    		
    		
    		while(p.nbIdentitesRevelees!=p.nbJoueurs-1) {
    			for(p.indexActif=0;p.indexActif<p.nbJoueurs;p.indexActif++) {
    				
        			System.out.println(p.nbIdentitesRevelees+"identités révelées\n");
        			
        			Joueur joueurActif=p.joueurs.get(p.indexActif);
        			if(joueurActif.id.isIdRevelee()==false || joueurActif.id.getPersonnage().equals("Villageois")) {
        				joueurActif.jouerTour();
        			}
        			
        		}
    			
    			
    		}
    		
    		p.finirRound();
    		p.afficherPointsJoueurs();
    		
    		
    		
    		//Test de fin de partie
    		Iterator <Joueur>itj= p.joueurs.iterator();
    		while(itj.hasNext()) {
    			Joueur joueur=itj.next();
    			if(joueur.points>5) {
    				p.terminerPartie();
    			}
    		} 
    			
    		
    		
    	}

    }
    
    public void update() {
    	
    }
}
