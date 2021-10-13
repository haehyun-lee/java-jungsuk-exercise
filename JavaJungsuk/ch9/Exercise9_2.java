package ch9;

public class Exercise9_2 {

	public static void main(String[] args) {
		Point3D p1 = new Point3D(1,2,3);
		Point3D p2 = new Point3D(1,2,3);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("p1==p2?"+(p1==p2));				//참조 주소 비교
		System.out.println("p1.equals(p2)?"+p1.equals(p2));	//인스턴스변수 값 비교
	}

}

class Point3D {
	int x, y, z;
	
	Point3D(){
		this(0,0,0);
	}
	
	Point3D(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Point3D) {
			Point3D p3d = (Point3D)obj;
			return this.x==p3d.x && this.y==p3d.y && this.z==p3d.z;
		}
		
		return false;
	}
	
	public String toString() {
		return String.format("[%d, %d, %d]", x, y, z);
	}
}
