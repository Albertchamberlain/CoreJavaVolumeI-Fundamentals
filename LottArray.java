package javabasestructure;

/**
 * @author Amos
 * @date 7/23/2020 9:45 PM
 */
public class LottArray {
    public static void main(String[] args) {
        final int MAX = 10;
        int [][] odds =new int[MAX+1][];
        for (int i = 0; i <=MAX ; i++) {
            odds[i] = new int[i+1];
        }

        for (int i = 0; i <odds.length ; i++) {
            for (int j = 0; j <odds[j].length ; j++) {

                int loota = 1;
                for (int k = 0; k <j ; k++) {

                    loota = loota*(i-k +1)/k;
                }
                odds[i][j] = loota;
            }
            for (int [] row: odds
                 ) {
                for (int odd:row
                     ) {
                    System.out.printf("%4f",odd);
                }
                System.out.println();
            }

        }
    }
}
