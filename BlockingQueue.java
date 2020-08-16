import java.nio.file.*;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Amos
 * @date 8/16/2020 11:07 PM
 */
public class BlockingQueue {
    private static final int FILE_QUEUE_SIZE = 10;
    private static  final int SEARCH_THREADS = 100;
    private static final Path DUMMY = Path.of("");
    private static BlockingQueue<Path> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);
    public static void main(String[] args) {
        try(final Scanner scanner = new Scanner(System.in)){
            System.out.println("Enter");
            String directory  = scanner.nextLine();
            System.out.print("Enter keyword");
            String keyword = scanner.nextLine();

            Runnable enumer = ()->{
                try{
                    enumerate(Path.of(directory));
                    queue.put(DUMMY);
                }
            }
        }
    }
}
