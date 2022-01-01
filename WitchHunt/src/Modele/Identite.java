package Modele;

import java.util.Scanner;




public class Identite {
    
    private String personnage;

    
    private boolean idRevelee;

    
    
    public Identite() {
    	this.idRevelee=false;
    	System.out.println("Quelle personnage choisis-tu? Taper 'Villageois' ou 'Witch'.\n");
    	Scanner sc= new Scanner(System.in);		
    	String perso =sc.nextLine();
        this.personnage = perso;
    	
    }
    public void revelerIdentite() {
    	System.out.println("C'EST UN : " + this.personnage);
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