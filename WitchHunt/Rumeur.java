
public class Rumeur {
    
    private String nom;

  
    public EffetHunt hunt;

    
    public EffetWitch witch;
    
    
    public Rumeur(String nom) {
    	
    	this.nom=nom;
    	
    	this.hunt=new EffetHunt(nom);
    	this.witch=new EffetWitch(nom);
    	
    }
    
    

}
