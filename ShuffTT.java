import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Amos
 * @date 8/11/2020 11:25 AM
 */
public class ShuffTT {
    public static void main(String[] args) {
        final ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 1; i <=49 ; i++) {
            integers.add(i);
        }
        Collections.shuffle(integers);
        List<Integer> winn =integers.subList(0,6);
        System.out.println("winn = " + winn);
        Collections.sort(winn);
        System.out.println("winn = " + winn);
    }
}
