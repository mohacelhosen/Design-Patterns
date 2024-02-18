package singleton.test;

import singleton.impl.PerfectSingletonPrinter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.concurrent.atomic.AtomicReference;

public class PerfectSingletonPrinterTest {
    public static void main(String[] args) {
        // normal test
        PerfectSingletonPrinter p1 = PerfectSingletonPrinter.getInstance();
        PerfectSingletonPrinter p2 = PerfectSingletonPrinter.getInstance();
        PerfectSingletonPrinter p3 = PerfectSingletonPrinter.getInstance();
        System.out.println("p1 hashCode= " + p1.hashCode());
        System.out.println("p2 hashCode= " + p2.hashCode());
        System.out.println("p3 hashCode= " + p3.hashCode());
        if (p1.hashCode()==p2.hashCode() && p1.hashCode()==p3.hashCode()){
            System.out.println("test 1:: ✅");
        }else{
            System.out.println("test 1:: ❌");
        }



        // multithreading test
        Thread t1 = new Thread(PerfectSingletonPrinterTest::accessInstance);
        Thread t2 = new Thread(PerfectSingletonPrinterTest::accessInstance);
        Thread t3 = new Thread(PerfectSingletonPrinterTest::accessInstance);

        t1.start();
        t2.start();
        t3.start();



        // cloneable test
        PerfectSingletonPrinter p4 = PerfectSingletonPrinter.getInstance();
        try{
            PerfectSingletonPrinter p5 = (PerfectSingletonPrinter)p4.clone();
            PerfectSingletonPrinter p6 = (PerfectSingletonPrinter)p4.clone();

            System.out.println("p4 hashCode= " + p4.hashCode());
            System.out.println("p5 hashCode= " + p5.hashCode());
            System.out.println("p6 hashCode= " + p6.hashCode());
            if (p4.hashCode()==p5.hashCode() && p4.hashCode()==p6.hashCode()){
                System.out.println("test 3:: ✅, cloneable return old object reference");
            }else{
                System.out.println("test 3:: ❌");
            }

        }catch (Exception e){
            e.printStackTrace();
        }



        // serializable test
        //serialize the object
        PerfectSingletonPrinter p7 = PerfectSingletonPrinter.getInstance();
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("printer.ser"))){
            oos.writeObject(p7);
            oos.flush();
        }catch (Exception e){
            e.printStackTrace();
        }


        //de-serialize the object
        PerfectSingletonPrinter p8=null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("printer.ser"))){
             p8 =(PerfectSingletonPrinter)ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }

        PerfectSingletonPrinter p9=null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("printer.ser"))){
            p9 =(PerfectSingletonPrinter)ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("p7 hashCode= " + p7.hashCode());
        System.out.println("p8 hashCode= " + p8.hashCode());
        System.out.println("p9 hashCode= " + p9.hashCode());
        if (p7.hashCode()==p8.hashCode() && p7.hashCode()==p9.hashCode()){
            System.out.println("test 4:: ✅, Serializable return old object reference");
        }else{
            System.out.println("test 4:: ❌");
        }



        // Reflection API TEST

        try{
            Constructor<PerfectSingletonPrinter> perfectSingletonConstructor = PerfectSingletonPrinter.class.getDeclaredConstructor();
            perfectSingletonConstructor.setAccessible(true);
            PerfectSingletonPrinter p11 = perfectSingletonConstructor.newInstance();
            System.out.println("test 5:: ❌ hascode:: "+p11.hashCode());
        }catch (Exception e){
            System.out.println("test 5:: ✅, Reflection api not allow to create new object");
        }



    }

    public static void accessInstance(){
        PerfectSingletonPrinter printer = PerfectSingletonPrinter.getInstance();
        System.out.println("Thread:: "+Thread.currentThread().getName()+", object hashcode:: "+printer.hashCode());
    }
}
