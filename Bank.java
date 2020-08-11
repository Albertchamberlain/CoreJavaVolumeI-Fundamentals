import java.util.Arrays;

/**
 * @author Amos
 * @date 8/11/2020 10:35 PM
 */
public class Bank {
    private final double[] accounts;

    public Bank(double[] accounts) {
        this.accounts = accounts;
    }
    public Bank (int n,double initialValue){
        accounts = new double[n];
        Arrays.fill(accounts,initialValue);
    }

    public void transfer(int from ,int to ,double amount){
        if(accounts[from]<amount){
            return;
        }
        System.out.print(Thread.currentThread());
        accounts[from] -=amount;
        System.out.println("from = " + from);
        System.out.println("to = " + to);
        System.out.println("amount = " + amount);
        accounts[to] += amount;
        System.out.print("Total"+getTotalBalance());
    }

    public double getTotalBalance(){
        double sum =0;
        for (double a:accounts
             ) {
            sum+=a;
        }
        return sum;
    }


    public int size(){
        return  accounts.length;
    }
    public static void main(String[] args) {
        
    }
}
