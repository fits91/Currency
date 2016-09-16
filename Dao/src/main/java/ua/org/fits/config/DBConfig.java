package ua.org.fits.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    @Primary
    public DataSource getProdactionDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "TDS")
    @ConfigurationProperties(prefix="test.spring.datasource")
    public DataSource getTestDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Autowired
    public JdbcTemplate getProdactionJdbcTemplate(DataSource masterDS) {
        return new JdbcTemplate(masterDS);
    }


    @Bean(name = "H2DS")
    public DataSource getTestH2DataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.H2) //.H2 or .DERBY
                .addScript("db/schema.sql")
                .addScript("db/data.sql")
                .build();
        return db;
    }

    @Bean(name = "testJDBC")
    @Autowired
    public JdbcTemplate getTestJdbcTemplate(@Qualifier("TDS") DataSource testDS) {
        return new JdbcTemplate(testDS);
    }

    @Bean(name = "testH2JDBC")
    @Autowired
    public JdbcTemplate getTestH2JdbcTemplate(@Qualifier("H2DS") DataSource testDS) {
        return new JdbcTemplate(testDS);
    }
}
