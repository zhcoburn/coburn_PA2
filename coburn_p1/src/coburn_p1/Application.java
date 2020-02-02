package coburn_p1;

/* This code allows a user to either encrypt or decrypt a four-digit
 * code by choosing an option, then typing in a number between 0 and 9999.
 * 
 * Pseudocode
 * 
 * 1.
 * ReadUserChoice
 * if Valid
 * Progress
 * 
 * else
 * return to 1.
 * 
 * 2.
 * ReadUserInput
 * if Valid
 *  if choice was 1
 *   encrypts code
 *  else
 *   assumes choice was 2, decrypts code
 * 
 * else
 * return to 2.
 * 
 * Read out final result
 *
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Application {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		DecimalFormat code = new DecimalFormat("0000");
		
		int choiceval = 0, inputval = 0, outputval = 0;
		boolean isValid = false;
		
		System.out.println("Welcome to the encryption machine!");
		System.out.println("What functionality would you like to use?");
		System.out.println("1 - Encrypt a 4-digit number");
		System.out.println("2 - Decrypt a 4-digit number");
		System.out.println("");
		
		
		// Does not progress code until a valid choice is made
		while(!isValid)
		{
			choiceval = in.nextInt();
			if(choiceval == 1 || choiceval == 2)
			{
				isValid = true;
			}
			else
				System.out.println("The choice you entered is invalid. Please try again.");
			System.out.println("");
		}
		
		isValid = false;
		
		System.out.println("Please enter a four-digit, positive integer. ");
		System.out.println("");
		// Does not progress until a valid code is entered
		while(!isValid)
		{
			inputval = in.nextInt();
			if(inputval < 10000 && inputval >= 0)
				isValid = true;
			else
				System.out.println("The value you entered is invalid. Please try again.");
			System.out.println("");
		}
		
		// Encrypts if choice was 1, decrypts if choice was 2
		if(choiceval == 1)
		{
			System.out.println("Encrypting...");
			outputval = Encrypter.encrypt(inputval);
			String finalcode = code.format(outputval);
			System.out.println("Done!");
			System.out.println("");
			System.out.print("The new encrypted code is ");
			System.out.println(finalcode);
		}
		
		if(choiceval == 2)
		{
			System.out.println("Decrypting...");
			outputval = Decrypter.decrypt(inputval);
			String finalcode = code.format(outputval);
			System.out.println("Done!");
			System.out.println("");
			System.out.print("The decrypted code is ");
			System.out.println(finalcode);
		}
	}
}


