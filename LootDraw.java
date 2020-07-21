package javabasestructure;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Amos
 * @date 7/21/2020 10:24 PM
 */
public class LootDraw {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("in = " + in);
        int k = in.nextInt();
        int n = in.nextInt();
        int [] numbers = new int[k];
        for (int i = 0; i <numbers.length ; i++) {
            numbers[i] = i+1;
        }
        int[] result = new int[n];
        for (int i = 0; i <result.length ; i++) {
            int r = (int)(Math.random()* n );
            result[i] = numbers[r];
             numbers[r] = numbers[n-1];
             n--;
        }

        Arrays.sort(result);
        System.out.println("result = " + result);
        for (int r:result) {
            System.out.println("r = " + r);

        }

    }
}
