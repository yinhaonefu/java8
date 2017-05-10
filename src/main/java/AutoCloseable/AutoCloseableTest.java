package AutoCloseable;

/**
 * Created by yinhao on 2017/5/10.
 * 自动调用close方法用于释放资源
 * 先声明的后关闭
 * close方法一定会被调用，即使代码执行时抛出异常
 */
public class AutoCloseableTest implements AutoCloseable{

    private String name;

    public AutoCloseableTest(String name) {
        this.name = name;
    }

    public void doSomething(){
        System.out.println(name + " doSomething invoked!");
    }

    @Override
    public void close() throws Exception {
        System.out.println(this.name + " close invoked!");
    }

    public static void main(String[] args) throws Exception{

        try (AutoCloseableTest autoCloseableTest = new AutoCloseableTest("autoCloseableTest");
             AutoCloseableTest autoCloseableTest2 = new AutoCloseableTest("autoCloseableTest2")){
            autoCloseableTest.doSomething();
            if(true){
                throw new NullPointerException();
            }
            autoCloseableTest2.doSomething();
        }

//        autoCloseableTest doSomething invoked!
//        autoCloseableTest2 close invoked!
//        autoCloseableTest close invoked!
//        Exception in thread "main" java.lang.NullPointerException
//        at AutoCloseable.AutoCloseableTest.main(AutoCloseableTest.java:32)

    }
}
