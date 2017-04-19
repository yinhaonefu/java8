package Optional;

import java.util.Optional;

/**
 * Created by yinhao on 17/4/14.
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("hello");
//        if (optional.isPresent()){
//            System.out.println(optional.get());
//        }
        optional.ifPresent(a -> System.out.println(a));

        System.out.println("-----");

        Optional<String> optional1 = Optional.empty();
        optional1.ifPresent(a -> System.out.println(a));
        System.out.println(optional1.orElse("world"));
        System.out.println(optional1.orElseGet(() -> "zhangsan"));


    }
}
