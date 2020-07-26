package javabasestructure;

import java.util.ArrayList;

/**
 * @author Amos
 * @date 7/26/2020 9:17 PM
 */
public class ArraayListTT {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Amos",1950));
        employees.add(new Employee("Jack",1834));
        employees.add(new Employee("Atas",1432));
        for (Employee employee:employees
             ) {
            employee.raiseSalary(4);
        }
        for (Employee employee:employees
             ) {
            System.out.println("employee = " + employee.getSalary()+employee.getHireDay()+ employee.getName());
        }
    }
}
