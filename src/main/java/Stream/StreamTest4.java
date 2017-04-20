package Stream;

import java.util.UUID;
import java.util.stream.Stream;

/**
 * Created by yinhao on 2017/4/20.
 */
public class StreamTest4 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
        stream.findFirst().ifPresent(System.out::println);

        System.out.println("-----------------");

        //iterate 对第一个参数应用第二个参数函数，然后将返回值不断的应用第二个参数函数，产生无限流
        //limit 可以限制最多产生6个结果 输出 1 3 5 7 9 11
        Stream.iterate(1,item -> item + 2).limit(6).forEach(System.out::println);
    }
}
