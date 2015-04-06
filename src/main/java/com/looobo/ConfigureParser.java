package com.looobo;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.*;

public class ConfigureParser {
    private Properties properties = new Properties();
    private String tableKey;
    private String sheets;
    private String propertiesPath = null;

    private static Logger logger = Logger.getLogger(ConfigureParser.class);


    public ConfigureParser(String tableKey, String propertiesPath) {
        this.tableKey = tableKey;
        this.propertiesPath = propertiesPath;
        if (this.propertiesPath == null) {
            this.propertiesPath = "table_definition.properties";
        }
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream(this.propertiesPath));
            sheets = properties.getProperty(tableKey + ".sheets");
        } catch (IOException e) {
            logger.error(e.fillInStackTrace());
        }
    }

    public List<List<String>> getColumns() {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < getSheets(); ++i) {
            try {
                result.add(Arrays.asList(properties.getProperty(tableKey + "." + i + ".definition").split(",")));
            } catch (NullPointerException e) {
                result.add(Arrays.asList(""));
                logger.info(tableKey + "." + i + ".definition" + "does not exist");
            }

        }
        return result;
    }

    public List<Map.Entry<Integer, Integer>> getRowRange() {
        List<Map.Entry<Integer, Integer>> result = new ArrayList<>();
        for (int i = 0; i < getSheets(); ++i) {
            try {
                List<String> strings = Arrays.asList(properties.getProperty(tableKey + "." + i + ".row.range").split(","));
                result.add(new AbstractMap.SimpleEntry<>(Integer.valueOf(strings.get(0)) - 1,
                        Integer.valueOf(strings.get(1)) - 1));
            } catch (NullPointerException e) {
                result.add(new AbstractMap.SimpleEntry<>(0, 0));
                logger.info(tableKey + "." + i + ".row.range" + "does not exist.");
            }

        }

        return result;
    }

    public List<Map.Entry<Integer, Integer>> getColumnRange() {
        List<Map.Entry<Integer, Integer>> result = new ArrayList<>();
        for (int i = 0; i < getSheets(); ++i) {
            try {
                List<String> strings = Arrays.asList(properties.getProperty(tableKey + "." + i + ".column.range").split(","));
                result.add(new AbstractMap.SimpleEntry<>(Integer.valueOf(strings.get(0)) - 1,
                        Integer.valueOf(strings.get(1)) - 1));
            } catch (NullPointerException e) {
                result.add(new AbstractMap.SimpleEntry<>(0, 0));
                logger.info(tableKey + "." + i + ".column.range" + "does not exist.");
            }
        }
        return result;
    }

    public int getSheets() {
        return Integer.parseInt(sheets);
    }
}
