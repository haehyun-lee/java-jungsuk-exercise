package ch09;

public class Exercise9_3 {

	public static void main(String[] args) {
		String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
		String path = "";
		String fileName = "";
		
		int index = fullPath.lastIndexOf("\\");		//구분자의 인덱스 반환
		path = fullPath.substring(0, index);		//처음~구분자 이전
		fileName = fullPath.substring(index+1);		//구분자 이후
		
		System.out.println("fullPath:"+fullPath);
		System.out.println("path:"+path);
		System.out.println("fileName:"+fileName);
	}
}
