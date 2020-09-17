import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Amos
 */
public class SocketTest {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("time-a.nist.gov",13);
            Scanner scanner = new Scanner(socket.getInputStream(), String.valueOf(StandardCharsets.UTF_8)))
        {
            while (scanner.hasNext())
            {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }
        }
}
