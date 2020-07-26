package javabasestructure;

import java.util.ArrayList;

/**
 * @author Amos
 * @date 7/26/2020 10:15 PM
 */
public class ObjectAn {
    public static void main(String[] args) throws IllegalAccessException {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i <=5 ; i++) {
            integers.add(i*i);
        }
        System.out.println(new ObjectAnalyzer().toString(integers));
    }
}
