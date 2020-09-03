import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author Amos
 * @date 8/10/2020 9:26 PM
 */
public class LinkListT {
    public static void main(String[] args) {
        final LinkedList<String> strings = new LinkedList<>();
        strings.add("TOm");
        strings.add("JIM");
        strings.add("ORT");
        final LinkedList<String> strings1 = new LinkedList<>();

        strings1.add("Bob");
        strings1.add("Dom");
        strings1.add("Zib");
        strings1.add("Gloz");


        ListIterator<String> iterator =strings.listIterator();
         Iterator<String> iterator1 = strings1.iterator();

        while(iterator1.hasNext()){
            if(iterator.hasNext()){
                iterator.next();
            }
            iterator.add(iterator1.next());
        }
        System.out.println("iterator = " + iterator);

        iterator1 = strings1.iterator();
        while(iterator1.hasNext()){
            iterator1.next();
            if(iterator1.hasNext()){
                iterator1.next();
                iterator1.remove();
            }
        }
        System.out.println("iterator1 = " + iterator1);

        strings.removeAll(strings1);

        System.out.println("iterator = " + iterator);
    }
}
