
package singleton.impl;

import singleton.util.Common;

import java.io.ObjectStreamException;

public class SingletonPreventCloneable extends Common {
    private static SingletonPreventCloneable instance;

    private SingletonPreventCloneable() {
        System.out.println("0 param constructor");
    }

    public static SingletonPreventCloneable getInstance() {
        if (instance == null) {
            synchronized (SingletonPreventCloneable.class) {
                if (instance == null) {
                    instance = new SingletonPreventCloneable();
                }
            }
        }
        return instance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return instance;
    }


}
