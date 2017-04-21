package Supplier;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * Created by yinhao on 2017/4/11.
 */
public class Test1 {
    public static void main(String[] args) {
        //方法引用
        Function<String,String> function = String::toUpperCase;
        String apply = function.apply("hello world");
        System.out.println(apply);

        List<String> names = Arrays.asList("zhangsan","lisi","wangwu","zhaoliu");
//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });
//        System.out.println(names);


        Collections.sort(names, (o1, o2) -> o2.compareTo(o1));

        System.out.println(names);
    }

}
