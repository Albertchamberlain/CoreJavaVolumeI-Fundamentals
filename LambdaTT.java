package javabasestructure;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Amos
 * @date 8/1/2020 9:05 AM
 */
public class LambdaTT {
    public static void main(String[] args) {
        String[] strings = new String[]{"Mercury", "Venus", "Earth", "Mars"};
        System.out.println("Arrays.toString(strings) = " + Arrays.toString(strings));
        System.out.println("sorted in dictionary order");

        Arrays.sort(strings);
        System.out.println("Arrays.toString(strings) = " + Arrays.toString(strings));
        System.out.println("Sorted by length");
        Arrays.sort(strings,(first,scond)->first.length()-scond.length());
        System.out.println("Arrays.toString(strings) = " + Arrays.toString(strings));


        Timer timer = new Timer(1000, event -> System.out.println("new Data() = " + new Date()));
        timer.start();

        JOptionPane.showMessageDialog(null,"Quit program?");

        System.exit(0);

    }
}
