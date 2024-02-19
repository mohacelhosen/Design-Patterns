package singleton.impl;

import singleton.util.Common;

import java.io.ObjectStreamException;

public class PerfectSingletonPrinter extends Common {
    private static boolean isInstantiated = false;

    // Prevent multiple object creation through the constructor event reflection api also
    private PerfectSingletonPrinter() {
        // Check if printer already exists
        if (isInstantiated ) {
            throw new IllegalStateException("Instance already exists. Use getInstance() method.");
        } else {
            isInstantiated = true;
            System.out.println("0 param constructor");
        }
    }

    //The use of a nested static class (SingletonHolder) and the initialization of the instance in a static field
    // provide additional safeguards against simple reflection instantiation.
    private static class SingletonHolder{
        private static PerfectSingletonPrinter PRINTER = new PerfectSingletonPrinter();
    }

    // return the instance stored in the SingletonHolder.
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
