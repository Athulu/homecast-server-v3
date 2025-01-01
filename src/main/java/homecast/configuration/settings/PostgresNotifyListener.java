package homecast.configuration.settings;

import com.fasterxml.jackson.databind.ObjectMapper;
import homecast.api.services.SettingService;
import homecast.configuration.settings.model.SettingChangeNotifyModel;
import lombok.AllArgsConstructor;
import org.postgresql.PGConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component
@AllArgsConstructor
public class PostgresNotifyListener {

    private static final Logger LOG = LoggerFactory.getLogger(PostgresNotifyListener.class);
    private final JdbcTemplate jdbcTemplate;
    private final SettingService settingService;

    public void listenForChanges() {
        new Thread(() -> {
            Connection connection = null;
            Statement stmt = null;
            PGConnection pgConnection;

            try {
                connection = jdbcTemplate.getDataSource().getConnection().unwrap(Connection.class);
                connection.setAutoCommit(true);
                stmt = connection.createStatement();

                stmt.execute("LISTEN settings_changes_channel;");
                pgConnection = (PGConnection) connection;

                while (true) {
                    var notifications = pgConnection.getNotifications();
                    if (notifications != null) {
                        for (var notification : notifications) {
                            String json = notification.getParameter();
                            LOG.info("Received notification JSON: " + json);
                            ObjectMapper objectMapper = new ObjectMapper();
                            try {
                                SettingChangeNotifyModel model = objectMapper.readValue(json, SettingChangeNotifyModel.class);
                                LOG.info(model.getOperation() + " setting: " + model);

                                settingService.initializeSetting(model.getProperty(), model.getValue());
                            } catch (Exception e) {
                                LOG.error("Error parsing JSON notification: ", e);
                            }
                        }
                    }
                    Thread.sleep(1000);
                }
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (stmt != null) stmt.close();
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
