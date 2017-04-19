import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by yinhao on 17/4/11.
 */
public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
        System.out.println(functionTest.compute(3,v -> v * 2,v -> v * v));//18
        System.out.println(functionTest.compute2(3,v -> v * 2,v -> v * v));//36

        System.out.println(functionTest.compute3(1,2,(a,b) -> a + b));//3
        System.out.println(functionTest.compute3(5,2,(a,b) -> a - b));//3
        System.out.println(functionTest.compute3(2,2,(a,b) -> a * b));//4
        System.out.println(functionTest.compute3(10,2,(a,b) -> a / b));//5



        System.out.println(functionTest.compute4(10,2,(a,b) -> a / b,a -> a * a));//5
    }

    public int compute(int a, Function<Integer,Integer> function1,Function<Integer,Integer> function2){
        return function1.compose(function2).apply(a);
    }

    public int compute2(int a, Function<Integer,Integer> function1,Function<Integer,Integer> function2){
        return function1.andThen(function2).apply(a);
    }

    public int compute3(int a, int b, BiFunction<Integer,Integer,Integer> biFunction){
        return biFunction.apply(a,b);
    }

    public int compute4(int a, int b, BiFunction<Integer,Integer,Integer> biFunction,Function<Integer,Integer> function){
        return biFunction.andThen(function).apply(a,b);
    }
}
