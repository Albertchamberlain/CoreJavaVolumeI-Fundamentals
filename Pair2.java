package javabasestructure;

import java.time.LocalDate;

/**
 * @author Amos
 * @date 8/8/2020 11:00 PM
 */
public class Pair2 {
    public static void main(String[] args) {
        LocalDate[] bo = {
                LocalDate.of(1906,12,1),
                LocalDate.of(1812,12,3),
                LocalDate.of(1999,12,4),
                LocalDate.of(1234,12,45),
        };
        Pair<LocalDate> mm = ArrayAlgtwo.minmax(bo);
        System.out.println("mm.getFirst() = " + mm.getFirst());
        System.out.println("mm.getSecond() = " + mm.getSecond());
    }
}


class ArrayAlgtwo {
    public static <T extends Comparable> Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        return new Pair<>(min, max);
    }
}
