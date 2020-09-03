package javabasestructure;

import java.lang.*;
import java.lang.reflect.Array;
import java.util.Arrays;


/**
 * @author Amos
 * @date 7/31/2020 9:36 PM
 */
public class CopyOfTest {
    public static void main(String[] args) {
        int [] a = {1,2,3};
        a=(int []) goodCopyOf(a,10);
        System.out.println(Arrays.toString(a));

        String [] b = {"Tom","Dock","Harry "};
        b = (String[]) goodCopyOf(b,10);
        System.out.println(Arrays.toString(b));
        System.out.println("Ths following");
        b = (String []) badCopyOf(b,10);
    }

    public static Object[] badCopyOf(Object[] a,int newLength)
    {
        Object[] objects = new Object[newLength];
        System.arraycopy(a,0,objects,0,Math.min(a.length,newLength));
        return objects;
    }
    public static Object goodCopyOf(Object a,int newLength){
        Class cl=  a.getClass();
        if(!cl.isArray()) return null;
        Class componentType= cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, newLength);
        return newArray;
    }
}
