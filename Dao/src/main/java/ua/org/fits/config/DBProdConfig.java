package ua.org.fits.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by developer on 06.11.2016.
 */
@Configuration
@Profile("prod")
public class DBProdConfig {
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource getDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource masterDS) {
        return new JdbcTemplate(masterDS);
    }
}
