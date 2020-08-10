import java.util.TreeSet;

import java.util.*;
/**
 * @author Amos
 * @date 8/10/2020 10:31 PM
 */
public class TreeSetTT {
    public static void main(String[] args) {
        final TreeSet<Item> items = new TreeSet<>();
        items.add(new Item("Tom",12));
        items.add(new Item("Com",15));
        items.add(new Item("Dao",12));
        items.add(new Item("ECV",11));
        System.out.println(items);


        final TreeSet<Item> items1 = new TreeSet<>(Comparator.comparing(Item::getDescription));

       items1.addAll(items);

        System.out.println("sortByDescr = " + items1);
    }
}
