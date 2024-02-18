package singleton.impl;

import singleton.util.Common;

import java.io.ObjectStreamException;

public class PerfectSingletonPrinter extends Common {
    private static boolean isInstantiated = false;

    // Prevent multiple object creation through the constructor
    private PerfectSingletonPrinter() {
        // Check if printer already exists
        if (isInstantiated) {
            throw new IllegalStateException("Instance already exists. Use getInstance() method.");
        } else {
            isInstantiated = true;
            System.out.println("0 param constructor");
        }
    }

    private static class SingletonHolder{
        private static PerfectSingletonPrinter PRINTER = new PerfectSingletonPrinter();
    }

    public static PerfectSingletonPrinter getInstance(){
        return SingletonHolder.PRINTER;
    }


    // Prevent multiple object creation through cloning
    @Override
    public Object clone() throws CloneNotSupportedException {
        return  SingletonHolder.PRINTER;
    }

    // Prevent multiple object creation through deserialization
    private Object readResolve() throws ObjectStreamException {
        return  SingletonHolder.PRINTER;
    }
}
