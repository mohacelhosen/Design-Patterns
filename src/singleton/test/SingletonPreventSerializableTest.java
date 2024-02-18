package singleton.test;

import singleton.impl.SingletonPreventSerializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SingletonPreventSerializableTest {
    public static void main(String[] args) {

        SingletonPreventSerializable p1 = SingletonPreventSerializable.getInstance();

        // Serialize the Singleton object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singletonSerializable.txt"))) {
            oos.writeObject(p1);
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Deserialize the Singleton object
        SingletonPreventSerializable p2 = null;
        SingletonPreventSerializable p3 = null;
        SingletonPreventSerializable p4 = null;


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singletonSerializable.txt"))) {
            p2 = (SingletonPreventSerializable) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singletonSerializable.txt"))) {
            p3 = (SingletonPreventSerializable) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singletonSerializable.txt"))) {
            p4 = (SingletonPreventSerializable) ois.readObject();
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
