

public class EffetHunt {
	
	//La valeurs par defaut des booleans est false
    
    public boolean piocherCarteDefausse;

   
    public boolean faireRevelerIdentite;

   
    public boolean choisiProchainJoueur;


    public boolean regarderIdentite;

   
    public boolean piocherPropreCarteRumeur;

   
    public boolean volerCarte;

    
    public boolean faireRevelerOuDefausser;

   
    public boolean revelerPropreIdentite;


    public boolean faireAccuserAutreJoueur;

  
    public boolean piocherAutreCarteRumeur;
    
    
    public boolean blackCat;
    
    public EffetHunt(String nom) {
    	
    	
    	switch(nom) {
    	case "angryMob":
    		
    		
    		this.faireRevelerIdentite=true;
    		
    		break;
    	case "theInquisition":
    	
    		
    		this.choisiProchainJoueur=true;
    		this.regarderIdentite=true;
    		break;
    		
    	case "pointedHat":
    		
    		this.piocherPropreCarteRumeur=true;
    		this.choisiProchainJoueur=true;
    		break;
    		
    	case "hookedNose":
    		
    		
    		this.choisiProchainJoueur=true;
    		this.volerCarte=true;
    		break;
    		
    	case "broomstick": //Ne peut pas être attaqier par carte AngryMob
    	
    		
    		this.choisiProchainJoueur=true;
    		break;
    		
    	case "wart":  //Ne peut pas etre attaqué par carte DuckingStool
    		
    		
    		this.choisiProchainJoueur=true;
    		break;
    	
    	case "duckingStool":
    		
    		
    		this.faireRevelerOuDefausser=true;
    		break;
    		
    	case "cauldron":
    		
    		this.revelerPropreIdentite=true;
    		
    		break;
    		
    	case "evilEye":
    		
    		this.faireAccuserAutreJoueur=true;
    		break;
    		
    	case "toad":
    		this.revelerPropreIdentite=true;
    		break;
    		
    	case "blackCat":
    		
    		this.blackCat=true; //Cas spécial: Piocher dans la défausse + défausser "Black Cat" + Jouer prochain 
    		
    		
    		break;
    		
    	case "petNewt":
    		
    		this.piocherAutreCarteRumeur=true;
    		this.choisiProchainJoueur=true;
    		break;
    		
    		
    	}
    }

}
