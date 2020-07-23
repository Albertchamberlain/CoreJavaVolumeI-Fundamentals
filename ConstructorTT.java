package javabasestructure;

import java.util.Random;

/**
 * @author Amos
 * @date 7/23/2020 11:20 PM
 */
public class ConstructorTT {
    public static void main(String[] args) {
        new Employeeee();
    }
}
class Employeeee{
    private static int nextId;

    private int id;
    private  String name = "";

    private double salary;

    static {
        Random gennerator = new Random();

        nextId = gennerator.nextInt(1000);

    }
    {
        id = nextId;
        nextId++;
    }

    public Employeeee() {

    }

    public Employeeee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employeeee(double salary) {
        this.salary = salary;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Employeeee.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


}
