package Comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yinhao on 2017/5/2.
 */
public class ComparatorTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world","welcome","nihao");

        //按字符串长度降序排列 使用方法引用方式
//        Collections.sort(list, Comparator.comparingInt(String::length).reversed());
//
//        System.out.println(list);

        //使用lambda表达式 按长度倒序 增加了reversed操作，编译器不确定中间参数的类型，需要显示指定String类型
//        Collections.sort(list, Comparator.comparingInt((String item) -> item.length()).reversed());
//
//        System.out.println(list);

//        list.sort(Comparator.comparingInt(String::length).reversed());
//
//        System.out.println(list);

        //先按长度升序，再忽略大小写按字母排序
//        Collections.sort(list, Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));
//
//        System.out.println(list);

        //同上
        Collections.sort(list, Comparator.comparingInt(String::length).
                thenComparing((item1, item2) -> item1.toLowerCase().compareTo(item2.toLowerCase())));

        System.out.println(list);
    }
}
