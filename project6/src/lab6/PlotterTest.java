package lab6;

import java.awt.Point;
import plotter.Plotter;
import plotter.Polyline;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

import plotter.Polyline;

public class PlotterTest {
	Plotter plotter = new Plotter();
	
/*
 *	public static void main(String[] args) {
 *		Plotter plotter = new Plotter();
 *		Polyline p = parseOneLine("red 100 100 200 100 200 200 100 200 100 100");
 *		plotter.plot(p);
 *
 *		p = parseOneLine("2 blue 250 100 400 350 100 350 250 100");
 * 		plotter.plot(p);
 *	}
 */
	
 	public static void main(String[] args) throws FileNotFoundException 
 	{
 		ArrayList<Polyline> list = readFile("hello.txt");
 		Plotter plotter = new Plotter();
 
 		for (Polyline p : list) 
 		{
 			plotter.plot(p);
 		}
 	}

	
	private static Polyline parseOneLine(String line) 
	{
		Scanner words = new Scanner(line);
		int width = 1;
		if (words.hasNextInt()) 
		{
			width = words.nextInt();
		}
		String color = words.next();
		Polyline p = new Polyline(color, width);
		while (words.hasNextInt()) 
		{
			int a = words.nextInt();
			int b = words.nextInt();
			p.addPoint(new Point(a, b));
		}
		words.close();
		return p;
	}

	private static ArrayList<Polyline> readFile(String filename) throws FileNotFoundException 
	{
		File file = new File(filename);
		Scanner scanner = new Scanner(file);
		ArrayList<Polyline> p = new ArrayList<Polyline>();
		while (scanner.hasNextLine()) 
		{
			String line = scanner.nextLine();
			line = line.trim();
			if (line.length() > 0 && !line.startsWith("#")) 
			{
				p.add(parseOneLine(line));
			}

		}
		scanner.close();
		return p;
	}
}