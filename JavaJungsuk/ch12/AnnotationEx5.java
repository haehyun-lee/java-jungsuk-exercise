package ch12;

import java.lang.annotation.*;

@Deprecated
@SuppressWarnings("1111")
@TestInfo(testedBy = "aaa", testDate = @DateTime(yyyymmdd = "211210", hhmmss = "204750"))
class AnnotationEx5 {
    public static void main(String[] args) {
        Class<AnnotationEx5> cls = AnnotationEx5.class;     // AnnotationEx의 Class 객체

        TestInfo anno = (TestInfo) cls.getAnnotation(TestInfo.class);       // TestInfo Annotation 객체
        System.out.println("anno.testedBy()=" + anno.testedBy());
        System.out.println("anno.testDate().yyyymmdd()=" + anno.testDate().yyyymmdd());
        System.out.println("anno.testDate().hhmmss()=" + anno.testDate().hhmmss());

        for (String str : anno.testTools()) {
            System.out.println("testTools=" + str);
        }
        System.out.println();

        // AnnotationEx5에 적용된 모든 Annotation 반환
        Annotation[] annoArr = cls.getAnnotations();

        for (Annotation a : annoArr) {
            System.out.println(a);
        }
    }
}

// 사용자 정의 Annotation : 정보 전달용
@Retention(RetentionPolicy.RUNTIME)                 // Annotation 유지기간 (실행 시에도 사용 가능)
@interface TestInfo{
    int count() default 1;                          // int
    String testedBy();                              // String
    String[] testTools() default "Junit";           // Array
    TestType testType() default TestType.FIRST;     // Enum
    DateTime testDate();                            // Annotation
}

@Retention(RetentionPolicy.RUNTIME)
@interface DateTime{
    String yyyymmdd();
    String hhmmss();
}

enum TestType { FIRST, FINAL }
