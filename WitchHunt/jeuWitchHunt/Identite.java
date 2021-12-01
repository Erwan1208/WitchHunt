package jeuWitchHunt;
import java.util.*;
import Java.io.BufferedInputStream;
import Java.io.IOException;
import Java.io.InputStream;





public class Identite {
    
    private String personnage;

    
    private boolean idRevelee;

    
    
    public Identite() {
    	this.idRevelee=false;
    	System.out.println("Quelle personnage choisis-tu? Taper 'Villageois' ou 'Witch'.\n");
    	Scanner sc= new Scanner(System.in);
    	if(sc.hasNext()) {
    		String perso = sc.next();
        	this.personnage = perso;
    	}
    	else System.out.prinln("Le scanner est vide")
    }
    public void revelerIdentite() {
    	System.out.println(this.personnage);
    	this.idRevelee=true;
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
    
    String getPersonnage() {
    	return this.personnage;
    }
    
    	
    
}
