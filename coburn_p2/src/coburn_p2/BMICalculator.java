package coburn_p2;

/* This code allows a user to use Imperial or Metric input,
 * then reads the entered weight or height in the chosen 
 * unit. Calculates BMI with the input height and weight
 * and the category the BMI falls under before printing
 * the resultant BMI and category.
 * 
 * 1.
 * Pseudocode
 * ReadUserChoice
 * if Valid
 * Progress
 * 
 * else
 * return to 1.
 * 
 * 2.
 * Read units in Imperial or Metric
 * if height and weight is positive
 * Progress
 * 
 * else
 * Exit program
 * 
 * CalculateBMI
 * 
 * CalculateBMICategory
 * 
 * DisplayBMI
 * 
 * DisplayBMICategory
 * 
 * 
 */

import java.util.Scanner;

public class BMICalculator {
	private static Scanner in =
		      new Scanner(System.in);
	
	private double heightInInches;
	private double weightInPounds;
	private double heightInMeters;
	private double weightInKilograms;
	private double bmi;
	private int unitType;
	private String bmiCategory;
	
	
	// Reads user unit preference, then values for height and weight
	public void readUserData()
	{
		System.out.println("Please enter the value corresponding to the units you would like to use.");
		System.out.println("1 - Imperial (Weight in pounds, height in inches)");
		System.out.println("2 - Metric (Weight in kilograms, height in meters)");
		readUnitType();
		readMeasurementData();
	}
	
	// Reads chosen unit type. Does not progress until a valid choice is made
	private void readUnitType()
	{
		boolean isValid = false;
		int input = 0;
		
		while(!isValid)
		{
			input = in.nextInt();
			if(input == 1 || input == 2)
			{
				unitType = input;
				isValid = true;
			}
			else
				System.out.println("This choice is invalid. Please try again.");
		}
	}
	
	
	// Reads height and weight values based on unit type chosen
	private void readMeasurementData()
	{
		if(unitType == 1)
			readImperialData();
		else
			readMetricData();
	}

	// Reads in weight in pounds and height in inches. Exits if value is invalid
	private void readImperialData()
	{
		System.out.println("Please enter your weight (in pounds):");
		double input = in.nextDouble();
		if(input < 0)
			System.exit(1);
		else
			setWeight(input);
		
		System.out.println("Please enter your height (in inches):");
		input = in.nextDouble();
		if(input < 0)
			System.exit(1);
		else
			setHeight(input);
	}
	
	// Reads in weight in kilograms and height in meters. Exits if value is invalid
	private void readMetricData()
	{
		System.out.println("Please enter your weight (in kilograms):");
		double input = in.nextDouble();
		if(input < 0)
			System.exit(1);
		else
			setWeight(input);
		
		System.out.println("Please enter your height (in meters):");
		input = in.nextDouble();
		if(input < 0)
			System.exit(1);
		else
			setHeight(input);
	}
	
	// Calculates BMI based on unit choice
	void calculateBmi()
	{
		double result;
		if(unitType == 1)
			result = 703 * getWeight() / (getHeight()*getHeight());
		else
			result = getWeight() / (getHeight()*getHeight());
		bmi = result;
		calculateBmiCategory(bmi);
	}
	
	// Calculates the category the BMI fits into
	private void calculateBmiCategory(double bmi)
	{
		if(bmi < 18.5)
			bmiCategory = "Underweight";
		else if(bmi < 25)
			bmiCategory = "Normal weight";
		else if(bmi < 30)
			bmiCategory = "Overweight";
		else
			bmiCategory = "Obese";
	}
	
	// Displays the BMI and the category it falls into
	public void displayBmi()
	{
		System.out.printf("The calculated Body/Mass Index is %.1f. %n", getBmi());
		System.out.printf("The BMI category this falls into is %s.", getBmiCategory());
	}
	
	// Set and Get methods
	
	public double getWeight()
	{
		if(unitType == 1)
			return weightInPounds;
		else
			return weightInKilograms;
	}
	
	private void setWeight(double input)
	{
		if(unitType == 1)
			weightInPounds = input;
		else
			weightInKilograms = input;
	}
	
	public double getHeight()
	{
		if(unitType == 1)
			return heightInInches;
		else
			return heightInMeters;
	}
	
	private void setHeight(double input)
	{
		if(unitType == 1)
			heightInInches = input;
		else
			heightInMeters = input;
	}
	
	public double getBmi()
	{
		return bmi;
	}
	
	public String getBmiCategory()
	{
		return bmiCategory;
	}
	
	public static void main(String[] args)
	{
		BMICalculator app = new BMICalculator();
	    app.readUserData();
	    app.calculateBmi();
	    app.displayBmi();
	}
}
