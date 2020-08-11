import java.util.BitSet;

/**
 * @author Amos
 * @date 8/11/2020 8:09 PM
 */
public class psvm {
    public static void main(String[] args) {
         int n = 2000000;
         long startTime =System.currentTimeMillis();
        final BitSet bitSet = new BitSet(n + 1);
        int counter  = 0;
        int i;
        for ( i = 2; i <=n ; i++) {
            bitSet.set(i);
        }
        i = 2;
        while (i * i <=n){
            if(bitSet.get(i)){
                counter++;
                int k = 2*i;
                while(k<=n){
                    bitSet.clear(k);
                    k+= i ;
                }
            }
            i++;
        }
        while(i<=n){
            if(bitSet.get(i)){
                counter++;
            }
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println(counter+"primers");
        System.out.println((end-startTime)+"milliseconds");
    }
}
