import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	//TODO: Plan of action
	// First, grab arraylist of points
	// Grab first point, find shortest path possible to another point
	// Go to that point, find shortest path possible to next point
	// Repeat until we have a full path
	// Print output

	public static void main(String[] args) {
		
		// Get input file 
		File file = new File("points.txt");
		// Create arraylist to hold coordinates
		ArrayList<Point4d> result = new ArrayList<>();
		
		try(Scanner in = new Scanner(file)){
			// Variable to hold char from file
			String content;
			//variable to hold temporary list of coordinates
			double[] list = new double[4];
			String[] points = new String[4];
			// Loop to grab n points from the file
			while(in.hasNext()) {
				// Grab the next point's raw characters from the file
				content = in.next();
				content = content.replaceAll("\\[|\\(|\\)|\\]", "");
				//System.out.println(content);
				// Split each point into individual coordinates
				points = content.split(",");
				// Parse strings into doubles to be used in the program		
				for(int i = 0; i < points.length; i++) {
					list[i] = Double.parseDouble(points[i]);
					//System.out.println(list[i]);
				}
				// Add the resulting list to the arraylist
				result.add(new Point4d(list[0], list[1], list[2], list[3]));

				for(int i = 0; i < points.length; i++) {
					//System.out.println(result.get(i));
				}
				//System.out.println(content + "\n");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// End reading file.
		Point4d p0 = new Point4d(result.get(2));
		Point4d p1 = new Point4d(result.get(1));
		
		System.out.println(p1.equals(p0));
		
		
	}
	



}


