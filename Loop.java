package javabasestructure;

import java.util.Scanner;

/**
 * @author Amos
 * @date 7/21/2020 10:15 PM
 */
public class Loop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("in = " + in);
        int k = in.nextInt();

        System.out.println("k = " + k);
        int n = in.nextInt();

        int lott = 1;
        for (int i = 0; i <k ; i++) {
            lott = lott *(n-i+1)/i;
            System.out.println("lott = " + lott);
        }
    }
}
