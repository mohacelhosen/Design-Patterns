package singleton.test;

import singleton.impl.PerfectSingletonPrinter;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/* url class loader is independent class loader*/

public class BreakSingletonUsingUrlClassLoader {
    public static void main(String[] args) {
        try {
            // Object creation by application classloader
            System.out.println("-------------Using application class loader---------------");
            PerfectSingletonPrinter printer = PerfectSingletonPrinter.getInstance();
            System.out.println("Parent class loader:: "+printer.getClass().getClassLoader());

            System.out.println("-------------Using URLClassLoader (ready mate custom) class loader---------------");
            // creating a classloader using URLClassLoader
            // problem code
//            URLClassLoader customClassLoader = new URLClassLoader(new URL[]{new URL("file:/D:/Design Patterns/Singleton Design Pattern/out/artifacts/Singleton_Design_Pattern_jar/Singleton Design Pattern.jar")}, null); // null for no parent


            // solution code to provide parent class
            URLClassLoader customClassLoader = new URLClassLoader(new URL[]{new URL("file:/D:/Design Patterns/Singleton Design Pattern/out/artifacts/Singleton_Design_Pattern_jar/Singleton Design Pattern.jar")}, printer.getClass().getClassLoader());

            String className = "singleton.impl.PerfectSingletonPrinter";
            System.out.println("Attempting to load class: " + className);

            // Load the specific class
            Class<?> singletonClass = customClassLoader.loadClass(className);

            System.out.println("Class loaded successfully: " + singletonClass.getName());

            // Get access to getInstance() method to load class
            Method declaredMethod = singletonClass.getDeclaredMethod("getInstance", new Class[]{});

            // Invoke the method
            Object p1 = declaredMethod.invoke(null);

            System.out.println("Original:: " + printer.hashCode());
            System.out.println("P1:: " + p1.hashCode());




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
