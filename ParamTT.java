package javabasestructure;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Amos
 * @date 7/23/2020 10:43 PM
 */
public class ParamTT {
    public static void main(String[] args) {
        System.out.println("TT begin...");
        double percent = 10;
        System.out.println("percent = " + percent);
        tripleValue(percent);
        System.out.println("After:percent" + percent);

        System.out.println("\nTTing tripleSalary");
        Employeee employee = new Employeee("Harry", 5000);

        System.out.println("employee.getSalary() = " + employee.getSalary());
        tripleSalary(employee);
        System.out.println("employee = " + employee.getSalary());

        System.out.println(" Swap running");

        Employeee employee1 = new Employeee("AoA", 780);
        Employeee employee2 = new Employeee("OaO", 14332);
        System.out.println("employee2.getName() = " + employee2.getName());
        System.out.println("employee1.getName() = " + employee1.getName());
        swap(employee1,employee2);
        System.out.println("employee2.getName() = " + employee2.getName());
        System.out.println("employee1.getName() = " + employee1.getName());



        }
    public static void tripleSalary(Employeee x){
        x.raiseSalary(200);
        System.out.println("tripleSalary.getSalary() = " + x.getSalary());
    }
    public static  void swap(Employeee x,Employeee y){
        Employeee temp =x;
        x=y;
        y=temp;
        System.out.println("x.getName() = " + x.getName());
        System.out.println("y.getName() = " + y.getName());
    }

    public  static void tripleValue(double x){
        x= 3*x;
        System.out.println("x = " + x);

    }

}
class Employeee{
    private String name;
    private double salary;
    private  Date hireDay;
    public Employeee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }



    public void raiseSalary(double byPercent){
        double raise = salary*byPercent/100;
        salary += raise;
    }

    public void setHireDay(int i, int i1, int i2) {
        Date newHireday  = new GregorianCalendar(i,i1 - 1,i2).getTime();
        hireDay.setTime(newHireday.getTime());
    }

    @Override
    public Employeee clone( ) throws  CloneNotSupportedException{
        Employeee cloned = (Employeee) super.clone();

        cloned.hireDay = (Date)hireDay.clone();
        return cloned;
    }
}
