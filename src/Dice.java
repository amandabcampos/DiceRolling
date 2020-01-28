import java.util.Random;
import java.util.Scanner;

/*
 * 
 * @author amandabcampos
 * 
 */

public class Dice {
	
	public static void main(String[] args) {
		
		// Box Cars : Both dice are six
		// Snake eyes : Both dice are one
		// Craps: Sum of both dice is two, three or twelve (only on first roll)
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Welcome to the Grand Circus Casino!");
	
		int rolls = 0;
		boolean looping = true;
		while(looping) {
			
			rolls++;
			System.out.println("How many sides should each die have?");
			int numSides = scnr.nextInt();
			
			System.out.println("Roll " + rolls);
			
			int num1 = generateRandomDieRoll(numSides);
			int num2 = generateRandomDieRoll(numSides);
			
			System.out.println(num1 + "\n" + num2);
			
			if (rolls == 1) {
				System.out.println("Is it Craps? " + craps(num1 + num2));
			} else {
				System.out.println("Is it a special combination? " + specialCombinations(num1+num2));
			}
			
			System.out.println("Roll again? (y/n): ");
			if (scnr.next().startsWith("n")) {
				System.out.print("Bye!");
				looping = false;
			}
		}
		scnr.close();			
	}
	
	private static int generateRandomDieRoll(int numSides) {	
		//return (int) (Math.floor(Math.random()*numSides + 1));	
		
		Random random = new Random();
		return random.nextInt(numSides) + 1;	
	}
	
	private static String specialCombinations(int sum) {
		if (sum == 2) {
			return "Snake Eyes";
		} else if( sum == 12 ) {
			return "Box Cars";
		}
		return "No special combination";
	}
	
	private static String craps(int sum) {
		if (sum == 2 || sum == 3 || sum == 12) {
			return "Craps!";
		}
		return "Not craps";
	}

}
