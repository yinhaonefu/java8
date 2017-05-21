package Consumer;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * Created by yinhao on 17/5/21.
 */
public class ConsumerTest {

    public void test(Consumer<Integer> consumer){
        System.out.println(consumer.getClass().getName());
        consumer.accept(100);
    }

    public static void main(String[] args) {
        ConsumerTest consumerTest = new ConsumerTest();

        Consumer<Integer> consumer = i -> System.out.println(i);
        IntConsumer intConsumer = i -> System.out.println(i);

        consumerTest.test(consumer);//面向对象方式
//        consumerTest.test(intConsumer); //面向对象方式，只能接收Consumer类型对象

        consumerTest.test(consumer::accept);//函数式方式 只要函数的定义满足就可以
        consumerTest.test(intConsumer::accept);//函数式方式 只要函数的定义满足就可以

        System.out.println(intConsumer instanceof IntConsumer);

        intConsumer.accept(200);
    }
}
