import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Amos
 * @date 8/16/2020 11:07 PM
 */
class BlockingQueueTT {
    private static final int FILE_QUEUE_SIZE = 10;
    private static  final int SEARCH_THREADS = 100;
    private static final Path DUMMY = Path.of("");
    private static java.util.concurrent.BlockingQueue<Path> queue = new ArrayBlockingQueue<Path>(FILE_QUEUE_SIZE);

    public static void main(String[] args) {
        try(final Scanner scanner = new Scanner(System.in)){
            System.out.println("Enter");
            String directory  = scanner.nextLine();
            System.out.print("Enter keyword");
            String keyword = scanner.nextLine();
            Runnable enumerator = ()->{
                try{
                    enumerate(Path.of(directory));
                    queue.put(DUMMY);
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                catch (InterruptedException e){
                }
            };
            new Thread(enumerator).start();
            for (int i = 1; i <SEARCH_THREADS ; i++) {
                Runnable searcher=()->{
                    try{
                        boolean done = false;
                        while(!done){
                            Path file = queue.take();
                            if(file == DUMMY){
                                queue.put(file);
                                done = true;
                            }
                            else{
                                search(file,keyword);
                            }
                        }
                    } catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                };
                new Thread(searcher).start();
            }
        }
    }


    public static void enumerate(Path directory) throws IOException, InterruptedException {
        try(Stream<Path> children = Files.list(directory)) {
            for (Path child:children.collect(Collectors.toList())
                 ) {
                if(Files.isDirectory(child)){
                    enumerate(child);
                }
                else
                {
                    queue.put(child);
                }
            }
        }
    }



    public static void search (Path file,String keyword) throws IOException {
        try(Scanner scanner = new Scanner(file, StandardCharsets.UTF_8)){
            int lineNumber = 0;

            while(scanner.hasNextLine()){
                lineNumber++;
                String line = scanner.nextLine();
                if(line.contains(keyword)){
                    System.out.printf("%s:%d:%s%n",file,lineNumber,line);
                }
            }
        }
    }
}
