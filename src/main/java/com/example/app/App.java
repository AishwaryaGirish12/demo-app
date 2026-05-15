package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        String name = "DevOps Student";
        if (StringUtils.isNotBlank(name)) {
            String message = greet(name);
            logger.info(message);
            System.out.println(message);
        } else {
            logger.error("Name is blank or empty!");
        }
    }

    public static String greet(String name) {
        return "Hello, " + name + "! DevOps Pipeline is Running Successfully.";
    }

    public static String getVersion() {
        return "v1.0";
    }
}
