package com.looobo;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {

            ClassLoader classLoader = Main.class.getClassLoader();
            properties.load(classLoader.getResourceAsStream("table_definition.properties"));
            String res = (String) properties.get("temp_support_applying");
            System.out.println(res);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
