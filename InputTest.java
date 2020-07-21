package javabasestructure;

import java.io.File;
import java.util.Scanner;

/**
 * @author Amos
 * @date 7/21/2020 9:53 PM
 */
public class InputTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("R u OK?");
        String name = in.nextLine();
        System.out.println("Thank you ");
        int i = in.nextInt();
        System.out.println("i = " + i);
        System.out.println("name = " + name);
    }
}
