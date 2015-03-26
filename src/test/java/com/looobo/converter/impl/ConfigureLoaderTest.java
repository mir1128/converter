package com.looobo.converter.impl;

import com.looobo.converter.ConfigureLoaderInterface;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class ConfigureLoaderTest {

    @Test
    public void testGetDefinition() throws Exception {
        ConfigureLoaderInterface loaderInterface = new ConfigureLoader("test_table_definition.properties");

        Map<String, Object> definition = loaderInterface.getConfigure(this.getClass().getClassLoader());

        assertEquals(definition.get("temp_support_applying"), "a,b,c,d");
    }
}