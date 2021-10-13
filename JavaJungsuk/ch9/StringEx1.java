package ch9;

public class StringEx1 {
	public static void main(String[] args) {
		//replace()
		String s = "helloworld에 오신걸 welcome합니다~";
		String s1 = s.replace("helloworld", "").replace("welcome", "");
		
		System.out.println("s:  "+s);
		System.out.println("s1: "+s1);
		System.out.println();
		
		//replaceAll()
		String s2 = "helloworld에 오신걸 welcome합니다~";
		String s3 = s2.replaceAll("[a-z]", "");
		
		System.out.println("s2: "+s2);
		System.out.println("s3: "+s3);
	}
}
