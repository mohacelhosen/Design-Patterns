package singleton.test;

import singleton.impl.SingletonPreventCloneable;

public class SingletonPreventCloneableTest {
    public static void main(String[] args) {
        SingletonPreventCloneable p1 = SingletonPreventCloneable.getInstance();
        try{
            SingletonPreventCloneable p2 = (SingletonPreventCloneable) p1.clone();
            SingletonPreventCloneable p3 = (SingletonPreventCloneable) p1.clone();
            SingletonPreventCloneable p4 = (SingletonPreventCloneable) p1.clone();

            System.out.println("p1 hashCode= " + p1.hashCode());
            System.out.println("p2 hashCode= " + p2.hashCode());
            System.out.println("p3 hashCode= " + p3.hashCode());
            System.out.println("p4 hashCode= " + p4.hashCode());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
