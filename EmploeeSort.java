package javabasestructure;

import java.util.Arrays;

/**
 * @author Amos
 * @date 7/31/2020 10:41 PM
 */
public class EmploeeSort {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Harry",35000);
        staff[1] = new Employee("Carl",75000);
        staff[2]  = new Employee("Tony",38000);

        Arrays.sort(staff);
        for (Employee e: staff
         ) {
            System.out.println("e.getName() = " + e.getName());
            System.out.println("e.getSalary() = " + e.getSalary());

        }
    }
}
