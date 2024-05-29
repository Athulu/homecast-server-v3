package homecast.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ServerInfo {
    private static final Logger LOG = LoggerFactory.getLogger(ServerInfo.class);

    public static String getHostAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            LOG.error("Cannot get host address" + e.getMessage());
            return null;
        }
    }

    public static String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            LOG.error("Cannot get host name" + e.getMessage());
            return null;
        }
    }
}
