package ua.org.fits.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@Profile("dev")
public class DBDevConfig {
    @Bean(name = "H2DS")
    public DataSource getTest2DataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.H2) //.H2 or .DERBY
                .addScript("db/schema.sql")
                .addScript("db/data.sql")
                .build();
        return db;
    }

    @Bean(name = "testJDBC")
    public JdbcTemplate getTestJdbcTemplate(@Qualifier("H2DS") DataSource testDS) {
        return new JdbcTemplate(testDS);
    }
}
