package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yinhao on 17/4/25.
 *
 * 输出:
 * hi zhangsan
 * hi lisi
 * hi wangwu
 * hi zhaoliu
 * hello zhangsan
 * hello lisi
 * hello wangwu
 * hello zhaoliu
 * 你好 zhangsan
 * 你好 lisi
 * 你好 wangwu
 * 你好 zhaoliu
 *
 * 利用flagmap将两个集合中的组合结果打平(放在一个集合中)
 *
 */
public class StreamTest9 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("hi","hello","你好");
        List<String> list2 = Arrays.asList("zhangsan","lisi","wangwu","zhaoliu");

        List<String> collect = list1.stream().flatMap(item1 -> list2.stream().map(item2 -> item1 + " " + item2))
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }
}
