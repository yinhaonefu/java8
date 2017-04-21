package DefaultMethod;

/**
 * Created by yinhao on 2017/4/17.
 */
public class MyClass implements MyInterface1,MyInterface2{

    @Override
    public void myMethod() {
        MyInterface2.super.myMethod();//指定使用MyInterface2中的实现
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myMethod();
    }
}
