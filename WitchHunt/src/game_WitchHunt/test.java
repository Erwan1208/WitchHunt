package game_WitchHunt;

import java.util.Scanner;

public class test {

	private String personnage;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stu
	    	System.out.println("Quelle personnage choisis-tu? Taper 'Villageois' ou 'Witch'.\n");
	    	Scanner sc= new Scanner(System.in);
	    	String perso = sc.next();
	    	System.out.println(perso);
	    	sc.close();
	    }
	}


