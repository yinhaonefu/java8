package Stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yinhao on 17/4/24.
 */
public class StreamTest7 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world","helloworld");

        list.stream().mapToInt(item -> item.length()).filter(length -> length == 5)
                .findFirst().ifPresent(System.out::println);

        list.stream().mapToInt(item -> {
            int length = item.length();
            System.out.println(item);//只输出了第一个长度为5的字符串,没有全部遍历
            return length;
        }).filter(length -> length == 5).
                findFirst().ifPresent(System.out::println);
    }
}
