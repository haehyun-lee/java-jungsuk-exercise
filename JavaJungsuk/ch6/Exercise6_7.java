package ch6;

class MyPoint{
	int x;
	int y;
	
	MyPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public double getDistance(double x1, double y1) {
		double xd = Math.pow(x1-x, 2);
		double yd = Math.pow(y1-y, 2);
		
		return Math.sqrt(xd + yd);
	}
}

public class Exercise6_7 {

	public static void main(String[] args) {
		MyPoint p = new MyPoint(1, 1);
		
		System.out.println(p.getDistance(2, 2));
	}

}
