package javabasestructure;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Amos
 * @date 8/9/2020 6:51 PM
 */
public class Genneric {
    public static void main(String[] args) {

        String name;
        if(args.length>0){
            name = args[0];
        }
        else{
            try(final Scanner scanner = new Scanner(System.in)){
                System.out.println(" PLZ Enter class name");
                name =  scanner.next();
            }
        }
        try{
            Class <?> cl = Class.forName(name);
            printClass(cl);
            for (Method method:cl.getDeclaredMethods()
                 ) {
                printMethod(method);
            }
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void printClass(Class<?> cl){
        printTypes(cl.getTypeParameters(),"<",",",">",true);
        Type sc= cl.getGenericSuperclass();
        if(sc!=null){
            System.out.print("extends");
            printType(sc,false);
        }
        printTypes(cl.getGenericInterfaces(),"implements",",","",false);
        System.out.println();
    }

    public static void printMethod(Method method){
        final String name = method.getName();
        System.out.println("Modifier.toString(method.getModifiers()) = " + Modifier.toString(method.getModifiers()));
        System.out.println("");
        printTypes(method.getTypeParameters(),"<",",",">",true);

        printType(method.getGenericReturnType(),false);

        System.out.print("");
        System.out.print("name = " + name);
        System.out.print("(");
        printTypes(method.getGenericParameterTypes(),"",",","",false);
        System.out.print(")");
    }


    public  static void printTypes(Type [] types,String pre,String sepm,String suf,boolean isDefinition){
        if(("extends".equals(pre)) && Arrays.equals(types,new Type[]{Object.class})){
            return;
        }

        if(types.length>0){
            System.out.println("pre = " + pre);
        }
        for (int i = 0; i < types.length; i++) {
            if(i>0){
                System.out.println("sepm = " + sepm);
            }
            printType(types[i],isDefinition);
        }
        if(types.length>0){
            System.out.println("suf = " + suf);
        }
    }

    public static void printType(Type type,boolean isDefinition){
        if(type instanceof Class){
            final Class<?> type1 = (Class<?>) type;
            System.out.println("type1.getName() = " + type1.getName());
        }
        else if(type instanceof TypeVariable){
            final TypeVariable<?> type1 = (TypeVariable<?>) type;
            System.out.println("type1.getName() = " + type1.getName());
            if(isDefinition){
                printTypes(type1.getBounds(),"extends","&","",false);
            }
        }
        else if(type instanceof WildcardType){
            final WildcardType type1 = (WildcardType) type;
            System.out.println( "?");
            printTypes(type1.getUpperBounds(),"extends","&","",false);
            printTypes(type1.getLowerBounds(),"extends","&","",false);
        }
        else if(type instanceof ParameterizedType){
            final ParameterizedType type1 = (ParameterizedType) type;
            Type owner = type1.getOwnerType();
            if(owner !=null){
                printType(owner,false);
                System.out.println(",");
            }
            printType(type1.getRawType(),false);
            printTypes(type1.getActualTypeArguments(),"<",">",",",false);
        }
        else if(type instanceof GenericArrayType){
            final GenericArrayType type1 = (GenericArrayType) type;
            System.out.println("");
            printType(type1.getGenericComponentType(),isDefinition);
            System.out.println("[]");
        }
    }


}
