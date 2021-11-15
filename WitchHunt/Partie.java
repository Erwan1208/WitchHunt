import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.*;
import java.util.*;

public class Partie {
   
    private String gagnant;


    private int round;


    private boolean terminee;


    private int nbJoueurs;

 
    private int nbIdentitesRevelees;

  
    private static  Partie instance;

    
    public List<Joueur> joueur = new ArrayList<Joueur> ();

  
    public List<Defausse> defausse = new ArrayList<Defausse> ();
    
    
    public List<Rumeur> listRumeurs = new ArrayList<Rumeur> ();

   
    public void terminerPartie() {
    }


    public void commencerRound() {
    	
    	int cartesParPersonne=(int) 12/this.joueur.size();
    	boolean[] carteTire= new boolean[12];
    	
    	for(int numCartes=1;numCartes<12;numCartes++) {
    		
    		for(int numCartesJoueur=0;numCartesJoueur<cartesParPersonne;numCartesJoueur++) {
    			
	    		int random= (int) Math.random()*12+1;
	    		
	    		if(carteTire[random]=false) {
	    			Rumeur rum=this.listRumeurs.get(random);
	    			Joueur player=this.joueur.get((int)numCartes/cartesParPersonne+1); //Permet de savoir à quel joueur on attribut la carte: On commence par le joueur 1, puis 2, puis 3 etc...
	    			player.rumeur.add(rum);	
	    		}
	    		else {
	    			numCartesJoueur--;
	    		}
    		}
    	}
    }


    public void afficherPointsJoueurs() {
    	
    	Iterator<Joueur> it= joueur.iterator();
    	while(it.hasNext()) {
    		Joueur player = it.next();
    		System.out.println("Le joueur"+player.pseudo +"a"+player.points +"points \n" );
    	}
    	
    }

  
   
    public void changerPoints() {
    	
    	
    }

   
    public static Partie getInstance() {
    	
    	if(instance == null) {
    		instance=new Partie();
    	}
        // Automatically generated method. Please delete this comment before entering specific code.
        return instance;
    }

    private Partie() {
    	this.terminee=false;
    	this.round=1;
    	this.nbIdentitesRevelees=0;
    	System.out.println("Combien de joueur voulez-vous? ");
    	Scanner sc= new Scanner(System.in);
    	int nbJoueurs = sc.nextInt();
    	System.out.println("Il y a " + nbJoueurs + " joueurs");
    	this.nbJoueurs=nbJoueurs;
    	sc.close();
    	for(int i=0;i<nbJoueurs;i++) {
    		Joueur nouvJoueur=new Joueur();
    		this.joueur.add(nouvJoueur);
    	}
    	
    }
    
    public static void main(String[] args) {
    	/* Ajouter la création de 12 cartes rumeurs!
    	 * On appelle le constructeur Rumeur() 12 fois avec un nom differents correspondant à une carte, et on ajoute la carte à la liste de la classe Partie
    	 */
    	
    }

}
