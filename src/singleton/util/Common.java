package singleton.util;

public class Common implements Cloneable {

    @Override
    public Object clone()throws CloneNotSupportedException {
        System.out.println("Clone executed");
        return super.clone();
    }
}
