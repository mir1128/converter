package com.looobo.converter.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TableConfigureParser {
    public Map<String, Object> configures;

    public TableConfigureParser(Map<String, Object> configures) {
        this.configures = configures;
    }

    List<String> getTableDefinition(String tableName){
        if (configures.containsKey(tableName)){
            return Arrays.asList(((String)configures.get(tableName)).split(","));
        }
        return null;
    }
}
