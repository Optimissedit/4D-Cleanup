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
		// Creates an arraylist holding an array of coordinates for N points
		// Note format is list.get(i)[j] with i being point index and j being xyzt coordinate
		ArrayList<double[]> list = getPoints(1);

	}
	
	// Function to read in from points.txt and grab n number of points
	public static ArrayList<double[]> getPoints(int n){
		// Get input file 
		File file = new File("points.txt");
		// Create arraylist to return
		ArrayList<double[]> result = new ArrayList<>();
		
		try(Scanner in = new Scanner(file)){
			// Variable to hold char from file
			String content;
			//variable to hold temporary list of coordinates
			double[] list = new double[4];
			// Counter to increment how many points we've taken in
			int counter = 0;
			// Loop to grab n points from the file
			while(counter < n) {
				// Grab the next point's raw characters from the file
				content = in.next().replaceAll("\\[|\\(|\\)|\\]", "");
				// Split each point into individual coordinates
				String[] points = content.split(",");
				// Parse strings into doubles to be used in the program		
				for(int i = 0; i < points.length; i++) {
					list[i] = Double.parseDouble(points[i]);
				}
				// Add the resulting list to the arraylist
				result.add(list);
				
				counter++;
				for(int i = 0; i < points.length; i++) {
					//System.out.println(list[i]);
				}
				//System.out.println(content + "\n");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
		
	}
}


