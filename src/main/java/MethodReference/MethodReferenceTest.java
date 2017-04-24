package MethodReference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by yinhao on 17/4/16.
 */
public class MethodReferenceTest {
    public String getString(Supplier<String> supplier){
        return supplier.get() + " test";
    }

    public String getString2(String str, Function<String,String> function){
        return function.apply(str);
    }

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan",90);
        Student student2 = new Student("lisi",93);
        Student student3 = new Student("wangwu",85);
        Student student4 = new Student("zhaoliu",99);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

//        students.sort(Student::compareStudentByScore);
//
//        students.forEach(student -> System.out.println(student.getScore()));
//
//        System.out.println("----------------------------");
//
//        StudentComparator studentComparator = new StudentComparator();
//
//        students.sort((s1, s2) -> studentComparator.compareStudentByScore(s1,s2));
//        students.forEach(student -> System.out.println(student.getScore()));

//        System.out.println("----------------------------");
//
//        students.sort(studentComparator::compareStudentByScore);
//        students.forEach(student -> System.out.println(student.getScore()));

//        System.out.println("----------------------------");
//
//        students.sort(studentComparator::compareStudentByName);
//        students.forEach(student -> System.out.println(student.getName()));
//
//        System.out.println("----------------------------");

        students.sort(Student::compareByScore);
        students.forEach(student -> System.out.println(student.getScore()));

        //构造方法引用
        MethodReferenceTest methodReferenceTest = new MethodReferenceTest();
        System.out.println(methodReferenceTest.getString(String::new));
        System.out.println(methodReferenceTest.getString2("hello",String::new));

    }
}
