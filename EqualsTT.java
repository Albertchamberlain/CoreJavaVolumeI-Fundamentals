package javabasestructure;

import java.util.logging.Logger;

/**
 * @author Amos
 * @date 7/24/2020 11:15 PM
 */
public class EqualsTT {
    public static void main(String[] args) {
        Employee alice1 = new Employee("Amos", 1234, 1999, 1, 2);
        Employee alice2 =alice1;
        Employee alice3 = new Employee("Amos", 1234, 1999, 1, 2);
        Employee employee = new Employee("bob", 1999, 1234, 12, 1);
        System.out.println("alice1 ==alice2 = " + (alice1 ==alice2));
        System.out.println("alice1 = " + (alice1==alice3));
        System.out.println("alice1.equals(alice3) = " + alice1.equals(alice3));
        System.out.println("alice1 = " + alice1.equals(employee));
        System.out.println("employee = " + employee);
        Manager amos = new Manager("Amos", 8000, 1897, 12, 15);
        Manager tmos = new Manager("Amos", 8000, 1897, 12, 15);
        tmos.setBonus(5000);
        System.out.println("tmos = " + tmos);
        System.out.println("amos.equals(tmos) = " + amos.equals(tmos));
        System.out.println("alice3 = " + alice1.hashCode());
        System.out.println("alice3 = " + alice3.hashCode());
        System.out.println("employee = " + employee.hashCode());
        System.out.println("amos.hashCode() = " + amos.hashCode());
    }
}
