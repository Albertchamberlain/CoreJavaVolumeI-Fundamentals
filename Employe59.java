import java.time.LocalDate;
import java.util.Objects;

public class Employe59 {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employe59(String name, double salary, LocalDate hireDay) {
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public  void raiseDay(double byPercent){
        double raise = salary * byPercent /100;
        salary +=raise;
    }

    public  boolean equals(Object otherObject){
        if(this == otherObject)return true;

        if(otherObject == null)return false;
        if(getClass()!= otherObject.getClass())return false;
        Employe59 other = (Employe59) otherObject;
        return  Objects.equals(name,other.name) && salary == other.salary && Objects.equals(hireDay,other.hireDay);
    }

    public int hashCode(){
        return Objects.hash(name,salary,hireDay);
    }

    @Override
    public String toString() {
        return "Employe59{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }
}
