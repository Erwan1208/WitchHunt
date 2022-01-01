package Modele;


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

 
    public int nbIdentitesRevelees;

  
    private static  Partie instance;

    
    public List<Joueur> joueurs = new ArrayList<Joueur> ();

  
    public Defausse defausse = new Defausse();
    
    
    public List<Rumeur> listRumeurs = new ArrayList<Rumeur> ();

    
    public void incrementerIdentitesRevelees() {
    	this.nbIdentitesRevelees++;
    }
    
   
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
    		System.out.println("Les gagnants sont "+gagnants);
    	}
    	else {
    		System.out.println("Le gagnant est " + gagnants.get(0));
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
    	
    	for(Joueur j : this.joueurs) {
    		System.out.println(j.pseudo);
    		j.id= new Identite();
    	}
    	
    	
    	this.nbIdentitesRevelees=0;
    	
    	if(this.round==1) {
    		this.creerCartesRumeurs();
    	}
    	
    	int cartesParPersonne=(int) 12/this.joueurs.size();
    	System.out.println("Il y a "+ cartesParPersonne + "cartes par personne" );
    	
    	
    	
    	//!!!Possibilité d'utiliser la methode Collections.shuffle()
    	for(Joueur j : this.joueurs) {
    		j.rumeurs.clear();
    	}
    	
    	Collections.shuffle(this.listRumeurs);
    	
    	for(Rumeur r : listRumeurs) {
    		System.out.println(r.nom);
    	}
    	
    	for(int numCartes=0;numCartes<(cartesParPersonne*this.nbJoueurs);numCartes++) {
    		
  
    			//int nb= (int)numCartes/cartesParPersonne;
    			//System.out.println(nb);
    			
    			Joueur player = this.joueurs.get((int)numCartes/cartesParPersonne);
    			player.rumeurs.add(this.listRumeurs.get(numCartes));
    	}
    	
    	
    	
    	//Verification
    	for (Joueur j : this.joueurs) {
    		System.out.println(j.pseudo + " :\n");
    		for(Rumeur r : j.rumeurs) {
        		System.out.println(r.nom);
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
    		if(o.id.isIdRevelee()==false || o.id.getPersonnage().equals("Villageois")) {
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
    
    public void finirRound() {
    	this.round++;
    	System.out.println("Round fini");
    	for(Joueur j :this.joueurs) {
    		if(j.id.isIdRevelee()==false) {
    			if (j.id.getPersonnage().equals("Witch")) {
    				j.points+=2;
    			}
    			else j.points+=1;
    		}
    	}
    }
    
    public int getNbJoueurs() {
    	return this.joueurs.size();
    }


    private Partie() {
    	this.terminee=false;
    	this.round=1;
    	
    	System.out.println("Combien de joueur voulez-vous? ");
    	Scanner sc= new Scanner(System.in);
    	int nbJoueurs = sc.nextInt();
    	sc.nextLine();
    	System.out.println("Il y a " + nbJoueurs + " joueurs");
    	this.nbJoueurs=nbJoueurs;
    	
    	for(int i=0;i<nbJoueurs;i++) {
    		Joueur nouvJoueur=new Joueur(this);
    		this.joueurs.add(nouvJoueur);
    	}
    	
    }
    
      
      
    public static void main(String[] args) {
    	Partie WitchHunt = new Partie();
    
    	while(WitchHunt.terminee==false) {
    		
    		
    		
    		//Deroulement round
    		WitchHunt.commencerRound();
    		
    		
    		
    		
    		while(WitchHunt.nbIdentitesRevelees!=WitchHunt.nbJoueurs-1) {
    			for(indexActif=0;indexActif<WitchHunt.nbJoueurs;indexActif++) {
    				
        			System.out.println(WitchHunt.nbIdentitesRevelees+"identités révelées\n");
        			
        			Joueur joueurActif=WitchHunt.joueurs.get(indexActif);
        			if(joueurActif.id.isIdRevelee()==false || joueurActif.id.getPersonnage().equals("Villageois")) {
        				joueurActif.jouerTour();
        			}
        			
        		}
    			
    			
    		}
    		
    		WitchHunt.finirRound();
    		WitchHunt.afficherPointsJoueurs();
    		
    		
    		
    		//Test de fin de partie
    		Iterator <Joueur>itj= WitchHunt.joueurs.iterator();
    		while(itj.hasNext()) {
    			Joueur joueur=itj.next();
    			if(joueur.points>5) {
    				WitchHunt.terminerPartie();
    			}
    		} 
    			
    		
    		
    	}
    	
    	
    }
    
    

}
