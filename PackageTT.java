package javabasestructure;

import jdk.nashorn.internal.objects.Global;

import static java.lang.System.out;

/**
 * @author Amos
 * @date 7/24/2020 10:34 PM
 */
public class PackageTT {
    public static void main(String[] args) {
        Employee harry_hacker = new Employee("Harry hacker", 5000, 1989, 10, 1);
        harry_hacker.raiseSalary(2);

        out.println("harry_hacker = " + harry_hacker.getSalary()+harry_hacker.getName());


    }
}



