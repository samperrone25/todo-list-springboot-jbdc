package com.webjdbc.webjdbc;

import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WebjdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebjdbcApplication.class, args);
	}

	@Bean
    public Connection getConnection() throws SQLException {
		Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");
        String url = "jdbc:postgresql://localhost:5432/jdbcDatabase";
        Connection conn = DriverManager.getConnection(url, props); // throws SQLException
        return conn;
	}
}

