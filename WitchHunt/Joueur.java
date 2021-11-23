import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.lang.String;
import java.util.Random;


public class Joueur {
	
	public Partie jeu;

    public int points;


    public String pseudo;


    public List<Rumeur> rumeur = new ArrayList<Rumeur> ();
    
    public List<Rumeur> cartesJouees = new ArrayList<Rumeur>();


    public Identite id;
    
    public Joueur(Partie jeuWitchHunt) {
    	this.jeu=jeuWitchHunt;
    }

    void setPseudo(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.pseudo = value;
    }
    
    public void changerPoints() {
    	
    }

    public boolean decideAccuser() {
    	System.out.println("Veux-tu accuser un joueur?\n");
    	System.out.println("Ecrit O pour oui et N pour non\n");
    	Scanner sc = new Scanner(System.in);
    	String reponse=sc.next();
    	if(reponse=="O") {
    		return true;
    	}
    	else return false;
    	
    	
    }
    
    public String choisirNomAccuse() {
    	System.out.println("Donner le pseudo de la personne que vous voulez accuser!\n");
    	Scanner sc = new Scanner(System.in);
    	String nomAccuse = sc.next();
    	sc.close();
    	return nomAccuse;
    	
    }
    
    public boolean choisirRevelerIdentite() {
    	System.out.println("Veux-tu réveler ton identité?\n");
    	System.out.println("Ecrit O pour oui et N pour non\n");
    	Scanner sc = new Scanner(System.in);
    	String reponse= sc.next();
    	sc.close();
    	if(reponse=="O") {
    		return true;
    	}
    	else return false;
    	
    	
    	
    }
    public void jouerTour() {
    	if(this.decideAccuser()) {
			//Selection de l'accusé
			jeu.afficherJoueursVivants();
			String nomAccuse=this.choisirNomAccuse();
			
			//Recherche de l'accusé
			Iterator<Joueur> itAcc=jeu.joueurs.iterator();
			while(itAcc.hasNext()) {
				Joueur playerSearch=itAcc.next();
				if(playerSearch.pseudo==nomAccuse) {
					
					//Choix Réponse de l'accusé
					if(playerSearch.choisirRevelerIdentite()) {
						playerSearch.id.revelerIdentite();		
					}
					else {
						playerSearch.jouerWitch();
					}
				}
			}
		}
		else {
			this.jouerHunt();
		}
    }
    
    

    public void jouerHunt() {
    	
    	
    	//Choisir quelle carte jouer et la prendre
    	
    	System.out.println("Quelle carte hunt souhaites-tu jouer?\n");
    	Iterator<Rumeur> ithunt = this.rumeur.iterator();
    	while (ithunt.hasNext()) {
    		System.out.println(ithunt.next().nom);
    		
    	}
    	System.out.println("Entrer le nom de la carte que tu souhaites jouer:\n");
    	Scanner scCarte= new Scanner(System.in);
    	String nomCarte = scCarte.next();
    	scCarte.close();
    	
    	
    	
    	
    	
    	
    	//Choisir sur quelle personne la jouer
    	
    	System.out.println("Sur quelle joueur souhaites-tu jouer la carte Hunt! ?\n");
    	Iterator<Joueur> itj=this.jeu.joueurs.iterator();
    	while(itj.hasNext()) {
    		System.out.println(itj.next().pseudo);
    	}
    	    
    	System.out.println("Entrer son pseudo");
    	Scanner sc = new Scanner(System.in);
    	String nomJoueur = sc.next();
    	sc.close();
    	
    	
    	//Effets Hunts
    	
    	//Trouver la carte jouée/selectionée
    	Iterator<Rumeur> itRum= this.rumeur.iterator();
    	Rumeur carteJouee;
    	while(itRum.hasNext()) {
    		Rumeur carte=itRum.next();
    		if(carte.nom==nomCarte) {
    			carteJouee=carte;
    			this.rumeur.remove(carteJouee);
    			this.cartesJouees.add(carteJouee);
    		}
    			
    	}
    	
    	//Faire ses effets
    	if(carteJouee.hunt.piocherCarteDefausse) {
    		
    		//Piocher carte au hasard de la défausse
    		Random random = new Random();
    		int index = random.nextInt(jeu.defausse.listRumeur.size());
    		this.rumeur.add(jeu.defausse.listRumeur.get(index));
    		
    		//Défausser la carte jouée
    		this.cartesJouees.remove(carteJouee);
    		this.jeu.defausse.listRumeur.add(carteJouee);
    		
    		
    	}
    	
    }

    public void jouerWitch() {
    	//Choisir quelle Carte Witch jouer + la jouer
    }
    
   
}