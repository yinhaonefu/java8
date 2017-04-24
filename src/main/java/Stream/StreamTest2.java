package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by yinhao on 17/4/19.
 */
public class StreamTest2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        System.out.println(list.stream().map(integer -> integer * 2).reduce(Integer::sum));

        IntStream.of(new int[]{5,6,7}).forEach(System.out::println);
        System.out.println("-------");
        IntStream.range(3,8).forEach(System.out::println);
        System.out.println("-------");
        IntStream.rangeClosed(3,8).forEach(System.out::println);
    }
}
