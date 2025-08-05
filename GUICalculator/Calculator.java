package GUICalculator;
/**
 * 
 * Calculator class to perform basic arithmetic operations:
 * addition, subtraction, multiplication, and division.
 * 
 * @author Ayomide Osineye
 * @aim creating a calculator using java
 * @date 24/06/2025
 */

import java.util.Scanner;
public class Calculator
{
	/**
	 * Adds all integers in the array and returns the sum.
	 * 
	 * @param numbers array of integers to add
	 * @return sum of all numbers
	 */

	public int addition(int numbers[]) 
	{
		int sum = 0;

		for(int i = 0; i < numbers.length; i++) 
		{
			sum += numbers[i];   
		}

		return sum;
	}


	/**
	 * Subtracts all subsequent integers in the array from the first element.
	 * 
	 * @param numbers array of integers to subtract
	 * @return result after subtraction
	 */

	public int subtract(int numbers[]) 
	{

		int sum = numbers[0];

		for(int i = 1; i < numbers.length; i++) 
		{
			sum -= numbers[i];	
		}
		return sum;
	}

	/**
	 * Divides the first integer by all subsequent integers in the array.
	 * 
	 * @param numbers array of integers to divide
	 * @return result after division as a float
	 */

	public float division(int numbers[]) 
	{
		float float_sum  = numbers[0];

		for(int i = 1; i <  numbers.length; i++) 
		{
			if(numbers[i] == 0) 
			{
				return Float.NaN;
			}
			float_sum /= numbers[i];	
		}

		return float_sum;
	}

	/**
	 * Multiplies all integers in the array and returns the product.
	 * 
	 * @param numbers array of integers to multiply
	 * @return product of all numbers
	 */

	public int multiplication(int numbers[]) 
	{
		int result = 1;

		for(int i = 0; i < numbers.length; i++) 
		{
			result *= numbers[i];   
		}

		return result;
	}

	/**
	 * Converts an array of strings into an array of integers.
	 * Assumes the strings are valid integer representations.
	 * 
	 * @param numbers array of strings representing integers
	 * @return array of parsed integers
	 */

	public int[] convertingToInt(String numbers[]) 
	{
		int covertedNumbers[] = new int[numbers.length];

		for(int i = 0; i < numbers.length; i++) 
		{
			covertedNumbers[i] = Integer.parseInt(numbers[i]);	
		}

		return covertedNumbers;
	}

	/**
	 * Prints the result of the specified arithmetic operation on the array of numbers.
	 * 
	 * @param operation the arithmetic operation ("+", "-", "*", "/")
	 * @param numbers array of integers to operate on
	 */

	public void printResult(String operation, int numbers[]) 
	{
		switch(operation) 
		{

		case "+":
			int sum = addition(numbers);
			System.out.println("The result from (+): " + sum);
			break;

		case "-":
			int difference = subtract(numbers);
			System.out.println("The result from (-): " + difference);
			break;

		case "*":
			int product = multiplication(numbers);
			System.out.println("The result from (*): " + product);
			break;

		case "/":
			float quotient = division(numbers);
			System.out.println("The result from (/): " + quotient);
			break;

		default:
			System.out.println("Invalid operation selected");
			break;

		}

	}



	// GUI Calculator methods (version 1)


	public float addition(float a, float b) 
	{
		return a + b; 
	}

	public float subtraction(float a, float b) 
	{
		return a - b;	
	}

	public float division(float a, float b) 
	{

		if(b == 0) 
		{


			return Float.NaN;

		} 

		return a/b;
	}

	public float multiplication(float a, float b) 
	{
		return a * b;
	}

	public static void main(String[] args) 
	{

		Calculator test = new Calculator();

		Scanner keyboard = new Scanner(System.in);
		String inputNumbers = "";
		String operation = "";
		Boolean running = true;
		String input = "";
		String stringSplit[] = null;


		while(running) {

			boolean loop = true;

			while (loop) 
			{
				System.out.println("Enter numbers and separate by commas: ");
				inputNumbers = keyboard.nextLine();
				stringSplit = inputNumbers.split(",");

				// Step 1: Make sure there are at least 2 numbers
				if (stringSplit.length < 2) 
				{
					System.out.println("Invalid input. Please enter at least two numbers separated by commas.");
					continue;
				}

				// Step 2: Validate each entry
				boolean allValid = true;



				// advanced for loop to loop through array
				for (String s : stringSplit) 
				{

					// use of trim to get rid of white space

					String trimmed = s.trim();

					// checks if there are empty cells

					if (trimmed.isEmpty()) {
						allValid = false;
						break;
					}

					// checks if the specific cell can be converted to an integer

					try {
						Integer.parseInt(trimmed);
					} 
					catch (NumberFormatException e) 
					{
						allValid = false;
						break;
					}
				}

				if (!allValid) {
					System.out.println("One or more inputs were invalid. Please try again.");
					continue;
				}

				loop = false;
			}


			System.out.println("Enter '+' to add, '-' to subtract\n'/' to divide, '*' to mutliple: ");
			operation = keyboard.nextLine(); 

			int numbers[] = test.convertingToInt(stringSplit);

			test.printResult(operation, numbers);

			System.out.println("Would you like to quit (Y|N): ");
			input = keyboard.nextLine();

			if(input.equalsIgnoreCase("y"))
			{
				System.out.println("Have a good rest of your day!");
				running = false;
			}

		}



		keyboard.close();


	}

}
