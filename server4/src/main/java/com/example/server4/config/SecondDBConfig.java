package com.example.server4.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.r2dbc.core.DefaultReactiveDataAccessStrategy;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.dialect.MySqlDialect;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.transaction.ReactiveTransactionManager;

@Configuration
@EnableR2dbcRepositories(
        basePackages = "com.example.server4.seconddb.repository",
        entityOperationsRef="secondEntityOperations"
)
public class SecondDBConfig {
    @Bean
    @Qualifier("second")
    public ConnectionFactory secondConnectionFactory(){
        return ConnectionFactories.get(ConnectionFactoryOptions.parse("r2dbc:mysql://localhost:3306/test2?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true")
                .mutate()
                .option(ConnectionFactoryOptions.USER, "root")
                .option(ConnectionFactoryOptions.PASSWORD, "1234")
                .build());
    }

    @Bean
    public R2dbcEntityOperations secondEntityOperations(@Qualifier("second") ConnectionFactory connectionFactory){
        DefaultReactiveDataAccessStrategy strategy = new DefaultReactiveDataAccessStrategy(MySqlDialect.INSTANCE);
        DatabaseClient databaseClient = DatabaseClient.builder().connectionFactory(connectionFactory).build();
        return new R2dbcEntityTemplate(databaseClient, strategy);
    }

    @Bean
    public ReactiveTransactionManager secondTransactionManager(@Qualifier("second") ConnectionFactory connectionFactory){
        return new R2dbcTransactionManager(connectionFactory);
    }
}
