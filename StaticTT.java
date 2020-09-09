package javabasestructure;

/**
 * @author Amos
 * @date 7/23/2020 10:34 PM
 */
public class StaticTT {
    public static void main(String[] args) {
        javabasestructure.Employee[] staff = new javabasestructure.Employee[3];
        staff[0] = new javabasestructure.Employee("tom",134);
        staff[1] = new javabasestructure.Employee("Vat",134);
        staff[2] = new javabasestructure.Employee("Amos",134);


        for (javabasestructure.Employee employee:staff
             ) {
            employee.setId();
            System.out.println("employee.toString() = " + employee.toString());
        }

        int n = javabasestructure.Employee.getNextId() ;
        System.out.println("n = " + n);
    }
}
