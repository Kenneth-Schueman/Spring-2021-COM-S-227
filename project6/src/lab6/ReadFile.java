package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("story.txt");
		Scanner scanner = new Scanner(file);
		int wordCount;
		 while (scanner.hasNextLine())
		    {
		      String line = scanner.nextLine();
		      String[] words = line.split(" ");
		      if(words.length == 1) {
		    	  wordCount = 0;
		      }
		      else {
		    	  wordCount = words.length;  
		      }  
		      System.out.print(wordCount + " ");
		      System.out.println(line);
		    }
	
		scanner.close();
	}
}

