package singleton.test;

import singleton.impl.EagerInitializationSingletonPrinter;

import java.lang.reflect.Constructor;

public class EagerInitializationSingletonPrinterBreak {
    public static void main(String[] args) {
        EagerInitializationSingletonPrinter p1 = EagerInitializationSingletonPrinter.getInstance();
        try {
            Constructor<EagerInitializationSingletonPrinter> printerConstructor = EagerInitializationSingletonPrinter.class.getDeclaredConstructor();
            printerConstructor.setAccessible(true);
            EagerInitializationSingletonPrinter p2 = printerConstructor.newInstance();
            EagerInitializationSingletonPrinter p3 = printerConstructor.newInstance();
            EagerInitializationSingletonPrinter p4 = printerConstructor.newInstance();

            System.out.println("p1 hashCode= " + p1.hashCode());
            System.out.println("p2 hashCode= " + p2.hashCode());
            System.out.println("p3 hashCode= " + p3.hashCode());
            System.out.println("p4 hashCode= " + p4.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
