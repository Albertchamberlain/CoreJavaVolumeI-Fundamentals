
import java.util.ArrayList;

/**
 * @author Amos
 * @date 7/26/2020 9:17 PM
 */
public class ArraayListTT {
    public static void main(String[] args) {
        ArrayList<javabasestructure.Employee> employees = new ArrayList<>();
        employees.add(new javabasestructure.Employee("Amos",1950));
        employees.add(new javabasestructure.Employee("Jack",1834));
        employees.add(new javabasestructure.Employee("Atas",1432));
        for (javabasestructure.Employee employee:employees
             ) {
            employee.raiseSalary(4);
        }
        for (javabasestructure.Employee employee:employees
             ) {
            System.out.println("employee = " + employee.getSalary()+employee.getHireDay()+ employee.getName());
        }
    }
}
