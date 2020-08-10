import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Amos
 * @date 8/10/2020 10:24 PM
 */
public class SetTT {
    public static void main(String[] args) {
         HashSet<String> strings = new HashSet<>();
        long totaltime = 0;
        try(final Scanner scanner = new Scanner(System.in)){
            while (scanner.hasNext()){
                String word = scanner.next();
                long callTime = System.currentTimeMillis();
                strings.add(word);
                callTime = System.currentTimeMillis()-callTime;
                totaltime += callTime;
            }
        }
        final Iterator<String> iterator = strings.iterator();
        for (int i = 1; i <=20 && iterator.hasNext() ; i++) {
            System.out.println(iterator.next());
        }
        System.out.println(". . .");
        System.out.println("iterator = " + iterator);
        System.out.println("totaltime = " + totaltime);
    }
}
