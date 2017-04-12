package com.dannyns.shop.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Component
public class DataSourceProperties {

    private static String DB_DRIVER = "db.driver";
    private static String DB_URL = "db.url";
    private static String DB_USERNAME = "db.username";
    private static String DB_PASSWORD = "db.password";

    @Value("${db.driver}")
    private String driver;

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    Properties properties;

    @PostConstruct
    public void postConstruct() {
        Properties properties = new Properties();
        properties.setProperty(DB_DRIVER, getDriver());
        properties.setProperty(DB_URL, getUrl());
        properties.setProperty(DB_USERNAME, getUsername());
        properties.setProperty(DB_PASSWORD, getPassword());
        this.properties = properties;
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Properties getAll() {
        return this.properties;
    }
}
