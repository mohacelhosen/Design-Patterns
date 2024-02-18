package singleton.test;

import singleton.impl.DoubleCheckingSynchronization;

public class DoubleCheckingSynchronizationTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->accessInstance());
        Thread t2 = new Thread(()->accessInstance());
        Thread t3 = new Thread(()->accessInstance());
        Thread t4 = new Thread(()->accessInstance());
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
    static void accessInstance(){
        DoubleCheckingSynchronization printer = DoubleCheckingSynchronization.getInstance();
        System.out.println("Thread:: "+Thread.currentThread().getName()+" object hashcode:: "+printer.hashCode());
    }
}
