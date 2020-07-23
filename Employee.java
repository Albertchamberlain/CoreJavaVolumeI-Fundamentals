package javabasestructure;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author Amos
 * @date 7/23/2020 10:13 PM
 */
public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;
    private  static  int nextId = 1 ;

    private  int id;

    public void setId() {
        this.id = nextId;
        nextId++;
    }

    public static int getNextId(){
        return nextId;
    }

    public Employee(String tom, double salary, int i1, int i2, int i3) {
        this.name = tom;
        this.salary = salary;
        hireDay = LocalDate.of(i1,i2,i3);
    }

    public Employee(String tom,double salary) {
        this.name = tom;
        this.salary = salary;
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

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }
    public void raiseSalary(double byPercent){
        double raise= salary *byPercent /100;
        salary += raise;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }
}
