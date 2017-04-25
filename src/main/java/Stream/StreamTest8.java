package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yinhao on 17/4/24.
 */
public class StreamTest8 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello welcome", "world hello",
                "hello world hello", "hello welcome");

        //使用flatMap将每个数组中的元素放在一个平的map中统一去重
        List<String> collect = list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream)
                .distinct().collect(Collectors.toList());

        collect.forEach(System.out::println);
    }
}
