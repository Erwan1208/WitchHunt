package game_WitchHunt;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    	this.idRevelee=false;
	    	System.out.println("Quelle personnage choisis-tu? Taper 'Villageois' ou 'Witch'.\n");
	    	Scanner sc= new Scanner(System.in);
	    	String perso = sc.next();
	    	this.personnage = perso;
	    	sc.close();
	    }
	}

}
