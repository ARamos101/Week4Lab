package week04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Week04StringBuilderListSetMapLab {
	public static void main(String[] args) {

		// 1. Why would we use a StringBuilder instead of a String?
		// 		a. Instantiate a new StringBuilder
		//		b. Append the characters 0 through 9 to it separated by dashes
		// 				Note:  make sure no dash appears at the end of the StringBuilder
		//1.) We would use a StringBuilder if we wanted to continue to modify the string we had directly.
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append(i + "-");
		}
		sb.deleteCharAt(sb.length() - 1);  // Remove the last dash
		String newWord = sb.toString();
		System.out.println(newWord);
		
		// 2. List of String:
		//		a. Create a list of Strings 
		//		b. Add 5 Strings to it, each with a different length
		List<String> names = new ArrayList<>(Arrays.asList("Johnny Appleseed", "Beethoven", "Alexander The Great", "Bob", "Rick"));
		
		
		// 3. Write and test a method that takes a list of strings 
		//			and returns the shortest string
		System.out.println(shortest(names));

		
        // 4. Write and test a method that takes a list of strings 
        // and returns the list with the first and last element switched
      System.out.println(switchFirstAndLast(names));
      
        // 5. Write and test a method that takes a list of strings 
        // and returns a string with all the list elements concatenated to each other, 
        // separated by a comma
      System.out.println(concatList(names));
      
        // 6. Write and test a method that takes a list of strings and a string 
        // and returns a new list with all strings from the original list 
        // containing the second string parameter (i.e. like a search method)
      System.out.println(findString(names, "e"));	//Can search for any string at all shared among all the strings
      
        // 7. Write and test a method that takes a list of integers 
        // and returns a List<List<Integer>> with the following conditions specified 
        // for the return value: 
        // a. The first List in the returned value contains any number from the input list 
        // that is divisible by 2 
        // b. The second List contains values from the input list that are divisible by 3 
        // c. The third containing values divisible by 5, and 
        // d. The fourth all numbers from the input List not divisible by 2, 3, or 5
      List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);	//Quick way to make preset lists without typing .add multiple times.
      System.out.println(divisibleBy(integers));
      
        // 8. Write and test a method that takes a list of strings 
        // and returns a list of integers that contains the length of each string
      System.out.println(findLength(names));
      
        // 9. Create a set of strings and add 5 values
      System.out.println("\nQuestion 9:");
      Set<String> stringSet = new HashSet<String>(Arrays.asList("Along", "the", "elephant", "tree", "edges"));
      System.out.println("Set of Strings: " + stringSet);
      
        // 10. Write and test a method that takes a set of strings and a character 
        // and returns a set of strings consisting of all the strings in the 
        // input set that start with the character parameter.
      System.out.println(findStringStart(stringSet, 't'));
      
        // 11. Write and test a method that takes a set of strings 
        // and returns a list of the same strings
      System.out.println(setToList(stringSet));
      
        // 12. Write and test a method that takes a set of integers 
        // and returns a new set of integers containing only even numbers 
        // from the original set
      Set<Integer> integerSet = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
      System.out.println(findEven(integerSet));
      
        // 13. Create a map of string and string and add 3 items to it where the key of each 
        // is a word and the value is the definition of the word
    System.out.println("\nQuestion 13:");
      Map<String, String> stringMap = new HashMap<String, String>();
      stringMap.put("Dinosaur", "Large reptile that lived around 65 million years ago");
      stringMap.put("Food", "Solid that humans eat");
      stringMap.put("Bev", "Liquid humans drink");
      System.out.println(stringMap);
      
        // 14. Write and test a method that takes a Map<String, String> and a string 
        // and returns the value for a key in the map that matches the 
        // string parameter (i.e. like a language dictionary lookup)
      System.out.println(findValue(stringMap, "Dinosaur"));
      
        // 15. Write and test a method that takes a List<String> 
        // and returns a Map<Character, Integer> containing a count of 
        // all the strings that start with a given character
      System.out.println(countStartingLetters(names));
    
	
	}	//END OF THE MAIN BODY CLASS 
    
	//LIST OF ALL METHODS BELOW:
	
	// Method 3:
	public static String shortest(List<String> stringList) {
		System.out.println("\nMethod 3:");
		String shortest = stringList.get(0);
		for (String str : stringList) {
			if (str.length() < shortest.length()) {
				shortest = str;
			}
		}
		return shortest;
	}
    // Method 4:
  public static List<String> switchFirstAndLast(List<String> list) {
    System.out.println("\nMethod 4:");
    String first = list.get(0);
    list.set(0,list.get(list.size() - 1)); //Puts the last element in the first position
    list.set(list.size() - 1, first);  //Puts the first element in the last position
    return list;
  }
    // Method 5:
  public static String concatList(List<String> list) {
    System.out.println("\nMethod 5:");
    String result = "";
    for (String string : list) {
      result += string + ",";
    }
    return result;
  }
    // Method 6:
  public static List<String> findString(List<String> strings, String str) {
    System.out.println("\nMethod 6:");
    List<String> newStrings = new ArrayList<String>();
    for (String string : strings) {
      if (string.contains(str)) {
        newStrings.add(string);
      }
    }
    return newStrings;
  }
    // Method 7:
  public static List<List<Integer>> divisibleBy(List<Integer> numbers) {
    System.out.println("\nMethod 7:");
    List<List<Integer>> divisible = new ArrayList<List<Integer>>();
    List<Integer> divisibleBy2 = new ArrayList<Integer>();
    List<Integer> divisibleBy3 = new ArrayList<Integer>();
    List<Integer> divisibleBy5 = new ArrayList<Integer>();
    List<Integer> notDivisible = new ArrayList<Integer>();
    for (int i = 0; i < numbers.size(); i++) {
      if (numbers.get(i) % 2 == 0) {
        divisibleBy2.add(numbers.get(i));
      }
      if (numbers.get(i) % 3 == 0) {
        divisibleBy3.add(numbers.get(i));
      }
      if (numbers.get(i) % 5 == 0) {
        divisibleBy5.add(numbers.get(i));
      }
      if (numbers.get(i) % 2 != 0 && numbers.get(i) % 3 != 0 && numbers.get(i) % 5 != 0) {
        notDivisible.add(numbers.get(i));
      }
    }
    divisible.add(divisibleBy2);
    divisible.add(divisibleBy3);
    divisible.add(divisibleBy5);
    divisible.add(notDivisible);
    
    return divisible;
  }
    // Method 8:
  public static List<Integer> findLength(List<String> strings) {
    System.out.println("\nMethod 8:");
    List<Integer> lengths = new ArrayList<Integer>();
    for (String string : strings) {
      lengths.add(string.length());
    } return lengths;
  }
    // Method 10:
  public static Set<String> findStringStart(Set<String> set, char c) {
    System.out.println("\nMethod 10:");
    Set<String> newSet = new HashSet<String>();
    for (String string : set) {
      if(string.charAt(0) == c) {
        newSet.add(string);
      }
    }
    return newSet;
  }
    // Method 11:
  public static List<String> setToList(Set<String> set) {
    System.out.println("\nMethod 11:");
    List<String> list = new ArrayList<String>();
    list.addAll(set);
    return list;
  }
    // Method 12:
  public static Set<Integer> findEven(Set<Integer> integers) {
    System.out.println("\nMethod 12:");
    Set<Integer> set = new HashSet<Integer>();
    for (Integer integer: integers) {
      if (integer % 2 == 0) {
        set.add(integer);
      }
    }
    return set;
  }
    // Method 14:
  public static String findValue(Map<String, String> map, String key) {
    System.out.println("\nMethod 14:");
    return map.get(key);
  }

    //Method 15:
      public static Map<Character, Integer> countStartingLetters(List<String> strings) {
        System.out.println("\nMethod 15:");
          Map<Character, Integer> map = new HashMap<Character, Integer>();
            for (String string: strings) {
              char firstChar = string.charAt(0);
              if (map.containsKey(firstChar)) {	//if the map has that character in it as a key then increase the value by 1
                map.put(firstChar, map.get(firstChar) + 1);
              }
              else {	//if the map doesn't have that character as a key then set value to 1
                map.put(firstChar, 1);
              }
            }
          return map;
        }
}