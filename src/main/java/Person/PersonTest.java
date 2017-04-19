package Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Created by yinhao on 17/4/11.
 */
public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person("zhangsan",20);
        Person person2 = new Person("lisi",30);
        Person person3 = new Person("wangwu",40);
        Person person4 = new Person("zhaoliu",50);

        List<Person> persons = Arrays.asList(person1,person2,person3,person4);


        PersonTest personTest = new PersonTest();
        personTest.getPersonsByUsername("zhangsan",persons).
                forEach(person -> System.out.println(person.getUsername()));

        System.out.println("------------------");

        personTest.getPersonByAge(30,persons).forEach(person ->
                System.out.println(person.getUsername()));

        System.out.println("------------------");


        personTest.getPersonByAge2(40, persons, (age, personList) -> {
            return personList.stream().filter(person -> person.getAge() > age).collect(Collectors.toList());
        }).forEach(person -> System.out.println(person.getUsername()));

        System.out.println("------------------");

        personTest.getPersonByAge2(40, persons, (age, personList) -> {
            return personList.stream().filter(person -> person.getAge() <= age).collect(Collectors.toList());
        }).forEach(person -> System.out.println(person.getUsername()));


    }

    public List<Person> getPersonsByUsername(String username,List<Person> persons){
        return persons.stream().filter(person -> person.getUsername().equals(username)).
                collect(Collectors.toList());
    }


    public List<Person> getPersonByAge(int age,List<Person> persons){

        BiFunction<Integer,List<Person>,List<Person>> biFuction = (ageOfPerson,personList) ->
                personList.stream().filter(person -> person.getAge() > ageOfPerson).
                    collect(Collectors.toList());

        return biFuction.apply(age,persons);

    }

    public List<Person> getPersonByAge2(int age,List<Person> persons,
                                        BiFunction<Integer,List<Person>,List<Person>> biFunction){
        return biFunction.apply(age,persons);
    }

}
