package singleton;

public class DoubleCheckedLocking {

    private static DoubleCheckedLocking doubleCheckedLocking;

    private DoubleCheckedLocking() {
        System.out.println("instance created by lazy initialization after double check");
    }

    public static DoubleCheckedLocking getInstance() throws InterruptedException {
        if (doubleCheckedLocking == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (doubleCheckedLocking == null) {
                    // we will get same hash code while using threads because we are just creating a object which will not take much time
                    // so im adding sleep because in real time example we have lots of code execute by application after object creation
                    Thread.sleep(2000);
                    doubleCheckedLocking = new DoubleCheckedLocking();
                }
            }

        }
        return doubleCheckedLocking;
    }
}
