package coburn_p1;

public class Encrypter {

	public static int encrypt(int inputnum) 
	{
		int thoud, hund, tend, oned, outnum;
		
		// Store each digit as an individual number
		thoud = inputnum/1000;
		hund = (inputnum/100)%10;
		tend = (inputnum/10)%10;
		oned = inputnum%10;
		
		// Alter the number by adding 7, then finding the remainder
		// of dividing by 10
		thoud = (thoud+7)%10;
		hund = (hund+7)%10;
		tend = (tend+7)%10;
		oned = (oned+7)%10;
		
		// Swap the 1st and 3rd digit, then the 2nd and 4th digit
		int temp;
		
		temp = thoud;
		thoud = tend;
		tend = temp;
		
		temp = hund;
		hund = oned;
		oned = temp;
		
		// Combine the digits into the new, encrypted number
		outnum = thoud*1000 + hund*100 + tend*10 + oned;
		
		return outnum;
	}

}
