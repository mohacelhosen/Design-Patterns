package singleton;

public class SingletonPrinter {

    private static SingletonPrinter printer;

    // Private constructor to prevent direct instantiation
    private SingletonPrinter() {
        //No body
    }

    //primary level singleton easily multi thread can break singleton
//    public static  SingletonPrinter getInstance() {
//        if (printer == null) {
//            printer = new SingletonPrinter();
//        }
//        return printer;
//    }


//primary level singleton easily multi thread can break singleton
//    public static SingletonPrinter getInstance() {
//            if (printer == null) {
//                try {
//                    Thread.sleep(10000);//introduces a race condition that can lead to the creation of multiple instances in a multi-threaded environment
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                printer = new SingletonPrinter();
//            }
//
//        return printer;
//    }



    // singleton in multi thread environment but performance issue
//    public static synchronized SingletonPrinter getInstance() {
//        if (printer == null) {
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            printer = new SingletonPrinter();
//        }
//        return printer;
//    }


    // class level locking
//    public static SingletonPrinter getInstance() {
//        System.out.println("Outside😆 syn block:: "+Thread.currentThread().getName());
//        // "this" keyword can't be used in static method
//        synchronized (SingletonPrinter.class) { //SingletonPrinter.class here ".class" is a static variable added by compiler. by this "SingletonPrinter.class" we know everything about "SingletonPrinter"
//            System.out.println("Inside🙂 syn block:: "+Thread.currentThread().getName());
//            if (printer == null) {
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                printer = new SingletonPrinter();
//            }
//        }
//        return printer;
//    }



    //Double-Checked Locking Singleton Pattern with Lazy Initialization.
    public static SingletonPrinter getInstance() {
        System.out.println("Outside😆 syn block:: "+Thread.currentThread().getName());
        // First check outside the synchronized block for performance
        if (printer == null) {
            // Synchronize only when the instance is not yet created
            synchronized (SingletonPrinter.class) {
                System.out.println("Inside🙂 syn block:: "+Thread.currentThread().getName());
                // Double-check inside the synchronized block
                if (printer == null) {
                    System.out.println("🎁"+Thread.currentThread().getName());
                    try {
                        // Simulate time-consuming initialization
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // Create the singleton instance
                    printer = new SingletonPrinter();
                }
            }
        }
        return printer;
    }

    public void printSomething() {
        System.out.println("Singleton Printer🖨️ instance is printing something.");
    }
}
