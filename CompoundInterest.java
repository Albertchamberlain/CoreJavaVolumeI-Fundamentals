package javabasestructure;
import java.util.Arrays;
/**
 * @author Amos
 * @date 7/21/2020 10:30 PM
 */
public class CompoundInterest {
    public static void main(String[] args) {
        final double sTR = 19;
        final  int nRATES = 6;
        final int nYEARS = 10;
        double[] interestRates = new double[nRATES];
        for (int i = 0; i <interestRates.length ; i++) {
            interestRates[i] = (sTR +i) / 100.0;
            double [][] balance = new double[nYEARS][nRATES];
            Arrays.fill(balance[0], 1000);
            for (int j = 0; j <balance.length ; j++) {
                for (int k = 0; k <balance[i].length ; k++)
                {
                    double old = balance[i-1] [j];
                    double interest = old*interestRates[j];
                    balance[i][j] = old +interest;
                }
            }
            for (double interestRate : interestRates) {
                System.out.println("%9.0f%%" + interestRate * 100);
            }
            System.out.println();

            for (double[] row:balance) {
                for (double b :row
                     ) {
                    System.out.println("%10.2f" + b);
                }
                System.out.println();
            }
        }
    }
}
