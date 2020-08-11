/**
 * @author Amos
 * @date 8/11/2020 10:31 PM
 */
public class ThreadTest {
    public static final int DELAY = 10;
    public static final int STEPS = 100;
    public static final double MAX_AMOUNT = 1000;

    public static void main(String[] args) {
        Bank bank = new Bank(4, 1000);
        Runnable task1 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(0, 1, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            } catch (InterruptedException e) {

            }
        };

        Runnable task2 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(2,3,amount);
                    Thread.sleep((int)(DELAY *Math.random()));
                }
            }
            catch (InterruptedException e){

            }
        };

        new Thread(task1).run();
        new Thread(task2).run();
        new Thread(task1).start();
    }
}
