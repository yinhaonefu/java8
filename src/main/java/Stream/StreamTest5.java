package Stream;

import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

/**
 * Created by yinhao on 2017/4/20.
 */
public class StreamTest5 {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,3,5,7,9,11);
        //找出大于2的元素，每个元素乘以2，忽略前两个元素后再取前两个元素求和
//        System.out.println(stream.filter(integer -> integer > 2).mapToInt(item -> item * 2).skip(2).limit(2).sum());

//        stream.filter(integer -> integer > 2).
//                mapToInt(item -> item * 2).skip(2).limit(2).min().ifPresent(System.out::println);

        IntSummaryStatistics intSummaryStatistics = stream.filter(integer -> integer > 2).
                mapToInt(item -> item * 2).skip(2).limit(2).summaryStatistics();
        System.out.println(intSummaryStatistics.getCount());
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getSum());


    }
}
