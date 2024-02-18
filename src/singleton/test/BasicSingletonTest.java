package singleton.test;

import singleton.impl.BasicSingletonPrinter;

public class BasicSingletonTest {
    public static void main(String[] args) {
        BasicSingletonPrinter p1 = BasicSingletonPrinter.getInstance();
        BasicSingletonPrinter p2 = BasicSingletonPrinter.getInstance();
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

    }
}
