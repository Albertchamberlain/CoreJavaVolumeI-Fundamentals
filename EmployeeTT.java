package javabasestructure;

/**
 * @author Amos
 * @date 7/23/2020 10:12 PM
 */
public class EmployeeTT {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Tom",75688,1978, 12, 15);
        staff[1] = new Employee("Cat",12344,1999, 12, 15);
        staff[2] = new Employee("Amos",35423,1998, 12, 15);
        for (Employee employee:staff
             ) {
            employee.raiseSalary(5);
        }
        for (Employee employee:staff
             ) {
            System.out.println(employee.toString());
        }

    }
}
