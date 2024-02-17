package singleton;

import java.lang.reflect.Constructor;

public class SingletonTest {
    public static void main(String[] args) {
        SingletonPrinter p1 = SingletonPrinter.getInstance();
        SingletonPrinter p2 = SingletonPrinter.getInstance();

        System.out.println("p1= " + p1.hashCode() + "\n" + "p2= " + p2.hashCode());


        // Breaking the singleton pattern using Reflection.(Reflection can break encapsulation)
        // Reflection in Java is a powerful and flexible feature that allows you to inspect
        // and manipulate classes, methods, fields, and other elements of the program dynamically at runtime.
        try {
            Constructor<SingletonPrinter> printerConstructor = SingletonPrinter.class.getDeclaredConstructor();
            printerConstructor.setAccessible(true);
            SingletonPrinter newPrinter = printerConstructor.newInstance();
            System.out.println("p3= "+newPrinter.hashCode());

        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
