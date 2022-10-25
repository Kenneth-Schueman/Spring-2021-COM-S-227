package lab6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LineNumberer
{
  public static void main(String[] args) throws FileNotFoundException
  {
	File file = new File("U:/Spring 2022/cs227/stuff/story.txt");
    Scanner scanner = new Scanner(file);
    int lineCount = 1;
    int wordCount = 0;

    while (scanner.hasNextLine())
    {
      String line = scanner.nextLine();
      System.out.print("L: " + lineCount + " ");
      //System.out.println(line);
      lineCount += 1;
      
      for (int i = 0; i < line.length(); i++)
      {
    	  if (line.charAt(i) == ' ')
    	  {
    		  ++wordCount;
    	  }
      }
      System.out.println("W: " + wordCount);
      wordCount = 0;
    }
    scanner.close();
  }
}
