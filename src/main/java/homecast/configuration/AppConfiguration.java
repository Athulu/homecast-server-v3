package homecast.configuration;

import homecast.configuration.settings.PostgresNotifyListener;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public CommandLineRunner run(PostgresNotifyListener postgresNotifyListener) {
        return args -> {
            postgresNotifyListener.listenForChanges();
        };
    }
}
