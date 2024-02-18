
package singleton.impl;

import singleton.util.Common;

import java.io.ObjectStreamException;

public class PerfectSingleton extends Common {
    private static PerfectSingleton instance;

    // Prevent multiple object creation through the constructor
    private PerfectSingleton() {
        // Check if an instance already exists
        if (instance != null) {
            throw new IllegalStateException("Instance already exists. Use getInstance() method.");
        }
        System.out.println("0 param constructor");
    }


    // Prevent multiple object creation through multi-threading
    public static PerfectSingleton getInstance() {
        if (instance == null) {
            synchronized (PerfectSingleton.class) {
                if (instance == null) {
                    instance = new PerfectSingleton();
                }
            }
        }
        return instance;
    }

    // Prevent multiple object creation through cloning
    @Override
    public Object clone() throws CloneNotSupportedException {
        return instance;
    }

    // Prevent multiple object creation through deserialization
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }


}
