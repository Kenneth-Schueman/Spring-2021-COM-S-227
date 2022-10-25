package lab6;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import plotter.Plotter;
import plotter.Polyline;

public class Polly {
	private static Polyline parseOneLine(String line)
	  {
		return null;
	  }
	
	 private static ArrayList<Polyline> readFile(String filename)
		      throws FileNotFoundException
		  {
			return null;
		  }
	 
	public static void main(String[] args)
	  {
	    Plotter plotter = new Plotter();
	    Polyline p = parseOneLine("red 100 100 200 100 200 200 100 200 100 100");
	    plotter.plot(p);
	    
	    p = parseOneLine("2 blue 250 100 400 350 100 350 250 100");
	    plotter.plot(p);
	  }

}
