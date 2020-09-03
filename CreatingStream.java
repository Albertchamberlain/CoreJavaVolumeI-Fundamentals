import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author Amos
 * @date 8/24/2020 9:20 PM
 */
public class CreatingStream {
    public static <T> void show (String title, Stream<T> stream){
        final int SIZE = 10;
        List<T> firstElements =  stream.limit(SIZE +1).collect(Collectors.toList());
        System.out.print(title + ":");
        for (int i = 0; i < firstElements.size(); i++) {
            if(i>0){
                System.out.println(",");
            }
            if(i<SIZE){
                System.out.println("firstElements = " + firstElements.get(i));
            }
            else {
                System.out.println("...");
            }
        }
        System.out.println();
    }
    public static void main(String [] args) throws IOException {
        Path path = Paths.get("../");
        final String s = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        final Stream<String> split = Stream.of(s.split("\\PL+"));
        show("words",split);

        final Stream<String> gently = Stream.of("gently", "down", "the", "stream");
        show("song",gently);
        Stream<String> silence = Stream.empty();
        show("silence",silence);

        final Stream<String> generate = Stream.generate(() -> "Echo");
        show("echos",generate);

        final Stream<Double> generate1 = Stream.generate(Math::random);
        show("random",generate1);

        final Stream<BigInteger> iterate = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE));
        show("integers",iterate);

        final Stream<String> stringStream = Pattern.compile("\\PL+").splitAsStream(s);
        show("stringStream",stringStream);
        try(final Stream<String> lines = Files.lines(path,StandardCharsets.UTF_8)){
            show("lines",lines);
        }


        final Iterable<Path> rootDirectories = FileSystems.getDefault().getRootDirectories();
        final Stream<Path> stream = StreamSupport.stream(rootDirectories.spliterator(), false);
        show("rootDir",stream);

        final Iterator<Path> iterator = Paths.get("../").iterator();
        final Stream<Path> stream1 = StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false);

        show("pathComponts",stream1);

    }
}
