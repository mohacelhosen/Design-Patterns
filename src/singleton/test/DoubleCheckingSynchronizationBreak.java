package singleton.test;

import singleton.impl.DoubleCheckingSynchronization;

public class DoubleCheckingSynchronizationBreak {
    public static void main(String[] args) {
        DoubleCheckingSynchronization p1 = DoubleCheckingSynchronization.getInstance();
        try{
            DoubleCheckingSynchronization p2= (DoubleCheckingSynchronization) p1.clone();
            DoubleCheckingSynchronization p3= (DoubleCheckingSynchronization) p1.clone();
            DoubleCheckingSynchronization p4= (DoubleCheckingSynchronization) p1.clone();

            System.out.println("p1 hashCode= " + p1.hashCode());
            System.out.println("p2 hashCode= " + p2.hashCode());
            System.out.println("p3 hashCode= " + p3.hashCode());
            System.out.println("p4 hashCode= " + p4.hashCode());

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
