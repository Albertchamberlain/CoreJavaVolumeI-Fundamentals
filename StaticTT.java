package javabasestructure;

/**
 * @author Amos
 * @date 7/23/2020 10:34 PM
 */
public class StaticTT {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("tom",134);
        staff[1] = new Employee("Vat",134);
        staff[2] = new Employee("Amos",134);


        for (Employee employee:staff
             ) {
            employee.setId();
            System.out.println("employee.toString() = " + employee.toString());
        }

        int n = Employee.getNextId() ;
        System.out.println("n = " + n);
    }
}
