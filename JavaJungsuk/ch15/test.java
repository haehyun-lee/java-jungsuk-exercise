package ch15;

public class test {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "helloworld";

        System.out.println(str1.substring(0));
        System.out.println(str1.substring(1));
        System.out.println(str1.substring(2));
        System.out.println(str1.substring(str1.length()));
        System.out.println();

        // 뒤에서 3자리만 남기게 자르기
        System.out.println(str1.substring(str1.length() - 3));        // 5 - 3 = 2
        System.out.println(str2.substring(str2.length() - 3));        // 10 - 3 = 7

        // 뒤에서 4자리만 남기게 자르기
        System.out.println(str1.substring(str1.length() - 4));
        System.out.println(str2.substring(str2.length() - 4));
        
//        System.out.println(str1.substring(str1.length() - 7));
//        System.out.println(str2.substring(str2.length() - 7));

    }
}
