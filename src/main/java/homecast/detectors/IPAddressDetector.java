package homecast.detectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Pattern;
public class IPAddressDetector {
    private static final Logger LOG = LoggerFactory.getLogger(IPAddressDetector.class);

    private static String getAddressIP() throws Exception {
        Enumeration e = NetworkInterface.getNetworkInterfaces();
        while (e.hasMoreElements()) {
            NetworkInterface n = (NetworkInterface) e.nextElement();
            Enumeration ee = n.getInetAddresses();
            while (ee.hasMoreElements()) {
                InetAddress i = (InetAddress) ee.nextElement();
                String ipAddress = i.getHostAddress();
                if (isPrivateClassCIPAddress(ipAddress)) {
                    ipAddress = "http://" + ipAddress + ":8080";
                    LOG.info("Address IP set to: " + ipAddress);
                    return ipAddress;
                }
            }
        }
        return null;
    }

    public static boolean isPrivateClassCIPAddress(String ipAddress) {
        String regex = "^192\\.168\\.[0-9]{1,3}\\.[0-9]{1,3}$";
        return Pattern.compile(regex).matcher(ipAddress).matches();
    }
}
