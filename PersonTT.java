package javabasestructure;

import java.time.LocalDate;

/**
 * @author Amos
 * @date 7/24/2020 11:06 PM
 */
public class PersonTT {
    public static void main(String[] args) {

    }
}




abstract class Person{

    public abstract  String getDescription();
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


class  Student extends Person{
    private String major;
    public  Student (String name , String major){
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return major;
    }
}


class Employeeeee extends Person{
    private  double salary;
    private LocalDate hireDay;

    public Employeeeee(String name, double salary, LocalDate hireDay) {
        super(name);
        this.salary = salary;
        this.hireDay = hireDay;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    @Override
    public String getDescription() {
        return String.format("%.2f",salary);
    }
    public void raiseSalary(double byPercent){
        double raise = salary*byPercent / 100;
        salary +=raise;
    }
}
