package com.azimolabs.camunda.config.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;
import ru.yandex.qatools.embed.postgresql.distribution.Version;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class EmbeddedPostgreSQLConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmbeddedPostgreSQLConfiguration.class);

    private static final int PORT = 5432;
    private static final String SCHEMA = "camunda";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    @Bean(destroyMethod = "stop")
    public EmbeddedPostgres embeddedPostgres() throws IOException, InterruptedException {
        EmbeddedPostgres postgres = new EmbeddedPostgres(Version.V9_6_5);
        postgres.start("localhost", PORT, SCHEMA, USERNAME, PASSWORD);
        return postgres;
    }

    @Bean
    //'EmbeddedPostgres' property is injected only to initialize embedded Postgres
    public DataSource dataSource(EmbeddedPostgres postgres) {
        LOGGER.info("Configuring test datasource");
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("org.postgresql.Driver");
        hikariConfig.setUsername(USERNAME);
        hikariConfig.setPassword(PASSWORD);
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:" + PORT + "/" + SCHEMA);
        return new HikariDataSource(hikariConfig);
    }

}
