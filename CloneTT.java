package javabasestructure;

/**
 * @author Amos
 * @date 7/31/2020 11:11 PM
 */
public class CloneTT {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employeee john = new Employeee("John ", 5000);
        john.setHireDay(2000,1,1);
        Employeee copy = (Employeee) john.clone();
        copy.raiseSalary(10);
        copy.setHireDay(2002,12,31);
        System.out.println("john = " + john);
        System.out.println("copy = " + copy);
    }
}
