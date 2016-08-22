package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by developer on 24.07.2016.
 */
//@Configuration
public class ConfigDataSource {
    @Bean
    @Primary
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "test")
    @ConfigurationProperties(prefix="spring.datasource.prod")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "jdbcSecondary")
    @Autowired
    public JdbcTemplate masterJdbcTemplate(@Qualifier("test") DataSource dsMaster) {
        return new JdbcTemplate(dsMaster);
    }
}
