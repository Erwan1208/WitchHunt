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

    public void creerCartesRumeurs() {
    	Rumeur angryMob= new Rumeur("angryMob");
    	this.listRumeurs.add(angryMob);
    	Rumeur theInquisition= new Rumeur("theInquisition");
    	this.listRumeurs.add(theInquisition);
    	Rumeur pointedHat= new Rumeur("pointedHat");
    	this.listRumeurs.add(pointedHat);
    	Rumeur hookedNose= new Rumeur("hookedNose");
    	this.listRumeurs.add(hookedNose);
    	Rumeur broomstick= new Rumeur("broomstick");
    	this.listRumeurs.add(broomstick);
    	Rumeur wart= new Rumeur("wart");
    	this.listRumeurs.add(wart);
    	Rumeur duckingStool= new Rumeur("duckingStool");
    	this.listRumeurs.add(duckingStool);
    	Rumeur cauldron= new Rumeur("cauldron");
    	this.listRumeurs.add(cauldron);
    	Rumeur evilEye= new Rumeur("evilEye");
    	this.listRumeurs.add(evilEye);
    	Rumeur toad= new Rumeur("toad");
    	this.listRumeurs.add(toad);
    	Rumeur blackCat= new Rumeur("blackCat");
    	this.listRumeurs.add(blackCat);
    	Rumeur petNewt= new Rumeur("petNewt");
    	this.listRumeurs.add(petNewt);
    	
    	
    	
    }

    public void commencerRound() {
    	
    	if(this.round==1) {
    		this.creerCartesRumeurs();
    	}
    	
    	int cartesParPersonne=(int) 12/this.joueur.size();
    	
    	//Initiation d'un tableau indiquant si la carte i a été tirée
    	boolean[] carteTire= new boolean[12];
    	for(int i=0;i<12;i++) {
    		carteTire[i]=false;
    	}
    	
    	//On donne [cartesParPersonne] cartes à chaque joueur en tirant au hasard juqu'à ce qu'il n'y ai plus de cartes  
    	for(int numCartes=1;numCartes<cartesParPersonne*this.nbJoueurs;numCartes+=cartesParPersonne) {
    		
    		for(int numCartesJoueur=0;numCartesJoueur<cartesParPersonne;numCartesJoueur++) {
    			
	    		int random= (int) Math.random()*12+1;
	    		
	    		if(carteTire[random]==false) {//Si la carte au hasard n'a pas déjà été tiré, la tirer et la donner au joueur 
	    			carteTire[random]=true;
	    			Rumeur rum=this.listRumeurs.get(random);
	    			Joueur player=this.joueur.get((int)numCartes/cartesParPersonne+1); //Permet de savoir à quel joueur on attribut la carte: On commence par le joueur 1, puis 2, puis 3 etc...
	    			player.rumeur.add(rum);	
	    		}
	    		else {
	    			numCartesJoueur--;//Si elle a été tirée, on répète le tirage...
	    			//Peut être améliorée car cela veut dire qu'il y aura enormement de répétition de tirage quand la plupart des cartes on été tirée
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
