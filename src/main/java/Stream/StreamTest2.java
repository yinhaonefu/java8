package Stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yinhao on 17/4/19.
 */
public class StreamTest2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        System.out.println(list.stream().map(integer -> integer * 2).reduce(Integer::sum));
    }
}
