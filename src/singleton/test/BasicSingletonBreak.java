package singleton.test;

import singleton.impl.BasicSingletonPrinter;

public class BasicSingletonBreak {
    public static void main(String[] args) {
        try{
            Thread thread1 = new Thread(() -> accessSingleton());
            Thread thread2 = new Thread(() -> accessSingleton());
            Thread thread3 = new Thread(() -> accessSingleton());
            Thread thread4 = new Thread(() -> accessSingleton());
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void accessSingleton(){
        BasicSingletonPrinter printer = BasicSingletonPrinter.getInstance();
        System.out.println("Thread:: "+Thread.currentThread().getName()+"  object hashcode:: "+printer.hashCode());
    }
}
