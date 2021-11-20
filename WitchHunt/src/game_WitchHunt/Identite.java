import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*; 

public class Identite {

    private String personnage;

    private boolean idRevelee;
   
   ArrayList<String> liste_Id = new ArrayList<String>(Arrays.asList("Villageois","Sorcière"));
    
   public Identite(String personnage, boolean idRevelee) {
	   this.personnage=personnage;
	   this.idRevelee=false;
   }
   
   
    public void revelerIdentite() {
    	System.out.println("");
    	
    }

    void setPersonnage(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.personnage = value;
    }

    
    boolean isIdRevelee() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.idRevelee;
    }

    void setIdRevelee(boolean value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.idRevelee = value;
    }

}
