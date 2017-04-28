package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

/**
 * Created by yinhao on 2017/4/27.
 */
public class StreamTest11 {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 80);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 100);
        Student student4 = new Student("zhaoliu", 90);

        List<Student> students = Arrays.asList(student1,student2,student3,student4);

        List<Student> collect = students.stream().collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println(students.stream().collect(counting()));
        System.out.println(students.stream().count());
    }
}
