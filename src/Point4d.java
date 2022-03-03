
public class Point4d{
	double x;
	double y;
	double z;
	double t;
	boolean visited;
	
	// Default Constructor
	Point4d(){
		x = 0;
		y = 0;
		z = 0;
		t = 0;
		this.visited = false;
	}
	
	// 4 Given values constructor
	Point4d(double x, double y, double z, double t){
		this.x = x;
		this.y = y;
		this.z = z;
		this.t = t;
		this.visited = false;
	}
	
	Point4d(double[] c){
		this.x = c[0];
		this.y = c[1];
		this.z = c[2];
		this.t = c[3];
		this.visited = false;
	}
	// Copy Constructor
	Point4d(Point4d p){
		this.x = p.x;
		this.y = p.y;
		this.z = p.z;
		this.t = p.t;
		this.visited = p.visited;
	}
	
	public String toString() {
		return (x + ", " + y + ", " + z + ", " + t);
	}
	
	public boolean equals(Point4d p) {
		return(this.x == p.x && this.y == p.y && this.z == p.z && this.t == p.t);
	}
	
	// Function to check if this point has been visited
	boolean isVisited() {
		return visited;
	}
	
	// Set the point to visited
	void markVisited() {
		visited = true;
	}
	
	// Finds euclidean distance between the two points
	double findDistance(Point4d b) {	
		return Math.sqrt(Math.pow(this.x - b.x ,2) + Math.pow(this.y - b.y,2) + Math.pow(this.z - b.z,2) + Math.pow(this.t - b.t,2));
	}
	
	// Returns coordinates in an array
	double[] getCoordArray() {
		double[] result = {x,y,z,t};
		return result;
	}
	
	double getX() {
		return x;
	}
	
	double getY() {
		return y;
	}
	
	double getZ() {
		return z;
	}
	
	double getT() {
		return t;
	}
	
	void setX(double x) {
		this.x = x;
	}
	
	void setY(double y) {
		this.y = y;
	}
	
	void setZ(double z) {
		this.z = z;
	}
	
	void setT(double t) {
		this.t = t;
	}
	

}
