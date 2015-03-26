package com.looobo.converter.impl;

import com.google.common.collect.Maps;
import com.looobo.converter.ConfigureLoaderInterface;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class ConfigureLoader implements ConfigureLoaderInterface {
    private static Logger logger = Logger.getLogger(ConfigureLoader.class);

    private String definitionFileName = "";

    public ConfigureLoader(String definitionFileName) {
        this.definitionFileName = definitionFileName;
    }

    public String getDefinitionFileName() {
        return definitionFileName;
    }

    @Override
    public Map<String, Object> getConfigure(ClassLoader loader) {
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

