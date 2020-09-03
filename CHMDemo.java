import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @author Amos
 */
public class CHMDemo {
    public static  ConcurrentHashMap<String,Long> map = new ConcurrentHashMap<>();

    public static  void provcess(Path file){
        try(final Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()){
                String word = scanner.next();
                map.merge(word,1L,Long::sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Set<Path> descendts(Path root) throws IOException {
        try (Stream<Path> enti = Files.walk(root)){
            return enti.collect(Collectors.toSet());
        }
    }



    public static void main(String [] args) throws IOException, InterruptedException {
        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(processors);

        Path pathroot = Path.of(".");
        for (Path p:descendts(pathroot)
        ) {
            if(p.getFileName().toString().endsWith(".java"))
            {
                executorService.execute(()->provcess(p));
            }
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES);
        map.forEach((k,v)->{
            if(v>=10){
                System.out.println("k = " + k);
                System.out.println("v = " + v);
            }
        });
    }
}
