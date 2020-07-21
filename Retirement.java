package javabasestructure;

import java.util.Scanner;

/**
 * @author Amos
 * @date 7/21/2020 10:01 PM
 */
public class Retirement {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.println("in = " + in);
        double goal = in.nextDouble();
        System.out.println("goal = " + goal);
        double payment = in.nextDouble();
        System.out.println("payment = " + payment);
        double interestRate = in.nextDouble();
        System.out.println(" = " + interestRate);
        double balance = 0;
        int  years =  0;
        while (balance<goal){
            balance+=payment;
            double interest = balance* interestRate / 100;
            balance += interest;
            years++;
        }
        System.out.println("years = " + years);
    }
}
