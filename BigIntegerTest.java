package javabasestructure;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Amos
 * @date 7/21/2020 10:19 PM
 */
public class BigIntegerTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("in = " + in);
        int  k = in.nextInt();

        System.out.println("k = " + k);
        int i = in.nextInt();
        BigInteger lott = BigInteger.valueOf(1);

        for (int j = 0; j <=k ; j++) {
            lott = lott.multiply(BigInteger.valueOf(k-i+1)).divide(BigInteger.valueOf(i));
            System.out.println("lott = " + lott);
            
        }
    }
}
