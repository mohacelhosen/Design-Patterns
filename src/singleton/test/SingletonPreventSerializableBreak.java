package singleton.test;

import singleton.impl.SingletonPreventCloneable;
import singleton.impl.SingletonPreventSerializable;

import java.lang.reflect.Constructor;

public class SingletonPreventSerializableBreak {
    public static void main(String[] args) {
        SingletonPreventSerializable p1 = SingletonPreventSerializable.getInstance();


        SingletonPreventCloneable p2 = null;
        SingletonPreventCloneable p3 = null;
        SingletonPreventCloneable p4 = null;
        try{
            Constructor<SingletonPreventCloneable> preventCloneableConstructor = SingletonPreventCloneable.class.getDeclaredConstructor();
            preventCloneableConstructor.setAccessible(true);
             p2 = preventCloneableConstructor.newInstance();
             p3 = preventCloneableConstructor.newInstance();
             p4 = preventCloneableConstructor.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("p1(original) hashCode= " + p1.hashCode());
        System.out.println("p2 hashCode= " + p2.hashCode());
        System.out.println("p3 hashCode= " + p3.hashCode());
        System.out.println("p4 hashCode= " + p4.hashCode());
    }
}
