package Stream;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by yinhao on 2017/5/4.
 */
public class MySetCollector2<T> implements Collector<T, Set<T>, Map<T, T>> {
    /**
     *     A a1 = supplier.get();
     *     accumulator.accept(a1, t1);
     *     accumulator.accept(a1, t2);
     *     R r1 = finisher.apply(a1);  // result without splitting
     *
     *     A a2 = supplier.get();
     *     accumulator.accept(a2, t1);
     *     A a3 = supplier.get();
     *     accumulator.accept(a3, t2);
     *     R r2 = finisher.apply(combiner.apply(a2, a3));  // result with splitting
     * @return
     */
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked!");
        //如果是串行流，只会调用一次
        //如果是并行流：
        // 没有添加Characteristics.CONCURRENT特性，会调用多次
        // 添加了Characteristics.CONCURRENT特性，调用一次
        return HashSet<T>::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked!");
        return (set, item) -> {
            set.add(item);
            //parallelStream如果添加Characteristics.CONCURRENT特性，不要在程序中输出集合内容
            //因为添加了Characteristics.CONCURRENT特性，多个线程会同时操作一个结果容器，当有线程遍历结果容器时，其他线程
            //对结果容器进行操作就会抛出java.util.ConcurrentModificationException
            System.out.println("accumulator " + set + "," + Thread.currentThread().getName());
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked!");
        return (set1, set2) -> {
            //并行流时，没有添加Characteristics.CONCURRENT会调用
            //因为并行流添加Characteristics.CONCURRENT只会有一个中间结果容器，不需要合并操作
            set1.addAll(set2);
            System.out.println("combiner " + Thread.currentThread().getName());
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher invoked!");
        return set -> {
            HashMap<T, T> map = new HashMap<>();
            set.stream().forEach(item -> map.put(item, item));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked!");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED,Characteristics.CONCURRENT));
    }

    public static void main(String[] args) {
        //超线程技术得到的可用核数
        System.out.println(Runtime.getRuntime().availableProcessors());

        List<String> list = Arrays.asList("hello","world","helloworld","welcome","a","b","c","d","e","f","g");
        Set<String> set = new HashSet<>();
        set.addAll(list);
        System.out.println("set:" + set);

        Map<String, String> collect = set.parallelStream().collect(new MySetCollector2<>());
        System.out.println(collect);
    }
}
