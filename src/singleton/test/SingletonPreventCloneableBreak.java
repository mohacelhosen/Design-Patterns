package singleton.test;

import singleton.impl.SingletonPreventCloneable;

import java.io.*;

public class SingletonPreventCloneableBreak {
    public static void main(String[] args) {

        SingletonPreventCloneable p1 = SingletonPreventCloneable.getInstance();

        // Serialize the Singleton object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.txt"))) {
            oos.writeObject(p1);
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Deserialize the Singleton object
        SingletonPreventCloneable p2 = null;
        SingletonPreventCloneable p3 = null;
        SingletonPreventCloneable p4 = null;


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.txt"))) {
            p2 = (SingletonPreventCloneable) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.txt"))) {
            p3 = (SingletonPreventCloneable) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.txt"))) {
            p4 = (SingletonPreventCloneable) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Print the hash codes to check if it's the same instance or not
        System.out.println("p1(original) hashCode= " + p1.hashCode());
        System.out.println("p2 hashCode= " + p2.hashCode());
        System.out.println("p3 hashCode= " + p3.hashCode());
        System.out.println("p4 hashCode= " + p4.hashCode());


    }
}
