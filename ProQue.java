import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * @author Amos
 * @date 8/10/2020 10:54 PM
 */
public class ProQue {
    public static void main(String[] args) {
        final PriorityQueue<LocalDate> localDates = new PriorityQueue<>();
        localDates.add(LocalDate.of(1905,12,7));
        localDates.add(LocalDate.of(1935,7,7));
        localDates.add(LocalDate.of(1235,5,7));
        localDates.add(LocalDate.of(1435,8,7));

        System.out.println("Iterating over elements...");
        for (LocalDate date:localDates
             ) {
            System.out.println("date = " + date);
        }
        System.out.println("Removing elements");
        while (!localDates.isEmpty()){
            System.out.println("localDates = " + localDates.peek());
            System.out.println("localDates = " + localDates.remove());

        }
    }
}
