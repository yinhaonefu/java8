package Comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yinhao on 17/5/2.
 */
public class ComparatorTest2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world","welcome","nihao");

        list.sort(Comparator.comparingInt(String::length).reversed().
                thenComparing(Comparator.comparing(String::toLowerCase,
                        Comparator.reverseOrder())));

        System.out.println(list);
    }
}
