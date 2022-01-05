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

   
    public void setPersonnage(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.personnage = value;
    }

   
    public boolean isIdRevelee() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.idRevelee;
    }


    public void setIdRevelee(boolean value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.idRevelee = value;
    }
    
    public String getPersonnage() {
    	return this.personnage;
    }
    
    	
    
}