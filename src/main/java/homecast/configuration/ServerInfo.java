package homecast.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class ServerInfo {
    private static final Logger LOG = LoggerFactory.getLogger(ServerInfo.class);
    private static final String PROTOCOL = "http";
    @Autowired
    private ServletWebServerApplicationContext webServerAppCtxt;

    public String getServerUrl() {
        return PROTOCOL + "://" + getHostAddress() + ":" + webServerAppCtxt.getWebServer().getPort();
    }

    private String getHostAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            LOG.error("Cannot get host address" + e.getMessage());
            return null;
        }
    }

    public String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            LOG.error("Cannot get host name" + e.getMessage());
            return null;
        }
    }
}
