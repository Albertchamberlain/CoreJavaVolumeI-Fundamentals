import java.time.LocalDate;
import java.util.Objects;

public class Manger510 extends Employe59 {
    private  double bonus;
    public Manger510(String name, double salary, LocalDate hireDay) {
        super(name, salary, hireDay);
        bonus = 0;
    }

    public double getSalary(){
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
    public void setBonus(double bonus){
        this.bonus = bonus;
        
    }
    public boolean equals(Object otherObject){
        if(!super.equals(otherObject)) return false;
        Manger510 other = (Manger510) otherObject;
        return bonus  == other.bonus;
    }
    public int hashcode(){
        return java.util.Objects.hash(super.hashCode(),bonus);
    }
    public String toString(){
        return super.toString() +bonus ;
    }
}
