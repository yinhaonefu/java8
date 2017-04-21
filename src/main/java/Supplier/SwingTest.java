package Supplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by yinhao on 2017/4/6.
 */
public class SwingTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }
}
