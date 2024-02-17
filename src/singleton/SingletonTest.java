package singleton;

import java.lang.reflect.Constructor;

public class SingletonTest {
    public static void main(String[] args) {
        // Create multiple threads to access singleton concurrently
        Thread thread1 = new Thread(() -> accessSingleton());
        Thread thread2 = new Thread(() -> accessSingleton());
        Thread thread3 = new Thread(() -> accessSingleton());
        Thread thread4 = new Thread(() -> accessSingleton());

        thread1.start();
        thread2.start();
        try{
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
        thread3.start();
        thread4.start();

        SingletonPrinter p1 = SingletonPrinter.getInstance();
        SingletonPrinter p2 = SingletonPrinter.getInstance();

        System.out.println("Thread " + Thread.currentThread().getId() + ": p1 hashCode= " + p1.hashCode());
        System.out.println("Thread " + Thread.currentThread().getId() + ": p2 hashCode= " + p2.hashCode());


        System.out.println("p1= " + p1.hashCode() + "\n" + "p2= " + p2.hashCode());


        // Breaking the singleton pattern using Reflection.(Reflection can break encapsulation)
        // Reflection in Java is a powerful and flexible feature that allows you to inspect
        // and manipulate classes, methods, fields, and other elements of the program dynamically at runtime.
        try {
            Constructor<SingletonPrinter> printerConstructor = SingletonPrinter.class.getDeclaredConstructor();
            printerConstructor.setAccessible(true);
            SingletonPrinter newPrinter = printerConstructor.newInstance();
            System.out.println("p3= " + newPrinter.hashCode());


        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void accessSingleton() {
        SingletonPrinter p4 = SingletonPrinter.getInstance();
        System.out.println("Thread " + Thread.currentThread().getId() + ": p4 hashCode= " + p4.hashCode());
    }
}
