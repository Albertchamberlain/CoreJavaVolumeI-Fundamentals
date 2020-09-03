import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Amos
 * @date 8/24/2020 9:08 PM
 */
public class CountLongWord {
    public static void main(String[] args) throws IOException {
        final String s = new String(Files.readAllBytes(Paths.get("../gutenberg/alice30.txt")), StandardCharsets.UTF_8);
        List<String> words = List.of(s.split("\\PL+"));

        long count = 0;
        for(String w : words){
            if(w.length()>12){
                count++;
            }
        }
        System.out.println("count = " + count);

        count = words.stream().filter(w->w.length()>12).count();
        System.out.println("count = " + count);


        count = words.parallelStream().filter(w->w.length()>12).count();
        System.out.println(count);

    }
}
