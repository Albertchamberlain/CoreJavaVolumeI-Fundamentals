import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Amos
 * @date 8/16/2020 9:02 PM
 */
public class BankAF {
    private final double[] accounts;
    private Lock bankLock;
    private Condition suff;

    public BankAF(double[] accounts, Lock bankLock) {
        this.accounts = accounts;
        this.bankLock = bankLock;
    }

    public BankAF(int n ,double init){
        accounts = new double[n];
        Arrays.fill(accounts,init);
        bankLock = new ReentrantLock();
        suff = bankLock.newCondition();
    }


    public void transfer(int from,int to,double amount){
        bankLock.lock();
        try{
            while(accounts[from]<amount){
                suff.await();
            }
            System.out.print(Thread.currentThread());
            accounts[from]-= amount;
            System.out.printf("%10.2f from %d to %d",amount,from,to);
            accounts[to]+=amount;
            System.out.printf("Total Balance %10.2f%n",getTotalBalance());
            suff.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            bankLock.unlock();
        }
    }

    public double getTotalBalance(){
        bankLock.lock();
        try{
            double sum = 0;
            for (double a:accounts
                 ) {
                sum+=0;
            }
            return sum;
        }
        finally {
            bankLock.unlock();
        }
    }
    public int size(){
        return accounts.length;
    }
}
