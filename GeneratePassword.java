package practiceexample.com;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GeneratePassword {

public String generatePass(int length, int strength) {
		
		String password = "";
		char[] splChars = {'!','@','#','$','%','*','$','[',']','{','}','(',')'};
		
		for(int i=0; i<=length-strength; i++) {
			int chars = getRandom(97, 122);
			password = password + (char) chars;
		}
		
		if(strength >= 2)
			password = password + getRandom(0, 9);
		
		if(strength == 3)
			password = password + splChars[getRandom(0, splChars.length)];//splChars[2]
		
		return password;	//abc6#	
	}
		
	public int getRandom(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
		 
	}
		
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter length:");
		int length = scan.nextInt();
		System.out.println("Enter strength:");
		int strength = scan.nextInt();
		
		GeneratePassword gp = new GeneratePassword();
		
		if(length<4 || length>10 || strength>3 || strength<1)
			System.out.println("Invalid input");
		else
			System.out.println(gp.generatePass(length, strength));
	}

}
	

