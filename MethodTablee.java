package javabasestructure;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Amos
 * @date 7/31/2020 10:29 PM
 */
public class MethodTablee {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method square = MethodTablee.class.getMethod("square",double.class);
        Method sqrt = Math.class.getMethod("sqrt",double.class);
        printTable(1,10,10,square);
        printTable(1,10,10,sqrt);
    }
    public static double ssquare(double x)
    {
        return x*x;
    }
    public static  void printTable(double from ,double to , int n , Method f) throws InvocationTargetException, IllegalAccessException {
        double dx = (to-from)/(n-1);
        for(double x = from ;x<=to;x+=dx){
            double  y = (Double) f.invoke(null,x);
            System.out.printf("%10.4f| %10.4f%n",x,y);
        }
    }
}
