package game_WitchHunt;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.*;
import java.util.*;

public class Partie {
   
	public static int indexActif;
	
    private String gagnant;


    private int round;


    private boolean terminee;


    private int nbJoueurs;

 
    private int nbIdentitesRevelees;

  
    private static  Partie instance;

    
    public List<Joueur> joueurs = new ArrayList<Joueur> ();

  
    public Defausse defausse = new Defausse();
    
    
    public List<Rumeur> listRumeurs = new ArrayList<Rumeur> ();

   
    public void terminerPartie() {
    	
    	//Trouver le maximum
    	Iterator<Joueur> itr=this.joueurs.iterator();
    	int max=0;
    	while(itr.hasNext()) {
    		Joueur player =itr.next();
    		if(player.points>max) {
    			max=player.points;
    		}
    	}
    	
    	//Creer une liste des gagnants
    	List<String> gagnants= new ArrayList<String>();
    	Iterator<Joueur> itr2=this.joueurs.iterator();
    	while(itr2.hasNext()) {
    		Joueur player =itr2.next();
    		if(player.points==max) {
    			gagnants.add(player.pseudo);
    		}
    	}
    	
    	//Donner la liste de tout les gagnants (Dans le cas où il y a égalité)
    	if(gagnants.size()>1) {
    		System.out.println("Les gagnants sont"+gagnants);
    	}
    	else {
    		System.out.println("Le gagnant est" + gagnants.get(0));
    	}
    	
    	this.terminee=true;
    	System.out.println("La partie est terminee!");
    	
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
    	
    	int cartesParPersonne=(int) 12/this.joueurs.size();
    	
    	//Initiation d'un tableau indiquant si la carte i a été tirée
    	boolean[] carteTire= new boolean[12];
    	for(int i=0;i<12;i++) {
    		carteTire[i]=false;
    	}
    	
    	//!!!Possibilité d'utilisé la methode Collections.shuffle()
    	
    	
    	//On donne [cartesParPersonne] cartes à chaque joueur en tirant au hasard juqu'à ce qu'il n'y ai plus de cartes  
    	for(int numCartes=1;numCartes<cartesParPersonne*this.nbJoueurs;numCartes+=cartesParPersonne) {
    		
    		for(int numCartesJoueur=0;numCartesJoueur<cartesParPersonne;numCartesJoueur++) {
    			
	    		int random= (int) Math.random()*12+1;
	    		
	    		if(carteTire[random]==false) {//Si la carte au hasard n'a pas déjà été tiré, la tirer et la donner au joueur 
	    			carteTire[random]=true;
	    			Rumeur rum=this.listRumeurs.get(random);
	    			Joueur player=this.joueurs.get((int)numCartes/cartesParPersonne+1); //Permet de savoir à quel joueur on attribut la carte: On commence par le joueur 1, puis 2, puis 3 etc...
	    			player.rumeurs.add(rum);	
	    		}
	    		else {
	    			numCartesJoueur--;//Si elle a été tirée, on répète le tirage...
	    			//Peut être améliorée car cela veut dire qu'il y aura enormement de répétition de tirage quand la plupart des cartes on été tirée
	    		}
    		}
    	}
    }


    public void afficherPointsJoueurs() {
    	
    	Iterator<Joueur> it= joueurs.iterator();
    	while(it.hasNext()) {
    		Joueur player = it.next();
    		System.out.println("Le joueur"+player.pseudo +"a"+player.points +"points \n" );
    	}
    	
    }
    
    public void afficherJoueursVivants() {
    	for(Joueur o: this.joueurs) {
    		if(o.id.isIdRevelee()) {
    			System.out.println(o.pseudo);
    		}
		}
    }


   
    public static Partie getInstance() {
    	
    	if(instance == null) {
    		instance=new Partie();
    	}
        
        return instance;
    }
    
    public void accuserJoueur() {
    }


    private Partie() {
    	this.terminee=false;
    	this.round=1;
    	this.nbIdentitesRevelees=0;
    	this.creerCartesRumeurs();
    	
    	System.out.println("Combien de joueur voulez-vous? ");
    	Scanner sc= new Scanner(System.in);
    	int nbJoueurs = sc.nextInt();
    	System.out.println("Il y a " + nbJoueurs + " joueurs");
    	this.nbJoueurs=nbJoueurs;
    	sc.close();
    	
    	for(int i=0;i<nbJoueurs;i++) {
    		Joueur nouvJoueur=new Joueur(this);
    		this.joueurs.add(nouvJoueur);
    	}
    	
    }
    
    
   
    public static void main(String[] args) {
    	Partie WitchHunt = new Partie();
    	
    	while(WitchHunt.terminee=false) {
    		
    		//Test de fin de partie
    		Iterator <Joueur>itj= WitchHunt.joueurs.iterator();
    		while(itj.hasNext()) {
    			Joueur joueur=itj.next();
    			if(joueur.points>5) {
    				WitchHunt.terminee=true;
    			}
    		}
    		
    		//Deroulement round
    		WitchHunt.commencerRound();
    		
    		for(indexActif=0;indexActif<WitchHunt.nbJoueurs;indexActif++) {
    			
    			Joueur joueurActif=WitchHunt.joueurs.get(indexActif);
    			if(joueurActif.id.isIdRevelee()==false) {
    				joueurActif.jouerTour();
    			}
    		
    		
    			
    			
    			
    		}
    		
    	}
    	
    }
    
    public int getNbJoueurs() {
    	return this.joueurs.size();
    }

}
