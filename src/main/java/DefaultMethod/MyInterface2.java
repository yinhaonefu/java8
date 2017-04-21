package DefaultMethod;

/**
 * Created by yinhao on 2017/4/17.
 */
public interface MyInterface2 {
    default void myMethod(){
        System.out.println("MyInterface2");
    }
}
