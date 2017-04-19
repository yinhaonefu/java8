package Predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by yinhao on 17/4/11.
 */
public class PredicateTest2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        PredicateTest2 predicateTest2 = new PredicateTest2();

        predicateTest2.conditionFilter(list,integer -> integer > 5);
        System.out.println("------------");
        predicateTest2.conditionFilter(list,integer -> integer < 4);
        System.out.println("------------");
        predicateTest2.conditionFilter(list,integer -> integer % 2 == 0);
        System.out.println("------------");
        predicateTest2.conditionFilter(list,integer -> true);
        System.out.println("------------");
        predicateTest2.conditionFilter2(list,integer -> integer > 5,integer1 -> integer1 % 2 == 0);
        System.out.println("------------");
        predicateTest2.conditionFilter3(list,integer -> integer > 5,integer1 -> integer1 % 2 == 0);
        System.out.println("------------");
        System.out.println(Predicate.isEqual("test").test("test"));
    }

    public void conditionFilter(List<Integer> list, Predicate<Integer> predicate){
        list.stream().filter(predicate).
                collect(Collectors.toList()).forEach(integer -> System.out.println(integer));
    }

    //two predicate : predicate1 and predicate2
    public void conditionFilter2(List<Integer> list,Predicate<Integer> predicate1,Predicate<Integer> predicate2){
        list.stream().filter(i -> predicate1.and(predicate2).test(i)).
                collect(Collectors.toList()).forEach( integer -> System.out.println(integer));
    }

    //two predicate : negate (predicate1 and predicate2)
    public void conditionFilter3(List<Integer> list,Predicate<Integer> predicate1,Predicate<Integer> predicate2){
        list.stream().filter(predicate1.and(predicate2).negate()).
                collect(Collectors.toList()).forEach( integer -> System.out.println(integer));
    }


}
