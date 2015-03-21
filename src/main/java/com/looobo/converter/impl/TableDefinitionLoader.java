package com.looobo.converter.impl;

import com.google.common.collect.Maps;
import com.looobo.converter.DefinitionLoaderInterface;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class TableDefinitionLoader implements DefinitionLoaderInterface {
    private static Logger logger = Logger.getLogger(TableDefinitionLoader.class);

    private String definitionFileName = "";

    public TableDefinitionLoader(String definitionFileName) {
        this.definitionFileName = definitionFileName;
    }

    public String getDefinitionFileName() {
        return definitionFileName;
    }

    @Override
    public Map<String, Object> getDefinition(ClassLoader loader) {
        Properties properties = new Properties();

        try {
            properties.load(loader.getResourceAsStream(getDefinitionFileName()));
        } catch (IOException e) {
            logger.error("can not find table_definition.properties");
            return Maps.newHashMap();
        }
        return Maps.newHashMap((Map) properties);
    }
}
