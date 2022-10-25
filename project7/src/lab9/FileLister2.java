package lab9;

import java.io.File;
import java.util.ArrayList;

public class FileLister2 {
	public static void main(String[] args) {
		String rootDirectory = ".";
		listAllFiles(new File(rootDirectory));
	}

	public static void listAllFiles(File f) {
		findFiles(f);
	}

	private static void findFiles(File f) {
		if (!f.isDirectory()) {
			System.out.println(f.getName());
		} else {
			System.out.println(f.getName());
			File[] files = f.listFiles();
			for (int i = 0; i < files.length; i++) {
				findFiles(files[i]);
			}
		}
	}
}
//  public static void main(String[] args)
//  {
//    // Choose the directory you want to list.
//    // If running in Eclipse, "." will just be the current project directory.
//    // Use ".." to list the whole workspace directory, or enter a path to
//    // some other directory.
//    File rootDirectory = new File(".");
//
//    ArrayList<String> result = (rootDirectory);
//    System.out.println(result);
//  }
//
//  /**
//   * Returns a list of files beneath the given file or directory.
//   * 
//   * @param file
//   * @return
//   */
//  public static ArrayList<String> (File file)
//  {
//    // create an empty array list...
//    ArrayList<String> arr = new ArrayList<String>();
//
//    // pass it into the recursive method
//    (file, arr);
//
//    // and return the filled-up ArrayList
//    return arr;
//  }
//
//  /**
//   * Recursive helper method includes an array list as an argument. Filenames
//   * are added to the array list as they are found.
//   * 
//   * @param file
//   * @param list
//   */
//  private static void (File file, ArrayList<String> list)
//  {
//    if (!file.isDirectory())
//    {
//      // base case
//      list.add(file.getName());
//    }
//    else
//    {
//      // recursively search the subdirectory
//      for (File f : file.listFiles())
//      {
//        (f, list);
//      }
//    }
//  }
//
//}