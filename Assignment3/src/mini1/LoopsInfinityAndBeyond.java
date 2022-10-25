package mini1;

import java.util.Scanner;
/**
 * Utility class with a bunch of static methods for loop practice.
 * @author Kenneth Schueman
 */
public class LoopsInfinityAndBeyond {
// disable instantiation
	private LoopsInfinityAndBeyond() { }
	
	/**
	 * Returns a new string in which every character in the given string that
	 * is not already repeated consecutively is doubled.
	 * 
	 * @param text given starting string
	 * @return string with characters doubled
	 */
	public static String doubleChars(String text) 
	{
		int i;
		String newString = "";
		
		if (text.length() > 1)
		{
			newString += "" + text.charAt(0);
		}
		
		else if (text.length() == 1)
		{
			newString += text.charAt(0);
			newString += text.charAt(0);
			return (newString);
		}
		
		else
		{
			return (newString += "");
		}
		
		if (text.charAt(0) != text.charAt(1)) 
		{
			newString += text.charAt(0);
		}
		
		for (i = 1; i < text.length() - 1; i++) 
		{
			newString += text.charAt(i);
			if (text.charAt(i) != text.charAt(i - 1) && text.charAt(i) != text.charAt(i + 1)) 
			{
				newString += text.charAt(i);
			}
		}
		
		newString += text.charAt(text.length() - 1);
		if (text.charAt(text.length() - 2) != text.charAt(text.length() - 1))
		{
			newString += text.charAt(text.length() - 1);
		}
		
		return (newString);
	}

	/**
	 * Returns a year with the highest value, given a string containing pairs
	 * of years and values (doubles). If there are no pairs, the method returns
	 * -1. In the case of a tie, the first year with the highest value is
	 * returned. Assumes the given string follows the correct format.
	 * 
	 * @param data given string containing year-value pairs
	 * @return first year associated with the highest value, or -1 if no pair
	 *         given
	 */

	public static int maxYear(String data) 
	{
		Scanner scan = new Scanner(data);
		int currYear;
		double currYearVal;
		
		if (data.length() == 0) 
		{
			scan.close();
			return (-1);
		}
		
		int maxYear = scan.nextInt();
		double maxVal = scan.nextDouble();
		
		while (scan.hasNextInt()) 
		{
			currYear = scan.nextInt();
			currYearVal = scan.nextDouble();
			
			
			if (currYearVal > maxVal)
			{
				maxYear = currYear;
			}
		} 
		
		scan.close();
		return (maxYear);
	}
	
	/**
	 * Returns the number of iterations required until <code>n</code> is equal to
	1,
	 * where each iteration updates <code>n</code> in the following way:
	 * 
	 * <pre>
	 *     if n is even
	 *         divide it in half
	 *     else
	 *         multiply n by three and add 1
	 * </pre>
	 * 
	 * @param n given starting number
	 * @return number of iterations required to reach <code>n == 1</code>, or -1 
	if
	 *         <code>n</code> is not positive
	 */
	public static int collatzCounter(int n) {
		int iterations = 0;
		
		if (n > 1) {
			while (n != 1) 
			{
				if (n % 2 == 0) 
				{
					n /= 2;
				}
				else
				{
					n *= 3;
					n += 1;
				}
				
				++iterations;
			}
		return (iterations);
		}
		
		else
		{
			if (n == 1)
			{
				return (0);
			}
			else
			{
				return (-1);
			}
		}
	}
	
	/**
	 * Returns a new string in which every word in the given string is doubled. A
	 * word is defined as a contiguous group of non-space (i.e., ' ') characters
	 * that starts with an alphabetic letter and are surrounded by spaces and/or
	 * the start or end of the given string. Assumes the given string does not
	 * contain more than one consecutive white-space.
	 * 
	 * @param text given starting string
	 * @return new string in which words are doubled
	 */
	public static String doubleWords(String text) {
		String newString = "";
		String word = "";
		int i;
		
		if (text.length() < 1)
		{
			return (word);
		}
		
		for (i = 0; i < text.length() - 1; i++) 
		{
			newString += text.charAt(i);
			word += text.charAt(i);
			
			if (text.charAt(i + 1) == ' ' && !Character.isDigit(word.charAt(0))) 
			{
				newString += " " + word + " ";
				word = "";
				i++;
			} 
			else if (text.charAt(i + 1) == ' ') 
			{
				word = "";
				i++;
			}
		}
		
		newString += text.charAt(text.length() - 1);
		word += text.charAt(text.length() - 1);
		
		if (!Character.isDigit(word.charAt(0))) 
		{
			newString += " " + word;
		}
		return (newString);
	}
	
	/**
	 * Returns true if string t can be obtained from string s by removing exactly
	 * one vowel character. The vowels are the letters 'a', 'e', 'i', 'o'
	 * and 'u'. Vowels can be matched in either upper or lower case, for example,
	 * 'A' is treated the same as 'a'. If s contains no vowels the method returns
	 * false.
	 * 
	 * @param s longer string
	 * @param t shorter string
	 * @return true if removing one vowel character from s produces the string t
	 */
	public static boolean oneVowelRemoved(String s, String t) {
		String removedVowel = "";
		int i;
		
		for (i = 0; i < s.length(); i++) 
		{
			switch (s.charAt(i)) 
			{
				case 'A':
				case 'E':
				case 'I':
				case 'O':
				case 'U':
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					
					removedVowel = "" + s.substring(0, i) + s.substring(i + 1, s.length());
					
					if (removedVowel.equals(t)) 
					{
						return (true);
					} 
					
					else 
					{
						removedVowel = "";
					}
					break;
				default:
					break;
			}
		}
		return (false);
	}
	
	/**
	 * Returns a new string in which a UFO pattern in the given string is
	 * shifted one character to the right. The UFO pattern starts with a
	 * {@code '<'}, has one or more {@code '='} and ends with a {@code '>'}. The 
	pattern may wrap
	 * around from the end to the beginning of the string, for example
	 * {@code ">  <="}. Any other characters from the given string remain in 
	place.
	 * If the UFO moves over top of another character, that character is
	 * removed. If there are multiple UFO patterns, only the one that starts
	 * farthest to the left is moved.
	 * 
	 * @param space given string
	 * @return a new string with a UFO pattern moved one to the right
	 */
	public static String ufo(String space) {
		int i;
		int breakPointStart = 0;
		int breakPointEnd = 0;
		boolean ufoPatternStart = false;
		boolean ufoPatternMiddle = false;
		boolean ufoPatternEnd = false;
		
		String right = "";
		String newStringStart = "";
		String newStringEnd = "";
		
		for (i = 0; i < space.length(); i++) 
		{
			if (space.charAt(i) == '<') {
				ufoPatternStart = true;
				breakPointStart = i;
				right += '<';
			}
			
			else if (ufoPatternStart && space.charAt(i) == '=') 
			{
				ufoPatternMiddle = true;
				right += '=';
			}
			
			else if (ufoPatternMiddle && space.charAt(i) == '>') 
			{
				ufoPatternEnd = true;
				breakPointEnd = i;
				right += '>';
				break;
			} 
			
			else 
			{
				right = "";
				ufoPatternStart = false;
				ufoPatternMiddle = false;
				ufoPatternEnd = false;
			}
		}
		
		newStringStart += space.substring(0, breakPointStart);
		newStringEnd += space.substring(breakPointEnd + 2, space.length());
		
		if (ufoPatternEnd)
		{
			return (newStringStart + " " + right + newStringEnd);
		}
		
		else
		{
			return (space);
		}
	}
	
	/**
	 * Prints a pattern of <code>2*n</code> rows containing slashes, dashes and 
	backslashes
	 * as illustrated below.
	 * 
	 * @param n number of rows in the output
	 */
	public static void printX(int n) {
		int i, j;
		int ctr = 0;
		int rCtr = n * 2 - 1;
		char fwrd = '/';
		char dash = '-';
		char back = '\\';
		
		if (n <= 0) {
			System.out.println();
		}
		for (i = 0; i < n * 2; i++) 
		{
			for (j = 0; j < n * 2; j++) 
			{
				if (j == ctr) 
				{
					System.out.print(back);
				}
				else if (j != ctr && j != rCtr && (j < ctr || j < rCtr)) 
				{
					System.out.print(dash);
				} 
				if (j == rCtr) {
					System.out.print(fwrd);
				}
			}
			
			rCtr--;
			ctr++;
			System.out.println();
		}
	}
}

