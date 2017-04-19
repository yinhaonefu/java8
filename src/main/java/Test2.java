/**
 * Created by yinhao on 17/4/6.
 */

interface MyInterface2{
    void test();
    String toString();
}


public class Test2 {

    public void myTest(MyInterface2 myInterface2){
        System.out.println(1);
        myInterface2.test();
        System.out.println(2);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.myTest(new MyInterface2() {
            @Override
            public void test() {
                System.out.println("mytest");
            }
        });
        System.out.println("------------");
        test2.myTest(() -> {
            System.out.println("mytest lambda");
        });

        MyInterface2 myInterface2 = () -> {
            System.out.println("hello");
        };

        System.out.println(myInterface2.getClass());
        System.out.println(myInterface2.getClass().getSuperclass());
        System.out.println(myInterface2.getClass().getInterfaces());
    }
}
