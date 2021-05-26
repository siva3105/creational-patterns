package singleton;

public class SingletonEagerInitialization {
    private static final SingletonEagerInitialization singleton = new SingletonEagerInitialization();

    private SingletonEagerInitialization() {
    }

    public static SingletonEagerInitialization getInstance(){
        return singleton;
    }
}
