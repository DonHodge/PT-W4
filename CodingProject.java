package week4;

/**
 * 
 */
public class CodingProject {

	public static void main(String[] args) {
		
// Question 1.)
		
		// initialize array
		int[] ages = {3, 9, 23, 64, 2, 8, 28, 93};
		
		// subtract first element from last element
		System.out.println(ages[ages.length -1] - ages[0]);
		
		// create array ages2
		int[] ages2 = {2, 10, 25, 63, 1, 9, 30, 97, 42};
		
		// subtract first element from last element
		System.out.println(ages2[ages2.length -1] - ages2[0]);
		
		// iterate through ages2 & calculate average
		int sum = 0;
		int avgAge = 0;
		for (int i = 0; i < ages2.length - 1; i++)sum += ages2[i];
		avgAge = sum / ages2.length;
		System.out.println(avgAge);
		
// Question 2.)
		
		// create String array
		String[] names = {"Sam", "Tommy", "Tim",
				"Sally", "Buck", "Bob"};
		
		// iterate through names, calculate average number of letters
		int numInName = 0;
		int avgNameLength = 0;
		for (int i = 0; i < names.length -1 ; i++) numInName += names[i].length();
		avgNameLength = numInName / names.length;
		System.out.println("Average length of names:" + avgNameLength);
		
		// print names on the same line
		for (int i = 0; i < names.length -1; i++) System.out.print(names[i] + " ");
		
// Question 3.) arrayName.length -1;
		
// Question 4.) arrayName[0];
		
// Question 5.)
		
		// create nameLength array;
		int[] nameLengths = new int[names.length -1];
		System.out.println();
		
		// for loop populate array w/length of each name
		for (int i = 0; i < names.length -1; i++) nameLengths[i] = names[i].length();
		for (int name : nameLengths) System.out.print(name + " ");
		
// Question 6.)
		System.out.println();
		
		// calculate sum of elements in nameLengths array
		int nameSum = 0;
		for (int i = 0; i <nameLengths.length -1; i++) nameSum += nameLengths[i];
		System.out.println("Sum of name characters: " + nameSum);
		
		// Q7 Called method
		System.out.println(repeatWord("Hello", 3));
		
		// Q8 Called method
		System.out.println(fullName("Deven", "Hodge"));
		
		// Q9 Called method
		int[] randomNumbers = {15, 2, 76, 40, 25, 72};
		System.out.println(greaterThan100(randomNumbers));
		
		// Q10 Called method
		double[] randomDoubles = {35.8, 49.6, 43.5, 6.3, 14.1};
		System.out.println(average(randomDoubles));
		
		// Q13 Called method
		System.out.println(twelveHourClock(15));
	}
// Question 7.)
	public static String repeatWord(String word, int n) {
		// initialize return variable
		String repeatedWord = "";
		
		// for loop that adds word to the variable n number of times
		for (int i = 0; i < n; i++) repeatedWord = repeatedWord + word;
		return repeatedWord;
	}
	
// Question 8.)
	public static String fullName(String firstName, String lastName) {
		// concatenate firstName, a space, & lastName
		return firstName + " " + lastName;
	}
	
// Question 9.)
	public static boolean greaterThan100(int[] numbers) {
		// initialize sum variable
		int sum = 0;
		
		// for loop to iterate through numbers array & add sum to variable
		for (int i = 0; i < numbers.length -1; i++) sum += numbers[i];
		// return true if sum variable is greater than 100
		if (sum > 100) return true;
		else return false;
	}
	
// Question 10.)
	public static double average(double[] numbers) {
		// initialize variables
		double sum = 0;
		double avg = 0;
		
		// for loop to add sum of array numbers to variable
		for (int i = 0; i < numbers.length -1; i++) sum += numbers[i];
		// divide sum by total number to calculate avg
		avg = sum / numbers.length;
		
		return avg;
	}
	
// Question 11.)
	public static boolean isFirstBigger(double[] a, double[] b) {
		//use average method to calculate the average of each array
		double avgA = average(a);
		double avgB = average(b);
		
		// compare averages w/if array to find boolean value
		if (avgA > avgB) return true;
		else return false;
	}
	
// Question 12.)
	public static boolean willBuyDrink(boolean isHotOutside, double moneyInPocket) {
		// both conditions checked in if statement
		if (isHotOutside && moneyInPocket > 10.5) return true;
		else return false;
	}
	
// Question 13.)
	/*
	 * This method will convert the hours in military time
	 * into the US familiar 12 hour time. I'm creating this
	 * method because we often handle time at these early
	 * levels of program by simply using a range of 0 - 23,
	 * but that doesn't handle the "am/pm" time that's used
	 * so often
	 */
	public static String twelveHourClock(int hours) {
		
		// this will return a String to include "am/pm"
		// hours 1 - 12 are the am hours, so we return them as they are
		// and include the am
		if (hours >= 1 && hours < 12) return hours + " a.m.";
		// hours 13 - 23 are the pm hours; these can be calculated
		// by subtracting the given hour by 12
		else if (hours >= 13 && hours <= 23) {
			int pm = hours - 12;
			return pm + " p.m.";
		}
		// both noon & midnight are interesting since the logic used
		// for the other hours aren't valid for these conditions
		// To counter this, we give them their own independent conditions
		else if (hours == 12) return hours + " p.m.";
		else if (hours == 0) {
			hours += 12;
			return hours + " a.m.";
		}
		// In the event that a number outside of the range of
		// 0 - 23, the method will basically just say "no"
		else return "Invalid time";
	}

}