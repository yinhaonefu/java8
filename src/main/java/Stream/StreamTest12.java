package Stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
public class StreamTest12 {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 30, 98);
        Student student2 = new Student("lisi", 25, 90);
        Student student3 = new Student("wangwu", 35, 85);
        Student student4 = new Student("zhangsan", 40, 85);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        //求最小分数
        Optional<Student> collect = students.stream().
                collect(Collectors.minBy(Comparator.comparingInt(Student::getScore)));

        collect.ifPresent(student -> System.out.println(student.getScore()));//85

        System.out.println("----------");

        //求概要信息 count sum min max average
        IntSummaryStatistics intSummaryStatistics = students.
                stream().collect(Collectors.summarizingInt(Student::getScore));
        System.out.println(intSummaryStatistics);
        //IntSummaryStatistics{count=4, sum=358, min=85, average=89.500000, max=98}


        System.out.println("----------");

        //连接
        String collect1 = students.stream().
                map(Student::getName).collect(Collectors.joining(", "));
        String collect2 = students.stream().
                map(Student::getName).collect(Collectors.joining(", ", "<begin> ", " <end>"));
        System.out.println(collect1);
        System.out.println(collect2);
        //zhangsan, lisi, wangwu, zhangsan
        //<begin> zhangsan, lisi, wangwu, zhangsan <end>


        System.out.println("----------");


        //二次分组
        Map<Integer, Map<String, List<Student>>> collect3 = students.stream().
                collect(Collectors.groupingBy(Student::getScore, Collectors.groupingBy(Student::getName)));
        System.out.println(collect3);
        //{98={zhangsan=[Student{name = zhangsan, score = 98}]}, 85={zhangsan=[Student{name = zhangsan, score = 85}], wangwu=[Student{name = wangwu, score = 85}]}, 90={lisi=[Student{name = lisi, score = 90}]}}


        System.out.println("----------");

        //分区
        Map<Boolean, List<Student>> collect4 = students.stream().
                collect(Collectors.partitioningBy(student -> student.getScore() > 90));
        System.out.println(collect4.get(true));
        //[Student{name = zhangsan, score = 98}]

        System.out.println("----------");

        //二次分区
        Map<Boolean, Map<Boolean, List<Student>>> collect5 = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() > 90, Collectors.partitioningBy(student5 -> student5.getScore() > 85)));
        System.out.println(collect5);
        //{false={false=[Student{name = wangwu, score = 85}, Student{name = zhangsan, score = 85}], true=[Student{name = lisi, score = 90}]}, true={false=[], true=[Student{name = zhangsan, score = 98}]}}


        System.out.println("----------");

        //分区求数量
        Map<Boolean, Long> collect6 = students.stream().
                collect(Collectors.partitioningBy(student -> student.getScore() > 90, Collectors.counting()));
        System.out.println(collect6);
        //{false=3, true=1}

        System.out.println("----------");

    }

}
