package singleton;

public class SingletonPrinter {

    private static SingletonPrinter printer;
    private SingletonPrinter(){
        //no body
    }

    public static SingletonPrinter getInstance(){
       if (printer==null){
           printer = new SingletonPrinter();
       }
       return printer;
    }

    public void printSomething() {
        System.out.println("Singleton Printer🖨️ instance is printing something.");
    }
}
