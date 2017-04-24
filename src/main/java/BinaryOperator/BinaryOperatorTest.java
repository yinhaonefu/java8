package BinaryOperator;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * Created by yinhao on 2017/4/14.
 */
public class BinaryOperatorTest {

    public static void main(String[] args) {
        BinaryOperatorTest binaryOperatorTest = new BinaryOperatorTest();
        System.out.println(binaryOperatorTest.compute(1,2,(value1,value2) -> value1 + value2));
        System.out.println("------------------------");
        System.out.println(binaryOperatorTest.getShort("hello","welcome",(a,b) -> a.length() - b.length()));
        System.out.println("------------------------");
        System.out.println(binaryOperatorTest.getShort("hello","welcome",(a,b) -> a.charAt(0) - b.charAt(0)));
    }


    public int compute(int value1, int value2, BinaryOperator<Integer> binaryOperator){
        return binaryOperator.apply(value1,value2);
    }


    public String getShort(String a, String b, Comparator<String> comparator){
        return BinaryOperator.minBy(comparator).apply(a,b);
    }
}
