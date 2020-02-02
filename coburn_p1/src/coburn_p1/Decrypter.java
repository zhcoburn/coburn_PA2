package coburn_p1;

public class Decrypter {

	public static int decrypt(int inputnum) {
int thoud, hund, tend, oned, outnum;
		
		// Store each digit as an individual number
		thoud = inputnum/1000;
		hund = (inputnum/100)%10;
		tend = (inputnum/10)%10;
		oned = inputnum%10;
		
		// Return the number to its original value by adding 3,
		// then finding the remainder of dividing by 10
		thoud = (thoud+3)%10;
		hund = (hund+3)%10;
		tend = (tend+3)%10;
		oned = (oned+3)%10;
		
		// Swap the 1st and 3rd digit, then the 2nd and 4th digit
		int temp;
		
		temp = thoud;
		thoud = tend;
		tend = temp;
		
		temp = hund;
		hund = oned;
		oned = temp;
		
		// Combine the digits into the now decrypted number
		outnum = thoud*1000 + hund*100 + tend*10 + oned;
		
		return outnum;
	}

}
