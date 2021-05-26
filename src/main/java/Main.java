import builder.Device;
import builder.DeviceBuilder;
import factory.Os;
import factory.OsFactory;
import prototype.BookShop;
import singleton.BillPughSingleton;
import singleton.DoubleCheckedLocking;
import singleton.SingletonEagerInitialization;
import singleton.SingletonLazyInitialization;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
        // singleton example
        // early initialization
        SingletonEagerInitialization object = SingletonEagerInitialization.getInstance();
        SingletonEagerInitialization object1 = SingletonEagerInitialization.getInstance();
        boolean isEqual = object.hashCode() == object1.hashCode();
        System.out.println("is both objects are same while eager intialization : " + isEqual);
        // lazy Initialization
        SingletonLazyInitialization obj1 = SingletonLazyInitialization.getInstance();
        SingletonLazyInitialization obj2 = SingletonLazyInitialization.getInstance();
        boolean isEqualForLazyInitialization = object.hashCode() == object1.hashCode();
        System.out.println("is both objects are same while lazy initialization : " + isEqualForLazyInitialization);

        // to test breaking of lazy intialization singleton by threads comment above lazy intialization code (21 to 24)
        ExecutorService executorService = null;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                System.out.println("lazy initalization with threads");
                SingletonLazyInitialization obj1 = null;
                DoubleCheckedLocking obj2 = null;
                try {
                    obj1 = SingletonLazyInitialization.getInstance();
                    obj2 =DoubleCheckedLocking.getInstance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                BillPughSingleton obj = BillPughSingleton.getInstance();
            }
        });

        try{
            executorService = Executors.newFixedThreadPool(2);
            for ( int i=0 ; i<1000 ; i++)
                executorService.execute(t1);


        } catch (Exception e){
            System.out.println(e.getStackTrace());
        } finally {
            if (executorService != null)
                executorService.shutdown();
        }

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                SingletonLazyInitialization obj1 = null;
                DoubleCheckedLocking obj2 = null;
                try {
                    obj1 = SingletonLazyInitialization.getInstance();
                    obj2 = DoubleCheckedLocking.getInstance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                BillPughSingleton obj = BillPughSingleton.getInstance();
            }
        });
        t1.start();
        t2.start();

        //prototype Example
        BookShop bookShop = new BookShop();
        bookShop.loadBooks();
        bookShop.setName("tony");
        BookShop bookShop1 = (BookShop) bookShop.clone();
        bookShop.getBooks().remove(1);
        System.out.println(bookShop);
        bookShop1.setName("steven");
        System.out.println(bookShop1);

        //builder examples
        Device device = new DeviceBuilder().setBattery(4000).setOs("andriod").build();
        Device device1 = new DeviceBuilder().setOs("IOS").setRam(3).setBattery(4500).setScreenSize(5.7).build();
        System.out.println(device.toString());
        System.out.println(device1.toString());

        //factory example
        Os obj = OsFactory.getOsObject("open");
        obj.specs();
    }
}
