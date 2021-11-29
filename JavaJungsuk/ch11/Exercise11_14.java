package ch11;

import java.util.ArrayList;
import java.util.Scanner;

// 성적처리 프로그램 (전체 등수, 반 등수 계산 앞에서 가져오기)
public class Exercise11_14 {
    static ArrayList record = new ArrayList();      // 성적 데이터
    static Scanner sc = new Scanner(System.in);     // 명령어 입력

    public static void main(String[] args) {
        while (true) {
            switch (displayMenu()) {
                case 1:
                    inputRecord();
                    break;
                case 2:
                    displayRecord();
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);

            }
        }
    }

    // 메뉴 표시
    static int displayMenu(){
        System.out.println("*************************************");
        System.out.println("*           성적 관리 프로그램         *");
        System.out.println("*************************************");
        System.out.println();
        System.out.println(" 1. 학생성적 입력하기 ");
        System.out.println();
        System.out.println(" 2. 학생성적 보기 ");
        System.out.println();
        System.out.println(" 3. 프로그램 종료");
        System.out.println();
        System.out.print("원하는 메뉴를 선택하세요. (1~3) : ");

        int menu = 0;

        do {
            try {
                menu = Integer.parseInt(sc.nextLine());                 //nextInt()로 받으면 해당 줄의 문자열("")이 남아있음

                if(1 <= menu && menu <= 3)
                    break;
                else
                    throw new Exception();
            } catch (Exception e) {
                System.out.println("메뉴를 잘못 선택하셨습니다. 다시 입력해주세요.");
                System.out.print("원하는 메뉴를 선택하세요. (1~3) : ");
            }
        } while (true);

        return menu;
    }

    // 데이터 입력
    static void inputRecord() {
        System.out.println("1. 학생성적 입력하기");
        System.out.println("이름, 반, 번호, 국어성적, 영어성적, 수학성적의 순서로 공백없이 입력하세요.");
        System.out.println("입력을 마치려면 q를 입력하세요. 메인화면으로 돌아갑니다.");

        while (true) {
            System.out.print(">>");

            String input = sc.nextLine();
            if (input.equalsIgnoreCase("q")) {
                return;
            }else{
                try {
                    String[] info = input.split(",");

                    Student student = new Student(info[0],
                            Integer.parseInt(info[1]),
                            Integer.parseInt(info[2]),
                            Integer.parseInt(info[3]),
                            Integer.parseInt(info[4]),
                            Integer.parseInt(info[5]));

                    record.add(student);

                    System.out.println("잘입력되었습니다. 입력을 마치려면 q를 입력하세요.");
                } catch (Exception e) {
                    System.out.println("입력오류입니다. 이름, 반, 번호, 국어성적, 영어성적, 수학성적의 순으로 입력하세요.");
                }
            }
        }
    }

    // 데이터 목록 표시
    static void displayRecord() {
        int koreanTotal = 0;
        int englishTotal = 0;
        int mathTotal = 0;
        int total = 0;

        int length = record.size();

        if (length > 0) {
            System.out.println();
            System.out.println("이름 반 번호 국어 영어 수학 총점 평균 전교등수 반등수");
            System.out.println("=============================================");

            for (int i = 0; i < length; i++) {
                Student student = (Student)record.get(i);
                System.out.println(student);
                koreanTotal += student.kor;
                englishTotal += student.eng;
                mathTotal += student.math;
                total += student.total;
            }

            System.out.println("=============================================");
            System.out.println("총점: " + koreanTotal + " " + englishTotal + " " + mathTotal + " " + total);
            System.out.println();
        }else{
            System.out.println("=============================================");
            System.out.println(" 데이터가 없습니다.");
            System.out.println("=============================================");
        }
    }
}

class Student implements Comparable{
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    int total;
    int schoolRank;
    int classRank;

    Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;

        this.total = kor + eng + math;
    }

    int getTotal(){
        return total;
    }

    float getAverage(){
        return Math.round((getTotal() / 3f) * 10) / 10f;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Student) {
            Student tmp = (Student)o;

            return tmp.total - this.total;
        }else{
            return -1;
        }
    }

    public String toString() {
        return name
                + ", " + ban
                + ", " + no
                + ", " + kor
                + ", " + eng
                + ", " + math
                + ", " + getTotal()
                + ", " + getAverage()
                + ", " + schoolRank
                + ", " + classRank
                ;
    }
}
