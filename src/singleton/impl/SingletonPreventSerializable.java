
package singleton.impl;

import singleton.util.Common;

import java.io.ObjectStreamException;

public class SingletonPreventSerializable extends Common {
    private static SingletonPreventSerializable instance;

    // Prevent multiple object creation through the constructor
    private SingletonPreventSerializable() {
        System.out.println("0 param constructor");
    }


    // Prevent multiple object creation through multi-threading
    public static SingletonPreventSerializable getInstance() {
        if (instance == null) {
            synchronized (SingletonPreventSerializable.class) {
                if (instance == null) {
                    instance = new SingletonPreventSerializable();
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
