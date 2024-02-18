package singleton.impl;

public class BasicSingletonPrinter {
    private static BasicSingletonPrinter printer;

    private BasicSingletonPrinter(){
        System.out.println("0 param constructor");
    }

    public static BasicSingletonPrinter getInstance(){
        if (printer==null){
            printer = new BasicSingletonPrinter();
        }
        return printer;
    }
}
