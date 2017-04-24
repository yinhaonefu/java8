package Supplier;

import java.util.function.Function;

/**
 * Created by yinhao on 2017/4/11.
 */
public class FunctionTest2 {
    public static void main(String[] args) {
        FunctionTest2 functionTest2 = new FunctionTest2();
        System.out.println(functionTest2.compute(5,value -> value + 2,value1 -> value1 * value1));
        System.out.println(functionTest2.compute2(5,value -> value + 2,value1 -> value1 * value1));
    }


    public int compute(int value, Function<Integer,Integer> function1,Function<Integer,Integer> function2){
        return function1.compose(function2).apply(value);
    }

    public int compute2(int value, Function<Integer,Integer> function1,Function<Integer,Integer> function2){
        return function1.andThen(function2).apply(value);
    }

}
