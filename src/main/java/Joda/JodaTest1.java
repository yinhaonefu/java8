package Joda;

import org.joda.primitives.list.IntList;
import org.joda.primitives.list.impl.ArrayIntList;

/**
 * Created by yinhao on 17/5/27.
 * joda.primitives 支持原生数据类型的集合操作
 */
public class JodaTest1 {
    public static void main(String[] args) {
        IntList intList = new ArrayIntList();

        intList.add(1);
        intList.add(2);

        intList.forEach(System.out::println);
    }
}
