package com.dannyns.shop.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Component
public class HibernateProperties {

    private static String HIBERNATE_DIALECT = "hibernate.dialect";
    private static String HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static String HIBERNATE_EJB_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
    private static String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static String HIBERNATE_FORMAT_SQL = "hibernate.format_sql";

    @Value("${hibernate.dialect}")
    private String dialect;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;

    @Value("${hibernate.ejb.naming_strategy}")
    private String ejbNamingStrategy;

    @Value("${hibernate.show_sql}")
    private String showSql;

    @Value("${hibernate.format_sql}")
    private String formatSql;

    Properties properties;

    @PostConstruct
    public void postConstruct() {
        Properties properties = new Properties();
        properties.setProperty(HIBERNATE_DIALECT, getDialect());
        properties.setProperty(HIBERNATE_HBM2DDL_AUTO, getHbm2ddlAuto());
        properties.setProperty(HIBERNATE_EJB_NAMING_STRATEGY, getEjbNamingStrategy());
        properties.setProperty(HIBERNATE_SHOW_SQL, getShowSql());
        properties.setProperty(HIBERNATE_FORMAT_SQL, getFormatSql());
        this.properties = properties;
    }

    public String getDialect() {
        return dialect;
    }


    public String getHbm2ddlAuto() {
        return hbm2ddlAuto;
    }


    public String getEjbNamingStrategy() {
        return ejbNamingStrategy;
    }


    public String getShowSql() {
        return showSql;
    }


    public String getFormatSql() {
        return formatSql;
    }

    public Properties getAll() {
        return this.properties;
    }
}
