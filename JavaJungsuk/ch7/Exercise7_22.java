package ch7;

class Point{
	int x;
	int y;
	
	Point(){
		this(0, 0);
	}
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "["+x+", "+y+"]";
	}
}

abstract class Shape{
	Point p;
	
	Shape(){
		this(new Point(0, 0));
	}
	
	Shape(Point p){
		this.p = p;
	}
	
	abstract double calcArea();
	
	Point getPosition() {
		return p;
	}
	
	void setPosition(Point p) {
		this.p = p;
	}
}

class Circle extends Shape{
	double r;
	
	Circle(){
		this(0);
	}
	
	Circle(double r){
		super();
		this.r = r;
	}
	
	double calcArea() {
		return r*r*Math.PI;
	}
}

class Rectangle extends Shape{
	double width;
	double height;
	
	Rectangle(){
		this(0, 0);
	}
	
	Rectangle(double width, double height){
		super();
		this.width = width;
		this.height = height;
	}
	
	double calcArea() {
		return width*height;
	}
	
	public boolean isSquare() {
		return (width==height);
	}
}

public class Exercise7_22 {

	static double sumArea(Shape[] arr) {
		double sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] instanceof Circle) {
				sum += ((Circle)arr[i]).calcArea();
			}else if(arr[i] instanceof Rectangle) {
				sum += ((Rectangle)arr[i]).calcArea();
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Shape[] arr = {new Circle(5.0), new Rectangle(3, 4), new Circle(1)};
		System.out.println("면적의 합:"+sumArea(arr));
	}

}
