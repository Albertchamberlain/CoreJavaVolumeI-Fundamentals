import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * @author Amos
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        try(final ServerSocket serverSocket = new ServerSocket(8199))
        {
            try(Socket incoming = serverSocket.accept())
            {
                final InputStream inputStream = incoming.getInputStream();
                final OutputStream outputStream = incoming.getOutputStream();

                try(final Scanner scanner = new Scanner(inputStream, String.valueOf(StandardCharsets.UTF_8)))
                {
                    final PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)
                            , true);

                    printWriter.println("Hello ,Enter BYE to exit");
                    boolean done = false;
                    while (!done && scanner.hasNextLine())
                    {
                        String line = scanner.nextLine();
                        out.println("Echo:"+line);
                        if("BYE".equals(line.trim()))
                        {
                            done = true;
                        }
                    }
                }
            }
        }
    }
}
