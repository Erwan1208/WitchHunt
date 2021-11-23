public class EffetWitch {
	
	//La valeur par defaut des booleans est false
  
    public boolean faireDefausserCarte;

   
    public boolean defausserCarte;

   
    public boolean jouerProchain;


    public boolean piocherPropreCarteRumeur;
    
    
    public boolean piocherCarteAcusateur;


    public boolean choisiProchainJoueur;

   
    public boolean faireAccuserAutreJoueur;
    
    
    
    public void EffetWitch(String pseudo){
    	
    	switch(pseudo) {
    	case "angryMob":
    		this.jouerProchain=true;
    		break;
    		
    	case "theInquisition":
    		this.defausserCarte=true;
    		this.jouerProchain=true;
    		
    		
    		break;
    		
    	case "pointedHat":
    		this.piocherPropreCarteRumeur=true;
    		this.jouerProchain=true;
    		
    	
    		break;
    		
    	case "hookedNose":
    		this.piocherCarteAcusateur=true;
    		this.jouerProchain=true;
    		
    
    		break;
    		
    	case "broomstick": //Ne peut pas être attaqier par carte AngryMob
    		this.jouerProchain=true;
    		
    		break;
    		
    	case "wart":  //Ne peut pas etre attaqué par carte DuckingStool
    		this.jouerProchain=true;
    		
    		break;
    	
    	case "duckingStool":
    		this.choisiProchainJoueur=true;
    		
    		break;
    		
    	case "cauldron":
    		this.faireDefausserCarte=true;
    		this.jouerProchain=true;
    		break;
    		
    	case "evilEye":
    		
    		this.choisiProchainJoueur=true;
    		this.faireAccuserAutreJoueur=true;
    		
    		break;
    		
    	case "toad":
    		
    		this.jouerProchain=true;
    		
    		break;
    		
    	case "blackCat":
    		
    		this.jouerProchain=true;
    		
    		break;
    		
    	case "petNewt":
    		
    		this.jouerProchain=true;
    		
    		break;
    		
    	}
    	
    	
    }



	
    

}