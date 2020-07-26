package javabasestructure;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * @author Amos
 * @date 7/26/2020 9:35 PM
 */
public class Refla {
    public static void main(String[] args) throws ClassNotFoundException {
        String name;
        if(args.length>0){
            name =args[0];
        }
        else
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter class name (e,g java.util.Date)");
            name = scanner.next();
        }
        Class cl  =Class.forName(name);
        Class supercl = cl.getSuperclass();
        String modi = Modifier.toString(cl.getModifiers());
        if(modi.length()>0){
            System.out.println("modi = " + modi);
        }
        System.out.print(name);
        if(supercl !=null && supercl !=Object.class){
            System.out.print(supercl.getName());
        }
        System.out.print("\n{\n");
        printConstructors(cl);
        System.out.println();
        printMethod(cl);
        System.out.println();
        printField(cl);
        System.out.println("}");

    }


    public  static void printConstructors(Class cl){
        Constructor[] constructors = cl.getConstructors();
        for (Constructor constructor:constructors
             ) {
            String name = constructor.getName();
            System.out.print("  ");
            String modi = Modifier.toString(constructor.getModifiers());
            if(modi.length()> 0){
                System.out.println("modi = " + modi);
            }

            Class[] paramTypes = cl.getInterfaces();
            for (int i = 0; i <paramTypes.length ; i++) {
                if(i>0){
                    System.out.print(",");
                }
            }
            System.out.println(");");
        }
    }

    public static void printMethod(Class cl){
        Method[] methods = cl.getDeclaredMethods();
        for (Method method:methods
             ) {
            Class reType = method.getReturnType();
            String name = method.getName();
            System.out.print(" ");

            String Modi = Modifier.toString(method.getModifiers());
            if(Modi.length()>0){
                System.out.println("Modi = " + Modi);
            }
            System.out.println(reType.getName()+"  " +name+"(");
            Class[] paramTypes = method.getParameterTypes();
            for (int i = 0; i <paramTypes.length ; i++) {
                if(i>0){
                    System.out.print(", ");
                }
            }
            System.out.println(");");
        }
    }
    public  static  void printField(Class cl){
        Field[] fields = cl.getDeclaredFields();
        for (Field field:fields
             ) {
            Class type = field.getType();
            String name = field.getName();
            System.out.print("  ");
            String modi = Modifier.toString(field.getModifiers());
            if(modi.length()>0){
                System.out.println(modi + " ");
            }
            System.out.println(type.getName() +" "+name+";" );
        }
    }
}
