package singleton.util;

import java.io.Serializable;

public class Common implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public Object clone()throws CloneNotSupportedException {
        System.out.println("Clone executed");
        return super.clone();
    }
}
