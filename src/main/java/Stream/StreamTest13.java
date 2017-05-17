package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by yinhao on 2017/5/17.
 * onClose函数接收Runnable类型的函数式接口类型，用于实现释放资源操作
 */
public class StreamTest13 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello","world","helloworld");

        NullPointerException nullPointerException = new NullPointerException();

        try (Stream<String> stream = list.stream()){
            stream.onClose(() -> {
                System.out.println("aaa");
                throw nullPointerException;
            }).onClose(() -> {
                System.out.println("bbb");
//                throw nullPointerException;//如果与第一个异常相同，则不会压制自己
                throw new ArithmeticException();//第二个抛出的不同异常会被压制
            }).forEach(System.out::println);
        }
    }
}
