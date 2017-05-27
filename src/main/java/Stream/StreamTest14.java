package Stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yinhao on 17/5/26.
 */
public class StreamTest14 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world","helloworld");
        list.stream().map(item -> item + "_abc").filter(item -> item.length() > 5).
                forEach(System.out::println);
        System.out.println("--------------");
        list.forEach(System.out::println);
    }
}
