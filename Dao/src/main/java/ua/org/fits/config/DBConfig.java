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

    @Bean
    @Autowired
    public JdbcTemplate getProdactionJdbcTemplate(DataSource masterDS) {
        return new JdbcTemplate(masterDS);
    }


    @Bean(name = "H2DS")
    @ConfigurationProperties(prefix="spring.h2.datasource")
    public DataSource getTest2DataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.H2) //.H2 or .DERBY
                .addScript("db/schema.sql")
                .addScript("db/data.s`ql")
                .build();
        return db;
    }

    @Bean(name = "testJDBC")
    @Autowired
    public JdbcTemplate getTestJdbcTemplate(@Qualifier("H2DS") DataSource testDS) {
        return new JdbcTemplate(testDS);
    }
}
