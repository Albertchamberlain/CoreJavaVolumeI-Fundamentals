import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static java.lang.System.out;

public class ThreadedEchoServer {
    public static void main(String[] args) {
        try(final ServerSocket serverSocket = new ServerSocket(8189))
        {
            int i = 1;
            while (true)
            {
                Socket incoming = serverSocket.accept();
                out.println("i = " + i);
                Runnable r = new ThreadEchoHandler(incoming);
                final Thread thread = new Thread(r);
                thread.start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class ThreadEchoHandler implements Runnable
{
    private Socket incoming;

    public ThreadEchoHandler(Socket sincoming) {
        this.incoming = sincoming;
    }
    @Override
    public void run()
    {
        try(final InputStream inputStream = incoming.getInputStream();
            final OutputStream outputStream = incoming.getOutputStream();
            final Scanner scanner = new Scanner(inputStream, String.valueOf(StandardCharsets.UTF_8));
            PrintWriter out =  new PrintWriter(new OutputStreamWriter(outputStream,StandardCharsets.UTF_8),true /*autoFlush*/))
        {
            out.println("Hello Enter BYE to exit");
            boolean done  = false;
            while (!done && scanner.hasNextLine() )
            {
                final String s = scanner.nextLine();
                out.println("Echo:"+s);
                if("BYE".equals(s.trim()))
                {
                    done = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
