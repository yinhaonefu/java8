package MethodReference;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yinhao on 17/4/16.
 */
public class MethodReferenceTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world","helloworld");
        list.forEach(System.out::println);
    }
}
