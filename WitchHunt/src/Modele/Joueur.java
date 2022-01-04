package Modele;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.lang.String;
import java.util.Random;

import java.util.Observable;

public class Joueur extends Observable {
	
	public Partie jeu;

    public int points;


    public String pseudo;

   
    public List<Rumeur> rumeurs = new ArrayList<Rumeur> ();
    
    public List<Rumeur> cartesJouees = new ArrayList<Rumeur>();
    
    


    public Identite id;
    
    public Joueur(Partie jeuWitchHunt) {
    	this.jeu=jeuWitchHunt;
    	this.points=0;
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Entrer ton pseudo:\n");
    	this.pseudo= sc.nextLine();
    }

    void setPseudo(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.pseudo = value;
    }
    
    public void changerPoints(int incrementation) {
    	this.points+=incrementation;
    }

    public boolean decideAccuser() {
    	System.out.println(this.pseudo+ ", veux-tu accuser un joueur?\n");
    	System.out.println("Ecrit O pour oui et N pour non\n");
    	Scanner scanner = new Scanner(System.in);
    	String reponse=scanner.next();
    	if(reponse.equals("O")) {
    		return true;
    	}
    	else return false;
    	
    	
    }
    
    public void afficherCarte(Rumeur carte) {
    	
    	this.setChanged();
    	this.notifyObservers(carte);
    	
    }
        
    public String choisirNomAccuse() {
    	System.out.println("Donner le pseudo de la personne que vous voulez accuser!\n");
    	Scanner sc = new Scanner(System.in);
    	String nomAccuse = sc.next();
    	return nomAccuse;
    	
    }
    
    public boolean choisirRevelerIdentite() {
    	System.out.println(this.pseudo+ " ,veux-tu réveler ton identité?\n");
    	System.out.println("Ecrit O pour oui et N pour non\n");
    	Scanner sc = new Scanner(System.in);
    	String reponse = sc.nextLine();
    	if(reponse.equals("O")) {
    		return true;
    	
    	}
    	else return false;
    	
    	
    	
    }
    
    public Joueur accuserJoueur() {
    	jeu.afficherJoueursVivants();
		String nomAccuse=this.choisirNomAccuse();
		
		//Recherche de l'accusé
		Iterator<Joueur> itAcc=jeu.joueurs.iterator();
		while(itAcc.hasNext()) {
			Joueur playerSearch=itAcc.next();
			if(playerSearch.pseudo.equals(nomAccuse)) {
				System.out.println("Trouvé");
				//Choix Réponse de l'accusé 
				return playerSearch;
				
			}
		}
    }
    public void jouerTour() {
    	
	    
	    if(jeu.nbIdentitesRevelees != jeu.getNbJoueurs()-1) {	
	    
	    	if(this.decideAccuser()) {
				//Selection de l'accusé
				Joueur playerSearch = this.accuserJoueur();
				if(playerSearch.choisirRevelerIdentite()) {
					playerSearch.id.revelerIdentite();
					jeu.incrementerIdentitesRevelees();
					if(playerSearch.id.getPersonnage().equals("Witch")) {
						this.points++;
						if(jeu.nbIdentitesRevelees!=jeu.getNbJoueurs()-1) {
	    					jeu.indexActif--;
	    				}
					}
				}
				else {
					playerSearch.jouerWitch(this);
				}
			}
				
	}
	    	else this.jouerHunt();
			
	    }
	    
    
    

    public void jouerHunt() {
    	
    	
    	//QUE CE PASSE T'IL POUR LES EFFETS DOUBLES??? EX/ CHOISI UN JOUEUR LE PROCHAIN JOUEUER ET REGARDER SON IDENTITE
    	
    	
    	//Choisir quelle carte jouer et la prendre
    	
    	System.out.println("Quelle carte hunt souhaites-tu jouer?\n");
    	Iterator<Rumeur> ithunt = this.rumeurs.iterator();
    	while (ithunt.hasNext()) {
    		System.out.println(ithunt.next().nom);
    		
    	}
    	System.out.println("Entrer le nom de la carte que tu souhaites jouer:\n");
    	Scanner scCarte= new Scanner(System.in);
    	String nomCarte = scCarte.next();
    	
    	
    	
    	
    	
    	
    	//Choisir sur quelle personne la jouer
    	
    	System.out.println("Sur quelle joueur souhaites-tu jouer la carte Hunt! ?\n");
    	jeu.afficherJoueursVivants();
    	    
    	System.out.println("Entrer son pseudo");
    	Scanner sc = new Scanner(System.in);
    	String nomJoueur = sc.next();
    	
    	
    	//Effets Hunts
    	
    	//Trouver la carte jouée/selectionée
    	Rumeur carteJouee = null;
    	for(Rumeur r : this.rumeurs) {
    		if(r.nom.equals(nomCarte)) {
    			carteJouee=r;
    			
    		}
    	}
    	this.rumeurs.remove(carteJouee);
		this.cartesJouees.add(carteJouee);
    	
    	
    	
    	
    	//Faire ses effets
    	if (carteJouee != null) {
        	
    		System.out.println("Carte trouvé");
    		
    		
        	if(carteJouee.hunt.piocherCarteDefausse) {
        		
        		//Piocher carte au hasard de la défausse
        		Random random = new Random();
        		int index = random.nextInt(jeu.defausse.listRumeur.size());
        		this.rumeurs.add(jeu.defausse.listRumeur.get(index));
        		
        		//Défausser la carte jouée
        		this.cartesJouees.remove(carteJouee);
        		this.jeu.defausse.listRumeur.add(carteJouee);
        		
        		
        	}
        	
        	if(carteJouee.hunt.faireRevelerIdentite) {
        		for(Joueur j: jeu.joueurs) {
        			if(j.pseudo.equals(nomJoueur)) {
        				j.id.revelerIdentite();
        				jeu.incrementerIdentitesRevelees();
        				if(j.id.getPersonnage().equals("Villageois")) { 
        					this.changerPoints(-2);
        					int indexProchain = jeu.joueurs.indexOf(j);
        					jeu.indexActif=(indexProchain-1)%jeu.getNbJoueurs();
        				}
        				else if(j.id.getPersonnage().equals("Witch")) {
        					this.changerPoints(2);
        					int indexProchain = jeu.joueurs.indexOf(this);
        					jeu.indexActif=(indexProchain-1)%jeu.getNbJoueurs();
        				}
        			}
        			
        		}
      	
        	 }
        	
        	if(carteJouee.hunt.choisiProchainJoueur == true) {
        		for(Joueur o: jeu.joueurs) {
        			if(o.pseudo.equals(nomJoueur)) { 				//PROBLEME: NE CHANGE PAS L'ORDRE DES JOUEURS QUI SUIVRONT
        				jeu.indexActif=(jeu.joueurs.indexOf(o)-1)%jeu.getNbJoueurs();
        			}
        		}
        	}
        	
        	if (carteJouee.hunt.regarderIdentite) {
        		for(Joueur o: jeu.joueurs) {
        			if(o.pseudo.equals(nomJoueur)) {
        				System.out.println("Shhhhhttttt!!!! C'est un "+ o.id.getPersonnage());
        				jeu.incrementerIdentitesRevelees();//COMMENT FAIRE POUR QUE CE SOIT EN SECRET?
        			}
        		}
        	}
        	
        	
        	if(carteJouee.hunt.piocherPropreCarteRumeur) {
        		for(Rumeur o : cartesJouees) {
        			System.out.println(o.nom);
        		}
        		System.out.println("Quelle carte Rumeur souhaites-tu piocher?\n");
        		Scanner scRum= new Scanner(System.in);
        		String cartepiochee= scRum.next();
        		
        		Rumeur carteChoisi = null;
        		for(Rumeur o: this.cartesJouees) {
        			if(o.nom.equals(cartepiochee)) {
        				carteChoisi=o;
        			}
        		}
        		this.rumeurs.add(carteChoisi);
				this.cartesJouees.remove(carteChoisi);
        		
        	}
        	
        	if(carteJouee.hunt.volerCarte) {
        		for(Joueur o: jeu.joueurs) {
        			if(o.pseudo.equals(nomJoueur)) {
        				Random rand = new Random();
        				int randindex = rand.nextInt(o.rumeurs.size());
        				Rumeur carteVolee= o.rumeurs.get(randindex);
        				this.rumeurs.add(carteVolee);
        				o.rumeurs.remove(carteVolee);
        			}
        		}
        	}
        	
        	if(carteJouee.hunt.faireRevelerOuDefausser) {
        		System.out.println(nomJoueur+", vous devez choisir si vous révelez votre identité ou vous defausser une carte.\n");
        		System.out.println("Souhaitez-vous réveler votre identité?\n Tapez 'O' pour oui ou 'N' pour non\n");
        		Scanner screp = new Scanner(System.in);
        		String reponse= screp.next();
        		
        		for(Joueur j: jeu.joueurs) {
        			if(j.pseudo.equals(nomJoueur)){
        				if(reponse=="O") {
        	    			j.id.revelerIdentite();
        	    			jeu.incrementerIdentitesRevelees();
        	    			if(j.id.getPersonnage().equals("Villageois")) {
        	    				this.changerPoints(-1);
        	    				int indexProchain= jeu.joueurs.indexOf(j);
        	    				jeu.indexActif=(indexProchain-1)%jeu.getNbJoueurs();
        	    			}
        	    			else if (j.id.getPersonnage().equals("Witch")) {
        	    				this.changerPoints(1);
        	    				int indexProchain= jeu.joueurs.indexOf(this);
        	    				jeu.indexActif=(indexProchain-1)%jeu.getNbJoueurs();
        	    			}
        	    		}
        	    		else {
        	    			Iterator<Rumeur> it= j.rumeurs.iterator();
        	    			while(it.hasNext()) {
        	    				System.out.println(it.next().nom);
        	    			}
        	    			System.out.println("Quelle carte souhaitez-vous défausser?\n Tapez son nom\n");
        	    			Scanner sccarte=new Scanner(System.in);
        	    			String nomDefausse= sccarte.next();
        	    			
        	    			Rumeur carteDefausse=null;
        	    			for(Rumeur o:j.rumeurs) {
        	    				if(o.nom.equals(nomDefausse)) {
        	    					carteDefausse=o;
        	    					
        	    				}
        	    			}
        	    			jeu.defausse.defausserCarte(carteDefausse);
	    					j.rumeurs.remove(carteDefausse);
	    					
	    					
    	    				int indexProchain= jeu.joueurs.indexOf(j);
    	    				jeu.indexActif=(indexProchain-1)%jeu.getNbJoueurs();
        	    			
        	    			
        	    		}
        			}
        		}
        		
        		
        	}
        	
        	if(carteJouee.hunt.revelerPropreIdentite) {
        		this.id.revelerIdentite();
        		jeu.incrementerIdentitesRevelees();
        		if(this.id.getPersonnage().equals("Villageois")) {
        			for(Joueur o: jeu.joueurs) {
            			if(o.pseudo.equals(nomJoueur)) { 				//PROBLEME: NE CHANGE PAS L'ORDRE DES JOUEURS QUI SUIVRONT
            				jeu.indexActif=(jeu.joueurs.indexOf(o)-1)%jeu.getNbJoueurs();
            			}
            		}
        		}
        		else {
        			int indexProchain= jeu.joueurs.indexOf(this); 
        			jeu.indexActif=(indexProchain-2)%jeu.joueurs.size();//NE PREND PAS EN COMPTE LE FAIT QUE DES JOUEURS ONT ETE ELIMINE
        		}
        	}
        	
        	if(carteJouee.hunt.faireAccuserAutreJoueur) { 				//PROBLEME:COMMENT SAVOIR QUAND C'EST LE TOUR DE LA PERSONNE
        		
        	}
        	if(carteJouee.hunt.piocherAutreCarteRumeur) {
        		
        		
        		//Afficher les cartes rumeurs
        		for(Joueur j : jeu.joueurs) {
        			for(Rumeur carte: j.cartesJouees)
        				System.out.println(carte.nom);
        		}
        		System.out.println("Quelle carte souhaites-tu piocher? Entrer son nom");
        		Scanner scNomCarte = new Scanner(System.in);
        		String nomDeCarte= scNomCarte.next();
        		for(Joueur j : jeu.joueurs) {
        			Rumeur carteChoisi= null;
        			for(Rumeur carte: j.cartesJouees) {
        				if(carte.nom.equals(nomDeCarte)) {
        					carteChoisi=carte;
        				}
        			}
        			this.rumeurs.add(carteChoisi);
					j.cartesJouees.remove(carteChoisi);
        			
        		}
        		
        		
        	}
        	if(carteJouee.hunt.blackCat) {
        		//Piocher carte de défausse
        		Random rand= new Random();
        		if(jeu.defausse.listRumeur.size()!= 0) {
        			int randindex= rand.nextInt(jeu.defausse.listRumeur.size());
        			this.rumeurs.add(jeu.defausse.listRumeur.get(randindex));
            		jeu.defausse.listRumeur.remove(randindex);
        		}
        		else {
        			System.out.println("Pourquoi tu joues cette carte? Il n'y a pas de défausse");
        		}
        		
        		
        		//Defausser carte
        		jeu.defausse.defausserCarte(carteJouee);
        		this.cartesJouees.remove(carteJouee);
        		
        		
        		jeu.indexActif=(jeu.joueurs.indexOf(this)-1)%jeu.getNbJoueurs();
        													//PROBLEME:COMMENT ETRE LE PROCHAIN JOUEUR
        	}
        	
        	if(carteJouee.hunt.faireAccuserAutreJoueur) {
        		
        		
        		
        		//Recherche du joueur qui devra accuser quelqu'un
        		for(Joueur j : jeu.joueurs) {
        			if(j.pseudo.equals(nomJoueur)) {
        				
        				//Changement de l'ordre
        				int indexProchain = (jeu.joueurs.indexOf(j)-1);
        				jeu.indexActif= indexProchain%jeu.getNbJoueurs();
        				
        				//Selection de qui ce joueur veut accuser
        				jeu.afficherJoueursVivants();
        				System.out.println(nomJoueur+"qui veut tu accuser? Tu ne peux pas accuser "+ this.pseudo);
        				Scanner scNomAccuse = new Scanner(System.in);
        				String nomJoueurAccuse = scNomAccuse.next();
        				
        				//Recherche du joueur Selectionne
        				if(nomJoueurAccuse != this.pseudo) {
        					for (Joueur player : jeu.joueurs) {
        						if (player.pseudo.equals(nomJoueurAccuse)) {
        							
        							if(player.choisirRevelerIdentite()) {
        								player.id.revelerIdentite();
        								jeu.incrementerIdentitesRevelees();
        							}
        							else {
        								player.jouerWitch(player);
        							}
        						}
        					}
        				}
        			}
        		}
        	}
    	
        
    	} 
    	else System.out.println("carteJouee=null");	
    	
    	this.setChanged();
    	this.notifyObservers();
    }

    public void jouerWitch(Joueur accusateur) {
    	//Choisir quelle Carte Witch jouer + la jouer
    	
    	
    	//Afficher et Choisir quelle carte jouee
    	System.out.println("Quelle carte hunt souhaites-tu jouer?\n");
    	Iterator<Rumeur> ithunt = this.rumeurs.iterator();
    	while (ithunt.hasNext()) {
    		System.out.println(ithunt.next().nom);
    		
    	}
    	System.out.println("Entrer le nom de la carte que tu souhaites jouer:\n");
    	Scanner scCarte= new Scanner(System.in);
    	String nomCarte = scCarte.next();
    	
    	
    	//Trouver la carte jouée/selectionée
    	Iterator<Rumeur> itRum= this.rumeurs.iterator();
    	Rumeur carteJouee = null;
    	while(itRum.hasNext()) {
    		Rumeur carte=itRum.next();
    		if(carte.nom.equals(nomCarte)) {
    			carteJouee=carte;
    			
    		}
    			
    	}
    	this.rumeurs.remove(carteJouee);
		this.cartesJouees.add(carteJouee);
		
		
    	
    	if(carteJouee.witch.faireDefausserCarte) {
    		System.out.println(accusateur.pseudo+"Choisis quelle carte tu veux defausser:\n");
    		for(Rumeur carte: accusateur.rumeurs) {
    			System.out.println(carte.nom);
    		}
    		
    		System.out.println("Entrer le nom de la carte que tu choisis de défausser\n");
    		Scanner scnomCarteDefausse= new Scanner(System.in);
    		String nomCarteDefausse= scnomCarteDefausse.next();
    		
    		Rumeur carteDefausse=null;
    		for(Rumeur carte: accusateur.rumeurs) {
    			if(carte.nom.equals(nomCarteDefausse)) {
    				carteDefausse=carte;
    			}
    		}
    		jeu.defausse.defausserCarte(carteDefausse);
			accusateur.rumeurs.remove(carteDefausse);
    		
    	}
    	
    	if(carteJouee.witch.defausserCarte) {
    		System.out.println(this.pseudo+"Choisis quelle carte tu veux defausser:\n");
    		for(Rumeur carte: this.rumeurs) {
    			System.out.println(carte.nom);
    		}
    		
    		System.out.println("Entrer le nom de la carte que tu choisis de défausser\n");
    		Scanner scCarteDefausse= new Scanner(System.in);
    		String nomCarteDefausse= scCarteDefausse.next();
    		
    		Rumeur carteDefausse = null;
    		for(Rumeur carte: this.rumeurs) {
    			if(carte.nom.equals(nomCarteDefausse)) {
    				carteDefausse = carte;
    			}
    		}
    		
    		jeu.defausse.defausserCarte(carteDefausse);
			this.rumeurs.remove(carteDefausse);
			
    	}
    	
    	if(carteJouee.witch.jouerProchain) {
    		jeu.indexActif=(jeu.joueurs.indexOf(this)-1)%jeu.getNbJoueurs();
    	}
    	if(carteJouee.witch.piocherPropreCarteRumeur) {
    		for(Rumeur carte: this.cartesJouees) {
    			System.out.println(carte);
    		}
    		System.out.println("Quelle carte rumeur souhaite tu piocher?");
    		Scanner scCartePiocher= new Scanner(System.in);
    		String nomCartePiocher= scCartePiocher.next();
    		
    		Rumeur cartePioche= null;
    		for(Rumeur carte: this.cartesJouees) {
    			if(carte.nom.equals(nomCartePiocher)) {
    				cartePioche= carte;
    			}
    		}
    		this.rumeurs.add(cartePioche);
			this.cartesJouees.remove(cartePioche);
    		
    		
    	}
    	if(carteJouee.witch.piocherCarteAcusateur) {
    		Random rand = new Random();
    		int indexCartePiochee= rand.nextInt(accusateur.rumeurs.size());
    		Rumeur carteRandom= accusateur.rumeurs.get(indexCartePiochee);
    		this.rumeurs.add(carteRandom);
    		accusateur.rumeurs.remove(carteRandom);
    	}
    	if(carteJouee.witch.choisiProchainJoueur) {
    		jeu.afficherJoueursVivants();
    		System.out.println("Qui sera le prochain joueur? entrer son pseudo");
    		Scanner scProchainJoueur= new Scanner(System.in);
    		String nomProchainJoueur= scProchainJoueur.next();
    		for(Joueur j : jeu.joueurs) {
    			if(j.pseudo.equals(nomProchainJoueur)) {
    				int indexProchain = jeu.joueurs.indexOf(j);
    				jeu.indexActif= (indexProchain-1)%jeu.getNbJoueurs();
    			}
    		}
    	}
    	
    	if(carteJouee.witch.faireAccuserAutreJoueur) {
    		
    		//Selection de joueur qui devra accuser quelqu'un
    		jeu.afficherJoueursVivants();
    		System.out.println("Qui veut tu obliger à accuser?");
    		Scanner scProchainJoueur= new Scanner(System.in);
    		String nomProchainJoueur= scProchainJoueur.next();
    		
    		//Recherche du joueur qui devra accuser quelqu'un
    		for(Joueur j : jeu.joueurs) {
    			if(j.pseudo.equals(nomProchainJoueur)) {
    				
    				//Changement de l'ordre
    				int indexProchain = jeu.joueurs.indexOf(j);
    				jeu.indexActif= indexProchain%jeu.getNbJoueurs();
    				
    				//Selection de qui ce joueur veut accuser
    				jeu.afficherJoueursVivants();
    				System.out.println(nomProchainJoueur+"qui veut tu accuser? Tu ne peux pas accuser "+ this.pseudo);
    				Scanner scNomAccuse = new Scanner(System.in);
    				String nomJoueurAccuse = scNomAccuse.next();
    				
    				//Recherche du joueur Selectionne
    				if(nomJoueurAccuse != this.pseudo) {
    					for (Joueur player : jeu.joueurs) {
    						if (player.pseudo.equals(nomJoueurAccuse)) {
    							
    							if(player.choisirRevelerIdentite()) {
    								player.id.revelerIdentite();
    								jeu.incrementerIdentitesRevelees();
    							}
    							else {
    								player.jouerWitch(player);
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    
    	this.setChanged();
    	this.notifyObservers();
    
    }
    	
}
    


   