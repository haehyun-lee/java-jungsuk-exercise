package ch4;

public class Exercise3_7 {

	public static void main(String[] args) {
		int fahrenheit = 100;
		float celcius = (int)(((float)5/9*(fahrenheit-32)*100)+0.5f)/100f;
		
		System.out.println("Fahrenheit : "+fahrenheit);
		System.out.println("Celcius : "+celcius);
	}
}
