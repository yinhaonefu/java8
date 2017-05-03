package Stream;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by yinhao on 2017/5/3.
 */
public class MySetCollector<T> implements Collector<T, Set<T>, Set<T>>{
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked!");
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked!");
        return Set<T>::add;
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked!");
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Set<T>> finisher() {
        System.out.println("finisher invoked!");
//        return set1 -> set1;
        return Function.identity();//不做类型转换，直接返回结果
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked!");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH,Characteristics.UNORDERED));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome");
        Set<String> collect = list.stream().collect(new MySetCollector<String>());
        System.out.println(collect);
//        分析stream().collect方法源代码了解日志输出顺序
//        supplier invoked!
//        accumulator invoked!
//        combiner invoked!
//        characteristics invoked!
//        characteristics invoked!
//        [world, hello, welcome]
    }
}
