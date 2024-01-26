package week4;
import java.util.*;

public class Week4StringBuilderListSetMapLab {

	public static void main(String[] args) {

		// 1. Why would we use a StringBuilder instead of a String?
		
		/*
		 * We would use a StringBuilder instead of a String when we expect
		 * the size of the String to change several times. As Strings are immutable,
		 * each time we modify a String, we are creating a new String - using memory resources.
		 * A StringBuilder is mutable, so no new memory is used when making changes to the object.
		 */
		
		// 		a. Instantiate a new StringBuilder
		StringBuilder sb = new StringBuilder();
		//		b. Append the characters 0 through 9 to it separated by dashes
		// 				Note:  make sure no dash appears at the end of the StringBuilder
		for (int i = 0; i < 9; i++) sb.append(i + "-");
		sb.append(9);
		System.out.println(sb);

		
		// 2. List of String:
		//		a. Create a list of Strings 
		List<String> safeties = new ArrayList<String>();
		//		b. Add 5 Strings to it, each with a different length
		safeties.add("Dawkins");
		safeties.add("Lott");
		safeties.add("Reed");
		safeties.add("Woodson");
		safeties.add("Taylor");
		
		
		System.out.println();

		// 3. Write and test a method that takes a list of strings 
		//			and returns the shortest string
		System.out.println(shortestWord(safeties));
		System.out.println();
		
		// 4. Write and test a method that takes a list of strings 
		//			and returns the list with the first and last element switched
		System.out.println(firstToLast(safeties));
		System.out.println();

		
		// 5. Write and test a method that takes a list of strings 
		//			and returns a string with all the list elements concatenated to each other,
		// 			separated by a comma
		List<String> receivers = new ArrayList<String>();
		receivers.add("Rice");
		receivers.add("Fitzgerald");
		receivers.add("Owens");
		receivers.add("Moss");
		receivers.add("Bruce");
		receivers.add("Brown");
		receivers.add("Smith");
		
		System.out.println(listToString(receivers));
		

		
		// 6. Write and test a method that takes a list of strings and a string 
		//			and returns a new list with all strings from the original list
		// 			containing the second string parameter (i.e. like a search method)
		System.out.println(findString(receivers, "B"));
		System.out.println();

		
		// 7. Write and test a method that takes a list of integers 
		//			and returns a List<List<Integer>> with the following conditions specified
		//			for the return value:
		//		a. The first List in the returned value contains any number from the input list 
		//			that is divisible by 2
		//		b. The second List contains values from the input list that are divisible by 3
		//		c. The third containing values divisible by 5, and 
		//		d. The fourth all numbers from the input List not divisible by 2, 3, or 5

		List<Integer> nums = Arrays.asList(121, 432, 23, 8, 50, 456, 37, 3, 5);
		List<List<Integer>> sortedNums = multidimensionalList(nums);
		
		for (List<Integer> numberList : sortedNums) {
			for (Integer number : numberList) {
				System.out.print(number + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		// 8. Write and test a method that takes a list of strings 
		//			and returns a list of integers that contains the length of each string
		System.out.println(wordLength(receivers));

		
		// 9. Create a set of strings and add 5 values
		Set<String> jedi = new HashSet<String>();
		jedi.add("Luke");
		jedi.add("Yoda");
		jedi.add("Obi-Wan");
		jedi.add("Mace Windu");
		jedi.add("Qui-Gon");
		
		System.out.println();
		
		
		// 10. Write and test a method that takes a set of strings and a character 
		//			and returns a set of strings consisting of all the strings in the
		// 			input set that start with the character parameter.
		
		System.out.println(startsWith(jedi, 'Y'));
		System.out.println();
		

		
		// 11. Write and test a method that takes a set of strings 
		//			and returns a list of the same strings
		System.out.println(setToList(jedi));
		System.out.println();

		// 12. Write and test a method that takes a set of integers 
		//			and returns a new set of integers containing only even numbers 
		//			from the original set
		Set<Integer> randomSet = new HashSet<Integer>();
		randomSet.add(121);
		randomSet.add(43);
		randomSet.add(23);
		randomSet.add(8);
		randomSet.add(50);
		randomSet.add(456);
		randomSet.add(37);
		randomSet.add(3);
		randomSet.add(5);
		randomSet.add(20);
		
		System.out.println(evenSet(randomSet));
		System.out.println();

		
		// 13. Create a map of string and string and add 3 items to it where the key of each
		// 			is a word and the value is the definition of the word
		
		Map<String, String> costumeIdea = new HashMap<String, String>();
		costumeIdea.put("Black Panther", "T'Challa ~ King of Wakanda");
		costumeIdea.put("Nightwing", "Adult Robin w/sick costume");
		costumeIdea.put("Green Lantern", "John Stewart - the black one");
		
		// 14. Write and test a method that takes a Map<String, String> and a string 
		// 			and returns the value for a key in the map that matches the
		// 			string parameter (i.e. like a language dictionary lookup)
		System.out.println(lookup(costumeIdea, "Green Lantern"));
		System.out.println();

		
		// 15. Write and test a method that takes a List<String> 
		//			and returns a Map<Character, Integer> containing a count of 
		//			all the strings that start with a given character
		
		Map<Character, Integer> letterCount = countOfLetter(receivers);
		for (Character initial : letterCount.keySet()) System.out.println(initial + " - " + letterCount.get(initial));
	}
	
	
	// Method 15:
	public static Map<Character, Integer> countOfLetter(List<String> list) {
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (String string : list) {
			char letter = string.charAt(0);
			if (map.get(letter) == null) map.put(letter, 1);
			else map.put(letter, map.get(letter)+1);
		}
		
		return map;
	}
	
	
	// Method 14:
	public static String lookup(Map<String, String> map, String str) {
		
		for (String key : map.keySet()) {
			if (key.equals(str)) return map.get(key);
		}
		
		return "Word not found";
	}

	
	// Method 12:
	public static Set<Integer> evenSet(Set<Integer> set) {
		Set<Integer> results = new HashSet<Integer>();
		for(Integer number : set)
			if (number % 2 == 0) results.add(number);
		
		return results;
	}

	
	// Method 11:
	public static List<String> setToList(Set<String> set) {
		
		List<String> list = new ArrayList<String>();
		for (String string : set) list.add(string);
		
		return list;
	}


	// Method 10:
	public static Set<String> startsWith(Set<String> set, char initial) {
		
		Set<String> results = new HashSet<String>();
		
		for (String word : set) {
			if (word.charAt(0) == initial) results.add(word);
		}
		
		return results;
	}

	
	// Method 8:
	public static List<Integer> wordLength(List<String> stringArray) {
		
		List<Integer> nameLength = new ArrayList<Integer>();
		for (int i = 0; i < stringArray.size(); i++) nameLength.add(stringArray.get(i).length());
		
		return nameLength;
	}
	

	
	// Method 7:
	public static List<List<Integer>> multidimensionalList(List<Integer> numbers) {
		
		List<List<Integer>> x = new ArrayList<List<Integer>>();
		
		// add ArrayList
		x.add(new ArrayList<Integer>());
		x.add(new ArrayList<Integer>());
		x.add(new ArrayList<Integer>());
		x.add(new ArrayList<Integer>());
		
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) % 2 == 0) x.get(0).add(numbers.get(i));
			if (numbers.get(i) % 3 == 0) x .get(1).add(numbers.get(i));
			if (numbers.get(i) % 5 == 0) x.get(2).add(numbers.get(i));
			if (numbers.get(i) % 2 != 0 && numbers.get(i) % 3 != 0 && numbers.get(i) % 5 != 0)
				x.get(3).add(numbers.get(i));
		}
		
			
		return x;
		}
	

	
	// Method 6:
	public static List<String> findString(List<String> stringArray, String str) {
		List<String> result = new ArrayList<String>();
		for (String string : stringArray) {
			if (string.contains(str)) result.add(string);
		}
		
		return result;
	}
	

	
	// Method 5:
	public static String listToString(List<String> stringArray) {
		return stringArray.toString();
	}
	
	
	
	// Method 4:
	public static List<String> firstToLast(List<String> words) {
		
		String temp = words.get(0);
		String last = words.get(words.size()-1);
		words.set(0, last);
		words.set(words.size()-1, temp);
		
		return words;
	}
	
	
	// Method 3:
	public static String shortestWord(List<String> words) {
		
		String shortest = words.get(0);
		for (String word : words) if (word.length() < shortest.length()) shortest = word;
		
		return shortest;
	}
	

}