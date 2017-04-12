package com.dannyns.shop;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import java.io.File;

public class EmbeddedTomcatEx {

    public static void main(String[] args) throws LifecycleException, InterruptedException, ServletException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.addWebapp("", new File("").getAbsolutePath());
        tomcat.start();
        tomcat.getServer().await();
    }

}
