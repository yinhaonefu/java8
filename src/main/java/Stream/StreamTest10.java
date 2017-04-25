package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by yinhao on 17/4/25.
 *
 * 按名字分组
 *
 * {lisi=[Stream.Student@12edcd21],
 * zhangsan=[Stream.Student@34c45dca, Stream.Student@52cc8049],
 * wangwu=[Stream.Student@5b6f7412]}
 *
 * zhangsan  存在两个元素
 *
 *
 */
public class StreamTest10 {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 30, 98);
        Student student2 = new Student("lisi", 25, 90);
        Student student3 = new Student("wangwu", 35, 85);
        Student student4 = new Student("zhangsan", 40, 80);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);


//        Map<String, List<Student>> collect = students.stream().
//                collect(Collectors.groupingBy(student -> student.getName()));
//        System.out.println(collect);


        //按名字分组后统计数量
//        Map<String, Long> collect1 = students.stream().collect(
//                Collectors.groupingBy(Student::getName, Collectors.counting()));
//        System.out.println(collect1);//{lisi=1, zhangsan=2, wangwu=1}


        //按名字分组后,求平均值
//        Map<String, Double> collect = students.stream().
//                collect(Collectors.groupingBy(Student::getName,
//                Collectors.averagingDouble(Student::getScore)));
//
//        System.out.println(collect);//{lisi=90.0, zhangsan=89.0, wangwu=85.0}

        //分区 分区只能分成两组,满足表达式的为true不满足为false.
        //collect.get(true)取出满足表达式的分区中的数据
        Map<Boolean, List<Student>> collect = students.stream().collect(
                Collectors.partitioningBy(student -> student.getAge() >= 30));
        System.out.println(collect.get(true));
    }
}
