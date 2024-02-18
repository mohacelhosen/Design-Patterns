package singleton.impl;

public class EagerInitializationSingletonPrinter {
    // generally safe because the instance of the singleton is created eagerly during the class loading,
    // and the static field printer is initialized only once.
    private static EagerInitializationSingletonPrinter printer = new EagerInitializationSingletonPrinter();

    private EagerInitializationSingletonPrinter(){
        System.out.println("0 param constructor");
    }

    public static EagerInitializationSingletonPrinter getInstance(){
        return printer;
    }
}
