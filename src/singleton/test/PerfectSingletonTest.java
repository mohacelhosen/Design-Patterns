package singleton.test;

import singleton.impl.PerfectSingleton;
import singleton.impl.SingletonPreventCloneable;
import singleton.impl.SingletonPreventSerializable;

import java.lang.reflect.Constructor;

public class PerfectSingletonTest {
    public static void main(String[] args) {
        PerfectSingleton p1 = PerfectSingleton.getInstance();


        PerfectSingleton p2 = null;
        PerfectSingleton p3 = null;
        PerfectSingleton p4 = null;
        try{
            Constructor<PerfectSingleton> perfectSingletonConstructor = PerfectSingleton.class.getDeclaredConstructor();
            perfectSingletonConstructor.setAccessible(true);
             p2 = perfectSingletonConstructor.newInstance();
             p3 = perfectSingletonConstructor.newInstance();
             p4 = perfectSingletonConstructor.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("p1(original) hashCode= " + p1.hashCode());
        System.out.println("p2 hashCode= " + p2.hashCode());
        System.out.println("p3 hashCode= " + p3.hashCode());
        System.out.println("p4 hashCode= " + p4.hashCode());
    }
}
