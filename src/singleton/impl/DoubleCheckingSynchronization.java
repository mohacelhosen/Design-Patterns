package singleton.impl;

import singleton.util.Common;

public class DoubleCheckingSynchronization extends Common {
    //The volatile keyword is used to prevent visibility issues between threads.
    private static volatile DoubleCheckingSynchronization printer;

    private DoubleCheckingSynchronization() {
        System.out.println("0 param constructor");
    }

    public static DoubleCheckingSynchronization getInstance() {
        System.out.println("Thread:: "+Thread.currentThread().getName()+", synchronized outer and outer 'if' 🤔");
        if (printer == null) {
            System.out.println("Thread:: "+Thread.currentThread().getName()+", synchronized outer but inner 'if' 😎, Time::"+System.currentTimeMillis());
            synchronized (DoubleCheckingSynchronization.class) { // "this" keyword is not allow for static variable that's why we use class level lock, only 1 thread can enter at a time
                System.out.println("Thread:: "+Thread.currentThread().getName()+", synchronized inner but outer 'if' 😋, Time::"+System.currentTimeMillis());

                // if u think multiple thread enter at a time but fact is that only 1 thread will execute the logic of if statement
                // Double-checking
                if (printer == null) {
                    System.out.println("Thread:: "+Thread.currentThread().getName()+", synchronized Inner and Inner if🎁, Time::"+System.currentTimeMillis());
                    printer = new DoubleCheckingSynchronization();
                }
            }
        }
        return printer;
    }
}
