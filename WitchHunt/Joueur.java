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


    public List<Rumeur> rumeurs = new ArrayList<Rumeur> ();
    
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
    	scCarte.close();
    	
    	
    	
    	
    	
    	
    	//Choisir sur quelle personne la jouer
    	
    	System.out.println("Sur quelle joueur souhaites-tu jouer la carte Hunt! ?\n");
    	jeu.afficherJoueursVivants();
    	    
    	System.out.println("Entrer son pseudo");
    	Scanner sc = new Scanner(System.in);
    	String nomJoueur = sc.next();
    	sc.close();
    	
    	
    	//Effets Hunts
    	
    	//Trouver la carte jouée/selectionée
    	Iterator<Rumeur> itRum= this.rumeurs.iterator();
    	Rumeur carteJouee;
    	while(itRum.hasNext()) {
    		Rumeur carte=itRum.next();
    		if(carte.nom==nomCarte) {
    			carteJouee=carte;
    			this.rumeurs.remove(carteJouee);
    			this.cartesJouees.add(carteJouee);
    		}
    			
    	}
    	
    	
    	
    	
    	//Faire ses effets
    	
    	
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
    			if(j.pseudo==nomJoueur) {
    				j.id.revelerIdentite();
    			}
    		}
  	
    	 }
    	
    	if(carteJouee.hunt.choisiProchainJoueur) {
    		for(Joueur o: jeu.joueurs) {
    			if(o.pseudo==nomJoueur) { 				//PROBLEME: NE CHANGE PAS L'ORDRE DES JOUEURS QUI SUIVRONT
    				o.jouerTour();
    			}
    		}
    	}
    	
    	if (carteJouee.hunt.regarderIdentite) {
    		for(Joueur o: jeu.joueurs) {
    			if(o.pseudo==nomJoueur) {
    				o.id.revelerIdentite();				//COMMENT FAIRE POUR QUE CE SOIT EN SECRET?
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
    		for(Rumeur o: this.cartesJouees) {
    			if(o.nom==cartepiochee) {
    				this.rumeurs.add(o);
    				this.cartesJouees.remove(o);
    			}
    		}
    		
    	}
    	
    	if(carteJouee.hunt.volerCarte) {
    		for(Joueur o: jeu.joueurs) {
    			if(o.pseudo==nomJoueur) {
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
    		screp.close();
    		
    		for(Joueur j: jeu.joueurs) {
    			if(j.pseudo==nomJoueur) {
    				if(reponse=="Y") {
    	    			j.id.revelerIdentite();
    	    		}
    	    		else {
    	    			Iterator<Rumeur> it= j.rumeurs.iterator();
    	    			while(it.hasNext()) {
    	    				System.out.println(it.next().nom);
    	    			}
    	    			System.out.println("Quelle carte souhaitez-vous défausser?\n Tapez son nom\n");
    	    			Scanner sccarte=new Scanner(System.in);
    	    			String nomDefausse= sccarte.next();
    	    			sccarte.close();
    	    			for(Rumeur o:j.rumeurs) {
    	    				if(o.nom==nomDefausse) {
    	    					jeu.defausse.defausserCarte(o);
    	    					j.rumeurs.remove(o);
    	    				}
    	    			}
    	    			
    	    		}
    			}
    		}
    		
    		
    	}
    	
    	if(carteJouee.hunt.revelerPropreIdentite) {
    		this.id.revelerIdentite();
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
    		Scanner scNomCarte = new Scanner();
    		String nomDeCarte= scNomCarte.next();
    		for(Joueur j : jeu.joueurs) {
    			for(Rumeur carte: j.cartesJouees)
    				if(carte.nom==nomDeCarte) {
    					this.rumeurs.add(carte);
    					j.cartesJouees.remove(carte);
    				}
    		}
    		
    		
    	}
    	if(carteJouee.hunt.blackCat) {
    		//Piocher carte de défausse
    		Random rand= new Random();
    		int randindex= rand.nextInt(jeu.defausse.listRumeur.size());
    		this.rumeurs.add(jeu.defausse.listRumeur.get(randindex));
    		jeu.defausse.listRumeur.remove(randindex);
    		
    		//Defausser carte
    		jeu.defausse.defausserCarte(carteJouee);
    		this.cartesJouees.remove(carteJouee);
    		
    		
    													//PROBLEME:COMMENT ETRE LE PROCHAIN JOUEUR
    	}
    	
    	
    	
    	
    	
    	
    	
    }

    public void jouerWitch() {
    	//Choisir quelle Carte Witch jouer + la jouer
    }
    
   
}