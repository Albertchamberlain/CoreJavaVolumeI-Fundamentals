import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Amos
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        if(args.length>0)
        {
            String host = args[0];
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for(InetAddress ad:addresses)
            {
                System.out.println("ad = " + ad);
            }
        }
        else
        {
            InetAddress localhostAddress = InetAddress.getLocalHost();
            System.out.println("localhostAddress = " + localhostAddress);
        }
    }
}
