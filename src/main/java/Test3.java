import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yinhao on 17/4/6.
 */
public class Test3 {
    public static void main(String[] args) {
//        TheInterface theInterface = () -> {};
//        System.out.println(theInterface.getClass().getInterfaces()[0]);
//        TheInterface2 theInterface2 = () -> {};
//        System.out.println(theInterface2.getClass().getInterfaces()[0]);
//
//        new Thread(() -> {
//            System.out.println("hello world");
//        }).start();

        List<String> list = Arrays.asList("hello","world","helloworld");

//        list.forEach(s -> System.out.println(s.toUpperCase()));
//
//        List<String> list1 = new ArrayList<>();
//        list.forEach(s -> list1.add(s.toUpperCase()));
//        list1.forEach(s -> System.out.println(s));

        //lambda表达式
        list.stream().map(item -> item.toUpperCase()).forEach(item -> System.out.println(item));
        //方法引用
        list.stream().map(String::toUpperCase).forEach(item -> System.out.println(item));

    }

}

@FunctionalInterface
interface TheInterface{
    void myMethod();
}

@FunctionalInterface
interface TheInterface2{
    void myMethod2();
}