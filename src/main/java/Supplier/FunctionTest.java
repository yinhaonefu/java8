package Supplier;

import java.util.function.Function;

/**
 * Created by yinhao on 2017/4/11.
 */
public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
        System.out.println(functionTest.compute(1,value -> 2 * value));
        System.out.println(functionTest.compute(2,value -> 5 + value));
        System.out.println(functionTest.compute(3,value -> value * value));


        System.out.println(functionTest.convert(5,value -> String.valueOf(value)+"helloworld"));
    }


    public int compute(int a, Function<Integer,Integer> function){
        Integer apply = function.apply(a);
        return  apply;
    }

    public String convert(int a,Function<Integer,String> function){
        return function.apply(a);
    }
}
