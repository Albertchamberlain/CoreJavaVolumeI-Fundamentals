package javabasestructure;
/**
 * @author Amos
 * @date 7/24/2020 10:59 PM
 */
public class MangerTT {
    public static void main(String[] args) {
        Manager amos = new Manager("Amos", 80000, 1897, 12, 2);
        amos.setBonus(5000);
        Employee[] employees = new Employee[3];
        employees[0] = amos;
        employees[1] = new Employee("EDad",2412,12,3,4);
        employees[2] = new Employee("Ema",2322,11,3,4);
        for (Employee e: employees
             ) {
            System.out.println("e = " + e.getName()+"salary"+e.getSalary());
        }

    }
}

class Manager extends Employee{

    public Manager(String tom, double salary, int i1, int i2, int i3) {
        super(tom, salary, i1, i2, i3);
    }

    public Manager(String tom, double salary) {
        super(tom, salary);
    }
    private double bonus;

    public double getBonus() {
        return super.getSalary()+bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "bonus=" + bonus +
                '}';
    }
}
