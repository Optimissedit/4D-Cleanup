import java.io.File;
import java.io.FileWriter;
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
		ArrayList<Point4d> pointList = new ArrayList<>();
		
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
				pointList.add(new Point4d(list[0], list[1], list[2], list[3]));

				for(int i = 0; i < points.length; i++) {
					//System.out.println(result.get(i));
				}
				//System.out.println(content + "\n");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// End reading file
		
		
		/*
		 * Create an array to store point indexes in order of visiting
		 *  -- Final structure will also be final path --
		 */
		ArrayList<Integer> visited = new ArrayList<>();
		// Variables to handle index of currently selected point, and the index of next found point
		int selectedInt = 0;
		int nextInt = 0;
		double pathSum = 0;
		//TODO: Loop until all points have been visited
		while(visited.size() < pointList.size()) {
			// Add current selectedIndex to visited list and mark it visited
			pointList.get(selectedInt).markVisited();
			visited.add(selectedInt);
			
			double min = Double.MAX_VALUE;
			boolean check = false;
			// Find next viable point with minimum distance
			for(int j = 0; j < pointList.size(); j++) {
				
				Point4d a = new Point4d(pointList.get(selectedInt));
				// Found point is less than previous, not the current int, and isn't visited already
				if(min > a.findDistance(pointList.get(j)) && j != selectedInt && !pointList.get(j).isVisited()) {
					//System.out.println("New Min:" + a.findDistance(pointList.get(j)));
					min = a.findDistance(pointList.get(j));
					nextInt = j;
					check = true;
				}
			}
			if(check) {
				pathSum = pathSum + min;
			}

			//System.out.println("Next Index " + nextInt);
			selectedInt = nextInt;
		}
		
		System.out.println(pathSum);
		
		try {
			File output = new File("output.txt");
			if(output.createNewFile()) {
				System.out.println("File successfully created.");
			}
			else {
				// File already exists, do nothing
			}			
			FileWriter writer = new FileWriter(output);
			writer.write("[");
			for(int i = 0; i < visited.size(); i++) {
				writer.write("(");
				writer.write(pointList.get(visited.get(i)).toString());
				if(i == visited.size() - 1) {
					writer.write(")");
				} else {
					writer.write("), ");
				}

			}
			writer.write("]");
			writer.close();
			
		}
		catch(IOException err) {
			//Error handling
			err.printStackTrace();
		}
	}
	



}


