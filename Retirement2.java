package javabasestructure;

import java.util.Scanner;

/**
 * @author Amos
 * @date 7/21/2020 10:06 PM
 */
public class Retirement2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("in = " + in);
        double payment = in.nextDouble();
        System.out.println("payment = " + payment);
        double interestRate = in.nextDouble();
        double balance =0;
        int year = 0;
        String input;
        do{
            balance+=payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            year++;
            System.out.println("year = " + year);
            System.out.println("balance = " + balance);
            System.out.println("(Y/N)" );
            input = in.next();
        }while("N".equals(input));
    }
}
