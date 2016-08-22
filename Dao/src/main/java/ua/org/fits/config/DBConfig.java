package ua.org.fits.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource getProdactionDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Autowired
    public JdbcTemplate getProdactionJdbcTemplate(DataSource masterDS) {
        return new JdbcTemplate(masterDS);
    }
}
