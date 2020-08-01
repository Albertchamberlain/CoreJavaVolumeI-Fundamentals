package javabasestructure;

import java.util.Scanner;

/**
 * @author Amos
 * @date 8/1/2020 11:36 AM
 */
public class StackTraceTT {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            System.out.print("Enter n");
            int n  = scanner.nextInt();
            facor(n);
        }
    }

    private static void  facor(int n) {
        System.out.println("n = " + n);

    }
}
