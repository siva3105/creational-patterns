package singleton;

public class SingletonLazyInitialization {

    private static SingletonLazyInitialization singletonLazyInitialization;

    private SingletonLazyInitialization() {
        System.out.println("instance created by lazy initialization");
    }

    public static SingletonLazyInitialization getInstance() throws InterruptedException {
        if (singletonLazyInitialization == null) {
            // we will get same hash code while using threads because we are just creating a object which will not take much time
            // so im adding sleep because in real time example we have lots of code execute by application after object creation
            Thread.sleep(2000);
            singletonLazyInitialization = new SingletonLazyInitialization();
        }
        return singletonLazyInitialization;
    }
}
