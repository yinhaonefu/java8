package Stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yinhao on 17/4/18.
 */
public class StreamTest {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello","world","helloworld");
//        String[] stringArray = stream.toArray(value -> new String[value]);
//        String[] stringArray = stream.toArray(String[]::new);
//        Arrays.asList(stringArray).forEach(s -> System.out.println(s));

//        List<String> list = stream.collect(Collectors.toList());
//        List<String> list = stream.collect(() -> new ArrayList<String>(),
//                (tempList,str) -> tempList.add(str),
//                (tempList,resultList) -> resultList.addAll(tempList));

//        List<String> list = stream.collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
//        list.forEach(System.out::println);

//        List<String> list = stream.collect(Collectors.toCollection(ArrayList::new));
//        list.forEach(System.out::println);

        System.out.println(stream.collect(Collectors.joining()));

    }
}
