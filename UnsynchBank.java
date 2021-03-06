/**
 * @author Amos
 * @date 8/16/2020 8:38 PM
 */
public class UnsynchBank {
    public static final  int NACCOUNTS = 100;
    public static  final double INITIAL_BALANCE = 1000;
    public static  final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    public static void main(String[]args){
        final Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i <NACCOUNTS ; i++) {
            int fromAccount = i;
            Runnable r = ()->{
                try{
                    while(true){
                        int toAccount = (int) (bank.size()*Math.random());
                        double amoount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount,toAccount,amoount);
                        Thread.sleep((int)(DELAY * Math.random()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            final Thread thread = new Thread(r);
            thread.start();
        }
    }
}
