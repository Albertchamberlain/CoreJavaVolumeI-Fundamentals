package javabasestructure;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Amos
 * @date 8/1/2020 11:02 AM
 */
public class ProxyTT {
    public static void main(String[] args) {
        Object[] objects = new Object[1000];
        for (int i = 0; i <objects.length ; i++) {
            Integer value = i+1;
            TraceHandler traceHandler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(
                    ClassLoader.getSystemClassLoader(),new Class[]{Comparable.class},traceHandler);
            objects[i] = proxy;
        }
        Integer key = new Random().nextInt(objects.length)+1;
        int result = Arrays.binarySearch(objects, key);
        if(result>0){
            System.out.println("objects = " + objects[result]);
        }
    }
}
class  TraceHandler implements InvocationHandler{
    private  Object target;
    public TraceHandler(Object t)
    {
        target = t;
    }
    @Override
    public Object invoke(Object proxy, Method m, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.print("target");
        System.out.println("m.getName() = " + m.getName());
        if(args !=null){
            for (int i = 0; i <args.length ; i++) {
                System.out.print(args[i]);
                if(i<args.length-1){
                    System.out.println(",");
                }
            }
        }
        System.out.println(" ");
        return m.invoke(target,args);
    }
}