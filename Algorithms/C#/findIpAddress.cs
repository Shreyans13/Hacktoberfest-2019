import  java.net.UnknownHostException;
import  java.net.InetAddress;
import  java.net.NetworkInterface;
public class Mac_Address {
    public static void main(String[] args)
            throws UnknownHostException{
        InetAddress ip;
        InetAddress addr = InetAddress.getLocalHost();
        try {
            String hostname = addr.getHostName();
            System.out.println("Host Name : "+hostname);

            ip = InetAddress.getLocalHost();
            System.out.println("Current IP address : " + ip.getHostAddress());

            NetworkInterface network = NetworkInterface.getByInetAddress(ip);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
