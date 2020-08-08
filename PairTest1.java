package javabasestructure;


/**
 * @author Amos
 * @date 8/8/2020 10:47 PM
 */
public class PairTest1 {

    public static void main(String[] args) {
        String [] words = {"Marry","had","a","little","lamb"};
        final Pair<String> minmax = ArrayAlgg.minmax(words);
        System.out.println("minmax.getFirst()= " + minmax.getFirst());
        System.out.println("minmax.getSecond() = " + minmax.getSecond());
    }
}

class ArrayAlgg{
    public static Pair<String> minmax(String [] a){
        if(a==null || a.length ==0){
            return null;
        }
        String min =a[0];
        String max = a[0];
        for (int i = 1; i <a.length ; i++) {
            if(min.compareTo(a[i])>0){
                min = a[i];
            }
            if(max.compareTo(a[i])<0){
                max = a[i];
            }
        }
        return new Pair<>(min,max);
    }
}
